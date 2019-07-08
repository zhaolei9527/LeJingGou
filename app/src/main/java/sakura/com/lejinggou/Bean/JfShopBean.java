package sakura.com.lejinggou.Bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * sakura.com.lejinggou.Bean
 *
 * @author 赵磊
 * @date 2019/7/8
 * 功能描述：
 */
public class JfShopBean {

    /**
     * msg : 获取成功
     * list : 4
     * status : 1
     */

    private String msg;
    private String list;
    private String status;

    public static List<JfShopBean> arrayJfShopBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<JfShopBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
