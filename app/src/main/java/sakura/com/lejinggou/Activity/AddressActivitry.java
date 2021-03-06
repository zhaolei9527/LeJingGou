package sakura.com.lejinggou.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.HashMap;

import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.AddressIndexBean;
import sakura.com.lejinggou.Bean.CodeBean;
import sakura.com.lejinggou.Bean.SuckleCartDelBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EZToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.View.CommomDialog;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

/**
 * Created by 赵磊 on 2017/9/25.
 */

public class AddressActivitry extends BaseActivity implements View.OnClickListener {

    private FrameLayout rl_back;
    private TextView tv_name;
    private TextView tv_phone;
    private TextView tv_address;
    private CheckBox btnIsChoosed;
    private LinearLayout ll_delete_address;
    private LinearLayout ll_change_address;
    private LinearLayout ll_address_list;
    private Button btn_add_address;
    private RelativeLayout ll_empty;
    private Dialog dialog;
    private String type;

    @Override
    protected int setthislayout() {
        return R.layout.activity_address_layout;
    }

    @Override
    protected void initview() {
        rl_back = (FrameLayout) findViewById(R.id.rl_back);
        ll_address_list = (LinearLayout) findViewById(R.id.ll_address_list);
        btn_add_address = (Button) findViewById(R.id.btn_add_address);
        ll_empty = (RelativeLayout) findViewById(R.id.LL_empty);
    }

    @Override
    protected void initListener() {
        rl_back.setOnClickListener(this);
        btn_add_address.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        type = getIntent().getStringExtra("type");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.btn_add_address:
                startActivity(new Intent(context, AddAdressActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Utils.isConnected(context)) {
            dialog = Utils.showLoadingDialog(context);
            if (!dialog.isShowing()) {
                dialog.show();
            }
            addressIndex();
        } else {
            EZToast.showShort(context, "网络未连接");
        }
    }

    /**
     * 地址列表获取
     */
    private void addressIndex() {
        HashMap<String, String> params = new HashMap<>(2);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "about/dzlist", "about/dzlist", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("RegisterActivity", result);
                try {
                    dialog.dismiss();
                    final AddressIndexBean addressIndexBean = new Gson().fromJson(result, AddressIndexBean.class);
                    if (1 == addressIndexBean.getStatus()) {
                        ll_address_list.removeAllViews();
                        ll_empty.setVisibility(View.GONE);

                        if (null == addressIndexBean.getData() || addressIndexBean.getData().isEmpty()) {
                            ll_empty.setVisibility(View.VISIBLE);
                            return;
                        }

                        for (int i = 0; i < addressIndexBean.getData().size(); i++) {
                            final View item_address = View.inflate(context, R.layout.item_address_layout, null);
                            item_address.setTag(addressIndexBean.getData().get(i).getId());
                            tv_name = (TextView) item_address.findViewById(R.id.tv_name);
                            tv_name.setText(addressIndexBean.getData().get(i).getName());
                            tv_phone = (TextView) item_address.findViewById(R.id.tv_phone);
                            tv_phone.setText(addressIndexBean.getData().get(i).getTel());
                            tv_address = (TextView) item_address.findViewById(R.id.tv_address);
                            StringBuilder stringAddress = new StringBuilder();
                            stringAddress.append(addressIndexBean.getData().get(i).getSsx());
                            stringAddress.append(addressIndexBean.getData().get(i).getAddress());
                            tv_address.setText(stringAddress.toString());
                            btnIsChoosed = (CheckBox) item_address.findViewById(R.id.btnIsChoosed);
                            btnIsChoosed.setTag(addressIndexBean.getData().get(i).getId());
                            if ("1".equals(addressIndexBean.getData().get(i).getIs_mr())) {
                                btnIsChoosed.setChecked(true);
                            } else {
                                btnIsChoosed.setChecked(false);
                            }

                            btnIsChoosed.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    for (int i1 = 0; i1 < ll_address_list.getChildCount(); i1++) {
                                        CheckBox viewById = (CheckBox) (ll_address_list.getChildAt(i1).findViewById(R.id.btnIsChoosed));
                                        if (v.getTag().equals(viewById.getTag())) {
                                            viewById.setChecked(true);
                                        } else {
                                            viewById.setChecked(false);
                                        }
                                    }
                                    if (Utils.isConnected(context)) {
                                        if (dialog != null) {
                                            if (!dialog.isShowing()) {
                                                dialog.show();
                                            }
                                        }
                                        addressQie((String) item_address.getTag());
                                    } else {
                                        EZToast.showShort(context, "网络未连接");
                                    }
                                }
                            });

                            ll_delete_address = (LinearLayout) item_address.findViewById(R.id.ll_delete_address);
                            ll_change_address = (LinearLayout) item_address.findViewById(R.id.ll_change_address);
                            ll_delete_address.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    new CommomDialog(context, R.style.dialog, "您确定删除此地址么？", new CommomDialog.OnCloseListener() {
                                        @Override
                                        public void onClick(Dialog dialog, boolean confirm) {
                                            if (confirm) {
                                                addressDel((String) item_address.getTag());
                                                ll_address_list.removeView(item_address);
                                                dialog.dismiss();
                                            } else {
                                                dialog.dismiss();
                                            }
                                        }
                                    }).setTitle("提示").show();
                                }
                            });

                            ll_change_address.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    for (int i1 = 0; i1 < addressIndexBean.getData().size(); i1++) {
                                        if (item_address.getTag().equals(addressIndexBean.getData().get(i1).getId())) {
                                            Intent intent = new Intent(context, AddAdressActivity.class);
                                            intent.putExtra("id", addressIndexBean.getData().get(i1).getId());
                                            intent.putExtra("name", addressIndexBean.getData().get(i1).getName());
                                            intent.putExtra("tel", addressIndexBean.getData().get(i1).getTel());
                                            intent.putExtra("address", addressIndexBean.getData().get(i1).getAddress());
                                            intent.putExtra("Ssx", addressIndexBean.getData().get(i1).getSsx());
                                            intent.putExtra("IsChoosed", addressIndexBean.getData().get(i1).getIs_mr());
                                            startActivity(intent);
                                        }
                                    }
                                }
                            });

                            if (!TextUtils.isEmpty(type)) {
                                ll_delete_address.setVisibility(View.INVISIBLE);
                                item_address.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        setResult(200, new Intent()
                                                .putExtra("name", tv_name.getText())
                                                .putExtra("phone", tv_phone.getText())
                                                .putExtra("address", tv_address.getText())
                                                .putExtra("addressid", item_address.getTag().toString())
                                        );
                                        finish();
                                    }
                                });
                            }

                            ll_address_list.addView(item_address);
                        }
                    } else {
                        ll_empty.setVisibility(View.VISIBLE);
                    }
                    result = null;
                } catch (Exception e) {
                    dialog.dismiss();
                    e.printStackTrace();
                    Toast.makeText(context, getString(R.string.Abnormalserver), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                error.printStackTrace();
                dialog.dismiss();
                Toast.makeText(context, getString(R.string.Abnormalserver), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 地址删除
     */
    private void addressDel(String id) {
        HashMap<String, String> params = new HashMap<>(3);
        params.put("id", id);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "about/dzdel", "about/dzdel", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("addressDel", result);
                try {
                    CodeBean codeBean = new Gson().fromJson(result, CodeBean.class);
                    if ("1".equals(String.valueOf(codeBean.getStatus()))) {
                        EZToast.showShort(context, "删除成功");
                        if (ll_address_list.getChildCount() == 0) {
                            ll_empty.setVisibility(View.VISIBLE);
                        }
                    }
                    codeBean = null;
                    result = null;
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, getString(R.string.Abnormalserver), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(context, getString(R.string.Abnormalserver), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 默认地址设置
     */
    private void addressQie(String id) {
        HashMap<String, String> params = new HashMap<>(3);
        params.put("id", id);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "about/dzmr", "about/dzmr", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                dialog.dismiss();
                Log.e("RegisterActivity", result);
                try {
                    SuckleCartDelBean SuckleCartDelBean = new Gson().fromJson(result, SuckleCartDelBean.class);
                    if ("1".equals(String.valueOf(SuckleCartDelBean.getStu()))) {
                        EZToast.showShort(context, "设置成功");
                    }
                    SuckleCartDelBean = null;
                    result = null;
                } catch (Exception e) {
                    dialog.dismiss();
                    e.printStackTrace();
                    Toast.makeText(context, getString(R.string.Abnormalserver), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                dialog.dismiss();
                error.printStackTrace();
                Toast.makeText(context, getString(R.string.Abnormalserver), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getQueues().cancelAll("address/del");
        App.getQueues().cancelAll("address/index");
        App.getQueues().cancelAll("address/qie");
        dialog = null;
        System.gc();
    }
}
