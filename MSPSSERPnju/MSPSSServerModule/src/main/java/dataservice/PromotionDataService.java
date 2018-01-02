package dataservice;

import po.CustomerPromotionPO;
import po.GrossPromotionPO;
import po.GroupPromotionPO;
import po.PromotionPO;
import util.CriteriaClause;
import util.ResultMessage;
import util.Time;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Harper on 17/11/13
 */
public interface PromotionDataService {

    public ResultMessage addCustomerPromotion(CustomerPromotionPO po);

    public ResultMessage updateCustomerPromotion(CustomerPromotionPO po);

    public ResultMessage deleteCustomerPromotion(String id);

    public ArrayList<CustomerPromotionPO> multiSearchCustomerPromotion(ArrayList<CriteriaClause> criteriaClauses);

    public ResultMessage addGroupPromotion(GroupPromotionPO po);

    public ResultMessage updateGroupPromotion(GroupPromotionPO po);

    public ResultMessage deleteGroupPromotion(String id);

    public ArrayList<GroupPromotionPO> multiSearchGroupPromotion(ArrayList<CriteriaClause> criteriaClauses) ;

    public ResultMessage addGrossPromotion(GrossPromotionPO po);

    public ResultMessage updateGrossPromotion(GrossPromotionPO po);

    public ResultMessage deleteGrossPromotion(String id);

    public ArrayList<GrossPromotionPO> multiSearchGrossPromotion(ArrayList<CriteriaClause> criteriaClauses);

}
