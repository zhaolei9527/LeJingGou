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
public class UserSeachJfGoodsBean {

    /**
     * msg : 获取成功
     * list : {"pageNum":1,"pageSize":20,"size":1,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D","jftypeid":"6","price":100,"date":"2019-06-28 13:46:01","supplier":"和田玉","needintegral":"0.1","stock":"7","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562055537070upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000010.tmp.png?Expires=1877415537&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=Ie3GxqFsnFzRf5%2FTlHDJIeNQUMQ%3D,","state":"0","paixu":10,"url":"","tupianlist":["http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D","http://wei1218.oss-cn-beijing.aliyuncs.com/1562055537070upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000010.tmp.png?Expires=1877415537&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=Ie3GxqFsnFzRf5%2FTlHDJIeNQUMQ%3D"]}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
     * status : 1
     */

    private String msg;
    private ListBeanX list;
    private String status;

    public static List<UserSeachJfGoodsBean> arrayUserSeachJfGoodsBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<UserSeachJfGoodsBean>>() {
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
         * size : 1
         * startRow : 1
         * endRow : 1
         * total : 1
         * pages : 1
         * list : [{"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D","jftypeid":"6","price":100,"date":"2019-06-28 13:46:01","supplier":"和田玉","needintegral":"0.1","stock":"7","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562055537070upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000010.tmp.png?Expires=1877415537&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=Ie3GxqFsnFzRf5%2FTlHDJIeNQUMQ%3D,","state":"0","paixu":10,"url":"","tupianlist":["http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D","http://wei1218.oss-cn-beijing.aliyuncs.com/1562055537070upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000010.tmp.png?Expires=1877415537&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=Ie3GxqFsnFzRf5%2FTlHDJIeNQUMQ%3D"]}]
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
             * id : 4
             * name : 和田玉1
             * fengmian : http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D
             * jftypeid : 6
             * price : 100.0
             * date : 2019-06-28 13:46:01
             * supplier : 和田玉
             * needintegral : 0.1
             * stock : 7
             * tupian : http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562055537070upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000010.tmp.png?Expires=1877415537&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=Ie3GxqFsnFzRf5%2FTlHDJIeNQUMQ%3D,
             * state : 0
             * paixu : 10
             * url :
             * tupianlist : ["http://wei1218.oss-cn-beijing.aliyuncs.com/1562055536704upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000009.tmp.png?Expires=1877415536&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=z7dmu6laIvR9xIn9vl1c4buQarU%3D","http://wei1218.oss-cn-beijing.aliyuncs.com/1562055537070upload_a1975330_b297_4c4b_ab2f_b495b332a34b_00000010.tmp.png?Expires=1877415537&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=Ie3GxqFsnFzRf5%2FTlHDJIeNQUMQ%3D"]
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
            private List<String> tupianlist;

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

            public List<String> getTupianlist() {
                return tupianlist;
            }

            public void setTupianlist(List<String> tupianlist) {
                this.tupianlist = tupianlist;
            }
        }
    }
}
