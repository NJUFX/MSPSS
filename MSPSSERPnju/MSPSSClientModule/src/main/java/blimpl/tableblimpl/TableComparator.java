package blimpl.tableblimpl;

import vo.*;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class TableComparator {

    public ProcessTableVO ComparePTByTime(ProcessTableVO processTableVO){
        //进货退货单
        ArrayList<SalesInBillVO> salesInBillList = processTableVO.getSalesInBillList();
        //销售单
        ArrayList<SalesOutBillVO> salesOutBillList = processTableVO.getSalesOutBillList();
        //现金费用单
        ArrayList<CashCostBillVO> cashCostBillList= processTableVO.getCashCostBillList();
        //付款单与收款单
        ArrayList<FinanceBillVO> financeBillList= processTableVO.getFinanceBillList();

        //报溢单，报损单，赠送单
        ArrayList<StockBillVO> stockBillList= processTableVO.getStockBillList();

        for(int i=0;i<=salesInBillList.size()-1;i++){
            for(int j=0;j<=salesInBillList.size()-2-i;j++){
                if(salesInBillList.get(j).getInit_time().toString().compareTo(salesInBillList.get(j+1).getInit_time().toString())>0){
                     SalesInBillVO mid = salesInBillList.get(j);
                     SalesInBillVO mid2 = salesInBillList.get(j+1);
                     salesInBillList.set(j,mid2);
                     salesInBillList.set(j+1,mid);
                }
            }
        }

        for(int i=0;i<=salesOutBillList.size()-1;i++){
            for(int j=0;j<=salesOutBillList.size()-2-i;j++){
                if(salesOutBillList.get(j).getInit_time().toString().compareTo(salesOutBillList.get(j+1).getInit_time().toString())>0){
                    SalesOutBillVO mid = salesOutBillList.get(j);
                    SalesOutBillVO mid2 = salesOutBillList.get(j+1);
                    salesOutBillList.set(j,mid2);
                    salesOutBillList.set(j+1,mid);
                }
            }
        }

        for(int i=0;i<=cashCostBillList.size()-1;i++){
            for(int j=0;j<=cashCostBillList.size()-2-i;j++){
                if(cashCostBillList.get(j).getInit_time().toString().compareTo(cashCostBillList.get(j+1).getInit_time().toString())>0){
                    CashCostBillVO mid = cashCostBillList.get(j);
                    CashCostBillVO mid2 = cashCostBillList.get(j+1);
                    cashCostBillList.set(j,mid2);
                    cashCostBillList.set(j+1,mid);
                }
            }
        }

        for(int i=0;i<=financeBillList.size()-1;i++){
            for(int j=0;j<=financeBillList.size()-2-i;j++){
                if(financeBillList.get(j).getInit_time().toString().compareTo(financeBillList.get(j+1).getInit_time().toString())>0){
                    FinanceBillVO mid = financeBillList.get(j);
                    FinanceBillVO mid2 = financeBillList.get(j+1);
                    financeBillList.set(j,mid2);
                    financeBillList.set(j+1,mid);
                }
            }
        }

        for(int i=0;i<=stockBillList.size()-1;i++){
            for(int j=0;j<=stockBillList.size()-2-i;j++){
                if(stockBillList.get(j).getInit_time().toString().compareTo(stockBillList.get(j+1).getInit_time().toString())>0){
                    StockBillVO mid = stockBillList.get(j);
                    StockBillVO mid2 = stockBillList.get(j+1);
                    stockBillList.set(j,mid2);
                    stockBillList.set(j+1,mid);
                }
            }
        }

        processTableVO.setSalesInBillList(salesInBillList);
        processTableVO.setSalesOutBillList(salesOutBillList);
        processTableVO.setStockBillList(stockBillList);
        processTableVO.setFinanceBillList(financeBillList);
        processTableVO.setCashCostBillList(cashCostBillList);

        return processTableVO;
    }

    public SaleTableVO CompareSTByTime(SaleTableVO saleTableVO){
     ArrayList<SalesOutBillVO> salesOutBillList = saleTableVO.getSalesOutBills();

        for(int i=0;i<=salesOutBillList.size()-1;i++){
            for(int j=0;j<=salesOutBillList.size()-2-i;j++){
                if(salesOutBillList.get(j).getInit_time().toString().compareTo(salesOutBillList.get(j+1).getInit_time().toString())>0){
                    SalesOutBillVO mid = salesOutBillList.get(j);
                    SalesOutBillVO mid2 = salesOutBillList.get(j+1);
                    salesOutBillList.set(j,mid2);
                    salesOutBillList.set(j+1,mid);
                }
            }
        }

        saleTableVO.setSalesOutBills(salesOutBillList);

        return saleTableVO;
    }
}
