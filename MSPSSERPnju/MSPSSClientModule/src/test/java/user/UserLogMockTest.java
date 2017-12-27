//package user;
//
//import blimpl.userblimpl.UserLog;
//import org.junit.*;
//import status.Log_In_Out_Status;
//import util.Kind_Of_Users;
//import util.ResultMessage;
//import vo.UserVO;
//
//import static org.junit.Assert.assertEquals;
//
//public class UserLogMockTest {
//    UserLog ul = new UserLog();
//    UserVO user = new UserVO("SS001", "Chen", Kind_Of_Users.StockSeller, "000000", "0000");
//
//    @Test
//    public void testLogin() {
//        Log_In_Out_Status il = ul.login(user.getID(), "000000");
//        assertEquals(Log_In_Out_Status.Login_Sucess, il);
//    }
//
//    @Test
//    public void testLogout() {
//        Log_In_Out_Status il = ul.logout(user.getID());
//        assertEquals(Log_In_Out_Status.Logout_Sucess, il);
//    }
//}
