package blimpl.promotionblimpl;

import util.ResultMessage;
import vo.CustomerPromotionVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 9:10 2017/12/14/008
 */
public class MockCustomerPromotion extends CustomerPromotion {
    /**
     * 得到所有当前时间可用的客户促销策略
     *
     * @return
     */
    @Override
    public ArrayList<CustomerPromotionVO> getAvailableCustomerPromotion() {
        return super.getAvailableCustomerPromotion();
    }

    /**
     * 增加针对客户的促销策略
     *
     * @param promotionVO
     * @return
     */
    @Override
    public ResultMessage addCustomerPromotion(CustomerPromotionVO promotionVO) {
        return super.addCustomerPromotion(promotionVO);
    }

    /**
     * 更改针对客户的促销策略
     *
     * @param promotionVO
     * @return
     */
    @Override
    public ResultMessage updateCustomerPromotion(CustomerPromotionVO promotionVO) {
        return super.updateCustomerPromotion(promotionVO);
    }

    /**
     * 删除客户的促销策略
     *
     * @param promotionVO
     * @return
     */
    @Override
    public ResultMessage deleteCustomerPromotion(CustomerPromotionVO promotionVO) {
        return super.deleteCustomerPromotion(promotionVO);
    }

    /**
     * 得到所有的客户促销策略
     *
     * @return
     */
    @Override
    public ArrayList<CustomerPromotionVO> getAllCustomerPromotion() {
        return super.getAllCustomerPromotion();
    }
}
