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
public class UserGetBillBean {


    /**
     * msg : 获取成功
     * list : {"pageNum":1,"pageSize":20,"size":2,"startRow":1,"endRow":2,"total":2,"pages":1,"list":[{"id":50,"user":{"id":1,"tel":"17629345001","headimg":"/Public/home/images/f_icon6.png","nickname":"e8438","status":1,"addtime":1561687699,"pid":0,"edittime":"0","password":"7fab9c962fbd1b59b1ed65f0cdb7ddf7","type":1,"isSm":0,"isYg":2,"zfbname":"","zfbacc":"","kymon":0.98,"djmon":0,"ljsy":0,"tjcode":"dece0071","skmsg":"","name":"","idcard":"","qm":"","isJqr":1,"ne":"0","syjf":"0"},"goods":{"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D","jftypeid":"6","price":100,"supplier":"和田玉","needintegral":"0.1","stock":"0","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562055537070upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000010.tmp.png?Expires=1877415537&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=Ie3GxqFsnFzRf5%2FTlHDJIeNQUMQ%3D,","state":"0","url":""},"state":"0","num":"1"},{"id":51,"user":{"id":1,"tel":"17629345001","headimg":"/Public/home/images/f_icon6.png","nickname":"e8438","status":1,"addtime":1561687699,"pid":0,"edittime":"0","password":"7fab9c962fbd1b59b1ed65f0cdb7ddf7","type":1,"isSm":0,"isYg":2,"zfbname":"","zfbacc":"","kymon":0.98,"djmon":0,"ljsy":0,"tjcode":"dece0071","skmsg":"","name":"","idcard":"","qm":"","isJqr":1,"ne":"0","syjf":"0"},"goods":{"id":5,"name":"和田玉2","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562049584539upload_1e93ea05_a042_4be4_906a_b8253e80b888_00000033.tmp.png?Expires=1877409584&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=GxhSv7cAxGWFJ3LnHLlg14FRsjI%3D","jftypeid":"6","price":100,"supplier":"和田玉","needintegral":"10000","stock":"10","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562049584539upload_1e93ea05_a042_4be4_906a_b8253e80b888_00000033.tmp.png?Expires=1877409584&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=GxhSv7cAxGWFJ3LnHLlg14FRsjI%3D,","state":"0","url":""},"price":"1000","state":"0","num":"1"}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
     * status : 1
     */

    private String msg;
    private ListBeanX list;
    private String status;

    public static List<UserGetBillBean> arrayUserGetBillBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<UserGetBillBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ListBeanX getList() {
        return list;
    }

    public void setList(ListBeanX list) {
        this.list = list;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ListBeanX {
        /**
         * pageNum : 1
         * pageSize : 20
         * size : 2
         * startRow : 1
         * endRow : 2
         * total : 2
         * pages : 1
         * list : [{"id":50,"user":{"id":1,"tel":"17629345001","headimg":"/Public/home/images/f_icon6.png","nickname":"e8438","status":1,"addtime":1561687699,"pid":0,"edittime":"0","password":"7fab9c962fbd1b59b1ed65f0cdb7ddf7","type":1,"isSm":0,"isYg":2,"zfbname":"","zfbacc":"","kymon":0.98,"djmon":0,"ljsy":0,"tjcode":"dece0071","skmsg":"","name":"","idcard":"","qm":"","isJqr":1,"ne":"0","syjf":"0"},"goods":{"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D","jftypeid":"6","price":100,"supplier":"和田玉","needintegral":"0.1","stock":"0","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562055537070upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000010.tmp.png?Expires=1877415537&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=Ie3GxqFsnFzRf5%2FTlHDJIeNQUMQ%3D,","state":"0","url":""},"state":"0","num":"1"},{"id":51,"user":{"id":1,"tel":"17629345001","headimg":"/Public/home/images/f_icon6.png","nickname":"e8438","status":1,"addtime":1561687699,"pid":0,"edittime":"0","password":"7fab9c962fbd1b59b1ed65f0cdb7ddf7","type":1,"isSm":0,"isYg":2,"zfbname":"","zfbacc":"","kymon":0.98,"djmon":0,"ljsy":0,"tjcode":"dece0071","skmsg":"","name":"","idcard":"","qm":"","isJqr":1,"ne":"0","syjf":"0"},"goods":{"id":5,"name":"和田玉2","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562049584539upload_1e93ea05_a042_4be4_906a_b8253e80b888_00000033.tmp.png?Expires=1877409584&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=GxhSv7cAxGWFJ3LnHLlg14FRsjI%3D","jftypeid":"6","price":100,"supplier":"和田玉","needintegral":"10000","stock":"10","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562049584539upload_1e93ea05_a042_4be4_906a_b8253e80b888_00000033.tmp.png?Expires=1877409584&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=GxhSv7cAxGWFJ3LnHLlg14FRsjI%3D,","state":"0","url":""},"price":"1000","state":"0","num":"1"}]
         * prePage : 0
         * nextPage : 0
         * isFirstPage : true
         * isLastPage : true
         * hasPreviousPage : false
         * hasNextPage : false
         * navigatePages : 8
         * navigatepageNums : [1]
         * navigateFirstPage : 1
         * navigateLastPage : 1
         */

        private String pageNum;
        private String pageSize;
        private String size;
        private String startRow;
        private String endRow;
        private String total;
        private String pages;
        private String prePage;
        private String nextPage;
        private String isFirstPage;
        private String isLastPage;
        private boolean hasPreviousPage;
        private boolean hasNextPage;
        private String navigatePages;
        private String navigateFirstPage;
        private String navigateLastPage;
        private List<ListBean> list;
        private List<Integer> navigatepageNums;

        public static List<ListBeanX> arrayListBeanXFromData(String str) {

            Type listType = new TypeToken<ArrayList<ListBeanX>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getPageNum() {
            return pageNum;
        }

        public void setPageNum(String pageNum) {
            this.pageNum = pageNum;
        }

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getStartRow() {
            return startRow;
        }

        public void setStartRow(String startRow) {
            this.startRow = startRow;
        }

        public String getEndRow() {
            return endRow;
        }

        public void setEndRow(String endRow) {
            this.endRow = endRow;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        public String getPrePage() {
            return prePage;
        }

        public void setPrePage(String prePage) {
            this.prePage = prePage;
        }

        public String getNextPage() {
            return nextPage;
        }

        public void setNextPage(String nextPage) {
            this.nextPage = nextPage;
        }

        public String isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(String isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public String isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(String isLastPage) {
            this.isLastPage = isLastPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public String getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(String navigatePages) {
            this.navigatePages = navigatePages;
        }

        public String getNavigateFirstPage() {
            return navigateFirstPage;
        }

        public void setNavigateFirstPage(String navigateFirstPage) {
            this.navigateFirstPage = navigateFirstPage;
        }

        public String getNavigateLastPage() {
            return navigateLastPage;
        }

        public void setNavigateLastPage(String navigateLastPage) {
            this.navigateLastPage = navigateLastPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public static class ListBean {
            /**
             * id : 50
             * user : {"id":1,"tel":"17629345001","headimg":"/Public/home/images/f_icon6.png","nickname":"e8438","status":1,"addtime":1561687699,"pid":0,"edittime":"0","password":"7fab9c962fbd1b59b1ed65f0cdb7ddf7","type":1,"isSm":0,"isYg":2,"zfbname":"","zfbacc":"","kymon":0.98,"djmon":0,"ljsy":0,"tjcode":"dece0071","skmsg":"","name":"","idcard":"","qm":"","isJqr":1,"ne":"0","syjf":"0"}
             * goods : {"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D","jftypeid":"6","price":100,"supplier":"和田玉","needintegral":"0.1","stock":"0","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562055537070upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000010.tmp.png?Expires=1877415537&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=Ie3GxqFsnFzRf5%2FTlHDJIeNQUMQ%3D,","state":"0","url":""}
             * state : 0
             * num : 1
             * price : 1000
             */

            private String id;
            private UserBean user;
            private GoodsBean goods;
            private String state;
            private String num;
            private String price;

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

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
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
                 * fengmian : http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D
                 * jftypeid : 6
                 * price : 100.0
                 * supplier : 和田玉
                 * needintegral : 0.1
                 * stock : 0
                 * tupian : http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562055537070upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000010.tmp.png?Expires=1877415537&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=Ie3GxqFsnFzRf5%2FTlHDJIeNQUMQ%3D,
                 * state : 0
                 * url :
                 */

                private String id;
                private String name;
                private String fengmian;
                private String jftypeid;
                private String price;
                private String supplier;
                private String needintegral;
                private String stock;
                private String tupian;
                private String state;
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

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
