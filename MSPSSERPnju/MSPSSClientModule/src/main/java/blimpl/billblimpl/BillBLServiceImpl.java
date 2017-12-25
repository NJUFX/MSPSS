package blimpl.billblimpl;

import blservice.billblservice.FinanceBillBLService;
import blservice.billblservice.ManagerBillBLService;
import blservice.billblservice.SalesmanBillBLService;
import blservice.billblservice.StockManagerBillBLService;
import util.ResultMessage;
import vo.*;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 13:21 2017/11/21/021
 */
public class BillBLServiceImpl implements ManagerBillBLService, StockManagerBillBLService, FinanceBillBLService, SalesmanBillBLService {
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
     */
    @Override
    public ArrayList<AlarmBillVO> getAllAlarmBill() {
        return alarmBill.getAllAlarmBills();
    }




    @Override
    public ResultMessage approveStockBill(StockBillVO stockBillVO) {
        return null;
    }

    @Override
    public ResultMessage approveSalesInBill(SalesInBillVO salesInBillVO) {
        return null;
    }

    @Override
    public ResultMessage approveSalesOutBill(SalesOutBillVO salesOutBillVO) {
        return null;
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
        return null;
    }

    @Override
    public ResultMessage rejectSalesInBill(SalesInBillVO salesInBillVO) {
        return null;
    }

    @Override
    public ResultMessage rejectSalesOutBill(SalesOutBillVO salesOutBillVO) {
        return null;
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
        return null;
    }

    @Override
    public ArrayList<SalesOutBillVO> getWaitingSalesOutBill() {
        return null;
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


}
