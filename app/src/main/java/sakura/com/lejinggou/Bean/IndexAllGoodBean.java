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
 * @date 2019/6/29
 * 功能描述：
 */
public class IndexAllGoodBean {


    /**
     * status : 1
     * info : 信息拉取成功
     * data : {"jfgoods":[{"name":"和田玉","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1561701353431upload_33893842_d13a_4f5e_ba97_a2b5e39d371e_00000053.tmp.jpg?Expires=1877061353&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=JaaDv8TpzmFy2WbFlTBhRwe3uiI%3D","price":"100.00","supplier":"和田玉","needintegral":"10000"}],"rg":[{"id":"1","name":"测试商品1","fm_img":"/Public/uploads/lb/2019-06-28/2019_06_28_150008_1349.png","gys":"测试商品1","dqprice":"20000.00","starttime":"1561651200","endtime":"1561824000","s":26275,"type":1}],"yg":[{"id":"4","name":"测试商品4","fm_img":"/Public/uploads/lb/2019-06-29/2019_06_29_151934_5916.png","gys":"测试商品4","dqprice":"20000.00","starttime":"1561816800","endtime":"1561824000","s":19075,"type":2}],"ls":[{"id":"2","name":"测试商品2","fm_img":"/Public/uploads/lb/2019-06-29/2019_06_29_151217_6203.png","gys":"测试商品2","dqprice":"20000.00","starttime":"1561737600","endtime":"1561741200","type":3}]}
     */

    private String status;
    private String info;
    private DataBean data;

    public static List<IndexAllGoodBean> arrayIndexAllGoodBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<IndexAllGoodBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
        private List<JfgoodsBean> jfgoods;
        private List<RgBean> rg;
        private List<YgBean> yg;
        private List<LsBean> ls;

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public List<JfgoodsBean> getJfgoods() {
            return jfgoods;
        }

        public void setJfgoods(List<JfgoodsBean> jfgoods) {
            this.jfgoods = jfgoods;
        }

        public List<RgBean> getRg() {
            return rg;
        }

        public void setRg(List<RgBean> rg) {
            this.rg = rg;
        }

        public List<YgBean> getYg() {
            return yg;
        }

        public void setYg(List<YgBean> yg) {
            this.yg = yg;
        }

        public List<LsBean> getLs() {
            return ls;
        }

        public void setLs(List<LsBean> ls) {
            this.ls = ls;
        }

        public static class JfgoodsBean {
            /**
             * name : 和田玉
             * fengmian : http://wei1218.oss-cn-beijing.aliyuncs.com/1561701353431upload_33893842_d13a_4f5e_ba97_a2b5e39d371e_00000053.tmp.jpg?Expires=1877061353&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=JaaDv8TpzmFy2WbFlTBhRwe3uiI%3D
             * price : 100.00
             * supplier : 和田玉
             * needintegral : 10000
             */

            private String name;
            private String id;
            private String fengmian;
            private String price;
            private String supplier;
            private String needintegral;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static List<JfgoodsBean> arrayJfgoodsBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<JfgoodsBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
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

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
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
        }

        public static class RgBean {
            /**
             * id : 1
             * name : 测试商品1
             * fm_img : /Public/uploads/lb/2019-06-28/2019_06_28_150008_1349.png
             * gys : 测试商品1
             * dqprice : 20000.00
             * starttime : 1561651200
             * endtime : 1561824000
             * s : 26275
             * type : 1
             */

            private String id;
            private String name;
            private String fm_img;
            private String gys;
            private String dqprice;
            private String starttime;
            private String endtime;
            private int s;
            private String type;

            public static List<RgBean> arrayRgBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<RgBean>>() {
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

            public String getFm_img() {
                return fm_img;
            }

            public void setFm_img(String fm_img) {
                this.fm_img = fm_img;
            }

            public String getGys() {
                return gys;
            }

            public void setGys(String gys) {
                this.gys = gys;
            }

            public String getDqprice() {
                return dqprice;
            }

            public void setDqprice(String dqprice) {
                this.dqprice = dqprice;
            }

            public String getStarttime() {
                return starttime;
            }

            public void setStarttime(String starttime) {
                this.starttime = starttime;
            }

            public String getEndtime() {
                return endtime;
            }

            public void setEndtime(String endtime) {
                this.endtime = endtime;
            }

            public int getS() {
                return s;
            }

            public void setS(int s) {
                this.s = s;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class YgBean {
            /**
             * id : 4
             * name : 测试商品4
             * fm_img : /Public/uploads/lb/2019-06-29/2019_06_29_151934_5916.png
             * gys : 测试商品4
             * dqprice : 20000.00
             * starttime : 1561816800
             * endtime : 1561824000
             * s : 19075
             * type : 2
             */

            private String id;
            private String name;
            private String fm_img;
            private String gys;
            private String dqprice;
            private String starttime;
            private String endtime;
            private int s;
            private String type;

            public static List<YgBean> arrayYgBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<YgBean>>() {
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

            public String getFm_img() {
                return fm_img;
            }

            public void setFm_img(String fm_img) {
                this.fm_img = fm_img;
            }

            public String getGys() {
                return gys;
            }

            public void setGys(String gys) {
                this.gys = gys;
            }

            public String getDqprice() {
                return dqprice;
            }

            public void setDqprice(String dqprice) {
                this.dqprice = dqprice;
            }

            public String getStarttime() {
                return starttime;
            }

            public void setStarttime(String starttime) {
                this.starttime = starttime;
            }

            public String getEndtime() {
                return endtime;
            }

            public void setEndtime(String endtime) {
                this.endtime = endtime;
            }

            public int getS() {
                return s;
            }

            public void setS(int s) {
                this.s = s;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class LsBean {
            /**
             * id : 2
             * name : 测试商品2
             * fm_img : /Public/uploads/lb/2019-06-29/2019_06_29_151217_6203.png
             * gys : 测试商品2
             * dqprice : 20000.00
             * starttime : 1561737600
             * endtime : 1561741200
             * type : 3
             */

            private String id;
            private String name;
            private String fm_img;
            private String gys;
            private String dqprice;
            private String starttime;
            private String endtime;
            private String type;

            public int getS() {
                return s;
            }

            public void setS(int s) {
                this.s = s;
            }

            private int s = 0;


            public static List<LsBean> arrayLsBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<LsBean>>() {
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

            public String getFm_img() {
                return fm_img;
            }

            public void setFm_img(String fm_img) {
                this.fm_img = fm_img;
            }

            public String getGys() {
                return gys;
            }

            public void setGys(String gys) {
                this.gys = gys;
            }

            public String getDqprice() {
                return dqprice;
            }

            public void setDqprice(String dqprice) {
                this.dqprice = dqprice;
            }

            public String getStarttime() {
                return starttime;
            }

            public void setStarttime(String starttime) {
                this.starttime = starttime;
            }

            public String getEndtime() {
                return endtime;
            }

            public void setEndtime(String endtime) {
                this.endtime = endtime;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
