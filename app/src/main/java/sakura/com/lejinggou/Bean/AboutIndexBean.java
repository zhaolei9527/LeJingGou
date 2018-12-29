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
public class AboutIndexBean {

    /**
     * status : 1
     * info : 信息拉取成功
     * data : {"id":"36","headimg":"/Public/uploads/lb/2018-12-26/2018_12_26_165352_3226.jpeg","nickname":"ededed","qm":"11111","ljsy":"277.20","kymon":"94512.20","djmon":"4200.00","zfbname":"11223","zfbacc":"11231","is_sm":"2","name":"guide ","idcard":"142731199108224812","skmsg":"","tjcode":"7ce6207a","is_yg":"2","ne":"1545814432","zje":98712.2,"lj":"http://ljg.t.100help.net/login/reg/pid/36.html","ewm":"/Public/ewm/36.png"}
     */

    private int status;
    private String info;
    private DataBean data;

    public static List<AboutIndexBean> arrayAboutIndexBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<AboutIndexBean>>() {
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
         * id : 36
         * headimg : /Public/uploads/lb/2018-12-26/2018_12_26_165352_3226.jpeg
         * nickname : ededed
         * qm : 11111
         * ljsy : 277.20
         * kymon : 94512.20
         * djmon : 4200.00
         * zfbname : 11223
         * zfbacc : 11231
         * is_sm : 2
         * name : guide
         * idcard : 142731199108224812
         * skmsg :
         * tjcode : 7ce6207a
         * is_yg : 2
         * ne : 1545814432
         * zje : 98712.2
         * lj : http://ljg.t.100help.net/login/reg/pid/36.html
         * ewm : /Public/ewm/36.png
         */

        private String id;
        private String headimg;
        private String nickname;
        private String qm;
        private String ljsy;
        private String kymon;
        private String djmon;
        private String zfbname;
        private String zfbacc;
        private String is_sm;
        private String name;
        private String idcard;
        private String skmsg;
        private String tjcode;
        private String is_yg;
        private String ne;
        private double zje;
        private String lj;
        private String ewm;

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getHeadimg() {
            return headimg;
        }

        public void setHeadimg(String headimg) {
            this.headimg = headimg;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getQm() {
            return qm;
        }

        public void setQm(String qm) {
            this.qm = qm;
        }

        public String getLjsy() {
            return ljsy;
        }

        public void setLjsy(String ljsy) {
            this.ljsy = ljsy;
        }

        public String getKymon() {
            return kymon;
        }

        public void setKymon(String kymon) {
            this.kymon = kymon;
        }

        public String getDjmon() {
            return djmon;
        }

        public void setDjmon(String djmon) {
            this.djmon = djmon;
        }

        public String getZfbname() {
            return zfbname;
        }

        public void setZfbname(String zfbname) {
            this.zfbname = zfbname;
        }

        public String getZfbacc() {
            return zfbacc;
        }

        public void setZfbacc(String zfbacc) {
            this.zfbacc = zfbacc;
        }

        public String getIs_sm() {
            return is_sm;
        }

        public void setIs_sm(String is_sm) {
            this.is_sm = is_sm;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIdcard() {
            return idcard;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }

        public String getSkmsg() {
            return skmsg;
        }

        public void setSkmsg(String skmsg) {
            this.skmsg = skmsg;
        }

        public String getTjcode() {
            return tjcode;
        }

        public void setTjcode(String tjcode) {
            this.tjcode = tjcode;
        }

        public String getIs_yg() {
            return is_yg;
        }

        public void setIs_yg(String is_yg) {
            this.is_yg = is_yg;
        }

        public String getNe() {
            return ne;
        }

        public void setNe(String ne) {
            this.ne = ne;
        }

        public double getZje() {
            return zje;
        }

        public void setZje(double zje) {
            this.zje = zje;
        }

        public String getLj() {
            return lj;
        }

        public void setLj(String lj) {
            this.lj = lj;
        }

        public String getEwm() {
            return ewm;
        }

        public void setEwm(String ewm) {
            this.ewm = ewm;
        }
    }
}
