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
 * @date 2018/12/26
 * 功能描述：
 */
public class IndexGoodsBean {

    /**
     * status : 1
     * info : 信息拉取成功
     * data : [{"id":"77","name":"贝汉美（BHM） 复古美式家居创意艺术品摆件工艺品盔甲武士电视柜博古架装饰品 站姿小兵","fm_img":"/Public/uploads/lb/2018-12-26/2018_12_26_140355_2756.jpg","gys":"贝汉美","dqprice":"100.00","starttime":"1545753600","endtime":"1545840000","s":29335,"type":1},{"id":"76","name":"朱炳仁 铜梅花鹿铜摆件 逐鹿顺意家居装饰品 铜工艺品 艺术品开业礼品 15天后发货礼物 小号（不参与活动）","fm_img":"/Public/uploads/lb/2018-12-26/2018_12_26_140313_7042.jpg","gys":"朱炳仁旗舰店","dqprice":"1600.00","starttime":"1545753600","endtime":"1545926400","s":115735,"type":1},{"id":"75","name":"新中式招财树迎客松纯铜艺术装饰摆件客厅工艺品餐厅玄关电视柜书房风水摆设创意家居艺术品 招财松A款","fm_img":"/Public/uploads/lb/2018-12-26/2018_12_26_135741_8606.jpg","gys":"星工产","dqprice":"1700.00","starttime":"1545753600","endtime":"1545840000","s":29335,"type":1},{"id":"73","name":"墨斗鱼 金色沙漏旋转款1小时1961 艺术摆件生日礼物送老婆女生朋友 家居饰品 简约时光沙漏 白色流沙","fm_img":"/Public/uploads/lb/2018-12-26/2018_12_26_135109_7500.jpg","gys":"墨斗鱼","dqprice":"140.00","starttime":"1545753600","endtime":"1545840000","s":29335,"type":1},{"id":"72","name":"欧式沉思者艺术品工艺品家居客厅创意书房装饰品雕塑人物创意摆件 砂岩思考者","fm_img":"/Public/uploads/lb/2018-12-26/2018_12_26_134657_5548.jpg","gys":" 卓升家居日用专营店","dqprice":"100.00","starttime":"1545753600","endtime":"1545840000","s":29335,"type":1},{"id":"71","name":"墨斗鱼 思考者摆件左托腮1916 抽象人物 砂岩现代简约创意家居书房玄关客厅电视柜办公室装饰品工艺品","fm_img":"/Public/uploads/lb/2018-12-26/2018_12_26_134152_1708.jpg","gys":"墨斗鱼","dqprice":"100.00","starttime":"1545753600","endtime":"1545926400","s":115735,"type":1}]
     */

    private int status;
    private String info;
    private List<DataBean> data;

    public static List<IndexGoodsBean> arrayIndexGoodsBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<IndexGoodsBean>>() {
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
         * id : 77
         * name : 贝汉美（BHM） 复古美式家居创意艺术品摆件工艺品盔甲武士电视柜博古架装饰品 站姿小兵
         * fm_img : /Public/uploads/lb/2018-12-26/2018_12_26_140355_2756.jpg
         * gys : 贝汉美
         * dqprice : 100.00
         * starttime : 1545753600
         * endtime : 1545840000
         * s : 29335
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
