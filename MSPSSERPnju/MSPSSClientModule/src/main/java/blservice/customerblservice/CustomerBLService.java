package blservice.customerblservice;

import exception.dataexception.IntOverFlowException;
import exception.dataexception.NegativeException;
import filterflags.CustomerSearchFlag;
import util.ResultMessage;
import vo.CustomerVO;

import java.util.ArrayList;

public interface CustomerBLService {
    /**
     * 通过关键词类型和关键词来查找客户
     *
     * @param keyType
     * @param keyword
     * @return
     */
    public ArrayList<CustomerVO> searchCustomer(CustomerSearchFlag keyType, String keyword);

    /**
     * 通过客户编号获取客户属性
     *
     * @param ID
     * @return
     */
    public CustomerVO getCustomerInfo(String ID);

    /**
     * @param customer
     * @return
     */
    public ResultMessage addCustomer(CustomerVO customer) throws IntOverFlowException;

    /**
     * 删除客户
     *
     * @param ID
     * @return
     */
    public ResultMessage delCustomer(String ID);

    /**
     * @param customer
     * @return
     */
    public ResultMessage modifyCustomer(CustomerVO customer)throws IntOverFlowException;

}
