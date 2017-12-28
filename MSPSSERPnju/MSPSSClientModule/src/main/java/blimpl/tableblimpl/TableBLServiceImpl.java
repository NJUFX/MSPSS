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
    ExportHelper exportHelper;
    TableComparator tableComparator;

    public TableBLServiceImpl(BusinessTable businessTableTool, SaleTable saleTableTool, ProcessTable processTableTool) {
        this.businessTableTool = businessTableTool;
        this.saleTableTool = saleTableTool;
        this.processTableTool = processTableTool;
        exportHelper = new ExportHelper();
        tableComparator = new TableComparator();
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
    public ProcessTableVO comparePTByTime(ProcessTableVO processtable) {

        return tableComparator.ComparePTByTime(processtable);
    }

    @Override
    public SaleTableVO checkSaleTable(SaleTableFilterFlagsVO flags) {

        return  saleTableTool.search(flags);
    }



    @Override
    public SaleTableVO compareSTByTime(SaleTableVO saletable) {

        return tableComparator.CompareSTByTime(saletable);
    }

    @Override
    public void exportBusinessTable(BusinessTableVO businesstable) {
         exportHelper.BusinessTableExport(businesstable);
    }

    @Override
    public void exportProcessTable(ProcessTableVO processtable) {
        exportHelper.ProcessTableExport(processtable);
    }

    @Override
    public void exportSaleTable(SaleTableVO saletable) {
        exportHelper.SaleTableExport(saletable);
    }
}
