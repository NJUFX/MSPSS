package blimpl.promotionblimpl;
import blstubdriver.promotionstubdriver.Promotion_Stub;

import blservice.promotionblservice.PromotionBLInfo;
import blservice.promotionblservice.PromotionBLService;

/**
 * Description:
 * Created by Hanxinhu at 9:47 2017/12/13/013
 */
public class PromotionBLFactory {
    private static CustomerPromotion customerPromotion = new CustomerPromotion();
    private static GroupPromotion groupPromotion = new GroupPromotion();
    private static GrossPromotion grossPromotion = new GrossPromotion();
    private static PromotionBLServiceImpl impl;

    public synchronized static PromotionBLInfo getPromotionInfo(){
        if (impl==null){
            impl = new PromotionBLServiceImpl(customerPromotion,grossPromotion,groupPromotion);
        }
       return impl;
    }
   public synchronized static PromotionBLService getPromotionBLService(){
        if (impl==null){
            impl = new PromotionBLServiceImpl(customerPromotion,grossPromotion,groupPromotion);
        }
        return impl;
    }
    public synchronized static PromotionBLService getPromotionBLServiceStub(){

        return new Promotion_Stub();
    }

}

