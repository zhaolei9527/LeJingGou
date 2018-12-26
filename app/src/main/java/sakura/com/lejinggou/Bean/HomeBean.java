package sakura.com.lejinggou.Bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * com.lingqiapp.Bean
 *
 * @author 赵磊
 * @date 2018/9/26
 * 功能描述：
 */
public class HomeBean {

    /**
     * status : 1
     * info : 信息拉取成功
     * data : {"dyurl":"http://ljg.t.100help.net/ym/lxkf.html","img":["/Public/uploads/lb/2018-11-23/2018_11_23_095524_4083.jpg","/Public/uploads/lb/2018-11-23/2018_11_23_095545_3642.jpg","/Public/uploads/lb/2018-11-23/2018_11_23_095604_2579.jpg"],"news":[{"title":"在每个人生阶段，如何升级你的翡翠？","id":"11"},{"title":"青海玉的秘密","id":"9"},{"title":"这是一条新闻","id":"7"}],"rg":[{"id":"47","name":"卷浪/2018冬季新款人字纹圆领毛衣女宽松韩版套头针织衫网红短款","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_160348_7556.png","gys":"早安日记文艺生活馆 ","dqprice":"530.00","starttime":"1544688209","endtime":"1546243411","s":455719,"type":1},{"id":"46","name":"定制西域 骆驼冲锋衣男女两件套三合一透气防风柔软面料保暖衣潮","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_155337_4252.jpg","gys":"正品户外运动服装 ","dqprice":"450.00","starttime":"1544687587","endtime":"1546242791","s":455099,"type":1},{"id":"45","name":"德国波梵森秋冬季户外冲锋衣男女三合一两件套防水保暖登山服潮牌","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_155129_7975.jpg","gys":"bonbfenssan波梵森旗舰店","dqprice":"1500.00","starttime":"1544687387","endtime":"1546242592","s":454900,"type":1},{"id":"44","name":"慕思床垫 独立筒弹簧床垫 2cm天然乳胶床垫1.8米席梦思 美脊版","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_154537_8974.jpg","gys":"慕思旗舰店 ","dqprice":"5000.00","starttime":"1544702400","endtime":"1546242228","s":454536,"type":1},{"id":"43","name":"海马床垫1.5m1.8米软硬两用乳胶椰棕20cm厚15cm厚席梦思床垫1.2米","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_154154_7555.jpg","gys":"海马席梦思工厂折扣店 ","dqprice":"500.00","starttime":"1544773253","endtime":"1546242056","s":454364,"type":1},{"id":"42","name":"2018秋冬新品女装韩国V领撞色亮丝兔毛混纺女士显瘦毛衣 圣诞版","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_153956_8791.jpg","gys":"KACIA STUDIO ","dqprice":"50.00","starttime":"1544686746","endtime":"1546241951","s":454259,"type":1}],"yg":[{"id":"47","name":"卷浪/2018冬季新款人字纹圆领毛衣女宽松韩版套头针织衫网红短款","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_160348_7556.png","gys":"早安日记文艺生活馆 ","dqprice":"530.00","starttime":"1544688209","endtime":"1546243411","s":455719,"type":1},{"id":"46","name":"定制西域 骆驼冲锋衣男女两件套三合一透气防风柔软面料保暖衣潮","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_155337_4252.jpg","gys":"正品户外运动服装 ","dqprice":"450.00","starttime":"1544687587","endtime":"1546242791","s":455099,"type":1},{"id":"45","name":"德国波梵森秋冬季户外冲锋衣男女三合一两件套防水保暖登山服潮牌","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_155129_7975.jpg","gys":"bonbfenssan波梵森旗舰店","dqprice":"1500.00","starttime":"1544687387","endtime":"1546242592","s":454900,"type":1},{"id":"44","name":"慕思床垫 独立筒弹簧床垫 2cm天然乳胶床垫1.8米席梦思 美脊版","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_154537_8974.jpg","gys":"慕思旗舰店 ","dqprice":"5000.00","starttime":"1544702400","endtime":"1546242228","s":454536,"type":1},{"id":"43","name":"海马床垫1.5m1.8米软硬两用乳胶椰棕20cm厚15cm厚席梦思床垫1.2米","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_154154_7555.jpg","gys":"海马席梦思工厂折扣店 ","dqprice":"500.00","starttime":"1544773253","endtime":"1546242056","s":454364,"type":1},{"id":"42","name":"2018秋冬新品女装韩国V领撞色亮丝兔毛混纺女士显瘦毛衣 圣诞版","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_153956_8791.jpg","gys":"KACIA STUDIO ","dqprice":"50.00","starttime":"1544686746","endtime":"1546241951","s":454259,"type":1}],"ls":[{"id":"47","name":"卷浪/2018冬季新款人字纹圆领毛衣女宽松韩版套头针织衫网红短款","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_160348_7556.png","gys":"早安日记文艺生活馆 ","dqprice":"530.00","starttime":"1544688209","endtime":"1546243411","s":455719,"type":1},{"id":"46","name":"定制西域 骆驼冲锋衣男女两件套三合一透气防风柔软面料保暖衣潮","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_155337_4252.jpg","gys":"正品户外运动服装 ","dqprice":"450.00","starttime":"1544687587","endtime":"1546242791","s":455099,"type":1},{"id":"45","name":"德国波梵森秋冬季户外冲锋衣男女三合一两件套防水保暖登山服潮牌","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_155129_7975.jpg","gys":"bonbfenssan波梵森旗舰店","dqprice":"1500.00","starttime":"1544687387","endtime":"1546242592","s":454900,"type":1},{"id":"44","name":"慕思床垫 独立筒弹簧床垫 2cm天然乳胶床垫1.8米席梦思 美脊版","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_154537_8974.jpg","gys":"慕思旗舰店 ","dqprice":"5000.00","starttime":"1544702400","endtime":"1546242228","s":454536,"type":1},{"id":"43","name":"海马床垫1.5m1.8米软硬两用乳胶椰棕20cm厚15cm厚席梦思床垫1.2米","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_154154_7555.jpg","gys":"海马席梦思工厂折扣店 ","dqprice":"500.00","starttime":"1544773253","endtime":"1546242056","s":454364,"type":1},{"id":"42","name":"2018秋冬新品女装韩国V领撞色亮丝兔毛混纺女士显瘦毛衣 圣诞版","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_153956_8791.jpg","gys":"KACIA STUDIO ","dqprice":"50.00","starttime":"1544686746","endtime":"1546241951","s":454259,"type":1}]}
     */

    private int status;
    private String info;
    private DataBean data;

    public static List<HomeBean> arrayHomeBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<HomeBean>>() {
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
         * dyurl : http://ljg.t.100help.net/ym/lxkf.html
         * img : ["/Public/uploads/lb/2018-11-23/2018_11_23_095524_4083.jpg","/Public/uploads/lb/2018-11-23/2018_11_23_095545_3642.jpg","/Public/uploads/lb/2018-11-23/2018_11_23_095604_2579.jpg"]
         * news : [{"title":"在每个人生阶段，如何升级你的翡翠？","id":"11"},{"title":"青海玉的秘密","id":"9"},{"title":"这是一条新闻","id":"7"}]
         * rg : [{"id":"47","name":"卷浪/2018冬季新款人字纹圆领毛衣女宽松韩版套头针织衫网红短款","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_160348_7556.png","gys":"早安日记文艺生活馆 ","dqprice":"530.00","starttime":"1544688209","endtime":"1546243411","s":455719,"type":1},{"id":"46","name":"定制西域 骆驼冲锋衣男女两件套三合一透气防风柔软面料保暖衣潮","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_155337_4252.jpg","gys":"正品户外运动服装 ","dqprice":"450.00","starttime":"1544687587","endtime":"1546242791","s":455099,"type":1},{"id":"45","name":"德国波梵森秋冬季户外冲锋衣男女三合一两件套防水保暖登山服潮牌","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_155129_7975.jpg","gys":"bonbfenssan波梵森旗舰店","dqprice":"1500.00","starttime":"1544687387","endtime":"1546242592","s":454900,"type":1},{"id":"44","name":"慕思床垫 独立筒弹簧床垫 2cm天然乳胶床垫1.8米席梦思 美脊版","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_154537_8974.jpg","gys":"慕思旗舰店 ","dqprice":"5000.00","starttime":"1544702400","endtime":"1546242228","s":454536,"type":1},{"id":"43","name":"海马床垫1.5m1.8米软硬两用乳胶椰棕20cm厚15cm厚席梦思床垫1.2米","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_154154_7555.jpg","gys":"海马席梦思工厂折扣店 ","dqprice":"500.00","starttime":"1544773253","endtime":"1546242056","s":454364,"type":1},{"id":"42","name":"2018秋冬新品女装韩国V领撞色亮丝兔毛混纺女士显瘦毛衣 圣诞版","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_153956_8791.jpg","gys":"KACIA STUDIO ","dqprice":"50.00","starttime":"1544686746","endtime":"1546241951","s":454259,"type":1}]
         * yg : [{"id":"47","name":"卷浪/2018冬季新款人字纹圆领毛衣女宽松韩版套头针织衫网红短款","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_160348_7556.png","gys":"早安日记文艺生活馆 ","dqprice":"530.00","starttime":"1544688209","endtime":"1546243411","s":455719,"type":1},{"id":"46","name":"定制西域 骆驼冲锋衣男女两件套三合一透气防风柔软面料保暖衣潮","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_155337_4252.jpg","gys":"正品户外运动服装 ","dqprice":"450.00","starttime":"1544687587","endtime":"1546242791","s":455099,"type":1},{"id":"45","name":"德国波梵森秋冬季户外冲锋衣男女三合一两件套防水保暖登山服潮牌","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_155129_7975.jpg","gys":"bonbfenssan波梵森旗舰店","dqprice":"1500.00","starttime":"1544687387","endtime":"1546242592","s":454900,"type":1},{"id":"44","name":"慕思床垫 独立筒弹簧床垫 2cm天然乳胶床垫1.8米席梦思 美脊版","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_154537_8974.jpg","gys":"慕思旗舰店 ","dqprice":"5000.00","starttime":"1544702400","endtime":"1546242228","s":454536,"type":1},{"id":"43","name":"海马床垫1.5m1.8米软硬两用乳胶椰棕20cm厚15cm厚席梦思床垫1.2米","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_154154_7555.jpg","gys":"海马席梦思工厂折扣店 ","dqprice":"500.00","starttime":"1544773253","endtime":"1546242056","s":454364,"type":1},{"id":"42","name":"2018秋冬新品女装韩国V领撞色亮丝兔毛混纺女士显瘦毛衣 圣诞版","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_153956_8791.jpg","gys":"KACIA STUDIO ","dqprice":"50.00","starttime":"1544686746","endtime":"1546241951","s":454259,"type":1}]
         * ls : [{"id":"47","name":"卷浪/2018冬季新款人字纹圆领毛衣女宽松韩版套头针织衫网红短款","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_160348_7556.png","gys":"早安日记文艺生活馆 ","dqprice":"530.00","starttime":"1544688209","endtime":"1546243411","s":455719,"type":1},{"id":"46","name":"定制西域 骆驼冲锋衣男女两件套三合一透气防风柔软面料保暖衣潮","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_155337_4252.jpg","gys":"正品户外运动服装 ","dqprice":"450.00","starttime":"1544687587","endtime":"1546242791","s":455099,"type":1},{"id":"45","name":"德国波梵森秋冬季户外冲锋衣男女三合一两件套防水保暖登山服潮牌","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_155129_7975.jpg","gys":"bonbfenssan波梵森旗舰店","dqprice":"1500.00","starttime":"1544687387","endtime":"1546242592","s":454900,"type":1},{"id":"44","name":"慕思床垫 独立筒弹簧床垫 2cm天然乳胶床垫1.8米席梦思 美脊版","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_154537_8974.jpg","gys":"慕思旗舰店 ","dqprice":"5000.00","starttime":"1544702400","endtime":"1546242228","s":454536,"type":1},{"id":"43","name":"海马床垫1.5m1.8米软硬两用乳胶椰棕20cm厚15cm厚席梦思床垫1.2米","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_154154_7555.jpg","gys":"海马席梦思工厂折扣店 ","dqprice":"500.00","starttime":"1544773253","endtime":"1546242056","s":454364,"type":1},{"id":"42","name":"2018秋冬新品女装韩国V领撞色亮丝兔毛混纺女士显瘦毛衣 圣诞版","fm_img":"/Public/uploads/lb/2018-12-13/2018_12_13_153956_8791.jpg","gys":"KACIA STUDIO ","dqprice":"50.00","starttime":"1544686746","endtime":"1546241951","s":454259,"type":1}]
         */

        private String dyurl;
        private List<String> img;
        private List<NewsBean> news;
        private List<RgBean> rg;
        private List<YgBean> yg;
        private List<LsBean> ls;

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getDyurl() {
            return dyurl;
        }

        public void setDyurl(String dyurl) {
            this.dyurl = dyurl;
        }

        public List<String> getImg() {
            return img;
        }

        public void setImg(List<String> img) {
            this.img = img;
        }

        public List<NewsBean> getNews() {
            return news;
        }

        public void setNews(List<NewsBean> news) {
            this.news = news;
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

        public static class NewsBean {
            /**
             * title : 在每个人生阶段，如何升级你的翡翠？
             * id : 11
             */

            private String title;
            private String id;

            public static List<NewsBean> arrayNewsBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<NewsBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class RgBean {
            /**
             * id : 47
             * name : 卷浪/2018冬季新款人字纹圆领毛衣女宽松韩版套头针织衫网红短款
             * fm_img : /Public/uploads/lb/2018-12-13/2018_12_13_160348_7556.png
             * gys : 早安日记文艺生活馆
             * dqprice : 530.00
             * starttime : 1544688209
             * endtime : 1546243411
             * s : 455719
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
            private int type;

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

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class YgBean {
            /**
             * id : 47
             * name : 卷浪/2018冬季新款人字纹圆领毛衣女宽松韩版套头针织衫网红短款
             * fm_img : /Public/uploads/lb/2018-12-13/2018_12_13_160348_7556.png
             * gys : 早安日记文艺生活馆
             * dqprice : 530.00
             * starttime : 1544688209
             * endtime : 1546243411
             * s : 455719
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
            private int type;

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

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class LsBean {
            /**
             * id : 47
             * name : 卷浪/2018冬季新款人字纹圆领毛衣女宽松韩版套头针织衫网红短款
             * fm_img : /Public/uploads/lb/2018-12-13/2018_12_13_160348_7556.png
             * gys : 早安日记文艺生活馆
             * dqprice : 530.00
             * starttime : 1544688209
             * endtime : 1546243411
             * s : 455719
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
            private int type;

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

            public int getS() {
                return s;
            }

            public void setS(int s) {
                this.s = s;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
