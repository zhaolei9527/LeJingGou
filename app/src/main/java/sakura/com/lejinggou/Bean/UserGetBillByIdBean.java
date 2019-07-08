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
 * @date 2019/7/8
 * 功能描述：
 */
public class UserGetBillByIdBean {

    /**
     * msg : 获取成功
     * list : {"id":50,"user":{"id":1,"tel":"17629345001","headimg":"/Public/home/images/f_icon6.png","nickname":"e8438","status":1,"addtime":1561687699,"pid":0,"edittime":"0","password":"7fab9c962fbd1b59b1ed65f0cdb7ddf7","type":1,"isSm":0,"isYg":2,"zfbname":"","zfbacc":"","kymon":0.98,"djmon":0,"ljsy":0,"tjcode":"dece0071","skmsg":"","name":"","idcard":"","qm":"","isJqr":1,"ne":"0","syjf":"0"},"goods":{"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D","jftypeid":"6","price":100,"date":"2019-06-28 13:46:01","supplier":"和田玉","needintegral":"0.1","stock":"0","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755798upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000040.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=v1hBHgwk9QkwvRVS3Ef0zOHE%2BWg%3D,","state":"0","context":"<p>\t\t\t\t<\/p><p>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style=\"background-color: rgb(255, 255, 255); color: rgb(64, 64, 64); font-family: &quot;Microsoft Yahei&quot;; font-size: 18px; text-align: justify; text-indent: 2em;\">在上海市最早一批进行上门收受餐厨垃圾的长宁区华阳街道，记者了解到，每天12时30分和18时，播放着专属音乐的\u201c三分类\u201d清运车便会沿街上门收垃圾；眼下，几乎所有沿街的653家商户都能做到干湿垃圾分类。<\/span><\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\"006.thumb_head\" class=\"thumbnail-pic-with-copyright\" src=\"http://cms-bucket.ws.126.net/2019/07/01/0e4fa6016447433ba5cc86a652b9adee.jpeg\" style=\"vertical-align: top; border: none; max-width: 100%; display: block; margin: 0px auto;\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; text-indent: 2em; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">图片来源：摄图网<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; text-indent: 2em; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">黑色、褐色、红色、蓝色四种垃圾筒在敞亮的厢房内依远近排开，保洁人员正在用湿垃圾粉碎脱水一体机进行破袋、除渣处理，墙上张贴的科普海报吸引人驻足观看\u2026\u2026这是第一财经记者在静安芷江西路街道北方佳苑小区的垃圾厢房看到的场景。<\/p><p><br/><\/p>","paixu":0,"url":""},"date":"2019-07-08 18:27:46","state":"0","num":"1"}
     * status : 1
     */

    private String msg;
    private ListBean list;
    private String status;

    public static List<UserGetBillByIdBean> arrayUserGetBillByIdBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<UserGetBillByIdBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ListBean getList() {
        return list;
    }

    public void setList(ListBean list) {
        this.list = list;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ListBean {
        /**
         * id : 50
         * user : {"id":1,"tel":"17629345001","headimg":"/Public/home/images/f_icon6.png","nickname":"e8438","status":1,"addtime":1561687699,"pid":0,"edittime":"0","password":"7fab9c962fbd1b59b1ed65f0cdb7ddf7","type":1,"isSm":0,"isYg":2,"zfbname":"","zfbacc":"","kymon":0.98,"djmon":0,"ljsy":0,"tjcode":"dece0071","skmsg":"","name":"","idcard":"","qm":"","isJqr":1,"ne":"0","syjf":"0"}
         * goods : {"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D","jftypeid":"6","price":100,"date":"2019-06-28 13:46:01","supplier":"和田玉","needintegral":"0.1","stock":"0","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755798upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000040.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=v1hBHgwk9QkwvRVS3Ef0zOHE%2BWg%3D,","state":"0","context":"<p>\t\t\t\t<\/p><p>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style=\"background-color: rgb(255, 255, 255); color: rgb(64, 64, 64); font-family: &quot;Microsoft Yahei&quot;; font-size: 18px; text-align: justify; text-indent: 2em;\">在上海市最早一批进行上门收受餐厨垃圾的长宁区华阳街道，记者了解到，每天12时30分和18时，播放着专属音乐的\u201c三分类\u201d清运车便会沿街上门收垃圾；眼下，几乎所有沿街的653家商户都能做到干湿垃圾分类。<\/span><\/p><p class=\"f_center\" style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);\"><img alt=\"006.thumb_head\" class=\"thumbnail-pic-with-copyright\" src=\"http://cms-bucket.ws.126.net/2019/07/01/0e4fa6016447433ba5cc86a652b9adee.jpeg\" style=\"vertical-align: top; border: none; max-width: 100%; display: block; margin: 0px auto;\"/><\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; text-indent: 2em; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">图片来源：摄图网<\/p><p style=\"margin-top: 32px; margin-bottom: 0px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; text-indent: 2em; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);\">黑色、褐色、红色、蓝色四种垃圾筒在敞亮的厢房内依远近排开，保洁人员正在用湿垃圾粉碎脱水一体机进行破袋、除渣处理，墙上张贴的科普海报吸引人驻足观看\u2026\u2026这是第一财经记者在静安芷江西路街道北方佳苑小区的垃圾厢房看到的场景。<\/p><p><br/><\/p>","paixu":0,"url":""}
         * date : 2019-07-08 18:27:46
         * state : 0
         * num : 1
         */

        private int id;
        private UserBean user;
        private GoodsBean goods;
        private String date;
        private String state;
        private String num;

        public static List<ListBean> arrayListBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ListBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public GoodsBean getGoods() {
            return goods;
        }

        public void setGoods(GoodsBean goods) {
            this.goods = goods;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public static class UserBean {
            /**
             * id : 1
             * tel : 17629345001
             * headimg : /Public/home/images/f_icon6.png
             * nickname : e8438
             * status : 1
             * addtime : 1561687699
             * pid : 0
             * edittime : 0
             * password : 7fab9c962fbd1b59b1ed65f0cdb7ddf7
             * type : 1
             * isSm : 0
             * isYg : 2
             * zfbname :
             * zfbacc :
             * kymon : 0.98
             * djmon : 0.0
             * ljsy : 0.0
             * tjcode : dece0071
             * skmsg :
             * name :
             * idcard :
             * qm :
             * isJqr : 1
             * ne : 0
             * syjf : 0
             */

            private int id;
            private String tel;
            private String headimg;
            private String nickname;
            private int status;
            private int addtime;
            private int pid;
            private String edittime;
            private String password;
            private int type;
            private int isSm;
            private int isYg;
            private String zfbname;
            private String zfbacc;
            private double kymon;
            private double djmon;
            private double ljsy;
            private String tjcode;
            private String skmsg;
            private String name;
            private String idcard;
            private String qm;
            private int isJqr;
            private String ne;
            private String syjf;

            public static List<UserBean> arrayUserBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<UserBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
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

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getAddtime() {
                return addtime;
            }

            public void setAddtime(int addtime) {
                this.addtime = addtime;
            }

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public String getEdittime() {
                return edittime;
            }

            public void setEdittime(String edittime) {
                this.edittime = edittime;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getIsSm() {
                return isSm;
            }

            public void setIsSm(int isSm) {
                this.isSm = isSm;
            }

            public int getIsYg() {
                return isYg;
            }

            public void setIsYg(int isYg) {
                this.isYg = isYg;
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

            public double getKymon() {
                return kymon;
            }

            public void setKymon(double kymon) {
                this.kymon = kymon;
            }

            public double getDjmon() {
                return djmon;
            }

            public void setDjmon(double djmon) {
                this.djmon = djmon;
            }

            public double getLjsy() {
                return ljsy;
            }

            public void setLjsy(double ljsy) {
                this.ljsy = ljsy;
            }

            public String getTjcode() {
                return tjcode;
            }

            public void setTjcode(String tjcode) {
                this.tjcode = tjcode;
            }

            public String getSkmsg() {
                return skmsg;
            }

            public void setSkmsg(String skmsg) {
                this.skmsg = skmsg;
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

            public String getQm() {
                return qm;
            }

            public void setQm(String qm) {
                this.qm = qm;
            }

            public int getIsJqr() {
                return isJqr;
            }

            public void setIsJqr(int isJqr) {
                this.isJqr = isJqr;
            }

            public String getNe() {
                return ne;
            }

            public void setNe(String ne) {
                this.ne = ne;
            }

            public String getSyjf() {
                return syjf;
            }

            public void setSyjf(String syjf) {
                this.syjf = syjf;
            }
        }

        public static class GoodsBean {
            /**
             * id : 4
             * name : 和田玉1
             * fengmian : http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D
             * jftypeid : 6
             * price : 100.0
             * date : 2019-06-28 13:46:01
             * supplier : 和田玉
             * needintegral : 0.1
             * stock : 0
             * tupian : http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755798upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000040.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=v1hBHgwk9QkwvRVS3Ef0zOHE%2BWg%3D,
             * state : 0
             * context : <p>				</p><p>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style="background-color: rgb(255, 255, 255); color: rgb(64, 64, 64); font-family: &quot;Microsoft Yahei&quot;; font-size: 18px; text-align: justify; text-indent: 2em;">在上海市最早一批进行上门收受餐厨垃圾的长宁区华阳街道，记者了解到，每天12时30分和18时，播放着专属音乐的“三分类”清运车便会沿街上门收垃圾；眼下，几乎所有沿街的653家商户都能做到干湿垃圾分类。</span></p><p class="f_center" style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; color: rgb(64, 64, 64); text-align: center; white-space: normal; background-color: rgb(255, 255, 255);"><img alt="006.thumb_head" class="thumbnail-pic-with-copyright" src="http://cms-bucket.ws.126.net/2019/07/01/0e4fa6016447433ba5cc86a652b9adee.jpeg" style="vertical-align: top; border: none; max-width: 100%; display: block; margin: 0px auto;"/></p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; text-indent: 2em; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">图片来源：摄图网</p><p style="margin-top: 32px; margin-bottom: 0px; padding: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 32px; font-family: &quot;Microsoft Yahei&quot;; text-indent: 2em; color: rgb(64, 64, 64); text-align: justify; white-space: normal; background-color: rgb(255, 255, 255);">黑色、褐色、红色、蓝色四种垃圾筒在敞亮的厢房内依远近排开，保洁人员正在用湿垃圾粉碎脱水一体机进行破袋、除渣处理，墙上张贴的科普海报吸引人驻足观看……这是第一财经记者在静安芷江西路街道北方佳苑小区的垃圾厢房看到的场景。</p><p><br/></p>
             * paixu : 0
             * url :
             */

            private int id;
            private String name;
            private String fengmian;
            private String jftypeid;
            private double price;
            private String date;
            private String supplier;
            private String needintegral;
            private String stock;
            private String tupian;
            private String state;
            private String context;
            private int paixu;
            private String url;

            public static List<GoodsBean> arrayGoodsBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<GoodsBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getFengmian() {
                return fengmian;
            }

            public void setFengmian(String fengmian) {
                this.fengmian = fengmian;
            }

            public String getJftypeid() {
                return jftypeid;
            }

            public void setJftypeid(String jftypeid) {
                this.jftypeid = jftypeid;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSupplier() {
                return supplier;
            }

            public void setSupplier(String supplier) {
                this.supplier = supplier;
            }

            public String getNeedintegral() {
                return needintegral;
            }

            public void setNeedintegral(String needintegral) {
                this.needintegral = needintegral;
            }

            public String getStock() {
                return stock;
            }

            public void setStock(String stock) {
                this.stock = stock;
            }

            public String getTupian() {
                return tupian;
            }

            public void setTupian(String tupian) {
                this.tupian = tupian;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getContext() {
                return context;
            }

            public void setContext(String context) {
                this.context = context;
            }

            public int getPaixu() {
                return paixu;
            }

            public void setPaixu(int paixu) {
                this.paixu = paixu;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
