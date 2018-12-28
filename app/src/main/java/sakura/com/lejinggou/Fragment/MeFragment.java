package sakura.com.lejinggou.Fragment;

import android.app.Dialog;
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
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import sakura.com.lejinggou.Activity.LoginActivity;
import sakura.com.lejinggou.Activity.MainActivity;
import sakura.com.lejinggou.Activity.SettingActivity;
import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseLazyFragment;
import sakura.com.lejinggou.Bean.AboutIndexBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EasyToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

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
    ImageView imgMessage;
    private Context context;
    private Dialog dialog;

    @Override
    protected void initPrepare() {

    }

    @Override
    protected void onInvisible() {

    }

    @Override
    protected void initData() {
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

                imgMessage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(context, SettingActivity.class));
                    }
                });


                getData();
            } else {
                EasyToast.showShort(context, getResources().getString(R.string.Networkexception));
            }
        }
    }

    @Override
    protected View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.me_frament_layout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

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
                    AboutIndexBean aboutIndexBean = new Gson().fromJson(result, AboutIndexBean.class);
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

                        SimpleDraweeView.setImageURI(UrlUtils.URL + aboutIndexBean.getData().getHeadimg());
                        tvUsername.setText(String.valueOf(aboutIndexBean.getData().getNickname()));
                        tvLJ.setText(String.valueOf(aboutIndexBean.getData().getLjsy()));
                        tvYE.setText(String.valueOf(aboutIndexBean.getData().getZje()));
                        tvBZJ.setText(String.valueOf(aboutIndexBean.getData().getDjmon()));
                        tvKYJ.setText(String.valueOf(aboutIndexBean.getData().getKymon()));
                        tvKQJ.setText(String.valueOf(aboutIndexBean.getData().getKymon()));

                    } else {
                        EasyToast.showShort(context, aboutIndexBean.getInfo());
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
            default:
                break;
        }
    }
}
