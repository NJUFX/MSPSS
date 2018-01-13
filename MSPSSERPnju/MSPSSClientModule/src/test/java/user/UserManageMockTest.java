package user;

import blimpl.userblimpl.User;
import org.junit.Test;
import util.Kind_Of_Users;
import util.ResultMessage;
import vo.UserVO;

import static junit.framework.TestCase.assertEquals;

public class UserManageMockTest {
    User ul = new User();
    UserVO user = new UserVO("SS001", "Chen", Kind_Of_Users.StockSeller, "000000");


    @Test
    public void testAddUser() {
        ResultMessage re = ul.addUser(user);
        assertEquals(ResultMessage.SUCCESS, re);
    }

    @Test
    public void testModifyUser() {
        user.setPassword("010101");
    ResultMessage re = ul.updateUser(user);
        assertEquals(ResultMessage.SUCCESS, re);
    }


    @Test
    public void testDelUser() {
    ResultMessage re = ul.deleteUser(user.getID());
        assertEquals(ResultMessage.SUCCESS, re);
    }

}
