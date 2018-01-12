package blimpl.stockblimpl;

import blservice.stockbl.StockBLInfo;
import blservice.stockbl.StockBLService;
import util.ResultMessage;
import util.Time;
import vo.ChangeInfoVO;
import vo.StockInventoryVO;
import vo.StockVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by Hanxinhu at 21:01 2017/11/18/018
 */
public class StockController implements StockBLService,StockBLInfo {
    private Stock stock;
    private ExportHelper exportHelper;
    public StockController(Stock stock) {
        this.stock = stock;
        exportHelper = new ExportHelper();
    }

    @Override
    public List<StockVO> viewStock(Time startTime, Time endTime) {
        return stock.viewStock(startTime.toString(),endTime.toString());
    }

    @Override
    public ResultMessage updateStock(ArrayList<ChangeInfoVO> change) {
        return stock.addStock(change);
    }

    /**
     * 库存盘点
     *
     * @return
     */
    @Override
    public ArrayList<StockInventoryVO> viewInventory() {
        return stock.viewInventory();
    }

    @Override
    public ResultMessage exportToExcel(ArrayList<StockInventoryVO> stockInventoryVOS) {
        exportHelper.ExportStockList(stockInventoryVOS);
        return ResultMessage.SUCCESS;
    }
}
