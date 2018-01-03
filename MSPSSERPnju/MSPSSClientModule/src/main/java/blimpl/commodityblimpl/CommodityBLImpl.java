package blimpl.commodityblimpl;

import blservice.commodityblservice.CommodityBLService;
import blservice.commodityblservice.CommodityInfoService;
import util.ResultMessage;
import vo.ClassificationVO;
import vo.CommodityVO;
import vo.FilterFlagVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 23:12 2017/11/15/015
 */
public class CommodityBLImpl implements CommodityBLService,CommodityInfoService {
   private Commodity commodity;
   private Classification classification;

    public CommodityBLImpl() {
        commodity = new Commodity();
        classification = new Classification();
    }

    public CommodityBLImpl(Commodity commodity, Classification classification) {
        this.commodity = commodity;
        this.classification = classification;
    }

    @Override
    public ResultMessage addCommodity(CommodityVO cvo) {

        return commodity.addCommodity(cvo);
    }

    @Override
    public ArrayList<CommodityVO> StockAscendingSort(ArrayList<CommodityVO> vos) {
        return commodity.StockAscendingSort(vos);
    }

    @Override
    public ArrayList<CommodityVO> StockDescendingSort(ArrayList<CommodityVO> vos) {
        return commodity.StockDescendingSort(vos);
    }

    @Override
    public ArrayList<CommodityVO> sellPriceDescendingSort(ArrayList<CommodityVO> vos) {
        return commodity.sellPriceDescendingSort(vos);
    }

    @Override
    public ArrayList<CommodityVO> sellPriceAscendingSort(ArrayList<CommodityVO> vos) {
        return commodity.sellPriceAscendingSort(vos);
    }

    @Override
    public ArrayList<CommodityVO> BuyPriceDescendingSort(ArrayList<CommodityVO> vos) {
        return commodity.BuyPriceDescendingSort(vos);
    }

    @Override
    public ArrayList<CommodityVO> BuyPriceAscendingSort(ArrayList<CommodityVO> vos) {
        return commodity.BuyPriceAscendingSort(vos);
    }

    @Override
    public ResultMessage updateCommodity(CommodityVO cvo) {
        return commodity.updateCommodity(cvo);
    }

    @Override
    public ResultMessage deleteCommodity(String id) {
        return commodity.deleteCommodity(id);
    }

    @Override
    public ArrayList<CommodityVO> searchCommodity(FilterFlagVO flags) {
        return commodity.searchCommodity(flags);
    }

    @Override
    public ResultMessage addClassification(ClassificationVO cvo) {
        return classification.addClassification(cvo);
    }

    @Override
    public ResultMessage updateClassification(ClassificationVO cvo) {
        return classification.updateClassification(cvo);
    }

    @Override
    public ResultMessage deleteClassification(String id) {
        return classification.deleteClassification(id);
    }

    @Override
    public ArrayList<ClassificationVO> getChildrenClassification(ClassificationVO classificationVO) {
        return classification.searchChildren(classificationVO);
    }

    @Override
    public ArrayList<CommodityVO> getChildrenCommodity(ClassificationVO classificationVO) {
        FilterFlagVO filterFlagVO = new FilterFlagVO();
        filterFlagVO.setClassificationName(classificationVO.name);
        return commodity.searchCommodity(filterFlagVO);
    }

    @Override
    public ClassificationVO getClassification(String id) {
        return classification.getClassification(id);
    }

    @Override
    public ArrayList<ClassificationVO> getRootClassifications() {
        return classification.getRootClassifications();
    }

    @Override
    public CommodityVO getCommodity(String id) {
        return commodity.getCommodity(id);
    }

    @Override
    public ArrayList<CommodityVO> search(FilterFlagVO vo) {
        return commodity.searchCommodity(vo);
    }

    /**
     * 在进货后，根据商品的进货信息，更新商品的库存均价，以及最近进价
     *
     * @param commodityID
     * @param number
     * @param price
     * @return
     */
    @Override
    public ResultMessage updateCommodityByIn(String commodityID, int number, double price) {

        return commodity.updateCommodityByIn(commodityID, number, price);
    }

    /**
     * 售货后，根据商品的售出信息，更新库存数量，以及最近售价
     * 同时检测是否会出现库存报警现象
     *
     * @param commodityID
     * @param number
     * @param price
     * @return
     */
    @Override
    public ResultMessage updateCommodityByOut(String commodityID, int number, double price) {
        return commodity.updateCommodityByOut(commodityID, number, price);
    }
}
