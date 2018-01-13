package bill;

import blimpl.blfactory.BLFactoryImpl;
import blservice.billblservice.StockManagerBillBLService;
import blservice.commodityblservice.CommodityBLService;
import blservice.userblservice.UserBLService;
import network.BillClientNetworkImpl;
import network.BillClientNetworkService;
import org.junit.Test;
import po.FinanceBillPO;
import util.*;
import vo.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BillTest {
 StockManagerBillBLService stockManagerBillBLService = new BLFactoryImpl().getStockManagerBillBLService();
 BillClientNetworkService billClientNetworkService = new BillClientNetworkImpl();
 CommodityBLService commodityBLService = new BLFactoryImpl().getCommodityBLService();
 UserBLService userBLService = new BLFactoryImpl().getUserBLService();
 private static final CommodityVO commodity1 = new CommodityVO("LED灯", "12138", "IEEE-0001", 10, 10, 100);
 private static final CommodityVO commodity2 = new CommodityVO("LED灯", "12138", "IEEE-0002", 10, 11, 110);
 private static final CommodityVO commodity3 = new CommodityVO("LED灯", "12138", "IEEE-0003", 10, 12, 120);
 private static final CommodityVO commodity4 = new CommodityVO("LED灯", "12138", "IEEE-0004", 10, 13, 130);
 private static final CommodityVO commodity5 = new CommodityVO("LED灯", "12138", "IEEE-0005", 10, 14, 140);
 private static final CommodityVO commodity6 = new CommodityVO("LED灯", "12138", "IEEE-0006", 10, 15, 150);
 private static final CommodityVO commodity7 = new CommodityVO("LED灯", "12138", "IEEE-0007", 10, 16, 160);
 private static final CommodityVO commodity8 = new CommodityVO("LED灯", "12138", "IEEE-0008", 10, 17, 170);
 private static final CommodityVO commodity9 = new CommodityVO("LED灯", "12138", "IEEE-0009", 10, 18, 180);
 private static final UserVO stockManager = new UserVO("sm", "hanxinhu", Kind_Of_Users.StockManager, "111", "hanxinhu521@163.com");
 private static final UserVO manager = new UserVO("sm", "hanxinhu", Kind_Of_Users.StockManager, "111", "hanxinhu521@163.com");
 private static final CustomerVO customer = new CustomerVO("1", Kind_Of_Customers.SUPPLIER, 2, "hanqi",
         "10086", "NJ", "210046", "hxh@foxmail.com", 100, 1000, 100, "hemusheng");
 private static final AccountVO accountVO1 = new AccountVO("HuaQi", 111, new Time());
 private static final AccountVO accountVO2 = new AccountVO("zhaoshang", 1111111, new Time());

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

 @Test
 public void test4() {
  ArrayList<SalesItemVO> salesItemVOS = new ArrayList<>();
  salesItemVOS.add(new SalesItemVO(commodity9, 1, 12));
  salesItemVOS.add(new SalesItemVO(commodity8, 1, 12));
  salesItemVOS.add(new SalesItemVO(commodity7, 1, 12));
  salesItemVOS.add(new SalesItemVO(commodity6, 1, 12));
  salesItemVOS.add(new SalesItemVO(commodity5, 1, 12));
  salesItemVOS.add(new SalesItemVO(commodity4, 1, 12));
  SalesOutBillVO salesOutBillVO1 = new SalesOutBillVO("xsd-20121212-00011", "小黄", "第一仓库",
          SalesOutBillType.OUT, 11, 11, customer, manager, null, salesItemVOS, new Time(), new Time(),
          null, BillStatus.commit);
  assertEquals(true, salesOutBillVO1 != null);
 }

 @Test
 public void test5() {
  ArrayList<SalesItemVO> salesItemVOS = new ArrayList<>();
  salesItemVOS.add(new SalesItemVO(commodity9, 1, 12));
  salesItemVOS.add(new SalesItemVO(commodity8, 1, 12));
  salesItemVOS.add(new SalesItemVO(commodity7, 1, 12));
  salesItemVOS.add(new SalesItemVO(commodity6, 1, 12));
  salesItemVOS.add(new SalesItemVO(commodity5, 1, 12));
  SalesOutBillVO salesOutBillVO1 = new SalesOutBillVO("xsd-20121212-00011", "小黄", "第一仓库",
          SalesOutBillType.OUT, 11, 11, customer, manager, null, salesItemVOS, new Time(), new Time(),
          null, BillStatus.commit);
  assertEquals(true, salesOutBillVO1 != null);
 }

 @Test
 public void test7() {
  ArrayList<SalesItemVO> salesItemVOS = new ArrayList<>();
  salesItemVOS.add(new SalesItemVO(commodity9, 1, 12));
  salesItemVOS.add(new SalesItemVO(commodity8, 1, 12));
  salesItemVOS.add(new SalesItemVO(commodity6, 1, 12));
  salesItemVOS.add(new SalesItemVO(commodity5, 1, 12));
  SalesOutBillVO salesOutBillVO1 = new SalesOutBillVO("xsd-20121212-00011", "小黄", "第一仓库",
          SalesOutBillType.OUT, 11, 11, customer, manager, null, salesItemVOS, new Time(), new Time(),
          null, BillStatus.commit);
  assertEquals(true, salesOutBillVO1 != null);
 }
}
