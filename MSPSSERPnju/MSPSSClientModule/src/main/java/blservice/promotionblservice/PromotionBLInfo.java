package blservice.promotionblservice;

import vo.CustomerPromotionVO;
import vo.GrossPromotionVO;
import vo.GroupPromotionVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 9:08 2017/12/13/013
 */
public interface PromotionBLInfo {
    /**
     * 得到所有当前时间可用的客户促销策略
     * @return
     */
    public ArrayList<CustomerPromotionVO> getAvailableCustomerPromotion();

    /**
     * 得到所有当前时间可用的特价包促销策略
     * @return
     */
    public ArrayList<GroupPromotionVO> getAvailableGroupPromotion();

    /**
     * 得到所有当前时间可用的满减促销策略
     * @return
     */
    public ArrayList<GrossPromotionVO> getAvailableGrossPromotion();
}
