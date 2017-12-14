package network;

import po.CustomerPromotionPO;
import po.GrossPromotionPO;
import po.GroupPromotionPO;
import util.CriteriaClause;
import util.ResultMessage;

import java.rmi.Remote;
import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 14:07 2017/11/30/030
 */
public interface PromotionClientNetworkService extends Remote {
    public ResultMessage addCustomerPromotion(CustomerPromotionPO po);

    public ResultMessage updateCustomerPromotion(CustomerPromotionPO po);

    public ResultMessage deleteCustomerPromotion(String id);

    public ArrayList<CustomerPromotionPO> multiSearchCustomerPromotion(ArrayList<CriteriaClause> criteriaClauses);

    public ResultMessage addGroupPromotion(GroupPromotionPO po);

    public ResultMessage updateGroupPromotion(GroupPromotionPO po);

    public ResultMessage deleteGroupPromotion(String id);

    public ArrayList<GroupPromotionPO> multiSearchGroupPromotion(ArrayList<CriteriaClause> criteriaClauses);

    public ResultMessage addGrossPromotion(GrossPromotionPO po);

    public ResultMessage updateGrossPromotion(GrossPromotionPO po);

    public ResultMessage deleteGrossPromotion(String id);

    public ArrayList<GrossPromotionPO> multiSearchGrossPromotion(ArrayList<CriteriaClause> criteriaClauses);

}
