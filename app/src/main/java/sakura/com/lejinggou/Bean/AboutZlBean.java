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
 * @date 2018/12/28
 * 功能描述：
 */
public class AboutZlBean {

    /**
     * status : 1
     * info : 修改成功
     * data : {"headimg":"/Public/uploads/lb/2018-12-28/2018_12_28_142723_1828.jpg","nickname":"sakura","qm":"aaaaaaaaaaaaaaaaaaaa"}
     */

    private int status;
    private String info;
    private DataBean data;

    public static List<AboutZlBean> arrayAboutZlBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<AboutZlBean>>() {
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * headimg : /Public/uploads/lb/2018-12-28/2018_12_28_142723_1828.jpg
         * nickname : sakura
         * qm : aaaaaaaaaaaaaaaaaaaa
         */

        private String headimg;
        private String nickname;
        private String qm;

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getHeadimg() {
            return headimg;
        }

        public void setHeadimg(String headimg) {
            this.headimg = headimg;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getQm() {
            return qm;
        }

        public void setQm(String qm) {
            this.qm = qm;
        }
    }
}
