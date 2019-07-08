package sakura.com.lejinggou.View;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.HashMap;

import me.fangx.haorefresh.LoadMoreListener;
import sakura.com.lejinggou.Activity.MyOrderDetailsActivity;
import sakura.com.lejinggou.Adapter.MyJFOrderAdapter;
import sakura.com.lejinggou.Bean.UserGetBillBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EZToast;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;


/**
 * Created by 赵磊 on 2017/9/19.
 */

public class JFOrderContentFrameLayout extends LinearLayout {
    private final BroadcastReceiver receiver;
    private WenguoyiRecycleView mRecyclerView;
    private int p = 1;
    private LinearLayoutManager line;
    private MyJFOrderAdapter adapter;
    private int height;
    private Context context;
    private String stu = "";
    private RelativeLayout ll_empty;
    private final Dialog dialog;

    public JFOrderContentFrameLayout(@NonNull Context context, final String stu) {
        super(context);
        this.context = context;
        this.stu = stu;
        dialog = Utils.showLoadingDialog(context);

        onCreateView();
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String stu1 = intent.getStringExtra("stu");
                if (stu.equals(stu1)) {
                    p = 1;
                    getData();
                }
                String unRegister = intent.getStringExtra("unRegister");
                if (!TextUtils.isEmpty(unRegister)) {
                    if ("unRegister".equals(unRegister)) {
                        context.unregisterReceiver(receiver);
                    }
                }
            }
        };
        context.registerReceiver(receiver, new IntentFilter("OrderContentRefresh"));
    }

    public void onCreateView() {
        View news_content_fragment_layout = View.inflate(context, R.layout.order_content_fragment_layout, null);
        initView(news_content_fragment_layout);
        addView(news_content_fragment_layout);
        getData();
    }

    private void initView(View view) {
        mRecyclerView = (WenguoyiRecycleView) view.findViewById(R.id.ce_shi_lv);
        line = new LinearLayoutManager(context);
        line.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(line);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        ProgressView progressView = new ProgressView(context);
        progressView.setIndicatorId(ProgressView.BallRotate);
        progressView.setIndicatorColor(getResources().getColor(R.color.colorAccent));
        mRecyclerView.setFootLoadingView(progressView);
        TextView textView = new TextView(context);
        textView.setText("-我也是有底线的-");
        mRecyclerView.setFootEndView(textView);
        mRecyclerView.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {
                p = p + 1;
                getData();
            }
        });
        ll_empty = (RelativeLayout) view.findViewById(R.id.LL_empty);
    }

    public void getData() {
        if (Utils.isConnected(context)) {
            dialog.show();
            orderLists(stu);
        } else {
            dialog.dismiss();
        }
    }

    /**
     * 订单列表获取
     */
    private void orderLists(final String stu) {
        HashMap<String, String> params = new HashMap<>(4);
        params.put("uid", String.valueOf(SpUtil.get(context, "uid", "")));
        params.put("state", stu);
        params.put("pageNo", String.valueOf(p));
        params.put("pageSize", "20");
        Log.e("OrderContentFrameLayout", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.JAVA_URL + "userGetBill", "userGetBill", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("OrderContentFrameLayout" + stu, result);
                try {
                    dialog.dismiss();
                    final UserGetBillBean orderListsBean = new Gson().fromJson(result, UserGetBillBean.class);
                    if (orderListsBean.getStatus().equals("1")) {
                        ll_empty.setVisibility(View.GONE);

                        if (orderListsBean.getList().getList().size() < 20 || !orderListsBean.getList().isHasNextPage()) {
                            mRecyclerView.setCanloadMore(false);
                        } else {
                            mRecyclerView.setCanloadMore(true);
                        }

                        if (1 == p) {
                            if (null != orderListsBean.getList().getList() && !orderListsBean.getList().getList().isEmpty()) {
                                adapter = new MyJFOrderAdapter(context, orderListsBean.getList().getList());
                                mRecyclerView.setAdapter(adapter);
                                mRecyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                        context.startActivity(new Intent(context, MyOrderDetailsActivity.class).putExtra("orderid", adapter.getDatas().get(i).getId()));
                                    }

                                });
                                ll_empty.setVisibility(GONE);
                            } else {
                                ll_empty.setVisibility(VISIBLE);
                            }
                        } else {
                            mRecyclerView.loadMoreComplete();
                            if (null != orderListsBean.getList().getList() && !orderListsBean.getList().getList().isEmpty()) {
                                adapter.setDatas(orderListsBean.getList().getList());
                            } else {
                                mRecyclerView.loadMoreEnd();
                            }
                        }
                    } else {
                        if (1 == p) {
                            ll_empty.setVisibility(View.VISIBLE);
                        } else {
                            EZToast.showShort(context, R.string.notmore);
                            mRecyclerView.loadMoreEnd();
                            mRecyclerView.setCanloadMore(false);
                        }
                    }

                } catch (Exception e) {
                    dialog.dismiss();
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


}
