package sakura.com.lejinggou.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.jude.rollviewpager.hintview.IconHintView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.fangx.haorefresh.LoadMoreListener;
import sakura.com.lejinggou.Activity.KeFuDetailsActivity;
import sakura.com.lejinggou.Activity.MainActivity;
import sakura.com.lejinggou.Activity.NewsActivity;
import sakura.com.lejinggou.Adapter.HomeGoodListAdapter;
import sakura.com.lejinggou.Adapter.LoopAdapter;
import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseLazyFragment;
import sakura.com.lejinggou.Bean.HomeBean;
import sakura.com.lejinggou.Bean.IndexGoodsBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.DensityUtils;
import sakura.com.lejinggou.Utils.EZToast;
import sakura.com.lejinggou.Utils.PriorityRunnable;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.View.MyGridView;
import sakura.com.lejinggou.View.ProgressView;
import sakura.com.lejinggou.View.VerticalTextview;
import sakura.com.lejinggou.View.WenguoyiRecycleView;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

/**
 * com.wenguoyi.Fragment
 *
 * @author 赵磊
 * @date 2018/5/15
 * 功能描述：
 */
public class HomeFragment extends BaseLazyFragment implements View.OnClickListener {
    Unbinder unbinder;
    @BindView(R.id.RollPagerView)
    com.jude.rollviewpager.RollPagerView RollPagerView;
    @BindView(R.id.tv_news)
    VerticalTextview tvNews;
    @BindView(R.id.v_regou)
    View vRegou;
    @BindView(R.id.ll_regou)
    LinearLayout llRegou;
    @BindView(R.id.v_jinri)
    View vJinri;
    @BindView(R.id.ll_jinri)
    LinearLayout llJinri;
    @BindView(R.id.v_jinrilishi)
    View vJinrilishi;
    @BindView(R.id.ll_jinrilishi)
    LinearLayout llJinrilishi;
    @BindView(R.id.rv_homelist)
    WenguoyiRecycleView rvHomelist;
    @BindView(R.id.LL_empty)
    RelativeLayout LLEmpty;
    @BindView(R.id.img_kefu)
    ImageView imgKefu;
    @BindView(R.id.gv_good_type)
    MyGridView gvGoodType;
    @BindView(R.id.v_all)
    View vAll;
    @BindView(R.id.ll_all)
    LinearLayout llAll;
    private Context context;
    private GridLayoutManager line;
    private int page = 1;
    private Dialog dialog;
    private ArrayList<String> titleList = new ArrayList<String>();
    private HomeGoodListAdapter adapter;
    private String type = "1";
    private SimpleAdapter goodtype;

    @Override
    protected void initPrepare() {

    }

    @Override
    protected void onInvisible() {

    }

    @Override
    protected void initData() {
        if (Utils.isConnected(context)) {
            dialog = Utils.showLoadingDialog(getActivity());
            dialog.show();
            getData();
            llRegou.setOnClickListener(this);
            llJinri.setOnClickListener(this);
            llJinrilishi.setOnClickListener(this);
            llAll.setOnClickListener(this);
        } else {
            EZToast.showShort(context, getResources().getString(R.string.Networkexception));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        dialog.show();
        getListData(type);
    }

    @Override
    protected View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.home_fragment_layout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        rvHomelist = view.findViewById(R.id.rv_homelist);
        LLEmpty = view.findViewById(R.id.LL_empty);
        line = new GridLayoutManager(context, 2);
        line.setOrientation(LinearLayoutManager.VERTICAL);
        rvHomelist.setLayoutManager(line);
        rvHomelist.setItemAnimator(new DefaultItemAnimator());
        ProgressView progressView = new ProgressView(context);
        progressView.setIndicatorId(ProgressView.BallRotate);
        progressView.setIndicatorColor(getResources().getColor(R.color.colorAccent));
        rvHomelist.setFootLoadingView(progressView);
        rvHomelist.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {
                page = page + 1;
                App.pausableThreadPoolExecutor.execute(new PriorityRunnable(1) {
                    @Override
                    public void doSth() {
                        getListData(type);
                    }
                });
            }
        });
        TextView textView = new TextView(context);
        textView.setText(context.getString(R.string.notmore));
        rvHomelist.setFootEndView(textView);

    }

    //数据获取
    public void getData() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("p", String.valueOf(page));
        Log.e("HomeFragment", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "index/index" + App.LanguageTYPEHTTP, "index/index", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("HomeFragment", result);
                try {
                    dialog.dismiss();
                    HomeBean homeBean = new Gson().fromJson(result, HomeBean.class);
                    if (homeBean.getStatus() == 0) {
                        LLEmpty.setVisibility(View.VISIBLE);
                        rvHomelist.setVisibility(View.GONE);
                    } else {
                        LLEmpty.setVisibility(View.GONE);
                        rvHomelist.setVisibility(View.VISIBLE);
                    }

                    //轮播图设置
                    RollPagerView.setHintView(new IconHintView(mContext, R.drawable.shape_selected, R.drawable.shape_noraml, DensityUtils.dp2px(mContext, mContext.getResources().getDimension(R.dimen.x7))));
                    RollPagerView.setPlayDelay(3000);
                    RollPagerView.setAdapter(new LoopAdapter(RollPagerView, homeBean.getData().getImg()));
                    //新闻跑马灯设置
                    //tvContent.setText(26, 5, Color.RED);//设置属性
                    tvNews.setTextStillTime(3000);//设置停留时长间隔
                    tvNews.setAnimTime(300);//设置进入和退出的时间间隔
                    tvNews.setOnItemClickListener(new VerticalTextview.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            //新闻点击事件
                            mContext.startActivity(new Intent(mContext, NewsActivity.class));
                        }
                    });

                    final HomeBean finalHomeBean = homeBean;
                    imgKefu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mContext.startActivity(new Intent(mContext, KeFuDetailsActivity.class).putExtra("url", finalHomeBean.getData().getDyurl()));
                        }
                    });

                    String[] from = {"fengmian", "name"};

                    int[] to = {R.id.SimpleDraweeView, R.id.tv_title};

                    ArrayList<Map<String, String>> dataList = new ArrayList<Map<String, String>>();

                    for (int i = 0; i < finalHomeBean.getData().getType().size(); i++) {
                        Map<String, String> map = new HashMap<String, String>();
                        map.put("fengmian", finalHomeBean.getData().getType().get(i).getFengmian());
                        map.put("name", finalHomeBean.getData().getType().get(i).getName());
                        dataList.add(map);
                    }

                    goodtype = new SimpleAdapter(context, dataList, R.layout.item_home_good_type_layout, from, to);

                    gvGoodType.setAdapter(goodtype);

                    gvGoodType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                                long arg3) {

                        }
                    });

                    for (int i = 0; i < homeBean.getData().getNews().size(); i++) {
                        titleList.add(Utils.Html2Text(homeBean.getData().getNews().get(i).getTitle().toString()));
                    }

                    tvNews.setTextList(titleList);
                    tvNews.startAutoScroll();

                    if (null != homeBean.getData().getRg() && !homeBean.getData().getRg().isEmpty()) {
                        adapter = new HomeGoodListAdapter(mContext, homeBean.getData().getRg());
                        rvHomelist.setAdapter(adapter);
                    } else {
                        adapter = new HomeGoodListAdapter(mContext, new ArrayList<HomeBean.DataBean.RgBean>());
                        rvHomelist.setAdapter(adapter);
                        LLEmpty.setVisibility(View.VISIBLE);
                    }

                    if (null != homeBean.getData().getYg() && !homeBean.getData().getYg().isEmpty()) {

                        final HomeBean finalHomeBean1 = homeBean;

                        new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                try {

                                    while (true) {

                                        sleep(1000);

                                        for (int i = 0; i < finalHomeBean1.getData().getYg().size(); i++) {
                                            int s = finalHomeBean1.getData().getYg().get(i).getS();
                                            if (s == 0) {
                                                s = s - 1;
                                                finalHomeBean1.getData().getYg().get(i).setS(s);
                                                final ArrayList<HomeBean.DataBean.RgBean> rgBeans = new ArrayList<>();
                                                HomeBean.DataBean.YgBean ygBean = finalHomeBean1.getData().getYg().get(i);
                                                final HomeBean.DataBean.RgBean rgBean = new HomeBean.DataBean.RgBean();
                                                rgBean.setType(1);
                                                rgBean.setStarttime(ygBean.getStarttime());
                                                rgBean.setEndtime(ygBean.getEndtime());
                                                rgBean.setName(ygBean.getName());
                                                rgBean.setFm_img(ygBean.getFm_img());
                                                rgBean.setId(ygBean.getId());
                                                rgBean.setGys(ygBean.getGys());
                                                rgBean.setDqprice(ygBean.getDqprice());
                                                rgBean.setS((int) (Long.parseLong(ygBean.getEndtime()) - Long.parseLong(ygBean.getStarttime())));

                                                getActivity().runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {

                                                        if (adapter == null) {
                                                            rgBeans.add(rgBean);
                                                            adapter = new HomeGoodListAdapter(mContext, rgBeans);
                                                            rvHomelist.setAdapter(adapter);
                                                        } else {
                                                            rgBeans.add(rgBean);
                                                            adapter.setRG(rgBeans);
                                                        }
                                                        adapter.notifyDataSetChanged();
                                                    }
                                                });

                                            } else {

                                                if (s >= 0) {
                                                    s = s - 1;
                                                    finalHomeBean1.getData().getYg().get(i).setS(s);
                                                }

                                            }

                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();

                        adapter = new HomeGoodListAdapter(mContext, homeBean.getData().getRg());
                        rvHomelist.setAdapter(adapter);

                    }

                    rvHomelist.loadMoreComplete();
                    homeBean = null;
                    result = null;
                } catch (Exception e) {
                    dialog.dismiss();
                    if (rvHomelist != null) {
                        rvHomelist.loadMoreComplete();
                        rvHomelist.loadMoreEnd();
                        rvHomelist.setCanloadMore(false);
                    }
                    e.printStackTrace();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                dialog.dismiss();
                error.printStackTrace();
            }
        });

    }

    //数据获取
    public void getListData(final String type) {
        App.getQueues().cancelAll("index/goods");
        HashMap<String, String> params = new HashMap<>(1);
        params.put("type", type);
        params.put("p", String.valueOf(page));
        Log.e("HomeFragment", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "index/goods" + App.LanguageTYPEHTTP, "index/goods", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("HomeFragment", result);
                try {
                    dialog.dismiss();
                    rvHomelist.setCanloadMore(true);
                    final IndexGoodsBean indexGoodsBean = new Gson().fromJson(result, IndexGoodsBean.class);

                    if (page == 1) {
                        adapter.datasRemove();
                        adapter.notifyDataSetChanged();
                    }

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (indexGoodsBean.getData() != null) {

                                ((MainActivity) getActivity()).mHandler.removeCallbacksAndMessages(null);

                                adapter.setDatas(type, indexGoodsBean.getData());
                                if (page == 1) {
                                    LLEmpty.setVisibility(View.GONE);
                                }
                            } else {
                                rvHomelist.loadMoreEnd();
                                rvHomelist.setCanloadMore(false);
                                if (page == 1) {
                                    LLEmpty.setVisibility(View.VISIBLE);
                                }
                            }
                        }
                    });

                    rvHomelist.loadMoreComplete();
                    result = null;
                } catch (Exception e) {
                    dialog.dismiss();
                    if (rvHomelist != null) {
                        rvHomelist.loadMoreEnd();
                        rvHomelist.setCanloadMore(false);
                    }
                    e.printStackTrace();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                if (page == 1) {
                    LLEmpty.setVisibility(View.VISIBLE);
                }
                dialog.dismiss();
                error.printStackTrace();
            }
        });

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        App.getQueues().cancelAll("index/index");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_all:
                vAll.setVisibility(View.VISIBLE);
                vRegou.setVisibility(View.GONE);
                vJinri.setVisibility(View.GONE);
                vJinrilishi.setVisibility(View.GONE);
                break;
            case R.id.ll_regou:
                type = "1";
                page = 1;
                vRegou.setVisibility(View.VISIBLE);
                vAll.setVisibility(View.GONE);
                vJinri.setVisibility(View.GONE);
                vJinrilishi.setVisibility(View.GONE);
                dialog.show();
                getListData(type);
                break;
            case R.id.ll_jinri:
                type = "2";
                page = 1;
                vRegou.setVisibility(View.GONE);
                vJinri.setVisibility(View.VISIBLE);
                vJinrilishi.setVisibility(View.GONE);
                vAll.setVisibility(View.GONE);
                dialog.show();
                getListData(type);
                break;
            case R.id.ll_jinrilishi:
                type = "3";
                page = 1;
                vRegou.setVisibility(View.GONE);
                vAll.setVisibility(View.GONE);
                vJinri.setVisibility(View.GONE);
                vJinrilishi.setVisibility(View.VISIBLE);
                dialog.show();
                getListData(type);
                break;
            default:
                break;
        }
    }
}
