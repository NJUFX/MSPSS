package blservice.accountblservice;

import util.ResultMessage;
import vo.AccountVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/11.
 */
public interface AccountBLService {
    /**
     * 添加账户
     *
     * @param account
     * @return 添加成功与否
     */
    public ResultMessage addAccount(AccountVO account);
    /**
     * 删除账户
     *
     * @param name
     * @return 删除成功与否
     */
    public ResultMessage deleteAccount(String name);
    /**
     * 修改账户
     *
     * @param oldname,newname
     * @return 修改成功与否
     */
    public ResultMessage modifyAccount(String oldname,String newname);
    /**
     * 查找账户
     *
     * @param name
     * @return 符合条件的List
     */
    public ArrayList<AccountVO> checkAccount(String name);
    /**
     * 账户收款
     *
     * @param name,money
     * @return void
     */
    public void income(String name,int money);
    /**
     * 账户付款
     *
     * @param name,money
     * @return void
     */
    public void pay(String name,int money);
    /**
     * 名称按字典序排序
     *
     * @param accountlist
     * @return 排序后的账户
     */
    public ArrayList<AccountVO> compareByName(ArrayList<AccountVO> accountlist);
    /**
     * 金额按从小到大排序
     *
     * @param accountlist
     * @return 排序后的账户
     */
    public ArrayList<AccountVO> compareByMoney(ArrayList<AccountVO> accountlist);

}
