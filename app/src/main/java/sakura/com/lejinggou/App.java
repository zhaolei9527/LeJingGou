package sakura.com.lejinggou;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.haoge.easyandroid.EasyAndroid;
import com.hss01248.frescopicker.FrescoIniter;
import com.tencent.bugly.Bugly;
import com.tencent.smtt.sdk.QbSdk;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import me.iwf.photopicker.PhotoPickUtils;
import sakura.com.lejinggou.Utils.PausableThreadPoolExecutor;

/**
 * sakura.com.lejinggou.Base
 *
 * @author 赵磊
 * @date 2018/12/21
 * 功能描述：
 */
public class App extends MultiDexApplication {
    /**
     * 先创建一个请求队列，因为这个队列是全局的，所以在Application中声明这个队列
     */
    public static RequestQueue queues;
    public static PausableThreadPoolExecutor pausableThreadPoolExecutor;
    public static String LanguageTYPEHTTP = "?l=zh-cn";
    public static Context context;
    public static boolean initX5 = false;

    protected String getAppkey() {
        return null;
    }

    protected String getAppSecret() {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = this;
        MultiDex.install(this);
        queues = Volley.newRequestQueue(getApplicationContext());
        Fresco.initialize(this);
        pausableThreadPoolExecutor = new PausableThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>());
        PhotoPickUtils.init(getApplicationContext(), new FrescoIniter());//第二个参数根据具体依赖库而定
        EasyAndroid.init(this);
        Bugly.init(getApplicationContext(), "58e444e19a", false);
        //初始化X5内核
        QbSdk.initX5Environment(this, new QbSdk.PreInitCallback() {

            @Override
            public void onCoreInitFinished() {
                //x5内核初始化完成回调接口，此接口回调并表示已经加载起来了x5，有可能特殊情况下x5内核加载失败，切换到系统内核。
            }

            @Override
            public void onViewInitFinished(boolean b) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.e("@@", "加载内核是否成功:" + b);
                initX5 = b;
            }
        });
    }

    public static RequestQueue getQueues() {
        return queues;
    }
}
