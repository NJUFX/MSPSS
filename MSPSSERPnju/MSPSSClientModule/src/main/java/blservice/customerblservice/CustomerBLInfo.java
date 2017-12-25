package blservice.customerblservice;

import util.ResultMessage;
import vo.CustomerVO;

/**
 * Description:
 * Created by Hanxinhu at 11:09 2017/12/12/012
 */
public interface CustomerBLInfo {
    public CustomerVO getCustomerByID(String ID);

    /**
     * 改变用户的应收额度 实在是想不出英文名了:) orz
     * 默认为减少
     *
     * @param customerID
     * @param money
     * @return
     */
    public ResultMessage changeYingShou(String customerID, double money);

    /**
     * 改变客户的应付额度 实在是想不出英文名了:) orz
     * 默认为减少
     *
     * @param customerID
     * @param money
     * @return
     */
    public ResultMessage changeYingFu(String customerID, double money);


}
