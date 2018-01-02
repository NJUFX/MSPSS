package dataimpl.customerdataimpl;

import dataservice.CustomerDataService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import po.CustomerPO;

/** 
* CustomerDataServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>һ�� 1, 2018</pre> 
* @version 1.0 
*/ 
public class CustomerDataServiceImplTest { 
private CustomerDataService customerDataService;
@Before
public void before() throws Exception {
    customerDataService = CustomerDataServiceFactory.getCustomerDataService();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: addCustomer(CustomerPO po) 
* 
*/ 
@Test
public void testAddCustomer() throws Exception { 
//TODO: Test goes here...

    //customerDataService.addCustomer(customerPO);
}

/** 
* 
* Method: updateCustomer(CustomerPO po) 
* 
*/ 
@Test
public void testUpdateCustomer() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteCustomer(String id) 
* 
*/ 
@Test
public void testDeleteCustomer() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: fullSearchCustomer(String field, Object value) 
* 
*/ 
@Test
public void testFullSearchCustomer() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: fuzzSearchCustomer(String field, String value) 
* 
*/ 
@Test
public void testFuzzSearchCustomer() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: rangeSearchCustomer(String field, Object min, Object max) 
* 
*/ 
@Test
public void testRangeSearchCustomer() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: searchCustomerByID(String ID) 
* 
*/ 
@Test
public void testSearchCustomerByID() throws Exception { 
//TODO: Test goes here... 
} 


} 
