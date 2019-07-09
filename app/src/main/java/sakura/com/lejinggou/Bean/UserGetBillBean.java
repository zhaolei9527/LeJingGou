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
     * list : {"pageNum":1,"pageSize":20,"size":4,"startRow":1,"endRow":4,"total":4,"pages":1,"list":[{"id":61,"oldjf":"0","newjf":"0","hfjf":"0","goods":{"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D","jftypeid":"6","price":100,"supplier":"和田玉","needintegral":"0.1","stock":"96","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755798upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000040.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=v1hBHgwk9QkwvRVS3Ef0zOHE%2BWg%3D,","state":"0","url":""},"oldprice":"0.98","newprice":"0.97","price":"0.01","date":"2019-07-08 20:26:30","state":"1","num":"1"},{"id":67,"oldjf":"0","newjf":"0","hfjf":"0","goods":{"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D","jftypeid":"6","price":100,"supplier":"和田玉","needintegral":"0.1","stock":"96","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755798upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000040.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=v1hBHgwk9QkwvRVS3Ef0zOHE%2BWg%3D,","state":"0","url":""},"oldprice":"0.97","newprice":"0.96","price":"0.01","date":"2019-07-08 22:47:59","state":"1","num":"1"},{"id":69,"oldjf":"0","newjf":"0","hfjf":"0","goods":{"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D","jftypeid":"6","price":100,"supplier":"和田玉","needintegral":"0.1","stock":"96","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755798upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000040.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=v1hBHgwk9QkwvRVS3Ef0zOHE%2BWg%3D,","state":"0","url":""},"oldprice":"0.96","newprice":"0.95","price":"0.01","date":"2019-07-08 22:49:22","state":"1","mpAddress":{"id":2,"uid":1,"name":"asda","tel":"17629345001","ssx":"河南省郑州市中原区","address":"asdasdasd","addtime":"1562588786","isMr":1},"num":"1"},{"id":70,"oldjf":"0","newjf":"0","hfjf":"0","goods":{"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D","jftypeid":"6","price":100,"supplier":"和田玉","needintegral":"0.1","stock":"96","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755798upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000040.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=v1hBHgwk9QkwvRVS3Ef0zOHE%2BWg%3D,","state":"0","url":""},"oldprice":"0.95","newprice":"0.94","price":"0.01","date":"2019-07-08 23:01:59","state":"1","mpAddress":{"id":2,"uid":1,"name":"asda","tel":"17629345001","ssx":"河南省郑州市中原区","address":"asdasdasd","addtime":"1562588786","isMr":1},"num":"1"}],"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
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
         * size : 4
         * startRow : 1
         * endRow : 4
         * total : 4
         * pages : 1
         * list : [{"id":61,"oldjf":"0","newjf":"0","hfjf":"0","goods":{"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D","jftypeid":"6","price":100,"supplier":"和田玉","needintegral":"0.1","stock":"96","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755798upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000040.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=v1hBHgwk9QkwvRVS3Ef0zOHE%2BWg%3D,","state":"0","url":""},"oldprice":"0.98","newprice":"0.97","price":"0.01","date":"2019-07-08 20:26:30","state":"1","num":"1"},{"id":67,"oldjf":"0","newjf":"0","hfjf":"0","goods":{"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D","jftypeid":"6","price":100,"supplier":"和田玉","needintegral":"0.1","stock":"96","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755798upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000040.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=v1hBHgwk9QkwvRVS3Ef0zOHE%2BWg%3D,","state":"0","url":""},"oldprice":"0.97","newprice":"0.96","price":"0.01","date":"2019-07-08 22:47:59","state":"1","num":"1"},{"id":69,"oldjf":"0","newjf":"0","hfjf":"0","goods":{"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D","jftypeid":"6","price":100,"supplier":"和田玉","needintegral":"0.1","stock":"96","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755798upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000040.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=v1hBHgwk9QkwvRVS3Ef0zOHE%2BWg%3D,","state":"0","url":""},"oldprice":"0.96","newprice":"0.95","price":"0.01","date":"2019-07-08 22:49:22","state":"1","mpAddress":{"id":2,"uid":1,"name":"asda","tel":"17629345001","ssx":"河南省郑州市中原区","address":"asdasdasd","addtime":"1562588786","isMr":1},"num":"1"},{"id":70,"oldjf":"0","newjf":"0","hfjf":"0","goods":{"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D","jftypeid":"6","price":100,"supplier":"和田玉","needintegral":"0.1","stock":"96","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755798upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000040.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=v1hBHgwk9QkwvRVS3Ef0zOHE%2BWg%3D,","state":"0","url":""},"oldprice":"0.95","newprice":"0.94","price":"0.01","date":"2019-07-08 23:01:59","state":"1","mpAddress":{"id":2,"uid":1,"name":"asda","tel":"17629345001","ssx":"河南省郑州市中原区","address":"asdasdasd","addtime":"1562588786","isMr":1},"num":"1"}]
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
             * id : 61
             * oldjf : 0
             * newjf : 0
             * hfjf : 0
             * goods : {"id":4,"name":"和田玉1","fengmian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D","jftypeid":"6","price":100,"supplier":"和田玉","needintegral":"0.1","stock":"96","tupian":"http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755798upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000040.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=v1hBHgwk9QkwvRVS3Ef0zOHE%2BWg%3D,","state":"0","url":""}
             * oldprice : 0.98
             * newprice : 0.97
             * price : 0.01
             * date : 2019-07-08 20:26:30
             * state : 1
             * num : 1
             * mpAddress : {"id":2,"uid":1,"name":"asda","tel":"17629345001","ssx":"河南省郑州市中原区","address":"asdasdasd","addtime":"1562588786","isMr":1}
             */

            private String id;
            private String oldjf;
            private String newjf;
            private String hfjf;
            private GoodsBean goods;
            private String oldprice;
            private String newprice;
            private String price;
            private String date;
            private String state;
            private String num;
            private MpAddressBean mpAddress;

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

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public MpAddressBean getMpAddress() {
                return mpAddress;
            }

            public void setMpAddress(MpAddressBean mpAddress) {
                this.mpAddress = mpAddress;
            }

            public static class GoodsBean {
                /**
                 * id : 4
                 * name : 和田玉1
                 * fengmian : http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D
                 * jftypeid : 6
                 * price : 100.0
                 * supplier : 和田玉
                 * needintegral : 0.1
                 * stock : 96
                 * tupian : http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755653upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000039.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=5JH4mg4lwsnYJFXXIha6YA3Xg6k%3D,http://wei1218.oss-cn-beijing.aliyuncs.com/1562587755798upload_0791695f_5e41_4c94_a822_1730bfd2b88c_00000040.tmp.png?Expires=1877947755&OSSAccessKeyId=LTAIsT7aEEg1qypH&Signature=v1hBHgwk9QkwvRVS3Ef0zOHE%2BWg%3D,
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

            public static class MpAddressBean {
                /**
                 * id : 2
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
}
