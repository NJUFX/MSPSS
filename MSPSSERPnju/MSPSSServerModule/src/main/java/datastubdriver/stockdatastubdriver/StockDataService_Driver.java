//package datastubdriver.stockdatastubdriver;
//
//import dataservice.StockDataService;
//import filterflags.StockFilter;
//import org.junit.Test;
//import po.CommodityStockPO;
//import po.StockPO;
//import util.ResultMessage;
//
//import java.util.Iterator;
//
///**
// * Project_Name ERPnju
// * Author: HanXinHu
// * Description:
// * Created on 22:34 2017/11/12/012
// */
//public class StockDataService_Driver {
//    private static final StockPO stockPO = new StockPO();
//    private static final CommodityStockPO COMMODITY_STOCK_PO = new CommodityStockPO();
//    private static final StockFilter filter = new StockFilter();
//    private static final StockDataService service = new StockDataService_Stub();
//    @Test
//    public void drive(){
//        ResultMessage testMessage;
//        //1
//        testMessage = service.addInventory(COMMODITY_STOCK_PO);
//        if (testMessage== ResultMessage.SUCCESS)
//            System.out.println("add inventory succeed");
//        else
//            System.out.println("add inventory fail");
//
//        //2
//        testMessage = service.addStock(stockPO);
//        if (testMessage == ResultMessage.SUCCESS)
//            System.out.println("add stock succeed");
//        else
//            System.out.println("add stock failed");
//
//        //3
//        testMessage = service.updateInventory(COMMODITY_STOCK_PO);
//        if (testMessage == ResultMessage.SUCCESS)
//            System.out.println("update inventory succeed");
//        else
//            System.out.println("update inventory fail");
//
//        //4
//        Iterator<StockPO> stock = service.SearchStock(filter);
//        if (stock!=null)
//            System.out.println("search stockInfo succeed");
//        else
//            System.out.println("search stockInfo fail");
//
//        //5
//        Iterator<CommodityStockPO> inventoryPOIterator = service.getAllInventory();
//        if (inventoryPOIterator!=null)
//            System.out.println("get all inventory succeed");
//        else
//            System.out.println("get all inventory fail");
//
//        //6
//        CommodityStockPO inventory =  service.searchInventory("12138");
//        if (inventory!=null)
//            System.out.println("search inventory succeed");
//        else
//            System.out.println("search inventory false");
//
//    }
//}
