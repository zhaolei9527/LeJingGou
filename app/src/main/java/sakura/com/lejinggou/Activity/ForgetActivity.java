package sakura.com.lejinggou.Activity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Bean.CodeBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.CodeUtils;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

public class ForgetActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.ll_msg)
    LinearLayout llMsg;
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.img_changecode)
    ImageView imgChangecode;
    @BindView(R.id.et_phonecode)
    EditText etPhonecode;
    @BindView(R.id.btn_getSMScode)
    TextView btnGetSMScode;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_passwordagain)
    EditText etPasswordagain;
    @BindView(R.id.cb_check)
    CheckBox cbCheck;
    @BindView(R.id.tv_xieyi)
    TextView tvXieyi;
    @BindView(R.id.btn_register)
    Button btnRegister;
    private Timer timer;
    private TimerTask task;
    private int time = 100;
    private Context context;
    private String account;
    private String phonecode;
    private String password;
    private String passwordagain;
    private Dialog dialog;
    private CodeUtils codeUtils;
    private Bitmap bitmap;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           /*set it to be no title*/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
       /*set it to be full screen*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forget);
        ButterKnife.bind(this);
        context = ForgetActivity.this;
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
        account = null;
        phonecode = null;
        password = null;
        passwordagain = null;
        System.gc();
    }

    private void initData() {
    }

    private void initView() {
        codeUtils = CodeUtils.getInstance();
        bitmap = codeUtils.createBitmap();
        code = codeUtils.getCode();
        image.setImageBitmap(bitmap);
        dialog = Utils.showLoadingDialog(context);
        imgChangecode.setOnClickListener(this);
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnRegister.setOnClickListener(this);
        btnGetSMScode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_changecode:
                bitmap = codeUtils.createBitmap();
                code = codeUtils.getCode();
                image.setImageBitmap(bitmap);
                break;
            case R.id.btn_register:
                submit();
                break;
            case R.id.btn_getSMScode:
                account = etAccount.getText().toString().trim();
                if (TextUtils.isEmpty(account)) {
                    Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!Utils.isCellphone(account)) {
                    Toast.makeText(this, "请输入正确手机号", Toast.LENGTH_SHORT).show();
                    return;
                }

                String incode = etCode.getText().toString().trim();
                if (TextUtils.isEmpty(incode)) {
                    Toast.makeText(this, "请输入图形验证码", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!incode.equals(code)) {
                    Toast.makeText(this, "图形验证码错误", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (time == 100) {
                    getcaptcha(etAccount.getText().toString());
                }
                break;
            default:
                break;
        }
    }

    private void getcaptcha(String phone) {
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
            getUserPlace(phone);
        } else {
            Toast.makeText(context, getString(R.string.Networkexception), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 发送验证码
     */
    private void getUserPlace(String phone) {
        HashMap<String, String> params = new HashMap<>(2);
        params.put("tel", phone);
        params.put("type", "2");
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "login/tel", "login/tel", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = result;
                Log.e("RegisterActivity", decode);
                try {
                    CodeBean codeBean = new Gson().fromJson(decode, CodeBean.class);
                    Toast.makeText(ForgetActivity.this, codeBean.getInfo(), Toast.LENGTH_SHORT).show();
                    if ("1".equals(String.valueOf(codeBean.getStatus()))) {

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
        account = etAccount.getText().toString().trim();
        if (TextUtils.isEmpty(account)) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!Utils.isCellphone(account)) {
            Toast.makeText(this, "请输入正确手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        phonecode = etPhonecode.getText().toString().trim();
        if (TextUtils.isEmpty(phonecode)) {
            Toast.makeText(this, "请输入短信验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        password = etPassword.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        passwordagain = etPasswordagain.getText().toString().trim();
        if (TextUtils.isEmpty(passwordagain)) {
            Toast.makeText(this, "请再次输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(passwordagain)) {
            Toast.makeText(this, "两次密码不一致", Toast.LENGTH_SHORT).show();
            return;
        }

        dialog.show();
        getRegister(account, phonecode, password);

    }

    /**
     * 注册id
     */
    private void getRegister(String phone, String code, String password) {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("tel", phone);
        params.put("code", code);
        params.put("password", password);
        params.put("fpassword", password);
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "login/forget", "login/forget", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                dialog.dismiss();
                time = 0;
                String decode = result;
                Log.e("RegisterActivity", decode);
                try {
                    CodeBean codeBean = new Gson().fromJson(decode, CodeBean.class);
                    if (1 == codeBean.getStatus()) {
                        Toast.makeText(ForgetActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(ForgetActivity.this, codeBean.getInfo(), Toast.LENGTH_SHORT).show();
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
