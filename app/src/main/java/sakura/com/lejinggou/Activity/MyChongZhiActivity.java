package sakura.com.lejinggou.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EasyToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

/**
 * com.wenguoyi.Activity
 *
 * @author 赵磊
 * @date 2018/5/29
 * 功能描述：
 */
public class MyChongZhiActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.tv_Title)
    TextView tvTitle;
    @BindView(R.id.tv_mingxi)
    TextView tvMingxi;
    @BindView(R.id.tv_bank)
    TextView tvBank;
    @BindView(R.id.et_money)
    EditText etMoney;
    @BindView(R.id.Choosedweixin)
    CheckBox Choosedweixin;
    @BindView(R.id.ll_WX)
    RelativeLayout llWX;
    @BindView(R.id.Choosedzhifubao)
    CheckBox Choosedzhifubao;
    @BindView(R.id.ll_ZFB)
    RelativeLayout llZFB;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    private Dialog dialog;
    private String type = "1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected int setthislayout() {
        return R.layout.activity_mychongzhi_layout;
    }

    @Override
    protected void initview() {
        String kymon = (String) SpUtil.get(context, "Kymon", "");
        tvBank.setText("当前账户余额：￥" + kymon);
    }

    @Override
    protected void initListener() {
        rlBack.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        llWX.setOnClickListener(this);
        llZFB.setOnClickListener(this);
        tvMingxi.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        if (Utils.isConnected(context)) {
            dialog = Utils.showLoadingDialog(context);
        } else {
            EasyToast.showShort(context, R.string.Networkexception);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_mingxi:
                startActivity(new Intent(context, MingXiJiLuListActivity.class));
                break;
            case R.id.btn_submit:

                break;
            case R.id.ll_WX:
                type = "1";
                Choosedweixin.setChecked(true);
                Choosedzhifubao.setChecked(false);
                break;
            case R.id.ll_ZFB:
                type = "1";
                Choosedweixin.setChecked(false);
                Choosedzhifubao.setChecked(true);
                break;
            default:
                break;
        }
    }

    /**
     * 余额获取
     */
    private void userJine() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("pwd", UrlUtils.KEY);
        params.put("type", "1");
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        Log.e("MyChongZhiActivity", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "user/jine", "user/jine", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("MyChongZhiActivity", result);
                try {
                    dialog.dismiss();


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
    protected void onDestroy() {
        super.onDestroy();
        App.getQueues().cancelAll("user/jine");
        //反注册EventBus
        EventBus.getDefault().unregister(MyChongZhiActivity.this);
        System.gc();
    }


}
