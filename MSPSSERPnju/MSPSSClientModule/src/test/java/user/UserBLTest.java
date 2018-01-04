package user;

import blimpl.userblimpl.User;
import org.junit.Test;
import po.UserPO;
import status.Log_In_Out_Status;
import util.Kind_Of_Users;
import util.ResultMessage;
import vo.UserVO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Description:
 * Created by Hanxinhu at 23:52 2018/1/2/002
 */
public class UserBLTest {
    private static User user = new User();

    @Test
    public void test1() {
        UserVO userVO = new UserVO("hxh", "韩新虎", Kind_Of_Users.StockManager, "123456", "hanxinhu521@163.com");
        ResultMessage message = user.addUser(userVO);
        assertEquals(ResultMessage.EXIST, message);
    }

    @Test
    public void test2() {
        UserVO userVO1 = new UserVO("hxh2", "韩新虎", Kind_Of_Users.StockManager, "123456", "hanxinhu521@163.com");
        UserVO userVO2 = new UserVO("hxh2", "韩新虎", Kind_Of_Users.StockManager, "123458", "hanxinhu521@163.com");
        user.addUser(userVO1);
        user.updateUser(userVO2);
        UserVO userVO3 = user.searchUserByID(userVO1.getID());
        assertEquals(userVO2.getPassword(), userVO3.getPassword());
    }

    @Test
    public void test3() {
        Log_In_Out_Status log_in_out_status = user.login("hxh", "123456");
        assertEquals(Log_In_Out_Status.Login_Success_StockManager, log_in_out_status);
        user.logout("hxh");
        assertEquals(null, user.getCurrentUser());
    }

    @Test
    public void test4() {
        UserVO userVO2 = new UserVO("hxh3", "韩新虎", Kind_Of_Users.StockManager, "123458", "hanxinhu521@163.com");
        user.addUser(userVO2);
        ResultMessage message = user.deleteUser(userVO2.getID());
        assertEquals(ResultMessage.SUCCESS, message);
    }

     @Test
    public  void test5(){
       UserVO vo = user.searchUserByID("FM001");
    assertNotNull(vo);
    }
}
