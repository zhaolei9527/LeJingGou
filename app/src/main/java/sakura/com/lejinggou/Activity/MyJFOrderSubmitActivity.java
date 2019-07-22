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

import com.android.volley.VolleyError;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.CreateBillBean;
import sakura.com.lejinggou.Bean.JfShopBean;
import sakura.com.lejinggou.Bean.PayResult;
import sakura.com.lejinggou.Bean.UserGetBillByIdBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EZToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;


public class MyJFOrderSubmitActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tv_stu)
    TextView tvStu;
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
    @BindView(R.id.img_checkaddress)
    ImageView imgCheckaddress;
    @BindView(R.id.rl_change_dizhi)
    RelativeLayout rlChangeDizhi;
    @BindView(R.id.ll_address)
    LinearLayout llAddress;
    @BindView(R.id.ll_orders)
    LinearLayout llOrders;
    @BindView(R.id.tv_BZJ)
    TextView tvBZJ;
    @BindView(R.id.tv_ZHJF)
    TextView tvZHJF;
    @BindView(R.id.tv_ZHYE)
    TextView tvZHYE;
    @BindView(R.id.tv_price_total)
    TextView tvPriceTotal;
    @BindView(R.id.tv_wuliu)
    TextView tvWuliu;
    @BindView(R.id.tv_danhao)
    TextView tvDanhao;
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
    @BindView(R.id.rl_suoxuJF)
    RelativeLayout rlSuoxuJF;
    @BindView(R.id.rl_userJF)
    RelativeLayout rlUserJF;
    @BindView(R.id.rl_userYUE)
    RelativeLayout rlUserYUE;
    @BindView(R.id.rl_ZJJF)
    RelativeLayout rlZJJF;
    @BindView(R.id.rl_JFZF)
    RelativeLayout rlJFZF;
    @BindView(R.id.rl_QTZF)
    RelativeLayout rlQTZF;
    @BindView(R.id.rl_WUGS)
    RelativeLayout rlWUGS;
    @BindView(R.id.rl_KDDH)
    RelativeLayout rlKDDH;
    @BindView(R.id.tv_ZJJF)
    TextView tvZJJF;
    @BindView(R.id.tv_JFZF)
    TextView tvJFZF;
    @BindView(R.id.tv_QTZF)
    TextView tvQTZF;
    private String orderid;
    private String order;
    private Dialog dialog;
    private CreateBillBean orderDetailBean;
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
                        EZToast.showShort(context, "支付成功");
                        finish();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        EZToast.showShort(context, "支付失败，请重试");
                    }
                    break;
                }
                default:
                    break;
            }
        }
    };

    private String id;
    private UserGetBillByIdBean userGetBillByIdBean;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getQueues().cancelAll("order/detail");
        System.gc();
    }

    @Override
    protected int setthislayout() {
        return R.layout.activity_my_jf_order_details;
    }

    @Override
    protected void initview() {
        initView();
        orderid = getIntent().getStringExtra("orderid");
        order = getIntent().getStringExtra("order");
        id = getIntent().getStringExtra("id");
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
                if (TextUtils.isEmpty(addressID)) {
                    EZToast.showShort(context, "请选择地址");
                    return;
                }

                dialog.show();

                if (!TextUtils.isEmpty(id)) {
                    orderYuepay();
                } else {
                    orderDetailYuepay();
                }

                break;
            default:
                break;
        }
    }

    private int addressCode = 200;
    private String addressID = "";
    private String name;
    private String phone;
    private String address;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == addressCode) {
            if (data == null) {

            } else {
                tvAddDizhi.setVisibility(View.INVISIBLE);
                tvName.setVisibility(View.VISIBLE);
                tvDizhi.setVisibility(View.VISIBLE);
                tvPhone.setVisibility(View.VISIBLE);
                name = data.getStringExtra("name");
                tvName.setText(name);
                phone = data.getStringExtra("phone");
                tvPhone.setText(phone);
                address = data.getStringExtra("address");
                tvDizhi.setText(address);
                addressID = data.getStringExtra("addressid");
            }
        }

    }

    private String orderResult = "";

    /**
     * 订单详情获取
     */
    private void orderSubmit() {
        HashMap<String, String> params = new HashMap<>(3);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        params.put("goodsid", id);
        params.put("num", "1");
        Log.e("MyOrderDetailsActivity", "createBill" + params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.JAVA_URL + "createBill", "createBill", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                dialog.dismiss();
                orderResult = result;
                Log.e("MyOrderDetailsActivity", result);
                try {

                    rlJFZF.setVisibility(View.GONE);
                    rlQTZF.setVisibility(View.GONE);
                    rlZJJF.setVisibility(View.GONE);
                    rlWUGS.setVisibility(View.GONE);
                    rlKDDH.setVisibility(View.GONE);

                    rlChangeDizhi.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivityForResult(new Intent(context, AddressActivitry.class)
                                    .putExtra("type", "backAddress"), addressCode);
                        }
                    });

                    orderDetailBean = new Gson().fromJson(result, CreateBillBean.class);

                    if (orderDetailBean.getList().getAddress() != null) {
                        tvAddDizhi.setVisibility(View.INVISIBLE);
                        tvName.setVisibility(View.VISIBLE);
                        tvName.setText(orderDetailBean.getList().getAddress().getName());
                        tvDizhi.setVisibility(View.VISIBLE);
                        tvDizhi.setText(orderDetailBean.getList().getAddress().getSsx() + orderDetailBean.getList().getAddress().getAddress());
                        tvPhone.setVisibility(View.VISIBLE);
                        tvPhone.setText(orderDetailBean.getList().getAddress().getTel());
                        //地址id
                        addressID = orderDetailBean.getList().getAddress().getId();
                    } else {
                        tvAddDizhi.setVisibility(View.VISIBLE);
                        tvName.setVisibility(View.INVISIBLE);
                        tvDizhi.setVisibility(View.INVISIBLE);
                        tvPhone.setVisibility(View.INVISIBLE);
                    }

                    tvZHJF.setText(orderDetailBean.getList().getUserjf());
                    tvZHYE.setText("￥" + orderDetailBean.getList().getUsermoney());

                    tvStu.setText("待付款");
                    llPay.setVisibility(View.VISIBLE);
                    llAddress.setVisibility(View.VISIBLE);

                    double Userjf = Double.parseDouble(orderDetailBean.getList().getUserjf());
                    double Needintegral = Double.parseDouble(orderDetailBean.getList().getGoods().getNeedintegral());

                    if (Userjf > Needintegral) {
                        rlLv.setVisibility(View.GONE);
                    }

                    tvPriceTotal.setText("￥" + orderDetailBean.getList().getGoods().getPrice());
                    tvBZJ.setText(orderDetailBean.getList().getGoods().getNeedintegral());

                    final View item_oreder_details_layout = View.inflate(context, R.layout.item_oreder_details_layout, null);
                    item_oreder_details_layout.setTag(orderDetailBean.getList().getGoods().getId());
                    SimpleDraweeView SimpleDraweeView = (com.facebook.drawee.view.SimpleDraweeView) item_oreder_details_layout.findViewById(R.id.SimpleDraweeView);
                    SimpleDraweeView.setImageURI(orderDetailBean.getList().getGoods().getFengmian());
                    final TextView tv_title = (TextView) item_oreder_details_layout.findViewById(R.id.tv_title);
                    tv_title.setText(orderDetailBean.getList().getGoods().getName());
                    TextView tv_classify = (TextView) item_oreder_details_layout.findViewById(R.id.tv_classify);
                    tv_classify.setText("￥" + orderDetailBean.getList().getGoods().getPrice());
                    item_oreder_details_layout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(context, JFPriceDetailsActivity.class);
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


    /**
     * 订单详情获取
     */
    private void orderDetail() {
        HashMap<String, String> params = new HashMap<>(3);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        params.put("id", orderid);
        Log.e("userGetBillById", "userGetBillById" + params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.JAVA_URL + "userGetBillById", "userGetBillById", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                dialog.dismiss();
                orderResult = result;
                Log.e("userGetBillById", result);
                try {

                    userGetBillByIdBean = new Gson().fromJson(result, UserGetBillByIdBean.class);
                    addressID = userGetBillByIdBean.getList().getMpAddress().getId();
                    tvName.setText(userGetBillByIdBean.getList().getMpAddress().getName());
                    tvPhone.setText(userGetBillByIdBean.getList().getMpAddress().getTel());
                    tvDizhi.setText(userGetBillByIdBean.getList().getMpAddress().getAddress());
                    tvZHJF.setText(userGetBillByIdBean.getList().getUser().getSyjf());
                    tvZHYE.setText("￥" + userGetBillByIdBean.getList().getUser().getKymon());
                    tvZJJF.setText(userGetBillByIdBean.getList().getGoods().getName());
                    tvJFZF.setText(userGetBillByIdBean.getList().getHfjf());
                    tvQTZF.setText("¥" + userGetBillByIdBean.getList().getPrice());

                    String stu = userGetBillByIdBean.getList().getState();

                    llPay.setVisibility(View.GONE);
                    if ("0".equals(stu)) {
                        tvStu.setText("待付款");
                        llPay.setVisibility(View.VISIBLE);
                        llAddress.setVisibility(View.VISIBLE);
                        rlSuoxuJF.setVisibility(View.VISIBLE);
                        rlUserJF.setVisibility(View.VISIBLE);
                        rlUserYUE.setVisibility(View.VISIBLE);
                        rlJFZF.setVisibility(View.GONE);
                        rlQTZF.setVisibility(View.GONE);
                        rlZJJF.setVisibility(View.GONE);
                        rlWUGS.setVisibility(View.GONE);
                        rlKDDH.setVisibility(View.GONE);
                    } else if ("1".equals(stu)) {
                        tvStu.setText("待发货");
                        rlSuoxuJF.setVisibility(View.GONE);
                        rlUserJF.setVisibility(View.GONE);
                        rlUserYUE.setVisibility(View.GONE);
                        rlJFZF.setVisibility(View.VISIBLE);
                        rlQTZF.setVisibility(View.VISIBLE);
                        rlZJJF.setVisibility(View.VISIBLE);
                        rlWUGS.setVisibility(View.GONE);
                        rlKDDH.setVisibility(View.GONE);
                    } else if ("2".equals(stu)) {
                        tvStu.setText("待收货");
                        rlSuoxuJF.setVisibility(View.GONE);
                        rlUserJF.setVisibility(View.GONE);
                        rlUserYUE.setVisibility(View.GONE);
                        rlJFZF.setVisibility(View.VISIBLE);
                        rlQTZF.setVisibility(View.VISIBLE);
                        rlZJJF.setVisibility(View.VISIBLE);
                        rlWUGS.setVisibility(View.VISIBLE);
                        rlKDDH.setVisibility(View.VISIBLE);
                    } else if ("3".equals(stu)) {
                        tvStu.setText("已完成");
                        rlSuoxuJF.setVisibility(View.GONE);
                        rlUserJF.setVisibility(View.GONE);
                        rlUserYUE.setVisibility(View.GONE);
                        rlJFZF.setVisibility(View.VISIBLE);
                        rlQTZF.setVisibility(View.VISIBLE);
                        rlZJJF.setVisibility(View.VISIBLE);
                        rlWUGS.setVisibility(View.VISIBLE);
                        rlKDDH.setVisibility(View.VISIBLE);
                    } else if ("4".equals(stu)) {
                        tvStu.setText("已取消");
                        rlSuoxuJF.setVisibility(View.GONE);
                        rlUserJF.setVisibility(View.GONE);
                        rlUserYUE.setVisibility(View.GONE);
                        rlJFZF.setVisibility(View.VISIBLE);
                        rlQTZF.setVisibility(View.VISIBLE);
                        rlZJJF.setVisibility(View.VISIBLE);
                        rlWUGS.setVisibility(View.GONE);
                        rlKDDH.setVisibility(View.GONE);
                        llAddress.setVisibility(View.VISIBLE);
                    } else {
                        tvStu.setText("");
                    }

                    tvPriceTotal.setText("￥" + userGetBillByIdBean.getList().getGoods().getPrice());
                    tvBZJ.setText(userGetBillByIdBean.getList().getGoods().getNeedintegral());

                    if (!TextUtils.isEmpty(userGetBillByIdBean.getList().getKuaidiming())) {
                        tvWuliu.setText(userGetBillByIdBean.getList().getKuaidiming());
                    }

                    if (!TextUtils.isEmpty(userGetBillByIdBean.getList().getKuaidihao())) {
                        tvDanhao.setText(userGetBillByIdBean.getList().getKuaidihao());
                    }

                    final View item_oreder_details_layout = View.inflate(context, R.layout.item_oreder_details_layout, null);
                    item_oreder_details_layout.setTag(userGetBillByIdBean.getList().getGoods().getId());
                    SimpleDraweeView SimpleDraweeView = (com.facebook.drawee.view.SimpleDraweeView) item_oreder_details_layout.findViewById(R.id.SimpleDraweeView);
                    SimpleDraweeView.setImageURI(userGetBillByIdBean.getList().getGoods().getFengmian());
                    final TextView tv_title = (TextView) item_oreder_details_layout.findViewById(R.id.tv_title);
                    tv_title.setText(userGetBillByIdBean.getList().getGoods().getName());
                    TextView tv_classify = (TextView) item_oreder_details_layout.findViewById(R.id.tv_classify);
                    tv_classify.setText("￥" + userGetBillByIdBean.getList().getGoods().getPrice());
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

                if (!TextUtils.isEmpty(id)) {
                    orderSubmit();
                } else {
                    orderDetail();
                }

            } else {
                EZToast.showShort(context, "网络未连接");
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


    private void orderYuepay() {
        HashMap<String, String> params = new HashMap<>(3);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        params.put("addressid", addressID);
        params.put("num", "1");

        double Userjf = Double.parseDouble(orderDetailBean.getList().getUserjf());
        double Needintegral = Double.parseDouble(orderDetailBean.getList().getGoods().getNeedintegral());

        if (Userjf > Needintegral) {
            params.put("jf", orderDetailBean.getList().getGoods().getNeedintegral());
        } else {
            params.put("jf", orderDetailBean.getList().getUserjf());
            if (!ChoosedYue.isChecked()) {
                dialog.dismiss();
                EZToast.showShort(context, "积分不足,请配合余额支付");
                return;
            }
        }

        params.put("oid", orderDetailBean.getList().getOid());

        if (ChoosedYue.isChecked()) {
            params.put("isyue", "1");
        } else {
            params.put("isyue", "0");
        }

        Log.e("orderZfpay", "jfshop" + params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.JAVA_URL + "jfshop", "jfshop", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String msg) {
                dialog.dismiss();
                Log.e("jfshop", msg);
                try {
                    JfShopBean jfShopBean = new Gson().fromJson(msg, JfShopBean.class);
                    if (jfShopBean.getStatus().equals("1")) {
                        EZToast.showShort(context, "支付成功");
                        tvStu.setText("待发货");
                        llPay.setVisibility(View.GONE);
                    } else {
                        EZToast.showShort(context, jfShopBean.getMsg());
                        if (jfShopBean.getMsg().equals("支付失败,余额不足")) {
                            startActivity(new Intent(context, MyChongZhiActivity.class));
                            finish();
                        }
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

    private void orderDetailYuepay() {
        HashMap<String, String> params = new HashMap<>(3);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        params.put("addressid", addressID);
        params.put("num", "1");
        double Userjf = Double.parseDouble(userGetBillByIdBean.getList().getUser().getSyjf());
        double Needintegral = Double.parseDouble(userGetBillByIdBean.getList().getGoods().getNeedintegral());
        if (Userjf > Needintegral) {
            params.put("jf", userGetBillByIdBean.getList().getGoods().getNeedintegral());
        } else {
            params.put("jf", userGetBillByIdBean.getList().getUser().getSyjf());
            if (!ChoosedYue.isChecked()) {
                dialog.dismiss();
                EZToast.showShort(context, "积分不足,请配合余额支付");
                return;
            }
        }
        params.put("oid", userGetBillByIdBean.getList().getId());
        if (ChoosedYue.isChecked()) {
            params.put("isyue", "1");
        } else {
            params.put("isyue", "0");
        }
        Log.e("orderZfpay", "jfshop" + params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.JAVA_URL + "jfshop", "jfshop", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String msg) {
                dialog.dismiss();
                Log.e("jfshop", msg);
                try {
                    JfShopBean jfShopBean = new Gson().fromJson(msg, JfShopBean.class);
                    if (jfShopBean.getStatus().equals("1")) {
                        EZToast.showShort(context, "支付成功");
                        tvStu.setText("待发货");
                        llPay.setVisibility(View.GONE);
                    } else {
                        EZToast.showShort(context, jfShopBean.getMsg());
                        if (jfShopBean.getMsg().equals("支付失败,余额不足")) {
                            startActivity(new Intent(context, MyChongZhiActivity.class));
                            finish();
                        }
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

}
