package po;

import java.io.Serializable;

/**
 * Description:
 * Created by Hanxinhu at 20:44 2017/11/27/027
 */
public class StockBillItemPO  implements Serializable{
    /**
     * 主键，切勿自己赋值
     */
    private String keycolumn;
    /**
     * 商品的编号
     */
   public String commodityID;

    /**
     * 商品的数量
     */
   public int number;

    /**
     *所属的stockBill
     *
     */
    private StockBillPO stockBillPO;

    public StockBillItemPO() {
    }

    public StockBillItemPO(String commodityID, int number){
       this.commodityID = commodityID;
       this.number = number;
       //this.stockBillPO = stockBillPO;
   }

    public String getKeycolumn() {
        return keycolumn;
    }

    public void setKeycolumn(String keycolumn) {
        this.keycolumn = keycolumn;
    }

    public StockBillPO getStockBillPO() {
        return stockBillPO;
    }

    public void setStockBillPO(StockBillPO stockBillPO) {
        this.stockBillPO = stockBillPO;
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
