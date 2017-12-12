package blservice.billblservice;


import util.ResultMessage;
import vo.*;

import java.util.ArrayList;

/**
 * Description: 给总经理用于审批单据 和查看未审批的单据
 * Created by Hanxinhu at 19:04 2017/12/12/012
 */
public interface  ManagerBillBLService {
    /**
     * 通过库存类单据 包括  库存赠送单 库存报损单 库存报溢单
     * @param stockBillVO
     * @return
     */
    public ResultMessage approveStockBill(StockBillVO stockBillVO);

    /**
     * 通过进货类单据  进货单 进货退货单
     * @param salesInBillVO
     * @return
     */
    public ResultMessage approveSalesInBill(SalesInBillVO salesInBillVO);

    /**
     * 通过销售单 销售退货单
     * @param salesOutBillVO
     * @return
     */
    public ResultMessage approveSalesOutBill(SalesOutBillVO salesOutBillVO);

    /**
     * 通过 应收单 应付单
     * @param financeBillVO
     * @return
     */
    public ResultMessage approveFinanceBill(FinanceBillVO financeBillVO);

    /**
     * 通过 现金费用单
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage approveCashCostBill(CashCostBillVO cashCostBillVO);
    /**
     * 拒绝库存类单据 包括  库存赠送单 库存报损单 库存报溢单
     * @param stockBillVO
     * @return
     */
    public ResultMessage rejectStockBill(StockBillVO stockBillVO);

    /**
     * 拒绝 进货类单据  进货单 进货退货单
     * @param salesInBillVO
     * @return
     */
    public ResultMessage rejectSalesInBill(SalesInBillVO salesInBillVO);

    /**
     * 拒绝 销售单 销售退货单
     * @param salesOutBillVO
     * @return
     */
    public ResultMessage rejectSalesOutBill(SalesOutBillVO salesOutBillVO);

    /**
     * 拒绝 应收单 应付单
     * @param financeBillVO
     * @return
     */
    public ResultMessage rejectFinanceBill(FinanceBillVO financeBillVO);

    /**
     * 拒绝 现金费用单
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage rejectCashCostBill(CashCostBillVO cashCostBillVO);

    /**
     * 得到所有等待审批的库存类单据
     * @return
     */
    public ArrayList<StockBillVO> getWaitingStockBill();
    /**
     * 得到所有等待审批的进货类单据
     * @return
     */
    public ArrayList<SalesInBillVO> getWaitingSalesInBill();
    /**
     * 得到所有等待审批的销售类单据
     * @return
     */
    public ArrayList<SalesOutBillVO> getWaitingSalesOutBill();
    /**
     * 得到所有等待审批的财务类单据 应收和应付
     * @return
     */
    public ArrayList<FinanceBillVO> getWaitingFinanceBill();
    /**
     * 得到所有等待审批的现金费用单据
     * @return
     */
    public ArrayList<CashCostBillVO> getWaitingcashCostBillVO();

}
