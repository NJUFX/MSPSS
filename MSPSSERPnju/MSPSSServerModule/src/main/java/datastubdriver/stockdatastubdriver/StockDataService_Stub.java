package datastubdriver.stockdatastubdriver;

import dataservice.StockDataService;
import filterflags.StockFilter;
import po.CommodityStockPO;
import po.StockPO;
import util.ResultMessage;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Project_Name ERPnju
 * Author: HanXinHu
 * Description:
 * Created on 22:33 2017/11/12/012
 */
public class StockDataService_Stub implements StockDataService {
    @Override
    public Iterator<StockPO> SearchStock(StockFilter filter) {
        if (filter!=null){
            System.out.println("search stock succeed");
            return new ArrayList<StockPO>().iterator();
        }
        System.out.println("search stock ");
        return null;
    }

    @Override
    public Iterator<CommodityStockPO> getAllInventory() {
        System.out.println("get all Inventory");
       return new ArrayList<CommodityStockPO>().iterator();

    }

    @Override
    public ResultMessage addStock(StockPO stockPO) {
        if (stockPO!=null)
        {
            System.out.println(" add stock succeed");
            return ResultMessage.SUCCESS;
        }
        System.out.println(" add stock fail");
        return ResultMessage.FAILED;
    }

    @Override
    public ResultMessage addInventory(CommodityStockPO commodityStockPO) {
        if (commodityStockPO != null)
        {
            System.out.println("add inventory succeed");
            return ResultMessage.SUCCESS;
        }
        System.out.println("add inventory failed");
        return ResultMessage.FAILED;
    }

    @Override
    public ResultMessage updateInventory(CommodityStockPO commodityStockPO) {
        if (commodityStockPO !=null)
        {
            System.out.println("update inventory succeed");
            return ResultMessage.SUCCESS;
        }
        System.out.println("update inventory failed");
        return ResultMessage.FAILED;
    }

    @Override
    public CommodityStockPO searchInventory(String id) {
        if (id.equals("12138")){
            System.out.println("search inventory succeed");
            return new CommodityStockPO();
        }
        System.out.println("search inventory failed");
        return null;
    }
}
