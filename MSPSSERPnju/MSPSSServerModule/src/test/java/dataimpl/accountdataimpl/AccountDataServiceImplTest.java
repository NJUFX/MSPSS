package dataimpl.accountdataimpl;

import dataservice.AccountDataService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import po.AccountPO;
import util.ResultMessage;
import util.Time;

import java.util.ArrayList;

/** 
* AccountDataServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>һ�� 1, 2018</pre> 
* @version 1.0 
*/ 
public class AccountDataServiceImplTest { 
private AccountDataService accountDataService;
@Before
public void before() throws Exception {
    accountDataService=AccountDataServiceFactory.getAccountDataService();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: addAccount(AccountPO account) 
* 
*/ 
@Test
public void testAddAccount() throws Exception { 
//TODO: Test goes here...
    Time time = new Time(2018,1,1,1,1,1);
    AccountPO accountPO = new AccountPO("苏果总帐",1200,time.toString());
    AccountPO accountPO1 = new AccountPO("乐天马特总帐",100,time.toString());
    ResultMessage resultMessage = accountDataService.addAccount(accountPO);

} 

/** 
* 
* Method: deleteAccount(String name) 
* 
*/ 
@Test
public void testDeleteAccount() throws Exception { 
//TODO: Test goes here...

    //FixME  因为目前数据库数据还比较少，还没测试删除的功能


} 

/** 
* 
* Method: modifyAccount(String oldName, String newName) 
* 
*/ 
@Test
public void testModifyAccount() throws Exception { 
//TODO: Test goes here...
    //FixMe 调用update方法的时候，记得要new一个对象，不然不会成功执行
    ResultMessage resultMessage = accountDataService.modifyAccount("苏果总帐","苏果江苏地区第一季度南京市总账");
} 

/** 
* 
* Method: checkAccount(String name) 
* 
*/ 
@Test
public void testCheckAccount() throws Exception { 
//TODO: Test goes here...
    AccountPO accountPO = accountDataService.checkAccount("苏果江苏地区第一季度南京市总账");
} 

/** 
* 
* Method: income(String name, double money) 
* 
*/ 
@Test
public void testIncome() throws Exception { 
//TODO: Test goes here...
    accountDataService.pay("苏果江苏地区第一季度南京市总账",100);

} 

/** 
* 
* Method: pay(String name, double money) 
* 
*/ 
@Test
public void testPay() throws Exception { 
//TODO: Test goes here...
    accountDataService.income("苏果江苏地区第一季度南京市总账",200);
} 

/** 
* 
* Method: rangeSearchAccount(String field, Object min, Object max) 
* 
*/ 
@Test
public void testRangeSearchAccount() throws Exception { 
//TODO: Test goes here...
    ArrayList<AccountPO> accountPOS = accountDataService.rangeSearchAccount("createtime",Time.MIN_TIME,Time.MAX_TIME);

    for(int i=0;i<=accountPOS.size()-1;i++){
        System.out.println(accountPOS.get(i).getName());
    }

} 

/** 
* 
* Method: fullSearchAccount(String field, Object value) 
* 
*/ 
@Test
public void testFullSearchAccount() throws Exception { 
//TODO: Test goes here...
    Time time = new Time(2018,1,1,1,1,1);
    ArrayList<AccountPO> accountPOS = accountDataService.fullSearchAccount("createtime",time.toString());

    for(int i=0;i<=accountPOS.size()-1;i++){
        System.out.println(accountPOS.get(i).getName());
    }
} 

/** 
* 
* Method: fuzzSearchAccount(String field, Object value) 
* 
*/ 
@Test
public void testFuzzSearchAccount() throws Exception { 
//TODO: Test goes here...
    ArrayList<AccountPO> accountPOS = accountDataService.fuzzSearchAccount("name","总账");

    for(int i=0;i<=accountPOS.size()-1;i++){
        System.out.println(accountPOS.get(i).getName());
    }
} 

/** 
* 
* Method: searchAccountByName(String name) 
* 
*/ 
@Test
public void testSearchAccountByName() throws Exception { 
//TODO: Test goes here...
    AccountPO accountPO = accountDataService.searchAccountByName("乐天马特总帐");

} 

/** 
* 
* Method: multiSearchAccount(ArrayList<CriteriaClause> criteriaClauses) 
* 
*/ 
@Test
public void testMultiSearchAccount() throws Exception { 
//TODO: Test goes here...

} 


} 
