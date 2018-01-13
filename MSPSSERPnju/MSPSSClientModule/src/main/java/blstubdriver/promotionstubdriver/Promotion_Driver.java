package blstubdriver.promotionstubdriver;

import org.junit.Test;
import util.ResultMessage;
import vo.CustomerPromotionVO;

import java.util.ArrayList;

public class Promotion_Driver {

    //constant

    Promotion_Stub promotion_stub = new Promotion_Stub();

    @Test
    public void drive() {
        //1
        ResultMessage TestResult1 = promotion_stub.addCustomerPromotion(null);
        if (TestResult1 == ResultMessage.SUCCESS) {
            System.out.println("Add Promotion Succeed!");
        } else {
            System.out.println("Add Promotion Failed!");
        }

        //2
        ResultMessage TestResult2 = promotion_stub.deleteCustomerPromotion(null);
        if (TestResult2 == ResultMessage.SUCCESS) {
            System.out.println("Delete Promoiton Succeed!");
        } else {
            System.out.println("Delete Promoiton Failed!");
        }

        //3
        ResultMessage TestResult3 = promotion_stub.updateCustomerPromotion(null);
        if (TestResult3 == ResultMessage.SUCCESS) {
            System.out.println("Update Promoiton Succeed!");
        } else {
            System.out.println("Update Promoiton Failed!");
        }

        //4
        ArrayList<CustomerPromotionVO> TestResult4 = promotion_stub.getAllCustomerPromotion();
        if (TestResult4.get(0) != null) {
            System.out.println("Search Promotion Succeed!");
        } else {
            System.out.println("Search Promotion Failed!");
        }

        //5
        ResultMessage resultMessage = promotion_stub.updateCustomerPromotion(null);
        if (resultMessage == ResultMessage.SUCCESS) {
            System.out.println("Show PromotionList Succeed!");
        } else {
            System.out.println("Show PromotionList Succeed!");
        }

        //6
        ResultMessage message = promotion_stub.addCustomerPromotion(null);
        if (message == ResultMessage.SUCCESS) {
            System.out.println("Show PromotionDetail Succeed!");
        } else {
            System.out.println("Show PromotionDetail Failed!");
        }

    }
}




