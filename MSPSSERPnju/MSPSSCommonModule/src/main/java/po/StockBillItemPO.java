package po;

/**
 * Description:
 * Created by Hanxinhu at 20:44 2017/11/27/027
 */
public class StockBillItemPO {
    /**
     * 商品的编号
     */
   public String commodityID;

    /**
     * 商品的数量
     */
   public int number;
   public StockBillItemPO(String commodityID,int number){
       this.commodityID = commodityID;
       this.number = number;
   }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCommodityID() {
        return commodityID;
    }

    public void setCommodityID(String commodityID) {
        this.commodityID = commodityID;
    }
}
