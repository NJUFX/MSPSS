package bill;

import network.BillClientNetworkImpl;
import network.BillClientNetworkService;
import org.junit.Test;
import po.FinanceBillPO;
import util.FinanceBillType;
import util.ResultMessage;

import static org.junit.Assert.assertNotNull;

public class BillTest {
 BillClientNetworkService billClientNetworkService = new BillClientNetworkImpl();
 @Test
  public void test1(){String ID = billClientNetworkService.getFinanceBillID(FinanceBillType.IN);
     System.out.println(ID);
  assertNotNull(ID);
 }
 @Test
 public void test2(){
  FinanceBillPO po = new FinanceBillPO();
  po.setID("String ");
ResultMessage message = billClientNetworkService.addFinanceBill(po);
 assertNotNull(message);
 }

}
