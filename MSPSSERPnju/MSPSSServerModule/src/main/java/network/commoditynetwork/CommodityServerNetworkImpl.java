package network.commoditynetwork;

import dataimpl.commoditydataimpl.CommodityDataServiceFactory;
import dataservice.CommodityDataService;
import network.commoditynetworkservice.CommodityServerNetworkService;
import po.ClassificationPO;
import po.CommodityPO;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/14.
 */
public class CommodityServerNetworkImpl extends UnicastRemoteObject implements CommodityServerNetworkService {

    private CommodityDataService commodityDataService;

    public CommodityServerNetworkImpl() throws RemoteException{
        commodityDataService = CommodityDataServiceFactory.getCommodityDataService();
    }

    /**
     * 添加商品
     * @param commodityPO
     * @return
     */
    public ResultMessage addCommodity(CommodityPO commodityPO) throws RemoteException{
        return commodityDataService.addCommodity(commodityPO);
    }

    /**
     * 更新商品信息
     * @param commodityPO
     * @return
     */
    public ResultMessage modifyCommodity(CommodityPO commodityPO) throws RemoteException{
        return commodityDataService.modifyCommodity(commodityPO);
    }

    /**
     * 删除商品
     * @param commodityPO
     * @return
     */
    public ResultMessage deleteCommodity(CommodityPO commodityPO) throws RemoteException{
        return commodityDataService.deleteCommodity("id",commodityPO.getID());
    }

    /**
     * 精确查找商品
     * @param id
     * @return
     */
    public CommodityPO exactlySearchCommodity(String id) throws RemoteException{
        return commodityDataService.exactlySearchCommodity("id",id);
    }

    public ArrayList<CommodityPO> fullSearchCommodity(String field, Object value) throws RemoteException{
        return commodityDataService.fullSearchCommodity(field,value);
    }
    /**
     *
     * @param field
     * @param value
     * @return
     */
    public ArrayList<CommodityPO> fuzzySearchCommodity(String field,String value) throws RemoteException{
        return commodityDataService.fuzzySearchCommodity(field,value);
    }

    /**
     *
     * @param field
     * @param min
     * @param max
     * @return
     */
    public ArrayList<CommodityPO> rangeSearchCommodity(String field, Object min, Object max) throws RemoteException{
        return commodityDataService.rangeSearchCommodity(field,min,max);
    }

    /**
     * 添加商品分类
     * @param classificationPO
     * @return
     */
    public ResultMessage addClassification(ClassificationPO classificationPO) throws RemoteException{
        return commodityDataService.addClassification(classificationPO);
    }

    /**
     * 更新商品分类信息
     * @param classificationPO
     * @return
     */
    public ResultMessage updateClassification(ClassificationPO classificationPO) throws RemoteException{
        return commodityDataService.updateClassification(classificationPO);
    }

    /**
     * 删除商品分类
     * @param id
     * @return
     */
    public ResultMessage deleteClassification(String id) throws RemoteException{
        return commodityDataService.deleteClassification(id);
    }

    /**
     * 得到所有的商品分类
     * @return
     */
    public ArrayList<ClassificationPO> getAllClassification() throws RemoteException{
        return commodityDataService.getAllClassification();
    }

    /**
     * 根据当前的id查找到该节点下的子分类
     */
    public ArrayList<ClassificationPO> getChildrenClassification(String id) throws RemoteException{
        return commodityDataService.getChildrenClassification(id);
    }
    /**
     * 得到特定的商品分类
     * @param id
     * @return
     */
    public ClassificationPO getClassification(String id) throws RemoteException{
        return commodityDataService.getClassification(id);
    }

    /**
     * 完全比配查找
     * @param field
     * @param val
     * @return
     */
    public ArrayList<ClassificationPO> fullSearchClassificationPO(String field,String val) throws RemoteException{
        return commodityDataService.fullSearchClassificationPO(field, val);
    }


}
