package network;

import network.billnetworkservice.BillServerNetworkService;
import po.*;
import util.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/24.
 */
public class BillClientNetworkImpl implements BillClientNetworkService{
    private BillServerNetworkService billServerNetworkService;

    public BillClientNetworkImpl(){
        try {
            billServerNetworkService = (BillServerNetworkService) Naming.lookup("BillServerNetworkService");
        } catch (NotBoundException e) {
            System.err.println("Client.network.BillServerNetworkService: Not bound, trying to connect");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加库存类单据 用于点击保存时
     * @param stockBillPO
     * @return
     */
    public ResultMessage addStockBill(StockBillPO stockBillPO){
        try{
            billServerNetworkService.addStockBill(stockBillPO);
            return ResultMessage.SUCCESS;
        }catch (RemoteException e){
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
            billServerNetworkService.updateStockBill(stockBillPO);
            return ResultMessage.SUCCESS;
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.SUCCESS;
    }

    /**
     * 删除某单据 未提交状态
     *
     * @param id
     * @return
     */
    public ResultMessage deleteStockBill(String id){
        try{
            billServerNetworkService.deleteStockBill(id);
            return ResultMessage.SUCCESS;
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    /**
     *用于查找某一数据
     */
    public ArrayList<StockBillPO> fullSearchStockBill(String field, Object value){
        try{
            return billServerNetworkService.fullSearchStockBill(field, value);

        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }


    public ArrayList<StockBillPO> multiSearchStockBill(ArrayList<CriteriaClause> criteriaClauses){
        try{
            return billServerNetworkService.multiSearchStockBill(criteriaClauses);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回形如 KDZSD-20101010-00001
     *
     * @param type
     * @return
     */
    public String getStockBillID(StockBillType type){
        try{
            return billServerNetworkService.getStockBillID(type);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 在数据层增加 现金费用单
     *
     * @param po
     * @return
     */
    public ResultMessage addCashCostBill(CashCostBillPO po){
        try{
            billServerNetworkService.addCashCostBill(po);
            return ResultMessage.SUCCESS;
        }catch (RemoteException e){
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
            billServerNetworkService.updateCashCostBill(po);
            return ResultMessage.SUCCESS;
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage deleteCashCostBill(String id){
        try{
            billServerNetworkService.deleteCashCostBill(id);
            return ResultMessage.SUCCESS;
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    /**
     * 得到应有的现金费用单ID
     *
     * @return
     */
    public String getCashCostBillID(){
      try{
          return billServerNetworkService.getCashCostBillID();
      }catch (RemoteException e){
          e.printStackTrace();
      }
      return null;
    }


    public ArrayList<CashCostBillPO> multiSearchCashCostBill(ArrayList<CriteriaClause> criteriaClauses){
        try{
           return  billServerNetworkService.multiSearchCashCostBill(criteriaClauses);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CashCostBillPO> fullSearchCashCostBill(String field, Object val){
        try{
           return  billServerNetworkService.fullSearchCashCostBill(field, val);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }


    public ResultMessage addFinanceBill(FinanceBillPO po){
        try{
            billServerNetworkService.addFinanceBill(po);
            return ResultMessage.SUCCESS;
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage updateFinanceBill(FinanceBillPO po){
        try{
            billServerNetworkService.updateFinanceBill(po);
            return ResultMessage.SUCCESS;
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage deleteFinanceBill(String id){
        try{
            billServerNetworkService.deleteFinanceBill(id);
            return ResultMessage.SUCCESS;
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ArrayList<FinanceBillPO> fullSearchFinanceBill(String field, Object val){
        try{
           return  billServerNetworkService.fullSearchFinanceBill(field, val);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<FinanceBillPO> multiSearchFinanceBill(ArrayList<CriteriaClause> criteriaClauses){
        try{
          return  billServerNetworkService.multiSearchFinanceBill(criteriaClauses);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据财务类单据类型返回应有的单据
     *
     * @param type
     * @return
     */
    public String getFinanceBillID(FinanceBillType type){
    try{
    billServerNetworkService.getFinanceBillID(type);

    }catch (RemoteException e){
        e.printStackTrace();
    }
    return null;
}

    public ResultMessage addSalesInBill(SalesInBillPO salesInBillPO){
        try{
            billServerNetworkService.addSalesInBill(salesInBillPO);
            return ResultMessage.SUCCESS;
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage updateSalesInBill(SalesInBillPO salesInBillPO){
        try{
            billServerNetworkService.updateSalesInBill(salesInBillPO);
            return ResultMessage.SUCCESS;
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public ResultMessage deleteSalesInBill(String id){
        try{
            billServerNetworkService.deleteSalesInBill(id);
            return ResultMessage.SUCCESS;
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ArrayList<SalesInBillPO> fullSearchSalesInBill(String field, Object val){
        try{
           return  billServerNetworkService.fullSearchSalesInBill(field, val);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<SalesInBillPO> mutilSearchSalesInBill(ArrayList<CriteriaClause> criteriaClauses){
        try{
           return  billServerNetworkService.mutilSearchSalesInBill(criteriaClauses);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据进货单 进货退货单来返回应有的ID
     *
     * @param type
     * @return
     */
    public String getSalesInBillID(SalesInBillType type){
        try{
           return billServerNetworkService.getSalesInBillID(type);
        }catch (RemoteException e){
            e.printStackTrace();

        }
        return null;
     }


    public ResultMessage addSalesOutBill(SalesOutBillPO salesOutBillPO){
        try{
            billServerNetworkService.addSalesOutBill(salesOutBillPO);
            return ResultMessage.SUCCESS;
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage updateSalesOutBill(SalesOutBillPO salesOutBillPO){
        try{
            billServerNetworkService.updateSalesOutBill(salesOutBillPO);
            return ResultMessage.SUCCESS;
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage deleteSalesOutBill(String id){
        try{
            billServerNetworkService.deleteSalesOutBill(id);
            return ResultMessage.SUCCESS;
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ArrayList<SalesOutBillPO> fullSearchSalesOutBill(String field, Object val){
        try{
            return billServerNetworkService.fullSearchSalesOutBill(field, val);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<SalesOutBillPO> mutilSearchSalesOutBill(ArrayList<CriteriaClause> criteriaClauses){
        try{
           return  billServerNetworkService.mutilSearchSalesOutBill(criteriaClauses);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public String getSalesOutBillID(SalesOutBillType type) {
        try {
            billServerNetworkService.getSalesOutBillID(type);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultMessage addAlarmBill(AlarmBillPO po) {
        return null;
    }

    /**
     * 用来根据前缀来得到某天的产生的库存报警单
     *
     * @param field
     * @param val
     * @return
     */
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
