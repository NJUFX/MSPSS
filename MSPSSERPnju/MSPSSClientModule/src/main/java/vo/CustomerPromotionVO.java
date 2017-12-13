package vo;

import util.Time;

import java.util.ArrayList;


/**
 * Description: 用于针对 客户等级的特价包
 * Created by Hanxinhu at 21:09 2017/12/12/012
 */
public class CustomerPromotionVO {
    /**
     * 该促销策略适用最低的客户的等级
     */
    private int level;
    /**
     * 促销策略的折让金额 比如让价88.8 999.9 100
     */
    private double discount;
    /**
     * 促销策略的赠送代金券数额 整数 100 1000
     */
    private int voucher;
    /**
     * 赠送的商品及数量
     */
    private ArrayList<PresentationCommodityItemVO> presentationCommodityItemVOS;
    /**
     *  开始时间
     */
    private Time initTime;
    /**
     * 结束时间
     */
    private Time endTime;


    public CustomerPromotionVO(int level, double discount, int voucher, ArrayList<PresentationCommodityItemVO> presentationCommodityItemVOS, Time initTime, Time endTime) {
        this.level = level;
        this.discount = discount;
        this.voucher = voucher;
        this.presentationCommodityItemVOS = presentationCommodityItemVOS;
        this.initTime = initTime;
        this.endTime = endTime;
    }

    public CustomerPromotionVO() {
    }

    public ArrayList<PresentationCommodityItemVO> getPresentationCommodityItemVOS() {
        return presentationCommodityItemVOS;
    }

    public void setPresentationCommodityItemVOS(ArrayList<PresentationCommodityItemVO> presentationCommodityItemVOS) {
        this.presentationCommodityItemVOS = presentationCommodityItemVOS;
    }

    public CustomerPromotionVO(int level, double discount, int voucher, Time initTime, Time endTime) {
        this.level = level;
        this.discount = discount;
        this.voucher = voucher;
        this.initTime = initTime;
        this.endTime = endTime;
    }

    public Time getInitTime() {
        return initTime;
    }

    public void setInitTime(Time initTime) {
        this.initTime = initTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int getLevel() {
        return level;
    }

    public double getDiscount() {
        return discount;
    }

    public int getVoucher() {
        return voucher;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setVoucher(int voucher) {
        this.voucher = voucher;
    }
}
