package sakura.com.lejinggou.Bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * sakura.liangdinvshen.Bean
 *
 * @author 赵磊
 * @date 2017/11/28
 * 功能描述：操作状态Bean
 */
public class CodeBean {

    /**
     * status : 1
     * info : 短信发送成功
     */

    private int status;
    private String info;

    public static List<CodeBean> arrayCodeBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<CodeBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
