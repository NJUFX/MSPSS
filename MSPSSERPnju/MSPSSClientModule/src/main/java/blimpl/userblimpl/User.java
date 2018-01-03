package blimpl.userblimpl;

import blimpl.blfactory.BLFactoryImpl;
import blservice.logblservice.LogBLInfo;
import network.UserClientNetworkImpl;
import network.UserClientNetworkService;
import po.UserPO;
import status.Log_In_Out_Status;
import util.Kind_Of_Users;
import util.ResultMessage;
import util.SendMailImpl;
import vo.UserVO;

import java.util.ArrayList;

public class User {

    private UserClientNetworkService networkService = new UserClientNetworkImpl();
    private static UserVO currentUser;
    private LogBLInfo logBLInfo = new BLFactoryImpl().getLogBLInfo();
    /**
     * @param user
     * @return
     */
    public ResultMessage addUser(UserVO user) {
        UserPO testPo = networkService.searchUserByID(user.getID());
        if (testPo != null) {
            if (testPo.getID() != null)
                return ResultMessage.EXIST;
        }
        UserPO po = vo_to_po(user);

        ResultMessage message = networkService.addUser(po);
        if (message == ResultMessage.SUCCESS) {
            SendMailImpl.getInstance().sendMail(user.getName(), user.getMail(),
                    "用户注册成功", "尊敬的" + user.getName() + ":\n" + "您在灯泡进销存系统已经成功注册" + user.getCategory().toString() + ",ID为" + user.getID());
            if (currentUser != null) {
                logBLInfo.add(currentUser.getID(), "注册了用户ID" + user.getID() + "账户名" + user.getName());
            }
        }
        return message;
    }

    /**
     * 根据用户类型查找用户
     * sale finance    同时返回经理
     *
     * @param kind
     * @return
     */

    public ArrayList<UserVO> searchUserByKind(Kind_Of_Users kind) {
        int category = kind.getNumber();

        ArrayList<UserPO> pos = networkService.fullSearchUser("category", category);
        //如果查询类型是销售人员 则将销售经理也返回
        //如果查询类型是财务人员 则将财务经理也返回
        if (category == 2 || category == 4)
            pos.addAll(networkService.fullSearchUser("category", category + 1));
        ArrayList<UserVO> vos = pos_to_vos(pos);
        return vos;
    }
    /**
     * 删除用户
     *
     * @param userID 用户id
     * @return 删除用户的运行结果
     */
    public ResultMessage deleteUser(String userID) {
        UserVO userVO = searchUserByID(userID);
        ResultMessage message = networkService.deleteUser(userID);
        if (message == ResultMessage.SUCCESS) {
            if (currentUser != null) {
                logBLInfo.add(currentUser.getID(), "删除了用户" + userID);
            }
            SendMailImpl.getInstance().sendMail(userVO.getName(), userVO.getMail(),
                    "用户已被注销", "尊敬的" + userVO.getName() + ":\n" + "您在灯泡进销存系统的账户已经成功注销" + userVO.getCategory().toString() + ",ID" + userVO.getID() + "已经无法使用");
        }
        return ResultMessage.SUCCESS;
    }

    /**
     * @param userVO
     * @return
     */
    public ResultMessage updateUser(UserVO userVO) {
        UserPO po = vo_to_po(userVO);
        ResultMessage message = networkService.updateUser(po);
        if (message == ResultMessage.SUCCESS) {
            SendMailImpl.getInstance().sendMail(userVO.getName(), userVO.getMail(),
                    "用户信息更新成功", "尊敬的" + userVO.getName() + ":\n" + "您在灯泡进销存系统已经成功注册" + userVO.getCategory().toString() + ",ID为" + userVO.getID());
            if (currentUser != null) {
                logBLInfo.add(currentUser.getID(), "更新了用户信息" + userVO.getID() + "账户名" + userVO.getName());
            }
        }
        return message;
    }

    /**
     * 根据用户的ID来查找
     *
     * @param ID
     * @return
     */

    public UserVO searchUserByID(String ID) {

        UserPO po = networkService.searchUserByID(ID);

        return po_to_vo(po);
    }

    /**
     * 登陆
     *
     * @param ID
     * @param password
     * @return
     */
    public Log_In_Out_Status login(String ID, String password) {

        if (networkService.searchUserByID(ID) == null)
            return Log_In_Out_Status.Login_IdNotExist;

        UserPO userPO = networkService.searchUserByID(ID);

        if (userPO.getPassword().equals(password)) {
            currentUser = po_to_vo(userPO);
            if (currentUser != null) {
                logBLInfo.add(currentUser.getID(), "成功登陆");
            }
            return Log_In_Out_Status.Login_Success;
           /* switch (userPO.getCategory()) {
                    case 1:
                    return Log_In_Out_Status.Login_Success_StockManager;
                case 2:
                    return Log_In_Out_Status.Login_Success_Salesman;
                case 3:
                    return Log_In_Out_Status.Login_Success_Salesman;
                case 4:
                    return Log_In_Out_Status.Login_Success_Financer;
                case 5:
                    return Log_In_Out_Status.Login_Success_Financer;
                case 6:
                    return Log_In_Out_Status.Login_Success_CheifManager;

            }
            return Log_In_Out_Status.Login_Success;
            */
        } else
            return Log_In_Out_Status.Login_PasswordWrong;
    }

    /**
     * 登出
     *
     * @param ID
     * @return
     */
    public Log_In_Out_Status logout(String ID) {
        if (currentUser != null) {
            logBLInfo.add(currentUser.getID(), "成功出");
        }
        currentUser = null;

        return Log_In_Out_Status.Logout_Sucess;
    }
    private UserVO po_to_vo(UserPO po) {
        UserVO vo = new UserVO(po.getID(), po.getName(), po.getKind(), po.getPassword(),po.getMail());
        return vo;
    }

    private UserPO vo_to_po(UserVO vo) {
        UserPO po = new UserPO(vo.getID(), vo.getName(), vo.getCategoryForPO(), vo.getPassword(),vo.getMail());
        return po;
    }

    private ArrayList<UserVO> pos_to_vos(ArrayList<UserPO> pos) {
        ArrayList<UserVO> vos = new ArrayList<>();
        for (UserPO po : pos) {
            vos.add(po_to_vo(po));
        }
        return vos;
    }

    public UserVO getCurrentUser() {
        return currentUser;
    }

    /**
     * 得到库存管理人员的邮箱地址
     * 便与通知库存报警信息
     */
    public ArrayList<String> getStockManagerMails() {
        ArrayList<String> mails = new ArrayList<>();
        ArrayList<UserVO> userVOS = searchUserByKind(Kind_Of_Users.StockManager);
        if (userVOS == null)
            return mails;
        for (int i = 0; i < userVOS.size(); i++) {
            mails.add(userVOS.get(i).getMail());
        }
        return mails;
    }

    /**
     * 得到总经理的邮箱
     * 以提醒总经理审批
     */

    public ArrayList<String> getChiefManagerMails() {
        ArrayList<String> mails = new ArrayList<>();
        ArrayList<UserVO> userVOS = searchUserByKind(Kind_Of_Users.ChiefManager);
        if (userVOS == null)
            return mails;
        for (int i = 0; i < userVOS.size(); i++) {
            mails.add(userVOS.get(i).getMail());
        }
        return mails;

    }
}
