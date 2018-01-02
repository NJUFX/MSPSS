package dataimpl.promotiondataimpl;

import datahelper.HibernateHelper;
import po.CustomerPromotionPO;
import po.GrossPromotionPO;
import po.GroupPromotionPO;

/**
 * Created by thinkpad on 2018/1/2.
 */
public class PromotionDataServiceFactory {
    private static PromotionDataServiceImpl promotionDataService;

    public static synchronized PromotionDataServiceImpl getPromotionDataService(){
        if(promotionDataService==null){
            promotionDataService = new PromotionDataServiceImpl(new HibernateHelper<CustomerPromotionPO>(CustomerPromotionPO.class),new HibernateHelper<GroupPromotionPO>(GroupPromotionPO.class),new HibernateHelper<GrossPromotionPO>(GrossPromotionPO.class));
        }
        return promotionDataService;
    }
}
