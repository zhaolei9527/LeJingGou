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
 * @date 2017/12/13
 * 功能描述：
 */
public class AddressIndexBean {

    /**
     * status : 1
     * info : 信息拉取成功
     * data : [{"id":"8","name":"八里街","tel":"18629345001","ssx":"河南省郑州市中原区","address":"UK搜看","is_mr":"1","addtime":"1545987024"}]
     */

    private int status;
    private String info;
    private List<DataBean> data;

    public static List<AddressIndexBean> arrayAddressIndexBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<AddressIndexBean>>() {
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
         * id : 8
         * name : 八里街
         * tel : 18629345001
         * ssx : 河南省郑州市中原区
         * address : UK搜看
         * is_mr : 1
         * addtime : 1545987024
         */

        private String id;
        private String name;
        private String tel;
        private String ssx;
        private String address;
        private String is_mr;
        private String addtime;

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

        public String getIs_mr() {
            return is_mr;
        }

        public void setIs_mr(String is_mr) {
            this.is_mr = is_mr;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }
    }
}
