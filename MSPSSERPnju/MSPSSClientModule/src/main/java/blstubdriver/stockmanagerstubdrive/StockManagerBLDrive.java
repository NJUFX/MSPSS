package blstubdriver.stockmanagerstubdrive;

import vo.*;
import blservice.stockmanagerblservice.StockmanagerBLService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

public class StockManagerBLDrive {
    private static final CommodityVO commodityVO = new CommodityVO("挂灯","15寸","12123131",25,30);
    private static final ClassificationVO classificationVO = new ClassificationVO("121","12","台灯");
    private static final AlarmReportVO alarmVO = new AlarmReportVO(commodityVO,121);
    private static final InventoryVO inventoryVO = new InventoryVO("台灯","可折叠",121,13,"1-1-2","1-2-1",new Date());
    private static final StockVO stockVO = new StockVO(InOrOut.IN,121,21);

    public static void main(String[] args) {
        StockmanagerBLService stockmanager = new StockManagerBLStub();
        //t1
        System.out.println(stockmanager.addCommodity("111","台灯","台灯").toString());

        System.out.println(stockmanager.modifyCommodity("112","大台灯","台灯").toString());

        System.out.println(stockmanager.deleteCommodity(commodityVO).toString());

        System.out.println(stockmanager.addClassification("11","台灯").toString());

        System.out.println(stockmanager.modifyCommodity("11","大台灯","台灯"));

        System.out.println(stockmanager.deleteClassification("11"));

         Iterator<ClassificationVO> s = stockmanager.getClassifications();
            for (;s.hasNext();){
                System.out.println(s.next().toString());
            }

           Iterator<CommodityVO> commodityVOIterator = stockmanager.searchCommodity(null);
            while (commodityVOIterator.hasNext()){
                System.out.println(commodityVOIterator.next().toString());
            }

            Iterator<StockVO> stockVOIterator = stockmanager.viewStock(null,null);
            while (stockVOIterator.hasNext()){
                System.out.println(stockVOIterator.next().toString());
            }

            Iterator<InventoryVO> inventoryVOIterator = stockmanager.inventoryCheck();
            while (inventoryVOIterator.hasNext()){
                System.out.println(inventoryVOIterator.next().toString());
            }

        ArrayList<CommodityVO> commodityVOS = new ArrayList<>();
        commodityVOS.add(commodityVO);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(111);
        System.out.println(stockmanager.makeLossAndOverflowReport(commodityVOS,integers));

        System.out.println(stockmanager.makePresentationReport(commodityVOS,integers));

        System.out.println(stockmanager.dealAlarmReport(alarmVO));
    }
}
