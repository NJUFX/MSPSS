package blimpl.billblimpl;

import blimpl.blfactory.BLFactoryImpl;
import blservice.logblservice.LogBLInfo;
import util.ResultMessage;
import vo.UserVO;

/**
 * Description:
 * Created by Hanxinhu at 10:01 2018/1/3/003
 */
public class BillLogHelper {
    private static LogBLInfo logBLInfo = new BLFactoryImpl().getLogBLInfo();

    public static ResultMessage init(UserVO userVO, String ID) {
        if (userVO != null)
            return logBLInfo.add(userVO.getID(), "创建了" + getName(ID) + " : " + ID);
        return ResultMessage.FAILED;
    }

    public static ResultMessage update(UserVO userVO, String ID) {
        if (userVO != null)
            return logBLInfo.add(userVO.getID(), "更新了" + getName(ID) + " : " + ID);
        return ResultMessage.FAILED;
    }

    public static ResultMessage commit(UserVO userVO, String ID) {
        if (userVO != null)
            return logBLInfo.add(userVO.getID(), "提交了" + getName(ID) + " : " + ID);
        return ResultMessage.FAILED;

    }

    public static ResultMessage approval(UserVO userVO, String ID) {
        if (userVO != null)
            return logBLInfo.add(userVO.getID(), "批准了" + getName(ID) + " : " + ID);
        return ResultMessage.FAILED;
    }

    public static ResultMessage delete(UserVO userVO, String ID) {
        if (userVO != null)
            return logBLInfo.add(userVO.getID(), "删除了" + getName(ID) + " : " + ID);
        return ResultMessage.FAILED;
    }

    public static ResultMessage withdraw(UserVO userVO, String ID) {
        if (userVO != null)
            return logBLInfo.add(userVO.getID(), "撤回了" + getName(ID) + " : " + ID);
        return ResultMessage.FAILED;
    }

    public static ResultMessage reject(UserVO userVO, String ID) {
        if (userVO != null)
            return logBLInfo.add(userVO.getID(), "拒绝了" + getName(ID) + " : " + ID);
        return ResultMessage.FAILED;
    }

    private static String getName(String ID) {
        return BillSendMessage.getName(ID);
    }

}
