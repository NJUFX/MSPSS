package blimpl.promotionblimpl;

import blservice.promotionblservice.PromotionBLInfo;
import blservice.promotionblservice.PromotionBLService;
import po.PromotionPO;
import util.ResultMessage;
import util.Time;
import vo.*;

import java.util.ArrayList;

/**
 * Created by Hanxihu on 17/12/13
 */

public class PromotionBLServiceImpl implements PromotionBLService,PromotionBLInfo {
    private Promotion promotion;

    public PromotionBLServiceImpl(Promotion promotion) {
        this.promotion = promotion;
    }

    /**
     * 得到所有当前时间可用的客户促销策略
     *
     * @return
     */
    @Override
    public ArrayList<CustomerPromotionVO> getAvailableCustomerPromotion() {
        return null;
    }

    /**
     * 得到所有当前时间可用的特价包促销策略
     *
     * @return
     */
    @Override
    public ArrayList<GroupPromotionVO> getAvailableGroupPromotion() {
        return null;
    }

    /**
     * 得到所有当前时间可用的满减促销策略
     *
     * @return
     */
    @Override
    public ArrayList<GrossPromotionVO> getAvailableGrossPromotion() {
        return null;
    }

    /**
     * 增加针对客户的促销策略
     *
     * @param promotionVO
     * @return
     */
    @Override
    public ResultMessage addCustomerPromotion(CustomerPromotionVO promotionVO) {
        return null;
    }

    /**
     * 更改针对客户的促销策略
     *
     * @param promotionVO
     * @return
     */
    @Override
    public ResultMessage updateCustomerPromotion(CustomerPromotionVO promotionVO) {
        return null;
    }

    /**
     * 删除客户的促销策略
     *
     * @param promotionVO
     * @return
     */
    @Override
    public ResultMessage deleteCustomerPromotion(CustomerPromotionVO promotionVO) {
        return null;
    }

    /**
     * 得到所有的客户促销策略
     *
     * @return
     */
    @Override
    public ArrayList<CustomerPromotionVO> getAllCustomerPromotion() {
        return null;
    }

    /**
     * 添加特价包促销策略
     *
     * @param groupPromotionVO
     * @return
     */
    @Override
    public ResultMessage addGroupPromotion(GroupPromotionVO groupPromotionVO) {
        return null;
    }

    /**
     * 更新特价包促销策略
     *
     * @param groupPromotionVO
     * @return
     */
    @Override
    public ResultMessage updateGroupPromotion(GroupPromotionVO groupPromotionVO) {
        return null;
    }

    /**
     * 删除特价包促销策略
     *
     * @param groupPromotionVO
     * @return
     */
    @Override
    public ResultMessage deleteGroupPromotion(GroupPromotionVO groupPromotionVO) {
        return null;
    }

    /**
     * 得到所有的特价包促销策略
     *
     * @return
     */
    @Override
    public ArrayList<GroupPromotionVO> getAllGroupPromotion() {
        return null;
    }

    /**
     * 添加满减特价包促销策略
     *
     * @param grossPromotionVO
     * @return
     */
    @Override
    public ResultMessage addGrossPromotion(GrossPromotionVO grossPromotionVO) {
        return null;
    }

    /**
     * 更新满减促销策略
     *
     * @param grossPromotionVO
     * @return
     */
    @Override
    public ResultMessage updateGrossPromotion(GrossPromotionVO grossPromotionVO) {
        return null;
    }

    /**
     * 删除满减策略
     *
     * @param grossPromotionVO
     * @return
     */
    @Override
    public ResultMessage deleteGrossPromotion(GrossPromotionVO grossPromotionVO) {
        return null;
    }

    /**
     * 得到所有的满减策略
     *
     * @return
     */
    @Override
    public ArrayList<GrossPromotionVO> getAllGrossPromotion() {
        return null;
    }
}
