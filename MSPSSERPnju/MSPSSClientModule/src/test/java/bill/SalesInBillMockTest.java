package bill;

import blimpl.billblimpl.MockSalesInBill;
import blimpl.billblimpl.SalesInBill;
import org.junit.Test;
import util.ResultMessage;
import vo.SalesInBillVO;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Description:
 * Created by Hanxinhu at 9:28 2017/11/22/022
 */
public class SalesInBillMockTest {
    private SalesInBill salesInBill = new MockSalesInBill();
    private SalesInBillVO salesInBillVO = new SalesInBillVO();

    @Test
    public void a_add() {
        ResultMessage message = salesInBill.saveSalesInBill(salesInBillVO);
        assertEquals(message, ResultMessage.SUCCESS);
    }

    @Test
    public void b_update() {
        ResultMessage message = salesInBill.commitSalesInBill(salesInBillVO);
        assertEquals(message, ResultMessage.SUCCESS);
    }

    @Test
    public void c_search() {
        ArrayList arrayList = salesInBill.getMySalesInBill(null);
        assertNotNull(arrayList);
    }

    @Test
    public void d_search() {
        ArrayList arrayList = salesInBill.getWaitingSalesInBill();
        assertNotNull(arrayList);
    }

}
