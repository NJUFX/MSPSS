package blstubdriver.promotionstubdriver;

import blservice.promotionblservice.PromotionBLService;
import po.PromotionPO;
import util.ResultMessage;
import util.Time;
import vo.PromotionListVO;
import vo.PromotionVO;

import java.util.ArrayList;

public class Promotion_Stub implements PromotionBLService{

    //constants
    String[] Test_String = new String[1];
    PromotionVO Test_PromotionVO = new PromotionVO("000001","分级赠送赠品",Test_String,new Time(2017,11,13,9,12,12));
    PromotionPO Test_PromotionPO = new PromotionPO();
    ArrayList<PromotionVO> Test_PromotionVOList = new ArrayList<PromotionVO>();


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
        ArrayList<PromotionPO> Test_PromotionPOList = new ArrayList<PromotionPO>();
        Test_PromotionPOList.add(Test_PromotionPO);
        return Test_PromotionPOList;
    }

    /**
     * 显示促销策略列表
     *
     * @param promotionList
     * @return PromotionListVO
     */
    public PromotionListVO showPromotionList(ArrayList<PromotionPO> promotionList){
        Test_PromotionVOList.add(Test_PromotionVO);
        PromotionListVO Test_PromotionListVO = new PromotionListVO(Test_PromotionVOList);
        return Test_PromotionListVO;
    }

    /**
     * 显示促销策略详情
     *
     * @param id
     * @return PromotionVO
     */
    public PromotionVO showPromotionDetail(String id){
        return Test_PromotionVO;
    }
}