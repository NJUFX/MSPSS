package blimpl.tableblimpl;

import auxiliary.CustomerPromotion;
import auxiliary.SalesOutBill;
import network.*;
import po.*;
import util.CriteriaClause;
import util.CriteriaClauseImpl;
import util.QueryMethod;
import vo.*;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/23.
 */
public class ProcessTable {
    BillClientNetworkService billClientNetworkService;
    CustomerClientNetworkService customerClientNetworkService;
    UserClientNetworkService userClientNetworkService;

    BillConverter billConverter;
    protected ProcessTable(){
        billClientNetworkService = new BillClientNetworkImpl();
        customerClientNetworkService = new CustomerClientNetworkImpl();
        userClientNetworkService = new UserClientNetworkImpl();
        billConverter = new BillConverter();
    }

    /**
     * 按条件搜索经营历程表
     * @param flags
     * @return
     */
    public ProcessTableVO search(ProcessTableFilterFlagsVO flags){

        ProcessTableVO processTableVO ;
        //进货退货单
        ArrayList<SalesInBillVO> salesInBillList = new ArrayList<SalesInBillVO>();
        //销售单
        ArrayList<SalesOutBillVO> salesOutBillList = new ArrayList<SalesOutBillVO>();
        //现金费用单
        ArrayList<CashCostBillVO> cashCostBillList = new ArrayList<CashCostBillVO>();
        //付款单与收款单
        ArrayList<FinanceBillVO> financeBillList = new ArrayList<FinanceBillVO>();

        //报溢单，报损单，赠送单
        ArrayList<StockBillVO> stockBillList = new ArrayList<StockBillVO>();

        ArrayList<CriteriaClause> cashCostBillCriteriaClauses = new ArrayList<CriteriaClause>();
        ArrayList<CriteriaClause> financeBillCriteriaClauses = new ArrayList<CriteriaClause>();
        ArrayList<CriteriaClause> salesInBillCriteriaClauses = new ArrayList<CriteriaClause>();
        ArrayList<CriteriaClause> salesOutBillCriteriaClauses = new ArrayList<CriteriaClause>();
        ArrayList<CriteriaClause> stockBillCriteriaClauses = new ArrayList<CriteriaClause>();

        if(flags.getBegin()!=null&&flags.getBegin()!=null){
           cashCostBillCriteriaClauses.add(CriteriaClauseImpl.createRangeValueQuery("init_time",flags.getBegin().toString(),flags.getEnd().toString(), QueryMethod.Range));
           financeBillCriteriaClauses.add(CriteriaClauseImpl.createRangeValueQuery("init_time",flags.getBegin().toString(),flags.getEnd().toString(), QueryMethod.Range));
           salesInBillCriteriaClauses.add(CriteriaClauseImpl.createRangeValueQuery("init_time",flags.getBegin().toString(),flags.getEnd().toString(), QueryMethod.Range));
           salesOutBillCriteriaClauses.add(CriteriaClauseImpl.createRangeValueQuery("init_time",flags.getBegin().toString(),flags.getEnd().toString(), QueryMethod.Range));
           stockBillCriteriaClauses.add(CriteriaClauseImpl.createRangeValueQuery("init_time",flags.getBegin().toString(),flags.getEnd().toString(), QueryMethod.Range));
        }
        if(flags.getCustomerName()!=null){
            ArrayList<CustomerPO> customerPOS = customerClientNetworkService.fullSearchCustomer("name",flags.getCustomerName());
            if(customerPOS.size()>=1) {
                String id = customerPOS.get(0).getID();
                financeBillCriteriaClauses.add(CriteriaClauseImpl.createSingleValueQuery("customer_id", id,QueryMethod.Full));
                salesInBillCriteriaClauses.add(CriteriaClauseImpl.createSingleValueQuery("provider", id,QueryMethod.Full));
                salesOutBillCriteriaClauses.add(CriteriaClauseImpl.createSingleValueQuery("customer_id", id,QueryMethod.Full));

            }
            }

        if(flags.getOperatorName()!=null){

            ArrayList<UserPO> userPOS = userClientNetworkService.fullSearchUser("name",flags.getOperatorName());
            if(userPOS.size()>=1){
                String id = userPOS.get(0).getID();
                cashCostBillCriteriaClauses.add(CriteriaClauseImpl.createSingleValueQuery("operator_id", id,QueryMethod.Full));
                financeBillCriteriaClauses.add(CriteriaClauseImpl.createSingleValueQuery("customer_id", id,QueryMethod.Full));
                salesInBillCriteriaClauses.add(CriteriaClauseImpl.createSingleValueQuery("customer_id", id,QueryMethod.Full));
                salesOutBillCriteriaClauses.add(CriteriaClauseImpl.createSingleValueQuery("customer_id", id,QueryMethod.Full));
            }
        }

        if(flags.getStorage()!=null){
            salesInBillCriteriaClauses.add(CriteriaClauseImpl.createSingleValueQuery("storage",flags.getStorage(),QueryMethod.Full));
            salesOutBillCriteriaClauses.add(CriteriaClauseImpl.createSingleValueQuery("storage",flags.getStorage(),QueryMethod.Full));
        }

        ArrayList<CashCostBillPO> cashCostBillPOS = billClientNetworkService.multiSearchCashCostBill(cashCostBillCriteriaClauses);
        ArrayList<FinanceBillPO> financeBillPOS = billClientNetworkService.multiSearchFinanceBill(financeBillCriteriaClauses);
        ArrayList<SalesInBillPO> salesInBillPOS = billClientNetworkService.mutilSearchSalesInBill(salesInBillCriteriaClauses);
        ArrayList<SalesOutBillPO> salesOutBillPOS = billClientNetworkService.mutilSearchSalesOutBill(salesOutBillCriteriaClauses);
        ArrayList<StockBillPO> stockBillPOS = billClientNetworkService.multiSearchStockBill(stockBillCriteriaClauses);


        for(int i=0;i<=cashCostBillPOS.size()-1;i++){
          cashCostBillList.add(billConverter.CashCostBill_PO_To_VO(cashCostBillPOS.get(i)));
        }

        for(int i=0;i<=financeBillPOS.size()-1;i++){
            financeBillList.add(billConverter.FinanceBill_PO_To_VO(financeBillPOS.get(i)));
        }

        for(int i=0;i<=salesInBillPOS.size()-1;i++){
            salesInBillList.add(billConverter.SalesInBill_PO_To_VO(salesInBillPOS.get(i)));
        }

        for(int i=0;i<=salesOutBillPOS.size()-1;i++){
            salesOutBillList.add(billConverter.SalesOutBill_PO_To_VO(salesOutBillPOS.get(i)));
        }

        for(int i=0;i<=stockBillPOS.size()-1;i++){
            stockBillList.add(billConverter.StockBill_PO_To_VO(stockBillPOS.get(i)));
        }

        processTableVO = new ProcessTableVO();

        processTableVO.setCashCostBillList(cashCostBillList);
        processTableVO.setFinanceBillList(financeBillList);
        processTableVO.setSalesInBillList(salesInBillList);
        processTableVO.setSalesOutBillList(salesOutBillList);
        processTableVO.setStockBillList(stockBillList);

        return processTableVO;

    }


}
