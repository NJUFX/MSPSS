package dataimpl.userdataimpl;

import dataservice.UserDataService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import po.UserPO;

/** 
* UserDataServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>һ�� 1, 2018</pre> 
* @version 1.0 
*/ 
public class UserDataServiceImplTest {
    private UserDataService userDataService;

@Before
public void before() throws Exception {
    userDataService = UserDataServiceFactory.getUserDataService();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: modifyPower(UserPO user, String power) 
* 
*/ 
@Test
public void testModifyPower() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: addUser(UserPO user) 
* 
*/ 
@Test
public void testAddUser() throws Exception { 
//TODO: Test goes here...
    UserPO userPO = new UserPO("FM-161250164","徐光耀",4,"161250164","hanxinhu521@163.com");
    userDataService.addUser(userPO);

} 

/** 
* 
* Method: deleteUser(String userid) 
* 
*/ 
@Test
public void testDeleteUser() throws Exception { 
//TODO: Test goes here...
    userDataService.deleteUser("FM-161250164");
} 

/** 
* 
* Method: updateUser(UserPO user) 
* 
*/ 
@Test
public void testUpdateUser() throws Exception { 
//TODO: Test goes here...
    UserPO userPO = new UserPO();
    userPO = userDataService.exactlySearchUser("name","徐光耀");

    userPO.setName("徐大光");
    userDataService.updateUser(userPO);
} 

/** 
* 
* Method: searchUserByID(String ID) 
* 
*/ 
@Test
public void testSearchUserByID() throws Exception { 
//TODO: Test goes here...
    UserPO userPO = userDataService.searchUserByID("FM-161250164");
    System.out.println(userPO.getID());
} 

/** 
* 
* Method: fullSearchUser(String filed, Object val) 
* 
*/ 
@Test
public void testFullSearchUser() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: exactlySearchUser(String field, Object val) 
* 
*/ 
@Test
public void testExactlySearchUser() throws Exception { 
//TODO: Test goes here... 
} 


} 
