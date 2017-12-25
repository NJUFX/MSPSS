package blservice.billblservice;

import util.ResultMessage;
import vo.SalesInBillVO;
import vo.SalesOutBillVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 11:45 2017/12/19/019
 */
public interface SalesmanBillBLService {
    /**
     * 保存进货单 进货退货单
     *
     * @param vo
     * @return
     */
    public ResultMessage saveSalesInBill(SalesInBillVO vo);

    /**
     * 提交进货单 进货退货单
     *
     * @param vo
     * @return
     */
    public ResultMessage commitSalesInBill(SalesInBillVO vo);

    /**
     * 删除进货单 进货退货单
     *
     * @param vo
     * @return
     */
    public ResultMessage deleteSalesInBill(SalesInBillVO vo);

    /**
     * 撤回已经提交的进货单
     *
     * @param vo
     * @return
     */
    public ResultMessage withdrawSalesInBill(SalesInBillVO vo);
    /**
     * 得到自己的 进货单 进货退货单
     *
     * @param operatorID
     * @return
     */
    public ArrayList<SalesInBillVO> getMySalesInBill(String operatorID);

    /**
     * 添加销售单
     *  保存
     * @param vo
     * @return
     */
    public ResultMessage saveSalesOutBill(SalesOutBillVO vo);

    /**
     * 提交销售单
     *
     * @param vo
     * @return
     */
    public ResultMessage commitSalesOutBill(SalesOutBillVO vo);

    /**
     * 删除销售单
     *
     * @param vo
     * @return
     */
    public ResultMessage deleteSalesOutBill(SalesOutBillVO vo);

    /**
     * 得到自己的销售单
     *
     * @param operatorID
     * @return
     */
    public ArrayList<SalesOutBillVO> getMySalesOutBill(String operatorID);

    /**
     * 撤回自己的销售单
     *
     * @param vo
     * @return
     */
    public ResultMessage withdrawSalesOutBill(SalesOutBillVO vo);

}
