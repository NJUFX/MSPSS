package network.promotionnetwork;

import dataimpl.promotiondataimpl.PromotionDataServiceFactory;
import dataservice.PromotionDataService;
import network.promotionnetworkservice.PromotionServerNetworkService;
import po.CustomerPromotionPO;
import po.GrossPromotionPO;
import po.GroupPromotionPO;
import util.CriteriaClause;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2018/1/2.
 */
public class PromotionServerNetworkImpl extends UnicastRemoteObject implements PromotionServerNetworkService {

    private PromotionDataService promotionDataService;

    public PromotionServerNetworkImpl() throws RemoteException{
        promotionDataService = PromotionDataServiceFactory.getPromotionDataService();
    }
    public ResultMessage addCustomerPromotion(CustomerPromotionPO po) throws RemoteException{
        return promotionDataService.addCustomerPromotion(po);
    }

    public ResultMessage updateCustomerPromotion(CustomerPromotionPO po)throws RemoteException{
        return promotionDataService.updateCustomerPromotion(po);
    }

    public ResultMessage deleteCustomerPromotion(String id)throws RemoteException{
        return promotionDataService.deleteCustomerPromotion(id);
    }

    public ArrayList<CustomerPromotionPO> multiSearchCustomerPromotion(ArrayList<CriteriaClause> criteriaClauses)throws RemoteException{
        return promotionDataService.multiSearchCustomerPromotion(criteriaClauses);
    }

    public ResultMessage addGroupPromotion(GroupPromotionPO po)throws RemoteException{
        return promotionDataService.addGroupPromotion(po);
    }

    public ResultMessage updateGroupPromotion(GroupPromotionPO po)throws RemoteException{
        return promotionDataService.updateGroupPromotion(po);
    }

    public ResultMessage deleteGroupPromotion(String id)throws RemoteException{
        return promotionDataService.deleteGroupPromotion(id);
    }

    public ArrayList<GroupPromotionPO> multiSearchGroupPromotion(ArrayList<CriteriaClause> criteriaClauses) throws RemoteException{
        return promotionDataService.multiSearchGroupPromotion(criteriaClauses);
    }

    public ResultMessage addGrossPromotion(GrossPromotionPO po)throws RemoteException{
        return promotionDataService.addGrossPromotion(po);
    }

    public ResultMessage updateGrossPromotion(GrossPromotionPO po)throws RemoteException{
        return promotionDataService.updateGrossPromotion(po);
    }

    public ResultMessage deleteGrossPromotion(String id)throws RemoteException{
        return promotionDataService.deleteGrossPromotion(id);
    }

    public ArrayList<GrossPromotionPO> multiSearchGrossPromotion(ArrayList<CriteriaClause> criteriaClauses)throws RemoteException{
        return promotionDataService.multiSearchGrossPromotion(criteriaClauses);
    }

}
