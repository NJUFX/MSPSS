package dataservice;


import filterflags.BillFilter;
import po.*;
import util.*;

import java.util.ArrayList;
import java.util.Iterator;

public interface BillDataService {
    /**
     * 添加库存类单据 用于点击保存时
     * @param stockBillPO
     * @return
     */
    public ResultMessage addStockBill(StockBillPO stockBillPO);

    /**
     * 更新库存类单据 用于点击提交时
     * @param stockBillPO
     * @return
     */
    public ResultMessage updateStockBill(StockBillPO stockBillPO);

    /**
     * 删除某单据 未提交状态
     *
     * @param id
     * @return
     */
    public ResultMessage deleteStockBill(String id);

    /**
     *用于查找某一数据
     */
    public ArrayList<StockBillPO> fullSearchStockBill(String field, Object value);


    public ArrayList<StockBillPO> multiSearchStockBill(ArrayList<CriteriaClause> criteriaClauses);


    /**
     * 在数据层增加 现金费用单
     *
     * @param po
     * @return
     */
    public ResultMessage addCashCostBill(CashCostBillPO po);

    /**
     * 在数据层更新 现金费用单
     *
     * @param po
     * @return
     */
    public ResultMessage updateCashCostBill(CashCostBillPO po);

    public ResultMessage deleteCashCostBill(String id);



    public ArrayList<CashCostBillPO> multiSearchCashCostBill(ArrayList<CriteriaClause> criteriaClauses);

    public ArrayList<CashCostBillPO> fullSearchCashCostBill(String field, Object val);


    public ResultMessage addFinanceBill(FinanceBillPO po);

    public ResultMessage updateFinanceBill(FinanceBillPO po);

    public ResultMessage deleteFinanceBill(String id);

    public ArrayList<FinanceBillPO> fullSearchFinanceBill(String field, Object val);

    public ArrayList<FinanceBillPO> multiSearchFinanceBill(ArrayList<CriteriaClause> criteriaClauses);



    public ResultMessage addSalesInBill(SalesInBillPO salesInBillPO);

    public ResultMessage updateSalesInBill(SalesInBillPO salesInBillPO);

    public ResultMessage deleteSalesInBill(String id);

    public ArrayList<SalesInBillPO> fullSearchSalesInBill(String field, Object val);

    public ArrayList<SalesInBillPO> mutilSearchSalesInBill(ArrayList<CriteriaClause> criteriaClauses);




    public ResultMessage addSalesOutBill(SalesOutBillPO salesOutBillPO);

    public ResultMessage updateSalesOutBill(SalesOutBillPO salesOutBillPO);

    public ResultMessage deleteSalesOutBill(String id);

    public ArrayList<SalesOutBillPO> fullSearchSalesOutBill(String field, Object val);

    public ArrayList<SalesOutBillPO> mutilSearchSalesOutBill(ArrayList<CriteriaClause> criteriaClauses);




}


