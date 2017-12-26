package network.billnetworkservice;

import com.sun.org.apache.regexp.internal.RE;
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
     * 范围查找
     * @param field
     * @param max
     * @param min
     * @return
     */
    public ArrayList<StockBillPO> rangeSearchStockBill(String field,Object max,Object min)throws RemoteException;
    /**
     * 返回形如 KDZSD-20101010-00001
     *
     * @param type
     * @return
     */
    public String getStockBillID(StockBillType type)throws RemoteException;
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
    /**
     * 范围查找
     * @param field
     * @param max
     * @param min
     * @return
     */
    public ArrayList<CashCostBillPO> rangeSearchCashCostBill(String field,Object max,Object min)throws RemoteException;
    /**
     * 得到应有的现金费用单ID
     *
     * @return
     */
    public String getCashCostBillID()throws RemoteException;


    public ResultMessage addFinanceBill(FinanceBillPO po)throws RemoteException;

    public ResultMessage updateFinanceBill(FinanceBillPO po)throws RemoteException;

    public ResultMessage deleteFinanceBill(String id)throws RemoteException;

    public ArrayList<FinanceBillPO> fullSearchFinanceBill(String field, Object val)throws RemoteException;

    public ArrayList<FinanceBillPO> multiSearchFinanceBill(ArrayList<CriteriaClause> criteriaClauses)throws RemoteException;
    /**
     * 范围查找
     * @param field
     * @param max
     * @param min
     * @return
     */
    public ArrayList<FinanceBillPO> rangeSearchFinanceBill(String field,Object max,Object min)throws RemoteException;
    /**
     * 根据财务类单据类型返回应有的单据
     *
     * @param type
     * @return
     */
    public String getFinanceBillID(FinanceBillType type)throws RemoteException;

    public ResultMessage addSalesInBill(SalesInBillPO salesInBillPO)throws RemoteException;

    public ResultMessage updateSalesInBill(SalesInBillPO salesInBillPO)throws RemoteException;

    public ResultMessage deleteSalesInBill(String id)throws RemoteException;

    public ArrayList<SalesInBillPO> fullSearchSalesInBill(String field, Object val)throws RemoteException;

    public ArrayList<SalesInBillPO> mutilSearchSalesInBill(ArrayList<CriteriaClause> criteriaClauses)throws RemoteException;
    /**
     * 范围查找
     * @param field
     * @param max
     * @param min
     * @return
     */
    public ArrayList<SalesInBillPO> rangeSearchSalesInBill(String field,Object max,Object min)throws RemoteException;

    public String getSalesInBillID(SalesInBillType type)throws RemoteException;
    public ResultMessage addSalesOutBill(SalesOutBillPO salesOutBillPO)throws RemoteException;

    public ResultMessage updateSalesOutBill(SalesOutBillPO salesOutBillPO)throws RemoteException;

    public ResultMessage deleteSalesOutBill(String id)throws RemoteException;

    public ArrayList<SalesOutBillPO> fullSearchSalesOutBill(String field, Object val)throws RemoteException;

    public ArrayList<SalesOutBillPO> mutilSearchSalesOutBill(ArrayList<CriteriaClause> criteriaClauses)throws RemoteException;
    /**
     * 范围查找
     * @param field
     * @param max
     * @param min
     * @return
     */
    public ArrayList<SalesOutBillPO> rangeSearchSalesOutBill(String field,Object max,Object min)throws RemoteException;

    public String getSalesOutBillID(SalesOutBillType type)throws RemoteException;

    public ResultMessage addAlarmBill(AlarmBillPO po)throws RemoteException;

    /**
     * 用来根据前缀来得到某天的产生的库存报警单
     *
     * @param field
     * @param val
     * @return
     */
    public ArrayList<AlarmBillPO> prefixSearchAlarmBill(String field, String val)throws RemoteException;

    /**
     * 得到库存报警单应有的数据
     *
     * @return
     */
    public String getAlarmID()throws RemoteException;

}
