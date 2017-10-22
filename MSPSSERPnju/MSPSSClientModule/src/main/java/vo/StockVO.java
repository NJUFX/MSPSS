package VO;

public class StockVO {
    /**
    * 是否出库
    */
    InOrOut inOrOut;
    /**
     * 出库的金额
     */
    double number;
    /**
     *  出库的数额
     */
    double price;

    public StockVO(InOrOut inOrOut,double number,double price){
        this.inOrOut = inOrOut;
        this.number = number;
        this.price = price;
    }

    @Override
    public String toString() {
        return inOrOut.toString()+ " 金额: "+price +" 数额: "+number;
    }
}
