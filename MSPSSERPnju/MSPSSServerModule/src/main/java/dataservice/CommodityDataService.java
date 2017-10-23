package dataservice;

import com.sun.org.apache.regexp.internal.RE;
import util.ResultMessage;

import po.*;

public interface CommodityDataService {
    public ResultMessage addCommodity(CommodityPO commodityPO);

    public ResultMessage modifyCommodity(CommodityPO commodityPO);

    public ResultMessage deleteCommodity(CommodityPO commodityPO);

    public ResultMessage searchCommodity();

    public ResultMessage AddClassification();

    public ResultMessage ModifyClassification();

    public ResultMessage DeleteClaassification();

}
