package blimpl.customerblimpl;

import blservice.customerblservice.CustomerBLInfo;
import blservice.customerblservice.CustomerBLService;
import exception.dataexception.IntOverFlowException;
import filterflags.CustomerSearchFlag;
import util.ResultMessage;
import vo.CustomerVO;

import java.util.ArrayList;

public class CustomerBLServiceImpl implements CustomerBLService,CustomerBLInfo {
    private Customer customer;

    public CustomerBLServiceImpl(Customer customer) {
        this.customer = customer;
    }

    /**
     *
     * @param keyType
     * @param keyword
     * @return
     */
    @Override
    public ArrayList<CustomerVO> searchCustomer(CustomerSearchFlag keyType, String keyword) {
        return customer.searchCustomer(keyType.toString(),keyword);
    }




    /**
     * 通过客户编号获取客户属性
     *
     * @param ID
     * @return
     */
    @Override
    public CustomerVO getCustomerInfo(String ID) {
        return customer.getCustomerInfo(ID);
    }

    /**
     * @param customerVO
     *
     * @return
     */
    @Override
    public ResultMessage addCustomer(CustomerVO customerVO) throws IntOverFlowException {

        if(customerVO.getLevel()<0&&customerVO.getIncomemoney()>Integer.MAX_VALUE){
            throw new IntOverFlowException(customerVO.getLevel());
        }
        return customer.addCustomer(customerVO) ;
    }

    /**
     * 删除客户
     *
     * @param ID
     * @return
     */
    @Override
    public ResultMessage delCustomer(String ID) {
        return customer.delCustomer(ID);
    }

    /**
     * @param customerVO
     * @return
     */
    @Override
    public ResultMessage modifyCustomer(CustomerVO customerVO) throws IntOverFlowException {


        if(customerVO.getLevel()<0&&customerVO.getIncomemoney()>Integer.MAX_VALUE){
            throw new IntOverFlowException(customerVO.getLevel());
        }
        return customer.modifyCustomer(customerVO);
    }

    @Override
    public CustomerVO getCustomerByID(String ID) {
        return customer.getCustomerInfo(ID);
    }

    /**
     * 改变用户的应收额度 实在是想不出英文名了:) orz
     * 默认为减少
     *
     * @param customerID
     * @param money
     * @return
     */
    @Override
    public ResultMessage changeYingShou(String customerID, double money) {
        return customer.changeYingShou(customerID, money);
    }

    /**
     * 改变客户的应付额度 实在是想不出英文名了:) orz
     * 默认为减少
     *
     * @param customerID
     * @param money
     * @return
     */
    @Override
    public ResultMessage changeYingFu(String customerID, double money) {
        return customer.changeYingFu(customerID, money);
    }
}
