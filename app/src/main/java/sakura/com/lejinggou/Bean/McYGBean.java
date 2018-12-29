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
public class McYGBean {

    /**
     * status : 1
     * info : 信息拉取成功
     * data : {"starttime":"1546081200","endtime":"1546185600","dj":"20.00","bzj":"10.00","type":2,"s":29344}
     */

    private int status;
    private String info;
    private DataBean data;

    public static List<McYGBean> arrayMcYGBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<McYGBean>>() {
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
         * starttime : 1546081200
         * endtime : 1546185600
         * dj : 20.00
         * bzj : 10.00
         * type : 2
         * s : 29344
         */

        private String starttime;
        private String endtime;
        private String dj;
        private String bzj;
        private int type;
        private int s;

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
    }
}
