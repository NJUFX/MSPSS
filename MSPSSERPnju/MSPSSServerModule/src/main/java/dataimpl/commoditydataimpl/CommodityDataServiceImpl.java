package dataimpl.commoditydataimpl;

import datahelper.DataHelper;

import dataservice.CommodityDataService;
import filterflags.CommodityFilter;
import po.ClassificationPO;
import po.CommodityPO;
import util.ResultMessage;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by thinkpad on 2017/12/8.
 */
public class CommodityDataServiceImpl implements CommodityDataService{
    private DataHelper<CommodityPO> commodityHelper;
    private DataHelper<ClassificationPO> classificationHelper;

    protected CommodityDataServiceImpl(DataHelper<CommodityPO> commodityHelper,DataHelper<ClassificationPO> classificationHelper){
        this.commodityHelper = commodityHelper;
        this.classificationHelper = classificationHelper;
    }

    /**
     * 添加商品
     * @param commodityPO
     * @return
     */
    public ResultMessage addCommodity(CommodityPO commodityPO){
        try{
            commodityHelper.save(commodityPO);

            return ResultMessage.SUCCESS;
        }catch (Exception e){
            System.out.println("add commodity fail");
            return ResultMessage.FAILED;
        }
    }

    /**
     * 更新商品信息
     * @param commodityPO
     * @return
     */
    public ResultMessage modifyCommodity(CommodityPO commodityPO){
        try{
            commodityHelper.update(commodityPO);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            System.out.println("modify commodity fail");
            return ResultMessage.FAILED;
        }
    }

    /**
     * 删除商品
     * @param key,name
     * @return
     */
    public ResultMessage deleteCommodity(String key,String name){
        try{
            commodityHelper.delete(key,name);

            return ResultMessage.SUCCESS;

        }catch (Exception e){
            System.out.println("delete commodity fail");

            return ResultMessage.FAILED;
        }
    }

    /**
     * 精确查找商品
     * @param field,value
     * @return
     */
    public CommodityPO exactlySearchCommodity(String field,String value){
        return commodityHelper.exactlyQuery(field,value);
    }

    /**
     * 前缀搜索商品
     * @param field,value
     * @return
     */
    public ArrayList<CommodityPO> prefixSearchCommodity(String field, String value){
        return commodityHelper.prefixMatchQuery(field,value);
    }

    /**
     * 模糊搜索商品
     * @param field,value
     * @return
     */
    public ArrayList<CommodityPO> fuzzySearchCommodity(String field,String value){
        return commodityHelper.fullMatchQuery(field,value);
    }

    /**
     * 完全搜索
     */
    public ArrayList<CommodityPO> fullSearchCommodity(String field, Object value){
        return commodityHelper.fullMatchQuery(field, value);
    }
    /**
     * 范围搜索商品
     * @param field,min,max
     * @return
     */
    public ArrayList<CommodityPO> rangeSearchCommodity(String field,Object min,Object max){
        return commodityHelper.rangeQuery(field,min,max);
    }

    /**
     * 添加商品分类
     * @param classificationPO
     * @return
     */
    public ResultMessage addClassification(ClassificationPO classificationPO){
        try{
            classificationHelper.save(classificationPO);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            System.out.println("add classification fail");
            return ResultMessage.FAILED;
        }
    }

    /**
     * 更新商品分类信息
     * @param classificationPO
     * @return
     */
    public ResultMessage modifyClassification(ClassificationPO classificationPO){
        try{
            classificationHelper.update(classificationPO);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            System.out.println("modify classification fail");
            return ResultMessage.FAILED;
        }
    }

    /**
     * 删除商品分类
     * @param id
     * @return
     */
    public ResultMessage deleteClassification(String id){
        try{
            classificationHelper.delete("id",id);
            return ResultMessage.SUCCESS;
        }catch (Exception e){
            System.out.println("delete classification fail");
            return ResultMessage.FAILED;
        }
    }

    /**
     * 得到所有的商品分类
     * @return
     */
    public ArrayList<ClassificationPO> getAllClassification(){
        return classificationHelper.rangeQuery("id","","zzzzzzzzzzzzzzzzzzzz");

    }

    /**
     * 得到特定的商品分类
     * @param id
     * @return
     */
    public ClassificationPO getClassification(String id){
        return classificationHelper.exactlyQuery("id",id);
    }

    /**
     * 更新商品分类信息
     */
    public ResultMessage updateClassification(ClassificationPO classificationPO){
        return classificationHelper.update(classificationPO);
    }

    /**
     * 根据当前的id查找到该节点下的子分类
     */
    public ArrayList<ClassificationPO> getChildrenClassification(String id){
        return classificationHelper.fullMatchQuery("parent_id",id);
    }

    /**
     * 完全比配查找
     * @param field
     * @param val
     * @return
     */
    public ArrayList<ClassificationPO> fullSearchClassificationPO(String field,String val){
        return classificationHelper.fullMatchQuery(field,val);
    }
}
