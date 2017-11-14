package datastubdriver.userdataservice;

import org.junit.Test;
import util.Kind_Of_Power;
import util.Kind_Of_Users;
import util.ResultMessage;
import po.*;

public class UserDataService_Driver {
    UserDataService_Stub userBLService_stub = new UserDataService_Stub();

    @Test
    public void dirve() {

        //test addUser
        UserPO user = new UserPO("SS001", "Chen", Kind_Of_Users.StockSeller, "000000", "0000");
        UserPO user2 = new UserPO("CM001", "July", Kind_Of_Users.ChiefManager, "000000", "0000");

        ResultMessage isAdd = userBLService_stub.addUser(user);
        userBLService_stub.addUser(user2);
        if (isAdd == ResultMessage.SUCCESS) {
            System.out.println("Add user successfully.");
        } else {
            System.out.println("Fail to add user.");
        }

        ResultMessage isSucess = userBLService_stub.modifyPower(user, "1000");
        if (isSucess == ResultMessage.SUCCESS) {
            System.out.println("Modify power successfully.");
        } else {
            System.out.println("Fail to modify power.");
        }

        //test modifyUser
        user.setPassword("010101");
        ResultMessage isMod = userBLService_stub.modifyUser(user);
        if (isMod == ResultMessage.SUCCESS) {
            System.out.println("Modify user successfully.");
        } else {
            System.out.println("Fail to modify");
        }

        //test delUser
        ResultMessage isDel = userBLService_stub.delUser("SS001");
        if (isDel == ResultMessage.SUCCESS) {
            System.out.println("Delete user successfully.");
        } else {
            System.out.println("Fail to delete user.");
        }
    }
}
