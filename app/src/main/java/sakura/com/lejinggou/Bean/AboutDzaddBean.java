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
 * @date 2018/12/28
 * 功能描述：
 */
public class AboutDzaddBean {

    /**
     * status : 1
     * info : 新增成功
     * data : {"id":"9","uid":"40","name":"急急如律令","tel":"17629345001","ssx":"河南省郑州市中原区","address":"UK肉JJ","addtime":"1545987961","edittime":null,"status":null,"is_mr":"1"}
     */

    private int status;
    private String info;
    private DataBean data;

    public static List<AboutDzaddBean> arrayAboutDzaddBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<AboutDzaddBean>>() {
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
         * id : 9
         * uid : 40
         * name : 急急如律令
         * tel : 17629345001
         * ssx : 河南省郑州市中原区
         * address : UK肉JJ
         * addtime : 1545987961
         * edittime : null
         * status : null
         * is_mr : 1
         */

        private String id;
        private String uid;
        private String name;
        private String tel;
        private String ssx;
        private String address;
        private String addtime;
        private Object edittime;
        private Object status;
        private String is_mr;

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

        public Object getEdittime() {
            return edittime;
        }

        public void setEdittime(Object edittime) {
            this.edittime = edittime;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }

        public String getIs_mr() {
            return is_mr;
        }

        public void setIs_mr(String is_mr) {
            this.is_mr = is_mr;
        }
    }
}
