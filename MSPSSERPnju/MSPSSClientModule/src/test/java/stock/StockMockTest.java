//package stock;
//
//import blimpl.stockblimpl.MockStock;
//import blimpl.stockblimpl.Stock;
//import org.junit.Assert;
//import org.junit.Test;
//import util.ResultMessage;
//import vo.StockVO;
//
//import java.util.ArrayList;
//
///**
// * Description:
// * Created by Hanxinhu at 10:05 2017/11/22/022
// */
//public class StockMockTest {
//    private Stock stock = new MockStock();
//    private StockVO stockVO = new StockVO(null,1,1);
//
//    @Test
//    public void a_add(){
//        ResultMessage message = stock.addStock(null);
//        Assert.assertEquals(ResultMessage.SUCCESS,message);
//    }
//    @Test
//    public void b_update(){
//        ArrayList arrayList = stock.viewStock(null,null);
//        Assert.assertNotNull(arrayList);
//    }
//}
