package blimpl.promotionblimpl;

import util.ResultMessage;
import vo.GrossPromotionVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 9:12 2017/12/14/008
 */
public class MockGrossPromotion extends GrossPromotion {
    /**
     * 添加满减特价包促销策略
     *
     * @param grossPromotionVO
     * @return
     */
    @Override
    public ResultMessage addGrossPromotion(GrossPromotionVO grossPromotionVO) {
        return super.addGrossPromotion(grossPromotionVO);
    }

    /**
     * 更新满减促销策略
     *
     * @param grossPromotionVO
     * @return
     */
    @Override
    public ResultMessage updateGrossPromotion(GrossPromotionVO grossPromotionVO) {
        return super.updateGrossPromotion(grossPromotionVO);
    }

    /**
     * 删除满减策略
     *
     * @param grossPromotionVO
     * @return
     */
    @Override
    public ResultMessage deleteGrossPromotion(GrossPromotionVO grossPromotionVO) {
        return super.deleteGrossPromotion(grossPromotionVO);
    }

    /**
     * 得到所有的满减策略
     *
     * @return
     */
    @Override
    public ArrayList<GrossPromotionVO> getAllGrossPromotion() {
        return super.getAllGrossPromotion();
    }

    /**
     * 得到所有当前时间可用的满减促销策略
     *
     * @return
     */
    @Override
    public ArrayList<GrossPromotionVO> getAvailableGrossPromotion() {
        return super.getAvailableGrossPromotion();
    }
}
