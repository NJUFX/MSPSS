package blimpl.promotionblimpl;

import blimpl.blfactory.BLFactoryImpl;
import blservice.logblservice.LogBLInfo;
import blservice.userblservice.UserInfo;
import network.PromotionClientNetworkImpl;
import network.PromotionClientNetworkService;
import po.GrossPromotionPO;
import po.PresentationCommodityItemPO;
import util.*;
import vo.GrossPromotionVO;
import vo.PresentationCommodityItemVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 18:39 2017/12/14/014
 */
public class GrossPromotion {
    private PromotionClientNetworkService networkService = new PromotionClientNetworkImpl();
    private UserInfo userInfo = new BLFactoryImpl().getUserInfo();
    private LogBLInfo logBLInfo = new BLFactoryImpl().getLogBLInfo();
    /**
     * 添加满减特价包促销策略
     *
     * @param grossPromotionVO
     * @return
     */

    public ResultMessage addGrossPromotion(GrossPromotionVO grossPromotionVO) {
        logBLInfo.add(userInfo.getCurrentUser().getID(), "新增了满减销售策略" + grossPromotionVO.getId());

        GrossPromotionPO po = vo_to_po(grossPromotionVO);
        return networkService.addGrossPromotion(po);
    }

    /**
     * 更新满减促销策略
     *
     * @param grossPromotionVO
     * @return
     */

    public ResultMessage updateGrossPromotion(GrossPromotionVO grossPromotionVO) {
        GrossPromotionPO po = vo_to_po(grossPromotionVO);
        logBLInfo.add(userInfo.getCurrentUser().getID(), "更新了满减销售策略" + grossPromotionVO.getId());

        return networkService.updateGrossPromotion(po);
    }

    /**
     * 删除满减策略
     *
     * @param grossPromotionVO
     * @return
     */

    public ResultMessage deleteGrossPromotion(GrossPromotionVO grossPromotionVO) {
        logBLInfo.add(userInfo.getCurrentUser().getID(), "删除了满减销售策略" + grossPromotionVO.getId());

        return networkService.deleteGrossPromotion(grossPromotionVO.getId());
    }

    /**
     * 得到所有的满减策略
     *
     * @return
     */

    public ArrayList<GrossPromotionVO> getAllGrossPromotion() {
        ArrayList<CriteriaClause> criteriaClauses = new ArrayList<>();
        CriteriaClause criteriaClause1 = CriteriaClauseImpl.createRangeValueQuery("initTime",Time.MIN_TIME,Time.MAX_TIME, QueryMethod.Range);
        criteriaClauses.add(criteriaClause1);
        ArrayList<GrossPromotionPO> pos = networkService.multiSearchGrossPromotion(criteriaClauses);
        return pos_to_vos(pos);
    }

    /**
     * 得到所有当前时间可用的满减促销策略
     *
     * @return
     */

    public ArrayList<GrossPromotionVO> getAvailableGrossPromotion() {
        ArrayList<CriteriaClause> criteriaClauses = new ArrayList<>();
        Time time = new Time();
        CriteriaClause criteriaClause1 = CriteriaClauseImpl.createRangeValueQuery("initTime",Time.MIN_TIME,time.toString(), QueryMethod.Range);
        CriteriaClause criteriaClause2 = CriteriaClauseImpl.createRangeValueQuery("endTime",time.toString(),Time.MAX_TIME,QueryMethod.Range);
        criteriaClauses.add(criteriaClause1);
        criteriaClauses.add(criteriaClause2);
        ArrayList<GrossPromotionPO> pos = networkService.multiSearchGrossPromotion(criteriaClauses);
        return pos_to_vos(pos) ;
    }
    private GrossPromotionPO vo_to_po(GrossPromotionVO vo){
        ArrayList<PresentationCommodityItemPO> itemPOS = new ArrayList<>();
        for (PresentationCommodityItemVO presentationCommodityItemVO
                : vo.getPresentationCommodityItemVOS()) {
            itemPOS.add(presentationCommodityItemVO.to_po());
        }
        GrossPromotionPO po = new GrossPromotionPO(vo.getTotal(),vo.getVoucher(),itemPOS,vo.getInitTime().toString(),vo.getEndTime().toString());
        return po;
    }
    private GrossPromotionVO po_to_vo(GrossPromotionPO po){
        ArrayList<PresentationCommodityItemVO> itemVOS = new ArrayList<>();
        for (PresentationCommodityItemPO presentationCommodityItemPO
                : po.getPresentationCommodityItemPOS()) {
            itemVOS.add(new PresentationCommodityItemVO(presentationCommodityItemPO.getCommodityID()
                    ,presentationCommodityItemPO.getNumber()));
        }
        GrossPromotionVO vo  = new GrossPromotionVO(po.getId(),po.getTotal(),po.getVoucher(),itemVOS,new Time(po.getInitTime()),new Time(po.getEndTime()));
        return vo;
    }
    private ArrayList<GrossPromotionVO> pos_to_vos(ArrayList<GrossPromotionPO> pos){
        ArrayList<GrossPromotionVO> vos = new ArrayList<>();
        for(GrossPromotionPO po : pos){
            vos.add(po_to_vo(po));
        }
        return vos;
    }
}
