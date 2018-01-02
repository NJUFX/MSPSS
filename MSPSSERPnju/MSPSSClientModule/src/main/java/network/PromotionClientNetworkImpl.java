package network;

import network.promotionnetworkservice.PromotionServerNetworkService;
import po.CustomerPromotionPO;
import po.GrossPromotionPO;
import po.GroupPromotionPO;
import util.CriteriaClause;
import util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/24.
 */
public class PromotionClientNetworkImpl implements PromotionClientNetworkService{
    private PromotionServerNetworkService promotionServerNetworkService;

    public PromotionClientNetworkImpl(){
        try {
            promotionServerNetworkService = (PromotionServerNetworkService) Naming.lookup("PromotionServerNetworkService");
        } catch (NotBoundException e) {
            System.err.println("Client.network.PromotionServerNetworkService: Not bound, trying to connect");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public ResultMessage addCustomerPromotion(CustomerPromotionPO po){
        try{
            return promotionServerNetworkService.addCustomerPromotion(po);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage updateCustomerPromotion(CustomerPromotionPO po){
        try{
            return promotionServerNetworkService.updateCustomerPromotion(po);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage deleteCustomerPromotion(String id){
        try{
            return promotionServerNetworkService.deleteCustomerPromotion(id);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ArrayList<CustomerPromotionPO> multiSearchCustomerPromotion(ArrayList<CriteriaClause> criteriaClauses){
        try{
            return promotionServerNetworkService.multiSearchCustomerPromotion(criteriaClauses);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public ResultMessage addGroupPromotion(GroupPromotionPO po){
        try{
            return promotionServerNetworkService.addGroupPromotion(po);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage updateGroupPromotion(GroupPromotionPO po){
        try{
            return promotionServerNetworkService.updateGroupPromotion(po);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage deleteGroupPromotion(String id){
        try{
            return promotionServerNetworkService.deleteGroupPromotion(id);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ArrayList<GroupPromotionPO> multiSearchGroupPromotion(ArrayList<CriteriaClause> criteriaClauses){
        try{
            return promotionServerNetworkService.multiSearchGroupPromotion(criteriaClauses);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public ResultMessage addGrossPromotion(GrossPromotionPO po){
        try{
            return promotionServerNetworkService.addGrossPromotion(po);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage updateGrossPromotion(GrossPromotionPO po){
        try{
            return promotionServerNetworkService.updateGrossPromotion(po);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage deleteGrossPromotion(String id){
        try{
            return promotionServerNetworkService.deleteGrossPromotion(id);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ArrayList<GrossPromotionPO> multiSearchGrossPromotion(ArrayList<CriteriaClause> criteriaClauses){
        try{
            return promotionServerNetworkService.multiSearchGrossPromotion(criteriaClauses);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        return null;
    }


}
