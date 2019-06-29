package sakura.com.lejinggou.Bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * com.wenguoyi.Bean
 *
 * @author 赵磊
 * @date 2018/6/5
 * 功能描述：
 */
public class NewsListBean {


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * typeList : [{"id":4,"name":"和田玉","fengmian":"D:\\develop\\eclipse1561516858701_welcome.jpg","date":"2019-06-26 10:40:58","state":"0","paixu":2},{"id":1,"name":"和田玉","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1561519557221upload_60b415d5_68c0_4fda_a74e_1a2445ae1ed6_00000004.tmp.jpg?Expires=1876879557&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=FLlW5dIvbYrSF5Ell2KWa0ZBEFc%3D","date":"2019-06-13 09:15:14","editdate":"2019-06-13 09:15:14","state":"0","paixu":3},{"id":3,"name":"美玉","fengmian":"D:\\develop\\eclipse1561515567401_welcome.jpg","date":"2019-06-26 10:19:27","state":"0","paixu":10}]
     * goodsList : {"pageNum":1,"pageSize":20,"size":3,"startRow":1,"endRow":3,"total":3,"pages":1,"list":[{"id":1,"name":"和田玉(碧玉)精品","jftypeid":"1","price":2000,"date":"2019-06-13 09:15:14","supplier":"千岩玉厂","needintegral":"10000","stock":"10","saletime":"2019-06-13 09:15:14","hotsale":"1","state":"0","edittime":"09:15:14","paixu":1,"fengmian":"D:\\develop\\eclipse1561514420035_welcome.jpg"},{"id":2,"name":"和田玉(碧玉)精品","jftypeid":"2","price":2000,"date":"2019-06-13 09:15:14","supplier":"千岩玉厂","needintegral":"10000","stock":"10","saletime":"2019-06-13 09:15:14","hotsale":"1","state":"0","edittime":"09:15:14","paixu":2},{"id":3,"name":"和田玉","fengmian":"D:\\develop\\eclipse1561514420035_welcome.jpg","jftypeid":"1","price":1000,"date":"2019-06-26 10:00:20","supplier":"和田玉供应","needintegral":"10000","stock":"10","state":"0","paixu":10}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
     */

    private String status;
    private GoodsListBean goodsList;
    private List<TypeListBean> typeList;

    public static List<NewsListBean> arrayNewsListBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<NewsListBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public GoodsListBean getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(GoodsListBean goodsList) {
        this.goodsList = goodsList;
    }

    public List<TypeListBean> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<TypeListBean> typeList) {
        this.typeList = typeList;
    }

    public static class GoodsListBean {
        /**
         * pageNum : 1
         * pageSize : 20
         * size : 3
         * startRow : 1
         * endRow : 3
         * total : 3
         * pages : 1
         * list : [{"id":1,"name":"和田玉(碧玉)精品","jftypeid":"1","price":2000,"date":"2019-06-13 09:15:14","supplier":"千岩玉厂","needintegral":"10000","stock":"10","saletime":"2019-06-13 09:15:14","hotsale":"1","state":"0","edittime":"09:15:14","paixu":1},{"id":2,"name":"和田玉(碧玉)精品","jftypeid":"2","price":2000,"date":"2019-06-13 09:15:14","supplier":"千岩玉厂","needintegral":"10000","stock":"10","saletime":"2019-06-13 09:15:14","hotsale":"1","state":"0","edittime":"09:15:14","paixu":2},{"id":3,"name":"和田玉","fengmian":"D:\\develop\\eclipse1561514420035_welcome.jpg","jftypeid":"1","price":1000,"date":"2019-06-26 10:00:20","supplier":"和田玉供应","needintegral":"10000","stock":"10","state":"0","paixu":10}]
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

        public static List<GoodsListBean> arrayGoodsListBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<GoodsListBean>>() {
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
             * id : 1
             * name : 和田玉(碧玉)精品
             * jftypeid : 1
             * price : 2000.0
             * date : 2019-06-13 09:15:14
             * supplier : 千岩玉厂
             * needintegral : 10000
             * stock : 10
             * saletime : 2019-06-13 09:15:14
             * hotsale : 1
             * state : 0
             * edittime : 09:15:14
             * paixu : 1
             * fengmian : D:\develop\eclipse1561514420035_welcome.jpg
             */

            private String id;
            private String name;
            private String jftypeid;
            private String price;
            private String date;
            private String supplier;
            private String needintegral;
            private String stock;
            private String saletime;
            private String hotsale;
            private String state;
            private String edittime;
            private String paixu;
            private String fengmian;

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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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

            public String getSaletime() {
                return saletime;
            }

            public void setSaletime(String saletime) {
                this.saletime = saletime;
            }

            public String getHotsale() {
                return hotsale;
            }

            public void setHotsale(String hotsale) {
                this.hotsale = hotsale;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getEdittime() {
                return edittime;
            }

            public void setEdittime(String edittime) {
                this.edittime = edittime;
            }

            public String getPaixu() {
                return paixu;
            }

            public void setPaixu(String paixu) {
                this.paixu = paixu;
            }

            public String getFengmian() {
                return fengmian;
            }

            public void setFengmian(String fengmian) {
                this.fengmian = fengmian;
            }
        }
    }

    public static class TypeListBean {
        /**
         * id : 4
         * name : 和田玉
         * fengmian : D:\develop\eclipse1561516858701_welcome.jpg
         * date : 2019-06-26 10:40:58
         * state : 0
         * paixu : 2
         * editdate : 2019-06-13 09:15:14
         */

        private String id;
        private String name;
        private String fengmian;
        private String date;
        private String state;
        private String paixu;
        private String editdate;

        public static List<TypeListBean> arrayTypeListBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<TypeListBean>>() {
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

        public String getPaixu() {
            return paixu;
        }

        public void setPaixu(String paixu) {
            this.paixu = paixu;
        }

        public String getEditdate() {
            return editdate;
        }

        public void setEditdate(String editdate) {
            this.editdate = editdate;
        }
    }
}
