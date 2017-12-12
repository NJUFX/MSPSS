package network;

import blimpl.commodityblimpl.Classification;
import filterflags.CommodityFilter;
import po.ClassificationPO;
import po.CommodityPO;
import util.ResultMessage;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Description:
 * Created by Hanxinhu at 14:06 2017/11/30/030
 */
public interface CommodityClientNetworkService extends Remote {
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

    public ArrayList<CommodityPO> fullSearchCommodity(String field, Object value);
    /**
     *
     * @param filed
     * @param value
     * @return
     */
    public ArrayList<CommodityPO> fuzzySearchCommodity(String filed,String value);

    /**
     *
     * @param field
     * @param min
     * @param max
     * @return
     */
    public ArrayList<CommodityPO> rangeSearchCommodity(String field, Object min, Object max);

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
    public ResultMessage updateClassification(ClassificationPO classificationPO);

    /**
     * 删除商品分类
     * @param id
     * @return
     */
    public ResultMessage deleteClassification(String id);



    /**
     * 根据当前的id查找到该节点下的子分类
     */
    public ArrayList<ClassificationPO> getChildrenClassification(String id);
    /**
     * 得到特定的商品分类
     * @param id
     * @return
     */
    public ClassificationPO getClassification(String id);

    /**
     * 完全比配查找
     * @param field
     * @param val
     * @return
     */
    public ArrayList<ClassificationPO> fullSearchClassificationPO(String field,String val);

}
