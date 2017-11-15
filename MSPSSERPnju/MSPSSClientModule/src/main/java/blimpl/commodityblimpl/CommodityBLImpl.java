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
    Commodity commodity;
    Classification classification;
    @Override
    public ResultMessage addCommodity(CommodityVO cvo) {
        return null;
    }

    @Override
    public ResultMessage updateCommodity(CommodityVO cvo) {
        return null;
    }

    @Override
    public ResultMessage deleteCommodity(String id) {
        return null;
    }

    @Override
    public Iterator<CommodityVO> searchCommodity(FilterFlagVO flags) {
        return null;
    }

    @Override
    public ResultMessage addClassification(ClassificationVO cvo) {
        return null;
    }

    @Override
    public ResultMessage updateClassification(ClassificationVO cvo) {
        return null;
    }

    @Override
    public ResultMessage deleteClassification(String id) {
        return null;
    }

    @Override
    public ClassificationVO getClassification(String id) {
        return null;
    }

    @Override
    public ArrayList<ClassificationVO> getAllClassification() {
        return null;
    }

    @Override
    public CommodityVO getCommodity(String id) {
        return null;
    }
}
