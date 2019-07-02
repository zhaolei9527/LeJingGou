package sakura.com.lejinggou.Fragment;

import android.content.Context;
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
import sakura.com.lejinggou.Bean.NewsListBean;
import sakura.com.lejinggou.R;


/**
 * Created by 赵磊 on 2017/9/20.
 */

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {

    Context mContext;
    private ArrayList<NewsListBean.GoodsListBean.ListBean> datas = new ArrayList();

    public ArrayList<NewsListBean.GoodsListBean.ListBean> getDatas() {
        return datas;
    }

    public NewsListAdapter(List<NewsListBean.GoodsListBean.ListBean> list, Context context) {
        this.datas = (ArrayList<NewsListBean.GoodsListBean.ListBean>) list;
        this.mContext = context;
    }

    public void setDatas(ArrayList datas) {
        this.datas.addAll(datas);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_jf_good_layout, parent, false);
        ViewHolder vp = new ViewHolder(view);
        return vp;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.SimpleDraweeView.setImageURI(datas.get(position).getFengmian());
        holder.tvTitle.setText(datas.get(position).getName());
        holder.tvJf.setText("积分价：" + datas.get(position).getNeedintegral());
        holder.tvMoney.setText(datas.get(position).getPrice());
        holder.tvGYS.setText("供应商："+datas.get(position).getSupplier());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.SimpleDraweeView)
        com.facebook.drawee.view.SimpleDraweeView SimpleDraweeView;
        @BindView(R.id.tv_jf)
        TextView tvJf;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_money)
        TextView tvMoney;
        @BindView(R.id.tv_GYS)
        TextView tvGYS;
        @BindView(R.id.ll_shop)
        LinearLayout llShop;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
