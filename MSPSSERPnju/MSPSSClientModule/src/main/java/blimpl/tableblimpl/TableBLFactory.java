package blimpl.tableblimpl;

import blimpl.tableblimpl.TableBLServiceImpl;
import blservice.tableblservice.TableBLService;

/**
 * Created by thinkpad on 2017/12/28.
 */
public class TableBLFactory {

    private static TableBLService tableBLService;
    private static BusinessTable businessTable = new BusinessTable();
    private static ProcessTable processTable = new ProcessTable();
    private static SaleTable saleTable = new SaleTable();
    public synchronized static TableBLService getTableBLService(){
        if(tableBLService==null){
            tableBLService = new TableBLServiceImpl(businessTable,saleTable,processTable);
        }
        return tableBLService;

    }
}
