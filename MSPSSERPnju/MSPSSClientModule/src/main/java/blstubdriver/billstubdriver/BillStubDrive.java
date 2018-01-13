package blstubdriver.billstubdriver;

import blservice.billblservice.FinanceBillBLService;
import blservice.billblservice.ManagerBillBLService;
import blservice.billblservice.SalesmanBillBLService;
import blservice.billblservice.StockManagerBillBLService;
import org.junit.Test;
import util.ResultMessage;
import vo.FinanceBillVO;

import static org.junit.Assert.assertEquals;

/**
 * Description:
 * Created by Hanxinhu at 8:33 2017/12/13/013
 */
public class BillStubDrive {
    FinanceBillBLService financeBillBLService = new FinanceBillStub();
    ManagerBillBLService managerBillBLService = new ManagerBLServiceStub();
    SalesmanBillBLService salesmanBillBLService = new SalesmanStub();
    StockManagerBillBLService stockManagerBillBLService = new StockManagerStub();

    @Test
    public void drive() {
        try {
            ResultMessage message = financeBillBLService.saveFinanceBill(new FinanceBillVO());
            assertEquals(ResultMessage.SUCCESS, message);

            message = financeBillBLService.commitFinanceBill(new FinanceBillVO());
            assertEquals(ResultMessage.SUCCESS, message);


            message = financeBillBLService.commitFinanceBill(new FinanceBillVO());
            assertEquals(ResultMessage.SUCCESS, message);

            message = financeBillBLService.commitFinanceBill(new FinanceBillVO());
            assertEquals(ResultMessage.SUCCESS, message);

            message = financeBillBLService.commitFinanceBill(new FinanceBillVO());
            assertEquals(ResultMessage.SUCCESS, message);

            message = financeBillBLService.commitFinanceBill(new FinanceBillVO());
            assertEquals(ResultMessage.SUCCESS, message);

            message = financeBillBLService.commitFinanceBill(new FinanceBillVO());
            assertEquals(ResultMessage.SUCCESS, message);


            message = financeBillBLService.commitFinanceBill(new FinanceBillVO());
            assertEquals(ResultMessage.SUCCESS, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
