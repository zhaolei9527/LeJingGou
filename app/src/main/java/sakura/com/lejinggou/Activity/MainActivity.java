package sakura.com.lejinggou.Activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.bottomtabbar.BottomTabBar;
import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.AppGetTZBean;
import sakura.com.lejinggou.Bean.LoginBean;
import sakura.com.lejinggou.Fragment.HomeFragment;
import sakura.com.lejinggou.Fragment.MeFragment;
import sakura.com.lejinggou.Fragment.NewsFragment;
import sakura.com.lejinggou.Fragment.ZuoRiLiShiFragment;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EZToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.View.CustomViewPager;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

public class MainActivity extends BaseActivity {

    @BindView(R.id.fl_content)
    CustomViewPager flContent;
    @BindView(R.id.BottomTabBar)
    sakura.bottomtabbar.BottomTabBar BottomTabBar;
    @BindView(R.id.SimpleDraweeView)
    com.facebook.drawee.view.SimpleDraweeView SimpleDraweeView;
    @BindView(R.id.img_close)
    ImageView imgClose;
    @BindView(R.id.ll_msg)
    LinearLayout llMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            home.addCategory(Intent.CATEGORY_HOME);
            startActivity(home);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected int setthislayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initview() {
        Acp.getInstance(this).request(new AcpOptions.Builder()
                        .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE
                                , Manifest.permission.READ_EXTERNAL_STORAGE
                                , Manifest.permission.READ_PHONE_STATE
                                , Manifest.permission.CAMERA)
                        .setDeniedMessage(getString(R.string.requstPerminssions))
                        .build(),
                new AcpListener() {
                    @Override
                    public void onGranted() {

                    }

                    @Override
                    public void onDenied(List<String> permissions) {
                        Toast.makeText(MainActivity.this, getString(R.string.Thepermissionapplicationisrejected), Toast.LENGTH_SHORT).show();
                    }
                });
        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new NewsFragment());
        fragments.add(new ZuoRiLiShiFragment());
        fragments.add(new MeFragment());
        CustomViewPager viewpager = (CustomViewPager) findViewById(R.id.fl_content);
        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }
        });
        ((BottomTabBar) findViewById(R.id.BottomTabBar)).setPadding(0, 0, 0, 0);
        ((BottomTabBar) findViewById(R.id.BottomTabBar))
                .initFragmentorViewPager(viewpager)
                .setImgSize(getResources().getDimension(R.dimen.x19), getResources().getDimension(R.dimen.y16))
                .setChangeColor(getResources().getColor(R.color.bgtitle), getResources().getColor(R.color.text666))
                .setDividerHeight(3)
                .isShowDivider(true)
                .setFontSize(12)
                .setDividerColor(getResources().getColor(R.color.bgea))
                .addTabItem("首页", getResources().getDrawable(R.mipmap.home_after), getResources().getDrawable(R.mipmap.home_before))
                .addTabItem("积分商城", getResources().getDrawable(R.mipmap.room_after), getResources().getDrawable(R.mipmap.room_before))
                .addTabItem("历史", getResources().getDrawable(R.mipmap.history_after), getResources().getDrawable(R.mipmap.history_before))
                .addTabItem("个人中心", getResources().getDrawable(R.mipmap.center_after), getResources().getDrawable(R.mipmap.center_before))
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, View view) {
                        if (position == 3 || position == 4) {
                            if (TextUtils.isEmpty((String) SpUtil.get(MainActivity.this, "uid", ""))) {
                                EZToast.showShort(MainActivity.this, getString(R.string.Please_login_first));
                                finish();
                                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                            }
                        }
                        if (!TextUtils.isEmpty((String) SpUtil.get(MainActivity.this, "uid", ""))) {
                            // indexCatr();
                        }

                    }
                })
                .commit();
    }

    @Override
    protected void initListener() {


    }

    @Override
    protected void initData() {
        appGetTZ();
    }

    private String account;
    private String password;
    private String wxopenid;

    @Override
    protected void onResume() {
        super.onResume();
        account = (String) SpUtil.get(context, "tel", "");
        password = (String) SpUtil.get(context, "password", "");
        wxopenid = (String) SpUtil.get(context, "wxopenid", "");
        if (!TextUtils.isEmpty(account) && !TextUtils.isEmpty(password)) {
            getLogin(account, password, "");
            Log.e("FlashActivity", "常规登录");
        } else if (!TextUtils.isEmpty(wxopenid)) {
            getLogin("", "", wxopenid);
            Log.e("FlashActivity", "wx登录");
        }
    }

    /**
     * 登录获取
     */
    private void getLogin(final String tel, final String password, String openid) {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("tel", tel);
        params.put("password", password);
        if (!TextUtils.isEmpty(openid)) {
            params.put("openid", openid);
        }
        Log.e("LoginActivity", "params:" + params);
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "login/dologin" + App.LanguageTYPEHTTP, "login/dologin", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = result;
                Log.e("LoginActivity", decode);
                try {
                    LoginBean loginBean = new Gson().fromJson(decode, LoginBean.class);
                    if (1 == loginBean.getStatus()) {
                        SpUtil.putAndApply(context, "uid", loginBean.getData().getUid().toString());
                    } else {
                        EZToast.showShort(context, getString(R.string.Login_failed_login));
                        startActivity(new Intent(context, LoginActivity.class));
                        finish();
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
            }
        });
    }

    /**
     * 登录获取
     */
    private void appGetTZ() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "0")));
        Log.e("appGetTZ", "params:" + params);
        VolleyRequest.RequestPost(context, UrlUtils.JAVA_URL + "appGetTZ", "appGetTZ", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = result;
                Log.e("appGetTZ", decode);
                try {
                    AppGetTZBean loginBean = new Gson().fromJson(decode, AppGetTZBean.class);

                    if (loginBean.getStatus().equals("1")) {

                        if (loginBean.getList().getState().equals("0")) {

                            llMsg.setVisibility(View.VISIBLE);

                            imgClose.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    llMsg.setVisibility(View.GONE);
                                }
                            });

                            SimpleDraweeView.setImageURI(loginBean.getList().getFengmian());

                            final AppGetTZBean finalLoginBean = loginBean;
                            SimpleDraweeView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(new Intent(context, JFPriceDetailsActivity.class)
                                            .putExtra("id", finalLoginBean.getList().getId())
                                    );
                                }
                            });
                        } else {
                            llMsg.setVisibility(View.GONE);
                        }

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
            }
        });
    }


}