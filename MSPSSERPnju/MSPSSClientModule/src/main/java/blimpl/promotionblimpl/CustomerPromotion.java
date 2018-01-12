package blimpl.promotionblimpl;

import blimpl.blfactory.BLFactoryImpl;
import blservice.logblservice.LogBLInfo;
import blservice.userblservice.UserInfo;
import network.PromotionClientNetworkImpl;
import network.PromotionClientNetworkService;
import po.CustomerPromotionPO;
import po.PresentationCommodityItemPO;
import util.*;
import vo.CustomerPromotionVO;
import vo.PresentationCommodityItemVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 10:05 2017/12/13/013
 */
public class CustomerPromotion {
    private PromotionClientNetworkService networkService = new PromotionClientNetworkImpl();
    private UserInfo userInfo = new BLFactoryImpl().getUserInfo();
    private LogBLInfo logBLInfo = new BLFactoryImpl().getLogBLInfo();
    /**
     * 得到所有当前时间可用的客户促销策略
     *
     * @return
     */

    public ArrayList<CustomerPromotionVO> getAvailableCustomerPromotion() {
        ArrayList<CriteriaClause> criteriaClauses = new ArrayList<>();
        Time time = new Time();
        CriteriaClause criteriaClause1 = CriteriaClauseImpl.createRangeValueQuery("initTime",Time.MIN_TIME,time.toString(), QueryMethod.Range);
        CriteriaClause criteriaClause2 = CriteriaClauseImpl.createRangeValueQuery("endTime",time.toString(),Time.MAX_TIME,QueryMethod.Range);
        criteriaClauses.add(criteriaClause1);
        criteriaClauses.add(criteriaClause2);
        ArrayList<CustomerPromotionPO> pos = networkService.multiSearchCustomerPromotion(criteriaClauses);
        return pos_to_vos(pos);
    }
    /**
     * 增加针对客户的促销策略
     *
     * @param promotionVO
     * @return
     */
    public ResultMessage addCustomerPromotion(CustomerPromotionVO promotionVO) {
        promotionVO.setId(new Time().getTimeID());
        CustomerPromotionPO po = vo_to_po(promotionVO);
        if (userInfo.getCurrentUser() != null) {
            logBLInfo.add(userInfo.getCurrentUser().getID(), "新增了客户销售策略" + promotionVO.getId());
        }
        return networkService.addCustomerPromotion(po);
    }

    /**
     * 更改针对客户的促销策略
     *
     * @param promotionVO
     * @return
     */

    public ResultMessage updateCustomerPromotion(CustomerPromotionVO promotionVO) {
        logBLInfo.add(userInfo.getCurrentUser().getID(), "更新了客户销售策略" + promotionVO.getId());

        CustomerPromotionPO po = vo_to_po(promotionVO);
        return networkService.updateCustomerPromotion(po);
    }

    /**
     * 删除客户的促销策略
     *
     * @param promotionVO
     * @return
     */

    public ResultMessage deleteCustomerPromotion(CustomerPromotionVO promotionVO) {
        logBLInfo.add(userInfo.getCurrentUser().getID(), "删除了客户销售策略" + promotionVO.getId());

        return networkService.deleteCustomerPromotion(promotionVO.getId());
    }

    /**
     * 得到所有的客户促销策略
     *
     * @return
     */

    public ArrayList<CustomerPromotionVO> getAllCustomerPromotion() {
        ArrayList<CriteriaClause> criteriaClauses = new ArrayList<>();
        criteriaClauses.add(CriteriaClauseImpl.createRangeValueQuery("initTime",Time.MIN_TIME,Time.MAX_TIME,QueryMethod.Range));
        ArrayList<CustomerPromotionPO> pos = networkService.multiSearchCustomerPromotion(criteriaClauses);

        return pos_to_vos(pos);
    }

    private CustomerPromotionPO vo_to_po(CustomerPromotionVO vo){
        ArrayList<PresentationCommodityItemPO> itemPOS = new ArrayList<>();
        if (vo.getPresentationCommodityItemVOS()!=null)
        for (PresentationCommodityItemVO presentationCommodityItemVO
                : vo.getPresentationCommodityItemVOS()) {
            itemPOS.add(presentationCommodityItemVO.to_po());
        }
        CustomerPromotionPO po = new CustomerPromotionPO(vo.getLevel(), vo.getDiscount(), vo.getVoucher(), itemPOS, vo.getInitTime().toString(), vo.getEndTime().toString());
        po.setId(vo.getId());
        return po;
    }
    private CustomerPromotionVO po_to_vo(CustomerPromotionPO po){
        ArrayList<PresentationCommodityItemVO> itemVOS = new ArrayList<>();
        for (PresentationCommodityItemPO presentationCommodityItemPO
                : po.getPresentationCommodityItemPOS()) {
            itemVOS.add(new PresentationCommodityItemVO(presentationCommodityItemPO.getCommodityID()
            ,presentationCommodityItemPO.getNumber()));
        }
        return new CustomerPromotionVO(po.getId(),po.getLevel(),po.getDiscount(),po.getVoucher(),itemVOS,new Time(po.getInitTime()),
        new Time(po.getEndTime()));
    }

    /**
     * @param pos
     * @return
     */
    private ArrayList<CustomerPromotionVO> pos_to_vos(ArrayList<CustomerPromotionPO> pos){
        if (pos==null)
            return new ArrayList<>();
        ArrayList<CustomerPromotionVO> vos = new ArrayList<>();
        for(CustomerPromotionPO po : pos){
            vos.add(po_to_vo(po));
        }
        return vos;
    }


}
