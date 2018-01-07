package blimpl.billblimpl;

import blimpl.blfactory.BLFactoryImpl;
import blservice.userblservice.UserInfo;
import ui.adminui.LoginController;
import util.ResultMessage;
import util.SendMailImpl;
import util.SendMailService;
import util.Time;
import vo.UserVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 9:25 2018/1/3/003
 */
public class BillSendMessage {
    static SendMailService service = SendMailImpl.getInstance();
    static UserInfo userInfo = new BLFactoryImpl().getUserInfo();

    public static ResultMessage commit(UserVO userVO, String ID) {
       try {
           ArrayList<String> mails = userInfo.getChiefManagerMails();

           for (int i = 0; i < mails.size(); i++) {
               service.sendMail("总经理", mails.get(i)
                       , userVO + "提交了" + getName(ID) + "等待您的审批", LoginController.getCurrentUser().getID() + "提交了" + getName(ID) + ":" + ID + "等待您的审批");
           }
       }catch (Exception e){
           e.printStackTrace();
       }
        return ResultMessage.SUCCESS;
    }

    public static ResultMessage withdraw(UserVO userVO, String ID) {
       try {
           ArrayList<String> mails = userInfo.getChiefManagerMails();
           for (int i = 0; i < mails.size(); i++) {
               service.sendMail("总经理", mails.get(i)
                       , userVO + "撤回了" + getName(ID), LoginController.getCurrentUser().getID() + "撤回了" + getName(ID) + ":" + ID + " 您不用审批了");
           }
       }catch (Exception e){
           e.printStackTrace();
       }
        return ResultMessage.SUCCESS;
    }

    public static ResultMessage approve(UserVO operator, UserVO approval, String ID) {
      try{
          service.sendMail(operator.getName(), operator.getMail()
                  , getName(ID) + ID + "审批通过", approval.getName() + "(ID:" + approval.getID() + ")" + new Time().toString() + "通过了您的单据" + getName(ID) + ID
          );
      }catch (Exception e){
          e.printStackTrace();
      }
        return ResultMessage.SUCCESS;
    }

    public static ResultMessage reject(UserVO operator, UserVO approval, String ID) {
      try {
          service.sendMail(operator.getName(), operator.getMail()
                  , getName(ID) + ID + "审批拒绝", approval.getName() + "(ID:" + approval.getID() + ")" + new Time().toString() + "拒绝了您的单据" + getName(ID) + ID
          );
      }catch (Exception e){
          e.printStackTrace();
      }
        return ResultMessage.SUCCESS;
    }

    public static String getName(String ID) {
        String prefix = ID.split("-")[0];
        String billType = "";
        switch (prefix) {
            case "KCZSD":
                billType = "库存赠送单";
                break;
            case "KCBSD":
                billType = "库存报损单";
                break;
            case "KCBYD":
                billType = "库存报溢单";
                break;
            case "XSD":
                billType = "销售单";
                break;
            case "XSTHD":
                billType = "销售退货单";
                break;
            case "JHD":
                billType = "进货单";
                break;
            case "JHTHD":
                billType = "进货退货单";
                break;
            case "XJFYD":
                billType = "现金费用单";
                break;
            case "SKD":
                billType = "收款单";
                break;
            case "FKD":
                billType = "付款单";
                break;
        }
        return billType;
    }
}
