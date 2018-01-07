package blservice.billblservice;

import exception.initclassexception.KeyColumnLostException;
import util.ResultMessage;
import vo.*;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 11:24 2017/12/19/019
 */
public interface FinanceBillBLService {

    /**
     * save commit
     */

    /**
     * 添加应收应付单
     *
     * @param vo
     * @return
     */
    public ResultMessage saveFinanceBill(FinanceBillVO vo) throws KeyColumnLostException;

    /**
     * 更新应收应付单
     *
     * @param vo
     * @return
     */
    public ResultMessage commitFinanceBill(FinanceBillVO vo) throws KeyColumnLostException;

    /**
     * 删除应收应付单
     *
     * @param vo
     * @return
     */
    public ResultMessage deleteFinanceBill(FinanceBillVO vo);

    /**
     * 得到某操作员创建的应收应付单据
     *
     * @param operatorID
     * @return
     */
    public ArrayList<FinanceBillVO> getMyFinanceBill(String operatorID);

    /**
     * 撤回已经提交的单据
     *
     * @param vo
     * @return
     */
    public ResultMessage withdrawFinanceBill(FinanceBillVO vo);
    /**
     * 添加现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage saveCashCostBill(CashCostBillVO cashCostBillVO)throws KeyColumnLostException;

    /**
     * 更新现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage commitCashCostBill(CashCostBillVO cashCostBillVO)throws KeyColumnLostException;

    /**
     * 删除现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage deleteCashCostBill(CashCostBillVO cashCostBillVO);

    /**
     * 得到某操作员创建的所有现金费用单
     *
     * @param operatorID
     * @return
     */
    public ArrayList<CashCostBillVO> getMyCashCostBill(String operatorID);

    /**
     * 撤回已经提交的现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage withdrawCashCostBill(CashCostBillVO cashCostBillVO);

    /**
     * 红冲库存类单据
     *
     * @param stockBillVO
     * @return
     */
    public ResultMessage HongChong(StockBillVO stockBillVO);

    /**
     * 红冲并复制
     *
     * @param stockBillVO
     * @return
     */
    public ResultMessage HongChongAndCopy(StockBillVO stockBillVO);

    /**
     * 红冲进货类单据
     *
     * @param salesInBillVO
     * @return
     */
    public ResultMessage HongChong(SalesInBillVO salesInBillVO);

    /**
     * 红冲销售类单据
     *
     * @param salesInBillVO
     * @return
     */
    public ResultMessage HongChongAndCopy(SalesInBillVO salesInBillVO);

    /**
     * @param salesOutBillVO
     * @return
     */
    public ResultMessage HongChong(SalesOutBillVO salesOutBillVO);

    /**
     * 红冲并复制销售类单据
     *
     * @param salesOutBillVO
     * @return
     */
    public ResultMessage HongChongAndCopy(SalesOutBillVO salesOutBillVO);

    /**
     * 红冲财务类单据
     *
     * @param financeBillVO
     * @return
     */
    public ResultMessage HongChong(FinanceBillVO financeBillVO);

    /**
     * 红冲并复制财务类单据
     *
     * @param financeBillVO
     * @return
     */
    public ResultMessage HongChongAndCopy(FinanceBillVO financeBillVO);

    /**
     * 红冲并复制财务类单据
     *
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage HongChong(CashCostBillVO cashCostBillVO);

    /**
     * 红冲并复制财务类单据
     *
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage HongChongAndCopy(CashCostBillVO cashCostBillVO);



}
