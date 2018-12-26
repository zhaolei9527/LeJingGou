package sakura.com.lejinggou.Adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Bean.HomeBean;
import sakura.com.lejinggou.Bean.IndexGoodsBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.UrlUtils;

/**
 * com.wenguoyi.Adapter
 *
 * @author 赵磊
 * @date 2018/5/15
 * 功能描述：首页商品列表适配器，包括了头部，轮播，和列表
 */
public class HomeGoodListAdapter extends RecyclerView.Adapter<HomeGoodListAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<HomeBean.DataBean.RgBean> rgBeanList = new ArrayList<HomeBean.DataBean.RgBean>();
    private ArrayList<HomeBean.DataBean.YgBean> ygBeanList = new ArrayList<HomeBean.DataBean.YgBean>();
    private ArrayList<HomeBean.DataBean.LsBean> lsBeanList = new ArrayList<HomeBean.DataBean.LsBean>();
    private String type;

    public HomeGoodListAdapter(Context context, List<HomeBean.DataBean.RgBean> rgBean) {
        this.mContext = context;
        this.type = "1";
        this.rgBeanList.addAll(rgBean);
    }

    public HomeGoodListAdapter(Context context, LinkedList<HomeBean.DataBean.YgBean> rgBean) {
        this.mContext = context;
        this.type = "2";
        this.ygBeanList.addAll(rgBean);
    }

    public HomeGoodListAdapter(Context context, ArrayList<HomeBean.DataBean.LsBean> rgBean) {
        this.mContext = context;
        this.type = "3";
        this.lsBeanList.addAll(rgBean);
    }


    public void datasRemove() {
        rgBeanList.clear();
        ygBeanList.clear();
        lsBeanList.clear();
    }

    public void setDatas(String type, List<IndexGoodsBean.DataBean> dataBeans) {
        this.type = type;
        if (type.equals("1")) {
            for (int i = 0; i < dataBeans.size(); i++) {
                HomeBean.DataBean.RgBean rgBean = new HomeBean.DataBean.RgBean();
                rgBean.setDqprice(dataBeans.get(i).getDqprice());
                rgBean.setEndtime(dataBeans.get(i).getEndtime());
                rgBean.setFm_img(dataBeans.get(i).getFm_img());
                rgBean.setGys(dataBeans.get(i).getGys());
                rgBean.setId(dataBeans.get(i).getId());
                rgBean.setName(dataBeans.get(i).getName());
                rgBean.setS(dataBeans.get(i).getS());
                rgBean.setStarttime(dataBeans.get(i).getStarttime());
                rgBean.setType(dataBeans.get(i).getType());
                this.rgBeanList.add(rgBean);
            }
        } else if (type.equals("2")) {
            for (int i = 0; i < dataBeans.size(); i++) {
                HomeBean.DataBean.YgBean ygBean = new HomeBean.DataBean.YgBean();
                ygBean.setDqprice(dataBeans.get(i).getDqprice());
                ygBean.setEndtime(dataBeans.get(i).getEndtime());
                ygBean.setFm_img(dataBeans.get(i).getFm_img());
                ygBean.setGys(dataBeans.get(i).getGys());
                ygBean.setId(dataBeans.get(i).getId());
                ygBean.setName(dataBeans.get(i).getName());
                ygBean.setS(dataBeans.get(i).getS());
                ygBean.setStarttime(dataBeans.get(i).getStarttime());
                ygBean.setType(dataBeans.get(i).getType());
                this.ygBeanList.add(ygBean);
            }
        } else if (type.equals("3")) {
            for (int i = 0; i < dataBeans.size(); i++) {
                HomeBean.DataBean.LsBean lsBean = new HomeBean.DataBean.LsBean();
                lsBean.setDqprice(dataBeans.get(i).getDqprice());
                lsBean.setEndtime(dataBeans.get(i).getEndtime());
                lsBean.setFm_img(dataBeans.get(i).getFm_img());
                lsBean.setGys(dataBeans.get(i).getGys());
                lsBean.setId(dataBeans.get(i).getId());
                lsBean.setName(dataBeans.get(i).getName());
                lsBean.setS(dataBeans.get(i).getS());
                lsBean.setStarttime(dataBeans.get(i).getStarttime());
                lsBean.setType(dataBeans.get(i).getType());
                this.lsBeanList.add(lsBean);
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_list_layout, parent, false);
        ViewHolder vp = new ViewHolder(view);
        return vp;
    }

    private boolean isfirst = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        if (type.equals("1")) {
            holder.SimpleDraweeView.setImageURI(UrlUtils.URL + rgBeanList.get(position).getFm_img());
            holder.tvGYS.setText("供应商：" + rgBeanList.get(position).getGys());
            holder.tvMoney.setText("￥" + rgBeanList.get(position).getDqprice());
            holder.tvTitle.setText(rgBeanList.get(position).getName());
        } else if (type.equals("2")) {
            holder.SimpleDraweeView.setImageURI(UrlUtils.URL + ygBeanList.get(position).getFm_img());
            holder.tvGYS.setText("供应商：" + ygBeanList.get(position).getGys());
            holder.tvMoney.setText("￥" + ygBeanList.get(position).getDqprice());
            holder.tvTitle.setText(ygBeanList.get(position).getName());
        } else if (type.equals("3")) {
            holder.SimpleDraweeView.setImageURI(UrlUtils.URL + lsBeanList.get(position).getFm_img());
            holder.tvGYS.setText("供应商：" + lsBeanList.get(position).getGys());
            holder.tvMoney.setText("￥" + lsBeanList.get(position).getDqprice());
            holder.tvTitle.setText(lsBeanList.get(position).getName());
        }

    }

    @Override
    public int getItemCount() {
        if (type.equals("1")) {
            return rgBeanList.size();
        } else if (type.equals("2")) {
            return ygBeanList.size();
        } else if (type.equals("3")) {
            return lsBeanList.size();
        } else {
            return 0;
        }
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

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
