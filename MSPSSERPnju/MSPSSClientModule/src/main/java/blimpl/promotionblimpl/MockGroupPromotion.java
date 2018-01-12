package blimpl.promotionblimpl;

import util.ResultMessage;
import vo.GroupPromotionVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 9:13 2018/12/18/008
 */
public class MockGroupPromotion extends GroupPromotion {
    /**
     * 添加特价包促销策略
     *
     * @param groupPromotionVO
     * @return
     */
    @Override
    public ResultMessage addGroupPromotion(GroupPromotionVO groupPromotionVO) {
        return super.addGroupPromotion(groupPromotionVO);
    }

    /**
     * 更新特价包促销策略
     *
     * @param groupPromotionVO
     * @return
     */
    @Override
    public ResultMessage updateGroupPromotion(GroupPromotionVO groupPromotionVO) {
        return super.updateGroupPromotion(groupPromotionVO);
    }

    /**
     * 删除特价包促销策略
     *
     * @param groupPromotionVO
     * @return
     */
    @Override
    public ResultMessage deleteGroupPromotion(GroupPromotionVO groupPromotionVO) {
        return super.deleteGroupPromotion(groupPromotionVO);
    }

    /**
     * 得到所有的特价包促销策略
     *
     * @return
     */
    @Override
    public ArrayList<GroupPromotionVO> getAllGroupPromotion() {
        return super.getAllGroupPromotion();
    }

    /**
     * 得到所有当前时间可用的特价包促销策略
     *
     * @return
     */
    @Override
    public ArrayList<GroupPromotionVO> getAvailableGroupPromotion() {
        return super.getAvailableGroupPromotion();
    }
}
