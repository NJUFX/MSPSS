package blstubdriver.adminstubdriver;
import po.PowerPO;
import po.UserPO;
import util.*;
/**
 * Created by thinkpad on 2017/10/23.
 */
public class Admin_Driver {
    Admin_Stub admin = new Admin_Stub();
    ResultMessage result;

    public void drive() {

        result = admin.addUser(new UserPO("161250164","王二",true,true,true,true));
        if(result==ResultMessage.SUCCESS){
            System.out.println("Add user successfully!");
        }
        else{
            System.out.println("Fail to add user ");
        }

        result = admin.deleteUser("161250164");
        if(result==ResultMessage.SUCCESS){
            System.out.println("Delete user successfully!");
        }
        else{
            System.out.println("Fail to delete user ");
        }

        result = admin.givePower(new PowerPO());
        if(result==ResultMessage.SUCCESS){
            System.out.println("Give power successfully!");
        }
        else{
            System.out.println("Fail to give power ");
        }

    }
}
