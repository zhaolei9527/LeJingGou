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
public class GoodsIndexBean {

    /**
     * status : 1
     * info : 信息拉取成功
     * data : {"id":"76","name":"朱炳仁 铜梅花鹿铜摆件 逐鹿顺意家居装饰品 铜工艺品 艺术品开业礼品 15天后发货礼物 小号（不参与活动）","imgurl":["/Public/uploads/lb/2018-12-26/2018_12_26_140313_7042.jpg"],"dqprice":"2200.00","cjuid":"38","fd":"100.00","bl":null,"bzj":"800.00","starttime":"1545753600","endtime":"1545926400","fdprice":"3800.00","ckprice":"3800.00","url":"http://ljg.t.100help.net/ym/gd/id/76.html","jgurl":"http://ljg.t.100help.net/ym/jggz.html","type":1,"uname":"哈哈大笑","uheadimg":"/Public/uploads/lb/2018-12-26/2018_12_26_164348_6557.jpeg","gys":"朱炳仁旗舰店","s":24122}
     */

    private int status;
    private String info;
    private DataBean data;

    public static List<GoodsIndexBean> arrayGoodsIndexBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<GoodsIndexBean>>() {
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
         * id : 76
         * name : 朱炳仁 铜梅花鹿铜摆件 逐鹿顺意家居装饰品 铜工艺品 艺术品开业礼品 15天后发货礼物 小号（不参与活动）
         * imgurl : ["/Public/uploads/lb/2018-12-26/2018_12_26_140313_7042.jpg"]
         * dqprice : 2200.00
         * cjuid : 38
         * fd : 100.00
         * bl : null
         * bzj : 800.00
         * starttime : 1545753600
         * endtime : 1545926400
         * fdprice : 3800.00
         * ckprice : 3800.00
         * url : http://ljg.t.100help.net/ym/gd/id/76.html
         * jgurl : http://ljg.t.100help.net/ym/jggz.html
         * type : 1
         * uname : 哈哈大笑
         * uheadimg : /Public/uploads/lb/2018-12-26/2018_12_26_164348_6557.jpeg
         * gys : 朱炳仁旗舰店
         * s : 24122
         */

        private String id;
        private String name;
        private String dqprice;
        private String cjuid;
        private String fd;
        private Object bl;
        private String bzj;
        private String starttime;
        private String endtime;
        private String fdprice;
        private String ckprice;
        private String url;
        private String jgurl;
        private int type;
        private String uname;
        private String uheadimg;
        private String gys;
        private int s;
        private List<String> imgurl;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDqprice() {
            return dqprice;
        }

        public void setDqprice(String dqprice) {
            this.dqprice = dqprice;
        }

        public String getCjuid() {
            return cjuid;
        }

        public void setCjuid(String cjuid) {
            this.cjuid = cjuid;
        }

        public String getFd() {
            return fd;
        }

        public void setFd(String fd) {
            this.fd = fd;
        }

        public Object getBl() {
            return bl;
        }

        public void setBl(Object bl) {
            this.bl = bl;
        }

        public String getBzj() {
            return bzj;
        }

        public void setBzj(String bzj) {
            this.bzj = bzj;
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

        public String getFdprice() {
            return fdprice;
        }

        public void setFdprice(String fdprice) {
            this.fdprice = fdprice;
        }

        public String getCkprice() {
            return ckprice;
        }

        public void setCkprice(String ckprice) {
            this.ckprice = ckprice;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getJgurl() {
            return jgurl;
        }

        public void setJgurl(String jgurl) {
            this.jgurl = jgurl;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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

        public String getGys() {
            return gys;
        }

        public void setGys(String gys) {
            this.gys = gys;
        }

        public int getS() {
            return s;
        }

        public void setS(int s) {
            this.s = s;
        }

        public List<String> getImgurl() {
            return imgurl;
        }

        public void setImgurl(List<String> imgurl) {
            this.imgurl = imgurl;
        }
    }
}
