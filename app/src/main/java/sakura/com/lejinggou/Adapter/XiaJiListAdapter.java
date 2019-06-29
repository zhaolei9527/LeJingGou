package sakura.com.lejinggou.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Bean.SelectMpUserBypidjksBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.UrlUtils;


/**
 * Created by 赵磊 on 2017/9/20.
 */

public class XiaJiListAdapter extends RecyclerView.Adapter<XiaJiListAdapter.ViewHolder> {

    Context mContext;
    private ArrayList<SelectMpUserBypidjksBean.ListBeanX.ListBean> datas = new ArrayList();

    public ArrayList<SelectMpUserBypidjksBean.ListBeanX.ListBean> getDatas() {
        return datas;
    }

    public XiaJiListAdapter(List<SelectMpUserBypidjksBean.ListBeanX.ListBean> list, Context context) {
        this.datas.addAll(list);
        this.mContext = context;
    }

    public void setDatas(ArrayList datas) {
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_xiaji, parent, false);
        ViewHolder vp = new ViewHolder(view);
        return vp;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.SimpleDraweeView.setImageURI(UrlUtils.URL + datas.get(position).getHeadimg());
        holder.tvUsername.setText(datas.get(position).getNickname());
        holder.tvLJ.setText("累计收益：￥" + datas.get(position).getLjsy());
        holder.tvJf.setText(datas.get(position).getSyjf());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.SimpleDraweeView)
        com.facebook.drawee.view.SimpleDraweeView SimpleDraweeView;
        @BindView(R.id.tv_username)
        TextView tvUsername;
        @BindView(R.id.tv_jf)
        TextView tvJf;
        @BindView(R.id.tv_LJ)
        TextView tvLJ;
        @BindView(R.id.img_message)
        RelativeLayout imgMessage;
        @BindView(R.id.fl_item)
        FrameLayout flItem;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
