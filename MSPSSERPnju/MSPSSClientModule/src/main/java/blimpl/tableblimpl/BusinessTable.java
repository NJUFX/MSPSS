package blimpl.tableblimpl;

import network.BillClientNetworkImpl;
import network.BillClientNetworkService;
import util.Time;
import vo.BusinessTableVO;

/**
 * Created by thinkpad on 2017/12/23.
 */
public class BusinessTable {
    BillClientNetworkService billClientNetworkService;

    protected BusinessTable(){
        billClientNetworkService = new BillClientNetworkImpl();
    }

    /**
     * 搜索一段时间内的经营情况表
     * @param begin
     * @param end
     * @return
     */
    public BusinessTableVO search(Time begin,Time end){
        return null;
    }

    /**
     * 按时间从大到小排序
     * @param businessTableVO
     * @return
     */
    public BusinessTableVO compareByTime(BusinessTableVO businessTableVO){
        return null;
    }


}
