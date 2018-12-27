package sakura.com.lejinggou.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.View.WenguoyiRecycleView;

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

    @Override
    protected int setthislayout() {
        return R.layout.activity_chujiajilu_layout;
    }

    @Override
    protected void initview() {
        id = getIntent().getStringExtra("id");
    }

    @Override
    protected void initListener() {
        rlBack.setOnClickListener(this);
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
}
