package blstubdriver.promotionstubdriver;
/**
 * Created by Harper on 17/11/13
 */

import org.junit.Test;
import po.PromotionPO;
import util.ResultMessage;
import util.Time;
import vo.PromotionListVO;
import vo.PromotionVO;

import java.util.ArrayList;

public class Promotion_Driver {

    //constant
    String[] Test_String = new String[1];
    PromotionVO Test_PromotionVO = new PromotionVO("000001","分级赠送赠品", Test_String,new Time(2017,11,13,9,12,12));
    Promotion_Stub promotion_stub = new Promotion_Stub();
    @Test
    public void drive(){

        //1
        ResultMessage TestResult1 = promotion_stub.add(Test_PromotionVO);
        if(TestResult1==ResultMessage.SUCCESS){
            System.out.println("Add Promotion Succeed!");
        }
        else{
            System.out.println("Add Promotion Failed!");
        }

        //2
        ResultMessage TestResult2 = promotion_stub.delete("000001");
        if(TestResult2==ResultMessage.SUCCESS){
            System.out.println("Delete Promoiton Succeed!");
        }
        else{
            System.out.println("Delete Promoiton Failed!");
        }

        //3
        ResultMessage TestResult3 = promotion_stub.update("000001",Test_PromotionVO);
        if(TestResult3==ResultMessage.SUCCESS){
            System.out.println("Update Promoiton Succeed!");
        }
        else{
            System.out.println("Update Promoiton Failed!");
        }

        //4
        ArrayList<PromotionPO> TestResult4 = promotion_stub.search(new Time(2017,11,13,16,33,33));
        if(TestResult4.get(0).getId().equals("000001")){
            System.out.println("Search Promotion Succeed!");
        }
        else{
            System.out.println("Search Promotion Failed!");
        }

        //5
        ArrayList<PromotionPO> Test_PromotionPOList = new ArrayList<PromotionPO>();
        PromotionPO Test_PromotionPO = new PromotionPO("000001","分级赠送赠品",Test_String,new Time(2017,11,13,9,12,12));
        Test_PromotionPOList.add(Test_PromotionPO);
        PromotionListVO TestResult5 = promotion_stub.showPromotionList(Test_PromotionPOList);
        if(TestResult5.getCurrentPromotion().get(0).getId().equals("000001")){
            System.out.println("Show PromotionList Succeed!");
        }
        else{
            System.out.println("Show PromotionList Succeed!");
        }

        //6
        PromotionVO TestResult6 = promotion_stub.showPromotionDetail("000001");
        if(TestResult6.getId().equals("000001")){
            System.out.println("Show PromotionDetail Succeed!");
        }
        else{
            System.out.println("Show PromotionDetail Failed!");
        }

    }
}
