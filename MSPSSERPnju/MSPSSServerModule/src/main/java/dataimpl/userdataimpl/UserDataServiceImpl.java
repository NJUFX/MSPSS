package dataimpl.userdataimpl;

import datahelper.DataHelper;
import datahelper.HibernateHelper;
import dataservice.UserDataService;
import po.UserPO;
import util.ResultMessage;

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
        try{
            user.setPower(power);
            userHelper.update(user);
            return ResultMessage.SUCCESS;
        }catch(Exception e){
            System.out.println("modify power fail");
            return ResultMessage.FAILED;
        }
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
    public ResultMessage delUser(String userid){
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
    public ResultMessage modifyUser(UserPO user){
        try{
            userHelper.update(user);
            return ResultMessage.SUCCESS;
        }catch(Exception e){
            System.out.println("modify User fail");
            return ResultMessage.FAILED;
        }
    }

    /**
     * 根据ID找user
     * @param ID
     * @return
     */
    public UserPO findUserByID(String ID){

            return userHelper.exactlyQuery("id",ID);

    }
}
