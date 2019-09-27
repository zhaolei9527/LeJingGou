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
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.CodeBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EZToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

/**
 * com.lingqiapp.Activity
 *
 * @author 赵磊
 * @date 2018/9/14
 * 功能描述：
 */
public class TiXianActivity extends BaseActivity {

    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.tv_Title)
    TextView tvTitle;
    @BindView(R.id.tv_bank)
    TextView tvBank;
    @BindView(R.id.et_money)
    EditText etMoney;
    @BindView(R.id.tv_yue)
    TextView tvYue;
    @BindView(R.id.tv_tixianjilu)
    TextView tvTixianjilu;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_code)
    EditText etCode;
    private Dialog dialog;

    @Override
    protected int setthislayout() {
        return R.layout.activity_tixian_layout;
    }

    @Override
    protected void initview() {
//        String zfbname = (String) SpUtil.get(context, "zfbname", "");
//        String zfbacc = (String) SpUtil.get(context, "zfbacc", "");
        String Kymon = (String) SpUtil.get(context, "Kymon", "");
//        tvBank.setText(zfbname + "：(" + zfbacc + ")");
        tvYue.setText("当前账户最多可提现余额：￥" + Kymon);
    }

    @Override
    protected void initListener() {

        String bankname = (String) SpUtil.get(context, "bankname", "");
        String bankcode = (String) SpUtil.get(context, "bankcode", "");

        if (!TextUtils.isEmpty(bankname)) {
            etName.setText(bankname);
        }

        if (!TextUtils.isEmpty(bankcode)) {
            etCode.setText(bankcode);
        }

        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    EZToast.showShort(context, etName.getHint().toString());
                    return;
                }

                String code = etCode.getText().toString().trim();

                if (TextUtils.isEmpty(code)) {
                    EZToast.showShort(context, etCode.getHint().toString());
                    return;
                }

                String money = etMoney.getText().toString().trim();

                if (TextUtils.isEmpty(money)) {
                    EZToast.showShort(context, etMoney.getHint().toString());
                    return;
                }

                double v = Double.parseDouble(money);

                if (v < 1) {
                    EZToast.showShort(context, "温馨提示：单次提现金额不低于" + 1 + "元");
                    return;
                }

                if (Utils.isConnected(context)) {
                    dialog.show();
                    doJAVATx();
                    //doTx();
                } else {
                    EZToast.showShort(context, R.string.Networkexception);
                }

                SpUtil.putAndApply(context, "bankname", etName.getText().toString().trim());
                SpUtil.putAndApply(context, "bankcode", etCode.getText().toString().trim());

            }
        });

        tvTixianjilu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, MingXiJiLuListActivity.class));
            }
        });

    }

    @Override
    protected void initData() {
        if (Utils.isConnected(context)) {
            dialog = Utils.showLoadingDialog(context);
        } else {
            EZToast.showShort(context, R.string.Networkexception);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private void doJAVATx() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("userid", String.valueOf(SpUtil.get(context, "uid", "")));
        params.put("price", etMoney.getText().toString());
        params.put("carno", etCode.getText().toString());
        params.put("name", etName.getText().toString());
        Log.e("LoginActivity", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.JAVA_URL + "chuangjiantixian", "chuangjiantixian", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = result;
                Log.e("LoginActivity", decode);
                try {
                    dialog.dismiss();
                    CodeBean codeBean = new Gson().fromJson(result, CodeBean.class);
                    EZToast.showShort(context, codeBean.getMsg());
                    if (codeBean.getStatus()==1){
                        onBackPressed();
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


    private void doTx() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        params.put("money", etMoney.getText().toString());
        Log.e("LoginActivity", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "about/tx", "about/tx", params, new VolleyInterface(context) {

            @Override
            public void onMySuccess(String result) {
                String decode = result;
                Log.e("LoginActivity", decode);
                try {
                    dialog.dismiss();
                    CodeBean codeBean = new Gson().fromJson(result, CodeBean.class);
                    EZToast.showShort(context, codeBean.getInfo());
                    etMoney.setText("");
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
}