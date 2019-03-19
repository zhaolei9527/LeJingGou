package sakura.com.lejinggou.Activity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.McYGBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EZToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

/**
 * sakura.com.lejinggou.Activity
 *
 * @author 赵磊
 * @date 2018/12/28
 * 功能描述：
 */
public class MaiChangYuGouActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.tv_Title)
    TextView tvTitle;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_DJ)
    TextView tvDJ;
    @BindView(R.id.tv_BZJ)
    TextView tvBZJ;
    @BindView(R.id.ll_JPJG)
    LinearLayout llJPJG;
    private Dialog dialog;

    @Override
    protected int setthislayout() {
        return R.layout.activity_maichang_yugou_layout;
    }

    @Override
    protected void initview() {
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

    private void getMcList() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("m", "");
        params.put("type", "2");
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
                    final McYGBean mcYGBean = new Gson().fromJson(result, McYGBean.class);
                    if (1 == mcYGBean.getStatus()) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (Long.parseLong(mcYGBean.getData().getStarttime()) == 0) {
                                    //TODO  进入卖场热购页面
                                } else {

                                    mcYGBean.getData().setS(mcYGBean.getData().getS() - 1);
                                    tvTime.setText("距开始： " + getTimeFromInt((mcYGBean.getData().getS())));

                                }
                                mHandler.postDelayed(this, 1000);
                            }
                        });

                        tvBZJ.setText("￥" + mcYGBean.getData().getBzj());
                        tvDJ.setText("￥" + mcYGBean.getData().getDj());

                    } else {
                        EZToast.showShort(context, mcYGBean.getInfo());
                    }
                    decode = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
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


            @Override
            public void onMyError(VolleyError error) {
                dialog.dismiss();
                error.printStackTrace();
            }
        });
    }


}
