package sakura.com.lejinggou.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.jude.rollviewpager.hintview.IconHintView;
import com.tencent.smtt.sdk.WebView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Adapter.GoodLoopAdapter;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.GoodsIndexBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.DateUtils;
import sakura.com.lejinggou.Utils.DensityUtils;
import sakura.com.lejinggou.Utils.EasyToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

public class PriceDetailsActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.RollPagerView)
    com.jude.rollviewpager.RollPagerView RollPagerView;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_GYS)
    TextView tvGYS;
    @BindView(R.id.tv_DQJ_money)
    TextView tvDQJMoney;
    @BindView(R.id.tv_DQJ)
    TextView tvDQJ;
    @BindView(R.id.tv_JJ_money)
    TextView tvJJMoney;
    @BindView(R.id.tv_JJ)
    TextView tvJJ;
    @BindView(R.id.tv_BZJ_money)
    TextView tvBZJMoney;
    @BindView(R.id.tv_BZJ)
    TextView tvBZJ;
    @BindView(R.id.tv_GYS2)
    TextView tvGYS2;
    @BindView(R.id.tv_Start_time)
    TextView tvStartTime;
    @BindView(R.id.tv_End_time)
    TextView tvEndTime;
    @BindView(R.id.tv_FD_money)
    TextView tvFDMoney;
    @BindView(R.id.tv_CKJ_money)
    TextView tvCKJMoney;
    @BindView(R.id.ll_CJJL)
    LinearLayout llCJJL;
    @BindView(R.id.ll_JGGZ)
    LinearLayout llJGGZ;
    @BindView(R.id.wb)
    WebView wb;
    @BindView(R.id.shopnow)
    TextView shopnow;
    private Dialog dialog;
    private String uid;
    private String id;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }

    @Override
    protected int setthislayout() {
        return R.layout.activity_price_details;
    }

    @Override
    protected void initview() {
        uid = (String) SpUtil.get(context, "uid", "");
        RollPagerView.setHintView(new IconHintView(context, R.drawable.shape_selected, R.drawable.shape_noraml, DensityUtils.dp2px(context, getResources().getDimension(R.dimen.x7))));
        RollPagerView.setPlayDelay(30000);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

        if (Utils.isConnected(context)) {
            dialog = Utils.showLoadingDialog(context);
            dialog.show();
            goodsDetail();
        } else {
            EasyToast.showShort(context, R.string.Networkexception);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shopnow:
                if (TextUtils.isEmpty(uid)) {
                    EasyToast.showShort(context, "请先登录");
                    startActivity(new Intent(context, LoginActivity.class));
                    return;
                }
                break;
            case R.id.rl_back:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        uid = (String) SpUtil.get(context, "uid", "");
    }

    /**
     * 产品详情获取
     */
    private void goodsDetail() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("id", String.valueOf(getIntent().getStringExtra("id")));
        Log.e("PriceDetailsActivity", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "goods/index", "goods/index", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("PriceDetailsActivity", result);
                try {
                    dialog.dismiss();
                    final GoodsIndexBean goodsIndexBean = new Gson().fromJson(result, GoodsIndexBean.class);
                    if (1 == goodsIndexBean.getStatus()) {
                        RollPagerView.setAdapter(new GoodLoopAdapter(RollPagerView, goodsIndexBean.getData().getImgurl()));
                        wb.loadUrl(goodsIndexBean.getData().getUrl());
                        tvTitle.setText(goodsIndexBean.getData().getName());
                        tvGYS.setText("供应商："+goodsIndexBean.getData().getGys());
                        tvGYS2.setText(goodsIndexBean.getData().getGys());
                        tvDQJMoney.setText("￥" + goodsIndexBean.getData().getDqprice());
                        tvJJMoney.setText("￥" + goodsIndexBean.getData().getFd());
                        tvFDMoney.setText("￥" + goodsIndexBean.getData().getFdprice());
                        tvBZJMoney.setText("￥" + goodsIndexBean.getData().getBzj());
                        tvCKJMoney.setText("￥" + goodsIndexBean.getData().getCkprice());
                        tvStartTime.setText(DateUtils.getMillon(Long.parseLong(goodsIndexBean.getData().getStarttime()) * 1000));
                        tvEndTime.setText(DateUtils.getMillon(Long.parseLong(goodsIndexBean.getData().getEndtime()) * 1000));

                        new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                try {
                                    for (int i = 0; i < goodsIndexBean.getData().getS(); i++) {
                                        Thread.sleep(1000);

                                        while (true) {
                                            Thread.sleep(1000);
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    try {
                                                        goodsIndexBean.getData().setS(goodsIndexBean.getData().getS() - 1);
                                                        tvTime.setText("距开始:" + getTimeFromInt(goodsIndexBean.getData().getS()));
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            });
                                        }

                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();


                    } else {
                        EasyToast.showShort(context, goodsIndexBean.getInfo());
                        finish();
                    }
                    result = null;
                } catch (Exception e) {
                    dialog.dismiss();
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
        } else {
            return "已结束";
        }

    }

}

