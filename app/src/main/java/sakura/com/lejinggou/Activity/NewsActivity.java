package sakura.com.lejinggou.Activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Adapter.NewsTitleListAdapter;
import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.NewsIndexBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EasyToast;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.View.ProgressView;
import sakura.com.lejinggou.View.SakuraLinearLayoutManager;
import sakura.com.lejinggou.View.WenguoyiRecycleView;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

/**
 * com.wenguoyi.Activity
 *
 * @author 赵磊
 * @date 2018/6/12
 * 功能描述：
 */
public class NewsActivity extends BaseActivity {


    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.rv_newslist)
    WenguoyiRecycleView rvNewslist;
    @BindView(R.id.LL_empty)
    RelativeLayout LLEmpty;
    private Dialog dialog;

    @Override
    protected int setthislayout() {
        return R.layout.activity_news_layout;
    }

    @Override
    protected void initview() {
        SakuraLinearLayoutManager line = new SakuraLinearLayoutManager(context);
        line.setOrientation(LinearLayoutManager.VERTICAL);
        rvNewslist.setLayoutManager(line);
        rvNewslist.setItemAnimator(new DefaultItemAnimator());
        ProgressView progressView = new ProgressView(context);
        progressView.setIndicatorId(ProgressView.BallRotate);
        progressView.setIndicatorColor(getResources().getColor(R.color.colorAccent));
        rvNewslist.setFootLoadingView(progressView);
        TextView textView = new TextView(context);
        textView.setText(context.getString(R.string.notmore));
        rvNewslist.setFootEndView(textView);
    }

    @Override
    protected void initListener() {
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        if (Utils.isConnected(context)) {
            dialog = Utils.showLoadingDialog(context);
            dialog.show();
            getData();
        } else {
            EasyToast.showShort(context, getResources().getString(R.string.Networkexception));
        }
    }

    //数据获取
    public void getData() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("type", "1");
        Log.e("HomeFragment", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "news/index" + App.LanguageTYPEHTTP, "news/index", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("HomeFragment", result);
                try {
                    dialog.dismiss();
                    NewsIndexBean newsIndexBean = new Gson().fromJson(result, NewsIndexBean.class);
                    if (newsIndexBean.getStatus() == 0) {
                        LLEmpty.setVisibility(View.VISIBLE);
                        rvNewslist.setVisibility(View.GONE);
                    } else {
                        LLEmpty.setVisibility(View.GONE);
                        rvNewslist.setVisibility(View.VISIBLE);
                    }

                    NewsTitleListAdapter adapter = new NewsTitleListAdapter(context, newsIndexBean.getData());
                    rvNewslist.setAdapter(adapter);

                    newsIndexBean = null;
                    result = null;
                } catch (Exception e) {
                    dialog.dismiss();
                    if (rvNewslist != null) {
                        rvNewslist.loadMoreComplete();
                        rvNewslist.loadMoreEnd();
                        rvNewslist.setCanloadMore(false);
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
