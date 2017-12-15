package vo;

import po.PresentationCommodityItemPO;

/**
 * Description: 促销策略里的赠品数量 以及 商品信息
 * Created by Hanxinhu at 23:55 2017/12/12/012
 */
public class PresentationCommodityItemVO {
    /**
     * 商品信息
     */
    String commodityID;
    /**
     * 赠送数量
     */
    int number;

    public PresentationCommodityItemVO(String commodityID, int number) {
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

    public PresentationCommodityItemPO to_po(){
        return new PresentationCommodityItemPO(commodityID,number);
    }
}
