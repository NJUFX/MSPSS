package blstubdriver.billstubdriver;

import blservice.billblservice.StockManagerBillBLService;
import exception.initclassexception.KeyColumnLostException;
import util.ResultMessage;
import util.Time;
import vo.AlarmBillVO;
import vo.StockBillVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 8:31 2017/12/13/013
 */
public class StockManagerStub implements StockManagerBillBLService {
    /**
     * 添加库存类单据
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage saveStockBill(StockBillVO vo) throws KeyColumnLostException {
        return null;
    }

    /**
     * 更新库存类单据
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage commitStockBill(StockBillVO vo) throws KeyColumnLostException {
        return null;
    }

    /**
     * 删除库存类单据
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage deleteStockBill(StockBillVO vo) {
        return null;
    }

    /**
     * 撤回库存类单据 （status为commit)
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage withdrawStockBill(StockBillVO vo) {
        return null;
    }

    /**
     * 得到操作员创建的单据
     *
     * @param operatorID
     * @return
     */
    @Override
    public ArrayList<StockBillVO> getMyStockBill(String operatorID) {
        return null;
    }

    /**
     * 得到某一天的库存报警单
     *
     * @param time
     * @return
     */
    @Override
    public ArrayList<AlarmBillVO> getAllAlarmBill(Time time) {
        return null;
    }
}
