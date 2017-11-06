package blimpl.stocksellerblimpl;

import vo.CustomerVO;

import java.util.*;

public class MockCustomer extends Customer {
    /**
     * 通过关键词搜索客户
     *
     * @param keytype
     * @param keyword
     * @return
     */
    @Override
    public ArrayList<CustomerVO> searchCustomer(String keytype, String keyword) {
        ArrayList<CustomerVO> CustomerSearch = new ArrayList<CustomerVO>();
        if (keytype.equals("ID")) {
            for (int i = 0; i < CustomerList.size(); i++) {
                if (CustomerList.get(i).getID().equals(keyword)) {
                    CustomerSearch.add(CustomerList.get(i));
                }
            }
        } else if (keytype.equals("name")) {
            for (int i = 0; i < CustomerList.size(); i++) {
                if (CustomerList.get(i).getName().equals(keyword)) {
                    CustomerSearch.add(CustomerList.get(i));
                }
            }
        }
        return CustomerList;
    }

    /**
     * 增加客户
     *
     * @param newCustomer
     * @return
     */
    @Override
    public boolean addCustomer(CustomerVO newCustomer) {
        CustomerList.add(newCustomer);
        return true;
    }

    /**
     * 删除客户
     *
     * @param ID
     * @return
     */
    @Override
    public boolean delCustomer(String ID) {
        for (int i = 0; i < CustomerList.size(); i++) {
            if (CustomerList.get(i).getID().equals(ID)) {
                CustomerList.get(i).setExist(false);
                return true;
            }
        }
        return false;
    }

    /**
     * 修改客户属性
     *
     * @param modCustomer
     * @return
     */
    @Override
    public boolean modifyCustomer(CustomerVO modCustomer) {
        for (int i = 0; i < CustomerList.size(); i++) {
            if (CustomerList.get(i).getID().equals(modCustomer.getID())) {
                CustomerList.remove(i);
                CustomerList.add(modCustomer);
                return true;
            }
        }
        return false;
    }
}
