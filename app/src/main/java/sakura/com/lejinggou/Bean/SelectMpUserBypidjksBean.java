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
 * @date 2019/6/29
 * 功能描述：
 */
public class SelectMpUserBypidjksBean {

    /**
     * msg : 获取成功
     * list : {"pageNum":1,"pageSize":10,"size":2,"startRow":1,"endRow":2,"total":2,"pages":1,"list":[{"id":44,"tel":"18737888878","headimg":"/Public/uploads/lb/2019-06-20/2019_06_20_151901_8177.jpg","nickname":"志在四方","status":1,"addtime":1548049145,"pid":1,"edittime":"1561015141","password":"6294018299c3094d3dc3405598783406","type":1,"isSm":2,"isYg":2,"zfbname":"李建刚","zfbacc":"18737888878","kymon":2018.21,"djmon":0,"ljsy":30262.2,"tjcode":"30339bba","skmsg":"","name":"李刚","idcard":"410727199001025934","qm":"盘","isJqr":1,"ne":"1561015141","syjf":"0"},{"id":144,"tel":"17629345001","headimg":"/Public/uploads/lb/2019-02-14/2019_02_14_141522_8102.jpg","nickname":"撒酷睿啊","status":1,"addtime":1550124790,"pid":1,"edittime":"1550219082","password":"9e162cce4be4cad83cf80592aaa96c59","type":1,"isSm":2,"isYg":2,"zfbname":"组织","zfbacc":"975976959＠全球。com","kymon":5000,"djmon":0,"ljsy":40000,"tjcode":"a82630c8","skmsg":"","name":"祝福","idcard":"412726199807103758","qm":"asdasd","isJqr":1,"ne":"1550219082","syjf":"0"}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
     * status : 1
     */

    private String msg;
    private ListBeanX list;
    private String status;

    public static List<SelectMpUserBypidjksBean> arraySelectMpUserBypidjksBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<SelectMpUserBypidjksBean>>() {
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
         * pageSize : 10
         * size : 2
         * startRow : 1
         * endRow : 2
         * total : 2
         * pages : 1
         * list : [{"id":44,"tel":"18737888878","headimg":"/Public/uploads/lb/2019-06-20/2019_06_20_151901_8177.jpg","nickname":"志在四方","status":1,"addtime":1548049145,"pid":1,"edittime":"1561015141","password":"6294018299c3094d3dc3405598783406","type":1,"isSm":2,"isYg":2,"zfbname":"李建刚","zfbacc":"18737888878","kymon":2018.21,"djmon":0,"ljsy":30262.2,"tjcode":"30339bba","skmsg":"","name":"李刚","idcard":"410727199001025934","qm":"盘","isJqr":1,"ne":"1561015141","syjf":"0"},{"id":144,"tel":"17629345001","headimg":"/Public/uploads/lb/2019-02-14/2019_02_14_141522_8102.jpg","nickname":"撒酷睿啊","status":1,"addtime":1550124790,"pid":1,"edittime":"1550219082","password":"9e162cce4be4cad83cf80592aaa96c59","type":1,"isSm":2,"isYg":2,"zfbname":"组织","zfbacc":"975976959＠全球。com","kymon":5000,"djmon":0,"ljsy":40000,"tjcode":"a82630c8","skmsg":"","name":"祝福","idcard":"412726199807103758","qm":"asdasd","isJqr":1,"ne":"1550219082","syjf":"0"}]
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
        private boolean isFirstPage;
        private boolean isLastPage;
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

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
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
             * id : 44
             * tel : 18737888878
             * headimg : /Public/uploads/lb/2019-06-20/2019_06_20_151901_8177.jpg
             * nickname : 志在四方
             * status : 1
             * addtime : 1548049145
             * pid : 1
             * edittime : 1561015141
             * password : 6294018299c3094d3dc3405598783406
             * type : 1
             * isSm : 2
             * isYg : 2
             * zfbname : 李建刚
             * zfbacc : 18737888878
             * kymon : 2018.21
             * djmon : 0.0
             * ljsy : 30262.2
             * tjcode : 30339bba
             * skmsg :
             * name : 李刚
             * idcard : 410727199001025934
             * qm : 盘
             * isJqr : 1
             * ne : 1561015141
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
    }
}
