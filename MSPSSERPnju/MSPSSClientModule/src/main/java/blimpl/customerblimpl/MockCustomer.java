//package blimpl.customerblimpl;
//
//import com.sun.org.apache.regexp.internal.RE;
//import util.ResultMessage;
//import vo.CustomerVO;
//
//import java.util.ArrayList;
//
//public class MockCustomer extends Customer {
//    /**
//     * 通过关键词搜索客户
//     *
//     * @param keytype
//     * @param keyword
//     * @return
//     */
//    @Override
//    public ArrayList<CustomerVO> searchCustomer(String keytype, String keyword) {
//        ArrayList<CustomerVO> CustomerSearch = new ArrayList<CustomerVO>();
//        if (keytype.equals("ID")) {
//            for (int i = 0; i < CustomerList.size(); i++) {
//                if (CustomerList.get(i).getID().equals(keyword)) {
//                    CustomerSearch.add(CustomerList.get(i));
//                }
//            }
//        } else if (keytype.equals("name")) {
//            for (int i = 0; i < CustomerList.size(); i++) {
//                if (CustomerList.get(i).getName().equals(keyword)) {
//                    CustomerSearch.add(CustomerList.get(i));
//                }
//            }
//        }
//        return CustomerSearch;
//    }
//
//    /**
//     * 增加客户
//     *
//     * @param newCustomer
//     * @return
//     */
//    @Override
//    public ResultMessage addCustomer(CustomerVO newCustomer) {
//        CustomerList.add(newCustomer);
//        return ResultMessage.SUCCESS;
//    }
//
//    /**
//     * 删除客户
//     *
//     * @param ID
//     * @return
//     */
//    @Override
//    public ResultMessage delCustomer(String ID) {
//        for (int i = 0; i < CustomerList.size(); i++) {
//            if (CustomerList.get(i).getID().equals(ID)) {
//                CustomerList.get(i).setExist(false);
//                return ResultMessage.SUCCESS;
//            }
//        }
//        return ResultMessage.FAILED;
//    }
//
//    /**
//     * 修改客户属性
//     *
//     * @param modCustomer
//     * @return
//     */
//    @Override
//    public ResultMessage modifyCustomer(CustomerVO modCustomer) {
//        for (int i = 0; i < CustomerList.size(); i++) {
//            if (CustomerList.get(i).getID().equals(modCustomer.getID())) {
//                CustomerList.remove(i);
//                CustomerList.add(modCustomer);
//                return ResultMessage.SUCCESS;
//            }
//        }
//        return ResultMessage.FAILED;
//    }
//
//    /**
//     * @param ID
//     * @return
//     */
//    @Override
//    public CustomerVO getCustomerInfo(String ID) {
//        for (int i = 0; i < CustomerList.size(); i++) {
//            if (CustomerList.get(i).getID().equals(ID)) {
//                return CustomerList.get(i);
//            }
//        }
//        return null;
//    }
//}
//
