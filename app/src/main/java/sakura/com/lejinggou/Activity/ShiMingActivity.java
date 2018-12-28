package sakura.com.lejinggou.Activity;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.LoginBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EasyToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.Utils.Validator;
import sakura.com.lejinggou.View.CommomDialog;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

/**
 * sakura.com.lejinggou.Activity
 *
 * @author 赵磊
 * @date 2018/12/28
 * 功能描述：
 */
public class ShiMingActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.tv_Title)
    TextView tvTitle;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_idcard)
    EditText etIdcard;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    private Dialog dialog;
    private String is_sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected int setthislayout() {
        return R.layout.activity_shiming_layout;
    }

    @Override
    protected void initview() {
        is_sm = (String) SpUtil.get(context, "is_sm", "");
    }

    @Override
    protected void initListener() {
        rlBack.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        String idcard = (String) SpUtil.get(context, "idcard", "");
        String name = (String) SpUtil.get(context, "name", "");
        etName.setText(name);
        etIdcard.setText(idcard);

        if (is_sm.equals("0")) {

        } else if (is_sm.equals("1")) {

        } else if (is_sm.equals("2")) {

        } else if (is_sm.equals("-1")) {
            String skmsg = (String) SpUtil.get(context, "skmsg", "");
            if (!TextUtils.isEmpty(skmsg)) {
                new CommomDialog(context, R.style.dialog, skmsg, new CommomDialog.OnCloseListener() {
                    @Override
                    public void onClick(Dialog dialog, boolean confirm) {
                        if (confirm) {
                            dialog.dismiss();
                        } else {
                            dialog.dismiss();
                        }
                    }
                }).setTitle("审核失败").show();
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.btn_submit:
                String Idcard = etIdcard.getText().toString().trim();
                String Name = etName.getText().toString().trim();

                if (TextUtils.isEmpty(Name)) {
                    EasyToast.showShort(context, etName.getHint().toString());
                    return;
                }

                if (!Validator.isChinese(Name)) {
                    EasyToast.showShort(context, "请输入汉字姓名");
                    return;
                }

                if (TextUtils.isEmpty(Idcard)) {
                    EasyToast.showShort(context, etIdcard.getHint().toString());
                    return;
                }

                if (!Validator.isIDCard(Idcard)) {
                    EasyToast.showShort(context, etIdcard.getHint().toString());
                    return;
                }

                if (Utils.isConnected(context)) {
                    dialog = Utils.showLoadingDialog(context);
                    dialog.show();
                    getLogin();
                } else {
                    EasyToast.showShort(context, R.string.Networkexception);

                }

                break;
            default:
                break;
        }
    }

    /**
     * 登录获取
     */
    private void getLogin() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        params.put("name", etName.getText().toString().trim());
        params.put("idcard", etIdcard.getText().toString().trim());
        Log.e("LoginActivity", "params:" + params);
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "about/sm" + App.LanguageTYPEHTTP, "about/sm", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = result;
                Log.e("LoginActivity", decode);
                try {
                    dialog.dismiss();
                    LoginBean loginBean = new Gson().fromJson(decode, LoginBean.class);
                    EasyToast.showShort(context, loginBean.getInfo());
                    decode = null;
                    loginBean = null;
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


}
