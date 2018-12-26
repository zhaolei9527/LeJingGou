package sakura.com.lejinggou.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.LoginBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.CodeUtils;
import sakura.com.lejinggou.Utils.EasyToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

/**
 * Created by 赵磊 on 2017/7/13.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.rl)
    LinearLayout rl;
    @BindView(R.id.et_passwd)
    EditText etPasswd;
    @BindView(R.id.rl2)
    LinearLayout rl2;
    @BindView(R.id.tv_forgetpassworld)
    TextView tvForgetpassworld;
    @BindView(R.id.rl3)
    RelativeLayout rl3;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.rl4)
    RelativeLayout rl4;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.img_changecode)
    ImageView imgChangecode;
    @BindView(R.id.ll_change)
    LinearLayout llChange;
    @BindView(R.id.btn_register)
    Button btnRegister;
    private Dialog dialog;
    private int pswminlen = 6;
    private String account;
    private String password;
    private String openid = "";
    private CodeUtils codeUtils;
    private Bitmap bitmap;
    private String code;


    @Override
    protected void ready() {
        super.ready();
        /*set it to be no title*/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        /*set it to be full screen*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    protected int setthislayout() {
        return R.layout.activcity_login;
    }

    @Override
    protected void initview() {
        initView();
    }

    @Override
    protected void initListener() {
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        tvForgetpassworld.setOnClickListener(this);
        dialog = Utils.showLoadingDialog(context);
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent();
        intent.setAction("LoginActivityIsStart");
        sendBroadcast(intent);
    }


    private void gotoMain() {
        startActivity(new Intent(context, MainActivity.class));
        finish();
    }

    private String mesg;

    @Override
    protected void onResume() {
        super.onResume();
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
                startActivity(new Intent(context, RegisterActivity.class));
                break;
            case R.id.btn_login:
                submit();
                break;
            case R.id.tv_forgetpassworld:
                startActivity(new Intent(context, ForgetActivity.class));
                break;
            default:
                break;
        }
    }

    private void initView() {
        codeUtils = CodeUtils.getInstance();
        bitmap = codeUtils.createBitmap();
        code = codeUtils.getCode();
        image.setImageBitmap(bitmap);
        imgChangecode.setOnClickListener(this);

    }

    private void submit() {
        // validate
        account = etAccount.getText().toString().trim();
        if (TextUtils.isEmpty(account)) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Utils.isCellphone(account)) {
            Toast.makeText(context, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        password = etPasswd.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < pswminlen) {
            Toast.makeText(this, "密码长度最小六位", Toast.LENGTH_SHORT).show();
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

        // TODO validate success, do something
        dialog.show();
        getLogin(account, password);
    }

    /**
     * 登录获取
     */
    private void getLogin(final String tel, final String password) {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("tel", tel);
        params.put("password", password);
        Log.e("LoginActivity", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "login/dologin", "login/dologin", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                dialog.dismiss();
                Log.e("LoginActivity", result);
                try {

                    LoginBean loginBean = new Gson().fromJson(result, LoginBean.class);
                    SpUtil.putAndApply(context, "uid", loginBean.getData().getUid());
                    SpUtil.putAndApply(context, "tel", etAccount.getText().toString());
                    SpUtil.putAndApply(context, "password", etPasswd.getText().toString());

                    if (1 == loginBean.getStatus()) {
                        EasyToast.showShort(context, loginBean.getInfo());
                        gotoMain();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                error.printStackTrace();
                dialog.dismiss();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.queues.cancelAll("login/login");
        account = null;
        password = null;
        System.gc();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        return;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
