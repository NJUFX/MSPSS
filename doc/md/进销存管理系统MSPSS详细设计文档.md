## 更新历史

| 修改人员 | 日期         | 变更原因               | 版本号    |
| ---- | ---------- | ------------------ | ------ |
| FX全组 | 2017-10-28 | 最初草稿               | V1.0   |
| 徐光耀  | 2017-10-30 | 添加逻辑层分解            | v1.1.1 |
| 伏家兴  | 2017-10-30 | 添加stockseller逻辑层分解 | V1.1.2 |
|      |            |                    |        |
|      |            |                    |        |
|      |            |                    |        |
|      |            |                    |        |
|      |            |                    |        |
|      |            |                    |        |

## 1. 引言

### **1.1编制目的**

本报告详细完成对MSPSS进销存管理系统概要设计，达到指导详细设计和开放的目的，同时实现和测试人员及用户的沟通

 

### 1.2词汇表

| 词汇名称  | 词汇含义                              | 备注   |
| ----- | --------------------------------- | ---- |
| MSPSS | Manage System Purchase Stock Sell |      |
| _ui   | 表示某展示层                            |      |
| _bl   | 表示某逻辑层                            |      |
| _data | 表示某数据层                            |      |



### 1.3参考资料

1. IEEE Std 1016-1998 《IEEE Recommended Practice for Software Design Descriptions》

2.FX小组，《进销存管理系统MSPSS需求规格说明书V1.2》

3.丁二玉，刘钦.计算与软件工程（卷二）[M]机械工业出版社，2012：134—182

## 2. 产品概述

参考进销存管理系统MSPSS用例文档和规格需求说明对产品概述的描述

## 3. 体系结构设计概述

参考进销存管理系统MSPSS体系结构设计文档对体系结构的描述

## 4. 结构视角

### 4.1 展示层的分解

#### 4.1.1 stockmanger模块 

#### 4.1.2 stockseller模块

#### 4.1.3 financer模块

#### 4.1.4 chiefmanger模块

### 4.2 业务逻辑层的分解

#### 4.2.1 stockmanger模块

### 4.2.1 stockmangager模块

##### (1)模块描述 

stockmanagerbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求。

stockmanagerbl模块的职责及接口参见软件体系结构设计文档

##### (2) 整体结构

根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，我们会添加接口。比如展示层和业务逻辑层之间我们添加businesslogicservice.stockmanagrerblservice.StockManagerBLService接口。业务逻辑层和数据层之间添加dataservice.StackDataService、dataservice.CommodityDataService、dataservice.BillDataService为了隔离业务逻辑职责和逻辑控制职责，我们增加了StockManagerBLServiceImpl，这样StockManagerBLServiceImpl会将客户管理和制定单据的业务逻辑委托给Stock对象、Bill对象和Commodity对象。ClassificationPO是作为商品分类属性的持久化对象被添加到设计模型中去的。PresentBillPO是作为库存赠送单的持久化对象被添加到设计模型中去的。OverOrLowBillPO是作为库存报损报溢单属性的持久化对象被添加到设计模型中去的。AlertBillPO是作为库存报警单属性的持久化对象被添加到设计模型中去的。StackPO是作为库存报警单属性的持久化对象被添加到设计模型中去的。

CommodityVO、StackVO、SalesBillVO、StackPO是作为值对象被添加到设计模型中去的。



stockmanagerbl模块的设计图

| 模块                        | 职责                               |
| ------------------------- | -------------------------------- |
| StockManagerBLServiceImpl | 负责管理stockmanager各个类的任务负责与bl模块的交互 |
| Commodity                 | 负责对商品信息的增删改查任务                   |
| Classification            | 负责对商品分类信息的增删改查任务                 |

#####（3）模块内部类的接口

StockManagerBLServiceImpl的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| StockManagerBLServiceImpl.SearchCommodity | 语法   | public ArrayList< CommodityVO > searchCommodity(String keytype, String keyword); |
|                                          | 前置条件 | 输入的关键词合法                                 |
|                                          | 后置条件 | 如果系统里有符合条件的商品，返回true，否则返回false           |
| StockManagerBLServiceImpl.getCommodityInfo | 语法   | public CommodityVO getCommodity(String ID); |
|                                          | 前置条件 | 输入的商品编号符合规范                              |
|                                          | 后置条件 | 如果系统中有该商品，返回该客户的属性。否则返回null              |
| StockManagerBLServiceImpl.AddCommodity   | 语法   | public boolean addCommodity(CommodityVO newCommodity); |
|                                          | 前置条件 | 输入的信息符合规范                                |
|                                          | 后置条件 | 系统新建一个商品，并提示新建成功                         |
| StockManagerBLServiceImpl.DelCommodity   | 语法   | public boolean delCommodity(String ID);  |
|                                          | 前置条件 | 需要删除的用户存在于系统中                            |
|                                          | 后置条件 | 删除用户，返回true                              |
| StockManagerBLServiceImpl.ModifyCommodity | 语法   | public boolean ModifyCommodity(CommodityVO modCommodity); |
|                                          | 前置条件 | 输入的信息符合规范                                |
|                                          | 后置条件 | 系统修改该商品的属性，并返回true                       |
| StockManagerBLServiceImpl.CreatePresentBill | 语法   | public boolean createPresentBill(PresentBillVO pre); |
|                                          | 前置条件 | 输入的信息符合规范                                |
|                                          | 后置条件 | 生成库存赠送单，返回true，提示生成成功                    |
| StockManagerBLServiceImpl.CreateOverOrLowBill | 语法   | public boolean createOverOrLow(OverOrLowVO ool); |
|                                          | 前置条件 | 输入的信息符合规范                                |
|                                          | 后置条件 | 生成库存报损报溢单，返回true，提示生成成功                  |
| StockManagerBLServiceImpl.DealAlertReport | 语法   | public boolean dealAlertReport(SalesPO sales); |
|                                          | 前置条件 | 输入的信息符合规范                                |
|                                          | 后置条件 | 处理库存报警单，返回true，提示生成成功                    |
| StockManagerBLServiceImpl.SearchClassification | 语法   | public ArrayList< ClassificationVO > searchClassification(String keytype, String keyword); |
|                                          | 前置条件 | 输入的关键词合法                                 |
|                                          | 后置条件 | 如果系统里有符合条件的商品分类，返回true，否则返回false         |
| StockManagerBLServiceImpl.AddClassification | 语法   | public boolean addClassification(String keytype, String keyword); |
|                                          | 前置条件 | 输入的关键词合法                                 |
|                                          | 后置条件 | 添加分类成功，返回true，否则返回false                  |
| StockManagerBLServiceImpl.deleteClassification | 语法   | public boolean deleteClassification(String keytype, String keyword); |
|                                          | 前置条件 | 输入的关键词合法                                 |
|                                          | 后置条件 | 删除分类成功，返回true，否则返回false                  |
| StockManagerBLServiceImpl.ModifyClassification | 语法   | public boolean ModifyClassification(String keytype, String keyword); |
|                                          | 前置条件 | 输入的关键词合法                                 |
|                                          | 后置条件 | 修改分类成功，返回true，否则返回false                  |





需要的接口（需接口）

| 服务名                                      | 服务        |
| ---------------------------------------- | --------- |
| CommodityDataService.addCommodity        | 增加商品      |
| CommodityDataService.delCommodity        | 删除商品      |
| CommodityDataService.modifyCommodity     | 修改商品属性    |
| CommodityDataService.getCommodityInfo    | 得到商品属性    |
| BillDataService.createPrentationBill     | 创建库存赠送单   |
| BillDataService.createOverOrLowBill      | 创建库存报损报溢单 |
| BillDataService.dealAlertReport          | 处理库存报警单   |
| ClassificationDataService.addClassification | 增加商品分类    |
| ClassificationDataService.delClassification | 删除商品分类    |
| ClassificationDataService.modifyClassification | 修改商品分类    |
| ClassificationDataService.getClassificationInfo | 得到商品分类属性  |

#### 4.2.2 stockseller模块

##### （1）模块概述

stocksellerbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求。

stocksellerbl模块的职责及接口参见软件体系结构设计文档

##### （2）整体结构

根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，我们会添加接口。比如展示层和业务逻辑层之间我们添加businesslogicservice.stocksellerblservice.StockSellerBLService接口。业务逻辑层和数据层之间添加dataservice.CustomerDataService、dataservice.BillDataService、dataservice.CommodityDataService接口。为了隔离业务逻辑职责和逻辑控制职责，我们增加了StockSellerBLServiceImpl，这样StockSellerBLServiceImpl会将客户管理和制定单据的业务逻辑委托给Customer对象和Bill对象。CustomerPO是作为客户属性的持久化对象被添加到设计模型中去的。PurchaseBillPO是作为进货单和进货退货单持久化对象被添加到设计模型中去的。、SalesBillPO是作为销售单和销售退货单的持久化对象被添加到设计模型中去的。、CommodityPO是作为商品属性的持久化对象被添加到设计模型中去的。CustomerVO、PurchaseBillVO、SalesBillVO、CommodityVO是作为值对象被添加到设计模型中去的。

stocksellerbl模块的设计图

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/stocksellerbl%E5%85%B3%E9%94%AE%E7%B1%BB%E5%9B%BE.png)

stocksellerbl模块的各个类职责如表所示

| 模块                       | 职责                                  |
| ------------------------ | ----------------------------------- |
| StockSellerBLServiceImpl | 负责管理stocksellerbl各个类的任务负责与其他bl模块的交互 |
| Customer                 | 负责对客户信息的增删改查任务                      |
| PurchaseBill             | 负责制定进货单和进货退货单的任务                    |
| SalesBill                | 负责制定销售单和销售退货单的任务                    |

##### （3）模块内部类的接口规范

StockSellerBLServiceImpl的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| StockSellerBLServiceImpl.SearchCustomer  | 语法   | public ArrayList< CustomerVO > searchCustomer(String keytype, String keyword); |
|                                          | 前置条件 | 输入的关键词合法                                 |
|                                          | 后置条件 | 如果系统里有符合条件的客户，返回true，否则返回false           |
| StockSellerBLServiceImpl.getCustomerInfo | 语法   | public CustomerVO getCustomer(String ID); |
|                                          | 前置条件 | 输入的客户编号符合规范                              |
|                                          | 后置条件 | 如果系统中有该客户，返回该客户的属性。否则返回null              |
| StockSellerBLServiceImpl.AddCustomer     | 语法   | public boolean addCustomer(CustomerVO newCustomer); |
|                                          | 前置条件 | 输入的信息符合规范                                |
|                                          | 后置条件 | 系统新建一个客户，并提示新建成功                         |
| StockSellerBLServiceImpl.DelCustomer     | 语法   | public boolean delCustomer(String ID);   |
|                                          | 前置条件 | 需要删除的用户存在于系统中                            |
|                                          | 后置条件 | 删除用户，返回true                              |
| StockSellerBLServiceImpl.ModifyCustomer  | 语法   | public boolean ModifyCustomer(CustomerVO modCustomer); |
|                                          | 前置条件 | 输入的信息符合规范                                |
|                                          | 后置条件 | 系统修改该客户的属性，并返回true                       |
| StockSellerBLServiceImpl.CreatePurchaseList | 语法   | public boolean createPurchaseList (PurchaseVO pur); |
|                                          | 前置条件 | 输入的信息符合规范                                |
|                                          | 后置条件 | 生成进货单，返回true，提示生成成功                      |
| StockSellerBLServiceImpl.CreatePurchaseReturnList | 语法   | public boolean createPurchaseReturnList (PurchaseReturnVO puret); |
|                                          | 前置条件 | 输入的信息符合规范                                |
|                                          | 后置条件 | 生成进货退货单，返回true，提示生成成功                    |
| StockSellerBLServiceImpl.CreateSalesList | 语法   | public boolean createSalesList(SalesPO sales); |
|                                          | 前置条件 | 输入的信息符合规范                                |
|                                          | 后置条件 | 生成销售单，返回true，提示生成成功                      |
| StockSellerBLServiceImpl.CreateSalesReturnList | 语法   | public boolean createSalesReturnList (SalesPO saleret); |
|                                          | 前置条件 | 输入的信息符合规范                                |
|                                          | 后置条件 | 生成销售退货单，返回true，提示生成成功                    |

需要的接口（需接口）

| 服务名                                      | 服务      |
| ---------------------------------------- | ------- |
| CustomerDataService.addCustomer          | 增加客户    |
| CustomerDataService.delCustomer          | 删除客户    |
| CustomerDataService.modityCustomer       | 修改客户属性  |
| CustomerDataService.getCustomerInfo      | 得到客户属性  |
| CommodityDataService.getCommodityInfo    | 得到商品属性  |
| BillDataService.createPurchaseList       | 创建进货单   |
| BillDataService.createPurchaseReturnList | 创建进货退货单 |
| BillDataService.createSalesList          | 创建销售单   |
| BillDataService.createSalesReturnList    | 创建销售退货单 |

##### （4）业务逻辑层内部动态模型

图4.2.2.4-1 表现了增加客户的操作中，各个类之间的协作关系

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/StockSeller_AddCus_%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)

图4.2.2.4-1

图4.2.2.4-2 表现了制定进货单的操作中，各个类之间的协作关系



![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/StockSeller_CrePur_%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)

图4.2.2.4-2



#### 4.2.3 financebl模块

##### （1）模块概述

financebl模块承担的需求参见需求规格说明文档功能需求及相关功能功能需求。

financebl模块的职责及接口参见软件系统结构描述文档

#####（2）整体结构

AccountController控制账户管理，他拥有AccountList的所有权，负责调试Account，PayBillController负责管理制定付款单界面，ReceiptBillController负责管理制定收款单界面，BusinessTableController负责控制经营历程表的生产，调用BillData查找数据
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE%E7%89%87%E6%A0%B9%E7%9B%AE%E5%BD%95/FinanceBl%E7%9A%84%E5%85%B3%E9%94%AE%E7%B1%BB%E5%9B%BE.png)


表xx financebl模块各个类的职责

| 模块                       | 职责                                       |
| ------------------------ | ---------------------------------------- |
| AccountController        | 负责实现对应账户管理界面所需要的服务                       |
| PayBillController        | 负责实现对应制定付款单界面所需要的服务                      |
| ReceiptController        | 负责实现对应制定收款单界面所需要的服务                      |
| PayBill                  | 付款单的领域模型对象，拥有一次制定单据所持有的 单据编号（XJFYD-yyyyMMdd-xxxxx）,操作员（当前登录用户），银行账户，条目清单，总额，可以帮助完成制定付款单界面所需要的服务 |
| ReceiptBill              | 收款单的领域模型对象，拥有一次制定付款单所持有的 单据编号（SKD-yyyyMMdd-xxxxx），客户（同时包含供应商和销售商），操作员（当前登录用户），转账列表，总额汇总 |
| BusinessTableController  | 经营历程表的领域模型对象，拥有经营历程表的 时间区间，单据类型，客户，业务员，仓库 |
| Account                  | 账户的领域模型对象，拥有名称和余额                        |
| GeneralAccount           | 期初总账的领域模型对象，拥有期初总帐的 商品信息（商品分类，某一商品的名称，类别，型号，进价/售价(默认为上年平均)，最近进价和最近售价留空），客户信息（客户分类，某一个客户的名称，联系方式等，应收应付(之前遗留)），银行账户信息（名称，余额） |
| GeneralAccountController | 负责实现对应期初建账的界面                            |
| BusinessTableController  | 负责实现对应经营历程表的界面                           |
| SalesListController      | 负责实现对应销售明细表的界面                           |
| ManageListController     | 负责实现对应经营情况表的界面                           |



#####（3）模块内部类的接口规范

AccountController的接口规范

| 提供的服务（供接口）                      |      |                                          |
| ------------------------------- | ---- | ---------------------------------------- |
| AccountController.addAccount    | 语法   | public ResultMessage addAccount（string name,int money) |
|                                 | 前置条件 | name不能与之前的重复                             |
|                                 | 后置条件 | 无                                        |
| AccountController.deleteAccount | 语法   | public ResultMessage deleteAccount（string name) |
|                                 | 前置条件 | name必须已经存在的账户列表中                         |
|                                 | 后置条件 | 无                                        |
| AccountController.modifyAccount | 语法   | public ResultMessage modifyAccount（string oldname,string newname,int money) |
|                                 | 前置条件 | oldname已经存在于账号列表中而newname不存在于账户列表中       |
|                                 | 后置条件 | 无                                        |
| AccountController.get           | 语法   | public Account check(string name)        |
|                                 | 前置条件 | name已经存在于账户列表中                           |
|                                 | 后置条件 | 返回已经写入账户信息（具体参见Account类说明表）的Account      |
|                                 |      |                                          |
|                                 |      |                                          |

| 需要的服务 |      |      |
| ----- | ---- | ---- |
| 无     |      |      |



PayBillController的接口规范

| 提供的服务                    |      |                                          |
| ------------------------ | ---- | ---------------------------------------- |
| PayBillController.create | 语法   | public ResultMessage create(PayBill)     |
|                          | 前置条件 | PayBill被初始化                              |
|                          | 后置条件 | 无                                        |
| PayBillController.check  | 语法   | public ArrayList<PayBill> check(string time1，stringtime2) |
|                          | 前置条件 | time1时间先于time2                           |
|                          | 后置条件 | 无                                        |
|                          |      |                                          |



ReceiptBillController的接口规范

| 提供的服务                        |      |                                          |
| ---------------------------- | ---- | ---------------------------------------- |
| ReceiptBillController.create | 语法   | public ResultMessage create(ReceiptBill bill) |
|                              | 前置条件 | bill被初始化                                 |
|                              | 后置条件 | 无                                        |
| ReceiptController.check      | 语法   | public ArrayList<ReceiptBill> check(string time1，stringtime2) |
|                              | 前置条件 | time1时间先于time2                           |
|                              | 后置条件 | 无                                        |
|                              |      |                                          |

BusinessTableController的接口规范

| 提供的服务                          |      |                                          |
| ------------------------------ | ---- | ---------------------------------------- |
| BusinessTableController.check  | 语法   | public ArrayList<Bill> check(Limit limit) |
|                                | 前置条件 | limit要已经被初始化                             |
|                                | 后置条件 | 调用BillDataService.check(Limit limit)     |
| BusinessTableController.export | 语法   | public ResultMessage export()            |
|                                | 前置条件 | 无                                        |
|                                | 后置条件 | 无                                        |

| 需要的服务                 |                       |
| --------------------- | --------------------- |
| 服务名                   | 服务                    |
| BillDataService.check | 返回符合条件的Bill的ArrayList |

#####（4）业务逻辑层内部动态模型
图4.2.3(4)-1中表现了添加账户的操作中，各个类之间的协作关系
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE%E7%89%87%E6%A0%B9%E7%9B%AE%E5%BD%95/%E6%B7%BB%E5%8A%A0%E8%B4%A6%E6%88%B7%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)


#### 4.2.4 chiefmanger模块

(1)模块概述

chiefmanagerbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求

chiefmanagerbl模块的职责及接口参加软件系统结构描述文档

(2)整体结构

根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，我们会添加接口。比如展示层和业务逻辑层之间我们添加businesslogicservice.chiefmanegerblservice.chiefmanagerBLService接口。业务逻辑层和数据层之间添加dataservice.systemDataService接口和dataservice.billDataservice接口。为了隔离业务逻辑职责和逻辑控制职责，我们增加了List和Promotion对象，这样chiefmanagerblServiceImpl会将查看报表和制定促销策略的业务逻辑分别委托给List对象和Promotion对象。BillPO、ConditionPO、LogPO、SalesBillPO、PromotionPO是作为持久化对象被添加到设计模型中去的。
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/chiefmanagerbl模块各个类的设计.png)

chiefmanagernbl模块的职责如下表所示

| 模块                         | 职责                                       |
| -------------------------- | ---------------------------------------- |
| ChiefManaagerBLServiceImpl | 实现查询日志和审批单据的简单服务，管理查看报表和制定促销策略的服务，负责与其他模块的交互 |
| List                       | 实现处理查看报表的服务                              |
| Promotion                  | 实现制定促销策略的服务                              |

（3）模块内部类的接口规范

ChiefmanagerBLServiceImpl的接口规范

| 提供的服务（供接口）                               |                         |                                          |
| ---------------------------------------- | ----------------------- | ---------------------------------------- |
| ChiefManagerBLServiceImpl.checkLimit     | 语法                      | public boolean checkLimit(int id,String serviceType); |
| 前置条件                                     | 用户已经成功登陆                |                                          |
| 后置条件                                     | 返回一个布尔值表示用户是否有使用申请功能的权限 |                                          |
| ChiefManagerBLServiceImpl.exportList     | 语法                      | public boolean exportList(ListVO listVO); |
| 前置条件                                     | 有符合条件的表单                |                                          |
| 后置条件                                     | 导出excel格式的表单            |                                          |
| ChiefManagerBLServiceImpl.emptyCondition | 语法                      | public  boolean emptyCondition();        |
| 前置条件                                     | 用户有搜索销售明细表的权限           |                                          |
| 后置条件                                     | 清空用户输入的搜索条件             |                                          |
| ChiefManagerBLServiceImpl.exit           | 语法                      | public void exit();                      |
| 前置条件                                     | 用户位于具体功能界面              |                                          |
| 后置条件                                     | 系统返回总经理登陆后的起始界面         |                                          |
| ChiefManagerBLServiceImpl.makeSalesList  | 语法                      | public SalesListVO makeSalesList(String time,String commodityName, String customerName, String salesmanName,String warehouseName ); |
| 前置条件                                     | 用户有查看销售明细表的权限           |                                          |
| 后置条件                                     | 返回用户要求的销售明细表            |                                          |
| ChiefManagerBLServiceImpl.makeManageList | 语法                      | public ManageListVO makeManageList(String time); |
| 前置条件                                     | 用户有查看经营情况表的权限           |                                          |
| 后置条件                                     | 返回用户要求的经营情况表            |                                          |
| ChiefManagerBLServiceImpl.showLogList    | 语法                      | public LogListVO showLogList();          |
| 前置条件                                     | 用户有查询日志的权限              |                                          |
| 后置条件                                     | 返回系统日志列表                |                                          |
| ChiefManagerBLServiceImpl.showLogDetail  | 语法                      | public LogVO showLogDetail(int id);      |
| 前置条件                                     | 用户有查询日志的权限              |                                          |
| 后置条件                                     | 返回该条日志的详细信息             |                                          |
| ChiefManagerBLServiceImpl.showBillList   | 语法                      | public BillListVO showBillList(boolean isExamined)； |
| 前置条件                                     | 用户有审批单据的权限              |                                          |
| 后置条件                                     | 返回待审批单据列表               |                                          |
| ChiefManagerBLServiceImpl.changeBillState | 语法                      | public ArrayList<BillVO> changeBillState(ArrayList<BillVO> billVOArray),boolean pass); |
| 前置条件                                     | 待审批单据列表不为空              |                                          |
| 后置条件                                     | 改变单据的审批状态为批准或不批准        |                                          |
| ChiefManagerBLServiceImpl.updateBillData | 语法                      | public void updateBillData(ArrayList<BillVO billVOArray>); |
| 前置条件                                     | 有单据被审批                  |                                          |
| 后置条件                                     | 将审批后的单据信息更新到数据库中        |                                          |
| ChiefManagerBLServiceImpl.sendMessage    |                         |                                          |
| ChiefManagerBLServiceImpl.showBillDetail | 语法                      | public BillVO showBillDetail(String id); |
| 前置条件                                     | 待审批单据列表不为空              |                                          |
| 后置条件                                     | 返回一张单据的详细内容             |                                          |
| ChiefManagerBLServiceImpl.choosePromotionType | 语法                      | public PromotionVO choosePromotionType(String type); |
| 前置条件                                     | 用户有权限制定促销策略             |                                          |
| 后置条件                                     | 返回类型对应的VO               |                                          |
| ChiefManagerBLServiceImpl.setPromotionTime | 语法                      | public PromotionVO setPromotionTime(PromotionVO promotionVO); |
| 前置条件                                     | 用户有权限制定促销策略             |                                          |
| 后置条件                                     | 返回修改了起始时间的PromotionVo   |                                          |
| ChiefManagerBLServiceImpl.checkPromotionInfo | 语法                      | public boolean checkPromotionInfo(PromotionVO promotionVO) |
| 前置条件                                     | 用户有权限制定促销策略             |                                          |
| 后置条件                                     | 检查用户传入促销策略信息的正确性        |                                          |
| ChiefManagerBLServiceImpl.ShowPromotionList | 语法                      | public PromotionListVO ShowPromotionList(); |
| 前置条件                                     | 用户有权限制定促销策略             |                                          |
| 后置条件                                     | 显示当前存在的促销策略列表           |                                          |
| ChiefManagerBLServiceImpl.updatePromotionInfo | 语法                      | public void updatePromotionInfo(PromotionVO promotionVO); |
| 前置条件                                     | 用户制定促销策略成功              |                                          |
| 后置条件                                     | 更新数据库中的促销策略信息           |                                          |
| 需要的服务（需接口）                               |                         |                                          |
| 服务名                                      | 服务                      |                                          |
| SystemData.userData.findUser             | 根据id查找对应的userPO         |                                          |
| SystemDataService.LogDataService.findLog | 根据ID查找对应的LogPO          |                                          |
| SystemDataService.promotionDataService.find | 查找参数类型对应的所有PromotionPO  |                                          |
| List.makeSalesList                       | 创建一个销售明细表               |                                          |
| List.makeManageList                      | 创建一个经营情况表               |                                          |
| Promotion.choosePromotionType            | 返回选择的促销策略类型             |                                          |
| Promotion.setPromotionTime               | 设置促销类型的时间               |                                          |
| Promotion.checkPromotionInfo             | 检查促销策略信息的合法性            |                                          |
| Promotion.ShowPromotionList              | 显示当前已有的促销策略列表           |                                          |
| Promotion.updatePromotionInfo            | 更新促销策略信息                |                                          |

List的接口规范

| 提供的服务（供接口）                   |                       |                                          |
| ---------------------------- | --------------------- | ---------------------------------------- |
| List.makeSalesList           | 语法                    | public SalesListVO makeSalesList(String time,String commodityName, String customerName, String salesmanName,String warehouseName ); |
| 前置条件                         | 用户有查看销售明细表的权限         |                                          |
| 后置条件                         | 返回用户要求的销售明细表          |                                          |
| List.makeManageList          | 语法                    | public ManageListVO makeManageList(String time); |
| 前置条件                         | 用户有查看经营情况表的权限         |                                          |
| 后置条件                         | 返回用户要求的经营情况表          |                                          |
| 需要的服务（需接口）                   |                       |                                          |
| BillDataService.findSaleBill | 根据搜索条件查找对应的saleBillPP |                                          |
| BillDataService.findBill     | 查找符合条件的所有类型的单据PO      |                                          |
| BillDataService.updateBill   | 改变BillPO中的数据          |                                          |

（4）业务逻辑层内部动态模型
!()[http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/查看经营情况表顺序图.png]
!()[http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/查看销售明细表顺序图.png]
!()[http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/制定促销策略顺序图.png]
