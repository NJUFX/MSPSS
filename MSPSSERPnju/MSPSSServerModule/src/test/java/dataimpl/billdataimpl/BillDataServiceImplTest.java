package dataimpl.billdataimpl;

import dataservice.BillDataService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import po.CashCostBillPO;
import po.CashCostItemPO;
import po.StockBillItemPO;
import po.StockBillPO;
import util.Time;

import java.util.ArrayList;

/** 
* BillDataServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>һ�� 1, 2018</pre> 
* @version 1.0 
*/ 
public class BillDataServiceImplTest { 
private BillDataService billDataService;
@Before
public void before() throws Exception {
    billDataService = BillDataServiceFactory.getBillDataService();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: addStockBill(StockBillPO stockBillPO) 
* 
*/ 
@Test
public void testAddStockBill() throws Exception { 
//TODO: Test goes here...
    ArrayList<StockBillItemPO> stockBillItemPOS = new ArrayList<StockBillItemPO>();
    StockBillItemPO stockBillItemPO = new StockBillItemPO("123",20);
    stockBillItemPOS.add(stockBillItemPO);
    Time time = new Time(2017,1,1,1,1,1);
    StockBillPO stockBillPO = new StockBillPO("123456",1,1,stockBillItemPOS,time.toString(),time.toString(),time.toString(),"写的很好","写的不错","1234567","2345");
    billDataService.addStockBill(stockBillPO);

} 

/** 
* 
* Method: updateStockBill(StockBillPO stockBillPO) 
* 
*/ 
@Test
public void testUpdateStockBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteStockBill(String id) 
* 
*/ 
@Test
public void testDeleteStockBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: fullSearchStockBill(String field, Object value) 
* 
*/ 
@Test
public void testFullSearchStockBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: multiSearchStockBill(ArrayList<CriteriaClause> criteriaClauses) 
* 
*/ 
@Test
public void testMultiSearchStockBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: rangeSearchStockBill(String field, Object max, Object min) 
* 
*/ 
@Test
public void testRangeSearchStockBill() throws Exception { 
//TODO: Test goes here...
    ArrayList<StockBillPO> stockBillPOS = billDataService.rangeSearchStockBill("init_time",Time.MIN_TIME,Time.MAX_TIME);
    System.out.println(stockBillPOS.get(0).getItemPOS().get(0).getCommodityID());
} 

/** 
* 
* Method: getStockBillID(StockBillType type) 
* 
*/ 
@Test
public void testGetStockBillID() throws Exception { 
//TODO: Test goes here...


} 

/** 
* 
* Method: addCashCostBill(CashCostBillPO po) 
* 
*/ 
@Test
public void testAddCashCostBill() throws Exception { 
//TODO: Test goes here...
    ArrayList<CashCostItemPO> cashCostItemPOS = new ArrayList<CashCostItemPO>();
    CashCostItemPO cashCostItemPO = new CashCostItemPO("123","写的很好",123);
    cashCostItemPOS.add(cashCostItemPO);
    Time time = new Time(2017,1,1,1,1,1);
    CashCostBillPO cashCostBillPO = new CashCostBillPO("111222","123456","123321",1,cashCostItemPOS,123,time.toString(),time.toString(),time.toString(),"123");
    billDataService.addCashCostBill(cashCostBillPO);

}

/** 
* 
* Method: updateCashCostBill(CashCostBillPO po) 
* 
*/ 
@Test
public void testUpdateCashCostBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteCashCostBill(String id) 
* 
*/ 
@Test
public void testDeleteCashCostBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: multiSearchCashCostBill(ArrayList<CriteriaClause> criteriaClauses) 
* 
*/ 
@Test
public void testMultiSearchCashCostBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: fullSearchCashCostBill(String field, Object val) 
* 
*/ 
@Test
public void testFullSearchCashCostBill() throws Exception { 
//TODO: Test goes here...

    ArrayList<CashCostBillPO> cashCostBillPOS = billDataService.fullSearchCashCostBill("operatorID","11111");
    System.out.print(cashCostBillPOS.get(0).getInit_time());
} 

/** 
* 
* Method: rangeSearchCashCostBill(String field, Object max, Object min) 
* 
*/ 
@Test
public void testRangeSearchCashCostBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getCashCostBillID() 
* 
*/ 
@Test
public void testGetCashCostBillID() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addFinanceBill(FinanceBillPO po) 
* 
*/ 
@Test
public void testAddFinanceBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateFinanceBill(FinanceBillPO po) 
* 
*/ 
@Test
public void testUpdateFinanceBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteFinanceBill(String id) 
* 
*/ 
@Test
public void testDeleteFinanceBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: fullSearchFinanceBill(String field, Object val) 
* 
*/ 
@Test
public void testFullSearchFinanceBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: multiSearchFinanceBill(ArrayList<CriteriaClause> criteriaClauses) 
* 
*/ 
@Test
public void testMultiSearchFinanceBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: rangeSearchFinanceBill(String field, Object max, Object min) 
* 
*/ 
@Test
public void testRangeSearchFinanceBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getFinanceBillID(FinanceBillType type) 
* 
*/ 
@Test
public void testGetFinanceBillID() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addSalesInBill(SalesInBillPO salesInBillPO) 
* 
*/ 
@Test
public void testAddSalesInBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateSalesInBill(SalesInBillPO salesInBillPO) 
* 
*/ 
@Test
public void testUpdateSalesInBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteSalesInBill(String id) 
* 
*/ 
@Test
public void testDeleteSalesInBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: fullSearchSalesInBill(String field, Object val) 
* 
*/ 
@Test
public void testFullSearchSalesInBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: mutilSearchSalesInBill(ArrayList<CriteriaClause> criteriaClauses) 
* 
*/ 
@Test
public void testMutilSearchSalesInBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: rangeSearchSalesInBill(String field, Object max, Object min) 
* 
*/ 
@Test
public void testRangeSearchSalesInBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getSalesInBillID(SalesInBillType type) 
* 
*/ 
@Test
public void testGetSalesInBillID() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addSalesOutBill(SalesOutBillPO salesOutBillPO) 
* 
*/ 
@Test
public void testAddSalesOutBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateSalesOutBill(SalesOutBillPO salesOutBillPO) 
* 
*/ 
@Test
public void testUpdateSalesOutBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteSalesOutBill(String id) 
* 
*/ 
@Test
public void testDeleteSalesOutBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: fullSearchSalesOutBill(String field, Object val) 
* 
*/ 
@Test
public void testFullSearchSalesOutBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: mutilSearchSalesOutBill(ArrayList<CriteriaClause> criteriaClauses) 
* 
*/ 
@Test
public void testMutilSearchSalesOutBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: rangeSearchSalesOutBill(String field, Object max, Object min) 
* 
*/ 
@Test
public void testRangeSearchSalesOutBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getSalesOutBillID(SalesOutBillType type) 
* 
*/ 
@Test
public void testGetSalesOutBillID() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addAlarmBill(AlarmBillPO po) 
* 
*/ 
@Test
public void testAddAlarmBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: prefixSearchAlarmBill(String field, String val) 
* 
*/ 
@Test
public void testPrefixSearchAlarmBill() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getAlarmID() 
* 
*/ 
@Test
public void testGetAlarmID() throws Exception { 
//TODO: Test goes here... 
} 


} 
