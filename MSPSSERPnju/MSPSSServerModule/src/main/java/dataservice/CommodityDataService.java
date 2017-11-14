package dataservice;


import filterflags.CommodityFilter;
import util.ResultMessage;

import po.*;

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
     * 删除商品
     * @param commodityPO
     * @return
     */
    public ResultMessage deleteCommodity(CommodityPO commodityPO);

    /**
     * 精确查找商品
     * @param id
     * @return
     */
    public CommodityPO exactlySearchCommodity(String id);

    /**
     * 前缀搜索商品
     * @param name
     * @return
     */
    public Iterator<CommodityPO> prefixSearchCommodity(String name);

    /**
     * 模糊搜索商品
     * @param name
     * @return
     */
    public Iterator<CommodityPO> fuzzySearchCommodity(String name);

    /**
     * 范围搜索商品
     * @param filter
     * @return
     */
    public Iterator<CommodityPO> rangeSearchCommodity(CommodityFilter filter);

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
    public Iterator<ClassificationPO> getAllClassification();

    /**
     * 得到特定的商品分类
     * @param id
     * @return
     */
    public ClassificationPO getClassification(String id);

}
