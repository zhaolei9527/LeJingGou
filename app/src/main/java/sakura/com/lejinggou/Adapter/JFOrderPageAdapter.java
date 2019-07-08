package sakura.com.lejinggou.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sakura.com.lejinggou.View.JFOrderContentFrameLayout;


/**
 * Created by 赵磊 on 2017/9/20.
 */

public class JFOrderPageAdapter extends PagerAdapter {

    private List<String> PageTitle;
    private List<JFOrderContentFrameLayout> PageS = new ArrayList<>();

    public JFOrderPageAdapter(Context context, List pageTitle) {
        this.PageTitle = pageTitle;

        JFOrderContentFrameLayout orderContentFrameLayout2 = new JFOrderContentFrameLayout(context, "0");
        orderContentFrameLayout2.setTag("0");
        PageS.add(orderContentFrameLayout2);

        JFOrderContentFrameLayout orderContentFrameLayout3 = new JFOrderContentFrameLayout(context, "1");
        orderContentFrameLayout3.setTag("1");
        PageS.add(orderContentFrameLayout3);

        JFOrderContentFrameLayout orderContentFrameLayout4 = new JFOrderContentFrameLayout(context, "2");
        orderContentFrameLayout4.setTag("2");
        PageS.add(orderContentFrameLayout4);

        JFOrderContentFrameLayout orderContentFrameLayout5 = new JFOrderContentFrameLayout(context, "3");
        orderContentFrameLayout5.setTag("3");
        PageS.add(orderContentFrameLayout5);

        JFOrderContentFrameLayout orderContentFrameLayout6 = new JFOrderContentFrameLayout(context, "4");
        orderContentFrameLayout6.setTag("4");
        PageS.add(orderContentFrameLayout6);

    }


    @Override
    public CharSequence getPageTitle(int position) {
        return PageTitle.get(position);
    }

    @Override
    public int getCount() {
        return PageTitle == null ? 0 : PageTitle.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(PageS.get(position));
        return PageS.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        if (view == object) {
            return true;
        }
        return false;
    }

}