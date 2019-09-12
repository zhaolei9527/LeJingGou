package sakura.com.lejinggou.Activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
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
import sakura.com.lejinggou.Adapter.XiaJiListAdapter;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.SelectMpUserBypidjksBean;
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
public class XiaJiListActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.rv_txjl_list)
    WenguoyiRecycleView rvTxjlList;
    @BindView(R.id.LL_empty)
    RelativeLayout LLEmpty;
    private XiaJiListAdapter adapter;
    private SakuraLinearLayoutManager line;
    private Dialog dialog;
    private int p = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected int setthislayout() {
        return R.layout.activity_xiaji_list;
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
        TextView textView = new TextView(context);
        textView.setText("-暂无更多-");
        rvTxjlList.setFootEndView(textView);
        rvTxjlList.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {
                p = p + 1;
                dialog.show();
                getTxmxList();
            }
        });

    }

    @Override
    protected void initListener() {
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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
        params.put("id", String.valueOf(SpUtil.get(context, "uid", "")));
        params.put("pageNo", String.valueOf(p));
        params.put("pageSize", "20");
        Log.e("selectMpUserBypidjks", "params:" + params);
        VolleyRequest.RequestPost(context, UrlUtils.JAVA_URL + "selectMpUserBypidjks", "selectMpUserBypidjks", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = result;
                try {
                    dialog.dismiss();
                    Log.e("selectMpUserBypidjks", decode.toString());
                    SelectMpUserBypidjksBean newsSearchBean = new Gson().fromJson(decode, SelectMpUserBypidjksBean.class);
                    if (newsSearchBean.getStatus().equals("1")) {
                        LLEmpty.setVisibility(View.GONE);
                        if (rvTxjlList != null) {
                            rvTxjlList.setEnabled(true);
                            rvTxjlList.loadMoreComplete();
                            rvTxjlList.setCanloadMore(true);
                        }
                        if (p == 1) {
                            adapter = new XiaJiListAdapter(newsSearchBean.getList().getList(), context);
                            rvTxjlList.setAdapter(adapter);
                        } else {
                            adapter.setDatas((ArrayList) newsSearchBean.getList().getList());
                        }

                        if (newsSearchBean.getList().getList().size()<20){
                            rvTxjlList.setCanloadMore(false);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            default:
                break;
        }
    }
}
