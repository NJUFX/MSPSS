package blimpl.customerblimpl;

import network.CustomerClientNetworkImpl;
import network.CustomerClientNetworkService;
import po.CustomerPO;
import util.Kind_Of_Customers;
import util.ResultMessage;
import vo.CustomerVO;

import java.util.ArrayList;

public class Customer {
    CustomerClientNetworkService networkService = new CustomerClientNetworkImpl();

    /**
     * 通过关键词类型和关键词来查找客户
     *
     * @param keytype
     * @param keyword
     * @return
     */
    public ArrayList<CustomerVO> searchCustomer(String keytype, String keyword) {
        ArrayList<CustomerVO> vos;
        ArrayList<CustomerPO> pos;

        switch (keytype){
            case "ID" :
                 pos = networkService.fullSearchCustomer("ID",Integer.parseInt(keyword));
                 break;
            case "name" :
                    pos = networkService.fuzzSearchCustomer("name",keyword);
                break;
            case "level" :
                pos = networkService.fullSearchCustomer("level",Integer.parseInt(keyword));
                break;
            case "category" :
                pos = networkService.fullSearchCustomer("category",keyword);
                break;
            case "DAE" :
                pos = networkService.fuzzSearchCustomer("DAE",keyword);
                break;
            case "Invalue":
                Double invalue = Double.parseDouble(keyword);
                //在前后
                double min = invalue * (1 - 0.1);
                double max = invalue * (1 - 0.1);
                pos = networkService.rangeSearchCustomer("Invalue",min,max);
                break;
                default:
                    pos = new ArrayList<>();
        }
        vos = pos_to_vos(pos);
        return vos;
    }

    /**
     * 通过客户编号获取客户属性
     *
     * @param ID
     * @return
     */
    public CustomerVO getCustomerInfo(String ID) {
        CustomerPO po = networkService.searchCustomerByID(ID);
        return po_to_vo(po);
    }

    /**
     * @param customer
     * @return
     */
    public ResultMessage addCustomer(CustomerVO customer) {
        CustomerPO po = vo_to_po(customer);
        return networkService.addCustomer(po);
    }

    /**
     * 删除客户
     *
     * @param ID
     * @return
     */
    public ResultMessage delCustomer(String ID) {

        return networkService.deleteCustomer(ID);
    }

    /**
     * @param customer
     * @return
     */
    public ResultMessage modifyCustomer(CustomerVO customer) {
        CustomerPO po = vo_to_po(customer);
        po.setID(Integer.parseInt(customer.getID()));
        return networkService.updateCustomer(po);
    }

    private CustomerVO po_to_vo(CustomerPO po){
        Kind_Of_Customers kind = po.getCategory() == 0 ? Kind_Of_Customers.SALER : Kind_Of_Customers.SUPPLIER;
        CustomerVO vo = new CustomerVO(String.format("%05d",po.getID()), kind,po.getLevel(),
                po.getName(),po.getPhonenumber(),po.getAddress(),po.getPostcode(),
                po.getEmail(),po.getInvalue(),po.getIncomemoney(),po.getPaymoney(),po.getDAE());
        System.out.println(vo.getCategory() == null);
    return vo;
    }

    private CustomerPO vo_to_po(CustomerVO vo){

        int category = Kind_Of_Customers.SALER==vo.getCategory() ? 0 :1;
        CustomerPO po = new CustomerPO(
                vo.getExist(),category,vo.getLevel(),
                vo.getName(),vo.getPhonenumber(),vo.getAddress()
                ,vo.getPostcode(),vo.getEmail(),vo.getInvalue(),
                vo.getIncomemoney(),vo.getPaymoney(),
                vo.getDAE());
    return po;
    }
    private ArrayList<CustomerVO> pos_to_vos(ArrayList<CustomerPO> pos){
        ArrayList<CustomerVO> vos = new ArrayList<>();
        for (CustomerPO po : pos){
            CustomerVO vo = po_to_vo(po);
            vos.add(vo);
        }
        return vos;
    }

    /**
     * 改变用户的应收额度 实在是想不出英文名了:) orz
     * 默认为减少
     *
     * @param customerID
     * @param money
     * @return
     */

    public ResultMessage changeYingShou(String customerID, double money) {
        CustomerPO po = networkService.searchCustomerByID(customerID);
        if (po == null)
            return ResultMessage.FAILED;
        po.setIncomemoney(po.getIncomemoney() - money);
        return networkService.updateCustomer(po);
    }

    /**
     * 改变客户的应付额度 实在是想不出英文名了:) orz
     * 默认为减少
     *
     * @param customerID
     * @param money
     * @return
     */

    public ResultMessage changeYingFu(String customerID, double money) {
        CustomerPO po = networkService.searchCustomerByID(customerID);
        if (po == null)
            return ResultMessage.FAILED;
        po.setPaymoney(po.getPaymoney() - money);
        return networkService.updateCustomer(po);
    }

}
