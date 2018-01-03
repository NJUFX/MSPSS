package blimpl.billblimpl;

import blimpl.blfactory.BLFactoryImpl;
import blservice.billblservice.StockBillInfo;
import blservice.commodityblservice.CommodityInfoService;
import blservice.customerblservice.CustomerBLInfo;
import blservice.promotionblservice.PromotionBLInfo;
import blservice.userblservice.UserInfo;
import network.BillClientNetworkImpl;
import network.BillClientNetworkService;
import po.SalesItemPO;
import po.SalesOutBillPO;
import util.BillStatus;
import util.ResultMessage;
import util.SalesOutBillType;
import util.Time;
import vo.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Description:
 * Created by Hanxinhu at 13:23 2017/11/21/021
 */
public class SalesOutBill {
    //fixme 还有选择的销售策略的问题
    private static BillClientNetworkService networkService = new BillClientNetworkImpl();
    private static CommodityInfoService commodityinfoService = new BLFactoryImpl().getCommodityInfoService();
    private static UserInfo userInfo = new BLFactoryImpl().getUserInfo();
    private static CustomerBLInfo customerBLInfo = new BLFactoryImpl().getCustomerBLInfo();
    private static StockBillInfo stockBillInfo = new StockBill();
    private static PromotionBLInfo promotionBLInfo = new BLFactoryImpl().getPromotionBLInfo();
    /**
     * 添加销售单
     * 保存
     *
     * @param vo
     * @return
     */
    public ResultMessage saveSalesOutBill(SalesOutBillVO vo) {
        vo.setStatus(BillStatus.init);
        if (vo.getInit_time() == null) {
            vo.setInit_time(new Time());
        }
        if (vo.getID() == null) {
            String id = networkService.getSalesOutBillID(vo.getType());
            vo.setID(id);
            BillLogHelper.init(userInfo.getCurrentUser(), id);
            return networkService.addSalesOutBill(vo_to_po(vo));
        }
        BillLogHelper.update(userInfo.getCurrentUser(), vo.getID());

        return networkService.updateSalesOutBill(vo_to_po(vo));
    }

    ;

    /**
     * 提交销售单
     *
     * @param vo
     * @return
     */
    public ResultMessage commitSalesOutBill(SalesOutBillVO vo) {
        vo.setCommit_time(new Time());
        vo.setStatus(BillStatus.commit);
        ArrayList<PresentationCommodityItemVO> list = vo.getPresentations();
        stockBillInfo.addStockPresentationBill(list);
        BillLogHelper.commit(userInfo.getCurrentUser(), vo.getID());
        BillSendMessage.commit(userInfo.getCurrentUser(), vo.getID());
        //开始将单据赠送出去

        return networkService.updateSalesOutBill(vo_to_po(vo));
    }



    /**
     * 删除销售单
     *
     * @param vo
     * @return
     */
    public ResultMessage deleteSalesOutBill(SalesOutBillVO vo) {
        if (vo.getStatus() == BillStatus.init) {
            BillLogHelper.delete(userInfo.getCurrentUser(), vo.getID());
            return networkService.deleteSalesOutBill(vo.getID());
        }
        return ResultMessage.FAILED;
    }



    /**
     * 得到自己的销售单
     *
     * @param operatorID
     * @return
     */
    public ArrayList<SalesOutBillVO> getMySalesOutBill(String operatorID) {
        List<SalesOutBillPO> pos = networkService.fullSearchSalesOutBill("operatorID", operatorID);
        return pos_to_vos(pos);
    }



    /**
     * @param vo
     * @return
     */
    public ResultMessage withdrawSalesOutBill(SalesOutBillVO vo) {
        vo.setStatus(BillStatus.init);
        vo.setCommit_time(null);
        BillSendMessage.withdraw(userInfo.getCurrentUser(), vo.getID());
        BillLogHelper.withdraw(userInfo.getCurrentUser(), vo.getID());
        return networkService.updateSalesOutBill(vo_to_po(vo));
    }

    public ArrayList<SalesOutBillVO> getWaitingSalesOutBill() {
        List<SalesOutBillPO> pos = networkService.fullSearchSalesOutBill("status", BillStatus.commit.ordinal());

        return pos_to_vos(pos);
    }

    public ResultMessage approveSalesOutBill(SalesOutBillVO salesOutBillVO) {
        salesOutBillVO.setStatus(BillStatus.approval);
        salesOutBillVO.setApproval_time(new Time());
        BillSendMessage.approve(salesOutBillVO.getOperator(), userInfo.getCurrentUser(), salesOutBillVO.getID());
        BillLogHelper.approval(userInfo.getCurrentUser(), salesOutBillVO.getID());
        return networkService.updateSalesOutBill(vo_to_po(salesOutBillVO));
    }

    public ResultMessage rejectSalesOutBill(SalesOutBillVO salesOutBillVO) {
        salesOutBillVO.setApproval_time(new Time());
        salesOutBillVO.setStatus(BillStatus.rejected);
        BillSendMessage.reject(salesOutBillVO.getOperator(), userInfo.getCurrentUser(), salesOutBillVO.getID());
        BillLogHelper.reject(userInfo.getCurrentUser(), salesOutBillVO.getID());
        return networkService.updateSalesOutBill(vo_to_po(salesOutBillVO));
    }

    public static SalesOutBillVO po_to_vo(SalesOutBillPO po) {
        Time initTime = po.getInit_time() != null ? new Time(po.getInit_time()) : null;
        Time commitTime = po.getInit_time() != null ? new Time(po.getCommit_time()) : null;
        Time approvalTime = po.getInit_time() != null ? new Time(po.getApproval_time()) : null;
        UserVO operator = po.getOperatorID() != null ? userInfo.getUser(po.getOperatorID()) : null;
        UserVO manager = po.getManagerID() != null ? userInfo.getUser(po.getManagerID()) : null;
        SalesOutBillType type = SalesOutBillType.values()[po.getType()];
        BillStatus status = BillStatus.values()[po.getStatus()];
        CustomerVO customerVO = customerBLInfo.getCustomerByID(po.getCustomerID());
        List<SalesItemPO> salesItemPOS = po.getSalesItemPOS();
        ArrayList<SalesItemVO> salesItemVOS = new ArrayList<>();
        for (SalesItemPO itemPO :
                salesItemPOS) {
            salesItemVOS.add(po_to_vo(itemPO));
        }

        SalesOutBillVO vo = new SalesOutBillVO(po.getID(), type, status, customerVO, po.getDAE(), po.getStorage()
                , salesItemVOS, null, po.getAllowance(), po.getVoucher(), po.getPresent_vocher(), initTime
                , commitTime, approvalTime, manager, operator, po.getSumBeforeDiscount(), po.getSumAfterDiscount());
        return vo;
    }

    public static SalesOutBillPO vo_to_po(SalesOutBillVO vo) {
        String initTime = vo.getInit_time() != null ? vo.getInit_time().toString() : null;
        String commitTime = vo.getCommit_time() != null ? vo.getCommit_time().toString() : null;
        String approvalTime = vo.getApproval_time() != null ? vo.getApproval_time().toString() : null;
        String operatorID = vo.getOperator() != null ? vo.getOperator().getID() : null;
        String managerID = vo.getManager() != null ? vo.getManager().getID() : null;
        String customerID = vo.getCustomerVO() != null ? vo.getCustomerVO().getID() : null;

        ArrayList<SalesItemPO> itemPOS = new ArrayList<>();

        for (SalesItemVO itemVO : vo.getItemVOS()
                ) {
            itemPOS.add(vo_to_po(itemVO));
        }
        SalesOutBillPO po = new SalesOutBillPO(vo.getID(), vo.getType().ordinal(), customerID,
                vo.getDAE(), operatorID, managerID, vo.getStatus().ordinal(), vo.getStorage(), initTime, commitTime, approvalTime,
                vo.getPs(), vo.getAllowance(), vo.getVoucher(), vo.getPresentation_voucher(),
                vo.getSumBeforeDiscount(), vo.getSumAfterDiscount(), itemPOS);
        return po;
    }

    public static ArrayList<SalesOutBillVO> pos_to_vos(List<SalesOutBillPO> pos) {
        ArrayList<SalesOutBillVO> salesOutBillVOS = new ArrayList<>();
        for (SalesOutBillPO po :
                pos) {
            salesOutBillVOS.add(po_to_vo(po));
        }
        return salesOutBillVOS;
    }

    public static SalesItemPO vo_to_po(SalesItemVO vo) {
        return new SalesItemPO(vo.getId(), vo.getNumber(), vo.getPrice(), vo.getPs());
    }

    public static SalesItemVO po_to_vo(SalesItemPO po) {
        CommodityVO commodityVO = commodityinfoService.getCommodity(po.getId());
        SalesItemVO vo = new SalesItemVO(commodityVO, po.getNumber(), po.getPrice());
        return vo;
    }

    /**
     * 根据订单内容返回合适的客户促销策略
     *
     * @param vo
     * @return
     */
    public ArrayList<CustomerPromotionVO> searchCustomerPromotion(SalesOutBillVO vo) {
        //返回该时间范围内可用的
        List<CustomerPromotionVO> customerPromotionVOS = promotionBLInfo.getAvailableCustomerPromotion();
        ArrayList<CustomerPromotionVO> promotionVOS = new ArrayList<>();
        int customerLevel = vo.getCustomerVO().getLevel();
        for (CustomerPromotionVO pro : customerPromotionVOS
                ) {
            if (pro.getLevel() >= customerLevel)
                promotionVOS.add(pro);
        }
        return promotionVOS;
    }

    /**
     * 根据订单内容返回合适的特价包策略
     *
     * @param vo
     * @return
     */
    public ArrayList<GroupPromotionVO> searchGroupPromotion(SalesOutBillVO vo) {
        List<SalesItemVO> salesItemVOS = vo.getItemVOS();
        ArrayList<GroupPromotionVO> promotionVOS = promotionBLInfo.getAvailableGroupPromotion();
        ArrayList<GroupPromotionVO> avail = new ArrayList<>();
        HashSet<String> commodityIDs = new HashSet<>();
        for (SalesItemVO item : salesItemVOS
                ) {
            commodityIDs.add(item.getId());
        }
        for (GroupPromotionVO groupPromotionVO : promotionVOS) {
            ArrayList<String> ids = groupPromotionVO.getCommodityIDs();
            if (commodityIDs.containsAll(ids)) {
                avail.add(groupPromotionVO);
            }
        }
        return avail;
    }

    /**
     * 根据订单内容返回合适的满减策略
     *
     * @param vo
     * @return
     */
    public ArrayList<GrossPromotionVO> searchGrossPromotion(SalesOutBillVO vo) {
        ArrayList<GrossPromotionVO> promotionVOS = promotionBLInfo.getAvailableGrossPromotion();
        ArrayList<GrossPromotionVO> avail = new ArrayList<>();
        double sum = vo.sumAfterDiscount;
        for (GrossPromotionVO grossPromotion :
                promotionVOS) {
            if (grossPromotion.getTotal() > sum) {
                avail.add(grossPromotion);
            }
        }
        return avail;
    }

    /**
     * 对一个销售单设置针对客户的促销策略
     *
     * @param customerPromotionVO
     * @param salesOutBillVO
     * @return
     */
    public SalesOutBillVO setCustomerPromotion(CustomerPromotionVO customerPromotionVO, SalesOutBillVO salesOutBillVO) {
        if (customerPromotionVO.getLevel() <= salesOutBillVO.getCustomerVO().getLevel()) {
            //增加销售单的折让
            salesOutBillVO.setAllowance(salesOutBillVO.getAllowance() + customerPromotionVO.getDiscount());
            salesOutBillVO.setPresentation_voucher(salesOutBillVO.getPresentation_voucher() + customerPromotionVO.getVoucher());
            salesOutBillVO.getPresentations().addAll(customerPromotionVO.getPresentationCommodityItemVOS());
        }
        return salesOutBillVO;


    }

    /**
     * 对一个销售单设置针对满额的促销策略
     *
     * @param promotionVO
     * @param salesOutBillVO
     * @return
     */
    public SalesOutBillVO setGrossPromotion(GrossPromotionVO promotionVO, SalesOutBillVO salesOutBillVO) {
        double sum = salesOutBillVO.getSumAfterDiscount();
        if (sum <= promotionVO.getTotal()) {
            salesOutBillVO.getPresentations().addAll(promotionVO.getPresentationCommodityItemVOS());
            salesOutBillVO.setPresentation_voucher(salesOutBillVO.getPresentation_voucher() + promotionVO.getVoucher());
        }
        return salesOutBillVO;
    }

    /**
     * 对一个销售单使用特价包的销售策略
     *
     * @param promotionVO
     * @param salesOutBillVO
     * @return
     */
    public SalesOutBillVO setGroupPromotion(GroupPromotionVO promotionVO, SalesOutBillVO salesOutBillVO) {
        for (SalesItemVO itemVO : salesOutBillVO.getItemVOS()) {
            if (promotionVO.getCommodityIDs().contains(itemVO.getId())) {
                double price = itemVO.getPrice() * promotionVO.getDiscountRate();
                itemVO.setPrice(price);
            }
        }
        return salesOutBillVO;
    }

    /**
     * 对于一个销售单取消使用针对客户的促销策略
     *
     * @param customerPromotionVO
     * @param salesOutBillVO
     * @return
     */
    public SalesOutBillVO unSetCustomerPromotion(CustomerPromotionVO customerPromotionVO, SalesOutBillVO salesOutBillVO) {
        if (customerPromotionVO.getLevel() <= salesOutBillVO.getCustomerVO().getLevel()) {
            //增加销售单的折让
            salesOutBillVO.setAllowance(salesOutBillVO.getAllowance() - customerPromotionVO.getDiscount());
            salesOutBillVO.setPresentation_voucher(salesOutBillVO.getPresentation_voucher() - customerPromotionVO.getVoucher());
            salesOutBillVO.getPresentations().removeAll(customerPromotionVO.getPresentationCommodityItemVOS());
        }
        return salesOutBillVO;
    }

    /**
     * 对一个销售单取消使用针对满减的促销策略
     *
     * @param promotionVO
     * @param salesOutBillVO
     * @return
     */
    public SalesOutBillVO unSetGrossPromotion(GrossPromotionVO promotionVO, SalesOutBillVO salesOutBillVO) {


        salesOutBillVO.getPresentations().removeAll(promotionVO.getPresentationCommodityItemVOS());
        salesOutBillVO.setPresentation_voucher(salesOutBillVO.getPresentation_voucher() - promotionVO.getVoucher());

        return salesOutBillVO;
    }

    /**
     * 对一个销售单取消使用针对组合包的促销策略
     *
     * @param promotionVO
     * @param salesOutBillVO
     * @return
     */
    public SalesOutBillVO unSetGroupPromotion(GroupPromotionVO promotionVO, SalesOutBillVO salesOutBillVO) {
        for (SalesItemVO itemVO : salesOutBillVO.getItemVOS()) {
            if (promotionVO.getCommodityIDs().contains(itemVO.getId())) {
                double price = itemVO.getPrice() / (1 + promotionVO.getDiscountRate());
                itemVO.setPrice(price);
            }
        }
        return salesOutBillVO;
    }

    public ResultMessage HongChong(SalesOutBillVO salesOutBillVO) {
        return ResultMessage.FAILED;
    }

    public ResultMessage HongChongAndCopy(SalesOutBillVO salesOutBillVO) {
        return ResultMessage.FAILED;
    }

}
