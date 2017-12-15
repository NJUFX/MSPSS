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
     * 得到所有的商品分类
     * @return
     */
    public ArrayList<ClassificationPO> getAllClassification();

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
