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
 * @date 2018/12/26
 * 功能描述：
 */
public class NewsIndexBean {

    /**
     * status : 1
     * info : 信息拉取成功
     * data : [{"id":"11","title":"在每个人生阶段，如何升级你的翡翠？","url":"http://ljg.t.100help.net/ym/nd/id/11.html"},{"id":"9","title":"青海玉的秘密","url":"http://ljg.t.100help.net/ym/nd/id/9.html"},{"id":"7","title":"这是一条新闻","url":"http://ljg.t.100help.net/ym/nd/id/7.html"}]
     */

    private int status;
    private String info;
    private List<DataBean> data;

    public static List<NewsIndexBean> arrayNewsIndexBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<NewsIndexBean>>() {
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 11
         * title : 在每个人生阶段，如何升级你的翡翠？
         * url : http://ljg.t.100help.net/ym/nd/id/11.html
         */

        private String id;
        private String title;
        private String url;

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
