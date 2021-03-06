package bill;

import blimpl.billblimpl.MockSalesOutBill;
import blimpl.billblimpl.SalesOutBill;
import org.junit.Assert;
import org.junit.Test;
import util.ResultMessage;
import vo.SalesOutBillVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 9:33 2017/11/22/022
 */
public class SalesOutBillMockTest {
    private SalesOutBill salesOutBill = new MockSalesOutBill();
    private SalesOutBillVO salesOutBillVO = new SalesOutBillVO();

    @Test
    public void a_add() {
        ResultMessage message = salesOutBill.saveSalesOutBill(salesOutBillVO);
        Assert.assertEquals(message, ResultMessage.SUCCESS);
    }

    @Test
    public void b_update() {
        ResultMessage message = salesOutBill.commitSalesOutBill(salesOutBillVO);
        Assert.assertEquals(message, ResultMessage.SUCCESS);
    }

    @Test
    public void c_search() {
        ArrayList arrayList = salesOutBill.getMySalesOutBill(null);
        Assert.assertNotNull(arrayList);
    }

}
