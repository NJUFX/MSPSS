package dataservice;

import filterflags.StockFilter;
import po.InventoryPO;
import po.StockPO;
import util.ResultMessage;

import java.util.Iterator;

public interface StockDataService {
    /**
     * 得到范围内的进出库信息
     * @param filter
     * @return
     */
    public Iterator<StockPO> SearchStock(StockFilter filter);

    /**
     * 得到所有的商品库存信息
     * @return
     */
    public Iterator<InventoryPO> getAllInventory();

    /**
     * 添加出入库信息信息
     * @param stockPO
     * @return
     */
    public ResultMessage addStock(StockPO stockPO);

    /**
     * 添加商品库存信息
     * @param inventoryPO
     * @return
     */
    public ResultMessage addInventory(InventoryPO inventoryPO);

    /**
     * 更新商品库存信息
     * @param inventoryPO
     * @return
     */
    public ResultMessage updateInventory(InventoryPO inventoryPO);

    /**
     * 搜索特定的商品库存信息
     * @param id
     * @return
     */
    public InventoryPO searchInventory(String id);

}
