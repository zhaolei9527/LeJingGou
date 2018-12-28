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
 * @date 2018/12/28
 * 功能描述：
 */
public class SymxBean {

    /**
     * status : 1
     * info : 信息拉取成功
     * data : [{"gid":"94","sy":"1.00","addtime":"1545977497","bs":"1090.00","gname":"弘音短筝成人练习专业实木半筝便携式小型迷你小古筝儿童初学入门 "},{"gid":"94","sy":"1.00","addtime":"1545977272","bs":"1020.00","gname":"弘音短筝成人练习专业实木半筝便携式小型迷你小古筝儿童初学入门 "},{"gid":"93","sy":"20.00","addtime":"1545960501","bs":"1200.00","gname":"扬州莫高黑檀古筝高档实木刻字素面成人初学入门专业考级演奏包邮"},{"gid":"90","sy":"1.00","addtime":"1545906100","bs":"110.00","gname":"asdfasdf"},{"gid":"89","sy":"1.00","addtime":"1545906027","bs":"110.00","gname":"adasd"},{"gid":"88","sy":"1.00","addtime":"1545905677","bs":"110.00","gname":"ASSD"}]
     */

    private int status;
    private String info;
    private List<DataBean> data;

    public static List<SymxBean> arraySymxBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<SymxBean>>() {
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * gid : 94
         * sy : 1.00
         * addtime : 1545977497
         * bs : 1090.00
         * gname : 弘音短筝成人练习专业实木半筝便携式小型迷你小古筝儿童初学入门
         */

        private String gid;
        private String sy;
        private String addtime;
        private String bs;
        private String gname;

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getGid() {
            return gid;
        }

        public void setGid(String gid) {
            this.gid = gid;
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

        public String getBs() {
            return bs;
        }

        public void setBs(String bs) {
            this.bs = bs;
        }

        public String getGname() {
            return gname;
        }

        public void setGname(String gname) {
            this.gname = gname;
        }
    }
}
