package dataimpl.billdataimpl;

import datahelper.DataHelper;
import dataservice.BillDataService;
import po.*;
import util.*;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/24.
 */
public class BillDataServiceImpl implements BillDataService{
    private DataHelper<StockBillPO> stockBillHelper;
    private DataHelper<CashCostBillPO> cashCostBillHelper;
    private DataHelper<FinanceBillPO> financeBillHelper;
    private DataHelper<SalesInBillPO> salesInBillHelper;
    private DataHelper<SalesOutBillPO> salesOutBillHelper;

    public BillDataServiceImpl(DataHelper<StockBillPO> stockBillHelper, DataHelper<CashCostBillPO> cashCostBillHelper, DataHelper<FinanceBillPO> financeBillHelper, DataHelper<SalesInBillPO> salesInBillHelper, DataHelper<SalesOutBillPO> salesOutBillHelper) {
        this.stockBillHelper = stockBillHelper;
        this.cashCostBillHelper = cashCostBillHelper;
        this.financeBillHelper = financeBillHelper;
        this.salesInBillHelper = salesInBillHelper;
        this.salesOutBillHelper = salesOutBillHelper;
    }

    /**
     * 添加库存类单据 用于点击保存时
     * @param stockBillPO
     * @return
     */
    public ResultMessage addStockBill(StockBillPO stockBillPO){
        try{
            stockBillHelper.save(stockBillPO);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();

        }
        return ResultMessage.FAILED;
    }

    /**
     * 更新库存类单据 用于点击提交时
     * @param stockBillPO
     * @return
     */
    public ResultMessage updateStockBill(StockBillPO stockBillPO){
        try{
            stockBillHelper.update(stockBillPO);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();

        }
        return ResultMessage.FAILED;
    }

    /**
     * 删除某单据 未提交状态
     *
     * @param id
     * @return
     */
    public ResultMessage deleteStockBill(String id){
        try{
            stockBillHelper.delete("id",id);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();

        }
        return ResultMessage.FAILED;
    }

    /**
     *用于查找某一数据
     */
    public ArrayList<StockBillPO> fullSearchStockBill(String field, Object value){
        return stockBillHelper.fullMatchQuery(field, value);
    }


    public ArrayList<StockBillPO> multiSearchStockBill(ArrayList<CriteriaClause> criteriaClauses){
        return stockBillHelper.multiCriteriaQuery(criteriaClauses);
    }

    /**
     * 返回形如 KCZSD-20101010-00001
     *
     * @param type
     * @return
     */
    public String getStockBillID(StockBillType type){
        ArrayList<StockBillPO> stockBillPOS;
        String prefix;
        switch(type){
            case Presentation:
                 stockBillPOS = stockBillHelper.prefixMatchQuery("id","KCZSD");
                 prefix ="KCZSD";
                break;
            case More:
                 stockBillPOS = stockBillHelper.prefixMatchQuery("id","KCBYD");
                prefix ="KCBYD";
                 break;
            case Less:
                stockBillPOS = stockBillHelper.prefixMatchQuery("id","KCBSD");
                prefix = "KCBSD";
                break;
            default:
                stockBillPOS = new ArrayList<StockBillPO>();
                prefix ="";
        }

        int num = stockBillPOS.size()+1;

        String strNum = ""+num;

        while(strNum.length()<5){
            strNum = "0"+strNum;
        }

        return prefix+"-"+Time.getTimeFormat()+"-"+strNum;

    }

    /**
     * 在数据层增加 现金费用单
     *
     * @param po
     * @return
     */
    public ResultMessage addCashCostBill(CashCostBillPO po){
        try{
            cashCostBillHelper.save(po);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    /**
     * 在数据层更新 现金费用单
     *
     * @param po
     * @return
     */
    public ResultMessage updateCashCostBill(CashCostBillPO po){
        try{
            cashCostBillHelper.update(po);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage deleteCashCostBill(String id){
        try{
            cashCostBillHelper.delete("id",id);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }


    public ArrayList<CashCostBillPO> multiSearchCashCostBill(ArrayList<CriteriaClause> criteriaClauses){
        return cashCostBillHelper.multiCriteriaQuery(criteriaClauses);
    }

    public ArrayList<CashCostBillPO> fullSearchCashCostBill(String field, Object val){
        return cashCostBillHelper.fullMatchQuery(field, val);
    }
    /**
     * 得到应有的现金费用单ID
     *
     * @return
     */
    public String getCashCostBillID(){
        ArrayList<CashCostBillPO> cashCostBillPOS = cashCostBillHelper.prefixMatchQuery("id","XJFYD");
        int num = cashCostBillPOS.size()+1;

        String strNum = ""+num;

        while(strNum.length()<5){
            strNum = "0"+strNum;
        }

        return "XJFYD"+"-"+Time.getTimeFormat()+"-"+strNum;

    }

    public ResultMessage addFinanceBill(FinanceBillPO po){
        try{
            financeBillHelper.save(po);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage updateFinanceBill(FinanceBillPO po){
        try{
            financeBillHelper.update(po);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage deleteFinanceBill(String id){
        try{
            financeBillHelper.delete("id",id);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ArrayList<FinanceBillPO> fullSearchFinanceBill(String field, Object val){
        return financeBillHelper.fullMatchQuery(field, val);
    }

    public ArrayList<FinanceBillPO> multiSearchFinanceBill(ArrayList<CriteriaClause> criteriaClauses){
        return financeBillHelper.multiCriteriaQuery(criteriaClauses);
    }

    /**
     * 根据财务类单据类型返回应有的单据
     *
     * @param type
     * @return
     */
    public String getFinanceBillID(FinanceBillType type){
        ArrayList<FinanceBillPO> financeBillPOS;
        String prefix;
        switch(type){
            case IN:
                financeBillPOS = financeBillHelper.prefixMatchQuery("id","SKD");
                prefix ="SKD";
                break;
            case OUT:
                financeBillPOS = financeBillHelper.prefixMatchQuery("id","FKD");
                prefix ="FKD";
                break;

            default:
                financeBillPOS = new ArrayList<FinanceBillPO>();
                prefix ="";
        }

        int num = financeBillPOS.size()+1;

        String strNum = ""+num;

        while(strNum.length()<5){
            strNum = "0"+strNum;
        }

        return prefix+"-"+Time.getTimeFormat()+"-"+strNum;
    }

    public ResultMessage addSalesInBill(SalesInBillPO salesInBillPO){
        try{
            salesInBillHelper.save(salesInBillPO);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage updateSalesInBill(SalesInBillPO salesInBillPO){
        try{
            salesInBillHelper.update(salesInBillPO);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage deleteSalesInBill(String id){
        try{
            salesInBillHelper.delete("id",id);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ArrayList<SalesInBillPO> fullSearchSalesInBill(String field, Object val){
        return salesInBillHelper.fullMatchQuery(field, val);
    }

    public ArrayList<SalesInBillPO> mutilSearchSalesInBill(ArrayList<CriteriaClause> criteriaClauses){
        return salesInBillHelper.multiCriteriaQuery(criteriaClauses);
    }

    public String getSalesInBillID(SalesInBillType type){
        ArrayList<SalesInBillPO> salesInBillPOS;
        String prefix;
        switch(type){
            case IN:
                salesInBillPOS = salesInBillHelper.prefixMatchQuery("id","JHD");
                prefix ="JHD";
                break;
            case OUT:
                salesInBillPOS = salesInBillHelper.prefixMatchQuery("id","JHTHD");
                prefix ="JHTHD";
                break;

            default:
                salesInBillPOS = new ArrayList<SalesInBillPO>();
                prefix ="";
        }

        int num = salesInBillPOS.size()+1;

        String strNum = ""+num;

        while(strNum.length()<5){
            strNum = "0"+strNum;
        }

        return prefix+"-"+Time.getTimeFormat()+"-"+strNum;
    }

    public ResultMessage addSalesOutBill(SalesOutBillPO salesOutBillPO){
        try{
            salesOutBillHelper.save(salesOutBillPO);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage updateSalesOutBill(SalesOutBillPO salesOutBillPO){
        try{
            salesOutBillHelper.update(salesOutBillPO);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage deleteSalesOutBill(String id){
        try{
            salesOutBillHelper.delete("id",id);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ArrayList<SalesOutBillPO> fullSearchSalesOutBill(String field, Object val){
        return salesOutBillHelper.fullMatchQuery(field, val);
    }

    public ArrayList<SalesOutBillPO> mutilSearchSalesOutBill(ArrayList<CriteriaClause> criteriaClauses){
        return salesOutBillHelper.multiCriteriaQuery(criteriaClauses);
    }

    public String getSalesOutBillID(SalesOutBillType type){
        ArrayList<SalesOutBillPO> salesOutBillPOS;
        String prefix;
        switch(type){
            case RETURN:
                salesOutBillPOS = salesOutBillHelper.prefixMatchQuery("id","XSTHD");
                prefix ="XSTHD";
                break;
            case OUT:
                salesOutBillPOS = salesOutBillHelper.prefixMatchQuery("id","XSD");
                prefix ="XSD";
                break;

            default:
                salesOutBillPOS = new ArrayList<SalesOutBillPO>();
                prefix ="";
        }

        int num = salesOutBillPOS.size()+1;

        String strNum = ""+num;

        while(strNum.length()<5){
            strNum = "0"+strNum;
        }

        return prefix+"-"+Time.getTimeFormat()+"-"+strNum;
    }
}
