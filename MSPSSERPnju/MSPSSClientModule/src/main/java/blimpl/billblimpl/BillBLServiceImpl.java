package blimpl.billblimpl;

import blservice.billblservice.*;
import util.ResultMessage;
import util.Time;
import vo.*;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 13:21 2017/11/21/021
 */
public class BillBLServiceImpl implements ManagerBillBLService, StockManagerBillBLService, FinanceBillBLService, SalesmanBillBLService, BillBLInfo {
    private StockBill stockBill ;
    private SalesOutBill salesOutBill ;
    private SalesInBill salesInBill;
    private FinanceBill financeBill ;
    private CashCostBill cashCostBill;
    private AlarmBill alarmBill;

    public BillBLServiceImpl(StockBill stockBill, SalesOutBill salesOutBill, SalesInBill salesInBill, FinanceBill financeBill, CashCostBill cashCostBill, AlarmBill alarmBill) {
        this.stockBill = stockBill;
        this.salesOutBill = salesOutBill;
        this.salesInBill = salesInBill;
        this.financeBill = financeBill;
        this.cashCostBill = cashCostBill;
        this.alarmBill = alarmBill;
    }

    /**
     * 撤回已经提交的单据
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage withdrawFinanceBill(FinanceBillVO vo) {

        return financeBill.withdrawFinanceBill(vo);
    }

    /**
     * 撤回已经提交的现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    @Override
    public ResultMessage withdrawCashCostBill(CashCostBillVO cashCostBillVO) {
        return cashCostBill.withdrawCashCostBill(cashCostBillVO);
    }

    /**
     * 红冲库存类单据
     *
     * @param stockBillVO
     * @return
     */
    @Override
    public ResultMessage HongChong(StockBillVO stockBillVO) {
        return stockBill.HongChong(stockBillVO);
    }

    /**
     * 红冲并复制
     *
     * @param stockBillVO
     * @return
     */
    @Override
    public ResultMessage HongChongAndCopy(StockBillVO stockBillVO) {
        return stockBill.HongChongAndCopy(stockBillVO);
    }

    /**
     * 红冲进货类单据
     *
     * @param salesInBillVO
     * @return
     */
    @Override
    public ResultMessage HongChong(SalesInBillVO salesInBillVO) {
        return salesInBill.HongChong(salesInBillVO);
    }

    /**
     * 红冲销售类单据
     *
     * @param salesInBillVO
     * @return
     */
    @Override
    public ResultMessage HongChongAndCopy(SalesInBillVO salesInBillVO) {
        return salesInBill.HongChongAndCopy(salesInBillVO);
    }

    /**
     * @param salesOutBillVO
     * @return
     */
    @Override
    public ResultMessage HongChong(SalesOutBillVO salesOutBillVO) {
        return salesOutBill.HongChong(salesOutBillVO);
    }

    /**
     * 红冲并复制销售类单据
     *
     * @param salesOutBillVO
     * @return
     */
    @Override
    public ResultMessage HongChongAndCopy(SalesOutBillVO salesOutBillVO) {
        return salesOutBill.HongChongAndCopy(salesOutBillVO);
    }

    /**
     * 红冲财务类单据
     *
     * @param financeBillVO
     * @return
     */
    @Override
    public ResultMessage HongChong(FinanceBillVO financeBillVO) {
        return financeBill.HongChong(financeBillVO);
    }

    /**
     * 红冲并复制财务类单据
     *
     * @param financeBillVO
     * @return
     */
    @Override
    public ResultMessage HongChongAndCopy(FinanceBillVO financeBillVO) {
        return financeBill.HongChongAndCopy(financeBillVO);
    }

    /**
     * 红冲并复制财务类单据
     *
     * @param cashCostBillVO
     * @return
     */
    @Override
    public ResultMessage HongChong(CashCostBillVO cashCostBillVO) {
        return cashCostBill.HongChong(cashCostBillVO);
    }

    /**
     * 红冲并复制财务类单据
     *
     * @param cashCostBillVO
     * @return
     */
    @Override
    public ResultMessage HongChongAndCopy(CashCostBillVO cashCostBillVO) {
        return cashCostBill.HongChong(cashCostBillVO);
    }

    /**
     * 保存进货单 进货退货单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage saveSalesInBill(SalesInBillVO vo) {
        return salesInBill.saveSalesInBill(vo);
    }

    /**
     * 提交进货单 进货退货单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage commitSalesInBill(SalesInBillVO vo) {
        return salesInBill.commitSalesInBill(vo);
    }

    /**
     * 删除进货单 进货退货单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage deleteSalesInBill(SalesInBillVO vo) {
        return salesInBill.deleteSalesInBill(vo);
    }

    /**
     * 撤回已经提交的进货单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage withdrawSalesInBill(SalesInBillVO vo) {
        return salesInBill.withdrawSalesInBill(vo);
    }

    /**
     * 得到自己的 进货单 进货退货单
     *
     * @param operatorID
     * @return
     */
    @Override
    public ArrayList<SalesInBillVO> getMySalesInBill(String operatorID) {
        return salesInBill.getMySalesInBill(operatorID);
    }

    /**
     * 添加销售单
     * 保存
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage saveSalesOutBill(SalesOutBillVO vo) {
        return salesOutBill.saveSalesOutBill(vo);
    }

    /**
     * 提交销售单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage commitSalesOutBill(SalesOutBillVO vo) {
        return salesOutBill.commitSalesOutBill(vo);
    }

    /**
     * 删除销售单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage deleteSalesOutBill(SalesOutBillVO vo) {
        return salesOutBill.deleteSalesOutBill(vo);
    }

    /**
     * 得到自己的销售单
     *
     * @param operatorID
     * @return
     */
    @Override
    public ArrayList<SalesOutBillVO> getMySalesOutBill(String operatorID) {
        return salesOutBill.getMySalesOutBill(operatorID);
    }

    /**
     * @param vo
     * @return
     */
    @Override
    public ResultMessage withdrawSalesOutBill(SalesOutBillVO vo) {
        return salesOutBill.withdrawSalesOutBill(vo);
    }

    /**
     * 撤回库存类单据 （status为commit)
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage withdrawStockBill(StockBillVO vo) {
        return stockBill.withdrawStockBill(vo);
    }

    /**
     * 得到所有的库存报警单
     *
     * @return
     * @param time
     */
    @Override
    public ArrayList<AlarmBillVO> getAllAlarmBill(Time time) {
        return alarmBill.getAlarmBill(time);
    }




    @Override
    public ResultMessage approveStockBill(StockBillVO stockBillVO) {
        return stockBill.approveStockBill(stockBillVO);
    }

    @Override
    public ResultMessage approveSalesInBill(SalesInBillVO salesInBillVO) {
        return salesInBill.approveSalesInBill(salesInBillVO);
    }

    @Override
    public ResultMessage approveSalesOutBill(SalesOutBillVO salesOutBillVO) {
        return salesOutBill.approveSalesOutBill(salesOutBillVO);
    }

    @Override
    public ResultMessage approveFinanceBill(FinanceBillVO financeBillVO) {
        return financeBill.approveFinanceBill(financeBillVO);
    }

    @Override
    public ResultMessage approveCashCostBill(CashCostBillVO cashCostBillVO) {
        return cashCostBill.approveCashCostBill(cashCostBillVO);
    }

    @Override
    public ResultMessage rejectStockBill(StockBillVO stockBillVO) {
        return stockBill.rejectStockBill(stockBillVO);
    }

    @Override
    public ResultMessage rejectSalesInBill(SalesInBillVO salesInBillVO) {
        return salesInBill.rejectSalesInBill(salesInBillVO);
    }

    @Override
    public ResultMessage rejectSalesOutBill(SalesOutBillVO salesOutBillVO) {
        return salesOutBill.rejectSalesOutBill(salesOutBillVO);
    }

    @Override
    public ResultMessage rejectFinanceBill(FinanceBillVO financeBillVO) {
        return financeBill.rejectFinanceBill(financeBillVO);
    }

    @Override
    public ResultMessage rejectCashCostBill(CashCostBillVO cashCostBillVO) {
        return cashCostBill.rejectCashCostBill(cashCostBillVO);
    }

    @Override
    public ArrayList<StockBillVO> getWaitingStockBill() {
        return stockBill.getWaitingStockBill();
    }

    @Override
    public ArrayList<SalesInBillVO> getWaitingSalesInBill() {
        return salesInBill.getWaitingSalesInBill();
    }

    @Override
    public ArrayList<SalesOutBillVO> getWaitingSalesOutBill() {
        return salesOutBill.getWaitingSalesOutBill();
    }

    @Override
    public ArrayList<FinanceBillVO> getWaitingFinanceBill() {
        return financeBill.getWaitingFinanceBill();
    }

    @Override
    public ArrayList<CashCostBillVO> getWaitingCashCostBillVO() {
        return cashCostBill.getWaitingCashCostBill();
    }


    /**
     * 得到操作员创建的单据
     *
     * @param operatorID
     * @return
     */
    @Override
    public ArrayList<StockBillVO> getMyStockBill(String operatorID) {
        return stockBill.getMyStockBill(operatorID);
    }

    /**
     * 添加库存类单据
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage saveStockBill(StockBillVO vo) {
        return stockBill.saveStockBill(vo);
    }

    /**
     * 更新库存类单据
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage commitStockBill(StockBillVO vo) {
        return stockBill.commitStockBill(vo);
    }

    /**
     * 删除库存类单据
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage deleteStockBill(StockBillVO vo) {

        return stockBill.deleteStockBill(vo);
    }

    /**
     * 添加应收应付单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage saveFinanceBill(FinanceBillVO vo) {

        return financeBill.saveFinanceBill(vo);
    }

    /**
     * 更新应收应付单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage commitFinanceBill(FinanceBillVO vo) {

        return financeBill.commitFinanceBill(vo);
    }

    /**
     * 删除应收应付单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage deleteFinanceBill(FinanceBillVO vo) {
        return financeBill.deleteFinanceBill(vo);
    }

    /**
     * 得到某操作员创建的应收应付单据
     *
     * @param operatorID
     * @return
     */
    @Override
    public ArrayList<FinanceBillVO> getMyFinanceBill(String operatorID) {
        return financeBill.getMyFinanceBill(operatorID);
    }

    /**
     * 添加现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    @Override
    public ResultMessage saveCashCostBill(CashCostBillVO cashCostBillVO) {
        return cashCostBill.saveCashCostBill(cashCostBillVO);
    }

    /**
     * 更新现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    @Override
    public ResultMessage commitCashCostBill(CashCostBillVO cashCostBillVO) {
        return cashCostBill.commitCashCostBill(cashCostBillVO);
    }

    /**
     * 删除现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    @Override
    public ResultMessage deleteCashCostBill(CashCostBillVO cashCostBillVO) {
        return cashCostBill.deleteCashCostBill(cashCostBillVO);
    }

    /**
     * 得到某操作员创建的所有现金费用单
     *
     * @param operatorID
     * @return
     */
    @Override
    public ArrayList<CashCostBillVO> getMyCashCostBill(String operatorID) {
        return cashCostBill.getMyCashCostBill(operatorID);
    }


    @Override
    public ResultMessage addAlarmBill(String commodityID, int number) {
        return alarmBill.addAlarmBill(commodityID, number);
    }

    /**
     * 根据订单内容返回合适的客户促销策略
     *
     * @param vo
     * @return
     */
    @Override
    public ArrayList<CustomerPromotionVO> searchCustomerPromotion(SalesOutBillVO vo) {
        return salesOutBill.searchCustomerPromotion(vo);
    }

    /**
     * 根据订单内容返回合适的特价包策略
     *
     * @param vo
     * @return
     */
    @Override
    public ArrayList<GroupPromotionVO> searchGroupPromotion(SalesOutBillVO vo) {
        return salesOutBill.searchGroupPromotion(vo);
    }

    /**
     * 根据订单内容返回合适的满减策略
     *
     * @param vo
     * @return
     */
    @Override
    public ArrayList<GrossPromotionVO> searchGrossPromotion(SalesOutBillVO vo) {
        return salesOutBill.searchGrossPromotion(vo);
    }

    /**
     * 对一个销售单设置针对客户的促销策略
     *
     * @param customerPromotionVO
     * @param salesOutBillVO
     * @return
     */
    @Override
    public SalesOutBillVO setCustomerPromotion(CustomerPromotionVO customerPromotionVO, SalesOutBillVO salesOutBillVO) {
        return salesOutBill.setCustomerPromotion(customerPromotionVO, salesOutBillVO);
    }

    /**
     * 对一个销售单设置针对满额的促销策略
     *
     * @param promotionVO
     * @param salesOutBillVO
     * @return
     */
    @Override
    public SalesOutBillVO setGrossPromotion(GrossPromotionVO promotionVO, SalesOutBillVO salesOutBillVO) {
        return salesOutBill.setGrossPromotion(promotionVO, salesOutBillVO);
    }

    /**
     * 对一个销售单使用特价包的销售策略
     *
     * @param promotionVO
     * @param salesOutBillVO
     * @return
     */
    @Override
    public SalesOutBillVO setGroupPromotion(GroupPromotionVO promotionVO, SalesOutBillVO salesOutBillVO) {
        return salesOutBill.setGroupPromotion(promotionVO, salesOutBillVO);
    }

    /**
     * 对于一个销售单取消使用针对客户的促销策略
     *
     * @param customerPromotionVO
     * @param salesOutBillVO
     * @return
     */
    @Override
    public SalesOutBillVO unSetCustomerPromotion(CustomerPromotionVO customerPromotionVO, SalesOutBillVO salesOutBillVO) {
        return salesOutBill.unSetCustomerPromotion(customerPromotionVO, salesOutBillVO);
    }

    /**
     * 对一个销售单取消使用针对满减的促销策略
     *
     * @param promotionVO
     * @param salesOutBillVO
     * @return
     */
    @Override
    public SalesOutBillVO unSetGrossPromotion(GrossPromotionVO promotionVO, SalesOutBillVO salesOutBillVO) {
        return salesOutBill.unSetGrossPromotion(promotionVO, salesOutBillVO);
    }

    /**
     * 对一个销售单取消使用针对组合包的促销策略
     *
     * @param promotionVO
     * @param salesOutBillVO
     * @return
     */
    @Override
    public SalesOutBillVO unSetGroupPromotion(GroupPromotionVO promotionVO, SalesOutBillVO salesOutBillVO) {
        return salesOutBill.unSetGroupPromotion(promotionVO, salesOutBillVO);
    }
}
