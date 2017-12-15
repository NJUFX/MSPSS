package vo;

import util.Time;

import java.util.ArrayList;

/**
 * Description: 特价包 组合商品实现一定的折扣 为了方便 我用折扣率来实现
 * Created by Hanxinhu at 23:24 2017/12/12/012
 */
public class GroupPromotionVO {
    /**
     * 编号
     */
    private String id;
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
    private Time initTime;
    /**
     * 促销策略结束时间
     */
    private Time endTime;

    public GroupPromotionVO(double discountRate, ArrayList<String> commodityIDs, Time initTime, Time endTime) {
        this.discountRate = discountRate;
        this.commodityIDs = commodityIDs;
        this.initTime = initTime;
        this.endTime = endTime;
    }

    public GroupPromotionVO(String id, double discountRate, ArrayList<String> commodityIDs, Time initTime, Time endTime) {
        this.id = id;
        this.discountRate = discountRate;
        this.commodityIDs = commodityIDs;
        this.initTime = initTime;
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
