package network.billnetworkservice;

import po.*;
import util.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/24.
 */
public interface BillServerNetworkService {
    /**
     * 添加库存类单据 用于点击保存时
     * @param stockBillPO
     * @return
     */
    public ResultMessage addStockBill(StockBillPO stockBillPO)throws RemoteException;

    /**
     * 更新库存类单据 用于点击提交时
     * @param stockBillPO
     * @return
     */
    public ResultMessage updateStockBill(StockBillPO stockBillPO)throws RemoteException;

    /**
     * 删除某单据 未提交状态
     *
     * @param id
     * @return
     */
    public ResultMessage deleteStockBill(String id)throws RemoteException;

    /**
     *用于查找某一数据
     */
    public ArrayList<StockBillPO> fullSearchStockBill(String field, Object value)throws RemoteException;


    public ArrayList<StockBillPO> multiSearchStockBill(ArrayList<CriteriaClause> criteriaClauses)throws RemoteException;


    /**
     * 在数据层增加 现金费用单
     *
     * @param po
     * @return
     */
    public ResultMessage addCashCostBill(CashCostBillPO po)throws RemoteException;

    /**
     * 在数据层更新 现金费用单
     *
     * @param po
     * @return
     */
    public ResultMessage updateCashCostBill(CashCostBillPO po)throws RemoteException;

    public ResultMessage deleteCashCostBill(String id)throws RemoteException;


    public ArrayList<CashCostBillPO> multiSearchCashCostBill(ArrayList<CriteriaClause> criteriaClauses)throws RemoteException;

    public ArrayList<CashCostBillPO> fullSearchCashCostBill(String field, Object val)throws RemoteException;


    public ResultMessage addFinanceBill(FinanceBillPO po)throws RemoteException;

    public ResultMessage updateFinanceBill(FinanceBillPO po)throws RemoteException;

    public ResultMessage deleteFinanceBill(String id)throws RemoteException;

    public ArrayList<FinanceBillPO> fullSearchFinanceBill(String field, Object val)throws RemoteException;

    public ArrayList<FinanceBillPO> multiSearchFinanceBill(ArrayList<CriteriaClause> criteriaClauses)throws RemoteException;


    public ResultMessage addSalesInBill(SalesInBillPO salesInBillPO)throws RemoteException;

    public ResultMessage updateSalesInBill(SalesInBillPO salesInBillPO)throws RemoteException;

    public ResultMessage deleteSalesInBill(String id)throws RemoteException;

    public ArrayList<SalesInBillPO> fullSearchSalesInBill(String field, Object val)throws RemoteException;

    public ArrayList<SalesInBillPO> mutilSearchSalesInBill(ArrayList<CriteriaClause> criteriaClauses)throws RemoteException;


    public ResultMessage addSalesOutBill(SalesOutBillPO salesOutBillPO)throws RemoteException;

    public ResultMessage updateSalesOutBill(SalesOutBillPO salesOutBillPO)throws RemoteException;

    public ResultMessage deleteSalesOutBill(String id)throws RemoteException;

    public ArrayList<SalesOutBillPO> fullSearchSalesOutBill(String field, Object val)throws RemoteException;

    public ArrayList<SalesOutBillPO> mutilSearchSalesOutBill(ArrayList<CriteriaClause> criteriaClauses)throws RemoteException;


}
