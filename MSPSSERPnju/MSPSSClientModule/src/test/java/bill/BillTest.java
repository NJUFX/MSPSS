package bill;

import blimpl.blfactory.BLFactoryImpl;
import blservice.commodityblservice.CommodityBLService;
import blservice.userblservice.UserBLService;
import network.BillClientNetworkImpl;
import network.BillClientNetworkService;
import org.junit.Test;
import po.FinanceBillPO;
import util.FinanceBillType;
import util.ResultMessage;
import util.StockBillType;
import vo.CommodityVO;
import vo.FilterFlagVO;
import vo.StockBillItemVO;
import vo.StockBillVO;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

public class BillTest {
 BillClientNetworkService billClientNetworkService = new BillClientNetworkImpl();
 CommodityBLService commodityBLService = new BLFactoryImpl().getCommodityBLService();
 UserBLService userBLService = new BLFactoryImpl().getUserBLService();
 @Test
  public void test1(){String ID = billClientNetworkService.getFinanceBillID(FinanceBillType.IN);
     System.out.println(ID);
  assertNotNull(ID);
 }
 @Test
 public void test2(){
  FinanceBillPO po = new FinanceBillPO();
  po.setID("String ");
ResultMessage message = billClientNetworkService.addFinanceBill(po);
 assertNotNull(message);
 }
 @Test
 public void test3(){
  FilterFlagVO filterFlagVO = new FilterFlagVO();
  filterFlagVO.setId("121");
  ArrayList<CommodityVO> commodityVOS = commodityBLService.searchCommodity(filterFlagVO);
  StockBillItemVO item = new StockBillItemVO(commodityVOS.get(0),122);
  ArrayList<StockBillItemVO> items = new ArrayList<>();
  items.add(item);
  StockBillVO vo = new StockBillVO(StockBillType.Less,items,"",userBLService.searchUserByID("CM-123"));
  assertNotNull(vo.getId());
 }

}
