<<<<<<< HEAD
package blstubdriver.tablestubdriver;

import blservice.tableblservice.TableBLService;
import filterflags.BusinessTableFilterFlags;
import filterflags.ProcessTableFilterFlags;
import filterflags.SaleTableFilterFlags;
import util.Time;
import vo.*;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class Table_Stub implements TableBLService{
    @Override
    public BusinessTableVO checkBusinessTable(Time begin, Time end) {
        return null;
    }


    @Override
    public ProcessTableVO checkProcessTable(ProcessTableFilterFlagsVO flags) {
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
=======
//package blstubdriver.tablestubdriver;
//
//import blservice.tableblservice.TableBLService;
//import filterflags.BusinessTableFilterFlags;
//import filterflags.ProcessTableFilterFlags;
//import filterflags.SaleTableFilterFlags;
//import util.Time;
//import vo.*;
//
///**
// * Created by thinkpad on 2017/11/11.
// */
//public class Table_Stub implements TableBLService{
//    @Override
//    public BusinessTableVO checkBusinessTable(Time begin, Time end) {
//        return null;
//    }
//
////    @Override
////    public BusinessTableVO compareBTByTime(BusinessTableVO businesstable) {
////        return null;
////    }
//
//    @Override
//    public ProcessTableVO checkProcessTable(ProcessTableFilterFlagsVO flags) {
//        return null;
//    }
//
//    @Override
//    public ProcessTableVO comparePTByName(ProcessTableVO processtable) {
//        return null;
//    }
//
//    @Override
//    public ProcessTableVO comparePTByTime(ProcessTableVO processtable) {
//        return null;
//    }
//
//    @Override
//    public SaleTableVO checkSaleTable(SaleTableFilterFlagsVO flags) {
//        return null;
//    }
//
//    @Override
//    public SaleTableVO compareSTByName(SaleTableVO saletable) {
//        return null;
//    }
//
//    @Override
//    public SaleTableVO compareSTByTime(SaleTableVO saletable) {
//        return null;
//    }
//
//    @Override
//    public void exportBusinessTable(BusinessTableVO businesstable) {
//
//    }
//
//    @Override
//    public void exportProcessTable(ProcessTableVO processtable) {
//
//    }
//
//    @Override
//    public void exportSaleTable(SaleTableVO saletable) {
//
//    }
//
//
//}
>>>>>>> f59cd79e654dc4bb5f11a08c12ba490088ef5c62
