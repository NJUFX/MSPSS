package blimpl.tableblimpl;

import network.BillClientNetworkImpl;
import network.BillClientNetworkService;
import vo.ProcessTableFilterFlagsVO;
import vo.ProcessTableVO;

/**
 * Created by thinkpad on 2017/12/23.
 */
public class ProcessTable {
    BillClientNetworkService billClientNetworkService;

    protected ProcessTable(){
        billClientNetworkService = new BillClientNetworkImpl();
    }

    /**
     * 按条件搜索经营历程表
     * @param flags
     * @return
     */
    public ProcessTableVO search(ProcessTableFilterFlagsVO flags){
        return null;
    }

    /**
     * 所有单据按名称以字典序的方式排序
     * @param processTableVO
     * @return
     */
    public ProcessTableVO compareByName(ProcessTableVO processTableVO){
        return null;
    }

    /**
     * 所有单据按时间从先到后排序
     * @param processTableVO
     * @return
     */
    public ProcessTableVO compareByTime(ProcessTableVO processTableVO){
        return null;
    }
}
