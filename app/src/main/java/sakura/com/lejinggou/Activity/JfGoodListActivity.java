package sakura.com.lejinggou.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Adapter.NewsPageAdapter;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Bean.NewsListBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.View.MyViewPager;
import sakura.com.lejinggou.View.PagerSlidingTabStrip;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

/**
 * sakura.com.lejinggou.Activity
 *
 * @author 赵磊
 * @date 2019/7/2
 * 功能描述：
 */
public class JfGoodListActivity extends BaseActivity {

    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.tabs)
    PagerSlidingTabStrip tabs;
    @BindView(R.id.VpNews_context)
    MyViewPager VpNewsContext;

    private int p = 1;
    private List titles = new ArrayList();
    private List titleid = new ArrayList();
    private NewsPageAdapter adapter;

    @Override
    protected int setthislayout() {
        return R.layout.activity_jfgood_layout;
    }

    @Override
    protected void initview() {

    }

    @Override
    protected void initListener() {
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }

    @Override
    protected void initData() {
        p = 1;
        getIndex();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    /**
     * 首页信息获取
     */
    private void getIndex() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("pageNo", String.valueOf(p));
        params.put("pageSize", "20");
        Log.e("NewsFragment", params.toString());
        VolleyRequest.RequestPost(context, UrlUtils.JAVA_URL + "usergetgoodsbytype", "usergetgoodsbytype", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                String decode = result;
                Log.e("NewsFragment", decode);
                try {
                    NewsListBean newsListBean = new Gson().fromJson(decode, NewsListBean.class);
                    //新闻分类处理
                    List<NewsListBean.TypeListBean> cate = newsListBean.getTypeList();
                    titles.clear();
                    titleid.clear();

                    titles.add("全部商品");
                    titleid.add("");

                    for (int i = 0; i < cate.size(); i++) {
                        titles.add(cate.get(i).getName());
                        titleid.add(cate.get(i).getId());
                    }

                    if (adapter == null) {
                        adapter = new NewsPageAdapter(getSupportFragmentManager(), context, titles, titleid);
                        VpNewsContext.setAdapter(adapter);
                        tabs.setViewPager(VpNewsContext);
                    } else {
                        if (p != 1) {
                            VpNewsContext.setAdapter(adapter);
                        }
                    }

                    String id = getIntent().getStringExtra("id");

                    for (int i = 0; i < titleid.size(); i++) {
                        if (titleid.get(i).equals(id)) {
                            VpNewsContext.setCurrentItem(i);
                        }
                    }

                    cate = null;
                    decode = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                error.printStackTrace();
            }
        });
    }

}
