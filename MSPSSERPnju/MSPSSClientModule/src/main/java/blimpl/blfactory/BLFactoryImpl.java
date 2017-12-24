package blimpl.blfactory;

import blimpl.accountblimpl.AccountFactory;
import blimpl.billblimpl.BillFactory;
import blimpl.commodityblimpl.CommodityBLFactory;
import blimpl.customerblimpl.CustomerBLFactory;
import blimpl.logblimpl.LogFactory;
import blimpl.promotionblimpl.PromotionBLFactory;
import blimpl.userblimpl.UserBLFactory;
import blservice.accountblservice.AccountBLInfo;
import blservice.accountblservice.AccountBLService;
import blservice.billblservice.*;
import blservice.blfactoryservice.BLFactoryService;
import blservice.commodityblservice.CommodityBLService;
import blservice.commodityblservice.CommodityInfoService;
import blservice.customerblservice.CustomerBLInfo;
import blservice.customerblservice.CustomerBLService;
import blservice.generalaccountblservice.GeneralAccountBLService;
import blservice.logblservice.LogBLInfo;
import blservice.logblservice.LogBLService;
import blservice.mainblservice.MainBLService;
import blservice.promotionblservice.PromotionBLService;
import blservice.stockbl.StockBLInfo;
import blservice.stockbl.StockBLService;
import blservice.tableblservice.TableBLService;
import blservice.userblservice.UserBLService;
import blservice.userblservice.UserInfo;

/**
 * Description:
 * Created by Hanxinhu at 9:13 2017/11/30/030
 */
public class BLFactoryImpl implements BLFactoryService {
    @Override
    public AccountBLService getAccountBLServiceStub() {
        return AccountFactory.getAccountBLService();
    }

    @Override
    public AccountBLInfo getAccountBLInfo() {
        return AccountFactory.getAccountInfo();
    }

    @Override
    public BillBLInfo getBillInfoStub() {
        return null;
    }

    @Override
    public BillBLService getBillBLServiceStub() {
        return null;
    }

    @Override
    public ManagerBillBLService getManagerBillBLService() {
      return  BillFactory.getManagerBillBLServiceStub();
    }

    @Override
    public StockManagerBillBLService getStockManagerBillBLService() {
        return BillFactory.getStockManagerBillBLService();
    }

    @Override
    public SalesmanBillBLService getSalesmanBillBLService() {
        return BillFactory.getSalesmanBillBLService();
    }

    @Override
    public FinanceBillBLService getFinanceBillBLService() {
        return BillFactory.getFinanceBillBLService();
    }

    @Override
    public CommodityBLService getCommodityBLServiceStub() {
        return CommodityBLFactory.getCommodityBLService();
    }

    @Override
    public CommodityInfoService getCommodityInfoServiceStub() {
        return CommodityBLFactory.getCommodityBLInfo();
    }

    @Override
    public CustomerBLService getCustomerBLServiceStub() {
        return null;
    }

    @Override
    public GeneralAccountBLService getGeneralAccountBLServiceStub() {
        return null;
    }

    @Override
    public LogBLService getLogBLServiceStub() {
        return null;
    }

    @Override
    public MainBLService getMainBLServiceStub() {
        return UserBLFactory.getMainBLService();
    }

    @Override
    public PromotionBLService getPromotionBLServiceStub() {
        return PromotionBLFactory.getPromotionBLServiceStub();
    }

    @Override
    public StockBLInfo getStockBLInfoStub() {
        return null;
    }

    @Override
    public StockBLService getStockBLServiceStub() {
        return null;
    }

    @Override
    public UserBLService getUserBLServiceStub() {
        return UserBLFactory.getUserBLService();
    }

    @Override
    public TableBLService getTableBLServiceStub() {
        return null;
    }

    @Override
    public AccountBLService getAccountBLService() {
        return null;
    }

    @Override
    public BillBLInfo getBillInfo() {
        return null;
    }


    @Override
    public CommodityBLService getCommodityBLService() {
        return null;
    }

    @Override
    public CommodityInfoService getCommodityInfoService() {
        return null;
    }

    @Override
    public CustomerBLService getCustomerBLService() {
        return CustomerBLFactory.getCustomerBLService();
    }

    @Override
    public GeneralAccountBLService getGeneralAccountBLService() {
        return null;
    }

    @Override
    public CustomerBLInfo getCustomerBLInfo() {
        return CustomerBLFactory.getCustomerBLInfo();
    }

    @Override
    public LogBLService getLogBLService() {
        return LogFactory.getLogBLServiceImpl();
    }

    @Override
    public LogBLInfo getLogBLInfo() {
        return LogFactory.getLogBLServiceImpl();
    }

    @Override
    public MainBLService getMainBLService() {
        return null;
    }

    @Override
    public PromotionBLService getPromotionBLService() {
        return PromotionBLFactory.getPromotionBLServiceStub();
    }

    @Override
    public StockBLInfo getStockBLInfo() {
        return null;
    }

    @Override
    public StockBLService getStockBLService() {
        return null;
    }

    @Override
    public UserBLService getUserBLService() {
        return null;
    }

    @Override
    public TableBLService getTableBLService() {
        return null;
    }

    @Override
    public UserInfo getUserInfo() {
        return UserBLFactory.getUserInfo();
    }
}
