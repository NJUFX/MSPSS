//package blstubdriver.commoditystubdriver;
//
//import blservice.commodityblservice.CommodityBLService;
//import blservice.commodityblservice.CommodityInfoService;
//import util.ResultMessage;
//import vo.ClassificationVO;
//import vo.CommodityVO;
//import vo.FilterFlagVO;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//
///**
// * Project_Name ERPnju
// * Author: HanXinHu
// * Description:
// * Created on 14:38 2017/11/11/011
// */
//public class CommodityBL_Stub implements CommodityBLService,CommodityInfoService{
//    @Override
//    public ResultMessage addCommodity(CommodityVO cvo) {
//        System.out.println("add commodity successfully!");
//        return ResultMessage.SUCCESS;
//    }
//
//    @Override
//    public ResultMessage updateCommodity(CommodityVO cvo) {
//        System.out.println("update commodity successfully!");
//        return ResultMessage.SUCCESS;
//    }
//
//    @Override
//    public ResultMessage deleteCommodity(String id) {
//        if (id.equals("12138")){
//            System.out.println("delete commodity successfully!");
//            return ResultMessage.SUCCESS;
//        }
//        else{
//            System.out.println("commodity doesn't exists");
//            return ResultMessage.FAILED;
//        }
//
//    }
//
//    @Override
//    public Iterator<CommodityVO> searchCommodity(FilterFlagVO flags) {
//        if (flags!=null){
//            System.out.println("timeSearchLog commodity successfully!");
//            return new ArrayList<CommodityVO>().iterator();
//        }else
//        {
//            System.out.println("timeSearchLog failed");
//            return null;
//        }
//
//    }
//
//    @Override
//    public ResultMessage addClassification(ClassificationVO cvo) {
//        System.out.println("add classificationName successfully!");
//        return ResultMessage.SUCCESS;
//    }
//
//    @Override
//    public ResultMessage updateClassification(ClassificationVO cvo) {
//        System.out.println("update classificationName successfully");
//        return ResultMessage.SUCCESS;
//    }
//
//    @Override
//    public ResultMessage deleteClassification(String id) {
//        if (id.equals("12138"))
//        {
//            System.out.println("delete classificationName successfully");
//            return ResultMessage.SUCCESS;
//        }
//        else
//        {
//            System.out.println("delete classificationName failed");
//            return ResultMessage.FAILED;
//        }
//    }
//
//    @Override
//    public ClassificationVO getClassification(String id) {
//        if (id.equals("12138"))
//            return new ClassificationVO("12138","吊灯");
//        else
//            return null;
//    }
//
//    @Override
//    public ArrayList<ClassificationVO> getRootClassifications() {
//        return new ArrayList<ClassificationVO>();
//    }
//
//    @Override
//    public ArrayList<CommodityVO> StockAscendingSort(ArrayList<CommodityVO> vos) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<CommodityVO> StockDescendingSort(ArrayList<CommodityVO> vos) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<CommodityVO> sellPriceDescendingSort(ArrayList<CommodityVO> vos) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<CommodityVO> sellPriceAscendingSort(ArrayList<CommodityVO> vos) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<CommodityVO> BuyPriceDescendingSort(ArrayList<CommodityVO> vos) {
//        return null;
//    }
//
//    @Override
//    public ArrayList<CommodityVO> BuyPriceAscendingSort(ArrayList<CommodityVO> vos) {
//        return null;
//    }
//
//    @Override
//    public CommodityVO getCommodity(String id) {
//        if (id.equals("12138"))
//        return new CommodityVO("大吊灯","蓝色","12138",1,2);
//        else
//         return null;
//    }
//
//    @Override
//    public ArrayList<CommodityVO> timeSearchLog(FilterFlagVO vo) {
//        return null;
//    }
//}
