package dataservice;


import filterflags.CommodityFilter;
import util.ResultMessage;

import po.*;

import java.util.ArrayList;
import java.util.Iterator;

public interface CommodityDataService {
    /**
     * 添加商品
     * @param commodityPO
     * @return
     */
    public ResultMessage addCommodity(CommodityPO commodityPO);

    /**
     * 更新商品信息
     * @param commodityPO
     * @return
     */
    public ResultMessage modifyCommodity(CommodityPO commodityPO);

    /**
     * 完全查找
     */
    public ArrayList<CommodityPO> fullSearchCommodity(String field, Object value);

    /**
     * 删除商品
     * @param key,name
     * @return
     */
    public ResultMessage deleteCommodity(String key,String name);

    /**
     * 精确查找商品
     * @param field,value
     * @return
     */
    public CommodityPO exactlySearchCommodity(String field,String value);

    /**
     * 前缀搜索商品
     * @param field,value
     * @return
     */
    public ArrayList<CommodityPO> prefixSearchCommodity(String field, String value);

    /**
     * 模糊搜索商品
     * @param field,value
     * @return
     */
    public ArrayList<CommodityPO> fuzzySearchCommodity(String field,String value);

    /**
     * 范围搜索商品
     * @param field,min,max
     * @return
     */
    public ArrayList<CommodityPO> rangeSearchCommodity(String field,Object min,Object max);

    /**
     * 添加商品分类
     * @param classificationPO
     * @return
     */
    public ResultMessage addClassification(ClassificationPO classificationPO);

    /**
     * 更新商品分类信息
     * @param classificationPO
     * @return
     */
    public ResultMessage modifyClassification(ClassificationPO classificationPO);

    /**
     * 删除商品分类
     * @param id
     * @return
     */
    public ResultMessage deleteClassification(String id);

    /**
     * 得到所有的商品分类
     * @return
     */
    public ArrayList<ClassificationPO> getAllClassification();

    /**
     * 得到特定的商品分类
     * @param id
     * @return
     */
    public ClassificationPO getClassification(String id);

    /**
     * 更新分类信息
     */
    public ResultMessage updateClassification(ClassificationPO classificationPO);

    /**
     * 根据当前的id查找到该节点下的子分类
     */
    public ArrayList<ClassificationPO> getChildrenClassification(String id);

    /**
     * 完全比配查找
     * @param field
     * @param val
     * @return
     */
    public ArrayList<ClassificationPO> fullSearchClassificationPO(String field,String val);

}
