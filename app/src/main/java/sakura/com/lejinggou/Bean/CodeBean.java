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
     * status : 2
     * info : 余额不足
     * dqmon : 0.00
     * bzj : 10.00
     */

    private int status;
    private String info;
    private String dqmon;
    private String bzj;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;


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

    public String getDqmon() {
        return dqmon;
    }

    public void setDqmon(String dqmon) {
        this.dqmon = dqmon;
    }

    public String getBzj() {
        return bzj;
    }

    public void setBzj(String bzj) {
        this.bzj = bzj;
    }
}
