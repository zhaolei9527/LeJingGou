package sakura.com.lejinggou.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.View.WenguoyiRecycleView;

/**
 * sakura.com.lejinggou.Activity
 *
 * @author 赵磊
 * @date 2018/12/28
 * 功能描述：
 */
public class MaiChangJieShuActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.tv_Title)
    TextView tvTitle;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.SimpleDraweeView_user)
    SimpleDraweeView SimpleDraweeViewUser;
    @BindView(R.id.tv_user)
    TextView tvUser;
    @BindView(R.id.tv_user_money)
    TextView tvUserMoney;
    @BindView(R.id.ll_JPJG)
    LinearLayout llJPJG;
    @BindView(R.id.rv_maichanglist)
    WenguoyiRecycleView rvMaichanglist;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.LL_empty)
    RelativeLayout LLEmpty;

    @Override
    protected int setthislayout() {
        return R.layout.activity_maichang_jieshu_layout;
    }

    @Override
    protected void initview() {

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

                break;
            default:
                break;
        }
    }
}
