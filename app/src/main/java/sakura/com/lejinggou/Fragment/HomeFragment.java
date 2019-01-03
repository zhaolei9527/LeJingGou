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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.jude.rollviewpager.hintview.IconHintView;

import java.util.ArrayList;
import java.util.HashMap;

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
import sakura.com.lejinggou.Utils.EasyToast;
import sakura.com.lejinggou.Utils.PriorityRunnable;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
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
    private Context context;
    private GridLayoutManager line;
    private int page = 1;
    private Dialog dialog;
    private ArrayList<String> titleList = new ArrayList<String>();
    private HomeGoodListAdapter adapter;
    private String type = "1";

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
        } else {
            EasyToast.showShort(context, getResources().getString(R.string.Networkexception));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).mHandler.removeCallbacksAndMessages(null);
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
        params.put("zzcn77", "962870");
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
        ((MainActivity) getActivity()).mHandler.removeCallbacksAndMessages(null);
        switch (view.getId()) {
            case R.id.ll_regou:
                if (!type.equals("1")) {
                    type = "1";
                    page = 1;
                    vRegou.setVisibility(View.VISIBLE);
                    vJinri.setVisibility(View.GONE);
                    vJinrilishi.setVisibility(View.GONE);
                    dialog.show();
                    getListData(type);
                }
                break;
            case R.id.ll_jinri:
                if (!type.equals("2")) {
                    type = "2";
                    page = 1;
                    vRegou.setVisibility(View.GONE);
                    vJinri.setVisibility(View.VISIBLE);
                    vJinrilishi.setVisibility(View.GONE);
                    dialog.show();
                    getListData(type);
                }
                break;
            case R.id.ll_jinrilishi:
                if (!type.equals("3")) {
                    type = "3";
                    page = 1;
                    vRegou.setVisibility(View.GONE);
                    vJinri.setVisibility(View.GONE);
                    vJinrilishi.setVisibility(View.VISIBLE);
                    dialog.show();
                    getListData(type);
                }
                break;
            default:
                break;
        }
    }
}
