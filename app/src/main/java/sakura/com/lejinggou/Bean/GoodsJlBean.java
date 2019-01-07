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
 * @date 2018/12/27
 * 功能描述：
 */
public class GoodsJlBean {

    /**
     * status : 1
     * info : 信息拉取成功
     * data : {"type":2,"list":[{"addtime":"1546667104","bs":"1230.00","nickname":"Sorry\u2019请停止爱我","headimg":"/Public/uploads/goods/2018-12-26/2018_12_26_112734_4584.jpg"},{"addtime":"1546667104","bs":"1435.00","nickname":"李皮皮","headimg":"/Public/uploads/goods/2019-01-02/2019_01_02_104708_1884.jpg"},{"addtime":"1546667104","bs":"1640.00","nickname":"njghua","headimg":"/Public/uploads/goods/2019-01-02/2019_01_02_112805_9966.jpg"},{"addtime":"1546667105","bs":"1845.00","nickname":"yoyo先生","headimg":"/Public/uploads/lb/2019-01-02/2019_01_02_134357_3977.png"},{"addtime":"1546667105","bs":"2050.00","nickname":"阎含","headimg":"/Public/uploads/goods/2019-01-02/2019_01_02_113410_7775.jpg"},{"addtime":"1546667105","bs":"2255.00","nickname":"哈哈大笑","headimg":"/Public/uploads/lb/2018-12-26/2018_12_26_164348_6557.jpeg"}],"dqj":{"addtime":"1546667108","bs":"10250.00","nickname":"独山玉","headimg":"/Public/home/images/f_icon6.png"}}
     */

    private int status;
    private String info;
    private DataBean data;

    public static List<GoodsJlBean> arrayGoodsJlBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GoodsJlBean>>() {
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
         * type : 2
         * list : [{"addtime":"1546667104","bs":"1230.00","nickname":"Sorry\u2019请停止爱我","headimg":"/Public/uploads/goods/2018-12-26/2018_12_26_112734_4584.jpg"},{"addtime":"1546667104","bs":"1435.00","nickname":"李皮皮","headimg":"/Public/uploads/goods/2019-01-02/2019_01_02_104708_1884.jpg"},{"addtime":"1546667104","bs":"1640.00","nickname":"njghua","headimg":"/Public/uploads/goods/2019-01-02/2019_01_02_112805_9966.jpg"},{"addtime":"1546667105","bs":"1845.00","nickname":"yoyo先生","headimg":"/Public/uploads/lb/2019-01-02/2019_01_02_134357_3977.png"},{"addtime":"1546667105","bs":"2050.00","nickname":"阎含","headimg":"/Public/uploads/goods/2019-01-02/2019_01_02_113410_7775.jpg"},{"addtime":"1546667105","bs":"2255.00","nickname":"哈哈大笑","headimg":"/Public/uploads/lb/2018-12-26/2018_12_26_164348_6557.jpeg"}]
         * dqj : {"addtime":"1546667108","bs":"10250.00","nickname":"独山玉","headimg":"/Public/home/images/f_icon6.png"}
         */

        private int type;
        private DqjBean dqj;
        private List<ListBean> list;

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public DqjBean getDqj() {
            return dqj;
        }

        public void setDqj(DqjBean dqj) {
            this.dqj = dqj;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class DqjBean {
            /**
             * addtime : 1546667108
             * bs : 10250.00
             * nickname : 独山玉
             * headimg : /Public/home/images/f_icon6.png
             */

            private String addtime;
            private String bs;
            private String nickname;
            private String headimg;

            public static List<DqjBean> arrayDqjBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<DqjBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public String getAddtime() {
                return addtime;
            }

            public void setAddtime(String addtime) {
                this.addtime = addtime;
            }

            public String getBs() {
                return bs;
            }

            public void setBs(String bs) {
                this.bs = bs;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getHeadimg() {
                return headimg;
            }

            public void setHeadimg(String headimg) {
                this.headimg = headimg;
            }
        }

        public static class ListBean {
            /**
             * addtime : 1546667104
             * bs : 1230.00
             * nickname : Sorry’请停止爱我
             * headimg : /Public/uploads/goods/2018-12-26/2018_12_26_112734_4584.jpg
             */

            private String addtime;
            private String bs;
            private String nickname;
            private String headimg;

            public static List<ListBean> arrayListBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<ListBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public String getAddtime() {
                return addtime;
            }

            public void setAddtime(String addtime) {
                this.addtime = addtime;
            }

            public String getBs() {
                return bs;
            }

            public void setBs(String bs) {
                this.bs = bs;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getHeadimg() {
                return headimg;
            }

            public void setHeadimg(String headimg) {
                this.headimg = headimg;
            }
        }
    }

}
