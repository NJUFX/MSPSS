package datastubdriver;

import po.CommodityPO;
import util.ResultMessage;

import dataservice.CommodityDataService;

public class CommodityServiceStub implements CommodityDataService {
    @Override
    public ResultMessage addCommodity(CommodityPO commodityPO) {
        return null;
    }

    @Override
    public ResultMessage modifyCommodity(CommodityPO commodityPO) {
        return null;
    }

    @Override
    public ResultMessage deleteCommodity(CommodityPO commodityPO) {
        return null;
    }

    @Override
    public ResultMessage searchCommodity() {
        return null;
    }

    @Override
    public ResultMessage AddClassification() {
        return null;
    }

    @Override
    public ResultMessage ModifyClassification() {
        return null;
    }

    @Override
    public ResultMessage DeleteClaassification() {
        return null;
    }
}
