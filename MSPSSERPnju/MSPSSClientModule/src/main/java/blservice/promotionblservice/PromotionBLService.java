package blservice.promotionblservice;

import po.PromotionPO;
import util.ResultMessage;
import util.Time;
import vo.CustomerPromotionVO;
import vo.PromotionListVO;
import vo.PromotionVO;

import java.util.ArrayList;

/**
 *
 * Created by Harper on 17/11/12
 */

public interface PromotionBLService {
    public ResultMessage addCustomerPromotion(CustomerPromotionVO promotionVO);

    public ResultMessage updateCustomerPromotion(CustomerPromotionVO promotionVO);

    public ResultMessage deleteCustomerPromotion(String id);
}
