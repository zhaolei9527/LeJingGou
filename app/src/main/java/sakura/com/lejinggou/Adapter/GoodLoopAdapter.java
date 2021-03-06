package sakura.com.lejinggou.Adapter;

import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.UrlUtils;


/**
 * Created by 赵磊 on 2017/5/25.
 */
//轮播图
public class GoodLoopAdapter extends LoopPagerAdapter {
    //

    private List<String> lbdatas = new ArrayList();

    public GoodLoopAdapter(RollPagerView viewPager) {
        super(viewPager);
    }


    public GoodLoopAdapter(RollPagerView viewPager, List<String> lbdatas) {
        super(viewPager);
        this.lbdatas = lbdatas;
    }

    @Override
    public View getView(ViewGroup container, int position) {
        View inflate = View.inflate(container.getContext(), R.layout.layout_img, null);
        SimpleDraweeView SimpleDraweeView = (com.facebook.drawee.view.SimpleDraweeView) inflate.findViewById(R.id.SimpleDraweeView);
        try {
            SimpleDraweeView.setImageURI(UrlUtils.URL + lbdatas.get(position));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inflate;
    }

    @Override
    public int getRealCount() {
        return lbdatas.size();
    }
}