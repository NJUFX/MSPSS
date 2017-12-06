//package blstubdriver.billstubdriver;
//
//import blservice.billblservice.BillBLInfo;
//import blservice.billblservice.BillBLService;
//import com.sun.org.apache.regexp.internal.RE;
//import org.junit.Test;
//import util.ResultMessage;
//import vo.AlarmBillVO;
//import vo.LessOrMoreBillVO;
//import vo.PresentationBillVO;
//import vo.SalesVO;
//
///**
// * Project_Name ERPnju
// * Author: HanXinHu
// * Description:
// * Created on 17:18 2017/11/11/011
// */
//public class BillBL_Driver {
//    private static final BillBLService billService = new BillBL_Stub();
//    private static final BillBLInfo billInfo = new BillBL_Stub();
//    private static final PresentationBillVO pbVO = new PresentationBillVO();
//    private static final LessOrMoreBillVO lomVO = new LessOrMoreBillVO();
//    @Test
//    public void drive(){
//        ResultMessage testMessage;
//
//        //1
//        testMessage = billInfo.makeAlarmBill(null);
//        if (testMessage== ResultMessage.SUCCESS)
//            System.out.println("make success !!!!!!");
//        else
//            System.out.println("make failed");
//        //2
//        testMessage = billService.makeCashBill(null);
//        if (testMessage== ResultMessage.SUCCESS)
//            System.out.println("make success !!!!!!");
//        else
//            System.out.println("make failed");
//        //3
//        testMessage = billService.makeLessOrMoreBill(null);
//        if (testMessage== ResultMessage.SUCCESS)
//            System.out.println("make success !!!!!!");
//        else
//            System.out.println("make failed");
//        //4
//        testMessage = billService.makePaymentAndReceiptBill(null);
//        if (testMessage== ResultMessage.SUCCESS)
//            System.out.println("make success !!!!!!");
//        else
//            System.out.println("make failed");
//        //5
//        testMessage = billService.makePresentationBill(null);
//        if (testMessage== ResultMessage.SUCCESS)
//            System.out.println("make success !!!!!!");
//        else
//            System.out.println("make failed");
//        //6
//
//        testMessage = billService.makePurchaseBill(null);
//        if (testMessage== ResultMessage.SUCCESS)
//            System.out.println("make success !!!!!!");
//        else
//            System.out.println("make failed");
//        //7
//        testMessage = billService.makePurchaseReturnBill(null);
//        if (testMessage== ResultMessage.SUCCESS)
//            System.out.println("make success !!!!!!");
//        else
//            System.out.println("make failed");
//        //8
//        testMessage = billService.makeSalesBill(null);
//        if (testMessage== ResultMessage.SUCCESS)
//            System.out.println("make success !!!!!!");
//        else
//            System.out.println("make failed");
//        //9
//        testMessage = billService.makeSalesReturnBill(null);
//        if (testMessage== ResultMessage.SUCCESS)
//            System.out.println("make success !!!!!!");
//        else
//            System.out.println("make failed");
//
//    }
//
//}
