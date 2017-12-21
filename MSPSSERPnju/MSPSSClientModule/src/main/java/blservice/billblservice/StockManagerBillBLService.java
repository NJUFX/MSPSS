package blservice.billblservice;

import util.ResultMessage;
import vo.AlarmBillVO;
import vo.StockBillVO;

import java.util.ArrayList;

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
    public ResultMessage saveStockBill(StockBillVO vo);

    /**
     * 更新库存类单据
     *
     * @param vo
     * @return
     */
    public ResultMessage commitStockBill(StockBillVO vo);

    /**
     * 删除库存类单据
     *
     * @param vo
     * @return
     */
    public ResultMessage deleteStockBill(StockBillVO vo);

    /**
     * 撤回库存类单据 （status为commit)
     *
     * @param vo
     * @return
     */
    public ResultMessage withdrawStockBill(StockBillVO vo);
    /**
     * 得到操作员创建的单据
     *
     * @param operatorID
     * @return
     */

    public ArrayList<StockBillVO> getMyStockBill(String operatorID);

    /**
     * 得到所有的库存报警单
     *
     * @return
     */
    public ArrayList<AlarmBillVO> getAllAlarmBill();

}
