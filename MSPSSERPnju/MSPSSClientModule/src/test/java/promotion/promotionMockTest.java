//package promotion;
//
//import blimpl.promotionblimpl.MockPromotion;
//import blimpl.promotionblimpl.Promotion;
//import org.junit.Test;
//import po.PromotionPO;
//import util.ResultMessage;
//import util.Time;
//import vo.PromotionVO;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
///**
// * Created by Harper on 17/11/23
// */
//public class promotionMockTest {
//    Promotion promotion = new MockPromotion();
//    String[] VOInfo = {};
//    PromotionVO testPromotionVO = new PromotionVO("000001","分级赠送赠品",VOInfo,new Time(2017,11,23,22,51,22));
//
//    @Test
//    public void teatAddPromotion(){
//        assertEquals(promotion.add(testPromotionVO), ResultMessage.SUCCESS);
//    }
//
//    @Test
//    public void testDeletePromotion(){
//        assertEquals(promotion.delete("000001"),ResultMessage.SUCCESS);
//    }
//
//    @Test
//    public void testUpdatePromotion(){
//        promotion.add(testPromotionVO);
//        assertEquals(promotion.update("000001",testPromotionVO),ResultMessage.SUCCESS);
//    }
//
//    @Test
//    public void testSearchPromotion(){
//        assertNotNull(promotion.search(new Time(2017,11,23,22,51,22)));
//    }
//
//    @Test
//    public void testShowPromotionList(){
//        ArrayList<PromotionPO> testList = new ArrayList<PromotionPO>();
//        PromotionPO testPromotionPO = new PromotionPO("000001","分级赠送赠品",VOInfo,new Time(2017,11,23,22,51,22));
//        testList.add(testPromotionPO);
//        assertNotNull(promotion.showPromotionList(testList));
//    }
//
//    @Test
//    public void testShowPromotionDetail(){
//        assertNotNull(promotion.showPromotionDetail("000001"));
//    }
//
//}
