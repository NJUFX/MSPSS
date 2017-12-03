//package commodity;
//
//import blimpl.commodityblimpl.Commodity;
//import blimpl.commodityblimpl.MockCommodity;
//import org.junit.Test;
//import util.ResultMessage;
//import vo.CommodityVO;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
///**
// * Description:
// * Created by Hanxinhu at 9:39 2017/11/22/022
// */
//public class CommodityMockTest {
//    private Commodity commodity = new MockCommodity();
//    private CommodityVO commodityVO = new CommodityVO("","","",1,1);
//    @Test
//    public void a_add(){
//        ResultMessage message = commodity.addCommodity(commodityVO);
//        assertEquals(message,ResultMessage.SUCCESS);
//    }
//    @Test
//    public void b_update(){
//        ResultMessage message = commodity.updateCommodity(commodityVO);
//        assertEquals(message,ResultMessage.SUCCESS);
//    }
//    @Test
//    public void c_delete(){
//        ResultMessage message = commodity.deleteCommodity("");
//        assertEquals(ResultMessage.SUCCESS,message);
//    }
//    @Test
//    public void d_search(){
//        commodityVO = commodity.getCommodity("");
//        assertNotNull(commodityVO);
//    }
//
//}
