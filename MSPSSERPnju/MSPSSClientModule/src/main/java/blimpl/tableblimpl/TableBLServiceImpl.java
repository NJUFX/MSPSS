package blimpl.tableblimpl;

import blservice.tableblservice.TableBLService;
import filterflags.BusinessTableFilterFlags;
import filterflags.ProcessTableFilterFlags;
import filterflags.SaleTableFilterFlags;
import vo.BusinessTableVO;
import vo.ProcessTableVO;
import vo.SaleTableVO;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class TableBLServiceImpl implements TableBLService {
    Table MyTable = new Table();
    @Override
    public BusinessTableVO checkBusinessTable(BusinessTableFilterFlags flags) {

        return MyTable.checkBusinessTable(flags);
    }

    @Override
    public BusinessTableVO compareBTByTime(BusinessTableVO businesstable) {

        return  MyTable.compareBTByTime(businesstable);
    }

    @Override
    public ProcessTableVO checkProcessTable(ProcessTableFilterFlags flags) {

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
    public SaleTableVO checkSaleTable(SaleTableFilterFlags flags) {

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
