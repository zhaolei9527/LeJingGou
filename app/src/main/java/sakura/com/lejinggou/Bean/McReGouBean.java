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
 * @date 2018/12/29
 * 功能描述：
 */
public class McReGouBean {

    /**
     * status : 1
     * info : 信息拉取成功
     * data : {"starttime":"1546012800","endtime":"1546099200","dj":"200.00","bzj":"100.00","type":1,"s":37768,"is_jlbzj":0,"uname":"哈哈大笑","uheadimg":"/Public/uploads/lb/2018-12-26/2018_12_26_164348_6557.jpeg","price":"240.00","list":[{"id":"1213","uid":"38","bs":"240.00","sy":"1.00","addtime":"1546052686","nickname":"哈哈大笑","headimg":"/Public/uploads/lb/2018-12-26/2018_12_26_164348_6557.jpeg"},{"id":"1212","uid":"28","bs":"230.00","sy":"1.00","addtime":"1546052683","nickname":"张大白","headimg":"/Public/uploads/goods/2018-12-26/2018_12_26_112908_9820.png"},{"id":"1211","uid":"27","bs":"220.00","sy":"1.00","addtime":"1546052683","nickname":"学不会、你要的低调","headimg":"/Public/uploads/goods/2018-12-26/2018_12_26_112846_7686.jpg"},{"id":"1210","uid":"38","bs":"210.00","sy":"1.00","addtime":"1546052683","nickname":"哈哈大笑","headimg":"/Public/uploads/lb/2018-12-26/2018_12_26_164348_6557.jpeg"}],"end":"1213","top":"1210"}
     */

    private int status;
    private String info;
    private DataBean data;

    public static List<McReGouBean> arrayMcYuGouBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<McReGouBean>>() {
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
         * starttime : 1546012800
         * endtime : 1546099200
         * dj : 200.00
         * bzj : 100.00
         * type : 1
         * s : 37768
         * is_jlbzj : 0
         * uname : 哈哈大笑
         * uheadimg : /Public/uploads/lb/2018-12-26/2018_12_26_164348_6557.jpeg
         * price : 240.00
         * list : [{"id":"1213","uid":"38","bs":"240.00","sy":"1.00","addtime":"1546052686","nickname":"哈哈大笑","headimg":"/Public/uploads/lb/2018-12-26/2018_12_26_164348_6557.jpeg"},{"id":"1212","uid":"28","bs":"230.00","sy":"1.00","addtime":"1546052683","nickname":"张大白","headimg":"/Public/uploads/goods/2018-12-26/2018_12_26_112908_9820.png"},{"id":"1211","uid":"27","bs":"220.00","sy":"1.00","addtime":"1546052683","nickname":"学不会、你要的低调","headimg":"/Public/uploads/goods/2018-12-26/2018_12_26_112846_7686.jpg"},{"id":"1210","uid":"38","bs":"210.00","sy":"1.00","addtime":"1546052683","nickname":"哈哈大笑","headimg":"/Public/uploads/lb/2018-12-26/2018_12_26_164348_6557.jpeg"}]
         * end : 1213
         * top : 1210
         */

        private String starttime;
        private String endtime;
        private String dj;
        private String bzj;
        private int type;
        private int s;
        private int is_jlbzj;
        private String uname;
        private String uheadimg;
        private String price;
        private String end;
        private String top;
        private List<ListBean> list;

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
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

        public String getDj() {
            return dj;
        }

        public void setDj(String dj) {
            this.dj = dj;
        }

        public String getBzj() {
            return bzj;
        }

        public void setBzj(String bzj) {
            this.bzj = bzj;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getS() {
            return s;
        }

        public void setS(int s) {
            this.s = s;
        }

        public int getIs_jlbzj() {
            return is_jlbzj;
        }

        public void setIs_jlbzj(int is_jlbzj) {
            this.is_jlbzj = is_jlbzj;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public String getUheadimg() {
            return uheadimg;
        }

        public void setUheadimg(String uheadimg) {
            this.uheadimg = uheadimg;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public String getTop() {
            return top;
        }

        public void setTop(String top) {
            this.top = top;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 1213
             * uid : 38
             * bs : 240.00
             * sy : 1.00
             * addtime : 1546052686
             * nickname : 哈哈大笑
             * headimg : /Public/uploads/lb/2018-12-26/2018_12_26_164348_6557.jpeg
             */

            private String id;
            private String uid;
            private String bs;
            private String sy;
            private String addtime;
            private String nickname;
            private String headimg;

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

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getBs() {
                return bs;
            }

            public void setBs(String bs) {
                this.bs = bs;
            }

            public String getSy() {
                return sy;
            }

            public void setSy(String sy) {
                this.sy = sy;
            }

            public String getAddtime() {
                return addtime;
            }

            public void setAddtime(String addtime) {
                this.addtime = addtime;
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
