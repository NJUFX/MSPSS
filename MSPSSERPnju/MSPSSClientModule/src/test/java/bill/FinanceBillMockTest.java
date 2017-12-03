//package bill;
//
//import blimpl.billblimpl.FinanceBill;
//import blimpl.billblimpl.MockFinanceBill;
//import org.junit.Test;
//import util.ResultMessage;
//import vo.FinanceBillVO;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
///**
// * Description:
// * Created by Hanxinhu at 9:24 2017/11/22/022
// */
//public class FinanceBillMockTest {
//    private FinanceBill financeBill = new MockFinanceBill();
//    private FinanceBillVO financeBillVO = new FinanceBillVO();
//    @Test
//    public void  a_add(){
//        ResultMessage resultMessage = financeBill.addFinanceBill(financeBillVO);
//        assertEquals(resultMessage,ResultMessage.SUCCESS);
//    }
//    @Test
//    public void b_update(){
//        ResultMessage resultMessage = financeBill.updateFinanceBill(financeBillVO);
//        assertEquals(resultMessage,ResultMessage.SUCCESS);
//    }
//    @Test
//    public void c_search(){
//        ArrayList arrayList = financeBill.searchFinanceBill(null);
//        assertNotNull(arrayList);
//    }
//}
