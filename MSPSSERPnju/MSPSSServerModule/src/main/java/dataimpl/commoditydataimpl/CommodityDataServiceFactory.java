package dataimpl.commoditydataimpl;

import datahelper.HibernateHelper;
import dataservice.CommodityDataService;
import po.ClassificationPO;
import po.CommodityPO;

/**
 * Created by thinkpad on 2017/12/8.
 */
public class CommodityDataServiceFactory {
    private static CommodityDataServiceImpl commodityDataService;

    public static synchronized CommodityDataService getCommodityDataService(){
        if(commodityDataService==null){
            commodityDataService = new CommodityDataServiceImpl(new HibernateHelper<CommodityPO>(CommodityPO.class), new HibernateHelper<ClassificationPO>(ClassificationPO.class));

        }
        return commodityDataService;
    }
}
