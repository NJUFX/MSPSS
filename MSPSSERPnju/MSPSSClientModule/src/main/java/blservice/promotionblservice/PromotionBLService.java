package blservice.promotionblservice;

import blimpl.customerblimpl.Customer;
import po.PromotionPO;
import util.ResultMessage;
import util.Time;
import vo.*;

import java.util.ArrayList;

/**
 *
 * Created by Harper on 17/11/12
 */

public interface PromotionBLService {
    /**
     * 增加针对客户的促销策略
     * @param promotionVO
     * @return
     */
    public ResultMessage addCustomerPromotion(CustomerPromotionVO promotionVO);

    /**
     * 更改针对客户的促销策略
     * @param promotionVO
     * @return
     */
    public ResultMessage updateCustomerPromotion(CustomerPromotionVO promotionVO);

    /**
     * 删除客户的促销策略
     * @param promotionVO
     * @return
     */
    public ResultMessage deleteCustomerPromotion(CustomerPromotionVO promotionVO);

    /**
     * 得到所有的客户促销策略
     * @return
     */
    public ArrayList<CustomerPromotionVO> getAllCustomerPromotion();
    /**
     * 添加特价包促销策略
     * @return
     */
    public ResultMessage addGroupPromotion(GroupPromotionVO groupPromotionVO);

    /**
     * 更新特价包促销策略
     * @param groupPromotionVO
     * @return
     */
    public ResultMessage updateGroupPromotion(GroupPromotionVO groupPromotionVO);

    /**
     * 删除特价包促销策略
     * @param groupPromotionVO
     * @return
     */

    public ResultMessage deleteGroupPromotion(GroupPromotionVO groupPromotionVO);

    /**
     * 得到所有的特价包促销策略
     * @return
     */
    public ArrayList<GroupPromotionVO> getAllGroupPromotion();

    /**
     * 添加满减特价包促销策略
     * @param grossPromotionVO
     * @return
     */
    public ResultMessage addGrossPromotion(GrossPromotionVO grossPromotionVO);

    /**
     * 更新满减促销策略
     * @param grossPromotionVO
     * @return
     */
    public ResultMessage updateGrossPromotion(GrossPromotionVO grossPromotionVO);

    /**
     * 删除满减策略
     * @param grossPromotionVO
     * @return
     */
    public ResultMessage deleteGrossPromotion(GrossPromotionVO grossPromotionVO);

    /**
     * 得到所有的满减策略
     * @return
     */
    public ArrayList<GrossPromotionVO> getAllGrossPromotion();

}
