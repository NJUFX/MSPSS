package blservice.customerblservice;

import vo.CustomerVO;

/**
 * Description:
 * Created by Hanxinhu at 11:09 2017/12/12/012
 */
public interface CustomerBLInfo {
    public CustomerVO getCustomerByID(String ID);
}
