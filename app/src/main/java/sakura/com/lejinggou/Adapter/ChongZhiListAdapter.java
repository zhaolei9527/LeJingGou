package sakura.com.lejinggou.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Bean.CzmxBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.DateUtils;
import sakura.com.lejinggou.Utils.SpUtil;


/**
 * Created by 赵磊 on 2017/9/20.
 */

public class ChongZhiListAdapter extends RecyclerView.Adapter<ChongZhiListAdapter.ViewHolder> {

    Context mContext;
    private ArrayList<CzmxBean.DataBean> datas = new ArrayList();

    public ArrayList<CzmxBean.DataBean> getDatas() {
        return datas;
    }

    public ChongZhiListAdapter(List<CzmxBean.DataBean> list, Context context) {
        this.datas.addAll(list);
        this.mContext = context;
    }

    public void setDatas(ArrayList datas) {
        this.datas.addAll(datas);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tixianjilu, parent, false);
        ViewHolder vp = new ViewHolder(view);
        return vp;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        String zfbname = (String) SpUtil.get(mContext, "zfbname", "");
        String zfbacc = (String) SpUtil.get(mContext, "zfbacc", "");
        holder.tvBank.setText(zfbname + "：(" + zfbacc + ")");
        holder.tvMoney.setText(datas.get(position).getMoney() + "元");
        holder.tvTime.setText(DateUtils.getMillon(Long.parseLong(datas.get(position).getAddtime()) * 1000));
        holder.tvMsg.setText(datas.get(position).getCause());
        holder.imgMsg.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_bank)
        TextView tvBank;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_money)
        TextView tvMoney;
        @BindView(R.id.img_msg)
        ImageView imgMsg;
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
