package blstubdriver.logstubdriver;

import org.junit.Test;
import po.LogPO;
import util.Time;
import vo.LogListVO;
import vo.LogVO;

import java.util.ArrayList;

/**
 * Created by Harper on 17/11/13
 */

public class Log_Driver {
    //Constant
    Log_Stub log_stub = new Log_Stub();

    @Test
    public void drive() {

        // 1
        ArrayList<LogPO> TestResult1 = log_stub.search(new Time(2017,11,13,21,12,12));
        if(TestResult1.get(0).getId().equals("000001")){
            System.out.println("Search Log Succeed!");
        }
        else{
            System.out.println("Search Log Failed!");
        }

        //2
        ArrayList<LogPO> Test_LogPOList = new ArrayList<LogPO>();
        LogPO Test_LogPO = new LogPO("000001","jiangchen","17/11/20","sell","Bulb",100,10000);
        Test_LogPOList.add(Test_LogPO);
        LogListVO TesultResult2 = log_stub.showLogList(Test_LogPOList);
        if(TesultResult2.getLogAmount()==1){
            System.out.println("Show Log List Succeed!");
        }
        else{
            System.out.println("Show Log List Failed!");
        }

        //3
        LogVO TestResult3 = log_stub.showLogDetail("000001");
        if(TestResult3.getOperator().equals("jiangchen")){
            System.out.println("Show Log Detail Succeed!");
        }
        else{
            System.out.println("Show Log Detail Failed!");
        }
    }
}
