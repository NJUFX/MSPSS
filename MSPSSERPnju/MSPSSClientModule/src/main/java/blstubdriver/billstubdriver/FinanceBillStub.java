package blstubdriver.billstubdriver;

import blservice.billblservice.FinanceBillBLService;
import exception.initclassexception.KeyColumnLostException;
import util.ResultMessage;
import vo.*;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 8:32 2017/12/13/013
 */
public class FinanceBillStub implements FinanceBillBLService {
    /**
     * 添加应收应付单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage saveFinanceBill(FinanceBillVO vo) throws KeyColumnLostException {
        return null;
    }

    /**
     * 更新应收应付单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage commitFinanceBill(FinanceBillVO vo) throws KeyColumnLostException {
        return null;
    }

    /**
     * 删除应收应付单
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage deleteFinanceBill(FinanceBillVO vo) {
        return null;
    }

    /**
     * 得到某操作员创建的应收应付单据
     *
     * @param operatorID
     * @return
     */
    @Override
    public ArrayList<FinanceBillVO> getMyFinanceBill(String operatorID) {
        return null;
    }

    /**
     * 撤回已经提交的单据
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage withdrawFinanceBill(FinanceBillVO vo) {
        return null;
    }

    /**
     * 添加现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    @Override
    public ResultMessage saveCashCostBill(CashCostBillVO cashCostBillVO) throws KeyColumnLostException {
        return null;
    }

    /**
     * 更新现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    @Override
    public ResultMessage commitCashCostBill(CashCostBillVO cashCostBillVO) throws KeyColumnLostException {
        return null;
    }

    /**
     * 删除现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    @Override
    public ResultMessage deleteCashCostBill(CashCostBillVO cashCostBillVO) {
        return null;
    }

    /**
     * 得到某操作员创建的所有现金费用单
     *
     * @param operatorID
     * @return
     */
    @Override
    public ArrayList<CashCostBillVO> getMyCashCostBill(String operatorID) {
        return null;
    }

    /**
     * 撤回已经提交的现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    @Override
    public ResultMessage withdrawCashCostBill(CashCostBillVO cashCostBillVO) {
        return null;
    }

    /**
     * 红冲库存类单据
     *
     * @param stockBillVO
     * @return
     */
    @Override
    public ResultMessage HongChong(StockBillVO stockBillVO) {
        return null;
    }

    /**
     * 红冲并复制
     *
     * @param stockBillVO
     * @return
     */
    @Override
    public ResultMessage HongChongAndCopy(StockBillVO stockBillVO) {
        return null;
    }

    /**
     * 红冲进货类单据
     *
     * @param salesInBillVO
     * @return
     */
    @Override
    public ResultMessage HongChong(SalesInBillVO salesInBillVO) {
        return null;
    }

    /**
     * 红冲销售类单据
     *
     * @param salesInBillVO
     * @return
     */
    @Override
    public ResultMessage HongChongAndCopy(SalesInBillVO salesInBillVO) {
        return null;
    }

    /**
     * @param salesOutBillVO
     * @return
     */
    @Override
    public ResultMessage HongChong(SalesOutBillVO salesOutBillVO) {
        return null;
    }

    /**
     * 红冲并复制销售类单据
     *
     * @param salesOutBillVO
     * @return
     */
    @Override
    public ResultMessage HongChongAndCopy(SalesOutBillVO salesOutBillVO) {
        return null;
    }

    /**
     * 红冲财务类单据
     *
     * @param financeBillVO
     * @return
     */
    @Override
    public ResultMessage HongChong(FinanceBillVO financeBillVO) {
        return null;
    }

    /**
     * 红冲并复制财务类单据
     *
     * @param financeBillVO
     * @return
     */
    @Override
    public ResultMessage HongChongAndCopy(FinanceBillVO financeBillVO) {
        return null;
    }

    /**
     * 红冲并复制财务类单据
     *
     * @param cashCostBillVO
     * @return
     */
    @Override
    public ResultMessage HongChong(CashCostBillVO cashCostBillVO) {
        return null;
    }

    /**
     * 红冲并复制财务类单据
     *
     * @param cashCostBillVO
     * @return
     */
    @Override
    public ResultMessage HongChongAndCopy(CashCostBillVO cashCostBillVO) {
        return null;
    }
}
