package datastubdriver.commoditydatastubdriver;

import dataservice.CommodityDataService;
import filterflags.CommodityFilter;
import po.ClassificationPO;
import po.CommodityPO;
import util.ResultMessage;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Project_Name ERPnju
 * Author: HanXinHu
 * Description:
 * Created on 22:35 2017/11/12/012
 */
public class CommodityDataService_Stub implements CommodityDataService{
    @Override
    public ResultMessage addCommodity(CommodityPO commodityPO) {
        if (commodityPO!=null)
        {
            System.out.println("add commodity succeed!");
            return ResultMessage.SUCCESS;
        }else
        {
            System.out.println("add commodity fail");
            return ResultMessage.FAILED;
        }
    }

    @Override
    public ResultMessage modifyCommodity(CommodityPO commodityPO) {
        if (commodityPO!=null)
        {
            System.out.println("modify commodity succeed!");
            return ResultMessage.SUCCESS;
        }else
        {
            System.out.println("modify commodity fail");
            return ResultMessage.FAILED;
        }
    }

    @Override
    public ResultMessage deleteCommodity(CommodityPO commodityPO) {
        if (commodityPO!=null)
        {
            System.out.println("delete commodity succeed!");
            return ResultMessage.SUCCESS;
        }else
        {
            System.out.println("delete commodity fail");
            return ResultMessage.FAILED;
        }
    }

    @Override
    public CommodityPO exactlySearchCommodity(String id) {
        if (id.equals("12138"))
        {
            System.out.println(" exactly search succeed");
            return new CommodityPO();
        }
        else
        {
            System.out.println(" exactly search fail");
            return null;
        }
    }

    @Override
    public Iterator<CommodityPO> prefixSearchCommodity(String name) {
        if (name.equals("台灯"))
        {
            System.out.println("prefix search succeed");
            return new ArrayList<CommodityPO>().iterator();
        }else {
            System.out.println("prefix search failed");
            return null;
        }
    }

    @Override
    public Iterator<CommodityPO> fuzzySearchCommodity(String name) {
        if (name.equals("台灯"))
        {
            System.out.println("fuzzy search succeed");
            return new ArrayList<CommodityPO>().iterator();
        }else {
            System.out.println("fuzzy search failed");
            return null;
        }

    }

    @Override
    public Iterator<CommodityPO> rangeSearchCommodity(CommodityFilter filter) {
        if (filter!=null)
        {
            System.out.println("range search succeed");
            return new ArrayList<CommodityPO>().iterator();
        }else {
            System.out.println("range search failed");
            return null;
        }
    }

    @Override
    public ResultMessage addClassification(ClassificationPO classificationPO) {
        if (classificationPO!=null)
        {
            System.out.println("add classification succeed!");
            return ResultMessage.SUCCESS;
        }else
        {
            System.out.println("add classification fail");
            return ResultMessage.FAILED;
        }
    }

    @Override
    public ResultMessage modifyClassification(ClassificationPO classificationPO) {
         if (classificationPO!=null)
        {
            System.out.println("modify classification succeed!");
            return ResultMessage.SUCCESS;
        }else
        {
            System.out.println("modify classification fail");
            return ResultMessage.FAILED;
        }
    }

    @Override
    public ResultMessage deleteClassification(String id) {
        if (id.equals("12138"))
        {
            System.out.println("delete classification succeed!");
            return ResultMessage.SUCCESS;
        }else
        {
            System.out.println("delete classification fail");
            return ResultMessage.FAILED;
        }
    }

    @Override
    public Iterator<ClassificationPO> getAllClassification() {
        System.out.println("there is all classifications");
        return new ArrayList<ClassificationPO>().iterator();
    }

    @Override
    public ClassificationPO getClassification(String id) {
        if (id.equals("12138")){
            System.out.println("get classification succeed");
            return new ClassificationPO();
        }
        System.out.println("get classification fail");
        return null;
    }


}
