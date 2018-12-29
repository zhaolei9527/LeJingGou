package sakura.com.lejinggou.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Activity.PriceDetailsActivity;
import sakura.com.lejinggou.Bean.IndexGoodsBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.DateUtils;
import sakura.com.lejinggou.Utils.UrlUtils;

/**
 * com.wenguoyi.Adapter
 *
 * @author 赵磊
 * @date 2018/5/15
 * 功能描述：首页商品列表适配器，包括了头部，轮播，和列表
 */
public class ZuoRiLiShiListAdapter extends RecyclerView.Adapter<ZuoRiLiShiListAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<IndexGoodsBean.DataBean> datas = new ArrayList<IndexGoodsBean.DataBean>();

    public ZuoRiLiShiListAdapter(Context context, List<IndexGoodsBean.DataBean> rgBean) {
        this.mContext = context;
        this.datas.addAll(rgBean);
    }

    public void setDatas(List<IndexGoodsBean.DataBean> dataBeans) {
        this.datas.addAll(dataBeans);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_list_layout, parent, false);
        ViewHolder vp = new ViewHolder(view);
        return vp;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.SimpleDraweeView.setImageURI(UrlUtils.URL + datas.get(position).getFm_img());
        holder.SimpleDraweeView.setTag("3");
        holder.SimpleDraweeView.setTag(UrlUtils.URL + datas.get(position).getFm_img());
        holder.tvGYS.setText("供应商：" + datas.get(position).getGys());
        holder.tvMoney.setText("￥" + datas.get(position).getDqprice());
        holder.tvTitle.setText(datas.get(position).getName());
        holder.tvTime.setBackground(mContext.getResources().getDrawable(R.mipmap.jieshutime_bg));
        holder.tvTime.setText("已结束：" + DateUtils.getMillon(Long.parseLong(datas.get(position).getEndtime()) * 1000));

        holder.llShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext, PriceDetailsActivity.class).putExtra("id", datas.get(position).getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.SimpleDraweeView)
        com.facebook.drawee.view.SimpleDraweeView SimpleDraweeView;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_money)
        TextView tvMoney;
        @BindView(R.id.tv_GYS)
        TextView tvGYS;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.ll_shop)
        LinearLayout llShop;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
