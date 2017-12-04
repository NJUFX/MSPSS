package vo;

import util.StockInfo;
import util.Time;

public class StockVO {
    /**
    * 是否出库
    */
   public StockInfo stockType;
    /**
     * 出库的金额
     */
   public double number;
    /**
     *  出库的数额
     */
   public double price;
    /**
     * 产生出库或入库记录的具体时间
     */
   public Time time;

   public CommodityVO commodityVO;

    public StockVO(StockInfo stockType, double number, double price, Time time,CommodityVO commodityVO){
        this.stockType = stockType;
        this.number = number;
        this.price = price;
        this.time = time;
        this.commodityVO =commodityVO;
    }

    @Override
    public String toString() {
        return stockType.toString()+ " 金额: "+price +" 数额: "+number;
    }
}
