package sakura.com.lejinggou.Activity;

import android.Manifest;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.bigkoo.pickerview.TimePickerView;
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
import sakura.com.lejinggou.Bean.LoginBean;
import sakura.com.lejinggou.Fragment.HomeFragment;
import sakura.com.lejinggou.Fragment.ShopFragment;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EasyToast;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
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
                        try {
                            ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                            cm.setText(TimePickerView.ZFB);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onDenied(List<String> permissions) {
                        Toast.makeText(MainActivity.this, getString(R.string.Thepermissionapplicationisrejected), Toast.LENGTH_SHORT).show();
                    }
                });
        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new ShopFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
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
                .addTabItem("房间", getResources().getDrawable(R.mipmap.room_after), getResources().getDrawable(R.mipmap.room_before))
                .addTabItem("历史", getResources().getDrawable(R.mipmap.history_after), getResources().getDrawable(R.mipmap.history_before))
                .addTabItem("个人中心", getResources().getDrawable(R.mipmap.center_after), getResources().getDrawable(R.mipmap.center_before))
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, View view) {
                        if (position == 3 || position == 4) {
                            if (TextUtils.isEmpty((String) SpUtil.get(MainActivity.this, "uid", ""))) {
                                EasyToast.showShort(MainActivity.this, getString(R.string.Please_login_first));
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
                        EasyToast.showShort(context, getString(R.string.Login_failed_login));
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


}