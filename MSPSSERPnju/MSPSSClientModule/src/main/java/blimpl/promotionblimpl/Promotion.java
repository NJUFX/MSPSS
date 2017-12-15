package blimpl.promotionblimpl;


import po.CustomerPromotionPO;
import po.PromotionPO;
import util.ResultMessage;
import util.Time;
import vo.*;

import java.util.ArrayList;

/**
 * Created by Harper on 17/11/23
 */
public class Promotion {

    /**
     * 得到所有当前时间可用的客户促销策略
     *
     * @return
     */

    public ArrayList<CustomerPromotionVO> getAvailableCustomerPromotion() {
        return null;
    }

    /**
     * 得到所有当前时间可用的特价包促销策略
     *
     * @return
     */

    public ArrayList<GroupPromotionVO> getAvailableGroupPromotion() {
        return null;
    }

    /**
     * 得到所有当前时间可用的满减促销策略
     *
     * @return
     */

    public ArrayList<GrossPromotionVO> getAvailableGrossPromotion() {
        return null;
    }

    /**
     * 增加针对客户的促销策略
     *
     * @param promotionVO
     * @return
     */

    public ResultMessage addCustomerPromotion(CustomerPromotionVO promotionVO) {
        return null;
    }

    /**
     * 更改针对客户的促销策略
     *
     * @param promotionVO
     * @return
     */

    public ResultMessage updateCustomerPromotion(CustomerPromotionVO promotionVO) {
        return null;
    }

    /**
     * 删除客户的促销策略
     *
     * @param promotionVO
     * @return
     */

    public ResultMessage deleteCustomerPromotion(CustomerPromotionVO promotionVO) {
        return null;
    }

    /**
     * 得到所有的客户促销策略
     *
     * @return
     */

    public ArrayList<CustomerPromotionVO> getAllCustomerPromotion() {
        return null;
    }

    /**
     * 添加特价包促销策略
     *
     * @param groupPromotionVO
     * @return
     */

    public ResultMessage addGroupPromotion(GroupPromotionVO groupPromotionVO) {
        return null;
    }

    /**
     * 更新特价包促销策略
     *
     * @param groupPromotionVO
     * @return
     */

    public ResultMessage updateGroupPromotion(GroupPromotionVO groupPromotionVO) {
        return null;
    }

    /**
     * 删除特价包促销策略
     *
     * @param groupPromotionVO
     * @return
     */

    public ResultMessage deleteGroupPromotion(GroupPromotionVO groupPromotionVO) {
        return null;
    }

    /**
     * 得到所有的特价包促销策略
     *
     * @return
     */

    public ArrayList<GroupPromotionVO> getAllGroupPromotion() {
        return null;
    }

    /**
     * 添加满减特价包促销策略
     *
     * @param grossPromotionVO
     * @return
     */

    public ResultMessage addGrossPromotion(GrossPromotionVO grossPromotionVO) {
        return null;
    }

    /**
     * 更新满减促销策略
     *
     * @param grossPromotionVO
     * @return
     */

    public ResultMessage updateGrossPromotion(GrossPromotionVO grossPromotionVO) {
        return null;
    }

    /**
     * 删除满减策略
     *
     * @param grossPromotionVO
     * @return
     */

    public ResultMessage deleteGrossPromotion(GrossPromotionVO grossPromotionVO) {
        return null;
    }

    /**
     * 得到所有的满减策略
     *
     * @return
     */

    public ArrayList<GrossPromotionVO> getAllGrossPromotion() {
        return null;
    }

    private CustomerPromotionVO po_to_vo(CustomerPromotionPO po){
        return null;
    }
}
