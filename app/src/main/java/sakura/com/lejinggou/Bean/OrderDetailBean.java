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
     * data : {"id":"119","price":"9990.00","bzj":"10.00","status":"3","addtime":"1546412961","kdgs":"申通快递","kdbh":"123123123123123","name":"特斯拉","tel":"17629345001","address":"河南省郑州市中原区skr聚聚","gname":"和田玉-山水如画11000-14000-200","fm_img":"/Public/uploads/lb/2019-01-02/2019_01_02_150631_5060.png","dqprice":"10000.00","status_msg":"待收货"}
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
         * id : 119
         * price : 9990.00
         * bzj : 10.00
         * status : 3
         * addtime : 1546412961
         * kdgs : 申通快递
         * kdbh : 123123123123123
         * name : 特斯拉
         * tel : 17629345001
         * address : 河南省郑州市中原区skr聚聚
         * gname : 和田玉-山水如画11000-14000-200
         * fm_img : /Public/uploads/lb/2019-01-02/2019_01_02_150631_5060.png
         * dqprice : 10000.00
         * status_msg : 待收货
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
