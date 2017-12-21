package blservice.billblservice;

import util.ResultMessage;
import vo.StockBillVO;

/**
 * Description:
 * Created by Hanxinhu at 11:06 2017/12/19/019
 */
public interface StockManagerBillBLService {
    /**
     * 添加库存类单据
     *
     * @param vo
     * @return
     */
    public ResultMessage addStockBill(StockBillVO vo);

    /**
     * 更新库存类单据
     *
     * @param vo
     * @return
     */
    public ResultMessage updateStockBill(StockBillVO vo);

    /**
     * 删除库存类单据
     *
     * @param vo
     * @return
     */
    public ResultMessage deleteStockBill(StockBillVO vo);

    /**
     * 得到操作员创建的单据
     *
     * @param operatorID
     * @return
     */
    public ResultMessage getMyStockBill(String operatorID);
}
