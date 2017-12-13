package po;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Description:总额满减 赠送 折扣促销策略
 * Created by Hanxinhu at 23:49 2017/12/12/012
 */
public class GrossPromotionPO implements Serializable {
    /**
     * 满减策略的编号
     */
    private int id;
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
    private ArrayList<PresentationCommodityItemPO> presentationCommodityItemPOS;
    /**
     *  起始时间
     */
    private String initTime;
    /**
     * 终止时间
     */
    private String endTime;

    public GrossPromotionPO() {
    }

    public GrossPromotionPO(double total, int voucher, ArrayList<PresentationCommodityItemPO> presentationCommodityItemPOS, String initTime, String endTime) {
        this.total = total;
        this.voucher = voucher;
        this.presentationCommodityItemPOS = presentationCommodityItemPOS;
        this.initTime = initTime;
        this.endTime = endTime;
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

    public ArrayList<PresentationCommodityItemPO> getPresentationCommodityItemPOS() {
        return presentationCommodityItemPOS;
    }

    public void setPresentationCommodityItemPOS(ArrayList<PresentationCommodityItemPO> presentationCommodityItemPOS) {
        this.presentationCommodityItemPOS = presentationCommodityItemPOS;
    }


}
