package vo;

import util.Time;

import java.util.ArrayList;

/**
 * Description:总额满减 赠送 折扣促销策略
 * Created by Hanxinhu at 23:41 2017/12/12/012
 */
public class GrossPromotionVO {
    /**
     * 编号
     */
    private String id;

    /**
     * 其他类型促销策略折让后的总金额
     * 达到该促销策略所触发的最低总金额
     *
     */
    private double total;
    /**
     * 促销策略的赠送代金券数额 整数 100 1000
     */
    private int voucher;
    /**
     * 达到该金额后赠送的商品
     */

    private ArrayList<PresentationCommodityItemVO> presentationCommodityItemVOS;
    /**
     * 起始时间
     */
    private Time initTime;
    /**
     * 结束时间
     */
    private Time endTime;

    public GrossPromotionVO(double total, int voucher, ArrayList<PresentationCommodityItemVO> presentationCommodityItemVOS, Time initTime, Time endTime) {
        this.total = total;
        this.voucher = voucher;
        this.presentationCommodityItemVOS = presentationCommodityItemVOS;
        this.initTime = initTime;
        this.endTime = endTime;
    }
    
    public GrossPromotionVO(double total, int voucher, Time initTime, Time endTime) {
        this.total = total;
        this.voucher = voucher;
        this.initTime = initTime;
        this.endTime = endTime;
    }

    public GrossPromotionVO(String id, double total, int voucher, ArrayList<PresentationCommodityItemVO> presentationCommodityItemVOS, Time initTime, Time endTime) {
        this.id = id;
        this.total = total;
        this.voucher = voucher;
        this.presentationCommodityItemVOS = presentationCommodityItemVOS;
        this.initTime = initTime;
        this.endTime = endTime;
    }

    public ArrayList<PresentationCommodityItemVO> getPresentationCommodityItemVOS() {
        return presentationCommodityItemVOS;
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

    public void setPresentationCommodityItemVOS(ArrayList<PresentationCommodityItemVO> presentationCommodityItemVOS) {
        this.presentationCommodityItemVOS = presentationCommodityItemVOS;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getVoucher() {
        return voucher;
    }

    public void setVoucher(int voucher) {
        this.voucher = voucher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
