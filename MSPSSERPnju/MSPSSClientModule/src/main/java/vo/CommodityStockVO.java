package vo;

import util.Time;



public class CommodityStockVO {

    /**
     * 商品
     */
    public CommodityVO commodityVO;

    /**
     * 该批次批号下的库存数量
     */

    public  int number;
    /**
     * 库存均价
     */
    public double price;
    /**
     * 批次
     */
    public String pici;
    /**
     * 批号
     */
    public String pihao;
    /**
     * 出厂日期
     */
    public Time exportDate;
    public CommodityStockVO(CommodityVO commodityVO, int number, double price, String pici, String pihao, Time exportDate){
        this.commodityVO = commodityVO;
        this.number = number;
        this.price = price;
        this.pici = pici;
        this.pihao = pihao;
        this.exportDate = exportDate;
    }

};