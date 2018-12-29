package sakura.com.lejinggou.Activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.fangx.haorefresh.LoadMoreListener;
import sakura.com.lejinggou.Adapter.MaiChangReGouListAdapter;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.McReGouBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EasyToast;
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
public class MaiChangReGouActivity extends BaseActivity implements View.OnClickListener {

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
    @BindView(R.id.rv_maichanglist)
    WenguoyiRecycleView rvMaichanglist;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.LL_empty)
    RelativeLayout LLEmpty;
    @BindView(R.id.tv_DJ)
    TextView tvDJ;
    @BindView(R.id.tv_BZJ)
    TextView tvBZJ;
    @BindView(R.id.ll_dijia)
    LinearLayout llDijia;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    private LinearLayoutManager line;
    private Dialog dialog;
    private MaiChangReGouListAdapter adapter;
    private String endM;
    private String topM;


    @Override
    protected int setthislayout() {
        return R.layout.activity_maichang_regou_layout;
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
            EasyToast.showShort(context, R.string.Networkexception);

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
                    final McReGouBean mcBean = new Gson().fromJson(decode, McReGouBean.class);
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
                String decode = result;
                try {
                    dialog.dismiss();
                    Log.e("NewsListFragment", decode.toString());
                    final McReGouBean mcBean = new Gson().fromJson(decode, McReGouBean.class);

                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mcBean.getData().setS(mcBean.getData().getS() - 1);
                            tvTime.setText("距结束:" + getTimeFromInt(mcBean.getData().getS()));
                            tvTime.setBackgroundColor(context.getResources().getColor(R.color.time));
                            mHandler.postDelayed(this, 1000);
                        }
                    });

                    if (1 == mcBean.getStatus()) {

                        endM = mcBean.getData().getTop();
                        topM = mcBean.getData().getEnd();

                        LLEmpty.setVisibility(View.GONE);
                        if (!TextUtils.isEmpty(mcBean.getData().getUname())) {
                            SimpleDraweeViewUser.setImageURI(UrlUtils.URL + mcBean.getData().getUheadimg());
                            tvUser.setText(mcBean.getData().getUname());
                            tvUserMoney.setText("￥" + mcBean.getData().getPrice());
                            adapter = new MaiChangReGouListAdapter(mcBean.getData().getList(), context);
                            rvMaichanglist.setAdapter(adapter);
                            llDijia.setVisibility(View.GONE);
                        } else {
                            tvDJ.setText("￥" + mcBean.getData().getDj());
                            tvBZJ.setText("￥" + mcBean.getData().getBzj());
                            llDijia.setVisibility(View.VISIBLE);
                        }
                    } else {
                        rvMaichanglist.setCanloadMore(false);
                        rvMaichanglist.loadMoreEnd();
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

    public String getTimeFromInt(long time) {

        if (time <= 0) {
            return "已结束";
        }

        long day = time / (1 * 60 * 60 * 24);
        long hour = time / (1 * 60 * 60) % 24;
        long minute = time / (1 * 60) % 60;
        long second = time / (1) % 60;

        if (day == 0) {
            return hour + "小时" + minute + "分" + second + "秒";
        } else if (hour == 0) {
            return minute + "分" + second + "秒";
        } else if (minute == 0) {
            return second + "秒";
        } else if (second == 0) {
            return "已结束";
        } else if (day != 0) {
            return day + "天" + hour + "小时" + minute + "分" + second + "秒";
        } else {
            return "已结束";
        }

    }


}
