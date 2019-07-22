package sakura.com.lejinggou.Activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.fangx.haorefresh.LoadMoreListener;
import sakura.com.lejinggou.Adapter.MaiChangListAdapter;
import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.McJieShuBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.DateUtils;
import sakura.com.lejinggou.Utils.EZToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.View.ProgressView;
import sakura.com.lejinggou.View.WenguoyiRecycleView;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

/**
 * sakura.com.lejinggou.Activity
 *
 * @author 赵磊
 * @date 2018/12/28
 * 功能描述：
 */
public class MaiChangJieShuActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.tv_Title)
    TextView tvTitle;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.SimpleDraweeView_user)
    SimpleDraweeView SimpleDraweeViewUser;
    @BindView(R.id.tv_user)
    TextView tvUser;
    @BindView(R.id.tv_user_money)
    TextView tvUserMoney;
    @BindView(R.id.ll_JPJG)
    LinearLayout llJPJG;
    @BindView(R.id.rv_maichanglist)
    WenguoyiRecycleView rvMaichanglist;
    private LinearLayoutManager line;
    private String endM;
    private Dialog dialog;
    private MaiChangListAdapter adapter;

    @Override
    protected int setthislayout() {
        return R.layout.activity_maichang_jieshu_layout;
    }

    @Override
    protected void initview() {
        line = new LinearLayoutManager(context);
        line.setOrientation(LinearLayoutManager.VERTICAL);
        rvMaichanglist.setLayoutManager(line);
        rvMaichanglist.setItemAnimator(new DefaultItemAnimator());
        ProgressView progressView = new ProgressView(context);
        progressView.setIndicatorId(ProgressView.BallRotate);
        progressView.setIndicatorColor(getResources().getColor(R.color.colorAccent));
        rvMaichanglist.setFootLoadingView(progressView);
        rvMaichanglist.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {
                dialog.show();
                getMcListEnd(endM);
            }
        });
        TextView textView = new TextView(context);
        textView.setText("-暂无更多-");
        rvMaichanglist.setFootEndView(textView);

        String title = getIntent().getStringExtra("title");
        tvTitle.setText(title);

    }

    @Override
    protected void initListener() {
        rlBack.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        if (Utils.isConnected(context)) {
            if (dialog == null) {
                dialog = Utils.showLoadingDialog(context);
            }
            dialog.show();
            getMcList();
        } else {
            EZToast.showShort(context, R.string.Networkexception);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            default:
                break;
        }
    }

    private void getMcListEnd(final String m) {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("m", m);
        params.put("type", "1");
        params.put("id", String.valueOf(getIntent().getStringExtra("id")));
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        Log.e("NewsListFragment", "params:" + params);
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "goods/mc", "goods/mc", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = result;
                try {
                    dialog.dismiss();
                    Log.e("NewsListFragment", decode);
                    final McJieShuBean mcBean = new Gson().fromJson(decode, McJieShuBean.class);
                    if (1 == mcBean.getStatus()) {
                        if (null != mcBean.getData().getList() && !mcBean.getData().getList().isEmpty()) {
                            endM = mcBean.getData().getTop();
                            adapter.setDatas((ArrayList) mcBean.getData().getList());
                            rvMaichanglist.loadMoreComplete();
                        } else {
                            rvMaichanglist.loadMoreEnd();
                        }
                    }
                    decode = null;
                } catch (Exception e) {
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


    private void getMcList() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("m", "");
        params.put("type", "1");
        params.put("id", String.valueOf(getIntent().getStringExtra("id")));
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        Log.e("NewsListFragment", "params:" + params);
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "goods/mc", "goods/mc", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                try {
                    dialog.dismiss();
                    Log.e("NewsListFragment", result);
                    final McJieShuBean mcBean = new Gson().fromJson(result, McJieShuBean.class);
                    if (1 == mcBean.getStatus()) {
                        rvMaichanglist.loadMoreComplete();
                        endM = mcBean.getData().getTop();
                        tvTime.setText("已结束：" + DateUtils.getMillon(Long.parseLong(mcBean.getData().getEndtime()) * 1000));

                        if (mcBean.getData().getUheadimg().startsWith("http")) {
                            SimpleDraweeViewUser.setImageURI(mcBean.getData().getUheadimg());
                        } else {
                            SimpleDraweeViewUser.setImageURI(UrlUtils.URL + mcBean.getData().getUheadimg());
                        }
                        tvUser.setText(mcBean.getData().getUname());
                        tvUserMoney.setText("￥" + mcBean.getData().getPrice());
                        if (null != mcBean.getData().getList() && !mcBean.getData().getList().isEmpty()) {
                            adapter = new MaiChangListAdapter(mcBean.getData().getList(), context);
                            rvMaichanglist.setAdapter(adapter);
                        }
                    }
                    result = null;
                } catch (Exception e) {
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
    protected void onDestroy() {
        App.getQueues().cancelAll("goods/mc");
        super.onDestroy();
    }
}
