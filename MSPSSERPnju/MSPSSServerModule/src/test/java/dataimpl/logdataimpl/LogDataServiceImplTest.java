package dataimpl.logdataimpl;

import dataservice.LogDataService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import po.LogPO;
import util.Time;

/** 
* LogDataServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>һ�� 1, 2018</pre> 
* @version 1.0 
*/ 
public class LogDataServiceImplTest { 
LogDataService logDataService;
@Before
public void before() throws Exception {
    logDataService = LogDataServiceFactory.getLogDataService();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: addLog(LogPO logPO) 
* 
*/ 
@Test
public void testAddLog() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: rangeSearch(String field, Object min, Object max) 
* 
*/ 
@Test
public void testRangeSearch() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: fullSearch(String field, Object value) 
* 
*/ 
@Test
public void testFullSearch() throws Exception { 
//TODO: Test goes here...
    Time time = new Time(2017,1,1,1,1,1);
    LogPO logPO = new LogPO("徐光耀",time.toString(),"添加账户");
    logDataService.addLog(logPO);
} 

/** 
* 
* Method: multiSearchLog(ArrayList<CriteriaClause> criteriaClauses) 
* 
*/ 
@Test
public void testMultiSearchLog() throws Exception { 
//TODO: Test goes here... 
} 


} 
