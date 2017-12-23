package blimpl.tableblimpl;

import blservice.tableblservice.TableBLService;
import filterflags.BusinessTableFilterFlags;
import filterflags.ProcessTableFilterFlags;
import filterflags.SaleTableFilterFlags;
import util.Time;
import vo.*;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class TableBLServiceImpl implements TableBLService {
    BusinessTable businessTable;
    SaleTable saleTable;
    ProcessTable processTable;

    public TableBLServiceImpl(BusinessTable businessTable, SaleTable saleTable, ProcessTable processTable) {
        this.businessTable = businessTable;
        this.saleTable = saleTable;
        this.processTable = processTable;
    }



    @Override
    public BusinessTableVO checkBusinessTable(Time begin, Time end) {

         return businessTable.search(begin,end);
    }

    @Override
    public BusinessTableVO compareBTByTime(BusinessTableVO businesstable) {

        return  businesstable.compareByTime(businesstable);
    }

    @Override
    public ProcessTableVO checkProcessTable(ProcessTableFilterFlagsVO flags) {

        return  MyTable.checkProcessTable(flags);
    }

    @Override
    public ProcessTableVO comparePTByName(ProcessTableVO processtable) {

        return  MyTable.comparePTByTime(processtable);
    }

    @Override
    public ProcessTableVO comparePTByTime(ProcessTableVO processtable) {

        return MyTable.comparePTByTime(processtable);
    }

    @Override
    public SaleTableVO checkSaleTable(SaleTableFilterFlagsVO flags) {

        return  MyTable.checkSaleTable(flags);
    }

    @Override
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
