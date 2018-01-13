package blstubdriver.commoditystubdriver;

import blservice.commodityblservice.CommodityBLService;
import blservice.commodityblservice.CommodityInfoService;
import org.junit.Test;
import util.ResultMessage;
import vo.ClassificationVO;
import vo.CommodityVO;
import vo.FilterFlagVO;

import java.util.ArrayList;

/**
 * Project_Name ERPnju
 * Author: HanXinHu
 * Description:
 * Created on 14:38 2017/11/11/011
 */
public class CommodityBL_Driver {
    private static final CommodityVO cvo1 = new CommodityVO("吊灯", "蓝色", null, 1, 2);
    private static final CommodityVO cvo2 = new CommodityVO("台灯", "红色", null, 2, 2);
    private static final String testID = "12138";
    private static final CommodityInfoService commodityInfoService = new CommodityBL_Stub();
    private static final CommodityBLService commodityService = new CommodityBL_Stub();
    private static final FilterFlagVO fvo = new FilterFlagVO();
    private static final ClassificationVO classificationVO = new ClassificationVO("台灯");

    @Test
    public void drive() {
        ResultMessage testMessage;

        //1
        testMessage = commodityService.addCommodity(cvo1);
        if (testMessage == ResultMessage.SUCCESS) {
            System.out.println("add success");
        } else
            System.out.println("add failed");

        //2
        testMessage = commodityService.updateCommodity(cvo1);
        if (testMessage == ResultMessage.SUCCESS)
            System.out.println("update successfully");
        else
            System.out.println("update failed");

        //3
        testMessage = commodityService.deleteCommodity("000001");
        if (testMessage == ResultMessage.SUCCESS)
            System.out.println("delete successfully");
        else
            System.out.println("delete failed");
        //4
        testMessage = commodityService.deleteCommodity(testID);
        if (testMessage == ResultMessage.SUCCESS)
            System.out.println("delete successfully");
        else
            System.out.println("delete failed");

        //5
        ArrayList<CommodityVO> commodityVOS = commodityService.searchCommodity(fvo);
        if (commodityVOS != null) {
            System.out.println("timeSearchLog successfully");
        } else {
            System.out.println("timeSearchLog failed");
        }
        //5
        commodityVOS = commodityService.searchCommodity(null);
        if (commodityVOS != null) {
            System.out.println("timeSearchLog successfully");
        } else {
            System.out.println("timeSearchLog failed");
        }
        //6
        testMessage = commodityService.addClassification(classificationVO);
        if (testMessage == ResultMessage.SUCCESS)
            System.out.println("add successfully");
        else
            System.out.println("add failed");
        //6
        testMessage = commodityService.updateClassification(classificationVO);
        if (testMessage == ResultMessage.SUCCESS)
            System.out.println("update successfully");
        else
            System.out.println("update failed");
        //7
        testMessage = commodityService.deleteClassification(testID);
        if (testMessage == ResultMessage.SUCCESS)
            System.out.println("delete successfully");
        else
            System.out.println("delete failed");
        //8
        testMessage = commodityService.deleteClassification("122");
        if (testMessage == ResultMessage.SUCCESS)
            System.out.println("delete successfully");
        else
            System.out.println("delete failed");

        //9
        testMessage = commodityInfoService.addCommodity(cvo2);
        if (testMessage == ResultMessage.SUCCESS)
            System.out.println("add successfully");
        else
            System.out.println("add failed");
        //10
        testMessage = commodityInfoService.updateCommodity(cvo2);
        if (testMessage == ResultMessage.SUCCESS)
            System.out.println("update successfully");
        else
            System.out.println("update failed");
        //11
        CommodityVO commodityVO = commodityInfoService.getCommodity("1");
        if (commodityVO == null)
            System.out.println("get failed");
        else
            System.out.println("get successfully");

        //12
        commodityVO = commodityInfoService.getCommodity(testID);
        if (commodityVO == null)
            System.out.println("get failed");
        else
            System.out.println("get successfully");


        //13
        ClassificationVO classificationVO1 = commodityService.getClassification(testID);
        if (classificationVO1 == null) {
            System.out.println("get failed");
        } else
            System.out.println("get successfully");
        //14
        classificationVO1 = commodityService.getClassification("1");
        if (classificationVO1 == null) {
            System.out.println("get failed");
        } else
            System.out.println("get successfully");

        //15
        ArrayList<ClassificationVO> classificationVOS = commodityService.getRootClassifications();
        if (classificationVOS == null)
            System.out.println("get failed");
        else
            System.out.println("get successfully");
    }

}
