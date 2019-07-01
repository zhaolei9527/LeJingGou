package sakura.com.lejinggou.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Activity.JFPriceDetailsActivity;
import sakura.com.lejinggou.Activity.MainActivity;
import sakura.com.lejinggou.Activity.PriceDetailsActivity;
import sakura.com.lejinggou.Bean.IndexAllGoodBean;
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
public class HomeAllGoodListAdapter extends RecyclerView.Adapter<HomeAllGoodListAdapter.ViewHolder> {

    Context mContext;
    private IndexAllGoodBean.DataBean datas;

    public IndexAllGoodBean.DataBean getDatas() {
        return datas;
    }

    public HomeAllGoodListAdapter(IndexAllGoodBean.DataBean list, Context context) {
        this.datas = (IndexAllGoodBean.DataBean) list;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_goods_all, parent, false);
        ViewHolder vp = new ViewHolder(view);
        return vp;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        if (position == 0) {
            holder.tvTitle.setText("积分产品");

            for (int i = 0; i < datas.getJfgoods().size(); i++) {
                View item_jf = LayoutInflater.from(mContext).inflate(R.layout.item_jf_good_layout, holder.llGood, false);
                SimpleDraweeView simpleDraweeView = item_jf.findViewById(R.id.SimpleDraweeView);
                TextView tv_jf = item_jf.findViewById(R.id.tv_jf);
                TextView tv_title = item_jf.findViewById(R.id.tv_title);
                TextView tv_money = item_jf.findViewById(R.id.tv_money);
                TextView tv_GYS = item_jf.findViewById(R.id.tv_GYS);
                simpleDraweeView.setImageURI(datas.getJfgoods().get(i).getFengmian());
                tv_jf.setText("积分价：" + datas.getJfgoods().get(i).getNeedintegral());
                tv_GYS.setText("供应商：" + datas.getJfgoods().get(i).getSupplier());
                tv_title.setText(datas.getJfgoods().get(i).getName());
                tv_money.setText("￥" + datas.getJfgoods().get(i).getPrice());

                final int finalI = i;
                item_jf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mContext.startActivity(new Intent(mContext, JFPriceDetailsActivity.class).putExtra("id", datas.getJfgoods().get(finalI).getId()));
                    }
                });

                holder.llGood.addView(item_jf);
            }

        } else if (position == 1) {
            holder.tvTitle.setText("热购产品");

            if (datas.getRg() != null) {
                for (int i = 0; i < datas.getRg().size(); i++) {
                    View item_jf = LayoutInflater.from(mContext).inflate(R.layout.item_home_all_list_layout, holder.llGood, false);
                    SimpleDraweeView simpleDraweeView = item_jf.findViewById(R.id.SimpleDraweeView);
                    final TextView tv_jf = item_jf.findViewById(R.id.tv_time);
                    TextView tv_title = item_jf.findViewById(R.id.tv_title);
                    TextView tv_money = item_jf.findViewById(R.id.tv_money);
                    TextView tv_GYS = item_jf.findViewById(R.id.tv_GYS);
                    tv_jf.setBackground(mContext.getResources().getDrawable(R.mipmap.time_bg));

                    simpleDraweeView.setImageURI(UrlUtils.URL + datas.getRg().get(i).getFm_img());
                    simpleDraweeView.setTag("1");
                    simpleDraweeView.setTag(UrlUtils.URL + datas.getRg().get(i).getFm_img());
                    tv_GYS.setText("供应商：" + datas.getRg().get(i).getGys());
                    tv_money.setText("￥" + datas.getRg().get(i).getDqprice());
                    tv_title.setText(datas.getRg().get(i).getName());
                    tv_jf.setBackground(mContext.getResources().getDrawable(R.mipmap.time_bg));

                    final int finalI = i;
                    ((MainActivity) mContext).mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            ((MainActivity) mContext).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        if (!datas.getRg().isEmpty()) {
                                            datas.getRg().get(finalI).setS(datas.getRg().get(finalI).getS() - 1);
                                            tv_jf.setText("距结束：" + getTimeFromInt(datas.getRg().get(finalI).getS()));
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                }
                            });

                            ((MainActivity) mContext).mHandler.postDelayed(this, 1000);

                        }
                    });

                    item_jf.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mContext.startActivity(new Intent(mContext, PriceDetailsActivity.class).putExtra("id", datas.getRg().get(finalI).getId()));
                        }
                    });

                    holder.llGood.addView(item_jf);
                }
            }

        } else if (position == 2) {
            holder.tvTitle.setText("预售产品");

            if (datas.getYg() != null) {

                for (int i = 0; i < datas.getYg().size(); i++) {
                    View item_jf = LayoutInflater.from(mContext).inflate(R.layout.item_home_all_list_layout, holder.llGood, false);
                    SimpleDraweeView simpleDraweeView = item_jf.findViewById(R.id.SimpleDraweeView);
                    final TextView tv_jf = item_jf.findViewById(R.id.tv_time);
                    TextView tv_title = item_jf.findViewById(R.id.tv_title);
                    TextView tv_money = item_jf.findViewById(R.id.tv_money);
                    TextView tv_GYS = item_jf.findViewById(R.id.tv_GYS);

                    simpleDraweeView.setImageURI(UrlUtils.URL + datas.getYg().get(i).getFm_img());
                    simpleDraweeView.setTag("2");
                    simpleDraweeView.setTag(UrlUtils.URL + datas.getYg().get(i).getFm_img());
                    tv_GYS.setText("供应商：" + datas.getYg().get(i).getGys());
                    tv_money.setText("￥" + datas.getYg().get(i).getDqprice());
                    tv_title.setText(datas.getYg().get(i).getName());
                    tv_jf.setBackground(mContext.getResources().getDrawable(R.mipmap.yugoutime_bg));

                    final int finalI = i;
                    ((MainActivity) mContext).mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            ((MainActivity) mContext).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        if (!datas.getYg().isEmpty()) {
                                            if (datas.getYg().get(finalI).getS() <= 0) {
                                                datas.getYg().remove(finalI);
                                                notifyDataSetChanged();
                                                return;
                                            }
                                            datas.getYg().get(finalI).setS(datas.getYg().get(finalI).getS() - 1);
                                            tv_jf.setText("距开始:" + getTimeFromInt(datas.getYg().get(finalI).getS()));
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            ((MainActivity) mContext).mHandler.postDelayed(this, 1000);
                        }
                    });

                    item_jf.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mContext.startActivity(new Intent(mContext, PriceDetailsActivity.class).putExtra("id", datas.getYg().get(finalI).getId()));
                        }
                    });

                    holder.llGood.addView(item_jf);
                }
            }

        } else if (position == 3) {
            holder.tvTitle.setText("历史产品");

            if (datas.getLs() != null) {
                for (int i = 0; i < datas.getLs().size(); i++) {
                    View item_jf = LayoutInflater.from(mContext).inflate(R.layout.item_home_all_list_layout, holder.llGood, false);
                    SimpleDraweeView simpleDraweeView = item_jf.findViewById(R.id.SimpleDraweeView);
                    TextView tv_jf = item_jf.findViewById(R.id.tv_time);
                    TextView tv_title = item_jf.findViewById(R.id.tv_title);
                    TextView tv_money = item_jf.findViewById(R.id.tv_money);
                    TextView tv_GYS = item_jf.findViewById(R.id.tv_GYS);

                    simpleDraweeView.setImageURI(UrlUtils.URL + datas.getLs().get(i).getFm_img());
                    simpleDraweeView.setTag("3");
                    simpleDraweeView.setTag(UrlUtils.URL + datas.getLs().get(i).getFm_img());
                    tv_GYS.setText("供应商：" + datas.getLs().get(i).getGys());
                    tv_money.setText("￥" + datas.getLs().get(i).getDqprice());
                    tv_title.setText(datas.getLs().get(i).getName());
                    tv_jf.setBackground(mContext.getResources().getDrawable(R.mipmap.jieshutime_bg));
                    tv_jf.setText("已结束：" + DateUtils.getDay(Long.parseLong(datas.getLs().get(i).getEndtime()) * 1000));

                    final int finalI = i;
                    item_jf.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mContext.startActivity(new Intent(mContext, PriceDetailsActivity.class).putExtra("id", datas.getLs().get(finalI).getId()));
                        }
                    });

                    holder.llGood.addView(item_jf);
                }
            }

        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    //自定义的ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.ll_more)
        LinearLayout llMore;
        @BindView(R.id.ll_good_list)
        LinearLayout llGood;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
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


}
