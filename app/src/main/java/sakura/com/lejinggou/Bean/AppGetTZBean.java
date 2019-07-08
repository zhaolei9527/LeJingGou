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
public class AppGetTZBean {


    /**
     * msg : 获取成功
     * list : {"id":5,"goods":{"id":5,"name":"和田玉2","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562049584539upload_1e93ea05_a042_4be4_906a_b8253e80b888_00000033.tmp.png?Expires=1877409584&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=GxhSv7cAxGWFJ3LnHLlg14FRsjI%3D","jftypeid":"6","price":100,"date":"2019-06-28 13:46:01","supplier":"和田玉","needintegral":"10000","stock":"10","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562049584539upload_1e93ea05_a042_4be4_906a_b8253e80b888_00000033.tmp.png?Expires=1877409584&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=GxhSv7cAxGWFJ3LnHLlg14FRsjI%3D,","state":"0","context":"<p>\t\t\t\t<\/p><p><br/><\/p><p><br/><\/p><p>aaaa<\/p>","paixu":10,"url":""},"fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1561945170160upload_d0ed448b_b123_40aa_99e3_3f6871abba60_00000009.tmp.jpg?Expires=1877305170&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=3eK5KGJR4%2FAO8g32I3pR93DnG58%3D","date":"2019-07-01 09:39:30","state":"0","context":"aaa","uid":"1","editdate":"2019-07-01 09:39:30"}
     * status : 1
     */

    private String msg;
    private ListBean list;
    private String status;

    public static List<AppGetTZBean> arrayAppGetTZBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<AppGetTZBean>>() {
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
         * id : 5
         * goods : {"id":5,"name":"和田玉2","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562049584539upload_1e93ea05_a042_4be4_906a_b8253e80b888_00000033.tmp.png?Expires=1877409584&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=GxhSv7cAxGWFJ3LnHLlg14FRsjI%3D","jftypeid":"6","price":100,"date":"2019-06-28 13:46:01","supplier":"和田玉","needintegral":"10000","stock":"10","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562049584539upload_1e93ea05_a042_4be4_906a_b8253e80b888_00000033.tmp.png?Expires=1877409584&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=GxhSv7cAxGWFJ3LnHLlg14FRsjI%3D,","state":"0","context":"<p>\t\t\t\t<\/p><p><br/><\/p><p><br/><\/p><p>aaaa<\/p>","paixu":10,"url":""}
         * fengmian : http://wei1218.oss-cn-beijing.aliyuncs.com/1561945170160upload_d0ed448b_b123_40aa_99e3_3f6871abba60_00000009.tmp.jpg?Expires=1877305170&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=3eK5KGJR4%2FAO8g32I3pR93DnG58%3D
         * date : 2019-07-01 09:39:30
         * state : 0
         * context : aaa
         * uid : 1
         * editdate : 2019-07-01 09:39:30
         */

        private String id;
        private GoodsBean goods;
        private String fengmian;
        private String date;
        private String state;
        private String context;
        private String uid;
        private String editdate;

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

        public GoodsBean getGoods() {
            return goods;
        }

        public void setGoods(GoodsBean goods) {
            this.goods = goods;
        }

        public String getFengmian() {
            return fengmian;
        }

        public void setFengmian(String fengmian) {
            this.fengmian = fengmian;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getEditdate() {
            return editdate;
        }

        public void setEditdate(String editdate) {
            this.editdate = editdate;
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
             * needintegral : 10000
             * stock : 10
             * tupian : http://wei1218.oss-cn-beijing.aliyuncs.com/1562049584539upload_1e93ea05_a042_4be4_906a_b8253e80b888_00000033.tmp.png?Expires=1877409584&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=GxhSv7cAxGWFJ3LnHLlg14FRsjI%3D,
             * state : 0
             * context : <p>				</p><p><br/></p><p><br/></p><p>aaaa</p>
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
            private String context;
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

            public String getContext() {
                return context;
            }

            public void setContext(String context) {
                this.context = context;
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
