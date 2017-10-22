package blstubdriver.stockmanagerstubdrive;
import VO.*;

import blservice.stockmanagerblservice.StockmanagerBLService;
import util.ResultMessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

public class StockManagerBLStub implements StockmanagerBLService {
    @Override
    public ResultMessage addCommodity(String ID, String name, String type) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage modifyCommodity(String ID, String new_name, String new_type) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage deleteCommodity(CommodityVO commodity_vo) {
        return ResultMessage.FAILED;
    }

    @Override
    public Iterator<CommodityVO> searchCommodity(FilterFlagVO flagvo) {
        ArrayList<CommodityVO> commodityVOS = new ArrayList<>() ;
        commodityVOS.add(new  CommodityVO("挂灯","15寸","12123131",25,30));
        commodityVOS.add(new  CommodityVO("挂灯","12寸","15352131",20,24));
        commodityVOS.add(new  CommodityVO("壁灯", "8寸","12588131",50,60));
        commodityVOS.add(new  CommodityVO("台灯","黑白色","15856131",25,30));
        commodityVOS.add(new  CommodityVO("台灯","红色","12147131",25,30));
        return commodityVOS.iterator();
    }

    @Override
    public CommodityVO getCommodity(String ID) {
        return new CommodityVO("台灯", "触摸可调亮度",ID,50,60);
    }

    @Override
    public ResultMessage addClassification(String parentID, String name) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage deleteClassification(String ID) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage modifyClassification(String ID, String newParentID, String newName) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public Iterator<ClassificationVO> getClassifications() {
        ArrayList<ClassificationVO> classificationVOS = new ArrayList<>();
        classificationVOS.add(new ClassificationVO("12318","12315","台灯"));
        classificationVOS.add(new ClassificationVO("12320","12318","黑色台灯"));
        classificationVOS.add(new ClassificationVO("12325","12318","红色台灯"));
        return classificationVOS.iterator();

    }
    @Override
    public Iterator<StockVO> viewStock(String startTime, String endTime) {
        ArrayList stocks = new ArrayList();
        stocks.add(new StockVO(InOrOut.IN,1221,121));
        stocks.add(new StockVO(InOrOut.OUT,321,221));
        stocks.add(new StockVO(InOrOut.OUT,3421,23));
        stocks.add(new StockVO(InOrOut.IN,21,211));

        return stocks.iterator();
    }

    @Override
    public Iterator<InventoryVO> inventoryCheck() {
        ArrayList<InventoryVO> inventoryVOS = new ArrayList<>();
        inventoryVOS.add(new InventoryVO("台灯","可挂式",131,113,"1-1-2","1-2-3", new Date()));
        inventoryVOS.add(new InventoryVO("台灯","可折叠式",233,123,"1-1-2","1-2-2", new Date()));
        inventoryVOS.add(new InventoryVO("台灯","可折叠可挂",131,213,"1-1-2","1-2-1", new Date()));
        inventoryVOS.add(new InventoryVO("台灯","可调亮度",111,313,"1-1-2","1-2-2", new Date()));
        inventoryVOS.add(new InventoryVO("台灯","可调亮度",131,313,"1-1-2","1-2-4", new Date()));
        return inventoryVOS.iterator();
    }

    @Override
    public ResultMessage makeLossAndOverflowReport(ArrayList<CommodityVO> commodityVO, ArrayList<Integer> numbers) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage makePresentationReport(ArrayList<CommodityVO> commodity, ArrayList<Integer> numbers) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage dealAlarmReport(AlarmReportVO report) {
        return ResultMessage.SUCCESS;
    }
}
