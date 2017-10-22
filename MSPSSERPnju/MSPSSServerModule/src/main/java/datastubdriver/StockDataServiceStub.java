package java.dataservicestubdrive;

import util.ResultMessage;

import java.dataservice.StockDataService;

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
