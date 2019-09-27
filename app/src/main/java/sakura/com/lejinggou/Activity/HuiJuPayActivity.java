package sakura.com.lejinggou.Activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Bean.HuiJuChongZhiBean;
import sakura.com.lejinggou.Bean.HuiJuSMSBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EZToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

public class HuiJuPayActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.et_price)
    EditText etPrice;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_user_code)
    EditText etUserCode;
    @BindView(R.id.et_card)
    EditText etCard;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_phonecode)
    EditText etPhonecode;
    @BindView(R.id.btn_getSMScode)
    TextView btnGetSMScode;
    @BindView(R.id.btn_juhepay)
    Button btnJuhepay;
    private Timer timer;
    private TimerTask task;
    private int time = 100;
    private Context context;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*set it to be no title*/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        /*set it to be full screen*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_huijupay);
        ButterKnife.bind(this);
        context = HuiJuPayActivity.this;
        initView();
        initData();

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (timer != null) {
            timer.cancel();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        task = null;
        if (timer != null) {
            timer = null;
        }
        System.gc();
    }

    private void initData() {

        String etPrice = (String) SpUtil.get(context, "etPrice", "");
        String etName = (String) SpUtil.get(context, "etName", "");
        String etUserCode = (String) SpUtil.get(context, "etUserCode", "");
        String etCard = (String) SpUtil.get(context, "etCard", "");
        String etPhone = (String) SpUtil.get(context, "etPhone", "");

        if (!TextUtils.isEmpty(etPrice)) {
//            this.etPrice.setText(etPrice);
        }

        if (!TextUtils.isEmpty(etName)) {
            this.etName.setText(etName);
        }

        if (!TextUtils.isEmpty(etUserCode)) {
            this.etUserCode.setText(etUserCode);
        }

        if (!TextUtils.isEmpty(etCard)) {
            this.etCard.setText(etCard);
        }

        if (!TextUtils.isEmpty(etPhone)) {
            this.etPhone.setText(etPhone);
        }

    }


    private void initView() {
        dialog = Utils.showLoadingDialog(context);
        btnGetSMScode.setOnClickListener(this);
        btnJuhepay.setOnClickListener(this);
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_xieyi:
                startActivity(new Intent(context, ZhuCeXieYiDetailsActivity.class));
                break;
            case R.id.btn_juhepay:

                if (TextUtils.isEmpty(etPrice.getText().toString().trim())) {
                    EZToast.showShort(context, etPrice.getHint().toString());
                    return;
                }

                if (TextUtils.isEmpty(etName.getText().toString().trim())) {
                    EZToast.showShort(context, etName.getHint().toString());
                    return;
                }

                if (TextUtils.isEmpty(etUserCode.getText().toString().trim())) {
                    EZToast.showShort(context, etUserCode.getHint().toString());
                    return;
                }

                if (TextUtils.isEmpty(etCard.getText().toString().trim())) {
                    EZToast.showShort(context, etCard.getHint().toString());
                    return;
                }

                if (TextUtils.isEmpty(etPhone.getText().toString().trim())) {
                    EZToast.showShort(context, etPhone.getHint().toString());
                    return;
                }

                if (TextUtils.isEmpty(etPhonecode.getText().toString().trim())) {
                    EZToast.showShort(context, etPhonecode.getHint().toString());
                    return;
                }

                SpUtil.putAndApply(context, "etPrice", etPrice.getText().toString());
                SpUtil.putAndApply(context, "etName", etName.getText().toString());
                SpUtil.putAndApply(context, "etUserCode", etUserCode.getText().toString());
                SpUtil.putAndApply(context, "etCard", etCard.getText().toString());
                SpUtil.putAndApply(context, "etPhone", etPhone.getText().toString());

                submit();

                break;
            case R.id.btn_getSMScode:

                if (TextUtils.isEmpty(etPrice.getText().toString().trim())) {
                    EZToast.showShort(context, etPrice.getHint().toString());
                    return;
                }

                if (TextUtils.isEmpty(etName.getText().toString().trim())) {
                    EZToast.showShort(context, etName.getHint().toString());
                    return;
                }

                if (TextUtils.isEmpty(etUserCode.getText().toString().trim())) {
                    EZToast.showShort(context, etUserCode.getHint().toString());
                    return;
                }

                if (TextUtils.isEmpty(etCard.getText().toString().trim())) {
                    EZToast.showShort(context, etCard.getHint().toString());
                    return;
                }

                if (TextUtils.isEmpty(etPhone.getText().toString().trim())) {
                    EZToast.showShort(context, etPhone.getHint().toString());
                    return;
                }

                getcaptcha();
                break;
            default:
                break;
        }
    }

    private void getcaptcha() {
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time--;
                        btnGetSMScode.setText("" + time);
                        if (time < 0) {
                            timer.cancel();
                            btnGetSMScode.setText("获取验证码");
                            btnGetSMScode.setEnabled(true);
                            time = 100;
                        }
                    }
                });
            }
        };
        timer.schedule(task, 1000, 1000);
        //// TODO: 2017/5/18  发送验证码
        if (Utils.isConnected(context)) {
            getUserPlace();
        } else {
            Toast.makeText(context, getString(R.string.Networkexception), Toast.LENGTH_SHORT).show();
        }
    }

    String orderid = "";

    /**
     * 发送验证码
     */
    private void getUserPlace() {
        HashMap<String, String> params = new HashMap<>(2);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        params.put("price", etPrice.getText().toString().trim());
        params.put("username", etName.getText().toString().trim());
        params.put("userNo", etUserCode.getText().toString().trim());
        params.put("carNo", etCard.getText().toString().trim());
        params.put("tel", etPhone.getText().toString().trim());
        VolleyRequest.RequestPost(context, UrlUtils.JAVA_URL + "huijuchongzhiSMS", "huijuchongzhiSMS", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = result;
                Log.e("RegisterActivity：", decode);
                try {
                    HuiJuSMSBean codeBean = new Gson().fromJson(decode, HuiJuSMSBean.class);
                    Toast.makeText(HuiJuPayActivity.this, codeBean.getMsg(), Toast.LENGTH_SHORT).show();
                    if ("1".equals(String.valueOf(codeBean.getStatus()))) {
                        orderid = codeBean.getOrderID();
                    } else {
                        time = 0;
                    }
                    decode = null;
                    codeBean = null;
                } catch (Exception e) {
                    e.printStackTrace();
                    time = 0;
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                error.printStackTrace();
                time = 0;
            }
        });
    }

    /**
     * 注册提交
     */
    private void submit() {
        // validate
        dialog.show();
        getRegister();
    }

    /**
     * 注册id
     */
    private void getRegister() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        params.put("price", etPrice.getText().toString().trim());
        params.put("userName", etName.getText().toString().trim());
        params.put("userno", etUserCode.getText().toString().trim());
        params.put("cardNo", etCard.getText().toString().trim());
        params.put("tel", etPhone.getText().toString().trim());
        params.put("orderNo", orderid);
        params.put("smsCode", etPhonecode.getText().toString().trim());
        VolleyRequest.RequestPost(context, UrlUtils.JAVA_URL + "huijuchongzhi", "huijuchongzhi", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                dialog.dismiss();
                time = 0;
                String decode = result;
                Log.e("RegisterActivity", decode);
                try {
                    HuiJuChongZhiBean codeBean = new Gson().fromJson(decode, HuiJuChongZhiBean.class);
                    if (codeBean.getStatus().equals("1")) {
                        Toast.makeText(HuiJuPayActivity.this, "充值成功", Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    } else {
                        Toast.makeText(HuiJuPayActivity.this, codeBean.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                    decode = null;
                    codeBean = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                dialog.dismiss();
                time = 0;
                error.printStackTrace();
            }
        });
    }


}
