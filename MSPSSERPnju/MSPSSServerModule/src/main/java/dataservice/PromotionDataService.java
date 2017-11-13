package dataservice;

import po.PromotionPO;
import util.ResultMessage;
import util.Time;

import java.util.ArrayList;

/**
 * Created by Harper on 17/11/13
 */
public interface PromotionDataService {

    /**
     * 增加一条促销策略
     *
     * @param promotionPO
     * @return ResultMessage
     */
    public ResultMessage add(PromotionPO promotionPO);

    /**
     * 删除一条促销策略
     *
     * @param id
     * @return ResultMessage
     */
    public ResultMessage delete(String id);

    /**
     * 更新一条促销策略
     *
     * @param id
     * @param promotionPO
     * @return ResultMessage
     */
    public ResultMessage update(PromotionPO promotionPO,String id);

    /**
     * 搜索符合条件的促销策略
     *
     * @param date
     * @return ArrayList<PromotionPO>
     */
    public ArrayList<PromotionPO> search(Time date);
}
