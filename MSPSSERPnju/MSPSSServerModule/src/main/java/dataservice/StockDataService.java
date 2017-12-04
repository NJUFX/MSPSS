package dataservice;

import filterflags.StockFilter;
import po.CommodityStockPO;
import po.StockPO;
import util.ResultMessage;

import java.util.ArrayList;
import java.util.Iterator;

public interface StockDataService {
    /**
     * 得到需要时间范围内的进出库信息
     *
     * @return
     */
    public ArrayList<StockPO> rangeSearchStock(String filed, Object min, Object max);



    /**
     * 添加出入库信息信息
     * @param stockPO
     * @return
     */
    public ResultMessage addStock(StockPO stockPO);


}
