package blimpl.promotionblimpl;

import blservice.promotionblservice.PromotionBLService;
import po.PromotionPO;
import util.ResultMessage;
import util.Time;
import vo.PromotionListVO;
import vo.PromotionVO;

import java.util.ArrayList;

/**
 * Created by Harper on 17/11/23
 */

public class PromotionBLServiceImpl implements PromotionBLService {
    /**
     * 增加一条促销策略
     *
     * @param promotionVO
     * @return ResultMessage
     */
    public ResultMessage add(PromotionVO promotionVO){
        return ResultMessage.SUCCESS;
    }

    /**
     * 删除一条促销策略
     *
     * @param id
     * @return ResultMessage
     */
    public ResultMessage delete(String id){
        return ResultMessage.SUCCESS;
    }

    /**
     * 更新一条促销策略
     *
     * @param id
     * @param promotionVO
     * @return ResultMessage
     */
    public ResultMessage update(String id,PromotionVO promotionVO){
        return ResultMessage.SUCCESS;
    }

    /**
     * 搜索所有有效的促销策略
     *
     * @param date
     * @return ArrayList<PromotionPO>
     */
    public ArrayList<PromotionPO> search(Time date){
        return null;
    }

    /**
     * 显示促销策略列表
     *
     * @param promotionList
     * @return PromotionListVO
     */
    public PromotionListVO showPromotionList(ArrayList<PromotionPO> promotionList){
        return null;
    }

    /**
     * 显示促销策略详情
     *
     * @param id
     * @return PromotionVO
     */
    public PromotionVO showPromotionDetail(String id){
        return null;
    }
}
