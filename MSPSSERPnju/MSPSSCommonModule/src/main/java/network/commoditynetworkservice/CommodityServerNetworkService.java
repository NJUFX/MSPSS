package network.commoditynetworkservice;

import po.ClassificationPO;
import po.CommodityPO;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/14.
 */
public interface CommodityServerNetworkService {

    /**
     * 添加商品
     * @param commodityPO
     * @return
     */
    public ResultMessage addCommodity(CommodityPO commodityPO) throws RemoteException;

    /**
     * 更新商品信息
     * @param commodityPO
     * @return
     */
    public ResultMessage modifyCommodity(CommodityPO commodityPO) throws RemoteException;

    /**
     * 删除商品
     * @param commodityPO
     * @return
     */
    public ResultMessage deleteCommodity(CommodityPO commodityPO) throws RemoteException;

    /**
     * 精确查找商品
     * @param id
     * @return
     */
    public CommodityPO exactlySearchCommodity(String id) throws RemoteException;

    public ArrayList<CommodityPO> fullSearchCommodity(String field, Object value) throws RemoteException;
    /**
     *
     * @param filed
     * @param value
     * @return
     */
    public ArrayList<CommodityPO> fuzzySearchCommodity(String filed,String value) throws RemoteException;

    /**
     *
     * @param field
     * @param min
     * @param max
     * @return
     */
    public ArrayList<CommodityPO> rangeSearchCommodity(String field, Object min, Object max) throws RemoteException;

    /**
     * 添加商品分类
     * @param classificationPO
     * @return
     */
    public ResultMessage addClassification(ClassificationPO classificationPO) throws RemoteException;

    /**
     * 更新商品分类信息
     * @param classificationPO
     * @return
     */
    public ResultMessage updateClassification(ClassificationPO classificationPO) throws RemoteException;

    /**
     * 删除商品分类
     * @param id
     * @return
     */
    public ResultMessage deleteClassification(String id) throws RemoteException;

    /**
     * 得到所有的商品分类
     * @return
     */
    public ArrayList<ClassificationPO> getAllClassification() throws RemoteException;

    /**
     * 根据当前的id查找到该节点下的子分类
     */
    public ArrayList<ClassificationPO> getChildrenClassification(String id) throws RemoteException;
    /**
     * 得到特定的商品分类
     * @param id
     * @return
     */
    public ClassificationPO getClassification(String id) throws RemoteException;

    /**
     * 完全比配查找
     * @param field
     * @param val
     * @return
     */
    public ArrayList<ClassificationPO> fullSearchClassificationPO(String field,String val) throws RemoteException;

}
