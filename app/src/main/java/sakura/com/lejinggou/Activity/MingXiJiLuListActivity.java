package sakura.com.lejinggou.Activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.fangx.haorefresh.LoadMoreListener;
import sakura.com.lejinggou.Adapter.ChongZhiListAdapter;
import sakura.com.lejinggou.Adapter.ShouYiListAdapter;
import sakura.com.lejinggou.Adapter.TiXianListAdapter;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.CzmxBean;
import sakura.com.lejinggou.Bean.SymxBean;
import sakura.com.lejinggou.Bean.TixianLogBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EZToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.View.ProgressView;
import sakura.com.lejinggou.View.SakuraLinearLayoutManager;
import sakura.com.lejinggou.View.WenguoyiRecycleView;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

/**
 * com.lingqiapp.Activity
 *
 * @author 赵磊
 * @date 2018/9/14
 * 功能描述：
 */
public class MingXiJiLuListActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.rv_txjl_list)
    WenguoyiRecycleView rvTxjlList;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.LL_empty)
    RelativeLayout LLEmpty;
    @BindView(R.id.tv_TX)
    TextView tvTX;
    @BindView(R.id.tv_CZ)
    TextView tvCZ;
    @BindView(R.id.tv_YJ)
    TextView tvYJ;
    @BindView(R.id.rv_czjl_list)
    WenguoyiRecycleView rvCzjlList;
    @BindView(R.id.rv_yjjl_list)
    WenguoyiRecycleView rvYjjlList;
    private TiXianListAdapter adapter;
    private ChongZhiListAdapter chongZhiListAdapter;
    private ShouYiListAdapter shouYiListAdapter;
    private SakuraLinearLayoutManager line;
    private SakuraLinearLayoutManager line2;
    private SakuraLinearLayoutManager line3;
    private Dialog dialog;
    private int p = 1;
    private int p2 = 1;
    private int p3 = 1;
    private String type = "1";

    @Override
    protected int setthislayout() {
        return R.layout.activity_mingxijilu_list;
    }

    @Override
    protected void initview() {
        line = new SakuraLinearLayoutManager(context);
        line.setOrientation(LinearLayoutManager.VERTICAL);
        rvTxjlList.setLayoutManager(line);
        rvTxjlList.setItemAnimator(new DefaultItemAnimator());
        ProgressView progressView = new ProgressView(context);
        progressView.setIndicatorId(ProgressView.BallRotate);
        progressView.setIndicatorColor(getResources().getColor(R.color.colorAccent));
        rvTxjlList.setFootLoadingView(progressView);
        rvTxjlList.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {
                p = p + 1;
                dialog.show();
                getTxmxList();
            }
        });
        TextView textView = new TextView(context);
        textView.setText("-暂无更多-");
        rvTxjlList.setFootEndView(textView);


        line2 = new SakuraLinearLayoutManager(context);
        line2.setOrientation(LinearLayoutManager.VERTICAL);
        rvCzjlList.setLayoutManager(line2);
        rvCzjlList.setItemAnimator(new DefaultItemAnimator());
        ProgressView progressView2 = new ProgressView(context);
        progressView2.setIndicatorId(ProgressView.BallRotate);
        progressView2.setIndicatorColor(getResources().getColor(R.color.colorAccent));
        rvCzjlList.setFootLoadingView(progressView2);
        rvCzjlList.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {
                p2 = p2 + 1;
                dialog.show();
                getCzmxList();
            }
        });
        TextView textView2 = new TextView(context);
        textView2.setText("-暂无更多-");
        rvCzjlList.setFootEndView(textView2);


        line3 = new SakuraLinearLayoutManager(context);
        line3.setOrientation(LinearLayoutManager.VERTICAL);
        rvYjjlList.setLayoutManager(line3);
        rvYjjlList.setItemAnimator(new DefaultItemAnimator());
        ProgressView progressView3 = new ProgressView(context);
        progressView3.setIndicatorId(ProgressView.BallRotate);
        progressView3.setIndicatorColor(getResources().getColor(R.color.colorAccent));
        rvYjjlList.setFootLoadingView(progressView3);
        rvYjjlList.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {
                p3 = p3 + 1;
                dialog.show();
                getSymxList();
            }
        });
        TextView textView3 = new TextView(context);
        textView3.setText("-暂无更多-");
        rvYjjlList.setFootEndView(textView3);

        rvYjjlList.setVisibility(View.GONE);
        rvCzjlList.setVisibility(View.GONE);

    }

    @Override
    protected void initListener() {
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tvCZ.setOnClickListener(this);
        tvYJ.setOnClickListener(this);
        tvTX.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        if (Utils.isConnected(context)) {
            if (dialog == null) {
                dialog = Utils.showLoadingDialog(context);
            }
            dialog.show();
            getTxmxList();
        } else {
            EZToast.showShort(context, R.string.Networkexception);

        }
    }

    private void getTxmxList() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("p", String.valueOf(p));
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        Log.e("NewsListFragment", "params:" + params);
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "about/txmx", "about/txmx", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = result;
                try {
                    dialog.dismiss();
                    Log.e("NewsListFragment", decode.toString());
                    TixianLogBean newsSearchBean = new Gson().fromJson(decode, TixianLogBean.class);
                    if (1 == newsSearchBean.getStatus()) {
                        LLEmpty.setVisibility(View.GONE);
                        if (rvTxjlList != null) {
                            rvTxjlList.setEnabled(true);
                            rvTxjlList.loadMoreComplete();
                            rvTxjlList.setCanloadMore(true);
                        }
                        if (p == 1) {
                            adapter = new TiXianListAdapter(newsSearchBean.getData(), context);
                            rvTxjlList.setAdapter(adapter);
                        } else {
                            if (null == newsSearchBean.getData() || newsSearchBean.getData().isEmpty()) {
                                p=p-1;
                                rvTxjlList.loadMoreEnd();
                                return;
                            }
                            adapter.setDatas((ArrayList) newsSearchBean.getData());
                        }
                    } else {
                        if (p != 1) {
                            p = p - 1;
                            Toast.makeText(context, "没有更多了", Toast.LENGTH_SHORT).show();
                        } else {
                            LLEmpty.setVisibility(View.VISIBLE);
                        }
                        rvTxjlList.setCanloadMore(false);
                        rvTxjlList.loadMoreEnd();
                    }
                    newsSearchBean = null;
                    decode = null;
                } catch (Exception e) {
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

    private void getCzmxList() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("p", String.valueOf(p2));
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        Log.e("NewsListFragment", "params:" + params);
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "about/czmx", "about/czmx", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = result;
                try {
                    dialog.dismiss();
                    Log.e("NewsListFragment", decode.toString());
                    CzmxBean czmxBean = new Gson().fromJson(decode, CzmxBean.class);
                    if (1 == czmxBean.getStatus()) {
                        LLEmpty.setVisibility(View.GONE);
                        if (rvCzjlList != null) {
                            rvCzjlList.setEnabled(true);
                            rvCzjlList.loadMoreComplete();
                            rvCzjlList.setCanloadMore(true);
                        }
                        if (p2 == 1) {
                            chongZhiListAdapter = new ChongZhiListAdapter(czmxBean.getData(), context);
                            rvCzjlList.setAdapter(chongZhiListAdapter);
                        } else {
                            if (null == czmxBean.getData() || czmxBean.getData().isEmpty()) {
                                p2=p2-1;
                                rvCzjlList.loadMoreEnd();
                                return;
                            }
                            chongZhiListAdapter.setDatas((ArrayList) czmxBean.getData());
                        }
                    } else {
                        if (p2 != 1) {
                            p2 = p2 - 1;
                            Toast.makeText(context, "没有更多了", Toast.LENGTH_SHORT).show();
                        } else {
                            LLEmpty.setVisibility(View.VISIBLE);
                        }
                        rvCzjlList.setCanloadMore(false);
                        rvCzjlList.loadMoreEnd();
                    }
                    czmxBean = null;
                    decode = null;
                } catch (Exception e) {
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

    private void getSymxList() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("p", String.valueOf(p3));
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        Log.e("NewsListFragment", "params:" + params);
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "about/symx", "about/symx", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = result;
                try {
                    dialog.dismiss();
                    Log.e("NewsListFragment", decode.toString());
                    SymxBean symxBean = new Gson().fromJson(decode, SymxBean.class);
                    if (1 == symxBean.getStatus()) {
                        LLEmpty.setVisibility(View.GONE);
                        if (rvYjjlList != null) {
                            rvYjjlList.setEnabled(true);
                            rvYjjlList.loadMoreComplete();
                            rvYjjlList.setCanloadMore(true);
                        }
                        if (p3 == 1) {
                            shouYiListAdapter = new ShouYiListAdapter(symxBean.getData(), context);
                            rvYjjlList.setAdapter(shouYiListAdapter);
                        } else {
                            if (null == symxBean.getData() || symxBean.getData().isEmpty()) {
                                p3=p3-1;
                                rvYjjlList.loadMoreEnd();
                                return;
                            }
                            shouYiListAdapter.setDatas((ArrayList) symxBean.getData());
                        }
                    } else {
                        if (p3 != 1) {
                            p3 = p3 - 1;
                            Toast.makeText(context, "没有更多了", Toast.LENGTH_SHORT).show();
                        } else {
                            LLEmpty.setVisibility(View.VISIBLE);
                        }
                        rvYjjlList.setCanloadMore(false);
                        rvYjjlList.loadMoreEnd();
                    }
                    symxBean = null;
                    decode = null;
                } catch (Exception e) {
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_CZ:
                if (!type.equals("2")) {
                    tvCZ.setBackgroundResource(R.mipmap.mingxi_bg);
                    tvTX.setBackgroundResource(0);
                    tvYJ.setBackgroundResource(0);
                    tvCZ.setTextColor(getResources().getColor(R.color.white));
                    tvTX.setTextColor(getResources().getColor(R.color.bgtitle));
                    tvYJ.setTextColor(getResources().getColor(R.color.bgtitle));
                    type = "2";
                    getCzmxList();
                    rvCzjlList.setVisibility(View.VISIBLE);
                    rvTxjlList.setVisibility(View.GONE);
                    rvYjjlList.setVisibility(View.GONE);
                }
                break;
            case R.id.tv_TX:
                if (!type.equals("1")) {
                    tvCZ.setBackgroundResource(0);
                    tvTX.setBackgroundResource(R.mipmap.mingxi_bg);
                    tvYJ.setBackgroundResource(0);
                    tvCZ.setTextColor(getResources().getColor(R.color.bgtitle));
                    tvTX.setTextColor(getResources().getColor(R.color.white));
                    tvYJ.setTextColor(getResources().getColor(R.color.bgtitle));
                    type = "1";
                    getTxmxList();
                    rvCzjlList.setVisibility(View.GONE);
                    rvTxjlList.setVisibility(View.VISIBLE);
                    rvYjjlList.setVisibility(View.GONE);
                }
                break;
            case R.id.tv_YJ:
                if (!type.equals("3")) {
                    tvCZ.setBackgroundResource(0);
                    tvTX.setBackgroundResource(0);
                    tvYJ.setBackgroundResource(R.mipmap.mingxi_bg);
                    tvCZ.setTextColor(getResources().getColor(R.color.bgtitle));
                    tvTX.setTextColor(getResources().getColor(R.color.bgtitle));
                    tvYJ.setTextColor(getResources().getColor(R.color.white));
                    type = "3";
                    getSymxList();
                    rvCzjlList.setVisibility(View.GONE);
                    rvTxjlList.setVisibility(View.GONE);
                    rvYjjlList.setVisibility(View.VISIBLE);
                }
                break;
            default:
                break;
        }
    }
}
