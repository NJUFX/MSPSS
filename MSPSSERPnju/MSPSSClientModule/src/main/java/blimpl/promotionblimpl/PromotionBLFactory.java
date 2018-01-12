package blimpl.promotionblimpl;

import blservice.promotionblservice.PromotionBLInfo;
import blservice.promotionblservice.PromotionBLService;
import blstubdriver.promotionstubdriver.Promotion_Stub;

/**
 * Description:
 * Created by Hanxinhu at 9:47 2017/12/13/013
 */
public class PromotionBLFactory {
    private static final CustomerPromotion customerPromotion = new CustomerPromotion();
    private static final GroupPromotion groupPromotion = new GroupPromotion();
    private static final GrossPromotion grossPromotion = new GrossPromotion();
    private static PromotionBLServiceImpl impl;

    /**
     * 返回一个PromotionBLServiceImpl的一个静态对象
     * @return PromotionBLInfpo
     */
    public synchronized static PromotionBLInfo getPromotionInfo(){
        if (impl==null){
            impl = new PromotionBLServiceImpl(customerPromotion,grossPromotion,groupPromotion);
        }
       return impl;
    }
    /**
     * 返回一个PromotionBLServiceImpl的一个静态对象
     * @return PromotionBLService
     */
   public synchronized static PromotionBLService getPromotionBLService(){
        if (impl==null){
            impl = new PromotionBLServiceImpl(customerPromotion,grossPromotion,groupPromotion);
        }
        return impl;
    }

    /**
     * 返回一个PromotionBLService的一个桩
     * @return PromotionBLService
     */
    public synchronized static PromotionBLService getPromotionBLServiceStub(){

        return new Promotion_Stub();
    }

}

