package sakura.com.lejinggou.Adapter;

import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Activity.MainActivity;
import sakura.com.lejinggou.Bean.HomeBean;
import sakura.com.lejinggou.R;

/**
 * com.wenguoyi.Adapter
 *
 * @author 赵磊
 * @date 2018/5/15
 * 功能描述：首页商品列表适配器，包括了头部，轮播，和列表
 */
public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.ViewHolder> {

    private MainActivity mContext;
    private HomeBean homeBean;
    private ArrayList<HomeBean.ListBean> datas = new ArrayList();

    public ArrayList<HomeBean.ListBean> getDatas() {
        return datas;
    }

    public HomeListAdapter(MainActivity context, HomeBean homeBean) {
        this.mContext = context;
        this.homeBean = homeBean;
        datas.addAll(homeBean.getList());
    }

    public void setDatas(List<HomeBean.ListBean> datas) {
        this.datas.addAll(datas);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.home_head_layout, parent, false);
            ViewHolder vp = new ViewHolder(view);
            return vp;
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_shop_layout, parent, false);
            ViewHolder vp = new ViewHolder(view);
            return vp;
        }
    }

    private boolean isfirst = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (position == 0) {
            if (!isfirst) {
                //轮播图设置
                isfirst = !isfirst;
            }
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return datas.size() + 1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Nullable
        @BindView(R.id.RollPagerView)
        com.jude.rollviewpager.RollPagerView RollPagerView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
