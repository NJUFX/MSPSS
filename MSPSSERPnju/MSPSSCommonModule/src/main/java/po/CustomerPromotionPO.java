package po;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Description:用于针对 客户等级的特价包
 * Created by Hanxinhu at 23:15 2017/12/12/012
 */
public class CustomerPromotionPO implements Serializable {
    /**
     * 促销策略编号
     */
    private int id;
    /**
     * 该促销策略适用的最低的客户的等级
     */
    private int level;
    /**
     * 促销策略的折让金额 比如让价88.8 999.9
     */
    private double discount;
    /**
     * 促销策略的赠送代金券数额 整数 100 1000
     */
    private int voucher;
    /**
     * 赠品列表 清单
     */
    private ArrayList<PresentationCommodityItemPO> presentationCommodityItemPOS;
    /**
     *  开始时间
     */
    private String initTime;
    /**
     * 结束时间
     */
    private String endTime;



    public CustomerPromotionPO() {
    }

    public CustomerPromotionPO(int level, double discount, int voucher, ArrayList<PresentationCommodityItemPO> presentationCommodityItemPOS, String initTime, String endTime) {
        this.level = level;
        this.discount = discount;
        this.voucher = voucher;
        this.presentationCommodityItemPOS = presentationCommodityItemPOS;
        this.initTime = initTime;
        this.endTime = endTime;
    }

    public CustomerPromotionPO(int id, int level, double discount, int voucher, ArrayList<PresentationCommodityItemPO> presentationCommodityItemPOS, String initTime, String endTime) {
        this.id = id;
        this.level = level;
        this.discount = discount;
        this.voucher = voucher;
        this.presentationCommodityItemPOS = presentationCommodityItemPOS;
        this.initTime = initTime;
        this.endTime = endTime;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getVoucher() {
        return voucher;
    }

    public void setVoucher(int voucher) {
        this.voucher = voucher;
    }

    public String getInitTime() {
        return initTime;
    }

    public void setInitTime(String initTime) {
        this.initTime = initTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
