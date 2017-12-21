package blservice.billblservice;

import util.ResultMessage;
import vo.SalesInBillVO;
import vo.SalesOutBillVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 11:45 2017/12/19/019
 */
public interface SalemanBillBLService {
    /**
     * 添加进货单 进货退货单
     *
     * @param vo
     * @return
     */
    public ResultMessage addSalesInBill(SalesInBillVO vo);

    /**
     * 更新进货单 进货退货单
     *
     * @param vo
     * @return
     */
    public ResultMessage updateSalesInBill(SalesInBillVO vo);

    /**
     * 删除进货单 进货退货单
     *
     * @param vo
     * @return
     */
    public ResultMessage deleteSalesInBill(SalesInBillVO vo);

    /**
     * 得到自己的 进货单 进货退货单
     *
     * @param operatorID
     * @return
     */
    public ArrayList<SalesInBillVO> getMySalesInBill(String operatorID);

    /**
     * 添加销售单
     *
     * @param vo
     * @return
     */
    public ResultMessage addSalesOutBill(SalesOutBillVO vo);

    /**
     * 更新销售单
     *
     * @param vo
     * @return
     */
    public ResultMessage updateSalesOutBill(SalesOutBillVO vo);

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


}
