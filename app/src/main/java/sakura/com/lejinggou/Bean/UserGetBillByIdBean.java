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
     * list : {"id":61,"oldjf":"0","newjf":"0","hfjf":"0","user":{"id":1,"tel":"17629345001","headimg":"/Public/home/images/f_icon6.png","nickname":"e8438","status":1,"addtime":1561687699,"pid":0,"edittime":"0","password":"7fab9c962fbd1b59b1ed65f0cdb7ddf7","type":1,"isSm":0,"isYg":2,"zfbname":"","zfbacc":"","kymon":0.94,"djmon":0,"ljsy":0,"tjcode":"dece0071","skmsg":"","name":"","idcard":"","qm":"","isJqr":1,"ne":"0","syjf":"0"},"goods":{"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D","jftypeid":"6","price":100,"date":"2019-06-28 13:46:01","supplier":"和田玉","needintegral":"0.1","stock":"96","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755798upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000040.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=v1hBHgwk9QkwvRVS3Ef0zOHE%2BWg%3D,","state":"0","paixu":0,"url":""},"oldprice":"0.98","newprice":"0.97","price":"0.01","date":"2019-07-08 20:26:30","state":"2","mpAddress":{"id":0,"uid":1,"name":"asda","tel":"17629345001","ssx":"河南省郑州市中原区","address":"asdasdasd","addtime":"1562588786","isMr":1},"kuaidihao":"1323124124124515","kuaidiming":"顺丰快递","num":"1"}
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
         * id : 61
         * oldjf : 0
         * newjf : 0
         * hfjf : 0
         * user : {"id":1,"tel":"17629345001","headimg":"/Public/home/images/f_icon6.png","nickname":"e8438","status":1,"addtime":1561687699,"pid":0,"edittime":"0","password":"7fab9c962fbd1b59b1ed65f0cdb7ddf7","type":1,"isSm":0,"isYg":2,"zfbname":"","zfbacc":"","kymon":0.94,"djmon":0,"ljsy":0,"tjcode":"dece0071","skmsg":"","name":"","idcard":"","qm":"","isJqr":1,"ne":"0","syjf":"0"}
         * goods : {"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D","jftypeid":"6","price":100,"date":"2019-06-28 13:46:01","supplier":"和田玉","needintegral":"0.1","stock":"96","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755798upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000040.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=v1hBHgwk9QkwvRVS3Ef0zOHE%2BWg%3D,","state":"0","paixu":0,"url":""}
         * oldprice : 0.98
         * newprice : 0.97
         * price : 0.01
         * date : 2019-07-08 20:26:30
         * state : 2
         * mpAddress : {"id":0,"uid":1,"name":"asda","tel":"17629345001","ssx":"河南省郑州市中原区","address":"asdasdasd","addtime":"1562588786","isMr":1}
         * kuaidihao : 1323124124124515
         * kuaidiming : 顺丰快递
         * num : 1
         */

        private String id;
        private String oldjf;
        private String newjf;
        private String hfjf;
        private UserBean user;
        private GoodsBean goods;
        private String oldprice;
        private String newprice;
        private String price;
        private String date;
        private String state;
        private MpAddressBean mpAddress;
        private String kuaidihao;
        private String kuaidiming;
        private String num;

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

        public String getOldjf() {
            return oldjf;
        }

        public void setOldjf(String oldjf) {
            this.oldjf = oldjf;
        }

        public String getNewjf() {
            return newjf;
        }

        public void setNewjf(String newjf) {
            this.newjf = newjf;
        }

        public String getHfjf() {
            return hfjf;
        }

        public void setHfjf(String hfjf) {
            this.hfjf = hfjf;
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

        public String getOldprice() {
            return oldprice;
        }

        public void setOldprice(String oldprice) {
            this.oldprice = oldprice;
        }

        public String getNewprice() {
            return newprice;
        }

        public void setNewprice(String newprice) {
            this.newprice = newprice;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
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

        public MpAddressBean getMpAddress() {
            return mpAddress;
        }

        public void setMpAddress(MpAddressBean mpAddress) {
            this.mpAddress = mpAddress;
        }

        public String getKuaidihao() {
            return kuaidihao;
        }

        public void setKuaidihao(String kuaidihao) {
            this.kuaidihao = kuaidihao;
        }

        public String getKuaidiming() {
            return kuaidiming;
        }

        public void setKuaidiming(String kuaidiming) {
            this.kuaidiming = kuaidiming;
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
             * kymon : 0.94
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

            private String id;
            private String tel;
            private String headimg;
            private String nickname;
            private String status;
            private String addtime;
            private String pid;
            private String edittime;
            private String password;
            private String type;
            private String isSm;
            private String isYg;
            private String zfbname;
            private String zfbacc;
            private String kymon;
            private String djmon;
            private String ljsy;
            private String tjcode;
            private String skmsg;
            private String name;
            private String idcard;
            private String qm;
            private String isJqr;
            private String ne;
            private String syjf;

            public static List<UserBean> arrayUserBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<UserBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getAddtime() {
                return addtime;
            }

            public void setAddtime(String addtime) {
                this.addtime = addtime;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
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

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getIsSm() {
                return isSm;
            }

            public void setIsSm(String isSm) {
                this.isSm = isSm;
            }

            public String getIsYg() {
                return isYg;
            }

            public void setIsYg(String isYg) {
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

            public String getLjsy() {
                return ljsy;
            }

            public void setLjsy(String ljsy) {
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

            public String getIsJqr() {
                return isJqr;
            }

            public void setIsJqr(String isJqr) {
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
             * stock : 96
             * tupian : http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755798upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000040.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=v1hBHgwk9QkwvRVS3Ef0zOHE%2BWg%3D,
             * state : 0
             * paixu : 0
             * url :
             */

            private String id;
            private String name;
            private String fengmian;
            private String jftypeid;
            private String price;
            private String date;
            private String supplier;
            private String needintegral;
            private String stock;
            private String tupian;
            private String state;
            private String paixu;
            private String url;

            public static List<GoodsBean> arrayGoodsBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<GoodsBean>>() {
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

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
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

            public String getPaixu() {
                return paixu;
            }

            public void setPaixu(String paixu) {
                this.paixu = paixu;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class MpAddressBean {
            /**
             * id : 0
             * uid : 1
             * name : asda
             * tel : 17629345001
             * ssx : 河南省郑州市中原区
             * address : asdasdasd
             * addtime : 1562588786
             * isMr : 1
             */

            private String id;
            private String uid;
            private String name;
            private String tel;
            private String ssx;
            private String address;
            private String addtime;
            private String isMr;

            public static List<MpAddressBean> arrayMpAddressBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<MpAddressBean>>() {
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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getSsx() {
                return ssx;
            }

            public void setSsx(String ssx) {
                this.ssx = ssx;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getAddtime() {
                return addtime;
            }

            public void setAddtime(String addtime) {
                this.addtime = addtime;
            }

            public String getIsMr() {
                return isMr;
            }

            public void setIsMr(String isMr) {
                this.isMr = isMr;
            }
        }
    }
}
