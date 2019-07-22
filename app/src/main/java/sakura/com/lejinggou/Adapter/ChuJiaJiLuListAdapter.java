package sakura.com.lejinggou.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Activity.ChuJiaJiLuActivity;
import sakura.com.lejinggou.Bean.GoodsJlBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.DateUtils;
import sakura.com.lejinggou.Utils.UrlUtils;

/**
 * com.wenguoyi.Adapter
 *
 * @author 赵磊
 * @date 2018/5/15
 * 功能描述：
 */
public class ChuJiaJiLuListAdapter extends RecyclerView.Adapter<ChuJiaJiLuListAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<GoodsJlBean.DataBean.ListBean> datas = new ArrayList();

    public ArrayList<GoodsJlBean.DataBean.ListBean> getDatas() {
        return datas;
    }

    public ChuJiaJiLuListAdapter(Context context, List<GoodsJlBean.DataBean.ListBean> msgBeen) {
        this.mContext = context;
        this.datas.addAll(msgBeen);
    }

    public void setDatas(List<GoodsJlBean.DataBean.ListBean> datas) {
        this.datas.addAll(datas);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_chujiajilu_layout, parent, false);
        ViewHolder vp = new ViewHolder(view);
        return vp;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        if (datas.get(position).getHeadimg().startsWith("http")) {
            holder. SimpleDraweeView.setImageURI(datas.get(position).getHeadimg());
        } else {
            holder. SimpleDraweeView.setImageURI(UrlUtils.URL + datas.get(position).getHeadimg());
        }

        holder.tvUser.setText(datas.get(position).getNickname());
        holder.tvTime.setText(DateUtils.getMm(Long.parseLong(datas.get(position).getAddtime()) * 1000));
        holder.tvUserMoney.setText("￥"+datas.get(position).getBs());

        if (position == 0) {
            if (ChuJiaJiLuActivity.type.equals("1")) {
                holder.tvUserType.setText("当前价");
                holder.tvUserType.setTextColor(mContext.getResources().getColor(R.color.textred));
                holder.tvUser.setTextColor(mContext.getResources().getColor(R.color.textred));
                holder.tvUserMoney.setTextColor(mContext.getResources().getColor(R.color.textred));
            } else {
                holder.tvUserType.setText("竞购成功");
                holder.tvUserType.setTextColor(mContext.getResources().getColor(R.color.textred));
                holder.tvUser.setTextColor(mContext.getResources().getColor(R.color.textred));
                holder.tvUserMoney.setTextColor(mContext.getResources().getColor(R.color.textred));
            }
        } else {
            holder.tvUserType.setText("出局");
            holder.tvUserType.setTextColor(mContext.getResources().getColor(R.color.text333));
            holder.tvUser.setTextColor(mContext.getResources().getColor(R.color.text333));
            holder.tvUserMoney.setTextColor(mContext.getResources().getColor(R.color.text333));
        }

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_user)
        TextView tvUser;
        @BindView(R.id.tv_user_money)
        TextView tvUserMoney;
        @BindView(R.id.tv_user_type)
        TextView tvUserType;
        @BindView(R.id.SimpleDraweeView)
        com.facebook.drawee.view.SimpleDraweeView SimpleDraweeView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
