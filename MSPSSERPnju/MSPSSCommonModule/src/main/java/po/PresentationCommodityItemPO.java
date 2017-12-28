package po;

import java.io.Serializable;

/**
 * Description:
 * Created by Hanxinhu at 23:59 2017/12/12/012
 */
public class PresentationCommodityItemPO implements Serializable {
    /**
     * 数据库主键，不要自己赋值
     */
    String keycolumn;
    /**
     * 商品的ID
     */
    String  commodityID;
    /**
     * 赠送的数量
     */
    int number;

    /**
     * 所属的CustomerPromotion
     */
    CustomerPromotionPO customerPromotionPOID;

    /**
     * 所属的gross_promotion_po
     */
    GrossPromotionPO grossPromotionPO;

    public PresentationCommodityItemPO() {
    }

    public PresentationCommodityItemPO(String commodityID, int number, CustomerPromotionPO customerPromotionPOID) {
        this.commodityID = commodityID;
        this.number = number;
        this.customerPromotionPOID = customerPromotionPOID;
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

    public CustomerPromotionPO getCustomerPromotionPOID() {
        return customerPromotionPOID;
    }

    public void setCustomerPromotionPOID(CustomerPromotionPO customerPromotionPOID) {
        this.customerPromotionPOID = customerPromotionPOID;
    }

    public String getKeycolumn() {
        return keycolumn;
    }

    public void setKeycolumn(String keycolumn) {
        this.keycolumn = keycolumn;
    }

    public GrossPromotionPO getGrossPromotionPO() {
        return grossPromotionPO;
    }

    public void setGrossPromotionPO(GrossPromotionPO grossPromotionPO) {
        this.grossPromotionPO = grossPromotionPO;
    }
}
