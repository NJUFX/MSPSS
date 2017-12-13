package po;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 23:59 2017/12/12/012
 */
public class PresentationCommodityItemPO implements Serializable {
    /**
     * 商品的ID
     */
    String  commodityID;
    /**
     * 赠送的数量
     */
    int number;

    public PresentationCommodityItemPO() {
    }

    public PresentationCommodityItemPO(String commodityID, int number) {
        this.commodityID = commodityID;
        this.number = number;
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
}
