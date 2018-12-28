package sakura.com.lejinggou.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Bean.SymxBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.DateUtils;


/**
 * Created by 赵磊 on 2017/9/20.
 */

public class ShouYiListAdapter extends RecyclerView.Adapter<ShouYiListAdapter.ViewHolder> {

    Context mContext;
    private ArrayList<SymxBean.DataBean> datas = new ArrayList();

    public ArrayList<SymxBean.DataBean> getDatas() {
        return datas;
    }

    public ShouYiListAdapter(List<SymxBean.DataBean> list, Context context) {
        this.datas.addAll(list);
        this.mContext = context;
    }

    public void setDatas(ArrayList datas) {
        this.datas.addAll(datas);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_yongjin, parent, false);
        ViewHolder vp = new ViewHolder(view);
        return vp;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvTitle.setText(datas.get(position).getGname());
        holder.tvMoney.setText("￥" + datas.get(position).getBs());
        holder.tvTime.setText(DateUtils.getMillon(Long.parseLong(datas.get(position).getAddtime()) * 1000));
        holder.tvMsg.setText("收益：" + datas.get(position).getSy() + "元");
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_money)
        TextView tvMoney;
        @BindView(R.id.tv_msg)
        TextView tvMsg;
        @BindView(R.id.fl_item)
        FrameLayout flItem;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
