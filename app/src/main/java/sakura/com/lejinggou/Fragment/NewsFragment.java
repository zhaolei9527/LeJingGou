package sakura.com.lejinggou.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import sakura.com.lejinggou.Adapter.NewsPageAdapter;
import sakura.com.lejinggou.App;
import sakura.com.lejinggou.Base.BaseLazyFragment;
import sakura.com.lejinggou.Bean.NewsListBean;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.SpUtil;
import sakura.com.lejinggou.Utils.UrlUtils;
import sakura.com.lejinggou.View.MyViewPager;
import sakura.com.lejinggou.View.PagerSlidingTabStrip;
import sakura.com.lejinggou.Volley.VolleyInterface;
import sakura.com.lejinggou.Volley.VolleyRequest;

/**
 * com.wenguoyi.Fragment
 *
 * @author 赵磊
 * @date 2018/5/15
 * 功能描述：
 */
public class NewsFragment extends BaseLazyFragment {

    @BindView(R.id.tabs)
    PagerSlidingTabStrip tabs;
    @BindView(R.id.VpNews_context)
    MyViewPager VpNewsContext;
    Unbinder unbinder;
    private Context context;
    private int p = 1;
    private List titles = new ArrayList();
    private List titleid = new ArrayList();
    private NewsPageAdapter adapter;

    @Override
    protected void initPrepare() {

    }

    @Override
    protected void onInvisible() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onResume() {
        super.onResume();
        p = 1;
        getIndex();
    }

    @Override
    protected View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.news_fragment_layout, container, false);
        return view;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    /**
     * 首页信息获取
     */
    private void getIndex() {
        HashMap<String, String> params = new HashMap<>(1);
        params.put("pageNo", String.valueOf(p));
        params.put("pageSize", "20");
        Log.e("NewsFragment", params.toString());
        VolleyRequest.RequestPost(getActivity(), UrlUtils.JAVA_URL + "usergetgoodsbytype", "usergetgoodsbytype", params, new VolleyInterface(getActivity()) {
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
                        adapter = new NewsPageAdapter(getChildFragmentManager(), getActivity(), titles, titleid);
                        VpNewsContext.setAdapter(adapter);
                        tabs.setViewPager(VpNewsContext);
                    } else {
                        if (p != 1) {
                            VpNewsContext.setAdapter(adapter);
                        }
                    }
                    //缓存首页数据
                    SpUtil.putAndApply(getActivity(), "index", decode);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        App.getQueues().cancelAll("new/index");
    }
}
