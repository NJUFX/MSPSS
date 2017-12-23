package network;

import network.accountnetworkservice.AccountServerNetworkService;
import network.commoditynetworkservice.CommodityServerNetworkService;
import po.ClassificationPO;
import po.CommodityPO;
import util.ResultMessage;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/12/14.
 */
public class CommodityClientNetworkImpl implements CommodityClientNetworkService {
    private CommodityServerNetworkService commodityServerNetworkService;

    public CommodityClientNetworkImpl(){
        try {
            commodityServerNetworkService = (CommodityServerNetworkService) Naming.lookup("CommodityServerNetworkService");
        } catch (NotBoundException e) {
            System.err.println("Client.network.CommodityServerNetworkService: Not bound, trying to connect");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加商品
     * @param commodityPO
     * @return
     */
    public ResultMessage addCommodity(CommodityPO commodityPO){
        try{
            return commodityServerNetworkService.addCommodity(commodityPO);
        }catch(RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新商品信息
     * @param commodityPO
     * @return
     */
    public ResultMessage modifyCommodity(CommodityPO commodityPO){
        try{
          return commodityServerNetworkService.modifyCommodity(commodityPO);
        }catch(RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除商品
     * @param commodityPO
     * @return
     */
    public ResultMessage deleteCommodity(CommodityPO commodityPO){
        try{
          return commodityServerNetworkService.deleteCommodity(commodityPO);
        }catch(RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 精确查找商品
     * @param id
     * @return
     */
    public CommodityPO exactlySearchCommodity(String id){
        try{
            return commodityServerNetworkService.exactlySearchCommodity(id);
        }catch(RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CommodityPO> fullSearchCommodity(String field, Object value){
        try{
          return commodityServerNetworkService.fullSearchCommodity(field, value);
        }catch(RemoteException e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     *
     * @param filed
     * @param value
     * @return
     */
    public ArrayList<CommodityPO> fuzzySearchCommodity(String filed,String value){
        try{
             return commodityServerNetworkService.fuzzySearchCommodity(filed, value);
        }catch(RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param field
     * @param min
     * @param max
     * @return
     */
    public ArrayList<CommodityPO> rangeSearchCommodity(String field, Object min, Object max){
        try{
          return commodityServerNetworkService.rangeSearchCommodity(field, min, max);
        }catch(RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加商品分类
     * @param classificationPO
     * @return
     */
    public ResultMessage addClassification(ClassificationPO classificationPO){
        try{
          return commodityServerNetworkService.addClassification(classificationPO);
        }catch(RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新商品分类信息
     * @param classificationPO
     * @return
     */
    public ResultMessage updateClassification(ClassificationPO classificationPO){
        try{
            return commodityServerNetworkService.updateClassification(classificationPO);
        }catch(RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除商品分类
     * @param id
     * @return
     */
    public ResultMessage deleteClassification(String id){
        try{
        return commodityServerNetworkService.deleteClassification(id);
        }catch(RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 得到所有的商品分类
     * @return
     */
    public ArrayList<ClassificationPO> getAllClassification(){
        try{
            return commodityServerNetworkService.getAllClassification();
        }catch(RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据当前的id查找到该节点下的子分类
     */
    public ArrayList<ClassificationPO> getChildrenClassification(String id){
        try{
           return commodityServerNetworkService.getChildrenClassification(id);
        }catch(RemoteException e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 得到特定的商品分类
     * @param id
     * @return
     */
    public ClassificationPO getClassification(String id){
        try{
            return commodityServerNetworkService.getClassification(id);
        }catch(RemoteException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 完全比配查找
     * @param field
     * @param val
     * @return
     */
    public ArrayList<ClassificationPO> fullSearchClassificationPO(String field,String val){
        try{
             return commodityServerNetworkService.fullSearchClassificationPO(field, val);
        }catch(RemoteException e){
            e.printStackTrace();
        }
        return null;
    }
}
