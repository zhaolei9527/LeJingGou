package sakura.com.lejinggou.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.fangx.haorefresh.LoadMoreListener;
import sakura.com.lejinggou.Adapter.ZuoRiLiShiListAdapter;
import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseLazyFragment;
import sakura.com.lejinggou.Bean.IndexGoodsBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EasyToast;
import sakura.com.lejinggou.Utils.PriorityRunnable;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.View.ProgressView;
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
public class ZuoRiLiShiFragment extends BaseLazyFragment implements View.OnClickListener {
    Unbinder unbinder;
    WenguoyiRecycleView rvHomelist;
    @BindView(R.id.LL_empty)
    RelativeLayout LLEmpty;
    private Context context;
    private GridLayoutManager line;
    private int page = 1;
    private Dialog dialog;
    private ZuoRiLiShiListAdapter adapter;
    private String type = "4";

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
        View view = inflater.inflate(R.layout.zuori_fragment_layout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        rvHomelist = view.findViewById(R.id.rv_homelist);
        LLEmpty = view.findViewById(R.id.LL_empty);
        line = new GridLayoutManager(context, 2);
        line.setOrientation(LinearLayoutManager.VERTICAL);
        rvHomelist.setLayoutManager(line);
        rvHomelist.setItemAnimator(new DefaultItemAnimator());
        ProgressView progressView = new ProgressView(context);
        progressView.setIndicatorId(ProgressView.BallRotate);
        progressView.setIndicatorColor(getResources().getColor(R.color.colorAccent));
        rvHomelist.setFootLoadingView(progressView);
        rvHomelist.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {
                page = page + 1;
                App.pausableThreadPoolExecutor.execute(new PriorityRunnable(1) {
                    @Override
                    public void doSth() {
                        getData();
                    }
                });
            }
        });
        TextView textView = new TextView(context);
        textView.setText(context.getString(R.string.notmore));
        rvHomelist.setFootEndView(textView);

    }

    //数据获取
    public void getData() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("type", type);
        params.put("p", String.valueOf(page));
        Log.e("HomeFragment", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "index/goods" + App.LanguageTYPEHTTP, "index/goods", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("HomeFragment", result);
                try {
                    dialog.dismiss();
                    rvHomelist.loadMoreComplete();
                    IndexGoodsBean indexGoodsBean = new Gson().fromJson(result, IndexGoodsBean.class);
                    if (indexGoodsBean.getStatus() == 0) {
                        if (page == 1) {
                            LLEmpty.setVisibility(View.VISIBLE);
                            rvHomelist.setVisibility(View.GONE);
                            rvHomelist.loadMoreEnd();
                        }
                    } else {
                        LLEmpty.setVisibility(View.GONE);
                        rvHomelist.setVisibility(View.VISIBLE);
                    }

                    if (null != indexGoodsBean.getData() && !indexGoodsBean.getData().isEmpty()) {
                        adapter = new ZuoRiLiShiListAdapter(mContext, indexGoodsBean.getData());
                        rvHomelist.setAdapter(adapter);
                    } else {
                        if (page == 1) {
                            LLEmpty.setVisibility(View.VISIBLE);
                            rvHomelist.setVisibility(View.GONE);
                            rvHomelist.loadMoreEnd();
                        }
                    }
                    indexGoodsBean = null;
                    result = null;
                } catch (Exception e) {
                    dialog.dismiss();
                    if (rvHomelist != null) {
                        rvHomelist.loadMoreEnd();
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
        App.getQueues().cancelAll("index/goods");
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            default:
                break;
        }
    }
}
