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
public class OrderDetailBean {

    /**
     * status : 1
     * info : 数据拉取成功
     * data : {"id":"71","price":"5488.00","bzj":"2000.00","status":"1","addtime":"1546070100","kdgs":"","kdbh":"","name":"","tel":"","address":"","gname":"和田青玉-亦佛亦魔","fm_img":"/Public/uploads/lb/2018-12-29/2018_12_29_154802_9405.png","dqprice":"7488.00","status_msg":"待付款"}
     */

    private int status;
    private String info;
    private DataBean data;

    public static List<OrderDetailBean> arrayOrderDetailBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<OrderDetailBean>>() {
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
         * id : 71
         * price : 5488.00
         * bzj : 2000.00
         * status : 1
         * addtime : 1546070100
         * kdgs :
         * kdbh :
         * name :
         * tel :
         * address :
         * gname : 和田青玉-亦佛亦魔
         * fm_img : /Public/uploads/lb/2018-12-29/2018_12_29_154802_9405.png
         * dqprice : 7488.00
         * status_msg : 待付款
         */

        private String id;
        private String price;
        private String bzj;
        private String status;
        private String addtime;
        private String kdgs;
        private String kdbh;
        private String name;
        private String tel;
        private String address;
        private String gname;
        private String fm_img;
        private String dqprice;
        private String status_msg;

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

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getBzj() {
            return bzj;
        }

        public void setBzj(String bzj) {
            this.bzj = bzj;
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

        public String getKdgs() {
            return kdgs;
        }

        public void setKdgs(String kdgs) {
            this.kdgs = kdgs;
        }

        public String getKdbh() {
            return kdbh;
        }

        public void setKdbh(String kdbh) {
            this.kdbh = kdbh;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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

        public String getDqprice() {
            return dqprice;
        }

        public void setDqprice(String dqprice) {
            this.dqprice = dqprice;
        }

        public String getStatus_msg() {
            return status_msg;
        }

        public void setStatus_msg(String status_msg) {
            this.status_msg = status_msg;
        }
    }
}
