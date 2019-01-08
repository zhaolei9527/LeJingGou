package sakura.com.lejinggou.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Activity.MainActivity;
import sakura.com.lejinggou.Activity.PriceDetailsActivity;
import sakura.com.lejinggou.Bean.HomeBean;
import sakura.com.lejinggou.Bean.IndexGoodsBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.DateUtils;
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

    public List getDatas() {
        if (type.equals("1")) {
            return rgBeanList;
        } else if (type.equals("2")) {
            return ygBeanList;
        } else if (type.equals("3")) {
            return lsBeanList;
        } else {
            return new ArrayList();
        }
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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (type.equals("1")) {
            holder.SimpleDraweeView.setImageURI(UrlUtils.URL + rgBeanList.get(position).getFm_img());
            holder.SimpleDraweeView.setTag("1");
            holder.SimpleDraweeView.setTag(UrlUtils.URL + rgBeanList.get(position).getFm_img());
            holder.tvGYS.setText("供应商：" + rgBeanList.get(position).getGys());
            holder.tvMoney.setText("￥" + rgBeanList.get(position).getDqprice());
            holder.tvTitle.setText(rgBeanList.get(position).getName());
            holder.tvTime.setBackground(mContext.getResources().getDrawable(R.mipmap.time_bg));


            ((MainActivity) mContext).mHandler.post(new Runnable() {
                @Override
                public void run() {
                    if (type.equals("1")) {
                        ((MainActivity) mContext).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    if (!rgBeanList.isEmpty()) {
                                        rgBeanList.get(position).setS(rgBeanList.get(position).getS() - 1);
                                        holder.tvTime.setText("距结束：" + getTimeFromInt(rgBeanList.get(position).getS()));
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        });

                        ((MainActivity) mContext).mHandler.postDelayed(this, 1000);

                    }
                }
            });

            holder.llShop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mContext.startActivity(new Intent(mContext, PriceDetailsActivity.class).putExtra("id", rgBeanList.get(position).getId()));
                }
            });

        } else if (type.equals("2")) {
            holder.SimpleDraweeView.setImageURI(UrlUtils.URL + ygBeanList.get(position).getFm_img());
            holder.SimpleDraweeView.setTag("2");
            holder.SimpleDraweeView.setTag(UrlUtils.URL + ygBeanList.get(position).getFm_img());
            holder.tvGYS.setText("供应商：" + ygBeanList.get(position).getGys());
            holder.tvMoney.setText("￥" + ygBeanList.get(position).getDqprice());
            holder.tvTitle.setText(ygBeanList.get(position).getName());
            holder.tvTime.setBackground(mContext.getResources().getDrawable(R.mipmap.yugoutime_bg));

            ((MainActivity) mContext).mHandler.post(new Runnable() {
                @Override
                public void run() {
                    if (type.equals("2")) {
                        ((MainActivity) mContext).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    if (!ygBeanList.isEmpty()) {
                                        if (ygBeanList.get(position).getS() <= 0) {
                                            ygBeanList.remove(position);
                                            notifyDataSetChanged();
                                            return;
                                        }
                                        ygBeanList.get(position).setS(ygBeanList.get(position).getS() - 1);
                                        holder.tvTime.setText("距开始:" + getTimeFromInt(ygBeanList.get(position).getS()));
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        ((MainActivity) mContext).mHandler.postDelayed(this, 1000);
                    }
                }
            });

            holder.llShop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mContext.startActivity(new Intent(mContext, PriceDetailsActivity.class).putExtra("id", ygBeanList.get(position).getId()));
                }
            });

        } else if (type.equals("3")) {
            holder.SimpleDraweeView.setImageURI(UrlUtils.URL + lsBeanList.get(position).getFm_img());
            holder.SimpleDraweeView.setTag("3");
            holder.SimpleDraweeView.setTag(UrlUtils.URL + lsBeanList.get(position).getFm_img());
            holder.tvGYS.setText("供应商：" + lsBeanList.get(position).getGys());
            holder.tvMoney.setText("￥" + lsBeanList.get(position).getDqprice());
            holder.tvTitle.setText(lsBeanList.get(position).getName());
            holder.tvTime.setBackground(mContext.getResources().getDrawable(R.mipmap.jieshutime_bg));
            holder.tvTime.setText("已结束：" + DateUtils.getDay(Long.parseLong(lsBeanList.get(position).getEndtime()) * 1000));

            holder.llShop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mContext.startActivity(new Intent(mContext, PriceDetailsActivity.class).putExtra("id", lsBeanList.get(position).getId()));
                }
            });

        }

    }

    public String getTimeFromInt(long time) {

        if (time <= 0) {
            return "已结束";
        }

        long day = time / (1 * 60 * 60 * 24);
        long hour = time / (1 * 60 * 60) % 24;
        long minute = time / (1 * 60) % 60;
        long second = time / (1) % 60;

        if (day == 0) {
            return hour + "小时" + minute + "分" + second + "秒";
        } else if (hour == 0) {
            return minute + "分" + second + "秒";
        } else if (minute == 0) {
            return second + "秒";
        } else if (second == 0) {
            return "已结束";
        } else if (day != 0) {
            return day + "天" + hour + "小时" + minute + "分" + second + "秒";
        } else {
            return "已结束";
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
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.ll_shop)
        LinearLayout llShop;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
