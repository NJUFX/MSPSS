package blimpl.commodityblimpl;

import blservice.commodityblservice.CommodityBLService;
import blservice.commodityblservice.CommodityInfoService;
import util.ResultMessage;
import vo.ClassificationVO;
import vo.CommodityVO;
import vo.FilterFlagVO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Description:
 * Created by Hanxinhu at 23:12 2017/11/15/015
 */
public class CommodityBLImpl implements CommodityBLService,CommodityInfoService {
   private Commodity commodity = new Commodity();
   private Classification classification = new Classification();
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
        return deleteCommodity(id);
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
    public ClassificationVO getClassification(String id) {
        return classification.getClassification(id);
    }

    @Override
    public ArrayList<ClassificationVO> getAllClassification() {
        return classification.getAllClassification();
    }

    @Override
    public CommodityVO getCommodity(String id) {
        return null;
    }

    @Override
    public ArrayList<CommodityVO> search(FilterFlagVO vo) {
        return null;
    }
}
