package dataservice;

import util.ResultMessage;
import util.Time;
import vo.GeneralAccountVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/13.
 */
public interface GeneralAccountDataService {

    /**
     * 新建期初建账
     *
     * @param generalaccount
     * @return 新建成功与否
     */
    public ResultMessage newGeneralAccount(GeneralAccountVO generalaccount);
    /**
     * 查询建账信息
     *
     * @param begin,end
     * @return 建账信息列表
     */
    public ArrayList<GeneralAccountVO> checkGeneralAccount(Time begin, Time end);
}
