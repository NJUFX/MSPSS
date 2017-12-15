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
    private CustomerPromotion customerPromotion;
    private GrossPromotion grossPromotion;
    private GroupPromotion groupPromotion;

    public PromotionBLServiceImpl(CustomerPromotion customerPromotion, GrossPromotion grossPromotion, GroupPromotion groupPromotion) {
        this.customerPromotion = customerPromotion;
        this.grossPromotion = grossPromotion;
        this.groupPromotion = groupPromotion;
    }


    /**
     * 得到所有当前时间可用的客户促销策略
     *
     * @return
     */
    @Override
    public ArrayList<CustomerPromotionVO> getAvailableCustomerPromotion() {
        return customerPromotion.getAvailableCustomerPromotion();
    }

    /**
     * 得到所有当前时间可用的特价包促销策略
     *
     * @return
     */
    @Override
    public ArrayList<GroupPromotionVO> getAvailableGroupPromotion() {
        return groupPromotion.getAvailableGroupPromotion();
    }

    /**
     * 得到所有当前时间可用的满减促销策略
     *
     * @return
     */
    @Override
    public ArrayList<GrossPromotionVO> getAvailableGrossPromotion() {
        return grossPromotion.getAvailableGrossPromotion();
    }

    /**
     * 增加针对客户的促销策略
     *
     * @param promotionVO
     * @return
     */
    @Override
    public ResultMessage addCustomerPromotion(CustomerPromotionVO promotionVO) {
        return customerPromotion.addCustomerPromotion(promotionVO);
    }

    /**
     * 更改针对客户的促销策略
     *
     * @param promotionVO
     * @return
     */
    @Override
    public ResultMessage updateCustomerPromotion(CustomerPromotionVO promotionVO) {

        return customerPromotion.updateCustomerPromotion(promotionVO);
    }

    /**
     * 删除客户的促销策略
     *
     * @param promotionVO
     * @return
     */
    @Override
    public ResultMessage deleteCustomerPromotion(CustomerPromotionVO promotionVO) {

        return customerPromotion.deleteCustomerPromotion(promotionVO);
    }

    /**
     * 得到所有的客户促销策略
     *
     * @return
     */
    @Override
    public ArrayList<CustomerPromotionVO> getAllCustomerPromotion() {
        return customerPromotion.getAllCustomerPromotion();
    }

    /**
     * 添加特价包促销策略
     *
     * @param groupPromotionVO
     * @return
     */
    @Override
    public ResultMessage addGroupPromotion(GroupPromotionVO groupPromotionVO) {

        return groupPromotion.addGroupPromotion(groupPromotionVO);
    }

    /**
     * 更新特价包促销策略
     *
     * @param groupPromotionVO
     * @return
     */
    @Override
    public ResultMessage updateGroupPromotion(GroupPromotionVO groupPromotionVO) {

        return groupPromotion.updateGroupPromotion(groupPromotionVO);
    }

    /**
     * 删除特价包促销策略
     *
     * @param groupPromotionVO
     * @return
     */
    @Override
    public ResultMessage deleteGroupPromotion(GroupPromotionVO groupPromotionVO) {
        return groupPromotion.deleteGroupPromotion(groupPromotionVO);
    }

    /**
     * 得到所有的特价包促销策略
     *
     * @return
     */
    @Override
    public ArrayList<GroupPromotionVO> getAllGroupPromotion() {

        return groupPromotion.getAllGroupPromotion();
    }

    /**
     * 添加满减特价包促销策略
     *
     * @param grossPromotionVO
     * @return
     */
    @Override
    public ResultMessage addGrossPromotion(GrossPromotionVO grossPromotionVO) {

        return grossPromotion.addGrossPromotion(grossPromotionVO);
    }

    /**
     * 更新满减促销策略
     *
     * @param grossPromotionVO
     * @return
     */
    @Override
    public ResultMessage updateGrossPromotion(GrossPromotionVO grossPromotionVO) {

        return grossPromotion.updateGrossPromotion(grossPromotionVO);
    }

    /**
     * 删除满减策略
     *
     * @param grossPromotionVO
     * @return
     */
    @Override
    public ResultMessage deleteGrossPromotion(GrossPromotionVO grossPromotionVO) {
        return grossPromotion.deleteGrossPromotion(grossPromotionVO);
    }

    /**
     * 得到所有的满减策略
     *
     * @return
     */
    @Override
    public ArrayList<GrossPromotionVO> getAllGrossPromotion() {
        return grossPromotion.getAllGrossPromotion();
    }

}
