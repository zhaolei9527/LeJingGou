package sakura.com.lejinggou.Fragment;

import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import sakura.com.lejinggou.Activity.ChongZhiXianXiaActivity;
import sakura.com.lejinggou.Activity.HelpActivity;
import sakura.com.lejinggou.Activity.LoginActivity;
import sakura.com.lejinggou.Activity.MainActivity;
import sakura.com.lejinggou.Activity.MingXiJiLuListActivity;
import sakura.com.lejinggou.Activity.MyJFOrderActivity;
import sakura.com.lejinggou.Activity.MyOrderActivity;
import sakura.com.lejinggou.Activity.SettingActivity;
import sakura.com.lejinggou.Activity.TiXianAliActivity;
import sakura.com.lejinggou.Activity.XiaJiListActivity;
import sakura.com.lejinggou.Activity.ZhiFuBaoActivity;
import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseLazyFragment;
import sakura.com.lejinggou.Bean.AboutIndexBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EZToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.View.CommomDialog;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

import static com.tencent.bugly.beta.Beta.checkUpgrade;

/**
 * sakura.com.lejinggou.Fragment
 *
 * @author 赵磊
 * @date 2018/12/28
 * 功能描述：
 */
public class MeFragment extends BaseLazyFragment implements View.OnClickListener {
    Unbinder unbinder;
    @BindView(R.id.SimpleDraweeView)
    com.facebook.drawee.view.SimpleDraweeView SimpleDraweeView;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_LJ)
    TextView tvLJ;
    @BindView(R.id.tvLJ)
    TextView tvLJURl;
    @BindView(R.id.tv_YE)
    TextView tvYE;
    @BindView(R.id.tv_BZJ)
    TextView tvBZJ;
    @BindView(R.id.tv_KYJ)
    TextView tvKYJ;
    @BindView(R.id.tv_KQJ)
    TextView tvKQJ;
    @BindView(R.id.ll_chongzhi)
    LinearLayout llChongzhi;
    @BindView(R.id.ll_tixian)
    LinearLayout llTixian;
    @BindView(R.id.ll_mingxi)
    LinearLayout llMingxi;
    @BindView(R.id.ll_myorder)
    LinearLayout llMyorder;
    @BindView(R.id.ll_daifukuan)
    LinearLayout llDaifukuan;
    @BindView(R.id.ll_daifahuo)
    LinearLayout llDaifahuo;
    @BindView(R.id.ll_daishouhuo)
    LinearLayout llDaishouhuo;
    @BindView(R.id.ll_yiwancheng)
    LinearLayout llYiwancheng;
    @BindView(R.id.ll_yiguoqi)
    LinearLayout llYiguoqi;
    @BindView(R.id.ll_TGM)
    LinearLayout llTGM;
    @BindView(R.id.ll_BZ)
    LinearLayout llBZ;
    @BindView(R.id.img_message)
    RelativeLayout imgMessage;
    @BindView(R.id.SimpleDraweeView_EWM)
    com.facebook.drawee.view.SimpleDraweeView SimpleDraweeViewEWM;
    @BindView(R.id.tv_TJM)
    TextView tvTJM;
    @BindView(R.id.ll_wem)
    LinearLayout llWem;
    @BindView(R.id.wem_close)
    ImageView wemClose;
    @BindView(R.id.rl_ewm)
    RelativeLayout rlEwm;
    @BindView(R.id.tv_jf)
    TextView tvJf;
    @BindView(R.id.ll_myorder_jf)
    LinearLayout llMyorderJf;
    @BindView(R.id.ll_daifukuan_jf)
    LinearLayout llDaifukuanJf;
    @BindView(R.id.ll_daifahuo_jf)
    LinearLayout llDaifahuoJf;
    @BindView(R.id.ll_daishouhuo_jf)
    LinearLayout llDaishouhuoJf;
    @BindView(R.id.ll_yiwancheng_jf)
    LinearLayout llYiwanchengJf;
    @BindView(R.id.ll_yiguoqi_jf)
    LinearLayout llYiguoqiJf;
    @BindView(R.id.ll_XJ)
    LinearLayout llXJ;
    @BindView(R.id.ll_EXIT)
    LinearLayout llEXIT;
    @BindView(R.id.ll_UPApp)
    LinearLayout llUPApp;
    private Context context;
    private Dialog dialog;
    private AboutIndexBean aboutIndexBean;

    @Override
    protected void initPrepare() {
    }

    @Override
    protected void onInvisible() {
    }

    @Override
    protected void initData() {


    }

    @Override
    protected View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.me_frament_layout, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            String uid = String.valueOf(SpUtil.get(context, "uid", ""));
            if (!TextUtils.isEmpty(uid)) {

                if (Utils.isConnected(context)) {
                    dialog = Utils.showLoadingDialog(getActivity());
                    dialog.show();
                    String img = String.valueOf(SpUtil.get(context, "img", ""));

                    if (!TextUtils.isEmpty(img)) {
                        SimpleDraweeView.setImageURI(UrlUtils.URL + img);
                    }

                    String uname = String.valueOf(SpUtil.get(context, "uname", ""));
                    if (!TextUtils.isEmpty(uname)) {
                        tvUsername.setText(uname);
                    }

                    imgMessage.setOnClickListener(this);
                    llChongzhi.setOnClickListener(this);
                    llTixian.setOnClickListener(this);
                    llMingxi.setOnClickListener(this);
                    llMyorder.setOnClickListener(this);
                    llDaifahuo.setOnClickListener(this);
                    llDaifukuan.setOnClickListener(this);
                    llDaishouhuo.setOnClickListener(this);
                    llYiwancheng.setOnClickListener(this);
                    llYiguoqi.setOnClickListener(this);

                    llMyorderJf.setOnClickListener(this);
                    llDaifahuoJf.setOnClickListener(this);
                    llDaifukuanJf.setOnClickListener(this);
                    llDaishouhuoJf.setOnClickListener(this);
                    llYiwanchengJf.setOnClickListener(this);
                    llYiguoqiJf.setOnClickListener(this);

                    llBZ.setOnClickListener(this);
                    llTGM.setOnClickListener(this);
                    wemClose.setOnClickListener(this);
                    tvTJM.setOnClickListener(this);
                    tvLJURl.setOnClickListener(this);
                    llXJ.setOnClickListener(this);
                    llEXIT.setOnClickListener(this);
                    llUPApp.setOnClickListener(this);

                    getData();
                } else {
                    EZToast.showShort(context, getResources().getString(R.string.Networkexception));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //数据获取
    public void getData() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        Log.e("HomeFragment", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "about/index" + App.LanguageTYPEHTTP, "about/index", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("HomeFragment", result);
                try {
                    dialog.dismiss();
                    aboutIndexBean = new Gson().fromJson(result, AboutIndexBean.class);
                    if (1 == aboutIndexBean.getStatus()) {

                        SpUtil.putAndApply(context, "img", aboutIndexBean.getData().getHeadimg());
                        SpUtil.putAndApply(context, "uname", aboutIndexBean.getData().getNickname());
                        SpUtil.putAndApply(context, "ne", aboutIndexBean.getData().getNe());
                        SpUtil.putAndApply(context, "is_sm", aboutIndexBean.getData().getIs_sm());
                        SpUtil.putAndApply(context, "zfbname", aboutIndexBean.getData().getZfbname());
                        SpUtil.putAndApply(context, "zfbacc", aboutIndexBean.getData().getZfbacc());
                        SpUtil.putAndApply(context, "name", aboutIndexBean.getData().getName());
                        SpUtil.putAndApply(context, "idcard", aboutIndexBean.getData().getIdcard());
                        SpUtil.putAndApply(context, "skmsg", aboutIndexBean.getData().getSkmsg());
                        SpUtil.putAndApply(context, "qm", aboutIndexBean.getData().getQm());
                        SpUtil.putAndApply(context, "Kymon", aboutIndexBean.getData().getKymon());
                        SpUtil.putAndApply(context, "syjf", aboutIndexBean.getData().getSyjf());
                        SpUtil.putAndApply(context, "Is_yg", aboutIndexBean.getData().getIs_yg());


                        if (aboutIndexBean.getData().getIs_yg().equals("4")) {
                            llEXIT.setVisibility(View.VISIBLE);
                        } else {
                            llEXIT.setVisibility(View.GONE);
                        }

                        if (aboutIndexBean.getData().getHeadimg().startsWith("http")) {
                            SimpleDraweeView.setImageURI(aboutIndexBean.getData().getHeadimg());
                        } else {
                            SimpleDraweeView.setImageURI(UrlUtils.URL + aboutIndexBean.getData().getHeadimg());
                        }

                        tvUsername.setText(String.valueOf(aboutIndexBean.getData().getNickname()));
                        tvLJ.setText("累计收益：￥" + String.valueOf(aboutIndexBean.getData().getLjsy()));
                        tvYE.setText(String.valueOf(aboutIndexBean.getData().getZje()));
                        tvBZJ.setText(String.valueOf(aboutIndexBean.getData().getDjmon()));
                        tvKYJ.setText(String.valueOf(aboutIndexBean.getData().getKymon()));
                        tvKQJ.setText(String.valueOf(aboutIndexBean.getData().getKymon()));
                        tvJf.setText(String.valueOf(aboutIndexBean.getData().getSyjf()));

                        SimpleDraweeViewEWM.setImageURI(UrlUtils.URL + aboutIndexBean.getData().getEwm());

                        if (!aboutIndexBean.getData().getIs_yg().equals("2")) {
                            llTGM.setVisibility(View.GONE);
                            llXJ.setVisibility(View.GONE);
                        } else {
                            llTGM.setVisibility(View.VISIBLE);
                            llXJ.setVisibility(View.VISIBLE);
                        }

                    } else {
                        EZToast.showShort(context, aboutIndexBean.getInfo());
                        mContext.startActivity(new Intent(context, LoginActivity.class));
                        ((MainActivity) mContext).finish();
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
    public void onDestroy() {
        super.onDestroy();
        App.getQueues().cancelAll("about/index");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_UPApp:
                checkUpgrade();
                break;
            case R.id.ll_EXIT:
                new CommomDialog(context, R.style.dialog, "您确定退出登录么？", new CommomDialog.OnCloseListener() {
                    @Override
                    public void onClick(Dialog dialog, final boolean confirm) {
                        if (confirm) {
                            dialog.dismiss();
                            SpUtil.clear(context);
                            Intent intent = new Intent(context, LoginActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        } else {
                            dialog.dismiss();
                        }
                    }
                }).setTitle("提示").show();
                break;
            case R.id.tv_TJM:
                try {
                    // 从API11开始android推荐使用android.content.ClipboardManager
                    // 为了兼容低版本我们这里使用旧版的android.text.ClipboardManager，虽然提示deprecated，但不影响使用。
                    ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                    // 将文本内容放到系统剪贴板里。
                    cm.setText(aboutIndexBean.getData().getTjcode());
                    EZToast.showShort(context, "已将推荐码复制到粘贴板");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.tvLJ:
                try {
                    // 从API11开始android推荐使用android.content.ClipboardManager
                    // 为了兼容低版本我们这里使用旧版的android.text.ClipboardManager，虽然提示deprecated，但不影响使用。
                    ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                    // 将文本内容放到系统剪贴板里。
                    cm.setText(aboutIndexBean.getData().getLj());
                    EZToast.showShort(context, "已将推荐链接复制到粘贴板");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.wem_close:
                rlEwm.setVisibility(View.GONE);
                break;
            case R.id.ll_TGM:
                if (aboutIndexBean.getData().getIs_yg().equals("2")) {
                    rlEwm.setVisibility(View.VISIBLE);
                } else {
                    EZToast.showShort(context, "您当前非经纪人");
                }
                break;
            case R.id.ll_XJ:
                if (aboutIndexBean.getData().getIs_yg().equals("2")) {
                    startActivity(new Intent(mContext, XiaJiListActivity.class));
                } else {
                    EZToast.showShort(context, "您当前非经纪人");
                }
                break;
            case R.id.ll_myorder:
                startActivity(new Intent(mContext, MyOrderActivity.class).putExtra("cid", "0"));
                break;
            case R.id.ll_daifukuan:
                startActivity(new Intent(mContext, MyOrderActivity.class).putExtra("cid", "1"));
                break;
            case R.id.ll_daifahuo:
                startActivity(new Intent(mContext, MyOrderActivity.class).putExtra("cid", "2"));
                break;
            case R.id.ll_daishouhuo:
                startActivity(new Intent(mContext, MyOrderActivity.class).putExtra("cid", "3"));
                break;
            case R.id.ll_yiwancheng:
                startActivity(new Intent(mContext, MyOrderActivity.class).putExtra("cid", "4"));
                break;
            case R.id.ll_yiguoqi:
                startActivity(new Intent(mContext, MyOrderActivity.class).putExtra("cid", "-1"));
                break;
            case R.id.ll_myorder_jf:
                startActivity(new Intent(mContext, MyJFOrderActivity.class).putExtra("cid", "0"));
                break;
            case R.id.ll_daifukuan_jf:
                startActivity(new Intent(mContext, MyJFOrderActivity.class).putExtra("cid", "0"));
                break;
            case R.id.ll_daifahuo_jf:
                startActivity(new Intent(mContext, MyJFOrderActivity.class).putExtra("cid", "1"));
                break;
            case R.id.ll_daishouhuo_jf:
                startActivity(new Intent(mContext, MyJFOrderActivity.class).putExtra("cid", "2"));
                break;
            case R.id.ll_yiwancheng_jf:
                startActivity(new Intent(mContext, MyJFOrderActivity.class).putExtra("cid", "3"));
                break;
            case R.id.ll_yiguoqi_jf:
                startActivity(new Intent(mContext, MyJFOrderActivity.class).putExtra("cid", "4"));
                break;
            case R.id.img_message:
                if (aboutIndexBean.getData().getIs_yg().equals("4")) {
                    EZToast.showShort(context, "当前身份不可修改用户资料");
                } else {
                    startActivity(new Intent(context, SettingActivity.class));
                }
                break;
            case R.id.ll_chongzhi:
//                startActivity(new Intent(context, HuiJuPayActivity.class));
                startActivity(new Intent(context, ChongZhiXianXiaActivity.class).putExtra("url", "http://abc.yuyuanyoupin.com:8080/jfshop/goRechargeForm"));
                //startActivity(new Intent(context, MyChongZhiActivity.class));
                break;
            case R.id.ll_tixian:
                if (aboutIndexBean.getData().getIs_yg().equals("4")) {
                    EZToast.showShort(context, "当前身份不可提现");
                } else {
                    String zfbname = (String) SpUtil.get(context, "zfbname", "");
                    if (!TextUtils.isEmpty(zfbname)) {
                        startActivity(new Intent(context, TiXianAliActivity.class));
                    } else {
                        EZToast.showShort(context, "请先绑定支付宝账户");
                        startActivity(new Intent(context, ZhiFuBaoActivity.class));
                    }
                }
                break;
            case R.id.ll_mingxi:
                startActivity(new Intent(context, MingXiJiLuListActivity.class));
                break;
            case R.id.ll_BZ:
                startActivity(new Intent(context, HelpActivity.class));
                break;
            default:
                break;
        }
    }
}
