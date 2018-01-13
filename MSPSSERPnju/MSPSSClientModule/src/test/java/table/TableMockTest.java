package table;

import blimpl.tableblimpl.MockTable;
import blimpl.tableblimpl.ProcessTable;
import filterflags.BusinessTableFilterFlags;
import filterflags.ProcessTableFilterFlags;
import filterflags.SaleTableFilterFlags;
import org.junit.Test;
import util.Time;
import vo.BusinessTableVO;
import vo.ProcessTableVO;
import vo.SaleTableVO;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by thinkpad on 2017/11/14.
 */
public class TableMockTest {

    private ProcessTable table;
    private BusinessTableFilterFlags bf = new BusinessTableFilterFlags(new Time(2017, 1, 1, 1, 1, 1), new Time(2017, 11, 11, 11, 11, 11));
    private ProcessTableFilterFlags pf = new ProcessTableFilterFlags();
    private SaleTableFilterFlags sf = new SaleTableFilterFlags();
    private BusinessTableVO bv = new BusinessTableVO();
    private ProcessTableVO pv = new ProcessTableVO();
    private SaleTableVO sv = new SaleTableVO();

    public TableMockTest() {
        table = new MockTable();
    }

    @Test
    public void testcheckBusinessTable() {
        assertEquals(",", ",");
    }

    @Test
    public void testcompareBTByTime() {
        assertEquals(",", ",");

    }

    @Test
    public void testcheckProcessTable(ProcessTableFilterFlags flags) {
        assertEquals(",", ",");

    }

    @Test
    public void testcomparePTByName(ProcessTableVO processtable) {
        assertEquals(",", ",");

    }

    @Test
    public void testcomparePTByTime(ProcessTableVO processtable) {
        assertEquals(",", ",");

    }

    @Test
    public void testcheckSaleTable(SaleTableFilterFlags flags) {
        assertEquals(",", ",");

    }

    @Test
    public void testcompareSTByName(SaleTableVO saletable) {
        assertEquals(",", ",");

    }

    @Test
    public void testcompareSTByTime(SaleTableVO saletable) {
        assertEquals(",", ",");

    }

}
