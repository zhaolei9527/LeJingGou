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
     * data : {"id":"40","headimg":"/Public/home/images/f_icon6.png","nickname":"83bae","qm":"","ljsy":"0.00","kymon":"0.00","djmon":"0.00","zfbname":"","zfbacc":"","is_sm":"0","name":"","idcard":"","skmsg":"","is_yg":"1","ne":"0","zje":0}
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
         * id : 40
         * headimg : /Public/home/images/f_icon6.png
         * nickname : 83bae
         * qm :
         * ljsy : 0.00
         * kymon : 0.00
         * djmon : 0.00
         * zfbname :
         * zfbacc :
         * is_sm : 0
         * name :
         * idcard :
         * skmsg :
         * is_yg : 1
         * ne : 0
         * zje : 0
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
        private String is_yg;
        private String ne;
        private int zje;

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

        public int getZje() {
            return zje;
        }

        public void setZje(int zje) {
            this.zje = zje;
        }
    }
}
