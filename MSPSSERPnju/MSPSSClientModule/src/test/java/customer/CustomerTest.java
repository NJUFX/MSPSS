package customer;

import blimpl.blfactory.BLFactoryImpl;
import blservice.customerblservice.CustomerBLInfo;
import blservice.customerblservice.CustomerBLService;
import org.junit.Test;
import util.Kind_Of_Customers;
import util.ResultMessage;
import vo.CustomerVO;

import static org.junit.Assert.assertEquals;

/**
 * Description:
 * Created by Hanxinhu at 17:23 2018/1/3/003
 */
public class CustomerTest {
    CustomerVO Intel = new CustomerVO("00000001", Kind_Of_Customers.SUPPLIER, 5, "Intel", "88438688", "南京市栖霞区仙林街道168号", "222243", "Intel@Intel.com", 5000, 3400, 0, "001");
    CustomerVO songtuan = new CustomerVO("00000002", Kind_Of_Customers.SALER, 5, "songtuan", "88488888", "南京市栖霞区仙林街道168号", "222243", "songtuan@163.com", 5000, 3400, 0, "001");
    CustomerBLService service = new BLFactoryImpl().getCustomerBLService();
    CustomerBLInfo info = new BLFactoryImpl().getCustomerBLInfo();
    @Test
    public void test1() {
        ResultMessage message = service.addCustomer(Intel);
        assertEquals(ResultMessage.SUCCESS, message);
    }

    @Test
    public void test2() {
        ResultMessage message = service.addCustomer(songtuan);
        assertEquals(ResultMessage.SUCCESS, message);
    }

    @Test
    public void test3() {
        Intel.setName("Micro");
        ResultMessage message = service.modifyCustomer(Intel);
        //     Intel.setName("Intel");
        assertEquals(ResultMessage.SUCCESS, message);
    }

    @Test
    public void test5() {
        ResultMessage message = service.delCustomer(Intel.getID());
        assertEquals(ResultMessage.SUCCESS, message);
    }

    @Test
    public void test6() {
        CustomerVO vo = info.getCustomerByID("123456");
        assertEquals("123456", vo.getID());
    }
}


