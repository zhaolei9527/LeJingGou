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

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.fangx.haorefresh.LoadMoreListener;
import sakura.com.lejinggou.Adapter.ChuJiaJiLuListAdapter;
import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.GoodsJlBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.PriorityRunnable;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.Utils.Utils;
import sakura.com.lejinggou.View.ProgressView;
import sakura.com.lejinggou.View.SakuraLinearLayoutManager;
import sakura.com.lejinggou.View.WenguoyiRecycleView;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

/**
 * sakura.com.lejinggou.Activity
 *
 * @author 赵磊
 * @date 2018/12/27
 * 功能描述：
 */
public class ChuJiaJiLuActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.rv_chujialist)
    WenguoyiRecycleView rvChujialist;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.LL_empty)
    RelativeLayout LLEmpty;
    private String id;
    public static String type = "1";
    private SakuraLinearLayoutManager line;
    private int page = 1;
    private Dialog dialog;
    private ChuJiaJiLuListAdapter chuJiaJiLuListAdapter;

    @Override
    protected int setthislayout() {
        return R.layout.activity_chujiajilu_layout;
    }

    @Override
    protected void initview() {
        dialog = Utils.showLoadingDialog(context);
        id = getIntent().getStringExtra("id");
        type = getIntent().getStringExtra("type");
        line = new SakuraLinearLayoutManager(context);
        line.setOrientation(LinearLayoutManager.VERTICAL);
        rvChujialist.setLayoutManager(line);
        rvChujialist.setItemAnimator(new DefaultItemAnimator());
        ProgressView progressView = new ProgressView(context);
        progressView.setIndicatorId(ProgressView.BallRotate);
        progressView.setIndicatorColor(getResources().getColor(R.color.colorAccent));
        rvChujialist.setFootLoadingView(progressView);
        rvChujialist.setLoadMoreListener(new LoadMoreListener() {
            @Override
            public void onLoadMore() {
                page = page + 1;
                App.pausableThreadPoolExecutor.execute(new PriorityRunnable(1) {
                    @Override
                    public void doSth() {
                        getListData();
                    }
                });
            }
        });
        TextView textView = new TextView(context);
        textView.setText(context.getString(R.string.notmore));
        rvChujialist.setFootEndView(textView);


    }

    @Override
    protected void initListener() {
        rlBack.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        getListData();
        dialog.show();
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
            case R.id.rl_back:
                finish();
                break;
            default:
                break;
        }
    }

    //数据获取
    public void getListData() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("p", String.valueOf(page));
        params.put("id", id);
        Log.e("HomeFragment", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "goods/jl" + App.LanguageTYPEHTTP, "goods/jl", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("HomeFragment", result);
                try {
                    dialog.dismiss();
                    rvChujialist.loadMoreComplete();
                    GoodsJlBean goodsJlBean = new Gson().fromJson(result, GoodsJlBean.class);

                    if (null == goodsJlBean.getData().getList() || goodsJlBean.getData().getList().isEmpty()) {
                        if (page == 1) {
                            LLEmpty.setVisibility(View.VISIBLE);
                        }

                        rvChujialist.loadMoreEnd();
                        rvChujialist.setCanloadMore(false);
                    } else {
                        if (page == 1) {
                            GoodsJlBean.DataBean.ListBean dqj = new GoodsJlBean.DataBean.ListBean();
                            dqj.setAddtime(goodsJlBean.getData().getDqj().getAddtime());
                            dqj.setBs(goodsJlBean.getData().getDqj().getBs());
                            dqj.setHeadimg(goodsJlBean.getData().getDqj().getHeadimg());
                            dqj.setNickname(goodsJlBean.getData().getDqj().getNickname());
                            chuJiaJiLuListAdapter = new ChuJiaJiLuListAdapter(context, goodsJlBean.getData().getList());
                            rvChujialist.setAdapter(chuJiaJiLuListAdapter);
                        } else {
                            GoodsJlBean.DataBean.ListBean dqj = new GoodsJlBean.DataBean.ListBean();
                            dqj.setAddtime(goodsJlBean.getData().getDqj().getAddtime());
                            dqj.setBs(goodsJlBean.getData().getDqj().getBs());
                            dqj.setHeadimg(goodsJlBean.getData().getDqj().getHeadimg());
                            dqj.setNickname(goodsJlBean.getData().getDqj().getNickname());
                            chuJiaJiLuListAdapter.setDatas(goodsJlBean.getData().getList());
                        }
                    }

                    result = null;
                } catch (Exception e) {
                    dialog.dismiss();
                    page = page - 1;
                    if (rvChujialist != null) {
                        rvChujialist.loadMoreComplete();
                        rvChujialist.loadMoreEnd();
                        rvChujialist.setCanloadMore(false);
                    }
                    e.printStackTrace();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                dialog.dismiss();
                page = page - 1;
                error.printStackTrace();
            }
        });

    }

}
