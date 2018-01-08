package blimpl.stockblimpl;


import util.ResultMessage;
import vo.ChangeInfoVO;
import vo.StockInventoryVO;
import vo.StockVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 21:52 2017/11/21/021
 */
public class MockStock extends Stock {
    @Override
    public ResultMessage addStock(ArrayList<ChangeInfoVO> change) {
        return super.addStock(change);
    }

    @Override
    public ArrayList<StockVO> viewStock(String startTime, String endTime) {
        return super.viewStock(startTime, endTime);
    }

    @Override
    public ArrayList<StockInventoryVO> viewInventory() {
        return super.viewInventory();
    }
}
