package blimpl.billblimpl;

import util.ResultMessage;
import vo.SalesOutBillVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 13:23 2017/11/21/021
 */
public class SalesOutBill {
    /**
     * 添加销售单
     * 保存
     *
     * @param vo
     * @return
     */
    public ResultMessage saveSalesOutBill(SalesOutBillVO vo) {
        return ResultMessage.SUCCESS;
    }

    ;

    /**
     * 提交销售单
     *
     * @param vo
     * @return
     */
    public ResultMessage commitSalesOutBill(SalesOutBillVO vo) {
        return ResultMessage.SUCCESS;
    }

    ;

    /**
     * 删除销售单
     *
     * @param vo
     * @return
     */
    public ResultMessage deleteSalesOutBill(SalesOutBillVO vo) {
        return ResultMessage.SUCCESS;
    }

    ;

    /**
     * 得到自己的销售单
     *
     * @param operatorID
     * @return
     */
    public ArrayList<SalesOutBillVO> getMySalesOutBill(String operatorID) {
        return new ArrayList<>();
    }

    ;

    /**
     * @param vo
     * @return
     */
    public ResultMessage withdrawSalesOutBill(SalesOutBillVO vo) {
        return ResultMessage.SUCCESS;
    }

    public ArrayList<SalesOutBillVO> getWaitingSalesOutBill() {
        return new ArrayList<>();
    }

}
