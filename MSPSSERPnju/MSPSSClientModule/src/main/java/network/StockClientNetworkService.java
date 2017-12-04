package network;

import po.StockPO;
import util.ResultMessage;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Description:
 * Created by Hanxinhu at 14:08 2017/11/30/030
 */
public interface StockClientNetworkService {
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
