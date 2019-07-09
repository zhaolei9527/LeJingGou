package sakura.com.lejinggou.Adapter;

import android.app.Dialog;
import android.content.Context;
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
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Bean.CodeBean;
import sakura.com.lejinggou.Bean.UserGetBillBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EZToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_jf_order_form_layout, parent, false);
        ViewHolder vp = new ViewHolder(view);
        return vp;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.SimpleDraweeView.setImageURI(datas.get(position).getGoods().getFengmian());
        holder.tvPrice.setText(datas.get(position).getGoods().getNeedintegral());
        holder.tvTitle.setText(datas.get(position).getGoods().getName());
        final String stu = datas.get(position).getState();

        if ("0".equals(stu)) {
//            holder.tv_order_type.setText("待付款");
            holder.llGjPrice.setVisibility(View.VISIBLE);
            holder.llJfPrice.setVisibility(View.GONE);
            holder.llQtPrice.setVisibility(View.GONE);
            holder.btnPayOrder.setVisibility(View.VISIBLE);
            holder.btnIsgetOrder.setVisibility(View.GONE);
            holder.tvTime.setVisibility(View.INVISIBLE);
        } else if ("1".equals(stu)) {
//            holder.tv_order_type.setText("待发货");
            holder.llGjPrice.setVisibility(View.GONE);
            holder.llJfPrice.setVisibility(View.VISIBLE);
            holder.llQtPrice.setVisibility(View.VISIBLE);
            holder.btnPayOrder.setVisibility(View.GONE);
            holder.btnIsgetOrder.setVisibility(View.GONE);

            holder.tvJfPrice.setText(datas.get(position).getHfjf());
            holder.tvQtPrice.setText(datas.get(position).getPrice());
            holder.tvTime.setText("兑换时间:" + datas.get(position).getDate());

        } else if ("2".equals(stu)) {
            holder.llGjPrice.setVisibility(View.GONE);
            holder.llJfPrice.setVisibility(View.VISIBLE);
            holder.llQtPrice.setVisibility(View.VISIBLE);
            holder.btnPayOrder.setVisibility(View.GONE);
            holder.btnIsgetOrder.setVisibility(View.VISIBLE);
            holder.tvJfPrice.setText(datas.get(position).getHfjf());
            holder.tvQtPrice.setText(datas.get(position).getPrice());
            holder.tvTime.setText("兑换时间:" + datas.get(position).getDate());

//            holder.tv_order_type.setText("待收货");
        } else if ("3".equals(stu)) {
//            holder.tv_order_type.setText("已完成");
            holder.llGjPrice.setVisibility(View.GONE);
            holder.llJfPrice.setVisibility(View.VISIBLE);
            holder.llQtPrice.setVisibility(View.VISIBLE);
            holder.btnPayOrder.setVisibility(View.GONE);
            holder.btnIsgetOrder.setVisibility(View.GONE);
            holder.tvJfPrice.setText(datas.get(position).getHfjf());
            holder.tvQtPrice.setText(datas.get(position).getPrice());
            holder.tvTime.setText("兑换时间:" + datas.get(position).getDate());

        } else if ("4".equals(stu)) {
//            holder.tv_order_type.setText("已取消");
            holder.llGjPrice.setVisibility(View.GONE);
            holder.llJfPrice.setVisibility(View.VISIBLE);
            holder.llQtPrice.setVisibility(View.VISIBLE);
            holder.btnPayOrder.setVisibility(View.GONE);
            holder.btnIsgetOrder.setVisibility(View.GONE);
            holder.tvJfPrice.setText(datas.get(position).getHfjf());
            holder.tvQtPrice.setText(datas.get(position).getPrice());
            holder.tvTime.setText("兑换时间:" + datas.get(position).getDate());

        }

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.SimpleDraweeView)
        com.facebook.drawee.view.SimpleDraweeView SimpleDraweeView;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.ll_gj_price)
        LinearLayout llGjPrice;
        @BindView(R.id.tv_jf_price)
        TextView tvJfPrice;
        @BindView(R.id.ll_jf_price)
        LinearLayout llJfPrice;
        @BindView(R.id.tv_qt_price)
        TextView tvQtPrice;
        @BindView(R.id.ll_qt_price)
        LinearLayout llQtPrice;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.btn_pay_order)
        Button btnPayOrder;
        @BindView(R.id.btn_delete_order)
        Button btnDeleteOrder;
        @BindView(R.id.btn_isget_order)
        Button btnIsgetOrder;
        @BindView(R.id.ll_or)
        LinearLayout llOr;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
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
