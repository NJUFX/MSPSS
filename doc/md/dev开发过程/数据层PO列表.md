数据层PO列表

注意：如果有重复的PO，即别人写过了你也要用，那就在属性中增加你需要的属性即可

| **PO****名称**（请以驼峰命名法书写，e.g. SalesBillPO） | **PO****中存储的内容**（e.g.SalesBillPO中存储的是数据层中的销售单据） | PO需要的属性（e.g. SalesBillPO中需要单据编号，请加上数据类型，如String id） | 所属的Data类型                |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- | ------------------------ |
| UserPO                                   | 用户的系统信息                                  | String name(用户名)//String id(账户)//String password//Power power(权限)//String job | SystemData.UserData      |
| SalesBillPO                              | 销售类单据，包括销售进货单和销售退货单                      | String ID;//单据编号 String saler; //销售商String DAE;//默认业务员 String worker;//操作员 String store;//仓库; ArrayList< CommodityPO > prolist; //商品列表 double befSum;//折让前总额  double discount; //折扣double vocher;//代金券 double aftSum;// 折让后总额 String remark; // 备注 | BillData                 |
| PurchaseBillPO                           | 进货单和进货退货单                                | String ID; // 单据编号 String supplier;//供应商     String store;//仓库 String worker;// 操作员 ArrayList< Commodity > prolist; 入库商品列表 double sum;// 总价 String remark; //备注 | BillData                 |
| BillPO                                   | 所有单据的父类，用于制定经营情况表和经营历程表的时候返回所有单据         | String billId//单据编号                      | BillData                 |
| LogPO                                    | 系统日志的详细内容                                | int id;//编号String logText;//日志内容         | SystemData.LogData       |
| PromotionPO                              | 促销策略的父类，对应六个子类PO                         | String type;//促销策略类型String time;// 有效时间区间 | SystemData.PromotionData |
| BillConditionPO                          | 搜索单据时的条件                         |String type;//单据类型 String time//创建时间 String BillId//单据编号 String[] detail  //详细搜索条件,如客户名称等                                        |billData                          |

| **PO****名称**（请以驼峰命名法书写，e.g. SalesBillPO） | **PO****中存储的内容**（e.g.SalesBillPO中存储的是数据层中的销售单据） | PO需要的属性（e.g. SalesBillPO中需要单据编号，请加上数据类型，如String id） | 所属的Data类型            |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- | -------------------- |
| IncomeBillPO                             | 付款单                                      | id(单据编号)//CustomerPO supplier（供应商）//CustomerPO seller(销售商)//UserPO operator(操作员)//ArrayList<TransferPO> tansferlist(转账列表)//long total(总额汇总) | billdataservice      |
| TransferPO                               | 转账信息                                     | BankAccountPO bankaccount(银行账户)//long money(转账金额)//String remarks（备注） | billdataservice      |
| CustomerPO                               | 客户信息                                     | Kind_Of_Costomers kind(客户分类，enum类) <br>String name(名字)//<br>String phonenumber(联系方式)//<br>double paymoney(应付的钱，之前遗留、赊账)//<br>double incomemoney(应收的钱，之前遗留的)//<br>double Invalue（应收额度）<br>BankAccountPO bankaccount(银行账号)<br>String ID（客户编号）<br>String category（分类，供应商或者销售商）<br>int level（等级）<br>String address（地址）<br>String postcode（邮编）String email（电子邮箱）<br>String DAE（默认业务员） | customerdataservice  |
| BankAccountPO                            | 银行账户信息                                   | String name//String id(银行账号)//long money//UserPO creator(建账人员) | systemdataservice    |
| PayBIll                                  | 付款单                                      | String  id(单据编号)//UserPO operator(操作员即当前登录用户)//BanAccountPO account(银行账户)//ArrayList<TermsPO> terms(条目清单)//long total(总额) | billdataservice      |
| TermsPO                                  | 条目清单                                     | String cases(条目名)//long money//String remarks | billdataservice      |
| FinalAccountPO                           | 期初建账信息                                   | String name//ArrayList< CommodityPO > commodity(商品信息)//ArrayList< CostomerPO > costomer(客户信息)//BankAccount bankaccount(银行账户信息) | systemdataservice    |
| CommodityPO                              | 商品信息                                     | Kind_Of_Commodity kind(商品类别，enum)//<br>String model(型号)//<br> double averageimportcost(上半年进价)//<br>double averageexportcost(上半年平均售价)//<br>double recentimportcost(最近一次进价)//<br>double recentexportcost(最近一次售价)<br>String ID(商品编号)<br>String name(商品名称)<br>int quanity(调用数量)<br>number(库存数量)<br> importcost(进价)<br> exportcost(售价) | commoditydataservice |
|                                          |                                          |                                          |                      |

| **PO****名称**（请以驼峰命名法书写，e.g. SalesBillPO） | **PO****中存储的内容**（e.g.SalesBillPO中存储的是数据层中的销售单据） | PO需要的属性（e.g. SalesBillPO中需要单据编号，请加上数据类型，如String id） | 所属的Data类型                                |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| ClassificationPO                         | 商品分类信息                                   | commoditydataservice                     | id  string商品分类标号<br> name  string 名称<br> parentClassification  父分类 classification<br> |
| InventoryPO                              | 库存信息                                     | stockdataservice                         | name string商品的名称、type型号，int库存数量，double库存均价，string批次，string批号，出厂日期 |
| StockPO                                  | 出入库信息                                    | stockdatatservice                        | numberOfINOrOut int 出/入库数量 moneyOfINOrOut double /金额，numberOfINOrOut int销售/进货的数量 moneyOfINOrOuts double /金额 |

