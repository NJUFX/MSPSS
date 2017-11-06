package stockseller;

import blimpl.stocksellerblimpl.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.Test;
import util.Kind_Of_Customers;
import vo.*;

public class CustomerMockTest {
    private Customer customer;
    CustomerVO Intel = new CustomerVO("0000001", Kind_Of_Customers.SUPPLIER, 5, "Intel", "88438688", "南京市栖霞区仙林街道168号", "222243", "Intel@Intel.com", 5000, 3400, 0, "001");
    CustomerVO songtuan = new CustomerVO("0000002", Kind_Of_Customers.SALER, 5, "songtuan", "88488888", "南京市栖霞区仙林街道168号", "222243", "songtuan@163.com", 5000, 3400, 0, "001");

    @Test
    public void testSearchCustomer() {
        ArrayList<CustomerVO> customerList = customer.searchCustomer("ID", "000002");
        boolean b = false;
        if (customerList.get(0).equals(songtuan)) b = true;
        assertEquals(true, b);
    }

    @Test
    public void testAddCustomer() {
        assertEquals(true, customer.addCustomer(Intel));
        assertEquals(true, customer.addCustomer(songtuan));
    }

    @Test
    public void testDelCustomer() {
        assertEquals(true, customer.delCustomer("0000001"));
    }

    @Test
    public void testModCustomer() {
        songtuan.setInvalue(10000);
        songtuan.setPostcode("222241");
        assertEquals(true, customer.modifyCustomer(songtuan));
    }

}
