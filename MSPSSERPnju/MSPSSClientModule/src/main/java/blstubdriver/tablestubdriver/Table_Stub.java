package blstubdriver.tablestubdriver;

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
public class Table_Stub implements TableBLService{
    @Override
    public BusinessTableVO checkBusinessTable(BusinessTableFilterFlags flags) {
        return null;
    }

    @Override
    public BusinessTableVO compareBTByTime(BusinessTableVO businesstable) {
        return null;
    }

    @Override
    public ProcessTableVO checkProcessTable(ProcessTableFilterFlags flags) {
        return null;
    }

    @Override
    public ProcessTableVO comparePTByName(ProcessTableVO processtable) {
        return null;
    }

    @Override
    public ProcessTableVO comparePTByTime(ProcessTableVO processtable) {
        return null;
    }

    @Override
    public SaleTableVO checkSaleTable(SaleTableFilterFlags flags) {
        return null;
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
