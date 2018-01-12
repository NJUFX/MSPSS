package blimpl.billblimpl;

import po.StockBillPO;
import util.ResultMessage;
import util.StockBillType;
import vo.PresentationCommodityItemVO;
import vo.StockBillVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by Hanxinhu at 9:01 2017/11/28/008
 */
public class MockStockBill extends StockBill {
    @Override
    public ResultMessage addStockPresentationBill(List<PresentationCommodityItemVO> list, String ps) {
        return super.addStockPresentationBill(list, ps);
    }

    /**
     * 添加库存类单据
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage saveStockBill(StockBillVO vo) {
        return super.saveStockBill(vo);
    }

    /**
     * 更新库存类单据
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage commitStockBill(StockBillVO vo) {
        return super.commitStockBill(vo);
    }

    /**
     * 撤回库存类单据 （status为commit)
     *
     * @param vo
     * @return
     */
    @Override
    public ResultMessage withdrawStockBill(StockBillVO vo) {
        return super.withdrawStockBill(vo);
    }

    /**
     * 得到操作员创建的单据
     *
     * @param operatorID
     * @return
     */
    @Override
    public ArrayList<StockBillVO> getMyStockBill(String operatorID) {
        return super.getMyStockBill(operatorID);
    }

    @Override
    public ArrayList<StockBillVO> getWaitingStockBill() {
        return super.getWaitingStockBill();
    }

    @Override
    public ResultMessage deleteStockBill(StockBillVO vo) {
        return super.deleteStockBill(vo);
    }

    @Override
    public ResultMessage approveStockBill(StockBillVO stockBillVO) {
        return super.approveStockBill(stockBillVO);
    }

    @Override
    public String getID(StockBillType type) {
        return super.getID(type);
    }

    @Override
    public StockBillVO po_to_vo(StockBillPO po) {
        return super.po_to_vo(po);
    }
}
