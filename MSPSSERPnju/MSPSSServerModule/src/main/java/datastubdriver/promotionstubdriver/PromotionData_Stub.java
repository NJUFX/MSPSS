package datastubdriver.promotionstubdriver;

import dataservice.PromotionDataService;
import po.PromotionPO;
import util.ResultMessage;
import util.Time;
import po.PromotionPO;

import java.util.ArrayList;

public class PromotionData_Stub implements PromotionDataService{

    /**
     * 增加一条促销策略
     *
     * @param promotionPO
     * @return ResultMessage
     */
    public ResultMessage add(PromotionPO promotionPO){
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
     * @param promotionPO
     * @return ResultMessage
     */
    public ResultMessage update(PromotionPO promotionPO,String id){
        return ResultMessage.SUCCESS;
    }

    /**
     * 搜索符合条件的促销策略
     *
     * @param date
     * @return ArrayList<PromotionPO>
     */
    public ArrayList<PromotionPO> search(Time date){
        String[] Test_String = new String[1];
        PromotionPO Test_PromotionPO = new PromotionPO();
        ArrayList<PromotionPO> Test_PromotionPOList = new ArrayList<PromotionPO>();
        Test_PromotionPOList.add(Test_PromotionPO);
        return Test_PromotionPOList;
    }
}
