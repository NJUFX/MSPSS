package network.promotionnetworkservice;

import po.CustomerPromotionPO;
import po.GrossPromotionPO;
import po.GroupPromotionPO;
import util.CriteriaClause;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2018/1/2.
 */
public interface PromotionServerNetworkService extends Remote {
    public ResultMessage addCustomerPromotion(CustomerPromotionPO po) throws RemoteException;

    public ResultMessage updateCustomerPromotion(CustomerPromotionPO po)throws RemoteException;

    public ResultMessage deleteCustomerPromotion(String id)throws RemoteException;

    public ArrayList<CustomerPromotionPO> multiSearchCustomerPromotion(ArrayList<CriteriaClause> criteriaClauses)throws RemoteException;

    public ResultMessage addGroupPromotion(GroupPromotionPO po)throws RemoteException;

    public ResultMessage updateGroupPromotion(GroupPromotionPO po)throws RemoteException;

    public ResultMessage deleteGroupPromotion(String id)throws RemoteException;

    public ArrayList<GroupPromotionPO> multiSearchGroupPromotion(ArrayList<CriteriaClause> criteriaClauses) throws RemoteException;

    public ResultMessage addGrossPromotion(GrossPromotionPO po)throws RemoteException;

    public ResultMessage updateGrossPromotion(GrossPromotionPO po)throws RemoteException;

    public ResultMessage deleteGrossPromotion(String id)throws RemoteException;

    public ArrayList<GrossPromotionPO> multiSearchGrossPromotion(ArrayList<CriteriaClause> criteriaClauses)throws RemoteException;

}

