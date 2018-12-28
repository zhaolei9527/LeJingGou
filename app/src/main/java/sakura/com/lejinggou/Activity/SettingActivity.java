package sakura.com.lejinggou.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EasyToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.View.CommomDialog;

/**
 * sakura.com.lejinggou.Activity
 *
 * @author 赵磊
 * @date 2018/12/28
 * 功能描述：
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.tv_Title)
    TextView tvTitle;
    @BindView(R.id.ll_GRZL)
    LinearLayout llGRZL;
    @BindView(R.id.ll_SMRZ)
    LinearLayout llSMRZ;
    @BindView(R.id.ll_ZFB)
    LinearLayout llZFB;
    @BindView(R.id.ll_ChangePwd)
    LinearLayout llChangePwd;
    @BindView(R.id.ll_ChangeAddress)
    LinearLayout llChangeAddress;
    @BindView(R.id.btn_exit)
    Button btnExit;
    @BindView(R.id.tv_zfb)
    TextView tvZfb;
    @BindView(R.id.tv_sm)
    TextView tvSm;
    private String is_sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected int setthislayout() {
        return R.layout.activity_setting_layout;
    }

    @Override
    protected void initview() {
        is_sm = (String) SpUtil.get(context, "is_sm", "");
        String zfbacc = (String) SpUtil.get(context, "zfbacc", "");
        String name = (String) SpUtil.get(context, "name", "");
        tvZfb.setText(zfbacc);
    }

    @Override
    protected void initListener() {

        rlBack.setOnClickListener(this);
        llChangeAddress.setOnClickListener(this);
        llChangePwd.setOnClickListener(this);
        llGRZL.setOnClickListener(this);
        llSMRZ.setOnClickListener(this);
        llZFB.setOnClickListener(this);
        btnExit.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.ll_GRZL:
                startActivity(new Intent(context, MyMessageActivity.class));
                break;
            case R.id.ll_SMRZ:
                if (is_sm.equals("0")) {
                    startActivity(new Intent(context, ShiMingActivity.class));
                } else if (is_sm.equals("1")) {
                    EasyToast.showShort(context, "审核中");
                } else if (is_sm.equals("2")) {
                    startActivity(new Intent(context, ShiMingActivity.class));
                } else if (is_sm.equals("-1")) {
                    startActivity(new Intent(context, ShiMingActivity.class));
                }
                break;
            case R.id.ll_ZFB:
                if (TextUtils.isEmpty(tvZfb.getText().toString())) {
                    startActivity(new Intent(context, ZhiFuBaoActivity.class));
                }
                break;
            case R.id.ll_ChangePwd:
                startActivity(new Intent(context, ChangePasswordActivity.class));
                break;
            case R.id.ll_ChangeAddress:
                startActivity(new Intent(context, MyMessageActivity.class));
                break;
            case R.id.btn_exit:
                new CommomDialog(context, R.style.dialog, "您确定退出登录么？", new CommomDialog.OnCloseListener() {
                    @Override
                    public void onClick(Dialog dialog, final boolean confirm) {
                        if (confirm) {
                            dialog.dismiss();
                        } else {
                            dialog.dismiss();
                            SpUtil.clear(context);
                            Intent intent = new Intent(context, LoginActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    }
                }).setTitle("提示").show();
                break;
            default:

                break;

        }
    }
}
