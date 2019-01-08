package sakura.com.lejinggou.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.hss01248.frescopicker.FrescoIniter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.iwf.photopicker.PhotoPickUtils;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.AboutZlBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EasyToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

/**
 * com.lingqiapp.Activity
 *
 * @author 赵磊
 * @date 2018/9/19
 * 功能描述：
 */
public class MyMessageActivity extends BaseActivity {
    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.SimpleDraweeView)
    com.facebook.drawee.view.SimpleDraweeView SimpleDraweeView;
    @BindView(R.id.rl_change_touxiang)
    RelativeLayout rlChangeTouxiang;
    @BindView(R.id.et_nicheng)
    EditText etNicheng;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.tv_qianming)
    EditText tvQianming;
    private Dialog dialog;
    private String pic = "";
    private List<File> imgfiles;
    private List<String> imgnames;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        PhotoPickUtils.onActivityResult(requestCode, resultCode, data, new PhotoPickUtils.PickHandler() {
            @Override
            public void onPickSuccess(final ArrayList<String> photos, int requestCode) {
                switch (requestCode) {
                    case 505:
                        pic = photos.get(0);
                        SimpleDraweeView.setImageURI("file://" + photos.get(0));
                        imgfiles = new ArrayList<>();
                        imgnames = new ArrayList<>();
                        imgfiles.add(new File(pic));
                        imgnames.add("headimg");
                        break;
                    default:
                        break;
                }
                Log.e("MyMessageActivity", photos.get(0));
            }

            @Override
            public void onPreviewBack(ArrayList<String> photos, int requestCode) {
            }

            @Override
            public void onPickFail(String error, int requestCode) {
            }

            @Override
            public void onPickCancle(int requestCode) {
            }
        });
    }

    @Override
    protected int setthislayout() {
        return R.layout.activity_message_layout;
    }

    @Override
    protected void initview() {

        String img = String.valueOf(SpUtil.get(context, "img", ""));
        if (!TextUtils.isEmpty(img)) {
            SimpleDraweeView.setImageURI(UrlUtils.URL + img);
        }

        String uname = String.valueOf(SpUtil.get(context, "uname", ""));
        if (!TextUtils.isEmpty(uname)) {
            etNicheng.setText(uname);
        }

        String qm = String.valueOf(SpUtil.get(context, "qm", ""));
        if (!TextUtils.isEmpty(qm)) {
            tvQianming.setText(qm);
        }

        PhotoPickUtils.init(getApplicationContext(), new FrescoIniter());//第二个参数根据具体依赖库而定
    }

    @Override
    protected void initListener() {
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Nicheng = etNicheng.getText().toString();

                if (TextUtils.isEmpty(Nicheng)) {
                    EasyToast.showShort(context, "用户名不能为空");
                    return;
                }

                if (Utils.isConnected(context)) {
                    dialog.show();
                    userDoinfo(imgnames, imgfiles);
                } else {
                    EasyToast.showShort(context, R.string.Networkexception);
                }

            }
        });

        rlChangeTouxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhotoPickUtils.startPick().setPhotoCount(1).setShowCamera(false).start((MyMessageActivity) context, 505);
            }
        });

        String ne = (String) SpUtil.get(context, "ne", "");

        if (!ne.equals("0")) {
            etNicheng.setFocusable(false);
            etNicheng.setEnabled(false);
        }

    }

    /**
     * 修改个人信息
     */
    private void userDoinfo(List<String> imgnames, List<File> imgs) {
        final HashMap<String, String> params = new HashMap<>(3);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        params.put("nickname", etNicheng.getText().toString());
        params.put("qm", tvQianming.getText().toString());
        Log.e("MyMessageActivity", params.toString());
        VolleyRequest.uploadMultipart(context, UrlUtils.BASE_URL + "about/zl", imgnames, imgs, params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("MyMessageActivity", result);
                try {
                    dialog.dismiss();
                    AboutZlBean aboutZlBean = new Gson().fromJson(result, AboutZlBean.class);

                    EasyToast.showShort(context, aboutZlBean.getInfo());

                    if (1 == aboutZlBean.getStatus()) {
                        SpUtil.putAndApply(context, "img", aboutZlBean.getData().getHeadimg());
                        SpUtil.putAndApply(context, "uname", aboutZlBean.getData().getNickname());
                        SpUtil.putAndApply(context, "qm", aboutZlBean.getData().getQm());
                        SpUtil.putAndApply(context, "ne", "1");
                        etNicheng.setFocusable(false);
                        etNicheng.setEnabled(false);
                    }


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
    protected void onResume() {
        super.onResume();
        if (Utils.isConnected(context)) {
            dialog = Utils.showLoadingDialog(context);
        } else {
            EasyToast.showShort(context, R.string.Networkexception);
        }
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
