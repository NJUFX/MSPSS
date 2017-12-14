//package datastubdriver.billdatastubdriver;
//
//import dataservice.BillDataService;
//import filterflags.BillFilter;
//import org.junit.Test;
//import po.BillPO;
//import util.ResultMessage;
//
//import java.util.Iterator;
//
///**
// * Project_Name ERPnju
// * Author: HanXinHu
// * Description:
// * Created on 22:32 2017/11/12/012
// */
//public class BillDataService_Driver {
//    private static final String id = "12318";
//    private static final BillPO billpo = new BillPO("");
//    private static final BillFilter filter = new BillFilter();
//    private static final BillDataService service = new BillDataService_Stub();
//
//    @Test
//    public void drive(){
//        ResultMessage testMessage;
//        //1
//        testMessage = service.addBill(billpo);
//        if (testMessage==ResultMessage.SUCCESS)
//            System.out.println("add bill succeed");
//        else
//            System.out.println("add bill fail");
//        //2
//
//        testMessage = service.deleteBill(id);
//        if (testMessage==ResultMessage.SUCCESS)
//            System.out.println("delete bill succeed");
//        else
//            System.out.println("delete bill fail");
//        //3
//        testMessage = service.deleteBill("000000");
//        if (testMessage == ResultMessage.SUCCESS)
//            System.out.println("delete bill succeed");
//        else
//            System.out.println("delete bill fail");
//
//        //4
//        testMessage = service.updateBill(billpo);
//        if (testMessage==ResultMessage.SUCCESS)
//            System.out.println("update bill succeed");
//        else
//            System.out.println("update bill failed");
//        //5
//        Iterator<BillPO> bill = service.searchBill(filter);
//        if (bill!=null)
//            System.out.println("search bill succeed");
//        else
//            System.out.println("search bill failed");
//
//    }
//
//}
