package vo;

import util.StockInfo;

/**
 * Description:
 * Created by Hanxinhu at 21:07 2017/11/18/018
 */
public class ChangeInfoVO {
    /**
     *  库存变动的商品编号
     */
    public String commodityID;
    /**
     * 该商品变动的库存数量
     */
    public int number;
    /**
     * 出库还是入库
     */
   public StockInfo info;

    /**
     * 出入库的时间
     */
  public   String Time;
    /**
     * 库存变动涉及的总金额 进货是进价乘以数量 出货是售价乘以数量
     */
  public double price;
    public ChangeInfoVO(String commodityID, int number, StockInfo info, String time,double price) {
        this.commodityID = commodityID;
        this.number = number;
        this.info = info;
        this.Time = time;
        this.price = price;
    }

}
