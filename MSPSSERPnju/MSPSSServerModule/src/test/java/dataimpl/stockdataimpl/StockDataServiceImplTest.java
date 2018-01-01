package dataimpl.stockdataimpl;

import dataservice.StockDataService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import po.StockPO;
import util.Time;

/** 
* StockDataServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>һ�� 1, 2018</pre> 
* @version 1.0 
*/ 
public class StockDataServiceImplTest { 
StockDataService stockDataService;
@Before
public void before() throws Exception {
    stockDataService = StockDataServiceFactory.getStockDataService();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: rangeSearchStock(String filed, Object min, Object max) 
* 
*/ 
@Test
public void testRangeSearchStock() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addStock(StockPO stockPO) 
* 
*/ 
@Test
public void testAddStock() throws Exception { 
//TODO: Test goes here...
    Time time = new Time(2017,1,1,1,1,1);
    StockPO stockPO = new StockPO(1,"123456",12,time.toString(),12.48);
    stockDataService.addStock(stockPO);

} 


} 
