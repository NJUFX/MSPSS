package blimpl.blfactory;

import blimpl.accountblimpl.AccountFactory;
import blimpl.billblimpl.BillFactory;
import blimpl.commodityblimpl.CommodityBLFactory;
import blimpl.customerblimpl.CustomerBLFactory;
import blimpl.generalaccountblimpl.GeneralAccountBLFactory;
import blimpl.logblimpl.LogFactory;
import blimpl.promotionblimpl.PromotionBLFactory;
import blimpl.stockblimpl.StockBLFactory;
import blimpl.tableblimpl.TableBLFactory;
import blimpl.userblimpl.UserBLFactory;
import blservice.accountblservice.AccountBLInfo;
import blservice.accountblservice.AccountBLService;
import blservice.billblservice.FinanceBillBLService;
import blservice.billblservice.ManagerBillBLService;
import blservice.billblservice.SalesmanBillBLService;
import blservice.billblservice.StockManagerBillBLService;
import blservice.blfactoryservice.BLFactoryService;
import blservice.commodityblservice.CommodityBLService;
import blservice.commodityblservice.CommodityInfoService;
import blservice.customerblservice.CustomerBLInfo;
import blservice.customerblservice.CustomerBLService;
import blservice.generalaccountblservice.GeneralAccountBLService;
import blservice.logblservice.LogBLInfo;
import blservice.logblservice.LogBLService;
import blservice.mainblservice.MainBLService;
import blservice.promotionblservice.PromotionBLInfo;
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
    public ManagerBillBLService getManagerBillBLService() {
        return BillFactory.getManagerBillBLService();
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
        return CustomerBLFactory.getCustomerBLService();
    }

    @Override
    public GeneralAccountBLService getGeneralAccountBLServiceStub() {
        return GeneralAccountBLFactory.getGeneralAccountBLService();
    }

    @Override
    public LogBLService getLogBLServiceStub() {
        return LogFactory.getLogBLService();
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
        return StockBLFactory.getStockBLInfo();
    }

    @Override
    public StockBLService getStockBLServiceStub() {
        return StockBLFactory.getStockBLService();
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
        return AccountFactory.getAccountBLService();
    }


    @Override
    public CommodityBLService getCommodityBLService() {
        return CommodityBLFactory.getCommodityBLService();
    }

    @Override
    public CommodityInfoService getCommodityInfoService() {
        return CommodityBLFactory.getCommodityBLInfo();
    }

    @Override
    public CustomerBLService getCustomerBLService() {
        return CustomerBLFactory.getCustomerBLService();
    }

    @Override
    public GeneralAccountBLService getGeneralAccountBLService() {
        return GeneralAccountBLFactory.getGeneralAccountBLService();
    }

    @Override
    public CustomerBLInfo getCustomerBLInfo() {
        return CustomerBLFactory.getCustomerBLInfo();
    }

    @Override
    public LogBLService getLogBLService() {
        return LogFactory.getLogBLService();
    }

    @Override
    public LogBLInfo getLogBLInfo() {
        return LogFactory.getLogBLInfo();
    }

    @Override
    public MainBLService getMainBLService() {
        return UserBLFactory.getMainBLService();
    }

    @Override
    public PromotionBLService getPromotionBLService() {
        return PromotionBLFactory.getPromotionBLService();
    }

    @Override
    public StockBLInfo getStockBLInfo() {
        return StockBLFactory.getStockBLInfo();
    }

    @Override
    public StockBLService getStockBLService() {
        return StockBLFactory.getStockBLService();
    }

    @Override
    public UserBLService getUserBLService() {
        return UserBLFactory.getUserBLService();
    }

    @Override
    public TableBLService getTableBLService() {
        return TableBLFactory.getTableBLService();
    }

    @Override
    public PromotionBLInfo getPromotionBLInfo() {
        return PromotionBLFactory.getPromotionInfo();
    }

    @Override
    public UserInfo getUserInfo() {
        return UserBLFactory.getUserInfo();
    }
}
