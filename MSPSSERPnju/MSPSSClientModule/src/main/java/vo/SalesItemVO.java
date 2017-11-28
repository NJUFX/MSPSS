package vo;

/**
 * Description: 进货单 和 销售单的 单项商品相关的信息
 * Created by Hanxinhu at 22:27 2017/11/27/027
 */
public class SalesItemVO {
    private CommodityVO commodityVO;
    /**
     * 商品名称
     */
    public String name;

    /**
     * 商品型号
     */
    public String type;
    /**
     * 商品编号
     */
    public String id;
    /**
     * 单价
     * 在进货单里默认为商品的进价
     * 在销售单里默认为商品的零售价
     */
    public double price;

    /**
     * 数量（手动输入）
     */
    public int number;
    public SalesItemVO(CommodityVO commodityVO,int number,double price){
        this.id = commodityVO.ID;
        this.commodityVO = commodityVO;
        this.type = commodityVO.type;
        this.name = commodityVO.name;
        this.number = number;
        this.price = price;
    }

    public String getId() {
        return commodityVO.ID;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

}
