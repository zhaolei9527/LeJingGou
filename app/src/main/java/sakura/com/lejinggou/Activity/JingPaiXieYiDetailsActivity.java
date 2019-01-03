package sakura.com.lejinggou.Activity;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;
import sakura.com.lejinggou.Base.BaseActivity;
import sakura.com.lejinggou.R;
import sakura.com.lejinggou.Utils.Utils;

/**
 * com.sakuraphonebtc.Activity
 *
 * @author 赵磊
 * @date 2018/3/31
 * 功能描述：
 */
public class JingPaiXieYiDetailsActivity extends BaseActivity {
    @BindView(R.id.rl_back)
    FrameLayout rlBack;
    @BindView(R.id.forum_Context)
    WebView forum_Context;
    @BindView(R.id.tv_Title)
    TextView tvTitle;
    private Dialog dialog;

    @Override
    protected int setthislayout() {
        return R.layout.zhucexieyi_details_activity_layout;
    }

    @Override
    protected void initview() {

        dialog = Utils.showLoadingDialog(context);
        if (!dialog.isShowing()) {
            dialog.show();
        }

        tvTitle.setText("竞购规则");

        // 开启 localStorage
        forum_Context.getSettings().setDomStorageEnabled(true);
        // 设置支持javascript
        forum_Context.getSettings().setJavaScriptEnabled(true);
        // 启动缓存
        forum_Context.getSettings().setAppCacheEnabled(true);
        // 设置缓存模式
        forum_Context.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        // 启动缓存
        forum_Context.getSettings().setAppCacheEnabled(true);
        forum_Context.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        forum_Context.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView webView, String s) {
                super.onPageFinished(webView, s);
                dialog.dismiss();
                int w = View.MeasureSpec.makeMeasureSpec(0,
                        View.MeasureSpec.UNSPECIFIED);
                int h = View.MeasureSpec.makeMeasureSpec(0,
                        View.MeasureSpec.UNSPECIFIED);
                //重新测量
                webView.measure(w, h);
            }

            @Override
            public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
                super.onPageStarted(webView, s, bitmap);
            }

            @Override
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                Toast.makeText(context, getString(R.string.hasError), Toast.LENGTH_SHORT).show();

            }
        });
        forum_Context.loadUrl(String.valueOf(getIntent().getStringExtra("url")));
    }

    @Override
    protected void initListener() {
        rlBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
