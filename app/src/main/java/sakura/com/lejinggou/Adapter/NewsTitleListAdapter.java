package sakura.com.lejinggou.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sakura.com.lejinggou.Activity.NewsDetailsActivity;
import sakura.com.lejinggou.Bean.NewsIndexBean;
import sakura.com.lejinggou.R;

/**
 * com.wenguoyi.Adapter
 *
 * @author 赵磊
 * @date 2018/5/15
 * 功能描述：
 */
public class NewsTitleListAdapter extends RecyclerView.Adapter<NewsTitleListAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<NewsIndexBean.DataBean> datas = new ArrayList();

    public ArrayList<NewsIndexBean.DataBean> getDatas() {
        return datas;
    }

    public NewsTitleListAdapter(Context context, List<NewsIndexBean.DataBean> msgBeen) {
        this.mContext = context;
        this.datas.addAll(msgBeen);
    }

    public void setDatas(List<NewsIndexBean.DataBean> datas) {
        this.datas.addAll(datas);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_news_title_layout, parent, false);
        ViewHolder vp = new ViewHolder(view);
        return vp;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tv_type_title.setText(datas.get(position).getTitle());
        holder.tv_type_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext, NewsDetailsActivity.class).putExtra("url", datas.get(position).getUrl()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_type_title;

        public ViewHolder(View view) {
            super(view);
            this.rootView = view;
            this.tv_type_title = (TextView) rootView.findViewById(R.id.tv_type_title);
        }
    }

}
