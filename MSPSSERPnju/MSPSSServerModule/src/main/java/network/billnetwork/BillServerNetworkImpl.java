package network.billnetwork;

import dataimpl.billdataimpl.BillDataServiceFactory;
import dataservice.BillDataService;
import network.billnetworkservice.BillServerNetworkService;
import po.*;
import util.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/25.
 */
public class BillServerNetworkImpl  extends UnicastRemoteObject implements BillServerNetworkService {
    private BillDataService billDataService;

    public BillServerNetworkImpl() throws RemoteException {
        billDataService = BillDataServiceFactory.getBillDataService();
    }
    /**
     * 添加库存类单据 用于点击保存时
     * @param stockBillPO
     * @return
     */
    public ResultMessage addStockBill(StockBillPO stockBillPO)throws RemoteException{
        return billDataService.addStockBill(stockBillPO);
    }

    /**
     * 更新库存类单据 用于点击提交时
     * @param stockBillPO
     * @return
     */
    public ResultMessage updateStockBill(StockBillPO stockBillPO)throws RemoteException{
        return billDataService.updateStockBill(stockBillPO);
    }

    /**
     * 删除某单据 未提交状态
     *
     * @param id
     * @return
     */
    public ResultMessage deleteStockBill(String id)throws RemoteException{
        return billDataService.deleteStockBill(id);
    }

    /**
     *用于查找某一数据
     */
    public ArrayList<StockBillPO> fullSearchStockBill(String field, Object value)throws RemoteException{
        return billDataService.fullSearchStockBill(field, value);
    }


    public ArrayList<StockBillPO> multiSearchStockBill(ArrayList<CriteriaClause> criteriaClauses)throws RemoteException{
        return billDataService.multiSearchStockBill(criteriaClauses);
    }

    /**
     * 范围查找
     * @param field
     * @param max
     * @param min
     * @return
     */
    public ArrayList<StockBillPO> rangeSearchStockBill(String field,Object max,Object min)throws RemoteException{
        return billDataService.rangeSearchStockBill(field, max, min);
    }

    /**
     * 返回形如 KDZSD-20101010-00001
     *
     * @param type
     * @return
     */
    public String getStockBillID(StockBillType type)throws RemoteException{
        return billDataService.getStockBillID(type);
    }

    /**
     * 在数据层增加 现金费用单
     *
     * @param po
     * @return
     */
    public ResultMessage addCashCostBill(CashCostBillPO po)throws RemoteException{
        return billDataService.addCashCostBill(po);
    }

    /**
     * 在数据层更新 现金费用单
     *
     * @param po
     * @return
     */
    public ResultMessage updateCashCostBill(CashCostBillPO po)throws RemoteException{
        return billDataService.updateCashCostBill(po);
    }

    public ResultMessage deleteCashCostBill(String id)throws RemoteException{
        return billDataService.deleteCashCostBill(id);
    }



    public ArrayList<CashCostBillPO> multiSearchCashCostBill(ArrayList<CriteriaClause> criteriaClauses)throws RemoteException{
        return billDataService.multiSearchCashCostBill(criteriaClauses);
    }

    public ArrayList<CashCostBillPO> fullSearchCashCostBill(String field, Object val)throws RemoteException{
        return billDataService.fullSearchCashCostBill(field, val);
    }

    /**
     * 范围查找
     * @param field
     * @param max
     * @param min
     * @return
     */
    public ArrayList<CashCostBillPO> rangeSearchCashCostBill(String field,Object max,Object min)throws RemoteException{
        return billDataService.rangeSearchCashCostBill(field, max, min);
    }

    /**
     * 得到应有的现金费用单ID
     *
     * @return
     */
    public String getCashCostBillID()throws RemoteException{
        return billDataService.getCashCostBillID();
    }

    public ResultMessage addFinanceBill(FinanceBillPO po)throws RemoteException{
        return billDataService.addFinanceBill(po);
    }

    public ResultMessage updateFinanceBill(FinanceBillPO po)throws RemoteException{
        return billDataService.updateFinanceBill(po);
    }

    public ResultMessage deleteFinanceBill(String id)throws RemoteException{
        return billDataService.deleteFinanceBill(id);
    }

    public ArrayList<FinanceBillPO> fullSearchFinanceBill(String field, Object val)throws RemoteException{
        return billDataService.fullSearchFinanceBill(field, val);
    }

    public ArrayList<FinanceBillPO> multiSearchFinanceBill(ArrayList<CriteriaClause> criteriaClauses)throws RemoteException{
        return billDataService.multiSearchFinanceBill(criteriaClauses);
    }

    /**
     * 范围查找
     * @param field
     * @param max
     * @param min
     * @return
     */
    public ArrayList<FinanceBillPO> rangeSearchFinanceBill(String field,Object max,Object min)throws RemoteException{
        return billDataService.rangeSearchFinanceBill(field, max, min);
    }

    /**
     * 根据财务类单据类型返回应有的单据
     *
     * @param type
     * @return
     */
    public String getFinanceBillID(FinanceBillType type)throws RemoteException{
        return billDataService.getFinanceBillID(type);
    }

    public ResultMessage addSalesInBill(SalesInBillPO salesInBillPO)throws RemoteException{
        return billDataService.addSalesInBill(salesInBillPO);
    }

    public ResultMessage updateSalesInBill(SalesInBillPO salesInBillPO)throws RemoteException{
        return billDataService.updateSalesInBill(salesInBillPO);
    }

    public ResultMessage deleteSalesInBill(String id)throws RemoteException{
        return billDataService.deleteSalesInBill(id);
    }

    public ArrayList<SalesInBillPO> fullSearchSalesInBill(String field, Object val)throws RemoteException{
        return billDataService.fullSearchSalesInBill(field, val);
    }

    public ArrayList<SalesInBillPO> mutilSearchSalesInBill(ArrayList<CriteriaClause> criteriaClauses)throws RemoteException{
        return billDataService.mutilSearchSalesInBill(criteriaClauses);
    }
    /**
     * 范围查找
     * @param field
     * @param max
     * @param min
     * @return
     */
    public ArrayList<SalesInBillPO> rangeSearchSalesInBill(String field,Object max,Object min)throws RemoteException{
        return billDataService.rangeSearchSalesInBill(field, max, min);
    }


    public String getSalesInBillID(SalesInBillType type)throws RemoteException{
        return billDataService.getSalesInBillID(type);
    }

    public ResultMessage addSalesOutBill(SalesOutBillPO salesOutBillPO)throws RemoteException{
        return billDataService.addSalesOutBill(salesOutBillPO);
    }

    public ResultMessage updateSalesOutBill(SalesOutBillPO salesOutBillPO)throws RemoteException{
        return billDataService.updateSalesOutBill(salesOutBillPO);
    }

    public ResultMessage deleteSalesOutBill(String id)throws RemoteException{
        return billDataService.deleteSalesOutBill(id);
    }

    public ArrayList<SalesOutBillPO> fullSearchSalesOutBill(String field, Object val)throws RemoteException{
        return billDataService.fullSearchSalesOutBill(field, val);
    }

    public ArrayList<SalesOutBillPO> mutilSearchSalesOutBill(ArrayList<CriteriaClause> criteriaClauses)throws RemoteException{
        return billDataService.mutilSearchSalesOutBill(criteriaClauses);
    }
    /**
     * 范围查找
     * @param field
     * @param max
     * @param min
     * @return
     */
    public ArrayList<SalesOutBillPO> rangeSearchSalesOutBill(String field,Object max,Object min)throws RemoteException{
        return billDataService.rangeSearchSalesOutBill(field, max, min);
    }

    public String getSalesOutBillID(SalesOutBillType type)throws RemoteException{
        return billDataService.getSalesOutBillID(type);
    }


    public ResultMessage addAlarmBill(AlarmBillPO po)throws RemoteException{
        return billDataService.addAlarmBill(po);
    }

    /**
     * 用来根据前缀来得到某天的产生的库存报警单
     *
     * @param field
     * @param val
     * @return
     */
    public ArrayList<AlarmBillPO> prefixSearchAlarmBill(String field, String val)throws RemoteException{
        return billDataService.prefixSearchAlarmBill(field, val);
    }

    /**
     * 得到库存报警单应有的数据
     *
     * @return
     */
    public String getAlarmID()throws RemoteException{
        return billDataService.getAlarmID();
    }
}
