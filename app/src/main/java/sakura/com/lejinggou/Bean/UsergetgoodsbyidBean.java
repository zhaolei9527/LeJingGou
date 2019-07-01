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
 * @date 2019/7/1
 * 功能描述：
 */
public class UsergetgoodsbyidBean {

    /**
     * msg : 获取成功
     * list : {"id":10,"name":"和田","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1561806468242upload_4616efc4_c4fe_4229_b28b_0e0c6df714f0_00000008.tmp.png?Expires=1877166468&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=qBDc4HjZTWDab6zCA%2FL1nAJuiWk%3D","jftypeid":"4","price":12,"date":"2019-06-29 19:07:49","supplier":"和田","needintegral":"12","stock":"12","shangjia":"3","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1561806468242upload_4616efc4_c4fe_4229_b28b_0e0c6df714f0_00000008.tmp.png?Expires=1877166468&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=qBDc4HjZTWDab6zCA%2FL1nAJuiWk%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1561806468717upload_4616efc4_c4fe_4229_b28b_0e0c6df714f0_00000009.tmp.jpg?Expires=1877166468&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=FLH9VTyYEfO4TAJygEIdt3uvMcE%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1561806468987upload_4616efc4_c4fe_4229_b28b_0e0c6df714f0_00000010.tmp.png?Expires=1877166468&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=lyUTFEKJSSTwubWvQsClJyShAn0%3D,","state":"0","paixu":12,"tupianlist":["http://wei1218.oss-cn-beijing.aliyuncs.com/1561806468242upload_4616efc4_c4fe_4229_b28b_0e0c6df714f0_00000008.tmp.png?Expires=1877166468&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=qBDc4HjZTWDab6zCA%2FL1nAJuiWk%3D","http://wei1218.oss-cn-beijing.aliyuncs.com/1561806468717upload_4616efc4_c4fe_4229_b28b_0e0c6df714f0_00000009.tmp.jpg?Expires=1877166468&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=FLH9VTyYEfO4TAJygEIdt3uvMcE%3D","http://wei1218.oss-cn-beijing.aliyuncs.com/1561806468987upload_4616efc4_c4fe_4229_b28b_0e0c6df714f0_00000010.tmp.png?Expires=1877166468&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=lyUTFEKJSSTwubWvQsClJyShAn0%3D"]}
     * status : 1
     */

    private String msg;
    private ListBean list;
    private String status;

    public static List<UsergetgoodsbyidBean> arrayUsergetgoodsbyidBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<UsergetgoodsbyidBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ListBean getList() {
        return list;
    }

    public void setList(ListBean list) {
        this.list = list;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ListBean {
        /**
         * id : 10
         * name : 和田
         * fengmian : http://wei1218.oss-cn-beijing.aliyuncs.com/1561806468242upload_4616efc4_c4fe_4229_b28b_0e0c6df714f0_00000008.tmp.png?Expires=1877166468&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=qBDc4HjZTWDab6zCA%2FL1nAJuiWk%3D
         * jftypeid : 4
         * price : 12.0
         * date : 2019-06-29 19:07:49
         * supplier : 和田
         * needintegral : 12
         * stock : 12
         * shangjia : 3
         * tupian : http://wei1218.oss-cn-beijing.aliyuncs.com/1561806468242upload_4616efc4_c4fe_4229_b28b_0e0c6df714f0_00000008.tmp.png?Expires=1877166468&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=qBDc4HjZTWDab6zCA%2FL1nAJuiWk%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1561806468717upload_4616efc4_c4fe_4229_b28b_0e0c6df714f0_00000009.tmp.jpg?Expires=1877166468&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=FLH9VTyYEfO4TAJygEIdt3uvMcE%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1561806468987upload_4616efc4_c4fe_4229_b28b_0e0c6df714f0_00000010.tmp.png?Expires=1877166468&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=lyUTFEKJSSTwubWvQsClJyShAn0%3D,
         * state : 0
         * paixu : 12
         * tupianlist : ["http://wei1218.oss-cn-beijing.aliyuncs.com/1561806468242upload_4616efc4_c4fe_4229_b28b_0e0c6df714f0_00000008.tmp.png?Expires=1877166468&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=qBDc4HjZTWDab6zCA%2FL1nAJuiWk%3D","http://wei1218.oss-cn-beijing.aliyuncs.com/1561806468717upload_4616efc4_c4fe_4229_b28b_0e0c6df714f0_00000009.tmp.jpg?Expires=1877166468&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=FLH9VTyYEfO4TAJygEIdt3uvMcE%3D","http://wei1218.oss-cn-beijing.aliyuncs.com/1561806468987upload_4616efc4_c4fe_4229_b28b_0e0c6df714f0_00000010.tmp.png?Expires=1877166468&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=lyUTFEKJSSTwubWvQsClJyShAn0%3D"]
         */

        private String id;
        private String name;
        private String fengmian;
        private String jftypeid;
        private String price;
        private String date;
        private String supplier;
        private String needintegral;
        private String stock;
        private String shangjia;
        private String tupian;
        private String state;
        private String paixu;
        private List<String> tupianlist;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFengmian() {
            return fengmian;
        }

        public void setFengmian(String fengmian) {
            this.fengmian = fengmian;
        }

        public String getJftypeid() {
            return jftypeid;
        }

        public void setJftypeid(String jftypeid) {
            this.jftypeid = jftypeid;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getSupplier() {
            return supplier;
        }

        public void setSupplier(String supplier) {
            this.supplier = supplier;
        }

        public String getNeedintegral() {
            return needintegral;
        }

        public void setNeedintegral(String needintegral) {
            this.needintegral = needintegral;
        }

        public String getStock() {
            return stock;
        }

        public void setStock(String stock) {
            this.stock = stock;
        }

        public String getShangjia() {
            return shangjia;
        }

        public void setShangjia(String shangjia) {
            this.shangjia = shangjia;
        }

        public String getTupian() {
            return tupian;
        }

        public void setTupian(String tupian) {
            this.tupian = tupian;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getPaixu() {
            return paixu;
        }

        public void setPaixu(String paixu) {
            this.paixu = paixu;
        }

        public List<String> getTupianlist() {
            return tupianlist;
        }

        public void setTupianlist(List<String> tupianlist) {
            this.tupianlist = tupianlist;
        }
    }
}
