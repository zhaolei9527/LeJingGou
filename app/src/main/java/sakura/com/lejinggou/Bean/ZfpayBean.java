package sakura.com.lejinggou.Bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * sakura.liangdinvshen.Bean
 *
 * @author 赵磊
 * @date 2018/1/3
 * 功能描述：
 */
public class ZfpayBean {

    /**
     * status : 1
     * info : 操作成功
     * data : {"type":2,"res":"app_id=2018121962592438&biz_content=%7B%22body%22%3A%22lpy-a8f1814908cc6d76751313e5ee34132a%22%2C%22subject%22%3A%22lpy-a8f1814908cc6d76751313e5ee34132a%22%2C%22out_trade_no%22%3A%22a8f1814908cc6d76751313e5ee34132a%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A0.1%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%7D&charset=UTF-8&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fljg.t.100help.net%2Findex.php%2Fpay%2Falipay_app.html&sign_type=RSA2&timestamp=2018-12-29+17%3A12%3A31&version=1.0&sign=mdNF%2BvPHIVpz5Z1Y6sAMF6EbInMYg0vwOjYEs9zPfM60GQMS7U%2Bfyi7NGBxdKzFM5Sd5drSLc5pkH7sKtyyfdnIhMcrFgJA4OtYfHzwvgl7m2l2M1wluwBKwds%2BR%2Btc6DFbulGyIZC%2BfMYsCsp1mjyVpVqn1Jd3oMBm76dmyeXwZunPZmJiUSfLGoWh1fJMepmP43l5t0IybHYMvllBL2AbmaKT5yvIqpSjam33x73eJ5ap50HOZ%2BnAQcgTflNnZJ5roPS0jxt0%2BkvQG2qDyE3ocTuV7aZjtazceqsJey8NLFITJu387WvkvL2FwscWQK%2FoEu3rEgFCamnxSBrTr5A%3D%3D","res2":{"app_id":"2018121962592438","biz_content":"{\"body\":\"lpy-a8f1814908cc6d76751313e5ee34132a\",\"subject\":\"lpy-a8f1814908cc6d76751313e5ee34132a\",\"out_trade_no\":\"a8f1814908cc6d76751313e5ee34132a\",\"timeout_express\":\"30m\",\"total_amount\":0.1,\"product_code\":\"QUICK_MSECURITY_PAY\"}","charset":"UTF-8","method":"alipay.trade.app.pay","notify_url":"http://ljg.t.100help.net/index.php/pay/alipay_app.html","sign_type":"RSA2","timestamp":"2018-12-29 17:12:31","version":"1.0","sign":"mdNF+vPHIVpz5Z1Y6sAMF6EbInMYg0vwOjYEs9zPfM60GQMS7U+fyi7NGBxdKzFM5Sd5drSLc5pkH7sKtyyfdnIhMcrFgJA4OtYfHzwvgl7m2l2M1wluwBKwds+R+tc6DFbulGyIZC+fMYsCsp1mjyVpVqn1Jd3oMBm76dmyeXwZunPZmJiUSfLGoWh1fJMepmP43l5t0IybHYMvllBL2AbmaKT5yvIqpSjam33x73eJ5ap50HOZ+nAQcgTflNnZJ5roPS0jxt0+kvQG2qDyE3ocTuV7aZjtazceqsJey8NLFITJu387WvkvL2FwscWQK/oEu3rEgFCamnxSBrTr5A=="}}
     */

    private int status;
    private String info;
    private DataBean data;

    public static List<ZfpayBean> arrayZfpayBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<ZfpayBean>>() {
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
         * type : 2
         * res : app_id=2018121962592438&biz_content=%7B%22body%22%3A%22lpy-a8f1814908cc6d76751313e5ee34132a%22%2C%22subject%22%3A%22lpy-a8f1814908cc6d76751313e5ee34132a%22%2C%22out_trade_no%22%3A%22a8f1814908cc6d76751313e5ee34132a%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A0.1%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%7D&charset=UTF-8&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fljg.t.100help.net%2Findex.php%2Fpay%2Falipay_app.html&sign_type=RSA2&timestamp=2018-12-29+17%3A12%3A31&version=1.0&sign=mdNF%2BvPHIVpz5Z1Y6sAMF6EbInMYg0vwOjYEs9zPfM60GQMS7U%2Bfyi7NGBxdKzFM5Sd5drSLc5pkH7sKtyyfdnIhMcrFgJA4OtYfHzwvgl7m2l2M1wluwBKwds%2BR%2Btc6DFbulGyIZC%2BfMYsCsp1mjyVpVqn1Jd3oMBm76dmyeXwZunPZmJiUSfLGoWh1fJMepmP43l5t0IybHYMvllBL2AbmaKT5yvIqpSjam33x73eJ5ap50HOZ%2BnAQcgTflNnZJ5roPS0jxt0%2BkvQG2qDyE3ocTuV7aZjtazceqsJey8NLFITJu387WvkvL2FwscWQK%2FoEu3rEgFCamnxSBrTr5A%3D%3D
         * res2 : {"app_id":"2018121962592438","biz_content":"{\"body\":\"lpy-a8f1814908cc6d76751313e5ee34132a\",\"subject\":\"lpy-a8f1814908cc6d76751313e5ee34132a\",\"out_trade_no\":\"a8f1814908cc6d76751313e5ee34132a\",\"timeout_express\":\"30m\",\"total_amount\":0.1,\"product_code\":\"QUICK_MSECURITY_PAY\"}","charset":"UTF-8","method":"alipay.trade.app.pay","notify_url":"http://ljg.t.100help.net/index.php/pay/alipay_app.html","sign_type":"RSA2","timestamp":"2018-12-29 17:12:31","version":"1.0","sign":"mdNF+vPHIVpz5Z1Y6sAMF6EbInMYg0vwOjYEs9zPfM60GQMS7U+fyi7NGBxdKzFM5Sd5drSLc5pkH7sKtyyfdnIhMcrFgJA4OtYfHzwvgl7m2l2M1wluwBKwds+R+tc6DFbulGyIZC+fMYsCsp1mjyVpVqn1Jd3oMBm76dmyeXwZunPZmJiUSfLGoWh1fJMepmP43l5t0IybHYMvllBL2AbmaKT5yvIqpSjam33x73eJ5ap50HOZ+nAQcgTflNnZJ5roPS0jxt0+kvQG2qDyE3ocTuV7aZjtazceqsJey8NLFITJu387WvkvL2FwscWQK/oEu3rEgFCamnxSBrTr5A=="}
         */

        private int type;
        private String res;
        private Res2Bean res2;

        public static List<DataBean> arrayDataBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<DataBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getRes() {
            return res;
        }

        public void setRes(String res) {
            this.res = res;
        }

        public Res2Bean getRes2() {
            return res2;
        }

        public void setRes2(Res2Bean res2) {
            this.res2 = res2;
        }

        public static class Res2Bean {
            /**
             * app_id : 2018121962592438
             * biz_content : {"body":"lpy-a8f1814908cc6d76751313e5ee34132a","subject":"lpy-a8f1814908cc6d76751313e5ee34132a","out_trade_no":"a8f1814908cc6d76751313e5ee34132a","timeout_express":"30m","total_amount":0.1,"product_code":"QUICK_MSECURITY_PAY"}
             * charset : UTF-8
             * method : alipay.trade.app.pay
             * notify_url : http://ljg.t.100help.net/index.php/pay/alipay_app.html
             * sign_type : RSA2
             * timestamp : 2018-12-29 17:12:31
             * version : 1.0
             * sign : mdNF+vPHIVpz5Z1Y6sAMF6EbInMYg0vwOjYEs9zPfM60GQMS7U+fyi7NGBxdKzFM5Sd5drSLc5pkH7sKtyyfdnIhMcrFgJA4OtYfHzwvgl7m2l2M1wluwBKwds+R+tc6DFbulGyIZC+fMYsCsp1mjyVpVqn1Jd3oMBm76dmyeXwZunPZmJiUSfLGoWh1fJMepmP43l5t0IybHYMvllBL2AbmaKT5yvIqpSjam33x73eJ5ap50HOZ+nAQcgTflNnZJ5roPS0jxt0+kvQG2qDyE3ocTuV7aZjtazceqsJey8NLFITJu387WvkvL2FwscWQK/oEu3rEgFCamnxSBrTr5A==
             */

            private String app_id;
            private String biz_content;
            private String charset;
            private String method;
            private String notify_url;
            private String sign_type;
            private String timestamp;
            private String version;
            private String sign;

            public static List<Res2Bean> arrayRes2BeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<Res2Bean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public String getApp_id() {
                return app_id;
            }

            public void setApp_id(String app_id) {
                this.app_id = app_id;
            }

            public String getBiz_content() {
                return biz_content;
            }

            public void setBiz_content(String biz_content) {
                this.biz_content = biz_content;
            }

            public String getCharset() {
                return charset;
            }

            public void setCharset(String charset) {
                this.charset = charset;
            }

            public String getMethod() {
                return method;
            }

            public void setMethod(String method) {
                this.method = method;
            }

            public String getNotify_url() {
                return notify_url;
            }

            public void setNotify_url(String notify_url) {
                this.notify_url = notify_url;
            }

            public String getSign_type() {
                return sign_type;
            }

            public void setSign_type(String sign_type) {
                this.sign_type = sign_type;
            }

            public String getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }
        }
    }
}
