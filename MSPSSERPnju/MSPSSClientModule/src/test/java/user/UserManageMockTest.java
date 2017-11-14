package user;

import blimpl.userblimpl.UserLog;
import blimpl.userblimpl.UserManage;
import org.junit.Test;
import status.Log_In_Out_Status;
import util.Kind_Of_Users;
import util.ResultMessage;
import vo.UserVO;

import static org.junit.Assert.assertEquals;

public class UserManageMockTest {
    UserManage ul = new UserManage();
    UserVO user = new UserVO("SS001", "Chen", Kind_Of_Users.StockSeller, "000000", "0000");

    @Test
    public void testAddUser() {
        ResultMessage re = ul.addUser(user);
        assertEquals(ResultMessage.SUCCESS, re);
    }

    @Test
    public void testModifyUser() {
        user.setPassword("010101");
        ResultMessage re = ul.modifyUser(user);
        assertEquals(ResultMessage.SUCCESS, re);
    }

    @Test
    public void testModifyPower() {
        ResultMessage re = ul.modifyPower(user, "1000");
    }

    @Test
    public void testDelUser() {
        ResultMessage re = ul.delUser(user.getID());
        assertEquals(ResultMessage.SUCCESS, re);
    }

}
