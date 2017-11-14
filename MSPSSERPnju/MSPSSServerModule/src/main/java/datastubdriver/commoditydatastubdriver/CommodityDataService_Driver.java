package datastubdriver.commoditydatastubdriver;

import dataservice.CommodityDataService;
import filterflags.CommodityFilter;
import org.junit.Test;
import po.ClassificationPO;
import po.CommodityPO;
import util.ResultMessage;

import java.util.Iterator;

/**
 * Project_Name ERPnju
 * Author: HanXinHu
 * Description:
 * Created on 22:36 2017/11/12/012
 */
public class CommodityDataService_Driver {
    private static final    CommodityPO commodityPO = new CommodityPO();
    private static final ClassificationPO classification = new ClassificationPO();
    private static final String testId = "12138";
    private static final CommodityDataService commodityDataService = new CommodityDataService_Stub();
    @Test
    public  void main(){
        ResultMessage testMessage;
        //1
        testMessage = commodityDataService.addCommodity(commodityPO);
        if (testMessage==ResultMessage.SUCCESS)
            System.out.println("succeed");
        else
            System.out.println("failed");

        //2

        testMessage = commodityDataService.addCommodity(null);
        if (testMessage==ResultMessage.SUCCESS)
            System.out.println("succeed");
        else
            System.out.println("failed");
        //3

        testMessage = commodityDataService.modifyCommodity(commodityPO);
        if (testMessage==ResultMessage.SUCCESS)
            System.out.println("succeed");
        else
            System.out.println("failed");

        //4
        testMessage = commodityDataService.deleteCommodity(commodityPO);
        if (testMessage==ResultMessage.SUCCESS)
            System.out.println("succeed");
        else
            System.out.println("failed");

        //5
        testMessage = commodityDataService.addClassification(classification);
        if (testMessage==ResultMessage.SUCCESS)
            System.out.println("succeed");
        else
            System.out.println("failed");

        //6
        testMessage = commodityDataService.modifyClassification(classification);
        if (testMessage==ResultMessage.SUCCESS)
            System.out.println("succeed");
        else
            System.out.println("failed");

        //7
        testMessage = commodityDataService.deleteClassification(testId);
        if (testMessage==ResultMessage.SUCCESS)
            System.out.println("succeed");
        else
            System.out.println("failed");

        //8
        testMessage = commodityDataService.deleteClassification("10000");
        if (testMessage==ResultMessage.SUCCESS)
            System.out.println("succeed");
        else
            System.out.println("failed");

        //9
        ClassificationPO classificationPO = commodityDataService.getClassification(testId);
        if (classificationPO!=null)
            System.out.println("succeed");
        else
            System.out.println("failed");

        //10
        classificationPO = commodityDataService.getClassification("10000");
        if (classificationPO!=null)
            System.out.println("succeed");
        else
            System.out.println("failed");

        //11
        Iterator<ClassificationPO> classificationPOIterator = commodityDataService.getAllClassification();
        if (classificationPOIterator!=null)
            System.out.println("succeed");
        else
            System.out.println("failed");


        //12
        CommodityPO commodityPO = commodityDataService.exactlySearchCommodity(testId);
        if (commodityPO!=null)
            System.out.println("succeed");
        else
            System.out.println("failed");
        //13
        commodityPO = commodityDataService.exactlySearchCommodity("00000");
        if (commodityPO!=null)
            System.out.println("succeed");
        else
            System.out.println("failed");

        //14
        Iterator<CommodityPO> commodityPOIterator;
        commodityPOIterator = commodityDataService.fuzzySearchCommodity("台灯");
        if ( commodityPOIterator !=null)
            System.out.println("succeed");
        else
            System.out.println("failed");

        //16
        commodityPOIterator = commodityDataService.prefixSearchCommodity("台灯");
        if ( commodityPOIterator !=null)
            System.out.println("succeed");
        else
            System.out.println("failed");

        //17
        commodityPOIterator = commodityDataService.rangeSearchCommodity(new CommodityFilter());
        if ( commodityPOIterator !=null)
            System.out.println("succeed");
        else
            System.out.println("failed");
    }
}
