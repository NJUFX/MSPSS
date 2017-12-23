//package bill;
//
//import blimpl.billblimpl.MockStockBill;
//import blimpl.billblimpl.StockBill;
//import org.junit.Test;
//import util.ResultMessage;
//import vo.StockBillVO;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
///**
// * Description:
// * Created by Hanxinhu at 8:37 2017/11/22/022
// */
//public class StockBillMockTest {
//    private StockBill stockBill = new MockStockBill();
//    private StockBillVO stockBillVO = new StockBillVO();
//
//    @Test
//    public void a_addStockBill(){
//        ResultMessage resultMessage = stockBill.saveStockBill(stockBillVO);
//        assertEquals(resultMessage,ResultMessage.SUCCESS);
//    }
//    @Test
//    public void b_updateStockBill(){
//        ResultMessage resultMessage = stockBill.commitStockBill(stockBillVO);
//        assertEquals(resultMessage,ResultMessage.SUCCESS);
//    }
//    @Test
//    public void c_searchStockBill(){
//        ArrayList arrayList = stockBill.searchStockBill(null);
//        assertNotNull(arrayList);
//    }
//}
