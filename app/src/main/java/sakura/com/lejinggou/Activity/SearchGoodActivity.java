package sakura.com.lejinggou.Activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.fangx.haorefresh.LoadMoreListener;
import sakura.com.lejinggou.Adapter.SheQuTieZiListAdapter;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.EZToast;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.View.ProgressView;
import sakura.com.lejinggou.View.WenguoyiRecycleView;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

/**
 * sakura.com.taokexing.Activity
 *
 * @author 赵磊
 * @date 2019/4/1
 * 功能描述：
 */
public class SearchGoodActivity extends BaseActivity {

    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.et_search_tiezi)
    EditText etSearchTiezi;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.rv_list)
    WenguoyiRecycleView rvList;
    @BindView(R.id.LL_empty)
    RelativeLayout LLEmpty;
    private Dialog dialog;
    private int p = 1;
    private LinearLayoutManager line;
    SheQuTieZiListAdapter adapter;

    @Override
    protected int setthislayout() {
        return R.layout.search_good_layout;
    }

    @Override
    protected void initview() {
        line = new LinearLayoutManager(context);
        line.setOrientation(LinearLayoutManager.VERTICAL);
        rvList.setLayoutManager(line);
        rvList.setItemAnimator(new DefaultItemAnimator());
        ProgressView progressView = new ProgressView(context);
        progressView.setIndicatorId(ProgressView.BallRotate);
        progressView.setIndicatorColor(getResources().getColor(R.color.colorAccent));
        rvList.setFootLoadingView(progressView);
        rvList.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {
                p = p + 1;
                dialog.show();
                getNewsList();
            }
        });
        TextView textView = new TextView(context);
        textView.setText("-暂无更多-");
        rvList.setFootEndView(textView);
    }

    @Override
    protected void initListener() {

        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        etSearchTiezi.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if ((actionId == 0 || actionId == 3) && event != null) {
                    //点击搜索要做的操作
                    String trim = etSearchTiezi.getText().toString().trim();
                    if (TextUtils.isEmpty(trim)) {
                        EZToast.showShort(context, "请输入关键字");
                        return false;
                    }
                    dialog.show();
                    getNewsList();
                }
                return false;
            }
        });

    }

    @Override
    protected void initData() {
        if (dialog == null) {
            dialog = Utils.showLoadingDialog(context);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    /**
     * 新闻列表获取
     */
    private void getNewsList() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("name", etSearchTiezi.getText().toString().trim());
        params.put("pageNo", String.valueOf(p));
        params.put("pageSize", "20");
        Log.e("HuiYuanZXListFragment", "params:" + params);
        VolleyRequest.RequestPost(context, UrlUtils.JAVA_URL + "userseachJfGoods", "userseachJfGoods", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                try {
                    dialog.dismiss();
                    Log.e("NewsListFragment", result);
//                    NewsNewsBean newsNewsBean = new Gson().fromJson(result, NewsNewsBean.class);
//                    if ("1".equals(String.valueOf(newsNewsBean.getStatus()))) {
//
//                        if (rvList != null) {
//                            rvList.setEnabled(true);
//                            rvList.loadMoreComplete();
//                            rvList.setCanloadMore(true);
//                        }
//
//                        if (newsNewsBean.getList() != null) {
//                            if (p == 1) {
//                                adapter = new SheQuTieZiListAdapter(newsNewsBean.getList(), context);
//                                rvList.setAdapter(adapter);
//                                if (newsNewsBean.getList().size() < 10) {
//                                    rvList.setCanloadMore(false);
//                                    rvList.loadMoreEnd();
//                                } else {
//                                    rvList.setCanloadMore(true);
//                                }
//                            } else {
//                                adapter.setDatas((ArrayList) newsNewsBean.getList());
//                            }
//
//                            rvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                                @Override
//                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                                    startActivity(new Intent(context, KechengDetailActivity.class)
//                                            .putExtra("id", String.valueOf(adapter.getDatas().get(i).getId()))
//                                    );
//                                }
//                            });
//
//                        } else {
//                            Toast.makeText(context, "暂无相关内容", Toast.LENGTH_SHORT).show();
//                        }
//
//                    } else {
//                        if (p != 1) {
//                            p = p - 1;
//                            Toast.makeText(context, "没有更多了", Toast.LENGTH_SHORT).show();
//                        } else {
//                        }
//                        rvList.setCanloadMore(false);
//                        rvList.loadMoreEnd();
//                    }
//                    newsNewsBean = null;
                    result = null;
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, context.getString(R.string.Abnormalserver), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                error.printStackTrace();
                dialog.dismiss();
                Toast.makeText(context, context.getString(R.string.Abnormalserver), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
