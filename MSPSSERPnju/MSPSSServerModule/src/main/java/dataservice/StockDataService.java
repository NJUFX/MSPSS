package dataservice;

import util.ResultMessage;

public interface StockDataService {
    public ResultMessage getStockInfo();

    public ResultMessage getAllStockInfo();
}
