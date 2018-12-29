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
 * @date 2017/12/18
 * 功能描述：
 */
public class OrderListsBean {


    /**
     * status : 1
     * info : 数据拉取成功
     * data : [{"id":"71","status":"1","addtime":"1546070100","gname":"和田青玉-亦佛亦魔","fm_img":"/Public/uploads/lb/2018-12-29/2018_12_29_154802_9405.png","price":"7488.00"}]
     */

    private int status;
    private String info;
    private List<DataBean> data;

    public static List<OrderListsBean> arrayOrderListsBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<OrderListsBean>>() {
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
         * id : 71
         * status : 1
         * addtime : 1546070100
         * gname : 和田青玉-亦佛亦魔
         * fm_img : /Public/uploads/lb/2018-12-29/2018_12_29_154802_9405.png
         * price : 7488.00
         */

        private String id;
        private String status;
        private String addtime;
        private String gname;
        private String fm_img;
        private String price;

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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getGname() {
            return gname;
        }

        public void setGname(String gname) {
            this.gname = gname;
        }

        public String getFm_img() {
            return fm_img;
        }

        public void setFm_img(String fm_img) {
            this.fm_img = fm_img;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
