package sakura.com.lejinggou.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Bean.McReGouBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.DateUtils;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;


/**
 * Created by 赵磊 on 2017/9/20.
 */

public class MaiChangReGouListAdapter extends RecyclerView.Adapter<MaiChangReGouListAdapter.ViewHolder> {

    Context mContext;
    private ArrayList<McReGouBean.DataBean.ListBean> datas = new ArrayList();

    public ArrayList<McReGouBean.DataBean.ListBean> getDatas() {
        return datas;
    }

    public MaiChangReGouListAdapter(List<McReGouBean.DataBean.ListBean> list, Context context) {
        this.datas.addAll(list);
        this.mContext = context;
    }

    public void setDatas(ArrayList datas) {
        this.datas.addAll(datas);
    }

    public void setTopDatas(ArrayList<McReGouBean.DataBean.ListBean> datas) {
        Collections.reverse(datas);
        for (int i = 0; i < datas.size(); i++) {
            this.datas.add(0, datas.get(i));
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {

        String uid = datas.get(position).getUid();
        if (!TextUtils.isEmpty(uid)) {
            if (String.valueOf(SpUtil.get(mContext, "uid", "")).equals(uid)) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 2;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_my_maichang_list_layout, parent, false);
            ViewHolder vp = new ViewHolder(view);
            return vp;
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_maichang_list_layout, parent, false);
            ViewHolder vp = new ViewHolder(view);
            return vp;
        }
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvTime.setText(DateUtils.getMillon(Long.parseLong(datas.get(position).getAddtime()) * 1000));
        holder.SimpleDraweeViewUser.setImageURI(UrlUtils.URL + datas.get(position).getHeadimg());
        holder.tvUser.setText(datas.get(position).getNickname());
        //首先是拼接字符串
        String content = "<font color=\"#ef1544\">￥" + datas.get(position).getBs() + "</font>";
        holder.tvMoney.setText(Html.fromHtml("出价：" + content + ",将会 获得" + datas.get(position).getSy() + "元奖励金"));

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.SimpleDraweeView_user)
        SimpleDraweeView SimpleDraweeViewUser;
        @BindView(R.id.tv_user)
        TextView tvUser;
        @BindView(R.id.tv_money)
        EditText tvMoney;
        @BindView(R.id.ll_JPJG)
        LinearLayout llJPJG;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}