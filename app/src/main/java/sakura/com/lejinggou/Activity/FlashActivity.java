package sakura.com.lejinggou.Activity;

import android.Manifest;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;

import java.util.HashMap;
import java.util.List;

import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.LoginBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;


/**
 * Created by 赵磊 on 2017/7/13.
 */

public class FlashActivity extends BaseActivity {

    private String account;
    private String password;
    private String wxopenid;

    @Override
    protected void onResume() {
        super.onResume();
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
        return R.layout.flash_layout;
    }

    @Override
    protected void initview() {

    }

    @Override
    protected void initListener() {
    }

    @Override
    protected void initData() {
        boolean connected = Utils.isConnected(context);
        if (connected) {
            AutoLogin();
        } else {
            if (context != null) {
                Toast.makeText(context, getString(R.string.Networkexception), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void AutoLogin() {
        account = (String) SpUtil.get(context, "tel", "");
        password = (String) SpUtil.get(context, "password", "");
        wxopenid = (String) SpUtil.get(context, "wxopenid", "");
        if (!TextUtils.isEmpty(account) && !TextUtils.isEmpty(password)) {
            getLogin(account, password);
            Log.e("FlashActivity", "常规登录");
        } else {
            delayGoToLogin();
            Log.e("FlashActivity", "nodata");
        }
    }

    /**
     * 登录获取
     */
    private void getLogin(final String tel, final String password) {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("tel", tel);
        params.put("password", password);
        Log.e("LoginActivity", "params:" + params);
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "login/dologin" + App.LanguageTYPEHTTP, "login/dologin", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = result;
                Log.e("LoginActivity", decode);
                try {
                    LoginBean loginBean = new Gson().fromJson(decode, LoginBean.class);
                    if (1 == loginBean.getStatus()) {
                        Toast.makeText(context, getString(R.string.Welcome_back), Toast.LENGTH_SHORT).show();
                        SpUtil.putAndApply(context, "uid", loginBean.getData().getUid().toString());
                        gotoMain();
                    } else {
                        Toast.makeText(context, "登录失效", Toast.LENGTH_SHORT).show();
                        SpUtil.clear(context);
                        delayGoToLogin();
                    }
                    decode = null;
                    loginBean = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                error.printStackTrace();
                delayGoToLogin();
            }
        });
    }

    private void gotoMain() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(context, MainActivity.class));
                finish();
            }
        }, 2000);
    }

    private void delayGoToLogin() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(context, MainActivity.class));
                finish();
            }
        }, 2000);
    }


}
