
package blstubdriver.tablestubdriver;

import blservice.tableblservice.TableBLService;
import util.Time;
import vo.*;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class Table_Stub implements TableBLService {
    @Override
    public BusinessTableVO checkBusinessTable(Time begin, Time end) {
        return null;
    }

//    @Override
//    public BusinessTableVO compareBTByTime(BusinessTableVO businesstable) {
//        return null;
//    }

    @Override
    public ProcessTableVO checkProcessTable(ProcessTableFilterFlagsVO flags) {
        return null;
    }


    public ProcessTableVO comparePTByName(ProcessTableVO processtable) {
        return null;
    }

    @Override
    public ProcessTableVO comparePTByTime(ProcessTableVO processtable) {
        return null;
    }

    @Override
    public SaleTableVO checkSaleTable(SaleTableFilterFlagsVO flags) {
        return null;
    }


    public SaleTableVO compareSTByName(SaleTableVO saletable) {
        return null;
    }

    @Override
    public SaleTableVO compareSTByTime(SaleTableVO saletable) {
        return null;
    }

    @Override
    public void exportBusinessTable(BusinessTableVO businesstable) {

    }

    @Override
    public void exportProcessTable(ProcessTableVO processtable) {

    }

    @Override
    public void exportSaleTable(SaleTableVO saletable) {

    }


}

