package datastubdriver;

import util.ResultMessage;

import dataservice.StockDataService;

public class StockDataServiceStub implements StockDataService {
    @Override
    public ResultMessage getStockInfo() {
        return ResultMessage.FAILED;
    }

    @Override
    public ResultMessage getAllStockInfo() {
        return ResultMessage.FAILED;
    }
}
