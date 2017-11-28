package vo;

import util.Time;

public class StockVO {
    /**
    * 是否出库
    */
    StockType stockType;
    /**
     * 出库的金额
     */
    double number;
    /**
     *  出库的数额
     */
    double price;
    /**
     * 产生出库或入库记录的具体时间
     */
    Time time;
    public StockVO(StockType stockType, double number, double price, Time time){
        this.stockType = stockType;
        this.number = number;
        this.price = price;
        this.time = time;
    }

    @Override
    public String toString() {
        return stockType.toString()+ " 金额: "+price +" 数额: "+number;
    }
}
