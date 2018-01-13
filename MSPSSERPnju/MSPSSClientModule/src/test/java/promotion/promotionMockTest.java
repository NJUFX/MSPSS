package promotion;

import blimpl.promotionblimpl.*;
import org.junit.Test;
import util.ResultMessage;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Harper on 17/11/23
 */
public class promotionMockTest {
    CustomerPromotion customerPromotion = new MockCustomerPromotion();
    GrossPromotion grossPromotion = new MockGrossPromotion();
    GroupPromotion groupPromotion = new MockGroupPromotion();

    @Test
    public void test1() {
        ResultMessage resultMessage = customerPromotion.addCustomerPromotion(null);
        assertEquals(ResultMessage.SUCCESS, resultMessage);
    }

    @Test
    public void test2() {
        ResultMessage resultMessage = customerPromotion.updateCustomerPromotion(null);
        assertEquals(ResultMessage.SUCCESS, resultMessage);
    }

    @Test
    public void test3() {
        ResultMessage resultMessage = customerPromotion.deleteCustomerPromotion(null);
        assertEquals(ResultMessage.SUCCESS, resultMessage);
    }

    @Test
    public void test4() {
        ArrayList list = customerPromotion.getAllCustomerPromotion();
        assertNotNull(list);
    }

    @Test
    public void test5() {
        ArrayList list = customerPromotion.getAvailableCustomerPromotion();
        assertNotNull(list);
    }


}
