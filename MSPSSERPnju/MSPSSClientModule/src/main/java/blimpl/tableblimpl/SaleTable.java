package blimpl.tableblimpl;


import network.*;
import po.CommodityPO;
import po.CustomerPO;
import po.SalesOutBillPO;
import po.UserPO;
import util.CriteriaClause;
import util.CriteriaClauseImpl;
import util.QueryMethod;
import vo.SaleTableFilterFlagsVO;
import vo.SaleTableVO;
import vo.SalesOutBillVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/23.
 */
public class SaleTable {
    BillClientNetworkService billClientNetworkService;
    CommodityClientNetworkService commodityClientNetworkService;
    UserClientNetworkService userClientNetworkService;
    CustomerClientNetworkService customerClientNetworkService;
    BillConverter billConverter;
    protected SaleTable(){
        billClientNetworkService = new BillClientNetworkImpl();
        commodityClientNetworkService = new CommodityClientNetworkImpl();
        userClientNetworkService = new UserClientNetworkImpl();
        customerClientNetworkService = new CustomerClientNetworkImpl();
        billConverter = new BillConverter();
    }

    /**
     * 按条件搜索销售明细表
     * @param flags
     * @return
     */
    public SaleTableVO search(SaleTableFilterFlagsVO flags){
        ArrayList<SalesOutBillPO> salesOutBillPOS ;

        ArrayList<CriteriaClause> criteriaClauses = new ArrayList<CriteriaClause>();
        if (flags.getBegin() != null && flags.getEnd() != null && flags.getBegin().toString() != "" && flags.getEnd().toString() != "") {
            criteriaClauses.add(CriteriaClauseImpl.createRangeValueQuery("init_time", flags.getBegin().toString(), flags.getEnd().toString(), QueryMethod.Range));
        }
        if (false) {
            ArrayList<CommodityPO> commodityPOS = commodityClientNetworkService.fullSearchCommodity("name",flags.getCommodityName());
            if(commodityPOS.size()>=0){
                criteriaClauses.add(CriteriaClauseImpl.createSingleValueQuery("customerID",commodityPOS.get(0).getID(),QueryMethod.Full));
            }
        }

        if (flags.getOperatorName() != null && flags.getOperatorName() != "" && flags.getOperatorName().length() != 0) {
            ArrayList<UserPO> userPOS = userClientNetworkService.fullSearchUser("name",flags.getOperatorName());
            if(userPOS.size()>=0){
                criteriaClauses.add(CriteriaClauseImpl.createSingleValueQuery("operatorID",userPOS.get(0).getID(),QueryMethod.Full));
            }
        }

        if (flags.getCustomerName() != null && flags.getCustomerName() != "" && flags.getCustomerName().length() != 0) {
            ArrayList<CustomerPO> customerPOS = customerClientNetworkService.fullSearchCustomer("name",flags.getCustomerName());
            if(customerPOS.size()>=0){
                criteriaClauses.add(CriteriaClauseImpl.createSingleValueQuery("customerID",customerPOS.get(0).getID(),QueryMethod.Full));
            }
        }

        if (flags.getStorage() != null && flags.getStorage() != "" && flags.getStorage().length() != 0) {
            criteriaClauses.add(CriteriaClauseImpl.createSingleValueQuery("storage",flags.getStorage(),QueryMethod.Full));
        }

        salesOutBillPOS = billClientNetworkService.mutilSearchSalesOutBill(criteriaClauses);
        ArrayList<SalesOutBillVO> salesOutBillVOS = new ArrayList<SalesOutBillVO>();
        for(int i=0;i<=salesOutBillPOS.size()-1;i++){
            salesOutBillVOS.add(billConverter.SalesOutBill_PO_To_VO(salesOutBillPOS.get(i)));

        }

        SaleTableVO saleTableVO = new SaleTableVO();
        saleTableVO.setSalesOutBills(salesOutBillVOS);

        return saleTableVO;
    }



}
