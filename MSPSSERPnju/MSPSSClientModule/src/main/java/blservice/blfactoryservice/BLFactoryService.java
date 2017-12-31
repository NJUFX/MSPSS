package blservice.blfactoryservice;


import blservice.accountblservice.AccountBLInfo;
import blservice.accountblservice.AccountBLService;
import blservice.billblservice.FinanceBillBLService;
import blservice.billblservice.ManagerBillBLService;
import blservice.billblservice.SalesmanBillBLService;
import blservice.billblservice.StockManagerBillBLService;
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
 * Created by Hanxinhu at 9:02 2017/11/30/030
 */
public interface BLFactoryService {
    public AccountBLService getAccountBLService();

    public AccountBLInfo getAccountBLInfo();

    public StockManagerBillBLService getStockManagerBillBLService();

    public SalesmanBillBLService getSalesmanBillBLService();

    public ManagerBillBLService getManagerBillBLService();

    public FinanceBillBLService getFinanceBillBLService();

    public CommodityBLService getCommodityBLService();

    public CommodityInfoService getCommodityInfoService();

    public CustomerBLService getCustomerBLService();

    public CustomerBLInfo getCustomerBLInfo();

    public GeneralAccountBLService getGeneralAccountBLService();

    public LogBLService getLogBLService();

    public LogBLInfo getLogBLInfo();

    public MainBLService getMainBLService();

    public PromotionBLService getPromotionBLService();

    public StockBLInfo getStockBLInfo();

    public StockBLService getStockBLService();

    public UserBLService getUserBLService();

    public UserInfo getUserInfo();

    public TableBLService getTableBLService();

    public PromotionBLInfo getPromotionBLInfo();


    //stub
    public AccountBLService getAccountBLServiceStub();


    public CommodityBLService getCommodityBLServiceStub();

    public CommodityInfoService getCommodityInfoServiceStub();

    public CustomerBLService getCustomerBLServiceStub();

    public GeneralAccountBLService getGeneralAccountBLServiceStub();

    public LogBLService getLogBLServiceStub();

    public MainBLService getMainBLServiceStub();

    public PromotionBLService getPromotionBLServiceStub();

    public StockBLInfo getStockBLInfoStub();

    public StockBLService getStockBLServiceStub();

    public UserBLService getUserBLServiceStub();

    public TableBLService getTableBLServiceStub();
}
