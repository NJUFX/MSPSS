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
     * 可以修改 修改后的单价 在通过审批后自动更新最近进价 和 最近零售价
     * 同时在通过审批后自动更新
     */
    public double price;

    /**
     * 数量（手动输入）
     */
    public int number;
    /**
     * 备注
     */
    public String ps;
    public SalesItemVO(CommodityVO commodityVO,int number,double price){
        this.id = commodityVO.ID;
        this.commodityVO = commodityVO;
        this.type = commodityVO.type;
        this.name = commodityVO.name;
        this.number = number;
        this.price = price;
    }

    public SalesItemVO(CommodityVO commodityVO, int number, double price, String ps) {
        this(commodityVO, number, price);
        this.ps = ps;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
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

    public CommodityVO getCommodityVO() {
        return commodityVO;
    }

    public void setCommodityVO(CommodityVO commodityVO) {
        this.commodityVO = commodityVO;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
