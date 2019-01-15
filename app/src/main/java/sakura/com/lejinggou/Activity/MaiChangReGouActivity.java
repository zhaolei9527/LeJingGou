package sakura.com.lejinggou.Activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alipay.sdk.app.PayTask;
import com.android.volley.VolleyError;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.fangx.haorefresh.LoadMoreListener;
import sakura.com.lejinggou.Adapter.MaiChangReGouListAdapter;
import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.CodeBean;
import sakura.com.lejinggou.Bean.McReGouBean;
import sakura.com.lejinggou.Bean.PayResult;
import sakura.com.lejinggou.Bean.ZfpayBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EasyToast;
import sakura.com.lejinggou.Utils.PriorityRunnable;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.View.ProgressView;
import sakura.com.lejinggou.View.WenguoyiRecycleView;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

/**
 * sakura.com.lejinggou.Activity
 *
 * @author 赵磊
 * @date 2018/12/28
 * 功能描述：
 */
public class MaiChangReGouActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.tv_Title)
    TextView tvTitle;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.SimpleDraweeView_user)
    SimpleDraweeView SimpleDraweeViewUser;
    @BindView(R.id.tv_user)
    TextView tvUser;
    @BindView(R.id.tv_user_money)
    TextView tvUserMoney;
    @BindView(R.id.rv_maichanglist)
    WenguoyiRecycleView rvMaichanglist;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.LL_empty)
    RelativeLayout LLEmpty;
    @BindView(R.id.tv_DJ)
    TextView tvDJ;
    @BindView(R.id.tv_BZJ)
    TextView tvBZJ;
    @BindView(R.id.ll_dijia)
    LinearLayout llDijia;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.img_dismiss)
    ImageView imgDismiss;
    @BindView(R.id.Choosedzhifubao)
    CheckBox Choosedzhifubao;
    @BindView(R.id.Choosedweixin)
    CheckBox Choosedweixin;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    @BindView(R.id.ll_pay)
    LinearLayout llPay;
    @BindView(R.id.ll_JPJG)
    FrameLayout llJPJG;
    @BindView(R.id.tv_YE)
    TextView tvYE;
    @BindView(R.id.tv_MINBZJ)
    TextView tvMINBZJ;
    @BindView(R.id.et_CZ)
    EditText etCZ;
    private LinearLayoutManager line;
    private Dialog dialog;
    private MaiChangReGouListAdapter adapter;
    private String endM;
    private String topM;
    private int pay = 2;
    private String is_jlbzj = "0";

    private static final int SDK_PAY_FLAG = 1;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    Log.e("PayActivity", resultInfo.toString());
                    String resultStatus = payResult.getResultStatus();
                    Log.e("PayActivity", resultStatus.toString());
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        EasyToast.showShort(context, "支付成功");
                        llPay.setVisibility(View.VISIBLE);
                        dialog.show();
                        orderBzj();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        EasyToast.showShort(context, "支付失败，请重试");
                    }
                    break;
                }
                default:
                    break;
            }
        }
    };
    private McReGouBean mcBean;

    @Override
    protected int setthislayout() {
        return R.layout.activity_maichang_regou_layout;
    }

    @Override
    protected void initview() {
        line = new LinearLayoutManager(context);
        line.setOrientation(LinearLayoutManager.VERTICAL);
        rvMaichanglist.setLayoutManager(line);
        rvMaichanglist.setItemAnimator(new DefaultItemAnimator());
        ProgressView progressView = new ProgressView(context);
        progressView.setIndicatorId(ProgressView.BallRotate);
        progressView.setIndicatorColor(getResources().getColor(R.color.colorAccent));
        rvMaichanglist.setFootLoadingView(progressView);
        rvMaichanglist.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {
                dialog.show();
                getMcListEnd(endM);
            }
        });
        TextView textView = new TextView(context);
        textView.setText("-暂无更多-");
        rvMaichanglist.setFootEndView(textView);
        String title = getIntent().getStringExtra("title");
        tvTitle.setText(title);
    }

    @Override
    protected void initListener() {
        rlBack.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        imgDismiss.setOnClickListener(this);
        tvPay.setOnClickListener(this);

        Choosedweixin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    pay = 1;
                    Choosedzhifubao.setChecked(false);
                }
            }
        });

        Choosedzhifubao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    pay = 2;
                    Choosedweixin.setChecked(false);
                }
            }
        });

    }

    @Override
    protected void initData() {
        if (Utils.isConnected(context)) {
            if (dialog == null) {
                dialog = Utils.showLoadingDialog(context);
            }
            dialog.show();
            getMcList();
        } else {
            EasyToast.showShort(context, R.string.Networkexception);

        }

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                App.pausableThreadPoolExecutor.execute(new PriorityRunnable(1) {
                    @Override
                    public void doSth() {
                        getMcListTop(topM);
                    }
                });
                mHandler.postDelayed(this, 1000);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.img_dismiss:
                llPay.setVisibility(View.GONE);
                break;
            case R.id.btn_submit:
                App.pausableThreadPoolExecutor.execute(new PriorityRunnable(1) {
                    @Override
                    public void doSth() {
                        if (is_jlbzj.equals("1")) {
                            orderChujia();
                        } else {
                            orderBzj();
                        }
                    }
                });

                break;
            case R.id.tv_pay:
                String CZ = etCZ.getText().toString().trim();
                if (TextUtils.isEmpty(CZ)) {
                    EasyToast.showShort(context, etCZ.getHint().toString());
                    return;
                }
                if (pay == 0) {
                    EasyToast.showShort(context, "请选择支付方式~");
                    return;
                }
                if (pay == 2) {
                    orderZfpay();
                } else {
                    //orderWxpay();
                }
                break;
            default:
                break;
        }
    }

    /**
     * 出价
     */
    private void orderChujia() {
        HashMap<String, String> params = new HashMap<>(3);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        params.put("gid", String.valueOf(getIntent().getStringExtra("id")));
        Log.e("orderZfpay", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "chujia/index", "chujia/index", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String msg) {
                dialog.dismiss();
                Log.e("orderZfpay", msg);
                try {
                    CodeBean codeBean = new Gson().fromJson(msg, CodeBean.class);
                    if (1 == codeBean.getStatus()) {
                        EasyToast.showShort(context, codeBean.getInfo());
                    } else {
                        EasyToast.showShort(context, codeBean.getInfo());
                    }

                    if (!TextUtils.isEmpty(codeBean.getUrl())) {
                        orderJQR(codeBean.getUrl());
                    }

                    codeBean = null;
                    msg = null;
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

    /**
     * 缴纳保证金
     */
    private void orderBzj() {
        HashMap<String, String> params = new HashMap<>(3);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        params.put("gid", String.valueOf(getIntent().getStringExtra("id")));
        Log.e("orderZfpay", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "chujia/bzj", "chujia/bzj", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String msg) {
                dialog.dismiss();
                Log.e("orderZfpay", msg);
                try {
                    CodeBean codeBean = new Gson().fromJson(msg, CodeBean.class);
                    if (1 == codeBean.getStatus()) {
                        dialog.dismiss();
                        orderChujia();
                    } else if (2 == codeBean.getStatus()) {
                        llPay.setVisibility(View.VISIBLE);
                        EasyToast.showShort(context, "余额不足，请充值~");
                        tvYE.setText("当前账户余额：" + codeBean.getDqmon());
                    } else {
                        //EasyToast.showShort(context, codeBean.getInfo());
                    }
                    msg = null;
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

    /**
     * 机器人出价
     */
    private void orderJQR(String url) {
        HashMap<String, String> params = new HashMap<>(3);
        params.put("gid", String.valueOf(getIntent().getStringExtra("id")));
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + url, url, params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String msg) {
                dialog.dismiss();
                Log.e("orderZfpay", msg);

                CodeBean codeBean = new Gson().fromJson(msg, CodeBean.class);

                if (!TextUtils.isEmpty(codeBean.getUrl())) {
                    orderJQR(codeBean.getUrl());
                }
            }
            @Override
            public void onMyError(VolleyError error) {
                dialog.dismiss();
                error.printStackTrace();
            }
        });
    }


    /**
     * 订单支付，支付宝
     */
    private void orderZfpay() {
        HashMap<String, String> params = new HashMap<>(3);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        params.put("money", etCZ.getText().toString().trim());
        params.put("type", "2");
        Log.e("orderZfpay", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "about/cz", "about/cz", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String msg) {
                dialog.dismiss();
                Log.e("支付宝", msg);
                try {
                    ZfpayBean zfpayBean = new Gson().fromJson(msg, ZfpayBean.class);
                    final ZfpayBean finalZfpayBean = zfpayBean;
                    Runnable payRunnable = new Runnable() {
                        @Override
                        public void run() {
                            PayTask alipay = new PayTask(MaiChangReGouActivity.this);
                            Map<String, String> result = alipay.payV2(finalZfpayBean.getData().getRes(), true);
                            Log.e("msp", result.toString());
                            Message msg = new Message();
                            msg.what = SDK_PAY_FLAG;
                            msg.obj = result;
                            mHandler.sendMessage(msg);
                        }
                    };
                    Thread payThread = new Thread(payRunnable);
                    payThread.start();
                    zfpayBean = null;
                    msg = null;
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

    private void getMcListEnd(final String m) {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("m", m);
        params.put("type", "1");
        params.put("id", String.valueOf(getIntent().getStringExtra("id")));
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        Log.e("NewsListFragment", "params:" + params);
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "goods/mc", "goods/mc", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = result;
                try {
                    dialog.dismiss();
                    Log.e("NewsListFragment", decode);
                    final McReGouBean mcBean = new Gson().fromJson(decode, McReGouBean.class);
                    is_jlbzj = String.valueOf(mcBean.getData().getIs_jlbzj());
                    if (1 == mcBean.getStatus()) {
                        if (null != mcBean.getData().getList() && !mcBean.getData().getList().isEmpty()) {
                            endM = mcBean.getData().getTop();
                            adapter.setDatas((ArrayList) mcBean.getData().getList());
                            rvMaichanglist.loadMoreComplete();
                        } else {
                            rvMaichanglist.loadMoreEnd();
                        }
                    }
                    decode = null;
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

    private void getMcListTop(final String m) {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("m", m);
        params.put("type", "2");
        params.put("id", String.valueOf(getIntent().getStringExtra("id")));
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "goods/mc", "goods/mc", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(final String result) {
                try {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            dialog.dismiss();
                            final McReGouBean mcBean = new Gson().fromJson(result, McReGouBean.class);
                            is_jlbzj = String.valueOf(mcBean.getData().getIs_jlbzj());
                            if (1 == mcBean.getStatus()) {
                                if (!tvUser.getText().equals(mcBean.getData().getUname())) {
                                    SimpleDraweeViewUser.setImageURI(UrlUtils.URL + mcBean.getData().getUheadimg());
                                }
                                tvUser.setText(mcBean.getData().getUname());
                                tvUserMoney.setText("￥" + mcBean.getData().getPrice());
                                if (null != mcBean.getData().getList() && !mcBean.getData().getList().isEmpty()) {
                                    topM = mcBean.getData().getEnd();
                                    if (adapter == null) {
                                        adapter = new MaiChangReGouListAdapter(mcBean.getData().getList(), context);
                                        rvMaichanglist.setAdapter(adapter);
                                        llDijia.setVisibility(View.GONE);
                                    } else {
                                        adapter.setTopDatas((ArrayList) mcBean.getData().getList());
                                        rvMaichanglist.scrollToPosition(0);
                                    }
                                }
                            }
                        }
                    });
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

    private void getMcList() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("m", "");
        params.put("type", "1");
        params.put("id", String.valueOf(getIntent().getStringExtra("id")));
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        Log.e("NewsListFragment", "params:" + params);
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "goods/mc", "goods/mc", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = result;
                try {
                    dialog.dismiss();
                    Log.e("NewsListFragment", decode.toString());
                    mcBean = new Gson().fromJson(decode, McReGouBean.class);
                    is_jlbzj = String.valueOf(mcBean.getData().getIs_jlbzj());


                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mcBean.getData().setS(mcBean.getData().getS() - 1);
                            tvTime.setText("距结束:" + getTimeFromInt(mcBean.getData().getS()));
                            tvTime.setBackgroundColor(context.getResources().getColor(R.color.time));
                            mHandler.postDelayed(this, 1000);
                        }
                    });

                    if (1 == mcBean.getStatus()) {

                        endM = mcBean.getData().getTop();
                        topM = mcBean.getData().getEnd();

                        String content = "<font color=\"#ef1544\">￥" + mcBean.getData().getBzj() + "</font>";
                        tvMINBZJ.setText(Html.fromHtml("拍卖商品当前保证金金额将大于或等于" + content + "，请做好充足的准备。"));

                        LLEmpty.setVisibility(View.GONE);
                        if (!TextUtils.isEmpty(mcBean.getData().getUname())) {
                            SimpleDraweeViewUser.setImageURI(UrlUtils.URL + mcBean.getData().getUheadimg());
                            tvUser.setText(mcBean.getData().getUname());
                            tvUserMoney.setText("￥" + mcBean.getData().getPrice());
                            adapter = new MaiChangReGouListAdapter(mcBean.getData().getList(), context);
                            rvMaichanglist.setAdapter(adapter);
                            llDijia.setVisibility(View.GONE);
                        } else {
                            tvDJ.setText("￥" + mcBean.getData().getDj());
                            tvBZJ.setText("￥" + mcBean.getData().getBzj());
                            llDijia.setVisibility(View.VISIBLE);
                        }
                    } else {
                        rvMaichanglist.setCanloadMore(false);
                        rvMaichanglist.loadMoreEnd();
                    }
                    decode = null;
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

    public String getTimeFromInt(long time) {

        if (time <= 0) {
            return "已结束";
        }

        long day = time / (1 * 60 * 60 * 24);
        long hour = time / (1 * 60 * 60) % 24;
        long minute = time / (1 * 60) % 60;
        long second = time / (1) % 60;

        if (day == 0) {
            return hour + "小时" + minute + "分" + second + "秒";
        } else if (hour == 0) {
            return minute + "分" + second + "秒";
        } else if (minute == 0) {
            return second + "秒";
        } else if (second == 0) {
            return "已结束";
        } else if (day != 0) {
            return day + "天" + hour + "小时" + minute + "分" + second + "秒";
        } else {
            return "已结束";
        }

    }

}
