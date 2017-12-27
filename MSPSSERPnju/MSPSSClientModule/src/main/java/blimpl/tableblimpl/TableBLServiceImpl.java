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
    BusinessTable businessTableTool;
    SaleTable saleTableTool;
    ProcessTable processTableTool;

    public TableBLServiceImpl(BusinessTable businessTableTool, SaleTable saleTableTool, ProcessTable processTableTool) {
        this.businessTableTool = businessTableTool;
        this.saleTableTool = saleTableTool;
        this.processTableTool = processTableTool;
    }

    @Override
    public BusinessTableVO checkBusinessTable(Time begin, Time end) {

         return businessTableTool.search(begin,end);
    }

    @Override
    public ProcessTableVO checkProcessTable(ProcessTableFilterFlagsVO flags) {

        return  processTableTool.search(flags);
    }

    @Override
    public ProcessTableVO comparePTByName(ProcessTableVO processtable) {

        return  processTableTool.compareByName(processtable);
    }

    @Override
    public ProcessTableVO comparePTByTime(ProcessTableVO processtable) {

        return processTableTool.compareByTime(processtable);
    }

    @Override
    public SaleTableVO checkSaleTable(SaleTableFilterFlagsVO flags) {

        return  saleTableTool.search(flags);
    }

    @Override
    public SaleTableVO compareSTByName(SaleTableVO saletable) {

        return saleTableTool.compareByName(saletable);
    }

    @Override
    public SaleTableVO compareSTByTime(SaleTableVO saletable) {

        return saleTableTool.compareByTime(saletable);
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
