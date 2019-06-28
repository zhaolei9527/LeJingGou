package sakura.com.lejinggou.Bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * com.wenguoyi.Bean
 *
 * @author 赵磊
 * @date 2018/6/5
 * 功能描述：
 */
public class NewsListBean {


    /**
     * clist : [{"id":1,"name":"军事1"}]
     * list : [{"id":1,"title":"军事新闻","view":27,"img":"/Public/uploads/20190611\\02bc2e957656facd22f390cc19d66bbe.png","addtime":1560253151}]
     * zpage : 1
     * status : 1
     */

    private String zpage;
    private String status;
    private List<ClistBean> clist;
    private List<ListBean> list;

    public static List<NewsListBean> arrayNewsListBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<NewsListBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getZpage() {
        return zpage;
    }

    public void setZpage(String zpage) {
        this.zpage = zpage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ClistBean> getClist() {
        return clist;
    }

    public void setClist(List<ClistBean> clist) {
        this.clist = clist;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ClistBean {
        /**
         * id : 1
         * name : 军事1
         */

        private String id;
        private String name;

        public static List<ClistBean> arrayClistBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ClistBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ListBean {
        /**
         * id : 1
         * title : 军事新闻
         * view : 27
         * img : /Public/uploads/20190611\02bc2e957656facd22f390cc19d66bbe.png
         * addtime : 1560253151
         */

        private String id;
        private String title;
        private String view;
        private String img;
        private String addtime;

        public static List<ListBean> arrayListBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ListBean>>() {
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

        public String getView() {
            return view;
        }

        public void setView(String view) {
            this.view = view;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }
    }
}
