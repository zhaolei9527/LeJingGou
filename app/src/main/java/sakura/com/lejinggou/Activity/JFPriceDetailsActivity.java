package sakura.com.lejinggou.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.jude.rollviewpager.hintview.IconHintView;
import com.tencent.smtt.sdk.WebView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Adapter.JfGoodLoopAdapter;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.UsergetgoodsbyidBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.DensityUtils;
import sakura.com.lejinggou.Utils.EZToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

public class JFPriceDetailsActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.RollPagerView)
    com.jude.rollviewpager.RollPagerView RollPagerView;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_GYS2)
    TextView tvGYS2;
    @BindView(R.id.tv_CKJ_money)
    TextView tvCKJMoney;
    @BindView(R.id.wb)
    WebView wb;
    @BindView(R.id.shopnow)
    TextView shopnow;
    private Dialog dialog;
    private String uid;
    private String id;
    private UsergetgoodsbyidBean goodsIndexBean;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }

    @Override
    protected int setthislayout() {
        return R.layout.activity_jf_price_details;
    }

    @Override
    protected void initview() {
        uid = (String) SpUtil.get(context, "uid", "");
        RollPagerView.setHintView(new IconHintView(context, R.drawable.shape_selected, R.drawable.shape_noraml, DensityUtils.dp2px(context, getResources().getDimension(R.dimen.x7))));
        RollPagerView.setPlayDelay(2000);
    }

    @Override
    protected void initListener() {
        rlBack.setOnClickListener(this);
        shopnow.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        if (Utils.isConnected(context)) {
            dialog = Utils.showLoadingDialog(context);
        } else {
            EZToast.showShort(context, R.string.Networkexception);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shopnow:
                if (TextUtils.isEmpty(uid)) {
                    EZToast.showShort(context, "请先登录");
                    startActivity(new Intent(context, LoginActivity.class));
                    return;
                }

                startActivity(new Intent(context, MyJFOrderSubmitActivity.class)
                        .putExtra("id", goodsIndexBean.getList().getId())
                );

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
        dialog.show();
        mHandler.removeCallbacksAndMessages(null);
        goodsDetail();
    }

    /**
     * 产品详情获取
     */
    private void goodsDetail() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("id", String.valueOf(getIntent().getStringExtra("id")));
//        params.put("id", "10");
        Log.e("PriceDetailsActivity", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.JAVA_URL + "usergetgoodsbyid", "usergetgoodsbyid", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("PriceDetailsActivity", result);
                try {
                    dialog.dismiss();
                    goodsIndexBean = new Gson().fromJson(result, UsergetgoodsbyidBean.class);
                    if (goodsIndexBean.getStatus().equals("1")) {
                        RollPagerView.setAdapter(new JfGoodLoopAdapter(RollPagerView, goodsIndexBean.getList().getTupianlist()));
                        tvTitle.setText(goodsIndexBean.getList().getName());
                        tvGYS2.setText("供应商：" + goodsIndexBean.getList().getSupplier());
                        tvCKJMoney.setText("￥" + goodsIndexBean.getList().getPrice());
                        tvTime.setText("需要积分：" + goodsIndexBean.getList().getNeedintegral());
                        wb.loadUrl("http://yuyuanyoupin.com/ym/jf/id/" + String.valueOf(getIntent().getStringExtra("id")) + ".html");
                    } else {
                        EZToast.showShort(context, goodsIndexBean.getMsg());
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

}

