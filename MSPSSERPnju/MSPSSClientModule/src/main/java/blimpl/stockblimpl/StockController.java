package blimpl.stockblimpl;

import blservice.stockbl.StockBLInfo;
import blservice.stockbl.StockBLService;
import util.ResultMessage;
import vo.ChangeInfoVO;
import vo.StockVO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Description:
 * Created by Hanxinhu at 21:01 2017/11/18/018
 */
public class StockController implements StockBLService,StockBLInfo {
    private Stock stock;
    @Override
    public Iterator<StockVO> viewStock(String startTime, String endTime) {
        return stock.viewStock(startTime,endTime).iterator();
    }

    @Override
    public ResultMessage updateStock(ArrayList<ChangeInfoVO> change) {
        return stock.addStock(change);
    }
}
