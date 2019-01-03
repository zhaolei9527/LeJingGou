package sakura.com.lejinggou.Activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alipay.sdk.app.PayTask;
import com.android.volley.VolleyError;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.OrderDetailBean;
import sakura.com.lejinggou.Bean.PayResult;
import sakura.com.lejinggou.Bean.ZfpayBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EasyToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;


public class MyOrderDetailsActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.img_dizhi)
    ImageView imgDizhi;
    @BindView(R.id.tv_check_address)
    TextView tvCheckAddress;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_dizhi)
    TextView tvDizhi;
    @BindView(R.id.tv_add_dizhi)
    TextView tvAddDizhi;
    @BindView(R.id.rl_change_dizhi)
    RelativeLayout rlChangeDizhi;
    @BindView(R.id.tv_stu)
    TextView tvStu;
    @BindView(R.id.img_checkaddress)
    ImageView imgCheckaddress;
    @BindView(R.id.ll_orders)
    LinearLayout llOrders;
    @BindView(R.id.tv_price_total)
    TextView tvPriceTotal;
    @BindView(R.id.tv_BZJ)
    TextView tvBZJ;
    @BindView(R.id.img_weixin)
    ImageView imgWeixin;
    @BindView(R.id.Choosedweixin)
    CheckBox Choosedweixin;
    @BindView(R.id.rl_weixinpay)
    RelativeLayout rlWeixinpay;
    @BindView(R.id.img_yue)
    ImageView imgYue;
    @BindView(R.id.Choosedyue)
    CheckBox Choosedyue;
    @BindView(R.id.rl_yue)
    RelativeLayout rlYue;
    @BindView(R.id.img_lv)
    ImageView imgLv;
    @BindView(R.id.ChoosedYue)
    CheckBox ChoosedYue;
    @BindView(R.id.rl_lv)
    RelativeLayout rlLv;
    @BindView(R.id.btn_paynow)
    Button btnPaynow;
    @BindView(R.id.ll_pay)
    LinearLayout llPay;
    @BindView(R.id.ll_address)
    LinearLayout llAddress;
    @BindView(R.id.tv_wuliu)
    TextView tvWuliu;
    @BindView(R.id.tv_danhao)
    TextView tvDanhao;
    private String orderid;
    private String order;
    private Dialog dialog;
    private OrderDetailBean orderDetailBean;
    String type = "1";

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
                        finish();
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


    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getQueues().cancelAll("order/detail");
        System.gc();
    }

    @Override
    protected int setthislayout() {
        return R.layout.activity_my_order_details;
    }

    @Override
    protected void initview() {
        initView();
        orderid = getIntent().getStringExtra("orderid");
        order = getIntent().getStringExtra("order");
    }

    @Override
    protected void initListener() {
        rlBack.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        isf = true;
    }

    private void initView() {

        imgCheckaddress.setVisibility(View.GONE);
        btnPaynow.setOnClickListener(this);
        Choosedweixin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    type = "1";
                    ChoosedYue.setChecked(false);
                    Choosedyue.setChecked(false);
                }
            }
        });

        ChoosedYue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    type = "3";
                    Choosedweixin.setChecked(false);
                    Choosedyue.setChecked(false);
                }
            }
        });

        Choosedyue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    type = "2";
                    Choosedweixin.setChecked(false);
                    ChoosedYue.setChecked(false);
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.btn_paynow:
                if (type.equals("2")) {
                    dialog.show();
                    orderZfpay();
                } else if (type.equals("1")) {
                    //orderWxpay();
                } else if (type.equals("3")) {
                    dialog.show();
                    orderYuepay();
                }

                break;
            default:
                break;
        }
    }


    /**
     * 订单支付，支付宝
     */
    private void orderZfpay() {
        HashMap<String, String> params = new HashMap<>(3);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        params.put("id", orderDetailBean.getData().getId());
        params.put("type", "2");
        Log.e("orderZfpay", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "about/zf", "about/zf", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String msg) {
                dialog.dismiss();
                Log.e("支付宝", msg);
                try {
                    ZfpayBean zfpayBean = new Gson().fromJson(msg, ZfpayBean.class);
                    if (1 == zfpayBean.getStatus()) {
                        final ZfpayBean finalZfpayBean = zfpayBean;
                        Runnable payRunnable = new Runnable() {
                            @Override
                            public void run() {
                                PayTask alipay = new PayTask(MyOrderDetailsActivity.this);
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
                    } else if (2 == zfpayBean.getStatus()) {
                        EasyToast.showShort(context, zfpayBean.getInfo());
                        finish();
                    } else {
                        EasyToast.showShort(context, zfpayBean.getInfo());
                        if (zfpayBean.getInfo().contains("请选择一个收获地址")) {
                            startActivity(new Intent(context, AddressActivitry.class));
                        }
                    }

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


    private void orderYuepay() {
        HashMap<String, String> params = new HashMap<>(3);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        params.put("id", orderDetailBean.getData().getId());
        params.put("type", "3");
        Log.e("orderZfpay", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "about/zf", "about/zf", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String msg) {
                dialog.dismiss();
                Log.e("支付宝", msg);
                try {
                    ZfpayBean zfpayBean = new Gson().fromJson(msg, ZfpayBean.class);
                    if (1 == zfpayBean.getStatus()) {
                        EasyToast.showShort(context, zfpayBean.getInfo());
                        finish();
                    } else if (2 == zfpayBean.getStatus()) {
                        EasyToast.showShort(context, zfpayBean.getInfo());
                        finish();
                    } else {
                        EasyToast.showShort(context, zfpayBean.getInfo());
                        if (zfpayBean.getInfo().contains("请选择一个收获地址")) {
                            startActivity(new Intent(context, AddressActivitry.class));
                        }
                    }

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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (505 == requestCode) {
            if (200 == resultCode) {
                finish();
            }
        }
    }

    private String orderResult = "";

    /**
     * 订单详情获取
     */
    private void orderDetail() {
        HashMap<String, String> params = new HashMap<>(3);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        params.put("id", orderid);
        Log.e("MyOrderDetailsActivity", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "order/detail", "order/detail", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                dialog.dismiss();
                orderResult = result;
                Log.e("MyOrderDetailsActivity", result);
                try {
                    orderDetailBean = new Gson().fromJson(result, OrderDetailBean.class);
                    tvName.setText(orderDetailBean.getData().getName());
                    tvPhone.setText(orderDetailBean.getData().getTel());
                    tvDizhi.setText(orderDetailBean.getData().getAddress());
                    String stu = orderDetailBean.getData().getStatus();

                    llPay.setVisibility(View.GONE);
                    if ("1".equals(stu)) {
                        tvStu.setText("待付款");
                        llPay.setVisibility(View.VISIBLE);
                        llAddress.setVisibility(View.GONE);
                    } else if ("2".equals(stu)) {
                        tvStu.setText("待发货");
                    } else if ("3".equals(stu)) {
                        tvStu.setText("待收货");
                    } else if ("4".equals(stu)) {
                        tvStu.setText("已完成");
                    } else if ("-1".equals(stu)) {
                        tvStu.setText("已过期");
                        llAddress.setVisibility(View.GONE);
                    } else {
                        tvStu.setText("");
                    }

                    tvPriceTotal.setText("￥" + orderDetailBean.getData().getPrice());
                    tvBZJ.setText("￥" + orderDetailBean.getData().getBzj());

                    if (!TextUtils.isEmpty(orderDetailBean.getData().getKdbh())) {
                        tvWuliu.setText(orderDetailBean.getData().getKdgs());
                    }

                    if (!TextUtils.isEmpty(orderDetailBean.getData().getKdgs())) {
                        tvDanhao.setText(orderDetailBean.getData().getKdbh());
                    }

                    final View item_oreder_details_layout = View.inflate(context, R.layout.item_oreder_details_layout, null);
                    item_oreder_details_layout.setTag(orderDetailBean.getData().getId());
                    SimpleDraweeView SimpleDraweeView = (com.facebook.drawee.view.SimpleDraweeView) item_oreder_details_layout.findViewById(R.id.SimpleDraweeView);
                    SimpleDraweeView.setImageURI(UrlUtils.URL + orderDetailBean.getData().getFm_img());
                    final TextView tv_title = (TextView) item_oreder_details_layout.findViewById(R.id.tv_title);
                    tv_title.setText(orderDetailBean.getData().getGname());
                    TextView tv_classify = (TextView) item_oreder_details_layout.findViewById(R.id.tv_classify);
                    tv_classify.setText("￥" + orderDetailBean.getData().getPrice());
                    item_oreder_details_layout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context, PriceDetailsActivity.class);
                            int tag = Integer.parseInt(item_oreder_details_layout.getTag().toString());
                            intent.putExtra("id", String.valueOf(tag));
                            startActivity(intent);
                        }
                    });
                    llOrders.addView(item_oreder_details_layout);
                    result = null;
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

    public static boolean isf = false;

    @Override
    protected void onResume() {
        super.onResume();
        if (isf) {
            boolean connected = Utils.isConnected(context);
            if (connected) {
                dialog = Utils.showLoadingDialog(context);
                dialog.show();
                orderDetail();
            } else {
                EasyToast.showShort(context, "网络未连接");
                finish();
            }
            isf = !isf;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
