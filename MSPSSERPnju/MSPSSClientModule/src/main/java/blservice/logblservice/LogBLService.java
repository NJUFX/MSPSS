package blservice.logblservice;

import po.LogPO;
import util.Time;
import vo.LogListVO;
import vo.LogVO;

import java.util.ArrayList;

/**
 * Created by Harper on 17/11/12
 *
 */

public interface LogBLService {

    /**
     * 搜索日志记录
     *
     * @param start,end
     * @return ArrayList<LogVO>
     */
    public ArrayList<LogVO> search(Time start,Time end);


}
