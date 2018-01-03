package dataimpl.generalaccountdataimpl;

import dataservice.GeneralAccountDataService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import po.GeneralAccountPO;
import po.GeneralAccount_AccountList_PO;
import po.GeneralAccount_CommodityList_PO;
import po.GeneralAccount_CustomerList_PO;
import util.Time;

import java.util.ArrayList;

/** 
* GeneralAccountDataServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>һ�� 1, 2018</pre> 
* @version 1.0 
*/ 
public class GeneralAccountDataServiceImplTest { 
GeneralAccountDataService generalAccountDataService;
@Before
public void before() throws Exception {
    generalAccountDataService = GeneralAccountDataServiceFactory.getGeneralAccountDataService();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: newGeneralAccount(GeneralAccountPO generalaccount) 
* 
*/ 
@Test
public void testNewGeneralAccount() throws Exception { 
//TODO: Test goes here...
    GeneralAccountPO generalAccountPO = new GeneralAccountPO();
    ArrayList<GeneralAccount_CommodityList_PO> generalAccount_commodityList_pos = new ArrayList<GeneralAccount_CommodityList_PO>();
    GeneralAccount_CommodityList_PO generalAccount_commodityList_po = new GeneralAccount_CommodityList_PO("水晶吊灯","123456","吊灯类","123456",12.45,45.58,23);
    generalAccount_commodityList_pos.add(generalAccount_commodityList_po);

    ArrayList<GeneralAccount_AccountList_PO> generalAccount_accountList_pos = new ArrayList<GeneralAccount_AccountList_PO>();
    GeneralAccount_AccountList_PO generalAccount_accountList_po = new GeneralAccount_AccountList_PO("南京绿光灯泡厂",520.1314);
    generalAccount_accountList_pos.add(generalAccount_accountList_po);


    ArrayList<GeneralAccount_CustomerList_PO> generalAccount_customerList_pos = new ArrayList<GeneralAccount_CustomerList_PO>();
    GeneralAccount_CustomerList_PO generalAccount_customerList_po = new GeneralAccount_CustomerList_PO(true,0,1,1,"隔壁王老板","18851826216","南京大学仙林校区","12312","123456@qq.com",123456.12,123.0,45.0);
    generalAccount_customerList_pos.add(generalAccount_customerList_po);


    Time time = new Time(2017,1,1,1,1,1);

    generalAccountPO.setTime(time.toString());
    generalAccountPO.setName("2017第一季度总账");
    generalAccountPO.setAccountlist(generalAccount_accountList_pos);
    generalAccountPO.setCommoditylist(generalAccount_commodityList_pos);
    generalAccountPO.setCustomerlist(generalAccount_customerList_pos);

    generalAccountDataService.newGeneralAccount(generalAccountPO);

} 

/** 
* 
* Method: checkGeneralAccount(String field, Object min, Object max) 
* 
*/ 
@Test
public void testCheckGeneralAccount() throws Exception { 
//TODO: Test goes here...
    ArrayList<GeneralAccountPO> generalAccountPO = generalAccountDataService.checkGeneralAccount("time",Time.MIN_TIME,Time.MAX_TIME);

    System.out.println(generalAccountPO.get(0).getAccountlist().get(0).getName());

}

/** 
* 
* Method: exactlySearchGeneralAccount(String field, Object value) 
* 
*/ 
@Test
public void testExactlySearchGeneralAccount() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: fullSearchGeneralAccount(String field, Object value) 
* 
*/ 
@Test
public void testFullSearchGeneralAccount() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: fuzzySearchGeneralAccount(String field, String value) 
* 
*/ 
@Test
public void testFuzzySearchGeneralAccount() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: rangeSearchGeneralAccount(String field, Object min, Object max) 
* 
*/ 
@Test
public void testRangeSearchGeneralAccount() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: searchCustomer(String name) 
* 
*/ 
@Test
public void testSearchCustomer() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: searchCommodity(String name) 
* 
*/ 
@Test
public void testSearchCommodity() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: changeToAccountPO(GeneralAccount_AccountList_PO account, String time) 
* 
*/ 
@Test
public void testChangeToAccountPO() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = GeneralAccountDataServiceImpl.getClass().getMethod("changeToAccountPO", GeneralAccount_AccountList_PO.class, String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: changeToCommodity(GeneralAccount_CommodityList_PO commodity) 
* 
*/ 
@Test
public void testChangeToCommodity() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = GeneralAccountDataServiceImpl.getClass().getMethod("changeToCommodity", GeneralAccount_CommodityList_PO.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: changeToCustomer(GeneralAccount_CustomerList_PO customer) 
* 
*/ 
@Test
public void testChangeToCustomer() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = GeneralAccountDataServiceImpl.getClass().getMethod("changeToCustomer", GeneralAccount_CustomerList_PO.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
