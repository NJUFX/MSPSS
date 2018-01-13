package user;

import blimpl.userblimpl.MockUser;
import blimpl.userblimpl.User;
import org.junit.Test;
import status.Log_In_Out_Status;
import util.Kind_Of_Users;
import vo.UserVO;

import static org.junit.Assert.assertEquals;

public class UserLogMockTest {
    User ul = new MockUser();
    UserVO user = new UserVO("SS001", "Chen", Kind_Of_Users.StockSeller, "000000", "0000");

    @Test
    public void testLogin() {
        Log_In_Out_Status il = ul.login(user.getID(), "000000");
        assertEquals(Log_In_Out_Status.Login_Success, il);
    }

    @Test
    public void testLogout() {
        Log_In_Out_Status il = ul.logout(user.getID());
        assertEquals(Log_In_Out_Status.Logout_Sucess, il);
    }
}
