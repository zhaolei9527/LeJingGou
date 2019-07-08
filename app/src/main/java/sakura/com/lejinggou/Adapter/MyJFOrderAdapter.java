package sakura.com.lejinggou.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sakura.com.lejinggou.Activity.MyOrderDetailsActivity;
import sakura.com.lejinggou.Bean.CodeBean;
import sakura.com.lejinggou.Bean.UserGetBillBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EZToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.View.CommomDialog;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;


/**
 * Created by 赵磊 on 2017/9/20.
 */

public class MyJFOrderAdapter extends RecyclerView.Adapter<MyJFOrderAdapter.ViewHolder> {

    Context mContext;
    private ArrayList<UserGetBillBean.ListBeanX.ListBean> datas = new ArrayList();
    private Dialog dialog;

    public ArrayList<UserGetBillBean.ListBeanX.ListBean> getDatas() {
        return datas;
    }

    public MyJFOrderAdapter(Context context, List<UserGetBillBean.ListBeanX.ListBean> list) {
        this.datas.addAll(list);
        this.mContext = context;
    }

    public void setDatas(List<UserGetBillBean.ListBeanX.ListBean> datas) {
        this.datas.addAll(datas);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_order_form_layout, parent, false);
        ViewHolder vp = new ViewHolder(view);
        return vp;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tv_order_form_time.setText("订单编号：" + datas.get(position).getId());
        holder.tv_order_content.setText("共1件商品 兑换积分:￥" + datas.get(position).getGoods().getNeedintegral());

        holder.ll_oreders.removeAllViews();
        final String stu = datas.get(position).getGoods().getState();
        if ("0".equals(stu)) {
            holder.tv_order_type.setText("待付款");
            holder.btn_pay_order.setVisibility(View.VISIBLE);
            holder.btn_isget_order.setVisibility(View.GONE);
            holder.btn_delete_order.setVisibility(View.GONE);
        } else if ("1".equals(stu)) {
            holder.tv_order_type.setText("待发货");
            holder.btn_delete_order.setVisibility(View.GONE);
            holder.btn_pay_order.setVisibility(View.GONE);
            holder.btn_isget_order.setVisibility(View.GONE);
        } else if ("2".equals(stu)) {
            holder.btn_delete_order.setVisibility(View.GONE);
            holder.btn_pay_order.setVisibility(View.GONE);
            holder.btn_isget_order.setVisibility(View.VISIBLE);
            holder.tv_order_type.setText("待收货");
        } else if ("3".equals(stu)) {
            holder.tv_order_type.setText("已完成");
            holder.btn_pay_order.setVisibility(View.GONE);
            holder.btn_isget_order.setVisibility(View.GONE);
            holder.btn_delete_order.setVisibility(View.GONE);
        } else if ("4".equals(stu)) {
            holder.tv_order_type.setText("已取消");
            holder.btn_pay_order.setVisibility(View.GONE);
            holder.btn_isget_order.setVisibility(View.GONE);
            holder.btn_delete_order.setVisibility(View.GONE);
        }

        if ("10".equals(stu)) {
            ViewGroup.LayoutParams layoutParams = holder.ll_or.getLayoutParams();
            layoutParams.height = 0;
            holder.ll_or.setLayoutParams(layoutParams);
        }

        View item_oreder_layout = View.inflate(mContext, R.layout.item_orederlist_layout, null);

        SimpleDraweeView SimpleDraweeView = (com.facebook.drawee.view.SimpleDraweeView) item_oreder_layout.findViewById(R.id.SimpleDraweeView);
        SimpleDraweeView.setImageURI(datas.get(position).getGoods().getFengmian());
        TextView tv_title = (TextView) item_oreder_layout.findViewById(R.id.tv_title);
        tv_title.setText(datas.get(position).getGoods().getName());
        TextView tv_price = (TextView) item_oreder_layout.findViewById(R.id.tv_price);
        tv_price.setText("￥" + datas.get(position).getGoods().getPrice());
        holder.ll_oreders.addView(item_oreder_layout);

        holder.btn_pay_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = Utils.showLoadingDialog(mContext);
                dialog.show();
                mContext.startActivity(new Intent(mContext, MyOrderDetailsActivity.class)
                        .putExtra("orderid", datas.get(position).getId())
                );
                dialog.dismiss();
            }
        });

        holder.btn_delete_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CommomDialog(mContext, R.style.dialog, "确定取消订单吗？", new CommomDialog.OnCloseListener() {
                    @Override
                    public void onClick(Dialog dialog, boolean confirm) {
                        if (confirm) {
                            dialog.dismiss();
                        } else {
                            dialog.dismiss();
                            orderCancel(datas.get(position).getId());
                            datas.get(position).setState("10");
                            notifyDataSetChanged();
                        }
                    }
                }).setTitle("提示").show();
            }
        });

        holder.btn_isget_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datas.get(position).setState("3");
                notifyItemChanged(position);
                orderReceipt(datas.get(position).getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_order_form_time;
        public TextView tv_order_type;
        public TextView tv_order_content;
        public Button btn_pay_order;
        public Button btn_isget_order;
        public LinearLayout ll_oreders;
        public LinearLayout ll_or;

        public Button btn_delete_order;

        public ViewHolder(View itemView) {
            super(itemView);
            this.rootView = itemView;
            this.btn_delete_order = (Button) rootView.findViewById(R.id.btn_delete_order);
            this.tv_order_form_time = (TextView) rootView.findViewById(R.id.tv_order_form_time);
            this.tv_order_type = (TextView) rootView.findViewById(R.id.tv_order_type);
            this.tv_order_content = (TextView) rootView.findViewById(R.id.tv_order_content);
            this.btn_pay_order = (Button) rootView.findViewById(R.id.btn_pay_order);
            this.btn_isget_order = (Button) rootView.findViewById(R.id.btn_isget_order);
            this.ll_oreders = (LinearLayout) rootView.findViewById(R.id.ll_oreders);
            this.ll_or = (LinearLayout) rootView.findViewById(R.id.ll_or);
        }
    }

    /**
     * 订单取消
     */
    private void orderCancel(String id) {
        HashMap<String, String> params = new HashMap<>(3);
        params.put("uid", String.valueOf(SpUtil.get(mContext, "uid", "")));
        params.put("id", id);
        VolleyRequest.RequestPost(mContext, UrlUtils.BASE_URL + "order/quxiao", "order/quxiao", params, new VolleyInterface(mContext) {
            @Override
            public void onMySuccess(String result) {
                Log.e("RegisterActivity", result);
                try {
                    CodeBean orderCancelBean = new Gson().fromJson(result, CodeBean.class);
                    if ("1".equals(String.valueOf(orderCancelBean.getStatus()))) {
                        Toast.makeText(mContext, "取消成功", Toast.LENGTH_SHORT).show();
                    } else {
                        EZToast.showShort(mContext, orderCancelBean.getInfo());
                    }
                    result = null;
                    orderCancelBean = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                error.printStackTrace();
            }
        });
    }


    /**
     * 确认收货
     */
    private void orderReceipt(String id) {
        HashMap<String, String> params = new HashMap<>(3);
        params.put("uid", String.valueOf(SpUtil.get(mContext, "uid", "")));
        params.put("id", id);
        Log.e("MyOrderAdapter", "params:" + params);
        VolleyRequest.RequestPost(mContext, UrlUtils.BASE_URL + "order/sh", "order/sh", params, new VolleyInterface(mContext) {
            @Override
            public void onMySuccess(String result) {
                Log.e("RegisterActivity", result);
                try {
                    CodeBean suckleCartDelBean = new Gson().fromJson(result, CodeBean.class);
                    if ("1".equals(String.valueOf(suckleCartDelBean.getStatus()))) {
                        EZToast.showShort(mContext, "确认收货成功");
                    } else {
                        EZToast.showShort(mContext, "确认收货失败");
                    }
                    result = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                error.printStackTrace();
            }
        });
    }

}
