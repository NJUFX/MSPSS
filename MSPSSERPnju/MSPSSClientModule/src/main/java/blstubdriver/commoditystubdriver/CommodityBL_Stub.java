package blstubdriver.commoditystubdriver;

import blservice.commodityblservice.CommodityBLService;
import blservice.commodityblservice.CommodityInfoService;
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
 * Created on 14:38 2017/11/11/011
 */
public class CommodityBL_Stub implements CommodityBLService,CommodityInfoService{
    @Override
    public ResultMessage addCommodity(CommodityVO cvo) {
        System.out.println("add commodity successfully!");
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage updateCommodity(CommodityVO cvo) {
        System.out.println("update commodity successfully!");
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage deleteCommodity(String id) {
        if (id.equals("12138")){
            System.out.println("delete commodity successfully!");
            return ResultMessage.SUCCESS;
        }
        else{
            System.out.println("commodity doesn't exists");
            return ResultMessage.FAILED;
        }

    }

    @Override
    public Iterator<CommodityVO> searchCommodity(FilterFlagVO flags) {
        if (flags!=null){
            System.out.println("search commodity successfully!");
            return new ArrayList<CommodityVO>().iterator();
        }else
        {
            System.out.println("search failed");
            return null;
        }

    }

    @Override
    public ResultMessage addClassification(ClassificationVO cvo) {
        System.out.println("add classification successfully!");
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage updateClassification(ClassificationVO cvo) {
        System.out.println("update classification successfully");
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage deleteClassification(String id) {
        if (id.equals("12138"))
        {
            System.out.println("delete classification successfully");
            return ResultMessage.SUCCESS;
        }
        else
        {
            System.out.println("delete classification failed");
            return ResultMessage.FAILED;
        }
    }

    @Override
    public ClassificationVO getClassification(String id) {
        if (id.equals("12138"))
            return new ClassificationVO("12138","吊灯");
        else
            return null;
    }

    @Override
    public ArrayList<ClassificationVO> getAllClassification() {
        return new ArrayList<ClassificationVO>();
    }

    @Override
    public CommodityVO getCommodity(String id) {
        if (id.equals("12138"))
        return new CommodityVO("大吊灯","蓝色","12138",1,2);
        else
         return null;
    }
}
