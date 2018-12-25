package sakura.com.lejinggou.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.VolleyError;

import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.fangx.haorefresh.LoadMoreListener;
import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseLazyFragment;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EasyToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.View.ProgressView;
import sakura.com.lejinggou.View.SakuraLinearLayoutManager;
import sakura.com.lejinggou.View.WenguoyiRecycleView;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

/**
 * com.wenguoyi.Fragment
 *
 * @author 赵磊
 * @date 2018/5/15
 * 功能描述：
 */
public class HomeFragment extends BaseLazyFragment {
    Unbinder unbinder;
    private Context context;
    private WenguoyiRecycleView rv_homelist;
    private SakuraLinearLayoutManager line;
    private int page = 1;
    private Dialog dialog;

    @Override
    protected void initPrepare() {

    }

    @Override
    protected void onInvisible() {

    }

    @Override
    protected void initData() {
        if (Utils.isConnected(context)) {
            dialog = Utils.showLoadingDialog(getActivity());
            dialog.show();
            getData();
        } else {
            EasyToast.showShort(context, getResources().getString(R.string.Networkexception));
        }
    }

    @Override
    protected View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.home_fragment_layout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rv_homelist = (WenguoyiRecycleView) view.findViewById(R.id.rv_homelist);
        line = new SakuraLinearLayoutManager(context);
        line.setOrientation(LinearLayoutManager.VERTICAL);
        rv_homelist.setLayoutManager(line);
        rv_homelist.setItemAnimator(new DefaultItemAnimator());
        ProgressView progressView = new ProgressView(context);
        progressView.setIndicatorId(ProgressView.BallRotate);
        progressView.setIndicatorColor(getResources().getColor(R.color.colorAccent));
        rv_homelist.setFootLoadingView(progressView);
        rv_homelist.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {
                page = page + 1;
                getData();
            }
        });
        TextView textView = new TextView(context);
        textView.setText(mContext.getString(R.string.notmore));
        rv_homelist.setFootEndView(textView);

    }

    //数据获取
    public void getData() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "0")));
        params.put("page", String.valueOf(page));
        Log.e("HomeFragment", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "index/index" + App.LanguageTYPEHTTP, "index/index", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("HomeFragment", result);
                try {
                    dialog.dismiss();
                    result = null;
                } catch (Exception e) {
                    dialog.dismiss();
                    if (rv_homelist != null) {
                        rv_homelist.loadMoreComplete();
                        rv_homelist.loadMoreEnd();
                        rv_homelist.setCanloadMore(false);
                    }
                    e.printStackTrace();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                dialog.dismiss();
                error.printStackTrace();
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        App.getQueues().cancelAll("index/index");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
