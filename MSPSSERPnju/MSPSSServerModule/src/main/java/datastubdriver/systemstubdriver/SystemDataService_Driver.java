package datastubdriver.systemstubdriver;


import po.*;
import status.*;

public class SystemDataService_Driver {


    public void driver(){

        SystemDataService_Stub systemdataservice = new SystemDataService_Stub();

        Log_Status logs ;
        logs = systemdataservice.login("161250164","161250164");
        if(logs==Log_Status.SUCCESS){
            System.out.println("Log in Successfully!");
        }
        else{
            System.out.println("Fail to log in");
        }

        logs = systemdataservice.logout();
        if(logs==Log_Status.SUCCESS){
            System.out.println("Log out Successfully!");
        }
        else{
            System.out.println("Fail to log out");
        }

        boolean b;
         b = systemdataservice.initializeFinalAccount(new FinalAccountPO());
        if(b==true){
            System.out.println("initialize Successfully!");
        }
        else{
            System.out.println("Fail to initialize");
        }

        FinalAccountPO account;
        account = systemdataservice.checkFinalAccount("2017总帐");
        if(account!=null){
            System.out.println("Check account Successfully!");
        }
        else{
            System.out.println("Fail to check account");
        }

        User_Oper_Status uos;
        uos = systemdataservice.addUser(new UserPO());
        if(uos==User_Oper_Status.SUCCESS){
            System.out.println("Add user Successfully!");
        }
        else{
            System.out.println("Fail to add user");
        }


        uos = systemdataservice.deleteUser(new UserPO());
        if(uos==User_Oper_Status.SUCCESS){
            System.out.println("delete user Successfully!");
        }
        else{
            System.out.println("Fail to delete user");
        }

        uos = systemdataservice.adjustPower(new PowerPO(),new UserPO());
        if(uos==User_Oper_Status.SUCCESS){
            System.out.println("Adjust power Successfully!");
        }
        else{
            System.out.println("Fail to adjust power");
        }


    }
}
