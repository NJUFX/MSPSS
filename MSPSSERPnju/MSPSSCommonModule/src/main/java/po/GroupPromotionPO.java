package po;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Description: 特价包 组合商品实现一定的折扣 为了方便 我用折扣率来实现
 * Created by Hanxinhu at 23:37 2017/12/12/012
 */
public class GroupPromotionPO implements Serializable{
    /**
     * 折扣率
     */
    private double discountRate;
    /**
     * 该组合里的商品 graph
     */
    private ArrayList<String> commodityIDs;
    /**
     * 促销策略起始时间
     */
    private String  initTime;
    /**
     * 促销策略结束时间
     */
    private String endTime;


    public GroupPromotionPO(double discountRate, ArrayList<String> commodityIDs, String initTime, String endTime) {
        this.discountRate = discountRate;
        this.commodityIDs = commodityIDs;
        this.initTime = initTime;
        this.endTime = endTime;
    }
    public GroupPromotionPO() {
    }


    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public ArrayList<String> getCommodityIDs() {
        return commodityIDs;
    }

    public void setCommodityIDs(ArrayList<String> commodityIDs) {
        this.commodityIDs = commodityIDs;
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
