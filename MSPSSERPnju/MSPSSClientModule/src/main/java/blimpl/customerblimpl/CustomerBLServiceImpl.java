package blimpl.customerblimpl;

import blservice.customerblservice.CustomerBLService;
import util.ResultMessage;
import vo.CustomerVO;

import java.util.ArrayList;

public class CustomerBLServiceImpl implements CustomerBLService {
    /**
     * 通过关键词类型和关键词来查找客户
     *
     * @param keytype
     * @param keyword
     * @return
     */
    @Override
    public ArrayList<CustomerVO> searchCustomer(String keytype, String keyword) {
        return null;
    }

    /**
     * 通过客户编号获取客户属性
     *
     * @param ID
     * @return
     */
    @Override
    public CustomerVO getCustomerInfo(String ID) {
        return null;
    }

    /**
     * @param customer
     * @return
     */
    @Override
    public ResultMessage addCustomer(CustomerVO customer) {
        return ResultMessage.SUCCESS;
    }

    /**
     * 删除客户
     *
     * @param ID
     * @return
     */
    @Override
    public ResultMessage delCustomer(String ID) {
        return ResultMessage.SUCCESS;
    }

    /**
     * @param customer
     * @return
     */
    @Override
    public ResultMessage modifyCustomer(CustomerVO customer) {
        return ResultMessage.SUCCESS;
    }

}
