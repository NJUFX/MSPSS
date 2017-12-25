package vo;

import util.Time;

public class AlarmBillVO {
    String ID;
    /**
     * 库存报警的商品
     */
    String commodityID;

    /**
     * 库存报警的商品的当前库存
     */
    int number;

    Time time;
   public AlarmBillVO(String commodityID, int number){
        this.commodityID = commodityID;
        this.number = number;
    }

    public AlarmBillVO(String ID, String commodityID, int number, Time time) {
        this.ID = ID;
        this.commodityID = commodityID;
        this.number = number;
        this.time = time;
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "库存报警商品编号为 "+ commodityID+" 当前库存量为 "+number;
    }
}
