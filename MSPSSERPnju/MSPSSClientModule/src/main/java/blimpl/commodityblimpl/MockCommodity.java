package blimpl.commodityblimpl;


import util.ResultMessage;
import vo.CommodityVO;

/**
 * Description:
 * Created by Hanxinhu at 21:45 2017/11/21/021
 */
public class MockCommodity extends Commodity{
    @Override
    public ResultMessage addCommodity(CommodityVO commodityVO) {
        return super.addCommodity(commodityVO);
    }

    @Override
    public ResultMessage updateCommodity(CommodityVO commodityVO) {
        return super.updateCommodity(commodityVO);
    }

    @Override
    public ResultMessage deleteCommodity(String id) {
        return super.deleteCommodity(id);
    }

    @Override
    public CommodityVO getCommodity(String id) {
        return super.getCommodity(id);
    }
}
