package blimpl.tableblimpl;

import vo.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class ExportHelper {

    /**
     *导出BusinessTableVO
     * @param businessTableVO
     */
    public void BusinessTableExport(BusinessTableVO businessTableVO){

        ArrayList<BusinessTableVO> businessTableVOS = new ArrayList<BusinessTableVO>();
        businessTableVOS.add(businessTableVO);

        Map<String,String> titleMap = new LinkedHashMap<String,String>();

        titleMap.put("salesIncome","销售类收入");
        titleMap.put("commodityIncome","商品类收入");
        titleMap.put("salesCost","销售成本");
        titleMap.put("commodityCost","商品类成本");

        String sheetName = "                 经营情况表";

        ExportExcel.excelExport(businessTableVOS,titleMap,sheetName);
    }

    /**
     * 导出SaleTableVO
     * @param saleTableVO
     */
    public void SaleTableExport(SaleTableVO saleTableVO){
        //销售单
        ArrayList<SalesOutBillVO> salesOutBillList=saleTableVO.getSalesOutBills();


        Map<String,String> titleMap2 = new LinkedHashMap<String,String>();

        for (int i = 0; i <= salesOutBillList.size() - 1; i++) {
            if (salesOutBillList.get(i).getID() == null) salesOutBillList.get(i).setID("");
            if (salesOutBillList.get(i).getDAE() == null) salesOutBillList.get(i).setDAE("");
        }
        titleMap2.put("ID","编号");
        titleMap2.put("DAE","业务员");
        // titleMap2.put("storage","仓库");
        titleMap2.put("allowance","折让");
        titleMap2.put("voucher","代金券金额");
        titleMap2.put("sumBeforeDiscount","折让前总额");
        titleMap2.put("sumAfterDiscount","折让后总额");

        String sheetName2 = "           销售明细报表";

        ExportExcel.excelExport(salesOutBillList,titleMap2,sheetName2);


    }

    /**
     * 导出ProcessTableVO
     * @param processTableVO
     */
    public void ProcessTableExport(ProcessTableVO processTableVO){

        //进货退货单
        ArrayList<SalesInBillVO> salesInBillList = processTableVO.getSalesInBillList();
        //销售单
        ArrayList<SalesOutBillVO> salesOutBillList=processTableVO.getSalesOutBillList();
        //现金费用单
        ArrayList<CashCostBillVO> cashCostBillList = processTableVO.getCashCostBillList();
        //付款单与收款单
        ArrayList<FinanceBillVO> financeBillList=processTableVO.getFinanceBillList();

        //报溢单，报损单，赠送单
        ArrayList<StockBillVO> stockBillList = processTableVO.getStockBillList();

        for (int i = 0; i <= salesInBillList.size() - 1; i++) {
            if (salesInBillList.get(i).getDAE() == null) salesInBillList.get(i).setDAE("");
            if (salesInBillList.get(i).getProvider() == null) salesInBillList.get(i).setProvider("");

        }

        for (int i = 0; i <= salesOutBillList.size() - 1; i++) {
            if (salesOutBillList.get(i).getID() == null) salesOutBillList.get(i).setDAE("");
            if (salesOutBillList.get(i).getDAE() == null) salesOutBillList.get(i).setDAE("");
        }

        for (int i = 0; i <= financeBillList.size() - 1; i++) {
            if (financeBillList.get(i).getID() == null) financeBillList.get(i).setID("");

        }

        for (int i = 0; i <= stockBillList.size() - 1; i++) {
            if (stockBillList.get(i).getId() == null) stockBillList.get(i).setId("");
        }

        Map<String,String> titleMap1 = new LinkedHashMap<String,String>();
        titleMap1.put("ID","编号");
        titleMap1.put("DAE","默认业务员");
        titleMap1.put("provider","供应商");

        //  titleMap1.put("ps","备注");
        titleMap1.put("sumMoney","总额");
        // titleMap1.put("commentByManager","总经理备注");

        Map<String,String> titleMap2 = new LinkedHashMap<String,String>();

        titleMap2.put("ID","编号");
        titleMap2.put("DAE","业务员");

        titleMap2.put("allowance","折让");
        titleMap2.put("voucher","代金券金额");
        titleMap2.put("sumBeforeDiscount","折让前总额");
        titleMap2.put("sumAfterDiscount","折让后总额");

        Map<String,String> titleMap3 = new LinkedHashMap<String,String>();

        titleMap3.put("ID","编号");
        titleMap3.put("sum","总额");

        Map<String,String> titleMap4 = new LinkedHashMap<String,String>();

        titleMap4.put("ID","编号");
        titleMap4.put("sum","总额");
        titleMap4.put("init_time","初始化时间");

        Map<String,String> titleMap5 = new LinkedHashMap<String,String>();

        titleMap5.put("id","编号");
        titleMap5.put("type", "种类编号");
        titleMap5.put("status", "状态");
        titleMap5.put("init_time", "创建时间");
        //  titleMap5.put("commentByManager","总经理评价");
        // titleMap5.put("commentByStockManager","库存管理人员评价");

        String sheetName1 = "           进货类报表";

        ExportExcel.excelExport(salesInBillList,titleMap1,sheetName1);

        String sheetName2 = "           销售类报表";

        ExportExcel.excelExport(salesOutBillList,titleMap2,sheetName2);

        String sheetName3 = "           现金费用类报表";

        ExportExcel.excelExport(cashCostBillList,titleMap3,sheetName3);

        String sheetName4 = "            财务类报表";

        ExportExcel.excelExport(financeBillList,titleMap4,sheetName4);

        String sheetName5 ="             库存类报表";

        ExportExcel.excelExport(stockBillList,titleMap5,sheetName5);





    }
/*
    public static void main(String [] args){
        ArrayList<SalesInBillVO> salesInBillVOS = new ArrayList<SalesInBillVO>();
        SalesInBillVO salesInBillVO = new SalesInBillVO("123", "王二","李四","二号仓",
                "123456",210.12,"单据写的不错");
        salesInBillVOS.add(salesInBillVO);

        ProcessTableVO processTableVO = new ProcessTableVO();
        processTableVO.setSalesInBillList(salesInBillVOS);
                ExportHelper exportHelper = new ExportHelper();
        exportHelper.ProcessTableExport(processTableVO);
    }
*/

}
