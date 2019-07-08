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
public class CreateBillBean {

    /**
     * address : {"id":0,"uid":1,"name":"asdasd","tel":"17629345001","ssx":"河南省郑州市中原区","address":"asdasdasd","addtime":"1562554463","isMr":1}
     * goods : {"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D","jftypeid":"6","price":100,"date":"2019-06-28 13:46:01","supplier":"和田玉","needintegral":"0.1","stock":"7","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562055537070upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000010.tmp.png?Expires=1877415537&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=Ie3GxqFsnFzRf5%2FTlHDJIeNQUMQ%3D,","state":"0","paixu":10,"url":""}
     * usermoney : 10001.05
     * oid : 14
     * userjf : 10000
     */

    private AddressBean address;
    private GoodsBean goods;
    private String usermoney;
    private String oid;
    private String userjf;

    public static List<CreateBillBean> arrayCreateBillBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<CreateBillBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public GoodsBean getGoods() {
        return goods;
    }

    public void setGoods(GoodsBean goods) {
        this.goods = goods;
    }

    public String getUsermoney() {
        return usermoney;
    }

    public void setUsermoney(String usermoney) {
        this.usermoney = usermoney;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getUserjf() {
        return userjf;
    }

    public void setUserjf(String userjf) {
        this.userjf = userjf;
    }

    public static class AddressBean {
        /**
         * id : 0
         * uid : 1
         * name : asdasd
         * tel : 17629345001
         * ssx : 河南省郑州市中原区
         * address : asdasdasd
         * addtime : 1562554463
         * isMr : 1
         */

        private String id;
        private String uid;
        private String name;
        private String tel;
        private String ssx;
        private String address;
        private String addtime;
        private String isMr;

        public static List<AddressBean> arrayAddressBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<AddressBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
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

        public String getSsx() {
            return ssx;
        }

        public void setSsx(String ssx) {
            this.ssx = ssx;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getIsMr() {
            return isMr;
        }

        public void setIsMr(String isMr) {
            this.isMr = isMr;
        }
    }

    public static class GoodsBean {
        /**
         * id : 4
         * name : 和田玉1
         * fengmian : http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D
         * jftypeid : 6
         * price : 100.0
         * date : 2019-06-28 13:46:01
         * supplier : 和田玉
         * needintegral : 0.1
         * stock : 7
         * tupian : http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562055537070upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000010.tmp.png?Expires=1877415537&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=Ie3GxqFsnFzRf5%2FTlHDJIeNQUMQ%3D,
         * state : 0
         * paixu : 10
         * url :
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
        private String tupian;
        private String state;
        private String paixu;
        private String url;

        public static List<GoodsBean> arrayGoodsBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<GoodsBean>>() {
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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
