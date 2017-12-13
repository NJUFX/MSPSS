package vo;

/**
 * Description: 促销策略里的赠品数量 以及 商品信息
 * Created by Hanxinhu at 23:55 2017/12/12/012
 */
public class PresentationCommodityItemVO {
    /**
     * 商品信息
     */
    CommodityVO commodityVO;
    /**
     * 赠送数量
     */
    int number;

    public PresentationCommodityItemVO(CommodityVO commodityVO, int number) {
        this.commodityVO = commodityVO;
        this.number = number;
    }

    public CommodityVO getCommodityVO() {
        return commodityVO;
    }

    public void setCommodityVO(CommodityVO commodityVO) {
        this.commodityVO = commodityVO;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
