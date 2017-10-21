数据层PO列表

注意：如果有重复的PO，即别人写过了你也要用，那就在属性中增加你需要的属性即可

| **PO****名称**（请以驼峰命名法书写，e.g. SalesBillPO） | **PO****中存储的内容**（e.g.SalesBillPO中存储的是数据层中的销售单据） | PO需要的属性（e.g. SalesBillPO中需要单据编号，请加上数据类型，如String id） | 所属的Data类型                |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- | ------------------------ |
| UserPO                                   | 用户的系统信息                                  | String name(用户名)//String id(账户)//String password//Power power(权限)//String job | SystemData.UserData      |
| SalesBillPO                              | 销售类单据，包括销售进货单和销售退货单                      | String commodityName;//商品String customerName;//客户String salesmanName;//销售员String warehouseName;//仓库String modelId;//型号int amount;//数量double unitPrice;//单价 | BillData                 |
| BillPO                                   | 所有单据的父类，用于制定经营情况表和经营历程表的时候返回所有单据         | String billId//单据编号                      | BillData                 |
| LogPO                                    | 系统日志的详细内容                                | int id;//编号String logText;//日志内容         | SystemData.LogData       |
| PromotionPO                              | 促销策略的父类，对应六个子类PO                         | String type;//促销策略类型String time;// 有效时间区间 | SystemData.PromotionData |
|                                          |                                          |                                          |                          |

| IncomeBillPO   | 付款单    | billdataservice      | String id(单据编号)//CustomerPO supplier（供应商）//CustomerPO seller(销售商)//UserPO operator(操作员)//ArrayList<TransferPO> tansferlist(转账列表)//long total(总额汇总) |
| -------------- | ------ | -------------------- | ---------------------------------------- |
|                | 转账信息   | billdataservice      | BankAccountPO bankaccount(银行账户)//long money(转账金额)//String remarks（备注） |
| CustomerPO     | 客户信息   | customerdataservice  | Kind_Of_Costomers kind(客户分类，enum类)//String name(名字)//String phonenumber(联系方式)//int paymoney(应付的钱，之前遗留、赊账)//int incomemoney(应收的钱，之前遗留的)//BankAccountPO bankaccount(银行账号) |
|                | 银行账户信息 | systemdataservice    | String name//String id(银行账号)//long money//UserPO creator(建账人员) |
| PayBIll        | 付款单    | billdataservice      | String  id(单据编号)//UserPO operator(操作员即当前登录用户)//BanAccountPO account(银行账户)//ArrayList<TermsPO> terms(条目清单)//long total(总额) |
|                | 条目清单   | billdataservice      | String cases(条目名)//long money//String remarks |
| FinalAccountPO | 期初建账信息 | systemdataservice    | String name//ArrayList<CommodityPO> commodity(商品信息)//ArrayList<CostomerPO> costomer(客户信息)//BankAccount bankaccount(银行账户信息) |
| CommodityPO    | 商品信息   | commoditydataservice | Kind_Of_Commodity kind(商品类别，enum)//String model(型号)//double averageimportcost(上半年进价)//double averageexportcost(上半年平均售价)//double recentimportcost(最近一次进价)//double recentexportcost(最近一次售价)<br>name(商品名称)<br> type(型号)<br> number(库存数量)<br> importcost(进价)<br> exportcost(售价) |
|                |        |                      |                                          |

| **PO****名称**（请以驼峰命名法书写，e.g. SalesBillPO） | **PO****中存储的内容**（e.g.SalesBillPO中存储的是数据层中的销售单据） | PO需要的属性（e.g. SalesBillPO中需要单据编号，请加上数据类型，如String id） | 所属的Data类型                                |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- | ---------------------------------------- |
| CommodityPO                              | 商品信息                                     | commoditydataservice                     | Kind_Of_Commodity kind(商品类别，enum)//String model(型号)//double averageimportcost(上半年进价)//double averageexportcost(上半年平均售价)//double recentimportcost(最近一次进价)//double recentexportcost(最近一次售价)<br>name(商品名称)<br> type(型号)<br> number(库存数量)<br> importcost(进价)<br> exportcost(售价) |
| ClassificationPO                         | 商品分类信息                                   | commoditydataservice                     | id  string商品分类标号<br> name  string 名称<br> parentClassification  父分类 classification<br> |
| InventoryPO                              | 库存信息                                     | stockdataservice                         | name string商品的名称、type型号，int库存数量，double库存均价，string批次，string批号，出厂日期 |
| StockPO                                  | 出入库信息                                    | stockdatatservice                        | numberOfINOrOut int 出/入库数量 moneyOfINOrOut double /金额，numberOfINOrOut int销售/进货的数量 moneyOfINOrOuts double /金额 |

