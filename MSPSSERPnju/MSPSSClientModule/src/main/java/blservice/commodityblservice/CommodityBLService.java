package blservice.commodityblservice;

import exception.dataexception.NegativeException;
import exception.timeexception.TimeFormatException;
import exception.timeexception.TimeRangeException;
import util.ResultMessage;
import vo.ClassificationVO;
import vo.CommodityVO;
import vo.FilterFlagVO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Project_Name ERPnju
 * Author: HanXinHu
 * Description:
 * Created on 14:18 2017/11/11/011
 */
public interface CommodityBLService {
    /**
     *  添加新的商品
     * @param cvo
     * @return
     */
    public ResultMessage addCommodity(CommodityVO cvo);

    /**
     * 更新商品信息
     * @param cvo
     * @return
     */
    public ResultMessage updateCommodity(CommodityVO cvo);

    /**
     * 删除指定的商品
     * @param id 商品编号
     * @return
     */
    public ResultMessage deleteCommodity(String id);

    /**
     * 搜索商品
     * @param flags
     * @return
     */
    public ArrayList<CommodityVO> searchCommodity(FilterFlagVO flags);

    /**
     * 添加商品分类信息
     * @param cvo
     * @return
     */
    public ResultMessage addClassification(ClassificationVO cvo);

    /**
     * 更新商品信息
     * @param cvo
     * @return
     */
    public ResultMessage updateClassification(ClassificationVO cvo);

    /**
     * 删除商品信息
     *
     * @param id@return
     */
    public ResultMessage deleteClassification(String id);

    /**
     * 获得商品分类
     * @param id
     * @return
     */
    public ClassificationVO getClassification(String id);

    /**
     * 获得一个商品分类的所有子分类
     * @param classificationVO
     * @return
     */
    public ArrayList<ClassificationVO> getChildrenClassification(ClassificationVO classificationVO);

    /**
     * 获得一个商品下的所有商品
     * @param classificationVO
     * @return
     */
    public ArrayList<CommodityVO> getChildrenCommodity(ClassificationVO classificationVO);
    /**
     * 得到所有的商品分类
     * @return
     */
    public ArrayList<ClassificationVO> getRootClassifications();

    /**
     * 根据商品的库存数量升序排列
     * @param vos
     * @return
     */
    public ArrayList< CommodityVO> StockAscendingSort(ArrayList< CommodityVO> vos);

    /**
     * 根据商品的库存数量降序排列
     * @param vos
     * @return
     */
    public ArrayList< CommodityVO> StockDescendingSort(ArrayList< CommodityVO> vos);

    /**
     * 根据售价降序排列
     * @param vos
     * @return
     */
    public ArrayList< CommodityVO> sellPriceDescendingSort(ArrayList< CommodityVO> vos);

    /**
     * 根据售价升序排列
     * @param vos
     * @return
     */
    public ArrayList< CommodityVO> sellPriceAscendingSort(ArrayList< CommodityVO> vos);

    /**
     * 根据商品进价升序排列
     * @param vos
     * @return
     */
    public ArrayList< CommodityVO> BuyPriceDescendingSort(ArrayList< CommodityVO> vos);

    /**
     * 根据商品进价升序排列
     * @param vos
     * @return
     */
    public ArrayList< CommodityVO> BuyPriceAscendingSort(ArrayList< CommodityVO> vos);
}
