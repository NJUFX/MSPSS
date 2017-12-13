package blimpl.promotionblimpl;

import blservice.promotionblservice.PromotionBLInfo;
import blservice.promotionblservice.PromotionBLService;

/**
 * Description:
 * Created by Hanxinhu at 9:47 2017/12/13/013
 */
public class PromotionBLFactory {
    private static Promotion promotion = new Promotion();
    private static PromotionBLServiceImpl impl;

    private synchronized static PromotionBLInfo getPromotionInfo(){
        if (impl==null){
            impl = new PromotionBLServiceImpl(promotion);
        }
       return impl;
    }
    private synchronized static PromotionBLService getPromotionBLService(){
        if (impl==null){
            impl = new PromotionBLServiceImpl(promotion);
        }
        return impl;
    }
}

