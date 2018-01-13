package commodity;

import blimpl.blfactory.BLFactoryImpl;
import blservice.commodityblservice.CommodityBLService;
import org.junit.Test;
import util.ResultMessage;
import vo.ClassificationVO;
import vo.CommodityVO;
import vo.FilterFlagVO;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Description:
 * Created by Hanxinhu at 17:54 2018/1/3/003
 */
public class CommodityTest {
    private static final CommodityBLService commodityBLService = new BLFactoryImpl().getCommodityBLService();

    @Test
    public void test1() {
        FilterFlagVO filterFlagVO = new FilterFlagVO();
        filterFlagVO.setClassificationName("123456");
        ArrayList<CommodityVO> vos = commodityBLService.searchCommodity(filterFlagVO);
        System.out.println(vos.size());
        assertEquals(0, vos.size());
    }

    @Test
    public void test2() {
        ClassificationVO classificationVO = new ClassificationVO("test");
        ResultMessage message = commodityBLService.addClassification(classificationVO);
        String ID = classificationVO.getID();
        assertEquals(ResultMessage.SUCCESS, message);
        commodityBLService.deleteClassification(ID);
    }

    @Test
    public void test3() {
        ClassificationVO classificationVO = new ClassificationVO("test");
        commodityBLService.addClassification(classificationVO);
        ClassificationVO classificationVO1 = new ClassificationVO("test1", classificationVO);
        commodityBLService.addClassification(classificationVO1);
        ArrayList<ClassificationVO> list = commodityBLService.getChildrenClassification(classificationVO);
        assertEquals(true, list.size() != 0);
        commodityBLService.deleteClassification(classificationVO.getID());
        commodityBLService.deleteClassification(classificationVO1.getID());
    }

    @Test
    public void test4() {
        ClassificationVO classificationVO = new ClassificationVO("test2");
        commodityBLService.addClassification(classificationVO);
        ClassificationVO classificationVO1 = new ClassificationVO("test3", classificationVO);
        commodityBLService.addClassification(classificationVO1);
        ArrayList<ClassificationVO> list = commodityBLService.getChildrenClassification(classificationVO);
        assertEquals(true, list.size() != 0);
        commodityBLService.deleteClassification(classificationVO.getID());
        commodityBLService.deleteClassification(classificationVO1.getID());
    }

    @Test
    public void test5() {
        ClassificationVO classificationVO = new ClassificationVO("test4");
        commodityBLService.addClassification(classificationVO);
        ClassificationVO classificationVO1 = new ClassificationVO("test5", classificationVO);
        commodityBLService.addClassification(classificationVO1);
        ArrayList<ClassificationVO> list = commodityBLService.getChildrenClassification(classificationVO);
        assertEquals(true, list.size() != 0);
        commodityBLService.deleteClassification(classificationVO.getID());
        commodityBLService.deleteClassification(classificationVO1.getID());
    }

    @Test
    public void test6() {
        ClassificationVO classificationVO = new ClassificationVO("test4");
        commodityBLService.addClassification(classificationVO);
        CommodityVO commodityVO = new CommodityVO("littel deng", "sad", "C", 1000, 1000);
        commodityBLService.addCommodity(commodityVO);
        System.out.println(commodityVO.getID());
        assertEquals(true, classificationVO.getID() != null);
    }

    @Test
    public void test7() {
        System.out.println(commodityBLService.getRootClassifications().size());
    }

}
