package sakura.com.lejinggou.Bean;

/**
 * sakura.com.lejinggou.Bean
 *
 * @author 赵磊
 * @date 2019/7/8
 * 功能描述：
 */
public class CreateBillBean {


    /**
     * msg : 获取成功
     * list : {"address":{"id":0,"uid":1,"name":"asda","tel":"17629345001","ssx":"河南省郑州市中原区","address":"asdasdasd","addtime":"1562588786","isMr":1},"goods":{"id":5,"name":"和田玉2","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562049584539upload_1e93ea05_a042_4be4_906a_b8253e80b888_00000033.tmp.png?Expires=1877409584&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=GxhSv7cAxGWFJ3LnHLlg14FRsjI%3D","jftypeid":"6","price":100,"date":"2019-06-28 13:46:01","supplier":"和田玉","needStringegral":"10000","stock":"10","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562049584539upload_1e93ea05_a042_4be4_906a_b8253e80b888_00000033.tmp.png?Expires=1877409584&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=GxhSv7cAxGWFJ3LnHLlg14FRsjI%3D,","state":"0","paixu":10,"url":""},"usermoney":0.94,"oid":72,"userjf":"0"}
     * status : 1
     */

    private String msg;
    private ListBean list;
    private String status;

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
         * address : {"id":0,"uid":1,"name":"asda","tel":"17629345001","ssx":"河南省郑州市中原区","address":"asdasdasd","addtime":"1562588786","isMr":1}
         * goods : {"id":5,"name":"和田玉2","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562049584539upload_1e93ea05_a042_4be4_906a_b8253e80b888_00000033.tmp.png?Expires=1877409584&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=GxhSv7cAxGWFJ3LnHLlg14FRsjI%3D","jftypeid":"6","price":100,"date":"2019-06-28 13:46:01","supplier":"和田玉","needStringegral":"10000","stock":"10","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562049584539upload_1e93ea05_a042_4be4_906a_b8253e80b888_00000033.tmp.png?Expires=1877409584&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=GxhSv7cAxGWFJ3LnHLlg14FRsjI%3D,","state":"0","paixu":10,"url":""}
         * usermoney : 0.94
         * oid : 72
         * userjf : 0
         */

        private AddressBean address;
        private GoodsBean goods;
        private String usermoney;
        private String oid;
        private String userjf;

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
             * name : asda
             * tel : 17629345001
             * ssx : 河南省郑州市中原区
             * address : asdasdasd
             * addtime : 1562588786
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
             * id : 5
             * name : 和田玉2
             * fengmian : http://wei1218.oss-cn-beijing.aliyuncs.com/1562049584539upload_1e93ea05_a042_4be4_906a_b8253e80b888_00000033.tmp.png?Expires=1877409584&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=GxhSv7cAxGWFJ3LnHLlg14FRsjI%3D
             * jftypeid : 6
             * price : 100.0
             * date : 2019-06-28 13:46:01
             * supplier : 和田玉
             * needStringegral : 10000
             * stock : 10
             * tupian : http://wei1218.oss-cn-beijing.aliyuncs.com/1562049584539upload_1e93ea05_a042_4be4_906a_b8253e80b888_00000033.tmp.png?Expires=1877409584&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=GxhSv7cAxGWFJ3LnHLlg14FRsjI%3D,
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

            public String getNeedintegral() {
                return needintegral;
            }

            public void setNeedintegral(String needintegral) {
                this.needintegral = needintegral;
            }

            private String needintegral;
            private String stock;
            private String tupian;
            private String state;
            private String paixu;
            private String url;

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
}
