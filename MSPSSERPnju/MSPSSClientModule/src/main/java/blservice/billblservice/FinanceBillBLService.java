package blservice.billblservice;

import util.ResultMessage;
import vo.CashCostBillVO;
import vo.FinanceBillVO;

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
    public ResultMessage addFinanceBill(FinanceBillVO vo);

    /**
     * 更新应收应付单
     *
     * @param vo
     * @return
     */
    public ResultMessage updateFinanceBill(FinanceBillVO vo);

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
     * 添加现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage addCashCostBill(CashCostBillVO cashCostBillVO);

    /**
     * 更新现金费用单
     *
     * @param cashCostBillVO
     * @return
     */
    public ResultMessage updateCashCostBill(CashCostBillVO cashCostBillVO);

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

}
