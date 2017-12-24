package table;

import blimpl.tableblimpl.MockTable;
import filterflags.BusinessTableFilterFlags;
import filterflags.ProcessTableFilterFlags;
import filterflags.SaleTableFilterFlags;
import org.junit.Test;
import util.Time;
import vo.BusinessTableVO;
import vo.ProcessTableVO;
import vo.SaleTableVO;

/**
 * Created by thinkpad on 2017/11/14.
 */
public class TableMockTest {

    private Table table;
    private BusinessTableFilterFlags bf = new BusinessTableFilterFlags(new Time(2017,1,1,1,1,1),new Time(2017,11,11,11,11,11));
    private ProcessTableFilterFlags pf = new ProcessTableFilterFlags();
    private SaleTableFilterFlags sf = new SaleTableFilterFlags();
    private BusinessTableVO bv = new BusinessTableVO();
    private ProcessTableVO pv = new ProcessTableVO();
    private SaleTableVO sv = new SaleTableVO();
    public TableMockTest(){
        table = new MockTable();
    }

    @Test
    public void testcheckBusinessTable() {

        assertEquals(table.checkBusinessTable(bf),null);
    }

    @Test
    public void testcompareBTByTime() {
        assertEquals(table.compareBTByTime(bv),null);
    }

    @Test
    public void testcheckProcessTable(ProcessTableFilterFlags flags) {
        assertEquals(table.checkProcessTable(pf),null);

    }

    @Test
    public void testcomparePTByName(ProcessTableVO processtable) {
        assertEquals(table.comparePTByName(pv),null);
    }

    @Test
    public void testcomparePTByTime(ProcessTableVO processtable) {
        assertEquals(table.comparePTByTime(pv),null);
    }

    @Test
    public void testcheckSaleTable(SaleTableFilterFlags flags) {
        assertEquals(table.checkSaleTable(sf),null);
    }

    @Test
    public void testcompareSTByName(SaleTableVO saletable) {
        assertEquals(table.compareSTByName(sv),null);
    }
    @Test
    public void testcompareSTByTime(SaleTableVO saletable) {
        assertEquals(table.compareSTByTime(sv),null);
    }

}
