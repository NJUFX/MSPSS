package blservice.blfactoryservice;


import blservice.accountblservice.AccountBLService;
import blservice.billblservice.BillBLInfo;
import blservice.billblservice.BillBLService;
import blservice.commodityblservice.CommodityBLService;
import blservice.commodityblservice.CommodityInfoService;
import blservice.customerblservice.CustomerBLService;
import blservice.generalaccountblservice.GeneralAccountBLService;
import blservice.logblservice.LogBLService;
import blservice.mainblservice.MainBLService;
import blservice.promotionblservice.PromotionBLService;
import blservice.stockbl.StockBLInfo;
import blservice.stockbl.StockBLService;
import blservice.tableblservice.TableBLService;
import blservice.userblservice.UserBLService;

/**
 * Description:
 * Created by Hanxinhu at 9:02 2017/11/30/030
 */
public interface BLFactoryService {
    public AccountBLService getAccountBLService();

    public BillBLInfo getBillInfo();

    public BillBLService getBillBLService();

    public CommodityBLService getComodityBLService();

    public CommodityInfoService getCommodityInfoService();

    public CustomerBLService getCustomerBLService();

    public GeneralAccountBLService getGeneralAccountBLService();

    public LogBLService getLogBLService();

    public MainBLService getMainBLService();

    public PromotionBLService getPromotionBLService();

    public StockBLInfo getStockBLInfo();

    public StockBLService getStockBLService();

    public UserBLService getUserBLService();

    public TableBLService getTableBLService();

}
