package sakura.com.lejinggou.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.Fragment.MyJFOrderFragment;
import sakura.com.lejinggou.R;

/**
 * com.wenguoyi.Activity
 *
 * @author 赵磊
 * @date 2018/6/12
 * 功能描述：
 */
public class MyJFOrderActivity extends BaseActivity {

    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    public static String cid;

    @Override
    protected int setthislayout() {
        return R.layout.activity_myorder_layout;
    }

    @Override
    protected void initview() {
        cid = getIntent().getStringExtra("cid");
        Class aClass = (Class) MyJFOrderFragment.class;
        Class clazz = null;
        try {
            clazz = Class.forName(aClass.getName());
            Fragment e = (Fragment) clazz.newInstance();
            FragmentTransaction fragmentTransaction = MyJFOrderActivity.this.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fl_content, e);
            fragmentTransaction.commit();
        } catch (Exception var6) {
            var6.printStackTrace();
        }
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

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
