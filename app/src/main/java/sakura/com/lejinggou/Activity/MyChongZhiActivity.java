package sakura.com.lejinggou.Activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alipay.sdk.app.PayTask;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.PayResult;
import sakura.com.lejinggou.Bean.ZfpayBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EZToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

/**
 * com.wenguoyi.Activity
 *
 * @author 赵磊
 * @date 2018/5/29
 * 功能描述：
 */
public class MyChongZhiActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.tv_Title)
    TextView tvTitle;
    @BindView(R.id.tv_mingxi)
    TextView tvMingxi;
    @BindView(R.id.tv_bank)
    TextView tvBank;
    @BindView(R.id.et_money)
    EditText etMoney;
    @BindView(R.id.Choosedweixin)
    CheckBox Choosedweixin;
    @BindView(R.id.ll_WX)
    RelativeLayout llWX;
    @BindView(R.id.Choosedzhifubao)
    CheckBox Choosedzhifubao;
    @BindView(R.id.ll_ZFB)
    RelativeLayout llZFB;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    private Dialog dialog;
    private String type = "1";

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
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        EZToast.showShort(context, "支付失败，请重试");
                    }
                    break;
                }
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected int setthislayout() {
        return R.layout.activity_mychongzhi_layout;
    }

    @Override
    protected void initview() {
        String kymon = (String) SpUtil.get(context, "Kymon", "");
        tvBank.setText("当前账户余额：￥" + kymon);
    }

    @Override
    protected void initListener() {
        rlBack.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        llWX.setOnClickListener(this);
        llZFB.setOnClickListener(this);
        tvMingxi.setOnClickListener(this);
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_mingxi:
                startActivity(new Intent(context, MingXiJiLuListActivity.class));
                break;
            case R.id.btn_submit:

                String Money = etMoney.getText().toString().trim();
                if (TextUtils.isEmpty(Money)) {
                    EZToast.showShort(context, etMoney.getHint().toString());
                    return;
                }

                if (type.equals("2")) {
                    dialog.show();
                    orderZfpay();
                } else {
                    //orderWxpay();
                }
                break;
            case R.id.ll_WX:
                type = "1";
                Choosedweixin.setChecked(true);
                Choosedzhifubao.setChecked(false);
                break;
            case R.id.ll_ZFB:
                type = "2";
                Choosedweixin.setChecked(false);
                Choosedzhifubao.setChecked(true);
                break;
            default:
                break;
        }
    }

    /**
     * 订单支付，支付宝
     */
    private void orderZfpay() {
        HashMap<String, String> params = new HashMap<>(3);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        params.put("money", etMoney.getText().toString().trim());
        params.put("type", "2");
        Log.e("orderZfpay", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "about/cz", "about/cz", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String msg) {
                dialog.dismiss();
                Log.e("支付宝", msg);
                try {
                    ZfpayBean zfpayBean = new Gson().fromJson(msg, ZfpayBean.class);
                    final ZfpayBean finalZfpayBean = zfpayBean;
                    Runnable payRunnable = new Runnable() {
                        @Override
                        public void run() {
                            PayTask alipay = new PayTask(MyChongZhiActivity.this);
                            Map<String, String> result = alipay.payV2(finalZfpayBean.getData().getRes(), true);
                            Log.e("msp", result.toString());
                            Message msg = new Message();
                            msg.what = SDK_PAY_FLAG;
                            msg.obj = result;
                            mHandler.sendMessage(msg);
                        }
                    };
                    Thread payThread = new Thread(payRunnable);
                    payThread.start();
                    zfpayBean = null;
                    msg = null;
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
        super.onDestroy();
        App.getQueues().cancelAll("user/jine");
        //反注册EventBus
        EventBus.getDefault().unregister(MyChongZhiActivity.this);
        System.gc();
    }


}
