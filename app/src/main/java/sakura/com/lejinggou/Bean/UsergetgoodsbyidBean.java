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
     * list : {"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D","jftypeid":"6","price":100,"date":"2019-06-28 13:46:01","supplier":"和田玉","needintegral":"10000","stock":"10","state":"0","paixu":10,"url":"http://152.136.187.246/ym/jf/id/4.html","tupianlist":["http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D","http://wei1218.oss-cn-beijing.aliyuncs.com/1562055537070upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000010.tmp.png?Expires=1877415537&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=Ie3GxqFsnFzRf5%2FTlHDJIeNQUMQ%3D"]}
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
         * id : 4
         * name : 和田玉1
         * fengmian : http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D
         * jftypeid : 6
         * price : 100.0
         * date : 2019-06-28 13:46:01
         * supplier : 和田玉
         * needintegral : 10000
         * stock : 10
         * state : 0
         * paixu : 10
         * url : http://152.136.187.246/ym/jf/id/4.html
         * tupianlist : ["http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D","http://wei1218.oss-cn-beijing.aliyuncs.com/1562055537070upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000010.tmp.png?Expires=1877415537&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=Ie3GxqFsnFzRf5%2FTlHDJIeNQUMQ%3D"]
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
        private String state;
        private String paixu;
        private String url;
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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<String> getTupianlist() {
            return tupianlist;
        }

        public void setTupianlist(List<String> tupianlist) {
            this.tupianlist = tupianlist;
        }
    }
}
