package blimpl.tableblimpl;


import blimpl.billblimpl.SalesOutBill;
import network.*;
import network.commoditynetworkservice.CommodityServerNetworkService;
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
        if(flags.getBegin()!=null&&flags.getEnd()!=null){
            criteriaClauses.add(CriteriaClauseImpl.createRangeValueQuery("init_time",flags.getBegin().toString(),flags.getEnd().toString(), QueryMethod.Range));
        }
        if(flags.getCommodityName()!=null){
            ArrayList<CommodityPO> commodityPOS = commodityClientNetworkService.fullSearchCommodity("name",flags.getCommodityName());
            if(commodityPOS.size()>=0){
                criteriaClauses.add(CriteriaClauseImpl.createSingleValueQuery("customer_id",commodityPOS.get(0).getID(),QueryMethod.Full));
            }
        }

        if(flags.getOperatorName()!=null){
            ArrayList<UserPO> userPOS = userClientNetworkService.fullSearchUser("name",flags.getOperatorName());
            if(userPOS.size()>=0){
                criteriaClauses.add(CriteriaClauseImpl.createSingleValueQuery("operator_id",userPOS.get(0).getID(),QueryMethod.Full));
            }
        }

        if(flags.getCustomerName()!=null){
            ArrayList<CustomerPO> customerPOS = customerClientNetworkService.fullSearchCustomer("name",flags.getCustomerName());
            if(customerPOS.size()>=0){
                criteriaClauses.add(CriteriaClauseImpl.createSingleValueQuery("customer_id",customerPOS.get(0).getID(),QueryMethod.Full));
            }
        }

        if(flags.getStorage()!=null){
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

    /**
     * 按商品名称以字典序的的方式排序
     * @param flags
     * @return
     */
    public SaleTableVO compareByName(SaleTableVO flags){
        return null;
    }

    /**
     * 按时间从前往后排序
     * @param saleTableVO
     * @return
     */
    public SaleTableVO compareByTime(SaleTableVO saleTableVO){
        return null;
    }
}
