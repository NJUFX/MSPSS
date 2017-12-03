package blimpl.blfactory;

import blservice.accountblservice.AccountBLService;
import blservice.billblservice.BillBLInfo;
import blservice.billblservice.BillBLService;
import blservice.blfactoryservice.BLFactoryService;
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
 * Created by Hanxinhu at 9:13 2017/11/30/030
 */
public class BLFactory implements BLFactoryService {
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
    public CommodityBLService getComodityBLService() {
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
        return null;
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
