package blimpl.tableblimpl;


import network.BillClientNetworkImpl;
import network.BillClientNetworkService;
import vo.SaleTableFilterFlagsVO;
import vo.SaleTableVO;

/**
 * Created by thinkpad on 2017/12/23.
 */
public class SaleTable {
    BillClientNetworkService billClientNetworkService;

    protected SaleTable(){
        billClientNetworkService = new BillClientNetworkImpl();
    }

    /**
     * 按条件搜索销售明细表
     * @param flags
     * @return
     */
    public SaleTableVO search(SaleTableFilterFlagsVO flags){
        return null;
    }

    /**
     * 按商品名称以字典序的的方式排序
     * @param flags
     * @return
     */
    public SaleTableVO compareByName(SaleTableVO flags){
        return null;
    }

    /**
     * 按时间从前往后排序
     * @param saleTableVO
     * @return
     */
    public SaleTableVO compareByTime(SaleTableVO saleTableVO){
        return null;
    }
}
