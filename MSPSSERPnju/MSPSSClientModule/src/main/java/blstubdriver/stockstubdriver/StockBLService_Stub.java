//package blstubdriver.stockstubdriver;
//
//import blservice.stockbl.StockBLInfo;
//import blservice.stockbl.StockBLService;
//import util.ResultMessage;
//import vo.BillVO;
//import vo.CommodityStockVO;
//import vo.StockVO;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//
///**
// * Project_Name ERPnju
// * Author: HanXinHu
// * Description:
// * Created on 16:09 2017/11/11/011
// */
//public class StockBLService_Stub implements StockBLInfo,StockBLService {
//    @Override
//    public ResultMessage updateStockAndInventory(BillVO billVO) {
//        if (billVO!=null)
//        {
//            System.out.println("update successfully");
//            return ResultMessage.SUCCESS;
//        }
//        else {
//            System.out.println("update failed");
//            return ResultMessage.FAILED;
//        }
//    }
//
//    @Override
//    public Iterator<StockVO> viewStock(String startTime, String endTime) {
//        if (startTime!=null&&endTime!=null){
//            System.out.println("there are all stock_info");
//            return new ArrayList<StockVO>().iterator();
//        }else
//            System.out.println("view failed");
//        return null;
//    }
//
//    @Override
//    public Iterator<CommodityStockVO> checkInventory() {
//       return new ArrayList<CommodityStockVO>().iterator();
//    }
//}
