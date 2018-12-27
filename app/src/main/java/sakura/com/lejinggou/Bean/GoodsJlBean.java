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
     * data : {"type":2,"list":[{"addtime":"1545830471","bs":"250.00","nickname":"哈哈大笑","headimg":"/Public/uploads/lb/2018-12-26/2018_12_26_164348_6557.jpeg"},{"addtime":"1545815793","bs":"200.00","nickname":"喂","headimg":"/Public/uploads/lb/2018-12-26/2018_12_26_170323_9038.jpeg"},{"addtime":"1545814101","bs":"150.00","nickname":"哈哈大笑","headimg":"/Public/uploads/lb/2018-12-26/2018_12_26_164348_6557.jpeg"}]}
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
         * list : [{"addtime":"1545830471","bs":"250.00","nickname":"哈哈大笑","headimg":"/Public/uploads/lb/2018-12-26/2018_12_26_164348_6557.jpeg"},{"addtime":"1545815793","bs":"200.00","nickname":"喂","headimg":"/Public/uploads/lb/2018-12-26/2018_12_26_170323_9038.jpeg"},{"addtime":"1545814101","bs":"150.00","nickname":"哈哈大笑","headimg":"/Public/uploads/lb/2018-12-26/2018_12_26_164348_6557.jpeg"}]
         */

        private int type;
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

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * addtime : 1545830471
             * bs : 250.00
             * nickname : 哈哈大笑
             * headimg : /Public/uploads/lb/2018-12-26/2018_12_26_164348_6557.jpeg
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
