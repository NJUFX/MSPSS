package promotion;

import blimpl.blfactory.BLFactoryImpl;
import blservice.promotionblservice.PromotionBLInfo;
import blservice.promotionblservice.PromotionBLService;
import org.junit.Test;
import util.ResultMessage;
import util.Time;
import vo.CustomerPromotionVO;
import vo.GrossPromotionVO;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Description:
 * Created by Hanxinhu at 15:21 2018/1/12/012
 */
public class PromotionBLTest {
    PromotionBLService promotionBLService = new BLFactoryImpl().getPromotionBLService();
    PromotionBLInfo promotionBLInfo = new BLFactoryImpl().getPromotionBLInfo();

    @Test
    public void test1() {
        CustomerPromotionVO customerPromotionVO = new CustomerPromotionVO();
        customerPromotionVO.setDiscount(1000);
        customerPromotionVO.setInitTime(new Time());
        customerPromotionVO.setEndTime(new Time());
        customerPromotionVO.setPresentationCommodityItemVOS(new ArrayList<>());
        ResultMessage message = promotionBLService.addCustomerPromotion(customerPromotionVO);
        assertEquals(ResultMessage.SUCCESS, message);
    }

    @Test
    public void test2() {
        GrossPromotionVO promotionVO = new GrossPromotionVO(1000, 1000, new ArrayList<>(), new Time(), new Time());
        ResultMessage message = promotionBLService.addGrossPromotion(promotionVO);
        assertEquals(ResultMessage.SUCCESS, message);
    }

}
