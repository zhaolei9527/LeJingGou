package sakura.com.lejinggou.Bean;

/**
 * sakura.com.lejinggou.Bean
 *
 * @author 赵磊
 * @date 2019/9/25
 * 功能描述：
 */
public class HuiJuSMSBean {

    /**
     * msg : 获取成功
     * orderID : 2019092510473122
     * list : 验签成功
     * status : 1
     */

    private String msg;
    private String orderID;
    private String list;
    private String status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
