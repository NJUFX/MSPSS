package blimpl.blfactory;

import blimpl.commodityblimpl.CommodityBLFactory;
import blimpl.logblimpl.LogFactory;
import blservice.accountblservice.AccountBLInfo;
import blimpl.accountblimpl.AccountFactory;
import blservice.accountblservice.AccountBLService;
import blservice.billblservice.BillBLInfo;
import blservice.billblservice.BillBLService;
import blservice.blfactoryservice.BLFactoryService;
import blservice.commodityblservice.CommodityBLService;
import blservice.commodityblservice.CommodityInfoService;
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
    public CommodityBLService getCommodityBLServiceStub() {
        return CommodityBLFactory.getCommodityBLImpl();
    }

    @Override
    public CommodityInfoService getCommodityInfoServiceStub() {
        return CommodityBLFactory.getCommodityBLImpl();
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
        return null;
    }

    @Override
    public PromotionBLService getPromotionBLServiceStub() {
        return null;
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
        return null;
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
    public BillBLService getBillBLService() {
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
        return null;
    }

    @Override
    public GeneralAccountBLService getGeneralAccountBLService() {
        return null;
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
        return null;
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





}
