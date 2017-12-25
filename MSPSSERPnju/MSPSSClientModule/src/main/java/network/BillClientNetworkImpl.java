package network;

import po.*;
import util.*;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/24.
 */
public class BillClientNetworkImpl implements BillClientNetworkService {
    /**
     * 添加库存类单据 用于点击保存时
     *
     * @param stockBillPO
     * @return
     */
    @Override
    public ResultMessage addStockBill(StockBillPO stockBillPO) {
        return null;
    }

    /**
     * 更新库存类单据 用于点击提交时
     *
     * @param stockBillPO
     * @return
     */
    @Override
    public ResultMessage updateStockBill(StockBillPO stockBillPO) {
        return null;
    }

    /**
     * 删除某单据 未提交状态
     *
     * @param id
     * @return
     */
    @Override
    public ResultMessage deleteStockBill(String id) {
        return null;
    }

    /**
     * 用于查找某一数据
     *
     * @param field
     * @param value
     */
    @Override
    public ArrayList<StockBillPO> fullSearchStockBill(String field, Object value) {
        return null;
    }

    @Override
    public ArrayList<StockBillPO> multiSearchStockBill(ArrayList<CriteriaClause> criteriaClauses) {
        return null;
    }

    /**
     * 返回形如 KDZSD-20101010-00001
     *
     * @param type
     * @return
     */
    @Override
    public String getStockBillID(StockBillType type) {
        return null;
    }

    /**
     * 在数据层增加 现金费用单
     *
     * @param po
     * @return
     */
    @Override
    public ResultMessage addCashCostBill(CashCostBillPO po) {
        return null;
    }

    /**
     * 在数据层更新 现金费用单
     *
     * @param po
     * @return
     */
    @Override
    public ResultMessage updateCashCostBill(CashCostBillPO po) {
        return null;
    }

    @Override
    public ResultMessage deleteCashCostBill(String id) {
        return null;
    }

    /**
     * 得到应有的现金费用单ID
     *
     * @return
     */
    @Override
    public String getCashCostBillID() {
        return null;
    }

    @Override
    public ArrayList<CashCostBillPO> multiSearchCashCostBill(ArrayList<CriteriaClause> criteriaClauses) {
        return null;
    }

    @Override
    public ArrayList<CashCostBillPO> fullSearchCashCostBill(String field, Object val) {
        return null;
    }

    @Override
    public ResultMessage addFinanceBill(FinanceBillPO po) {
        return null;
    }

    @Override
    public ResultMessage updateFinanceBill(FinanceBillPO po) {
        return null;
    }

    @Override
    public ResultMessage deleteFinanceBill(String id) {
        return null;
    }

    @Override
    public ArrayList<FinanceBillPO> fullSearchFinanceBill(String field, Object val) {
        return null;
    }

    @Override
    public ArrayList<FinanceBillPO> multiSearchFinanceBill(ArrayList<CriteriaClause> criteriaClauses) {
        return null;
    }

    /**
     * 根据财务类单据类型返回应有的单据
     *
     * @param type
     * @return
     */
    @Override
    public String getFinanceBillID(FinanceBillType type) {
        return null;
    }

    @Override
    public ResultMessage addSalesInBill(SalesInBillPO salesInBillPO) {
        return null;
    }

    @Override
    public ResultMessage updateSalesInBill(SalesInBillPO salesInBillPO) {
        return null;
    }

    @Override
    public ResultMessage deleteSalesInBill(String id) {
        return null;
    }

    @Override
    public ArrayList<SalesInBillPO> fullSearchSalesInBill(String field, Object val) {
        return null;
    }

    @Override
    public ArrayList<SalesInBillPO> mutilSearchSalesInBill(ArrayList<CriteriaClause> criteriaClauses) {
        return null;
    }

    /**
     * 根据进货单 进货退货单来返回应有的ID
     *
     * @param type
     * @return
     */
    @Override
    public String getSalesInBillID(SalesInBillType type) {
        return null;
    }

    @Override
    public ResultMessage addSalesOutBill(SalesOutBillPO salesOutBillPO) {
        return null;
    }

    @Override
    public ResultMessage updateSalesOutBill(SalesOutBillPO salesOutBillPO) {
        return null;
    }

    @Override
    public ResultMessage deleteSalesOutBill(String id) {
        return null;
    }

    @Override
    public ArrayList<SalesOutBillPO> fullSearchSalesOutBill(String field, Object val) {
        return null;
    }

    @Override
    public ArrayList<SalesOutBillPO> mutilSearchSalesOutBill(ArrayList<CriteriaClause> criteriaClauses) {
        return null;
    }

    @Override
    public String getSalesOutBillID(SalesOutBillType type) {
        return null;
    }

    @Override
    public ResultMessage addAlarmBill(AlarmBillPO po) {
        return null;
    }

    @Override
    public ArrayList<AlarmBillPO> prefixSearchAlarmBill(String field, String val) {
        return null;
    }

    /**
     * 得到库存报警单应有的数据
     *
     * @return
     */
    @Override
    public String getAlarmID() {
        return null;
    }
}
