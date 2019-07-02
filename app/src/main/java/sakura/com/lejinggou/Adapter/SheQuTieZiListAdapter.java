package sakura.com.lejinggou.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import sakura.com.lejinggou.R;


/**
 * Created by 赵磊 on 2017/9/20.
 */

public class SheQuTieZiListAdapter extends RecyclerView.Adapter<SheQuTieZiListAdapter.ViewHolder> {

    Context mContext;
    private ArrayList<String> datas = new ArrayList();

    public ArrayList<String> getDatas() {
        return datas;
    }

    public SheQuTieZiListAdapter(List<String> list, Context context) {
        this.datas = (ArrayList<String>) list;
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

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
