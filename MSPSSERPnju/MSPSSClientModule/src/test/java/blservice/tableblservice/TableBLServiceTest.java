package blservice.tableblservice;

import blimpl.blfactory.BLFactoryImpl;
import blservice.blfactoryservice.BLFactoryService;
import filterflags.SaleTableFilterFlags;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import vo.SaleTableFilterFlagsVO;
import vo.SaleTableVO;

import static org.junit.Assert.*;

/**
 * Created by thinkpad on 2017/12/28.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TableBLServiceTest {
    BLFactoryService blFactoryService = new BLFactoryImpl();
    TableBLService tableBLService = blFactoryService.getTableBLService();

    @Test
    public void checkSaleTable() throws Exception {
        SaleTableFilterFlagsVO saleTableFilterFlags = new SaleTableFilterFlagsVO();
        SaleTableVO saleTableVO;
        saleTableVO = tableBLService.checkSaleTable(saleTableFilterFlags);

    }

    @Test
    public void checkBusinessTable() throws Exception {
    }

    @Test
    public void checkProcessTable() throws Exception {
    }



    @Test
    public void compareSTByTime() throws Exception {
    }

    @Test
    public void comparePTByTime() throws Exception {
    }

}