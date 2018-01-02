/*
package datastubdriver.promotionstubdriver;

import org.junit.Test;
import po.PromotionPO;
import util.ResultMessage;
import util.Time;

import java.util.ArrayList;

public class PromotionData_Driver {
    //constant

    PromotionData_Stub promotiondata_stub = new PromotionData_Stub();
    String[] Test_String = new String[1];
    PromotionPO Test_PromotionPO = new PromotionPO();

    @Test
    public void drive(){

        //1
        ResultMessage TestResult1 = promotiondata_stub.add(Test_PromotionPO);
        if(TestResult1==ResultMessage.SUCCESS){
            System.out.println("Add Promotion Succeed!");
        }
        else{
            System.out.println("Add Promotion Failed!");
        }

        //2
        ResultMessage TestResult2 = promotiondata_stub.delete("000001");
        if(TestResult2==ResultMessage.SUCCESS){
            System.out.println("Delete Promotion Succeed!");
        }
        else{
            System.out.println("Delete Promotion Failed!");
        }

        //3
        ResultMessage TestResult3 = promotiondata_stub.update(Test_PromotionPO,"000001");
        if(TestResult3==ResultMessage.SUCCESS){
            System.out.println("Update Promotion Succeed!");
        }
        else{
            System.out.println("Update Promotion Failed!");
        }

        //4
        ArrayList<PromotionPO> TestResult4 = promotiondata_stub.search(new Time(2017,11,13,23,33,22));
        if(true){
            System.out.println("Search Promotion Succeed!");
        }
        else{
            System.out.println("Search Promotion Failed!");
        }


    }
}
*/
