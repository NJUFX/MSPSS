package dataimpl.userdataimpl;

import datahelper.DataHelper;
import datahelper.HibernateHelper;
import dataservice.UserDataService;
import po.UserPO;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/8.
 */
public class UserDataServiceImpl implements UserDataService{
    private DataHelper<UserPO> userHelper;

    protected UserDataServiceImpl(DataHelper<UserPO> userHelper){
        this.userHelper = userHelper;
    }
    /**
     * 增加权限
     *
     * @param power
     * @return
     */
    public ResultMessage modifyPower(UserPO user, String power){
        //po中没发现有power
      return ResultMessage.FAILED;
    }

    /**
     * @param user
     * @return
     */
    public ResultMessage addUser(UserPO user){
        try{
            userHelper.save(user);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            System.out.println("add User fail");
            return ResultMessage.FAILED;

        }
    }

    /**
     * 删除用户
     *
     * @param userid 用户id
     * @return 删除用户的运行结果
     */
    public ResultMessage deleteUser(String userid){
        try{
            userHelper.delete("id",userid);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            System.out.println("delete user fail");
            return ResultMessage.FAILED;
        }
    }
    /**
     * @param user
     * @return
     */
    public ResultMessage updateUser(UserPO user){
        try{
            userHelper.update(user);
            return ResultMessage.SUCCESS;
        }catch(Exception e){
            System.out.println("modify User fail");
            return ResultMessage.FAILED;
        }
    }


    /**
     * 通过登录账号返回ID
     * @param ID
     * @return
     */
    public UserPO searchUserByID(String ID){
     return userHelper.exactlyQuery("id",ID);
    }

    /**
     * 完全匹配一定类型的用户
     *
     * @param filed
     * @param val
     * @return
     */
    public ArrayList<UserPO> fullSearchUser(String filed, Object val){
        return userHelper.fullMatchQuery(filed, val);
    }

    /**
     * 精确查找
     *
     * @param field
     * @param val
     * @return
     */
    public UserPO exactlySearchUser(String field, Object val){
        return userHelper.exactlyQuery(field,val);
    }
}
