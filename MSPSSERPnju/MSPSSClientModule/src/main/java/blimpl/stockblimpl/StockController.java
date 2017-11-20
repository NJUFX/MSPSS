package blimpl.stockblimpl;

import blservice.stockbl.StockBLInfo;
import blservice.stockbl.StockBLService;
import util.ResultMessage;
import vo.BillVO;
import vo.InventoryVO;
import vo.StockVO;

import java.util.Iterator;

/**
 * Description:
 * Created by Hanxinhu at 21:01 2017/11/18/018
 */
public class StockController implements StockBLService,StockBLInfo {
    @Override
    public Iterator<StockVO> viewStock(String startTime, String endTime) {
        return null;
    }

    @Override
    public Iterator<InventoryVO> checkInventory() {
        return null;
    }

    @Override
    public ResultMessage updateStockAndInventory(BillVO billVO) {
        return null;
    }
}
