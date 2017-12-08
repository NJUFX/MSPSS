package datastubdriver.logdatastubdriver;


import org.junit.Test;
import po.LogPO;
import util.ResultMessage;
import util.Time;

import java.util.ArrayList;

/**
 * Created by Harper on 17/11/13
 */

public class LogData_Driver {

  //Constant
    LogData_Stub logData_stub = new LogData_Stub();
    LogPO Test_LogPO = new LogPO();
    @Test
    public void drive(){

        //1
        ResultMessage TestResult1 = logData_stub.add(Test_LogPO);
        if(TestResult1==ResultMessage.SUCCESS){
            System.out.println("Add Log Succeed!");
        }
        else{
            System.out.println("Add Log Failed!");
        }

        //2
        ArrayList<LogPO> TestResult2 = logData_stub.search(new Time(2017,11,13,21,34,34));
        if(TestResult2.get(0).getId().equals("000001")){
            System.out.println("Search Log Succeed!");
        }
        else{
            System.out.println("Search Log Failed!");
        }
    }


}
