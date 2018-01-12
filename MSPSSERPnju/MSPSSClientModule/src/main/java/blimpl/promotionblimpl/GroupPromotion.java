package blimpl.promotionblimpl;

import blimpl.blfactory.BLFactoryImpl;
import blservice.logblservice.LogBLInfo;
import blservice.userblservice.UserInfo;
import network.PromotionClientNetworkImpl;
import network.PromotionClientNetworkService;
import po.GroupPromotionPO;
import util.*;
import vo.GroupPromotionVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 18:39 2017/12/14/014
 */
public class GroupPromotion {
    private PromotionClientNetworkService networkService  = new PromotionClientNetworkImpl();
    private UserInfo userInfo = new BLFactoryImpl().getUserInfo();
    private LogBLInfo logBLInfo = new BLFactoryImpl().getLogBLInfo();

    /**
     * 添加特价包促销策略
     *
     * @param groupPromotionVO
     * @return
     */

    public ResultMessage addGroupPromotion(GroupPromotionVO groupPromotionVO) {
        groupPromotionVO.setId(new Time().getTimeID());
        if (userInfo.getCurrentUser() != null)
            logBLInfo.add(userInfo.getCurrentUser().getID(), "增加了特价包销售策略" + groupPromotionVO.getId());
        return networkService.addGroupPromotion(vo_to_po(groupPromotionVO));
    }

    /**
     * 更新特价包促销策略
     *
     * @param groupPromotionVO
     * @return
     */

    public ResultMessage updateGroupPromotion(GroupPromotionVO groupPromotionVO) {
        logBLInfo.add(userInfo.getCurrentUser().getID(), "更新了特价包销售策略" + groupPromotionVO.getId());

        return networkService.updateGroupPromotion(vo_to_po(groupPromotionVO));
    }

    /**
     * 删除特价包促销策略
     *
     * @param groupPromotionVO
     * @return
     */

    public ResultMessage deleteGroupPromotion(GroupPromotionVO groupPromotionVO) {
        logBLInfo.add(userInfo.getCurrentUser().getID(), "删除了特价包销售策略" + groupPromotionVO.getId());

        return networkService.deleteCustomerPromotion(groupPromotionVO.getId());
    }

    /**
     * 得到所有的特价包促销策略
     *
     * @return
     */

    public ArrayList<GroupPromotionVO> getAllGroupPromotion() {
        ArrayList<CriteriaClause> criteriaClauses = new ArrayList<>();
        criteriaClauses.add(CriteriaClauseImpl.createRangeValueQuery("initTime",Time.MIN_TIME,Time.MAX_TIME, QueryMethod.Range));
        ArrayList<GroupPromotionPO> pos = networkService.multiSearchGroupPromotion(criteriaClauses);
        return pos_to_vos(pos);
    }
    /**
     * 得到所有当前时间可用的特价包促销策略
     *
     * @return
     */

    public ArrayList<GroupPromotionVO> getAvailableGroupPromotion() {
        ArrayList<CriteriaClause> criteriaClauses = new ArrayList<>();
        Time time = new Time();
        CriteriaClause criteriaClause1 = CriteriaClauseImpl.createRangeValueQuery("initTime",Time.MIN_TIME,time.toString(), QueryMethod.Range);
        CriteriaClause criteriaClause2 = CriteriaClauseImpl.createRangeValueQuery("endTime",time.toString(),Time.MAX_TIME,QueryMethod.Range);
        criteriaClauses.add(criteriaClause1);
        criteriaClauses.add(criteriaClause2);
        ArrayList<GroupPromotionPO> pos = networkService.multiSearchGroupPromotion(criteriaClauses);
        return pos_to_vos(pos);
    }

    /**
     * @param po
     * @return
     */
    private GroupPromotionVO po_to_vo(GroupPromotionPO po){
        ArrayList<String> commoditys  = new ArrayList<>();
        commoditys.addAll(po.getCommodityIDs());
        GroupPromotionVO vo = new GroupPromotionVO(po.getDiscountRate(), commoditys, new Time(po.getInitTime()), new Time(po.getEndTime()));
        vo.setId(po.getId());
        return vo;
    }
    private GroupPromotionPO vo_to_po(GroupPromotionVO vo){
        GroupPromotionPO po = new GroupPromotionPO(vo.getId(),vo.getDiscountRate(),vo.getCommodityIDs(),vo.getInitTime().toString(),vo.getEndTime().toString());

        return po;
    }
    private ArrayList<GroupPromotionVO> pos_to_vos(ArrayList<GroupPromotionPO> pos){
        ArrayList<GroupPromotionVO> vos = new ArrayList<>();
        for(GroupPromotionPO po : pos){
                vos.add(po_to_vo(po));
        }
        return vos;
    }
}
