package vo;

import util.Time;

/**
 * Created by thinkpad on 2017/12/23.
 */
public class SaleTableFilterFlagsVO {

    /*
      销售明细表
     */
    //时间区间
    Time begin;
    Time end;
    //商品名
    String commodityName;
    //客户
    String customerName;
    //业务员
    String operatorName;
    //仓库
    String storage;

    public Time getBegin() {
        return begin;
    }

    public void setBegin(Time begin) {
        this.begin = begin;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
}
