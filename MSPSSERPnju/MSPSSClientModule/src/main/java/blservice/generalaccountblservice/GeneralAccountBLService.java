package blservice.generalaccountblservice;

import util.ResultMessage;
import vo.GeneralAccountVO;
import util.Time;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/11.
 */
public interface GeneralAccountBLService {
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
    /**
     * 按时间先后排序
     *
     * @param accountlist
     * @return 排序后的列表
     */
    public ArrayList<GeneralAccountVO> ETLsort(ArrayList<GeneralAccountVO> accountlist);


}
