package po;

import java.io.Serializable;

/**
 * Description:
 * Created by Hanxinhu at 16:54 2017/12/25/025
 */
public class AlarmBillPO implements Serializable{
    /**
     * 库存报警单的ID
     * 为了统一格式 也做出 KCBJD-20171225-00001
     */
    String id;
    String commodityID;
    int number;
    String time;

    public AlarmBillPO() {
    }

    public AlarmBillPO(String id, String commodityID, int number, String time) {
        this.id = id;
        this.commodityID = commodityID;
        this.number = number;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommodityID() {
        return commodityID;
    }

    public void setCommodityID(String commodityID) {
        this.commodityID = commodityID;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
