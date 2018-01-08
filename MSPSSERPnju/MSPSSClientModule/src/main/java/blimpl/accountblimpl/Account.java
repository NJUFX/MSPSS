package blimpl.accountblimpl;

import blimpl.blfactory.BLFactoryImpl;
import blservice.logblservice.LogBLInfo;
import blservice.userblservice.UserInfo;
import network.AccountClientNetworkImpl;
import network.AccountClientNetworkService;
import po.AccountPO;
import util.*;
import vo.AccountFilterFlagsVO;
import vo.AccountVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class Account {
    AccountClientNetworkService networkService = new AccountClientNetworkImpl();
    UserInfo userInfo = new BLFactoryImpl().getUserInfo();
    LogBLInfo logBLInfo = new BLFactoryImpl().getLogBLInfo();

    public ResultMessage addAccount(AccountVO accountVO) {
        accountVO.setCreateTime(new Time());
        ResultMessage message = networkService.addAccount(vo_to_po(accountVO));
        if (message == ResultMessage.SUCCESS)
            if (userInfo.getCurrentUser() != null) {
                logBLInfo.add(userInfo.getCurrentUser().getID(), "创建了账户" + accountVO.getName());
            }
        return message;
    }

    public ResultMessage deleteAccount(String name){
        ResultMessage message = networkService.deleteAccount(name);
        if (message == ResultMessage.SUCCESS)
            if (userInfo.getCurrentUser() != null) {
                logBLInfo.add(userInfo.getCurrentUser().getID(), "删除了账户 : " + name);
            }
        return message;
    }

    public ResultMessage modifyAccount(String oldName,String newName){
       // find old
        AccountPO po = networkService.searchAccountByName(oldName);
        //
        ResultMessage message1 =   networkService.addAccount(new AccountPO(newName,po.getMoney(),po.getCreatetime()));
        ResultMessage message2 =   deleteAccount(oldName);
        if (message1==message2&&message1.equals(ResultMessage.SUCCESS)) {
            if (userInfo.getCurrentUser() != null) {
                logBLInfo.add(userInfo.getCurrentUser().getID(), "更新了账户 : " + oldName + " to " + newName);
            }
            return ResultMessage.SUCCESS;
        }
        else
            return ResultMessage.FAILED;
    }

    public AccountVO searchAccountByName(String name){
        return po_to_vo(networkService.searchAccountByName(name));
    }
    public ArrayList<AccountVO> searchAccount(AccountFilterFlagsVO vo){
        ArrayList<CriteriaClause> criteriaClauses = new ArrayList<>();
        if (vo.getName()!=null){
            if (vo.getName().equals(""))
                criteriaClauses.add(CriteriaClauseImpl.createRangeValueQuery("createtime", Time.MIN_TIME, Time.MAX_TIME, QueryMethod.Range));
            else
                criteriaClauses.add(CriteriaClauseImpl.createSingleValueQuery("name", vo.getName(), QueryMethod.Full));
        }
        if (vo.getMinTime()!=null&&vo.getMaxTime()!=null){
            criteriaClauses.add(CriteriaClauseImpl.createRangeValueQuery("createtime",vo.getMinTime().toString(),vo.getMaxTime().toString(),QueryMethod.Range));
        }
        return pos_to_vos(networkService.multiSearchAccount(criteriaClauses));
    }
    public void income(String name,double money){
     AccountPO po =  networkService.searchAccountByName(name);
        po.setMoney(po.getMoney()+money);
        networkService.updateAccount(po);
    }

    public void pay(String name,double money){
        AccountPO po = networkService.searchAccountByName(name);

        po.setMoney(po.getMoney()-money);
        networkService.updateAccount(po);
    }

    public ArrayList<AccountVO> fuzzSearchAccountByName(String name) {
        return pos_to_vos(networkService.fullSearchAccount("name",name));
    }


    public ArrayList<AccountVO> rangeSearchAccountByTime(Time min, Time max) {
        return pos_to_vos(networkService.rangeSearchAccount("createtime",min.toString(),max.toString()));
    }

    public ArrayList<AccountVO> AccountMoneyAscendingSort(ArrayList<AccountVO> accountList){
        accountList.sort(new AccountMoneyAscendingComparator());
        return accountList;
    }


    public ArrayList<AccountVO> AccountNameAscendingSort(ArrayList<AccountVO> accountList) {
        accountList.sort(new AccountNameAscendingComparator());
        return accountList;
    }


    public ArrayList<AccountVO> AccountNameDescendingSort(ArrayList<AccountVO> accountList) {
        accountList.sort(new AccountNameDescendingComparator());
        return accountList;
    }


    public ArrayList<AccountVO> AccountMoneyDescendingSort(ArrayList<AccountVO> accountList) {
        accountList.sort(new AccountNameDescendingComparator());
        return accountList;
    }
    private AccountPO vo_to_po(AccountVO accountVO){
        AccountPO po = new AccountPO(accountVO.getName(),accountVO.getMoney(),accountVO.getCreateTime().toString());
        return po;
    }
    private AccountVO po_to_vo(AccountPO po){
        AccountVO vo = new AccountVO(po.getName(),po.getMoney(),new Time(po.getCreatetime()));
        return vo;
    }
    private ArrayList<AccountPO> vos_to_pos(ArrayList<AccountVO> vos){
        ArrayList<AccountPO> pos = new ArrayList<>();
        for (AccountVO vo: vos) {
            pos.add(vo_to_po(vo));
        }
        return pos;
    }
    private ArrayList<AccountVO> pos_to_vos(ArrayList<AccountPO> pos){
        ArrayList<AccountVO> vos = new ArrayList<>();
        for (AccountPO po : pos){
            vos.add(po_to_vo(po));
        }
        return vos;
    }
}
