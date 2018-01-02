package blimpl.promotionblimpl;

import network.PromotionClientNetworkService;
import po.CustomerPromotionPO;
import po.GrossPromotionPO;
import po.GroupPromotionPO;
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
    private PromotionClientNetworkService networkService  = new PromotionClientNetworkService() {
        @Override
        public ResultMessage addCustomerPromotion(CustomerPromotionPO po) {
            return null;
        }

        @Override
        public ResultMessage updateCustomerPromotion(CustomerPromotionPO po) {
            return null;
        }

        @Override
        public ResultMessage deleteCustomerPromotion(String id) {
            return null;
        }

        @Override
        public ArrayList<CustomerPromotionPO> multiSearchCustomerPromotion(ArrayList<CriteriaClause> criteriaClauses) {
            return null;
        }

        @Override
        public ResultMessage addGroupPromotion(GroupPromotionPO po) {
            return null;
        }

        @Override
        public ResultMessage updateGroupPromotion(GroupPromotionPO po) {
            return null;
        }

        @Override
        public ResultMessage deleteGroupPromotion(String id) {
            return null;
        }

        @Override
        public ArrayList<GroupPromotionPO> multiSearchGroupPromotion(ArrayList<CriteriaClause> criteriaClauses) {
            return null;
        }

        @Override
        public ResultMessage addGrossPromotion(GrossPromotionPO po) {
            return null;
        }

        @Override
        public ResultMessage updateGrossPromotion(GrossPromotionPO po) {
            return null;
        }

        @Override
        public ResultMessage deleteGrossPromotion(String id) {
            return null;
        }

        @Override
        public ArrayList<GrossPromotionPO> multiSearchGrossPromotion(ArrayList<CriteriaClause> criteriaClauses) {
            return null;
        }
    };
    /**
     * 得到所有当前时间可用的客户促销策略
     *
     * @return
     */

    public ArrayList<CustomerPromotionVO> getAvailableCustomerPromotion() {
        ArrayList<CriteriaClause> criteriaClauses = new ArrayList<>();
        Time time = new Time();
        CriteriaClause criteriaClause1 = CriteriaClauseImpl.createRangeValueQuery("init_time",Time.MIN_TIME,time.toString(), QueryMethod.Range);
        CriteriaClause criteriaClause2 = CriteriaClauseImpl.createRangeValueQuery("end_time",time.toString(),Time.MAX_TIME,QueryMethod.Range);
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
        CustomerPromotionPO po = vo_to_po(promotionVO);
        return networkService.addCustomerPromotion(po);
    }

    /**
     * 更改针对客户的促销策略
     *
     * @param promotionVO
     * @return
     */

    public ResultMessage updateCustomerPromotion(CustomerPromotionVO promotionVO) {
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

        return networkService.deleteCustomerPromotion(promotionVO.getId());
    }

    /**
     * 得到所有的客户促销策略
     *
     * @return
     */

    public ArrayList<CustomerPromotionVO> getAllCustomerPromotion() {
        ArrayList<CriteriaClause> criteriaClauses = new ArrayList<>();
        criteriaClauses.add(CriteriaClauseImpl.createRangeValueQuery("init_time",Time.MIN_TIME,Time.MAX_TIME,QueryMethod.Range));
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
     return new CustomerPromotionPO(vo.getLevel(),vo.getDiscount(),vo.getVoucher(),itemPOS,vo.getInitTime().toString(),vo.getEndTime().toString());
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
