package sakura.com.lejinggou.Activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.BankEvent;
import sakura.com.lejinggou.Bean.PayResult;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EZToast;
import sakura.com.lejinggou.Utils.Utils;


public class PayActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.tv_ordernumber)
    TextView tvOrdernumber;
    @BindView(R.id.tv_totalmoney)
    TextView tvTotalmoney;
    @BindView(R.id.img_weixin)
    ImageView imgWeixin;
    @BindView(R.id.Choosedweixin)
    CheckBox Choosedweixin;
    @BindView(R.id.img_yue)
    ImageView imgYue;
    @BindView(R.id.Choosedyue)
    CheckBox Choosedyue;
    @BindView(R.id.btn_paynow)
    Button btnPaynow;
    @BindView(R.id.rl_weixinpay)
    RelativeLayout rlWeixinpay;
    private String orderid;
    private String order;
    private Dialog dialog;

    private static final int SDK_PAY_FLAG = 1;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    Log.e("PayActivity", resultInfo.toString());
                    String resultStatus = payResult.getResultStatus();
                    Log.e("PayActivity", resultStatus.toString());
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        EZToast.showShort(context, "支付成功");
                        EventBus.getDefault().post(
                                new BankEvent("good", "pay"));
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        EZToast.showShort(context, "支付失败，请重试");
                        EventBus.getDefault().post(
                                new BankEvent("bad", "pay"));
                    }
                    break;
                }
                default:
                    break;
            }
        }

        ;
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isfinish) {
            isfinish = !isfinish;
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getQueues().cancelAll("order/pay");
        //反注册EventBus
        EventBus.getDefault().unregister(PayActivity.this);
        System.gc();
    }

    @Override
    protected int setthislayout() {
        return R.layout.activity_pay;
    }

    @Override
    protected void initview() {
        orderid = getIntent().getStringExtra("orderid");
        order = getIntent().getStringExtra("order");
        if (!TextUtils.isEmpty(order)) {
            tvOrdernumber.setText(order);
        }

        //注册EventBus
        if (!EventBus.getDefault().isRegistered(PayActivity.this)) {
            EventBus.getDefault().register(PayActivity.this);
        }

        dialog = Utils.showLoadingDialog(context);
    }

    @Override
    protected void initListener() {
        btnPaynow.setOnClickListener(this);
        rlBack.setOnClickListener(this);

        rlWeixinpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Choosedweixin.setChecked(true);
                Choosedyue.setChecked(false);
            }
        });

    }

    @Override
    protected void initData() {
        if (Utils.isConnected(context)) {
            tvOrdernumber.setText(getIntent().getStringExtra("orderid"));
            tvTotalmoney.setText(getIntent().getStringExtra("monsy"));
        } else {
            finish();
            EZToast.showShort(context, "网络未连接");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_paynow:
                if (Utils.isConnected(context)) {
                    if (Choosedweixin.isChecked()) {
                        return;
                    } else {

                    }
                    if (!dialog.isShowing()) {
                        dialog.show();
                        btnPaynow.setClickable(false);
                    }

                } else {
                    EZToast.showShort(context, "网络未连接");
                }
                break;
            case R.id.rl_back:
                finish();
                break;
            default:
                break;
        }
    }

    public static boolean isfinish = false;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(BankEvent event) {
        if (!TextUtils.isEmpty(event.getmType())) {
            if ("pay".equals(event.getmType())) {
                if ("good".equals(event.getMsg())) {

                } else if ("bad".equals(event.getMsg())) {


                }
            }
        }
    }

}
