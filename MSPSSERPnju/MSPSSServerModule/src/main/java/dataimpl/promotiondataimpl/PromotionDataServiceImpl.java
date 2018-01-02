package dataimpl.promotiondataimpl;

import datahelper.DataHelper;
import dataservice.PromotionDataService;
import po.CustomerPromotionPO;
import po.GrossPromotionPO;
import po.GroupPromotionPO;
import util.CriteriaClause;
import util.ResultMessage;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2018/1/2.
 */
public class PromotionDataServiceImpl implements PromotionDataService {
    private DataHelper<CustomerPromotionPO> customerPromotionHelper;
    private DataHelper<GroupPromotionPO> groupPromotionHelper;
    private DataHelper<GrossPromotionPO> grossPromotionHelper;

    protected PromotionDataServiceImpl(DataHelper<CustomerPromotionPO> customerPromotionHelper,DataHelper<GroupPromotionPO> groupPromotionHelper,DataHelper<GrossPromotionPO> grossPromotionHelper){
        this.customerPromotionHelper = customerPromotionHelper;
        this.groupPromotionHelper = groupPromotionHelper;
        this.grossPromotionHelper = grossPromotionHelper;
    }
    public ResultMessage addCustomerPromotion(CustomerPromotionPO po){
        try{
            customerPromotionHelper.save(po);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage updateCustomerPromotion(CustomerPromotionPO po){
        try{
            customerPromotionHelper.update(po);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage deleteCustomerPromotion(String id){
        try{
            customerPromotionHelper.delete("id",id);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ArrayList<CustomerPromotionPO> multiSearchCustomerPromotion(ArrayList<CriteriaClause> criteriaClauses){
        return customerPromotionHelper.multiCriteriaQuery(criteriaClauses);
    }

    public ResultMessage addGroupPromotion(GroupPromotionPO po){
        try{
            groupPromotionHelper.save(po);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage updateGroupPromotion(GroupPromotionPO po){
        try{
            groupPromotionHelper.update(po);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage deleteGroupPromotion(String id){
        try{
            groupPromotionHelper.delete("id",id);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ArrayList<GroupPromotionPO> multiSearchGroupPromotion(ArrayList<CriteriaClause> criteriaClauses){
        return groupPromotionHelper.multiCriteriaQuery(criteriaClauses);
    }

    public ResultMessage addGrossPromotion(GrossPromotionPO po){
        try{
            grossPromotionHelper.save(po);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage updateGrossPromotion(GrossPromotionPO po){
        try{
            grossPromotionHelper.update(po);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ResultMessage deleteGrossPromotion(String id){
        try{
            grossPromotionHelper.delete("id",id);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMessage.FAILED;
    }

    public ArrayList<GrossPromotionPO> multiSearchGrossPromotion(ArrayList<CriteriaClause> criteriaClauses){
        return grossPromotionHelper.multiCriteriaQuery(criteriaClauses);
    }

}
