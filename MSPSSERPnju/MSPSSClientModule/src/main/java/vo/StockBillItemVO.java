package vo;

/**
 * Description: 保存库存类单据的商品及商品数量
 * Created by Hanxinhu at 19:54 2017/11/27/027
 */
public class StockBillItemVO {
    /**
     *  商品
     */
    CommodityVO commodityVO;

    /**
     * 该商品在库存类单据里的数量
     */
    int number;

    public StockBillItemVO(CommodityVO commodityVO,int number){
        this.commodityVO = commodityVO;
        this.number = number;
    }
}
