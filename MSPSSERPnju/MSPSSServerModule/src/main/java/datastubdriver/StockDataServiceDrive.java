package java.dataservicestubdrive;

import java.dataservice.BillDataService;
import java.dataservice.StockDataService;

public class StockDataServiceDrive   {
    public static void main(String[] args) {
        StockDataService s = new StockDataServiceStub();
        System.out.println(s.getAllStockInfo());
        System.out.println(s.getStockInfo());
    }
}
