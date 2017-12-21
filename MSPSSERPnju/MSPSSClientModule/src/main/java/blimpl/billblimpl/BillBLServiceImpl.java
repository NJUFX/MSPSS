package blimpl.billblimpl;

import blservice.billblservice.FinanceBillBLService;
import blservice.billblservice.ManagerBillBLService;
import blservice.billblservice.StockManagerBillBLService;
import util.ResultMessage;
import vo.*;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 13:21 2017/11/21/021
 */
public class BillBLServiceImpl implements ManagerBillBLService, StockManagerBillBLService, FinanceBillBLService {
    private StockBill stockBill ;
    private SalesOutBill salesOutBill ;
    private SalesInBill salesInBill ;
    private FinanceBill financeBill ;
    private CashCostBill cashCostBill;

    public BillBLServiceImpl(StockBill stockBill, SalesOutBill salesOutBill, SalesInBill salesInBill, FinanceBill financeBill) {
        this.stockBill = stockBill;
        this.salesOutBill = salesOutBill;
        this.salesInBill = salesInBill;
        this.financeBill = financeBill;
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
        return null;
    }

    @Override
    public ResultMessage approveCashCostBill(CashCostBillVO cashCostBillVO) {
        return null;
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
        return null;
    }

    @Override
    public ResultMessage rejectCashCostBill(CashCostBillVO cashCostBillVO) {
        return null;
    }

    @Override
    public ArrayList<StockBillVO> getWaitingStockBill() {
        return null;
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
        return null;
    }

    @Override
    public ArrayList<CashCostBillVO> getWaitingCashCostBillVO() {
        return null;
    }


    /**
     * 得到操作员创建的单据
     *
     * @param operatorID
     * @return
     */
    @Override
    public ResultMessage getMyStockBill(String operatorID) {
        return null;
    }

    /**
     * 添加库存类单据
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage addStockBill(StockBillVO vo) {
        return stockBill.addStockBill(vo);
    }

    /**
     * 更新库存类单据
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage updateStockBill(StockBillVO vo) {
        return stockBill.updateStockBill(vo);
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
    public ResultMessage addFinanceBill(FinanceBillVO vo) {

        return financeBill.addFinanceBill(vo);
    }

    /**
     * 更新应收应付单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage updateFinanceBill(FinanceBillVO vo) {
        return financeBill.updateFinanceBill(vo);
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
    public ResultMessage addCashCostBill(CashCostBillVO cashCostBillVO) {
        return cashCostBill.addCashCostBill(cashCostBillVO);
    }

    /**
     * 更新现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    @Override
    public ResultMessage updateCashCostBill(CashCostBillVO cashCostBillVO) {
        return cashCostBill.updateCashCostBill(cashCostBillVO);
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
