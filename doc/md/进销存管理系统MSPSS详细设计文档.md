
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E6%96%87%E6%A1%A3%E5%B0%81%E9%9D%A2/Y%5DUGHQX%7DPCX0Y%5DPPJMKEJ@6.png)
## 更新历史

| 修改人员 | 日期         | 变更原因               | 版本号    |
| ---- | ---------- | ------------------ | ------ |
| FX全组 | 2017-10-28 | 最初草稿               | V1.0   |
| 徐光耀  | 2017-10-30 | 添加逻辑层分解            | v1.1.1 |
| 伏家兴  | 2017-10-30 | 添加stockseller逻辑层分解 | V1.1.2 |
| 刘雅歆  | 2017-11-02 | 添加总经理模块的逻辑层分解      | v1.1.3 |
| 韩新虎  | 2017-11-02 | 添加库存管理人员的逻辑层分解     | V1.1.4 |
| 伏家兴  | 2017-11-04 | 添加进货销售人员展示层分解      | V1.2.1 |
| 刘雅歆  | 2017-11-05 | 添加总经理展示层分解         | V1.2.2 |
| 徐光耀  | 2017-11-06 | 添加财务人员展示层分解        | v1.2.3 |
| 伏家兴  | 2017-11-08 | 添加admin模块的展示层分解    | V1.2.4 |
| FX全组 | 2017-11-10 | 重构业务逻辑层            | V1.3   |
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
2. FX小组，《进销存管理系统MSPSS需求规格说明书V1.2》
3. 丁二玉，刘钦.计算与软件工程（卷二）[M]机械工业出版社，2012：134—182

## 2. 产品概述

参考进销存管理系统MSPSS用例文档和规格需求说明对产品概述的描述

## 3. 体系结构设计概述

参考进销存管理系统MSPSS体系结构设计文档对体系结构的描述

## 4. 结构视角

### 4.1 展示层的分解

#### 4.1.1 stockmanger模块 

(1)整体结构

展示层的控制器为树状委托结构，StockManagerViewController负责对客户界面的整体跳转，StockManagerNavBarController负责实现导航栏界面，StockManagerCommodityViewController,StockManagerBillViewController,StockManagerStockViewController,StockManagerInventoryController分别实现库存管理人员导航栏的商品管理，制定库存报损报溢单，库存查看，库存盘点界面的跳转

stockmanager界面各个类的职责如下

| 模块                                 | 职责               |
| ---------------------------------- | ---------------- |
| StockManagerViewController         | 负责实现对库存管理人员界面的调整 |
| StockManagerNavBarController       | 负责实现客户导航栏        |
| CommodityInfoViewController        | 负责实现商品信息管理界面     |
| ClassificationInfoViewController   | 负责实现商品分类信息管理界面   |
| CommodityAllListViewController     | 负责实现全部商品列表界面     |
| ClassificationAllViewController    | 负责实现所有商品分类界面     |
| CommodityAddViewController         | 负责添加商品界面         |
| ClassificationAddViewController    | 负责实现添加商品分类界面     |
| CommodityUpdateViewController      | 负责实现更新商品信息界面     |
| ClassificationUpdateViewController | 负责实现更新商品分类信息界面   |
| StockViewController                | 负责实现库存查看界面       |
| InventoryViewController            | 负责实现库存盘点界面       |
| CreateMoreBillController           | 负责实现制定库存报溢单界面    |
| CreateLessBillController           | 负责实现制定库存报损单界面    |
| CreatePrensentationBillController  | 负责实现制定库存赠送单界面    |
| BillViewController                 | 负责实现查看自己制定的单据界面  |
| AlertBillViewController            | 负责查看产生的库存报警单界面   |

（2）模块内部的的接口

表一StockManagerViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   |                                        |
| ---------------------------------------- | ---- | -------------------------------------- |
| StockManagerViewController.showCommodityInfoView | 语法   | public void showCommodityInfoView      |
|                                          | 前置条件 | 点击导航栏 商品信息                             |
|                                          | 后置条件 | 显示商品信息界面                               |
| StockManagerViewController.showClassificationInfoView | 语法   | public void showClassificationInfoView |
|                                          | 前置条件 | 点击导航栏商品分类信息                            |
|                                          | 后置条件 | 显示商品分类信息界面                             |
| StockManagerViewController.showBillList  | 语法   | public void showBillList               |
|                                          | 前置条件 | 点击导航栏 单据列表                             |
|                                          | 后置条件 | 显示单据列表界面                               |
| StockManagerViewController.showAlertBillList | 语法   | public void showAlertBillList          |
|                                          | 前置条件 | 点击查看库存报警单                              |
|                                          | 后置条件 | 显示导航栏库存报警单查看                           |
| StockManagerViewController.showStockView | 语法   | public void showStockView              |
|                                          | 前置条件 | 点击库存查看                                 |
|                                          | 后置条件 | 显示库存查看界面                               |
| StockManagerViewController.showInventoryCheck | 语法   | public void showInventoryCheck         |
|                                          | 前置条件 | 点击库存盘点                                 |
|                                          | 后置条件 | 显示库存盘点界面                               |

需要的服务(需接口)

| 服务名                                      | 服务       |
| ---------------------------------------- | -------- |
| CommodityInfoViewController.showCommodityInfoView | 商品信息管理界面 |
| ClassificationInfoViewController.showClassificationInfoView | 商品分类管理界面 |
| BillViewController.showBillList          | 单据列表     |
| AlertBillViewController.showAlertBillList | 报警单据列表   |
| StockViewController.showStockView        | 库存查看界面   |
| InventoryViewController.showInventoryCheck | 库存盘点界面   |

表二StockManagerNavBarController的接口规范

提供的服务 供接口

| 服务名  | 服务   |      |
| ---- | ---- | ---- |
|      |      |      |

需要的服务  需接口

| 服务名                                      | 服务          |
| ---------------------------------------- | ----------- |
| StockManagerViewController.showCommodityInfoView | 显示商品信息界面    |
| StockManagerViewController.showClassificationInfoView | 显示商品分类界面    |
| StockManagerViewController.showBillList  | 显示单据信息界面    |
| StockManagerViewController.showAlertBillList | 显示查看库存报警单界面 |
| StockManagerViewController.showStockView | 显示库存盘点界面    |
| StockManagerViewController.showInventoryCheck | 显示库存盘点界面    |

表3CommodityInfoViewController的接口规范

| 服务名                                      | 服务   |                                         |
| ---------------------------------------- | ---- | --------------------------------------- |
| CommodityInfoViewController.back         | 语法   | public void back()                      |
|                                          | 前置条件 | 无                                       |
|                                          | 后置条件 | 返回上一界面                                  |
| CommodityInfoViewController.showAllCommodityInfoView | 语法   | public void showAllCommodityInfoView()s |
|                                          | 前置条件 | 无                                       |
|                                          | 后置条件 | 显示所有商品信息界面                              |
| CommodityInfoViewController.showAddCommodityView | 语法   | public void showAddCommodityView()      |
|                                          | 前置条件 | 无                                       |
|                                          | 后置条件 | 跳转到添加商品信息界面                             |
| CommodityInfoViewController.showUpdateCommodityView | 语法   | public void showUpdateCommodityView()   |
|                                          | 前置条件 | 无                                       |
|                                          | 后置条件 | 跳转到更新商品信息界面                             |

需要的服务(需接口)

| 服务名                                      | 服务           |
| ---------------------------------------- | ------------ |
| CommodityAllListViewController.showCommodityListView | 展示商品信息界面     |
| CommodityAddViewController.showAddView   | 展示添加商品信息界面   |
| CommodityUpdateViewController.showUpdateView | 展示添加更新商品信息界面 |

表4 ClassificationInfoViewController的接口规范 

提供的服务 供接口 

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| ClassificationInfoViewController.back    | 语法   | public void back()                       |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回上一界面                                   |
| ClassificationInfoViewController.showAllClassificationInfoView | 语法   | public void showAllClassificationInfoView() |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 显示所有商品信息界面                               |
| ClassificationInfoViewController.showAddClassificationView | 语法   | public void showAddClassificationView()  |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 跳转到添加商品信息界面                              |
| ClassificationInfoViewController.showUpdateClassificationView | 语法   | public void showUpdateClassificationView() |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 跳转到更新商品分类信息界面                            |

需要的服务(需接口)

| 服务名                                      | 服务             |
| ---------------------------------------- | -------------- |
| ClassificationAllListViewController.showCommodityListView | 展示商品分类信息界面     |
| ClassificationAddViewController.showAddView | 展示添加商品分类信息界面   |
| ClassificationUpdateViewController.showUpdateView | 展示添加更新商品分类信息界面 |

表5 CommodityAllListViewController的接口规范

提供的服务 供接口 

| 服务名                                 | 服务   |                                    |
| ----------------------------------- | ---- | ---------------------------------- |
| CommodityAllListViewController.back | 语法   | public void back()                 |
|                                     | 前置条件 | 无                                  |
|                                     | 后置条件 | 返回上一界面                             |
| CommodityAllListViewController      | 语法   | public void showAllCommodityView() |
|                                     | 前置条件 | 无                                  |
|                                     | 后置条件 | 显示所有商品信息                           |

需要的服务(需接口)

| 服务名                                | 服务   |
| ---------------------------------- | ---- |
| CommodityBLService.searchCommodity | 得到商品 |
|                                    |      |
|                                    |      |

表6 ClassificationAllViewController  的接口规范

提供的服务 供接口 

| 服务名                                      | 服务   |                                         |
| ---------------------------------------- | ---- | --------------------------------------- |
| ClassificationAllListViewController.back | 语法   | public void back()                      |
|                                          | 前置条件 | 无                                       |
|                                          | 后置条件 | 返回上一界面                                  |
| ClassificationAllListViewController      | 语法   | public void showAllClassificationView() |
|                                          | 前置条件 | 无                                       |
|                                          | 后置条件 | 显示所有商品信息                                |

需要的服务(需接口)

| 服务名                                     | 服务         |
| --------------------------------------- | ---------- |
| CommodityBLService.getAllClassification | 得到所有商品分类信息 |
| CommodityBLService.searchClassification | 搜索商品分类信息   |
|                                         |            |

表7 CommodityAddViewController 的接口规范 



提供的服务 供接口 

| 服务名                                    | 服务   |                           |
| -------------------------------------- | ---- | ------------------------- |
| CommodityAddViewController.back        | 语法   | public void back()        |
|                                        | 前置条件 | 无                         |
|                                        | 后置条件 | 返回上一界面                    |
| CommodityAddViewController.showAddView | 语法   | public void showAddView() |
|                                        | 前置条件 | 无                         |
|                                        | 后置条件 | 显示更新界面                    |
|                                        |      |                           |

需要的服务(需接口)

| 服务名                             | 服务   |
| ------------------------------- | ---- |
| CommodityBLService.addCommodity | 更新商品 |
|                                 |      |

表8 ClassificationAddViewController 的接口规范 

提供的服务 供接口 

| 服务名                                      | 服务   |                              |
| ---------------------------------------- | ---- | ---------------------------- |
| ClassificationAddViewController.back     | 语法   | public void back()           |
|                                          | 前置条件 | 无                            |
|                                          | 后置条件 | 返回上一界面                       |
| ClassificationAddViewController.showAddView | 语法   | public void showUpdateView() |
|                                          | 前置条件 | 无                            |
|                                          | 后置条件 | 显示更新界面                       |
|                                          |      |                              |

需要的服务(需接口)

| 服务名                                | 服务   |
| ---------------------------------- | ---- |
| CommodityBLService.updateCommodity | 更新商品 |
|                                    |      |

表9  CommodityUpdateViewController  的接口规范

提供的服务 供接口 

| 服务名                                      | 服务   |                              |
| ---------------------------------------- | ---- | ---------------------------- |
| CommodityUpdateViewController.back       | 语法   | public void back()           |
|                                          | 前置条件 | 无                            |
|                                          | 后置条件 | 返回上一界面                       |
| CommodityUpdateViewController.showUpdateView | 语法   | public void showUpdateView() |
|                                          | 前置条件 | 无                            |
|                                          | 后置条件 | 显示更新界面                       |
|                                          |      |                              |

需要的服务(需接口)

| 服务名                                | 服务   |
| ---------------------------------- | ---- |
| CommodityBLService.updateCommodity | 更新商品 |
|                                    |      |

表10  ClassificationUpdateViewController的接口规范

提供的服务 供接口 

| 服务名                                      | 服务   |                              |
| ---------------------------------------- | ---- | ---------------------------- |
| ClassificationUpdateViewController.back  | 语法   | public void back()           |
|                                          | 前置条件 | 无                            |
|                                          | 后置条件 | 返回上一界面                       |
| ClassificationUpdateViewController.showUpdateView | 语法   | public void showUpdateView() |
|                                          | 前置条件 | 无                            |
|                                          | 后置条件 | 显示更新界面                       |
|                                          |      |                              |

需要的服务(需接口)

| 服务名                                     | 服务     |
| --------------------------------------- | ------ |
| CommodityBLService.updateClassification | 更新商品分类 |
|                                         |        |

表11  StockViewController的接口规范

提供的服务 供接口 

| 服务名                               | 服务   |                           |
| --------------------------------- | ---- | ------------------------- |
| StockViewController.back          | 语法   | public void back()        |
|                                   | 前置条件 | 无                         |
|                                   | 后置条件 | 返回上一界面                    |
| StockViewController.showInitView  | 语法   | public void showInitView  |
|                                   | 前置条件 | 无                         |
|                                   | 后置条件 | 显示库存查看的初始界面               |
| StockViewController.showStockView | 语法   | public void showStockView |
|                                   | 前置条件 | 无                         |
|                                   | 后置条件 | 显示库存查看的具体界面               |

需要的服务(需接口)

| 服务名                      | 服务   |
| ------------------------ | ---- |
| StockBLService.viewStock | 库存查看 |
|                          |      |
|                          |      |

表12  InventoryViewController  的接口规范

提供的服务 供接口 

| 服务名                                   | 服务   |                             |
| ------------------------------------- | ---- | --------------------------- |
| InventoryViewController.back          | 语法   | public void back()          |
|                                       | 前置条件 | 无                           |
|                                       | 后置条件 | 返回上一界面                      |
| InventoryViewController.showInventory | 语法   | public void showInventory() |
|                                       | 前置条件 | 无                           |
|                                       | 后置条件 | 展示库存盘点界面                    |
|                                       |      |                             |
|                                       |      |                             |
|                                       |      |                             |

需要的服务(需接口)

| 服务名                             | 服务     |
| ------------------------------- | ------ |
| StockBillService.checkInventory | 库存盘点界面 |
|                                 |        |
|                                 |        |

表13  CreateMoreBillController  的接口规范

提供的服务 供接口 

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CreateMoreBillController.back            | 语法   | public void back()                       |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回上一界面                                   |
| CreateMoreBillController.showCreateBillView | 语法   | CreateMoreBillController. showCreateBillView |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 展示制定库存报损单的界面                             |

需要的服务(需接口)

| 服务名                          | 服务      |
| ---------------------------- | ------- |
| BillBLService.CreateMoreBill | 制定库存报溢单 |
|                              |         |

表14  CreateLessBillController 的接口规范

提供的服务 供接口 

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CreateLessBillController.back            | 语法   | public void back()                       |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回上一界面                                   |
| CreateLessBillController.showCreateBillView | 语法   | CreateLessBillController. showCreateBillView |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 展示制定库存报损单的界面                             |

需要的服务(需接口)

| 服务名                          | 服务      |
| ---------------------------- | ------- |
| BillBLService.CreateLessBill | 制定库存报损单 |
|                              |         |

表15  CreatePrensentationBillController 的接口规范

提供的服务 供接口 

| 服务名                                      | 服务   |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CreatePrensentationBillController.back   | 语法   | public void back()                       |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回上一界面                                   |
| CreatePrensentationBillController.showCreateBillView | 语法   | CreatePrensentationBillController. showCreateBillView |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 展示制定库存赠送单的界面                             |

需要的服务(需接口)

| 服务名                                   | 服务      |
| ------------------------------------- | ------- |
| BillBLService.CreatePrensentationBill | 制定库存赠送单 |
|                                       |         |

表16  BillViewController的接口规范

提供的服务 供接口 

| 服务名                               | 服务   |                            |
| --------------------------------- | ---- | -------------------------- |
| BillViewController.back           | 语法   | public void back()         |
|                                   | 前置条件 | 无                          |
|                                   | 后置条件 | 返回上一界面                     |
| BillViewController.showBillList   | 语法   | public void showBillList   |
|                                   | 前置条件 | 无                          |
|                                   | 后置条件 | 展示所有的单据信息                  |
| BillViewController.showBillDetail | 语法   | public void showBillDetail |
|                                   | 前置条件 | 无                          |
|                                   | 后置条件 | 展示单据的具体信息                  |

需要的服务(需接口)

| 服务名                      | 服务        |
| ------------------------ | --------- |
| BillBLService.searchBill | 搜索订单      |
| BillBLService.getBill    | 得到订单的具体信息 |
|                          |           |
|                          |           |

表17  AlertBillViewController  的接口规范

提供的服务 供接口 



| 服务名                                   | 服务   |                             |
| ------------------------------------- | ---- | --------------------------- |
| AlertBillViewController.back          | 语法   | public void back()          |
|                                       | 前置条件 | 无                           |
|                                       | 后置条件 | 返回上一界面                      |
| AlertBillViewController.showAlertBill | 语法   | public void showAlertBill() |
|                                       | 前置条件 | 无                           |
|                                       | 后置条件 | 显示库存报警单                     |



需要的服务(需接口)

| 服务名                           | 服务      |
| ----------------------------- | ------- |
| BillBLService.searchAlertBill | 得到库存报警单 |
|                               |         |
|                               |         |
|                               |         |



#### 4.1.2 stockseller模块

##### （1）整体结构

展示层的控制器为树状委托式结构，StockSellerViewController负责对进货销售人员界面的整体跳转，StockSellerNavBarController负责实现导航栏界面，CustomerManagerViewController、BillCreateViewController分别实现进货销售人员导航栏的客户管理和制定单据的跳转

StockSeller界面各类的职责如表4.1.2(1)-1所示

表4.1.2(1)-1 StockSeller界面各类的职责

| 模块                              | 职责                 |
| ------------------------------- | ------------------ |
| StockSellerViewController       | 负责实现对进货销售人员界面的整体跳转 |
| StockSellerNavBarController     | 负责实现进货销售人员导航栏      |
| CustomerManageViewController    | 负责进货销售人员客户管理界面     |
| BillCreateViewController        | 负责进货销售人员制定单据理界面    |
| CustomerAddViewController       | 负责进货销售人员增加客户界面     |
| CustomerDelViewController       | 负责进货销售人员删除客户界面     |
| CustomerModifyViewController    | 负责进货销售人员修改客户属性界面   |
| CustomerSearchViewController    | 负责进货销售人员查找客户界面     |
| CustomerShowViewController      | 负责进货销售人员展示客户属性界面   |
| PurchaseCreateViewController    | 负责进货销售人员制定进货单界面    |
| SalesCreateViewController       | 负责进货销售人员制定进货退货单界面  |
| PurchaseRetCreateViewController | 负责进货销售人员制定销售单界面    |
| SalesRetCreateViewController    | 负责进货销售人员制定销售退货单界面  |

##### （2）模块内部类的接口规范

表4.1.2(2)-1 StockSellerViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                   |
| ---------------------------------------- | ---- | ------------------------------------ |
| StockSellerViewController.showCustomerManage | 语法   | public boolean showCustomerManage(); |
|                                          | 前置条件 | 点击导航栏客户管理                            |
|                                          | 后置条件 | 显示客户管理界面                             |
| StockSellerViewController.showBillCreate | 语法   | public boolean showBillCreate();     |
|                                          | 前置条件 | 点击导航栏制定单据                            |
|                                          | 后置条件 | 显示制定单据界面                             |
|                                          |      |                                      |

需要的服务（需接口）

| 服务名                               | 服务       |
| --------------------------------- | -------- |
| CustomerManageViewController.show | 显示客户管理界面 |
| BillCreateViewController.show     | 显示制定单据界面 |
|                                   |          |

表4.1.2(2)-2 StockSellerNavBarController的接口规范

提供的服务（供接口）

无

需要的服务（需接口）

| 服务名                               | 服务       |
| --------------------------------- | -------- |
| CustomerManageViewController.show | 显示客户管理界面 |
| BillCreateViewController.show     | 显示制定单据界面 |
|                                   |          |

表4.1.2(2)-3 CustomerManageViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                  |
| ---------------------------------------- | ---- | ----------------------------------- |
| CustomerManageViewController.showAddCustomer | 语法   | public boolean showAddCustomer()    |
|                                          | 前置条件 | 点击增加客户按钮                            |
|                                          | 后置条件 | 显示增加客户界面                            |
| CustomerManageViewController.showDelCustomer | 语法   | public boolean showDelCustomer()    |
|                                          | 前置条件 | 点击删除客户按钮                            |
|                                          | 后置条件 | 显示删除客户界面                            |
| CustomerManageViewController.showModityCustomer | 语法   | public boolean showModifyCustomer() |
|                                          | 前置条件 | 点击修改客户属性按钮                          |
|                                          | 后置条件 | 显示修改客户属性界面                          |
| CustomerManageViewController.showSearchCustomer | 语法   | public boolean showSearchCustomer() |
|                                          | 前置条件 | 点击查找客户按钮                            |
|                                          | 后置条件 | 显示查找客户界面                            |
| CustomerManageViewController.show        | 语法   | public boolean show()               |
|                                          | 前置条件 | 无                                   |
|                                          | 后置条件 | 显示客户管理界面                            |

需要的服务（需接口）

| 服务名                               | 服务         |
| --------------------------------- | ---------- |
| CustomerAddViewController.show    | 显示增加客户界面   |
| CustomerDelViewController.show    | 显示删除客户界面   |
| CustomerModifyViewController.show | 显示修改客户属性界面 |
| CustomerSearchViewController.show | 显示查找客户界面   |
|                                   |            |

表4.1.2(2)-4 BillCreateViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                     |
| ---------------------------------------- | ---- | -------------------------------------- |
| BillCreateViewController.showSalseCreate | 语法   | public boolean showSalseCreate()       |
|                                          | 前置条件 | 点击制定销售单按钮                              |
|                                          | 后置条件 | 显示制定销售单界面                              |
| BillCreateViewController.showSalesRetCreate | 语法   | public boolean showSalseRetCreate()    |
|                                          | 前置条件 | 点击制定销售退货单按钮                            |
|                                          | 后置条件 | 显示制定销售退货单界面                            |
| BillCreateViewController.showPurchaseCreate | 语法   | public boolean showPurchaseCreate()    |
|                                          | 前置条件 | 点击制定进货单按钮                              |
|                                          | 后置条件 | 显示制定进货单界面                              |
| BillCreateViewController.showPurchaseRetCreate | 语法   | public boolean showPurchaseRetCreate() |
|                                          | 前置条件 | 点击制定进货退货单按钮                            |
|                                          | 后置条件 | 显示制定进货退货单界面                            |
| BillCreateViewController.show            | 语法   | public boolean show()                  |
|                                          | 前置条件 | 无                                      |
|                                          | 后置条件 | 显示制定的单据界面                              |

需要的服务（需接口）

| 服务名                                  | 服务          |
| ------------------------------------ | ----------- |
| PurchaseCreateViewController.show    | 显示制定进货单界面   |
| PurchaseRetCreateViewController.show | 显示制定进货退货单界面 |
| SalesCreateViewController.show       | 显示制定销售单界面   |
| SalesRetCreateViewController.show    | 显示制定销售退货单界面 |

表4.1.2(2)-5 CustomerAddViewController的接口规范

提供的服务（供接口）

| 服务名                                   | 服务   | 服务                                       |
| ------------------------------------- | ---- | ---------------------------------------- |
| CustomerAddViewController.back        | 语法   | public boolean back()                    |
|                                       | 前置条件 | 点击返回按钮                                   |
|                                       | 后置条件 | 返回上一界面                                   |
| CustomerAddViewController.addCustomer | 语法   | public boolean addCustomer(CustomerVO customer) |
|                                       | 前置条件 | 点击确定按钮                                   |
|                                       | 后置条件 | 系统更新数据                                   |
| CustomerAddViewController.show        | 语法   | public boolean show()                    |
|                                       | 前置条件 | 无                                        |
|                                       | 后置条件 | 显示增加客户界面                                 |

需要的服务（需接口）

| 服务名                               | 服务       |
| --------------------------------- | -------- |
| CustomerManageViewController.show | 显示客户管理界面 |
| StockSellerBLService.addCustomer  | 增加客户     |

表4.1.2(2)-6 CustomerDelViewController的接口规范

提供的服务（供接口）

| 服务名                                   | 服务   | 服务                                    |
| ------------------------------------- | ---- | ------------------------------------- |
| CustomerDelViewController.back        | 语法   | public boolean back()                 |
|                                       | 前置条件 | 点击返回按钮                                |
|                                       | 后置条件 | 返回上一界面                                |
| CustomerDelViewController.delCustomer | 语法   | public boolean delCustomer(String ID) |
|                                       | 前置条件 | 点击确定按钮                                |
|                                       | 后置条件 | 系统更新数据                                |
| CustomerDelViewController.show        | 语法   | public boolean show()                 |
|                                       | 前置条件 | 无                                     |
|                                       | 后置条件 | 显示删除客户界面                              |

需要的服务（需接口）

| 服务名                               | 服务       |
| --------------------------------- | -------- |
| CustomerManageViewController.show | 显示客户管理界面 |
| StockSellerBLService.delCustomer  | 删除客户     |

表4.1.2(2)-7 CustomerModifyViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CustomerModifyViewController.back        | 语法   | public boolean back()                    |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回上一界面                                   |
| CustomerModifyViewController.modifyCustomer | 语法   | public boolean modifyCustomer(CustomerVO customer) |
|                                          | 前置条件 | 点击确定按钮                                   |
|                                          | 后置条件 | 系统更新数据                                   |
| CustomerModifyViewController.show        | 语法   | public boolean show()                    |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 显示修改客户属性界面                               |

需要的服务（需接口）

| 服务名                                 | 服务       |
| ----------------------------------- | -------- |
| CustomerManageViewController.show   | 显示客户管理界面 |
| StockSellerBLService.modifyCustomer | 修改客户属性   |

表4.1.2(2)-8 CustomerSearchViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CustomerSearchViewController.back        | 语法   | public boolean back()                    |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回上一界面                                   |
| CustomerSearchViewController.searchCustomer | 语法   | public ArrayList< CustomerVO > searchCustomer(String keyType, String keyword) |
|                                          | 前置条件 | 点击确定按钮                                   |
|                                          | 后置条件 | 返回符合关键词的客户属性列表                           |
| CustomerSearchViewController.show        | 语法   | public boolean show()                    |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 显示查找客户属性界面                               |
| CustomerSearchViewController.showCustomer | 语法   | public boolean showCustomer(String ID)   |
|                                          | 前置条件 | 点击查看客户属性按钮                               |
|                                          | 后置条件 | 显示显示客户属性界面                               |

需要的服务（需接口）

| 服务名                                 | 服务       |
| ----------------------------------- | -------- |
| CustomerManageViewController.show   | 显示客户管理界面 |
| CustomerShowViewController.show     | 显示客户属性   |
| StockSellerBLService.searchCustomer | 查找客户     |
|                                     |          |

表4.1.2(2)-9 CustomerShowViewController的接口规范

提供的服务（供接口）

| 服务名                             | 服务   | 服务                             |
| ------------------------------- | ---- | ------------------------------ |
| CustomerShowViewController.back | 语法   | public boolean back()          |
|                                 | 前置条件 | 点击返回按钮                         |
|                                 | 后置条件 | 返回上一界面                         |
| CustomerShowViewController.show | 语法   | public boolean show(String ID) |
|                                 | 前置条件 | 无                              |
|                                 | 后置条件 | 显示客户属性                         |

需要的服务（需接口）

| 服务名                                  | 服务       |
| ------------------------------------ | -------- |
| CustomerManageViewController.show    | 显示客户管理界面 |
| StockSellerBLService.getCustomerInfo | 查找客户     |
|                                      |          |

表4.1.2(2)-10 PurchaseCreateViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| PurchaseCreateViewController.show        | 语法   | public boolean show()                    |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 显示制定进货单界面                                |
| PurchaseCreateViewController.back        | 语法   | public boolean back()                    |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回上一界面                                   |
| PurchaseCreateViewController.createPurchase | 语法   | public boolean createPurchase(PurchaseVO purchase) |
|                                          | 前置条件 | 点击确认按钮                                   |
|                                          | 后置条件 | 创建进货单                                    |

需要的服务（需接口）

| 服务名                                 | 服务       |
| ----------------------------------- | -------- |
| BillCreateViewController.show       | 显示制定单据界面 |
| StockSellerBLService.createPurchase | 创建进货单    |

表4.1.2(2)-11 PurchaseRetCreateViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| PurchaseRetCreateViewController.show     | 语法   | public boolean show()                    |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 显示制定进货退货单界面                              |
| PurchaseRetCreateViewController.back     | 语法   | public boolean back()                    |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回上一界面                                   |
| PurchaseRetCreateViewController.createPurchaseRet | 语法   | public boolean createPurchaseRet(PurchaseVO puret) |
|                                          | 前置条件 | 点击确认按钮                                   |
|                                          | 后置条件 | 创建进货退货单                                  |

需要的服务（需接口）

| 服务名                                    | 服务       |
| -------------------------------------- | -------- |
| BillCreateViewController.show          | 显示制定单据界面 |
| StockSellerBLService.createPurchaseRet | 创建进货退货单  |

表4.1.2(2)-12 SalesCreateViewController的接口规范

提供的服务（供接口）

| 服务名                                   | 服务   | 服务                                       |
| ------------------------------------- | ---- | ---------------------------------------- |
| SalesCreateViewController.show        | 语法   | public boolean show()                    |
|                                       | 前置条件 | 无                                        |
|                                       | 后置条件 | 显示制定销售单界面                                |
| SalesCreateViewController.back        | 语法   | public boolean back()                    |
|                                       | 前置条件 | 点击返回按钮                                   |
|                                       | 后置条件 | 返回上一界面                                   |
| SalesCreateViewController.createSales | 语法   | public boolean createSales(SalesVO sales) |
|                                       | 前置条件 | 点击确认按钮                                   |
|                                       | 后置条件 | 创建销售单                                    |

需要的服务（需接口）

| 服务名                              | 服务       |
| -------------------------------- | -------- |
| BillCreateViewController.show    | 显示制定单据界面 |
| StockSellerBLService.createSales | 创建销售单    |

表4.1.2(2)-13 SalesRetCreateViewController的接口规范

提供的服务（供接口）

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| SalesRetCreateViewController.show        | 语法   | public boolean show()                    |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 显示制定销售退货单界面                              |
| SalesRetCreateViewController.back        | 语法   | public boolean back()                    |
|                                          | 前置条件 | 点击返回按钮                                   |
|                                          | 后置条件 | 返回上一界面                                   |
| SalesRetCreateViewController.createSalesRet | 语法   | public boolean createSalesRet(SalesVO saleret) |
|                                          | 前置条件 | 点击确认按钮                                   |
|                                          | 后置条件 | 创建销售退货单                                  |

需要的服务（需接口）

| 服务名                                 | 服务       |
| ----------------------------------- | -------- |
| BillCreateViewController.show       | 显示制定单据界面 |
| StockSellerBLService.createSalesRet | 创建销售退货单  |



#### 4.1.3 financer模块

##### （1）整体结构

展示层的控制器为树状委托式结构，

financebl模块FinanceViewController负责对财务人员功能界面的整体跳转，FinanceNaveBarController负责实现导航栏部分，AccountViewController,BillKindViewController,TableViewController,GeneralAccountController，分别是实现 导航栏的账户管理、单据类型、查看报表、期初建账的界面的跳转。<br>

finance各个类的职责如表4.1.3(1)-1所示<br>

表4.1.1.3(1)-1各个类的职责

| 模块                             | 职责                    |
| ------------------------------ | --------------------- |
| FinanceViewController          | 负责实现对财务人员界面的整体跳转      |
| FinanceNaveBarController       | 负责实现导航栏               |
| AccountViewController          | 负责实现账户搜索及显示账户列表的账户主界面 |
| AddAccoutViewController        | 负责实现增加账户界面            |
| ModifyAccoutViewController     | 负责实现修改账户界面            |
| BillKindViewController         | 负责实现单据类型选择界面          |
| CashBillViewController         | 负责实现制定现金费用单界面         |
| PayBillViewController          | 负责实现制定付款界面            |
| ReceiptBillViewController      | 负责实现制度收款单界面           |
| TableViewController            | 负责实现查看报表界面            |
| CheckGeneralAccountController  | 负责实现查找总账户界面           |
| CreateGeneralAccountController | 负责实现期初建账界面            |
| FinanceInfoController          | 负责实现信息的传递             |

##### （2）模块内部类的接口规范

表4.1.3(2)-1 FinanceViewController的接口规范

| 提供的服务(供接口)                         |      |                                   |
| ---------------------------------- | ---- | --------------------------------- |
| 服务名                                |      | 服务                                |
| FinanceViewController.ShowUserInfo | 语法   | public void ShowUserInfo()        |
|                                    | 前置条件 | 启动财务人员界面                          |
|                                    | 后置条件 | 显示用户信息                            |
| FinanceViewController.ModifyInfo   | 语法   | public ResultMessage ModifyInfo() |
|                                    | 前置条件 | 点击修改用户信息                          |
|                                    | 后置条件 | 返回修改信息状态                          |

| 需要的服务(需接口)                           |                                          |
| ------------------------------------ | ---------------------------------------- |
| 模块                                   | 服务                                       |
| FinanceInfoController.modifyUserInfo | public ResultMessage modifyUserInfo(UserVO user) |
| FinanceInfoController.getUserInfo    | public void getUserInfo(String id)       |

表4.1.3(2)-2 FinanceNaveBarController的接口规范

| 提供的服务(供接口)                               |      |                                      |
| ---------------------------------------- | ---- | ------------------------------------ |
| 服务名                                      |      | 服务                                   |
| FinanceNaveBarController.showAccoutManageView | 语法   | public void showAccoutManageView()   |
|                                          | 前置条件 | 点击账户管理button                         |
|                                          | 后置条件 | 跳转到账户管理界面，并且对应button颜色加深             |
| FinanceNaveBarController.showBillView    | 语法   | public void showBillView()           |
|                                          | 前置条件 | 点击制定单据button                         |
|                                          | 后置条件 | 跳转到制定单据界面，并且对应button颜色加深             |
| FinanceNaveBarController.showTableView   | 语法   | public void showTableView()          |
|                                          | 前置条件 | 点击查看报表button                         |
|                                          | 后置条件 | 跳转到查看报表界面，并且对应button颜色加深             |
| FinanceNaveBarController.showGeneralAccoutView | 语法   | public void showGeneralAccountView() |
|                                          | 前置条件 | 点击期初建账button                         |
|                                          | 后置条件 | 跳转到期初建账界面，并且对应button颜色加深             |

| 需要的服务(需接口)                               |            |
| ---------------------------------------- | ---------- |
| 服务名                                      | 服务         |
| AccountViewController.showSearchView()   | 展示搜索账户界面   |
| BillKindViewController.show()            | 展示单据类型界面   |
| TableViewController.showSearchView()     | 展示搜索报表界面   |
| CheckGeneralAccountController.showSearchView() | 展示搜索期初账户界面 |

表4.1.3(2)-3 AccountViewController的接口规范

| 提供的服务(供接口)                               |      |                                        |
| ---------------------------------------- | ---- | -------------------------------------- |
| 服务名                                      |      | 服务                                     |
| AccountViewController.showSearchView     | 语法   | public void showSearchView()           |
|                                          | 前置条件 | 用户进入账户管理界面                             |
|                                          | 后置条件 | 显示搜索账户界面                               |
| AccountViewController.showDeleteAccoutView | 语法   | public void showDeleteAccoutView()     |
|                                          | 前置条件 | 用户已经填入搜索信息，并且显示出符合条件的账户，用户点击删除账户button |
|                                          | 后置条件 | 询问是否删除，若是，则显示更新过的账户列表                  |
| AccountViewController.showModifyAccoutView | 语法   | public void showModifyAccountView()    |
|                                          | 前置条件 | 用户已经填入搜索信息，并且显示出符合条件的账户，用户点击修改账户button |
|                                          | 后置条件 | 进入修改账户界面                               |
| AccountViewController.showAddAccountView | 语法   | public void showAddAccountView()       |
|                                          | 前置条件 | 用户点击增加账户button                         |
|                                          | 后置条件 | 进入增加账户界面                               |

| 需要的服务(需接口)                          |             |
| ----------------------------------- | ----------- |
| 服务名                                 | 服务          |
| AddAccoutViewController.show        | 显示增加账户界面    |
| ModifyAccoutViewController.show     | 显示修改账户界面    |
| FinanceInfoController.deleteAccount | 删除账户        |
| FinanceInfoController.getAccount    | 获得符合搜索条件的账户 |

表4.1.3(2)-4 AddAccoutViewController的接口规范

| 提供的服务(供接口)                        |      |                                          |
| --------------------------------- | ---- | ---------------------------------------- |
| 服务名                               |      | 服务                                       |
| AddAccoutViewController.show      | 语法   | public void show()                       |
|                                   | 前置条件 | 无                                        |
|                                   | 后置条件 | 显示增加账户界面                                 |
| AddAccoutViewController.updateAdd | 语法   | public ResultMessage updateAdd(Account account) |
|                                   | 前置条件 | 点击提交按钮                                   |
|                                   | 后置条件 | 返回修改状态                                   |

| 需要的服务(需接口)                       |      |
| -------------------------------- | ---- |
| 服务名                              | 服务   |
| FinanceInfoController.addAccount | 增加账户 |

表4.1.3(2)-5 ModifyAccoutViewController的接口规范

| 提供的服务(供接口)                              |      |                                          |
| --------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                     |      | 服务                                       |
| ModifyAccoutViewController.show         | 语法   | public void show()                       |
|                                         | 前置条件 | 无                                        |
|                                         | 后置条件 | 显示修改账户界面                                 |
| ModifyAccoutViewController.updateModify | 语法   | public ResultMessage updateModify(Account account) |
|                                         | 前置条件 | 点击提交按钮                                   |
|                                         | 后置条件 | 返回修改状态                                   |

| 需要的服务(需接口)                          |      |
| ----------------------------------- | ---- |
| 服务名                                 | 服务   |
| FinanceInfoController.modifyAccount | 修改账户 |

表4.1.3(2)-6 BillKindViewController的接口规范

| 提供的服务(供接口)                               |      |                                 |
| ---------------------------------------- | ---- | ------------------------------- |
| 服务名                                      |      | 服务                              |
| BillKindViewController.show()            | 语法   | public void show()              |
|                                          | 前置条件 | 无                               |
|                                          | 后置条件 | 显示账户类型界面                        |
| BillKindViewController.createPayBill()   | 语法   | public void createPayBill()     |
|                                          | 前置条件 | 点击付款单button                     |
|                                          | 后置条件 | 显示制定付款单界面                       |
| BillKindViewController.createCashBill    | 语法   | public void createCashBill()    |
|                                          | 前置条件 | 点击制定现金费用单button                 |
|                                          | 后置条件 | 显示制定现金费用单界面                     |
| BillKindViewController.createReceiptBill | 语法   | public void createReceiptBill() |
|                                          | 前置条件 | 点击制定收款单界面                       |
|                                          | 后置条件 | 显示制定收款                          |

| 需要的服务(需接口)                       |               |
| -------------------------------- | ------------- |
| 服务名                              | 服务            |
| CashBillViewController.show()    | 负责实现制定现金费用单界面 |
| PayBillViewController.show()     | 负责实现制定付款界面    |
| ReceiptBillViewController.show() | 负责实现制度收款单界面   |

表4.1.3(2)-7 CashBillViewController的接口规范

| 提供的服务(供接口)                    |      |                                       |
| ----------------------------- | ---- | ------------------------------------- |
| 服务名                           |      | 服务                                    |
| CashBillViewController.show   | 语法   | public void show()                    |
|                               | 前置条件 | 无                                     |
|                               | 后置条件 | 显示制定现金费用单界面                           |
| CashBillViewController.commit | 语法   | public void commit(CashBill cashbill) |
|                               | 前置条件 | 点击提交按钮                                |
|                               | 后置条件 | 无                                     |

| 需要的服务(需接口)                           |         |
| ------------------------------------ | ------- |
| 服务名                                  | 服务      |
| FinanceInfoController.commitCashBill | 提交现金费用单 |

表4.1.3(2)-8 PayBillViewController的接口规范

| 提供的服务(供接口)                   |      |                                     |
| ---------------------------- | ---- | ----------------------------------- |
| 服务名                          |      | 服务                                  |
| PayBillViewController.show   | 语法   | public void show()                  |
|                              | 前置条件 | 无                                   |
|                              | 后置条件 | 显示制定付款单                             |
| PayBillViewController.commit | 语法   | public void commit(PayBill paybill) |
|                              | 前置条件 | 点击提交按钮                              |
|                              | 后置条件 | 返回提交状态                              |

| 需要的服务(需接口)                          |       |
| ----------------------------------- | ----- |
| 服务名                                 | 服务    |
| FinanceInfoController.commitPayBill | 提交付款单 |

表4.1.3(2)-9 ReceiptBillViewController的接口规范

| 提供的服务(供接口)                       |      |                                         |
| -------------------------------- | ---- | --------------------------------------- |
| 服务名                              |      | 服务                                      |
| ReceiptBillViewController.show   | 语法   | public void show()                      |
|                                  | 前置条件 | 无                                       |
|                                  | 后置条件 | 显示制定收款单                                 |
| ReceiptBillViewController.commit | 语法   | public void commit(ReceiptBill receipt) |
|                                  | 前置条件 | 点击提交按钮                                  |
|                                  | 后置条件 | 返回提交状态                                  |

| 需要的服务(需接口)                              |       |
| --------------------------------------- | ----- |
| 服务名                                     | 服务    |
| FinanceInfoController.commitReceiptBill | 提交收款单 |

表4.1.3(2)-10 TableViewController的接口规范

| 提供的接口(供接口)                 |      |                                          |
| -------------------------- | ---- | ---------------------------------------- |
| 服务名                        |      | 服务                                       |
| TableViewController.search | 语法   | public ArrayList<Bill> search(BillFilter filter) |
|                            | 前置条件 | 点击搜索button                               |
|                            | 后置条件 | 返回匹配的单据                                  |
| TableViewController.show   | 语法   | public void show()                       |
|                            | 前置条件 | 无                                        |
|                            | 后置条件 | 显示界面                                     |

| 需要的接口(需接口)                       |         |
| -------------------------------- | ------- |
| 服务名                              | 服务      |
| FinanceInfoController.searchBill | 返回匹配的单据 |

表4.1.3(2)-11CheckGeneralAccountController的接口规范

| 提供的接口(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| CheckGeneralAccountController.showSearchView | 语法   | public void showSearchView()             |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 显示期初建账的搜索界面                              |
| CheckGeneralAccountController.search     | 语法   | public void search()                     |
|                                          | 前置条件 | 用户点击搜索button                             |
|                                          | 后置条件 | 显示符合条件的总账列表                              |
| CheckGeneralAccountController.add        | 语法   | public ResultMessage add(GeneralAccount account) |
|                                          | 前置条件 | 用户点击增加button                             |
|                                          | 后置条件 | 返回增加账户状态                                 |

| 需要的服务(需接口)                               |           |
| ---------------------------------------- | --------- |
| 服务名                                      | 服务        |
| FinanceInfoController.searchGeneralAccount | 搜索符合条件的单据 |
| CreateGeneralAccountController.show      | 显示增加账户界面  |

表4.1.3(2)-12 CreateGeneralAccountController的接口规范

| 提供的服务(供接口)                            |      |                                          |
| ------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                   |      | 服务                                       |
| CreateGeneralAccountController.show   | 语法   | public void show()                       |
|                                       | 前置条件 | 无                                        |
|                                       | 后置条件 | 显示期初建账界面                                 |
| CreateGeneralAccountController.commit | 语法   | public void commit(GeneralAccount account) |
|                                       | 前置条件 | 点击提交按钮                                   |
|                                       | 后置条件 | 返回提交状态                                   |

| 需要的服务(需接口)                               |      |
| ---------------------------------------- | ---- |
| 服务名                                      | 服务   |
| FinanceInfoController.commitGeneralAccount | 提交账户 |

表4.1.3(2)-13 FinanceInfoController的接口规范

| 提供的服务(供接口)                               |      |                                          |
| ---------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                      |      | 服务                                       |
| FinanceInfoController.commitGeneralAccount | 语法   | public void commitGeneralAccount(GeneralAccount account) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| FinanceInfoController.searchGeneralAccount | 语法   | public ArrayList<GeneralAccount> searchGeneralAccount(GeneralAccountFilter filter) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回符合条件的总账                                |
| FinanceInfoController.commitPayBill      | 语法   | public void commitPayBill()              |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| FinanceInfoController.commitReceiptBill  | 语法   | public void commitReceiptBill()          |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| FinanceInfoController.commitCashBill     | 语法   | public void commitCashBill()             |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 无                                        |
| FinanceInfoController.addAccount         | 语法   | public ResultMessage addAccount(Account account) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回添加状态                                   |
| FinanceInfoController.deleteAccount      | 语法   | public ResultMessage deleteAccount(String id) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回删除状态                                   |
| FinanceInfoController.modifyAccount      | 语法   | public ResultMessage modifyAccount(Account account ,String id) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回修改状态                                   |
| FinanceInfoController.searchAccount      | 语法   | public ArrayList<Account> searchAccount(AccountFilter filter) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回符合条件的账户列表                              |
| FinanceInfoController.searchBill         | 语法   | public ArrayList<Bill> searchBill(BillFilter filter) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回符合条件的单据列表                              |

| 需要的服务(需接口)                            |           |
| ------------------------------------- | --------- |
| 服务名                                   | 服务        |
| FinanceBLService.commitGeneralAccount | 提交单据      |
| FinanceBLService.searchGeneralAccount | 搜索匹配的期初账户 |
| FinanceBLServicer.commitPayBill       | 提交付款单     |
| FinanceBLService.commitReceiptBill    | 提交收款单     |
| FinanceBLService.commitCashBill       | 提交现金费用单   |
| FinanceBLService.addAccount           | 增加账户      |
| FinanceBLService.deleteAccount        | 删除账户      |
| FinanceBLService.modifyAccount        | 修改账户      |
| FinanceBLService.searchAccount        | 查找账户      |
| FinanceBLService.searchBill           | 查找单据      |

#### 4.1.4 chiefmanger模块

##### （1）整体结构

展示层的控制器为树状委托式结构，ChiefManagerViewController负责总经理界面的整体跳转，ChiefManagerNavBarController负责实现导航栏界面，ChiefManagerSearchListController负责实现查看报表界面，ChiefManagerSalesListController负责实现查看销售明细表界面，ChiefManagerManageListController负责实现查看经营情况表界面，ChiefManagerExamineBillController负责实现审批单据界面,ChiefManagerShowBillDetailController负责实现显示单据详情界面，ChiefManagerReadLogController负责实现查询日志界面，ChiefManagerShowLogDetail负责实现显示日志详情界面，ChiefManagerSetPromotionController负责实现制定销售策略界面。

chiefManager界面各个类的职责如下表所示

| 模块                                   | 职责             |
| ------------------------------------ | -------------- |
| ChiefManagerViewController           | 负责实现总经理界面的整体跳转 |
| ChiefManagerNavBarController         | 负责实现导航栏界面      |
| ChiefManagerSearchListController     | 负责实现查看报表界面     |
| ChiefManagerSalesListController      | 负责实现查看销售明细表界面  |
| ChiefManagerManageListController     | 负责实现查看经营情况表界面  |
| ChiefManagerExamineBillController    | 负责实现审批单据界面     |
| ChiefManagerShowBillDetailController | 负责实现显示单据详情界面   |
| ChiefManagerReadLogController        | 负责实现查询日志界面     |
| ChiefManagerShowLogDetail            | 负责实现显示日志详情界面   |
| ChiefManagerSetPromotionController   | 负责实现制定销售策略界面   |

##### （2）模块内部类的接口规范

ChiefManagerViewController的接口规范

| 提供的服务（供接口）                               |           |                                 |
| ---------------------------------------- | --------- | ------------------------------- |
| 服务名                                      | 服务        |                                 |
| ChiefManagerViewController.showSearchList | 语法        | public void showSearchList();   |
| 前置条件                                     | 点击导航栏查看报表 |                                 |
| 后置条件                                     | 显示查看报表界面  |                                 |
| ChiefManagerViewController.showExamineBill | 语法        | public void showExamineBill();  |
| 前置条件                                     | 点击导航栏审批单据 |                                 |
| 后置条件                                     | 显示审批单据界面  |                                 |
| ChiefManagerViewController.showReadLog   | 语法        | public void showReadLog();      |
| 前置条件                                     | 点击导航栏查询日志 |                                 |
| 后置条件                                     | 显示查询日志界面  |                                 |
| ChiefManagerViewController.showSetPromotion | 语法        | public void showSetPromotion(); |
| 前置条件                                     | 点击导航栏促销策略 |                                 |
| 后置条件                                     | 显示促销策略界面  |                                 |
| 需要的服务（需接口）                               |           |                                 |
| 无                                        |           |                                 |

ChiefManagerNavBarController的接口规范

| 提供的服务（供接口）                               |            |
| ---------------------------------------- | ---------- |
| 服务名                                      | 服务         |
| 无                                        |            |
| 需要的服务（需接口）                               |            |
| 服务名                                      | 服务         |
| ChiefManagerViewController.showSearchList | 显示查看报表界面   |
| ChiefManagerViewController.showExamineBill | 显示审批单据界面   |
| ChiefManagerViewController.showReadLog   | 显示查询日志界面   |
| ChiefManagerViewController.showSetPromotion | 显示制定促销策略界面 |

ChiefManagerSearchListController的接口规范

| 提供的服务（供接口）                               |                |                         |
| ---------------------------------------- | -------------- | ----------------------- |
| 服务名                                      | 服务             |                         |
| ChiefManagerSearchListController.showList | 语法             | public void showList(); |
| 前置条件                                     | 点击查看报表界面的确认按钮  |                         |
| 后置条件                                     | 输出符合用户条件的报表    |                         |
| ChiefManagerSearchListController.empty   | 语法             | public void empty();    |
| 前置条件                                     | 点击查看报表界面的清空按钮  |                         |
| 后置条件                                     | 清空查询条件         |                         |
| ChiefManagerSearchListController.exit    | 语法             | public void exit();     |
| 前置条件                                     | 点击查看报表界面的退出按钮  |                         |
| 后置条件                                     | 退出查询功能返回总经理主界面 |                         |
| 需要的服务（需接口）                               |                |                         |
| 服务名                                      | 服务             |                         |
| ChiefManagerBLServiceImpl.makeSalesList  | 制作符合条件的销售明细表   |                         |
| ChiefManagerBLServiceImpl.makeManageList | 制作符合条件的经营情况表   |                         |

ChiefManagerSalesListController的接口规范

| 提供的服务（供接口）                             |                |                       |
| -------------------------------------- | -------------- | --------------------- |
| 服务名                                    | 服务             |                       |
| ChiefManagerSalesListController.back   | 语法             | public void back();   |
| 前置条件                                   | 无              |                       |
| 后置条件                                   | 返回上一界面         |                       |
| ChiefManagerSalesListController.export | 语法             | public void export(); |
| 前置条件                                   | 点击销售明细表界面的导出按钮 |                       |
| 后置条件                                   | 导出当前的报表        |                       |
| 需要的服务（需接口）                             |                |                       |
| 服务名                                    | 服务             |                       |
| ChiefManagerBLServiceImpl.export       | 导出当前的报表        |                       |

ChiefManagerManageListController的接口规范

| 提供的服务（供接口）                              |                |                       |
| --------------------------------------- | -------------- | --------------------- |
| 服务名                                     | 服务             |                       |
| ChiefManagerManageListController.back   | 语法             | public void back();   |
| 前置条件                                    | 无              |                       |
| 后置条件                                    | 返回上一界面         |                       |
| ChiefManagerManageListController.export | 语法             | public void export(); |
| 前置条件                                    | 点击经营情况表界面的导出按钮 |                       |
| 后置条件                                    | 导出当前的报表        |                       |
| 需要的服务（需接口）                              |                |                       |
| 服务名                                     | 服务             |                       |
| ChiefManagerBLServiceImpl.export        | 导出当前的报表        |                       |

ChiefManagerExamineBillController的接口规范

| 提供的服务（供接口）                               |                |                               |
| ---------------------------------------- | -------------- | ----------------------------- |
| 服务名                                      | 服务             |                               |
| ChiefManagerExamineBillController.showBillList | 语法             | public void showBillList();   |
| 前置条件                                     | 点击导航栏审批单据按钮    |                               |
| 后置条件                                     | 显示当前待审批单据列表    |                               |
| ChiefManagerExamineBillController.confirm | 语法             | public void confirm();        |
| 前置条件                                     | 点击审批单据界面的确认按钮  |                               |
| 后置条件                                     | 选定单据           |                               |
| ChiefManagerExamineBillController.pass   | 语法             | public void pass();           |
| 前置条件                                     | 有选定的单据         |                               |
| 后置条件                                     | 单据被审批通过        |                               |
| ChiefManagerExamineBillController.fail   | 语法             | public void fail();           |
| 前置条件                                     | 有选定的单据         |                               |
| 后置条件                                     | 单据被审批不通过       |                               |
| ChiefManagerExamineBillControlle.exit    | 语法             | public void exit();           |
| 前置条件                                     | 点击审批界面的退出按钮    |                               |
| 后置条件                                     | 退出审批功能返回总经理主界面 |                               |
| ChiefManagerExamineBillControlle.showBillDetail | 语法             | public void showBillDetail(); |
| 前置条件                                     | 点击一条单据         |                               |
| 后置条件                                     | 显示单据的详细信息      |                               |
| 需要的服务（需接口）                               |                |                               |
| 服务名                                      | 服务             |                               |
| ChiefManagerBLServiceImpl.showBillList   | 显示当前提交单据列表     |                               |
| ChiefManagerBLServiceImpl.changeBillState | 改变选定单据的状态      |                               |
| ChiefManagerBLServiceImpl.exit           | 退出当前功能返回总经理界面  |                               |
| ChiefManagerShowBillDetailController.showBillDetail | 显示单据的详细信息      |                               |

ChiefManagerShowBillDetailController的接口规范

| 提供的服务（供接口）                               |           |                               |
| ---------------------------------------- | --------- | ----------------------------- |
| 服务名                                      | 服务        |                               |
| ChiefManagerShowBillDetailController.back | 语法        | public void back();           |
| 前置条件                                     | 无         |                               |
| 后置条件                                     | 返回上一界面    |                               |
| ChiefManagerShowBillDetailController.showBillDetail | 语法        | public void showBillDetail(); |
| 前置条件                                     | 无         |                               |
| 后置条件                                     | 显示单据的详细信息 |                               |
| 需要的服务（需接口）                               |           |                               |
| 服务名                                      | 服务        |                               |
| ChiefManagerBLServiceImpl.showBillDetail | 显示单据的详细信息 |                               |

ChiefManagerReadLogController的接口规范

| 提供的服务（供接口）                               |                |                               |
| ---------------------------------------- | -------------- | ----------------------------- |
| 服务名                                      | 服务             |                               |
| ChiefManagerReadLogController.showLogList | 语法             | public void showLogList();    |
| 前置条件                                     | 点击导航栏查询日志按钮    |                               |
| 后置条件                                     | 显示当前日志列表       |                               |
| ChiefManagerReadLogController.exit       | 语法             | public void exit();           |
| 前置条件                                     | 点击查询日志界面的退出按钮  |                               |
| 后置条件                                     | 退出查询功能返回总经理主界面 |                               |
| ChiefManagerReadLogController.showLogDetail | 语法             | public void showBillDetail(); |
| 前置条件                                     | 点击一条日志         |                               |
| 后置条件                                     | 显示日志的详细信息      |                               |
| 需要的服务（需接口）                               |                |                               |
| 服务名                                      | 服务             |                               |
| ChiefManagerBLServiceImpl.showLogList    | 显示当前日志列表       |                               |
| ChiefManagerBLServiceImpl.exit           | 退出当前功能返回总经理界面  |                               |
| ChiefManagerShowLogDetailController.showLogDetail | 显示日志的详细信息      |                               |

ChiefManagerShowLogDetailController的接口规范

| 提供的服务（供接口）                               |           |                               |
| ---------------------------------------- | --------- | ----------------------------- |
| 服务名                                      | 服务        |                               |
| ChiefManagerShowLogDetailController.back | 语法        | public void back();           |
| 前置条件                                     | 无         |                               |
| 后置条件                                     | 返回上一界面    |                               |
| ChiefManagerShowLogDetailController.showLogDetail | 语法        | public void showBillDetail(); |
| 前置条件                                     | 无         |                               |
| 后置条件                                     | 显示日志的详细信息 |                               |
| 需要的服务（需接口）                               |           |                               |
| 服务名                                      | 服务        |                               |
| ChiefManagerBLServiceImpl.showLogDetail  | 显示日志的详细信息 |                               |

ChiefManagerSetPromotionController的接口规范

| 提供的服务（供接口）                               |              |                                  |
| ---------------------------------------- | ------------ | -------------------------------- |
| 服务名                                      | 服务           |                                  |
| ChiefManagerSetPromotionController.submit | 语法           | public void confirm();           |
| 前置条件                                     | 点击促销策略界面确认按钮 |                                  |
| 后置条件                                     | 返回促销策略是否制定成功 |                                  |
| ChiefManagerSetPromotionController.exit  | 语法           | public void exit();              |
| 前置条件                                     | 无            |                                  |
| 后置条件                                     | 返回上一个界面      |                                  |
| ChiefManagerSetPromotionController.showPromotionList | 语法           | public void showPromotionList(); |
| 前置条件                                     | 无            |                                  |
| 后置条件                                     | 显示当前促销策略列表   |                                  |
| 需要的服务（需接口）                               |              |                                  |
| 服务名                                      | 服务           |                                  |
| ChiefManagerBLService.choosePromotionTyp | 选择促销策略类型     |                                  |
| ChiefManagerBLService.setPromotionTime   | 选择促销策略时间区间   |                                  |
| ChiefManagerBLService.checkPromotionInfo | 检查促销策略信息     |                                  |
| ChiefManagerBLService.ShowPromotionList  | 显示当前策略列表     |                                  |



#### 4.1.4 admin模块

##### （1）整体结构

展示层的控制器为树状委托式结构，AdminViewController负责对系统管理员界面的整体跳转，AdminNavBarController负责实现导航栏界面。

Admin界面各类的职责如表4.2.1(1)-1所示

表4.2.1(1)-1 Admin界面各类的职责

| 模块                       | 职责              |
| ------------------------ | --------------- |
| AdminViewController      | 负责对系统管理员界面的整体跳转 |
| AdminNavBarController    | 负责实现导航栏界面       |
| UserAddViewController    | 负责实现增加用户界面的跳转   |
| UserDelViewController    | 负责实现删除用户界面的跳转   |
| UserModifyViewController | 负责实现修改用户界面的跳转   |

##### （2）模块内部类的接口规范

表4.1.4(2)-1 AdminViewController的接口规范

提供的服务（供接口）

| 服务名                                | 服务   | 服务                            |
| ---------------------------------- | ---- | ----------------------------- |
| AdminViewController.showUserAdd    | 语法   | public boolean showUserAdd(); |
|                                    | 前置条件 | 点击导航栏增加用户                     |
|                                    | 后置条件 | 显示增加用户界面                      |
| AdminViewController.showUserDel    | 语法   | public boolean showUserDel(); |
|                                    | 前置条件 | 点击导航栏删除用户                     |
|                                    | 后置条件 | 显示删除用户界面                      |
| AdminViewController.showUserModify | 语法   | public boolean showUserAdd(); |
|                                    | 前置条件 | 点击导航栏修改用户                     |
|                                    | 后置条件 | 显示修改用户界面                      |

需要的服务（需接口）

| 服务名                           | 服务       |
| ----------------------------- | -------- |
| UserAddViewController.show    | 显示增加用户界面 |
| UserDelViewController.show    | 显示删除用户界面 |
| UserModifyViewController.show | 显示修改用户界面 |

表4.1.4(2)-2 AdminNavBarController的接口规范

提供的服务（供接口）

无

需要的服务（需接口）

| 服务名                           | 服务       |
| ----------------------------- | -------- |
| UserAddViewController.show    | 显示增加用户界面 |
| UserDelViewController.show    | 显示删除用户界面 |
| UserModifyViewController.show | 显示修改用户界面 |
|                               |          |



表4.1.4(2)-3 UserAddViewController的接口规范

提供的服务（供接口）

| 服务名                           | 服务   | 服务                                  |
| ----------------------------- | ---- | ----------------------------------- |
| UserAddViewController.back    | 语法   | public boolean back()               |
|                               | 前置条件 | 点击返回按钮                              |
|                               | 后置条件 | 返回上一界面                              |
| UserAddViewController.addUser | 语法   | public boolean addUser(UserVO user) |
|                               | 前置条件 | 点击确定按钮                              |
|                               | 后置条件 | 系统更新数据                              |
| UserAddViewController.show    | 语法   | public boolean show()               |
|                               | 前置条件 | 无                                   |
|                               | 后置条件 | 显示增加用户界面                            |

需要的服务（需接口）

| 服务名                      | 服务       |
| ------------------------ | -------- |
| AdminViewController.show | 显示用户管理界面 |
|                          |          |

表4.1.4(2)-4 UserDelViewController的接口规范

提供的服务（供接口）

| 服务名                           | 服务   | 服务                                |
| ----------------------------- | ---- | --------------------------------- |
| UserDelViewController.back    | 语法   | public boolean back()             |
|                               | 前置条件 | 点击返回按钮                            |
|                               | 后置条件 | 返回上一界面                            |
| UserDelViewController.delUser | 语法   | public boolean delUser(String id) |
|                               | 前置条件 | 点击确定按钮                            |
|                               | 后置条件 | 系统更新数据                            |
| UserDelViewController.show    | 语法   | public boolean show()             |
|                               | 前置条件 | 无                                 |
|                               | 后置条件 | 显示删除用户界面                          |

需要的服务（需接口）

| 服务名                      | 服务       |
| ------------------------ | -------- |
| AdminViewController.show | 显示用户管理界面 |
|                          |          |

表4.1.4(2)-5 UserModifyViewController的接口规范

提供的服务（供接口）

| 服务名                                  | 服务   | 服务                                     |
| ------------------------------------ | ---- | -------------------------------------- |
| UserModifyViewController.back        | 语法   | public boolean back()                  |
|                                      | 前置条件 | 点击返回按钮                                 |
|                                      | 后置条件 | 返回上一界面                                 |
| UserModifyViewController.addCustomer | 语法   | public boolean modifyUser(UserVO user) |
|                                      | 前置条件 | 点击确定按钮                                 |
|                                      | 后置条件 | 系统更新数据                                 |
| UserModifyViewController.show        | 语法   | public boolean show()                  |
|                                      | 前置条件 | 无                                      |
|                                      | 后置条件 | 显示修改用户界面                               |

需要的服务（需接口）

| 服务名                      | 服务       |
| ------------------------ | -------- |
| AdminViewController.show | 显示用户管理界面 |
|                          |          |

### 

### 4.2 业务逻辑层的分解

#### 4.2.1 UserBL模块

##### （1）模块描述

userbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求。

userbl模块的职责及接口参见软件体系结构设计文档

##### （2）整体结构

根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，我们会添加接口。比如展示层和业务逻辑层之间我们添加businesslogicservice.userblservice.UserBLService接口。业务逻辑层和数据层之间添加dataservice.UserDataService。为了隔离业务逻辑职责和逻辑控制职责，我们增加了UserBLServiceImpl，这样UserBLServiceImpl会将用户管理和登陆登出的业务逻辑委托给UserManage对象和UserLog对象。UserPO是作为用户的持久化对象被添加到设计模型中去的。UserVO是作为值对象被添加到设计模型中去的。

UserBL模块各个类的职责

| 模块                | 职责                             |
| ----------------- | ------------------------------ |
| UserBLServiceImpl | 管理 userbl 各个类的任务，负责与其他 bl 模块交互 |
| UserManage        | 负责对用户的增加、删除和修改操作               |
| UserLog           | 负责用户的登陆登出操作                    |

##### （3）模块内部类的接口规范

UserBLServiceImpl的接口规范如表4.2.1(3)-1所示

UserManage的接口规范如表4.2.1(3)-2所示

UserLog的接口规范如表4.2.1(3)-3所示

表4.2.1(3)-1 UserBLServiceImpl的接口规范

提供的服务（供接口）

| 服务名                          | 服务   | 服务                                       |
| ---------------------------- | ---- | ---------------------------------------- |
| UserBLServiceImpl.login      | 语法   | public Log_In_Out_Status login(String ID, String password) |
|                              | 前置条件 | 用户处于未登录状态                                |
|                              | 后置条件 | 用户登陆                                     |
| UserBLServiceImpl.logout     | 语法   | public Log_In_Out_Status logout(String ID) |
|                              | 前置条件 | 用户已登录                                    |
|                              | 后置条件 | 用户登出                                     |
| UserBLServiceImpl.addUser    | 语法   | public ResultMessage addUser(UserVO);    |
|                              | 前置条件 | 输入的信息符合规范                                |
|                              | 后置条件 | 增加用户                                     |
| UserBLServiceImpl.delUser    | 语法   | public ResultMessage delUser(String ID); |
|                              | 前置条件 | 输入的ID已存在                                 |
|                              | 后置条件 | 删除该用户                                    |
| UserBLServiceImpl.modifyUser | 语法   | public ResultMessage modifyUser(UserVO); |
|                              | 前置条件 | 输入的信息符合规范                                |
|                              | 后置条件 | 修改用户属性                                   |

需要的服务（需接口）

| 服务名                   | 服务   |
| --------------------- | ---- |
| UserManage.addUser    | 增加用户 |
| UserManage.delUser    | 删除用户 |
| UserManage.modifyUser | 修改用户 |
| UserLog.login         | 登陆   |
| UserLog.logout        | 登出   |

表4.2.1(3)-2 UserManage的接口规范

| 服务名                   | 服务   | 服务                                       |
| --------------------- | ---- | ---------------------------------------- |
| UserManage.addUser    | 语法   | public ResultMessage addUser(UserVO);    |
|                       | 前置条件 | 输入的信息符合规范                                |
|                       | 后置条件 | 增加用户                                     |
| UserManage.delUser    | 语法   | public ResultMessage delUser(String ID); |
|                       | 前置条件 | 输入的ID已存在                                 |
|                       | 后置条件 | 删除该用户                                    |
| UserManage.modifyUser | 语法   | public ResultMessage modifyUser(UserVO); |
|                       | 前置条件 | 输入的信息符合规范                                |
|                       | 后置条件 | 修改用户属性                                   |

需要的服务（需接口）

| 服务名                          | 服务   |
| ---------------------------- | ---- |
| UserBLServiceImpl.addUser    | 增加用户 |
| UserBLServiceImpl.delUser    | 删除用户 |
| UserBLServiceImpl.modifyUser | 修改用户 |

表4.2.1(3)-3 UserLog的接口规范

提供的服务（供接口）

| 服务名            | 服务   | 服务                                       |
| -------------- | ---- | ---------------------------------------- |
| UserLog.login  | 语法   | public Log_In_Out_Status login(String ID, String password) |
|                | 前置条件 | 用户处于未登录状态                                |
|                | 后置条件 | 用户登陆                                     |
| UserLog.logout | 语法   | public Log_In_Out_Status logout(String ID) |
|                | 前置条件 | 用户已登录                                    |
|                | 后置条件 | 用户登出                                     |

需要的服务（需接口）

| 服务名                      | 服务   |
| ------------------------ | ---- |
| UserBLServiceImpl.login  | 登陆   |
| UserBLServiceImpl.logout | 登出   |
|                          |      |

##### （4）业务逻辑层内部动态模型

增加用户顺序图

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%BF%9B%E8%B4%A7%E9%94%80%E5%94%AE%E4%BA%BA%E5%91%98/Admin-%E5%A2%9E%E5%8A%A0%E7%94%A8%E6%88%B7.png)

登陆顺序图

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%BF%9B%E8%B4%A7%E9%94%80%E5%94%AE%E4%BA%BA%E5%91%98/Admin_login.png)

# 详细设计模板

## BillBL

(1)模块描述

billbl模块承担的需求参见规格说明文档功能需求以及相关非功能需求

billbl模块的职责及接口参见软件系统结构描述文档

(2)整体结构

根据体系结构的设计，我们将系统分成了展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，比如展示层和逻辑层之间我们添加billblservice接口。业务逻辑层和数据层之间添加billdataservice接口，为了隔离业务逻辑职责和业务控制职责，我们增加了billController，这样billController会将对单据信息的逻辑处理委托给stockbill,salesinbill,salesoutbill,financebill对象，stockbillpo是作为库存类单据的持久化对象被添加到设计模型中，salesInbillpo是作为进货类单据的持久化对象被添加到设计模型中，salesoutbillpo是作为销售类单据的持久化对象被添加到设计模型中，financebillpo是作为财务类单据的持久化对象被添加到设计模型中，

bill模块的设计如图所示

| 模块             | 职责                         |
| -------------- | -------------------------- |
| billController | 负责管理bill各个类的任务，负责与其他模块进行交互 |
| stockbill      | 完成对库存类报表的增改查               |
| salesinbill    | 完成对进货类报表的增改查               |
| salesoutbill   | 完成对销售类报表的增改查               |
| financebill    | 完成对财务类报表的增改查               |

(3) 模块内部类的接口规范

表一billcontroller

提供的服务 供接口

| 服务名                               | 服务   |                                          |
| --------------------------------- | ---- | ---------------------------------------- |
| BillController.addstockbill       | 语法   | public ResultMessage addstockbill(StockBillVO stockBillVO) |
|                                   | 前置条件 | 添加库存单                                    |
|                                   | 后置条件 | 返回添加是否成功                                 |
| BillController.updatestockbill    | 语法   | public ResultMessage updatestockbill(StockBillVO stockBillVO) |
|                                   | 前置条件 | 更新库存单                                    |
|                                   | 后置条件 | 返回更新是否成功                                 |
| BillController.searchstockbill    | 语法   | public ArrayList< StockBillVO> searchstockbill(FilterFlag flag) |
|                                   | 前置条件 | 搜索库存单                                    |
|                                   | 后置条件 | 返回符合条件的库存单                               |
| BillController.addsalesinbill     | 语法   | public ResultMessage addsalesinbill(SalesInBillVO salesinbillVO) |
|                                   | 前置条件 | 添加进货单                                    |
|                                   | 后置条件 | 返回是否添加成功                                 |
| BillController.updatesalesinbill  | 语法   | public ResultMessage updatesalesinbill(SalesInBillVO salesinbillVO) |
|                                   | 前置条件 | 更新进货单                                    |
|                                   | 后置条件 | 返回是否更新成功                                 |
| BillController.searchsalesinbill  | 语法   | public ArrayList< SalesInVO> searchsalesinbill(FilterFlag flag) |
|                                   | 前置条件 | 搜索进货单                                    |
|                                   | 后置条件 | 返回符合条件的进货单                               |
| BillController.addsalesoutbill    | 语法   | public ResultMessage addsalesoutbill(SalesOutBillVO salesoutbillVO) |
|                                   | 前置条件 | 添加售货单                                    |
|                                   | 后置条件 | 返回添加成功与否                                 |
| BillController.updatesalesoutbill | 语法   | public ResultMessage updatesalesoutbill(SalesOutBillVO salesoutbillVO) |
|                                   | 前置条件 | 更新售货单                                    |
|                                   | 后置条件 | 返回更新成功与否                                 |
| BillController.searchsalesoutbill | 语法   | public ArrayList< SalesOutBillVO >searchsalesoutbill(FilterFlag flag) |
|                                   | 前置条件 | 搜索符合条件的售货单                               |
|                                   | 后置条件 | 返回符合条件的售货单                               |
| BillController.addfinancebill     | 语法   | public ResultMessage addfinancebill(FinanceBillVO financebillVO) |
|                                   | 前置条件 | 添加财务单                                    |
|                                   | 后置条件 | 返回添加成功与否                                 |
| BillController.updatefinancebill  | 语法   | public ResultMessage updatefinancebill(FinanceBillVO financebillVO) |
|                                   | 前置条件 | 更新财务单                                    |
|                                   | 后置条件 | 返回更新成功与否                                 |
| BillController.searchfinancebill  | 语法   | searchfinancebill(FilterFlag flag)       |
|                                   | 前置条件 | 搜索符合条件的财务单                               |
|                                   | 后置条件 | 返回符合条件的财务单                               |

需要的服务 需接口

| 服务名                             | 服务      |
| ------------------------------- | ------- |
| stockbill.addstockbill          | 添加库存类单据 |
| stockbill.updatestockbill       | 更新库存类单据 |
| stockbill.searchstockbill       | 搜索库存类单据 |
| salesinbill.addsaleinbill       | 添加进货类单据 |
| salesinbill.updatesaleinbill    | 更新进货类单据 |
| salesinbill.searchsaleinbill    | 搜索进货类单据 |
| salesoutbill.addsalesoutbill    | 添加销售类单据 |
| salesoutbill.updatesalesoutbill | 更新销售类单据 |
| salesoutbill.searchsalesoutbill | 搜索销售类单据 |
| financebill.addfinancebill      | 添加财务类单据 |
| financebill.updatefinancebill   | 更新财务类单据 |
| financebill.searchfinancebill   | 搜索财务类单据 |

表二stockbill

| 服务名                       | 服务   |                                          |
| ------------------------- | ---- | ---------------------------------------- |
| stockbill.addstockbill    | 语法   | public ResultMessage addstockbill(StockBillVO stockBillVO) |
|                           | 前置条件 | 添加库存单                                    |
|                           | 后置条件 | 返回添加成功与否                                 |
| stockbill.updatestockbill | 语法   | public ResultMessage updatestockbill(StockBillVO stockBillVO) |
|                           | 前置条件 | 更新库存单                                    |
|                           | 后置条件 | 返回更新成功与否                                 |
| stockbill.searchstockbill | 语法   | public ArrayList< StockBillVO> searchstockbill(FilterFlag flag) |
|                           | 前置条件 | 搜索符合条件的库存单                               |
|                           | 后置条件 | 返回符合条件的库存单                               |
|                           |      |                                          |
|                           |      |                                          |

需要的服务 需接口

| 服务名                              | 服务     |
| -------------------------------- | ------ |
| stockdataservice.addstockbill    | 添加库存单据 |
| stockdataservice.updatestockbill | 更新库存单据 |
| stockdataservice.searchstockbill | 搜索库存单据 |

表三 salesinbill

提供的服务 供接口

| 服务名                          | 服务   |                                          |
| ---------------------------- | ---- | ---------------------------------------- |
| salesinbill.addsaleinbill    | 语法   | public ResultMessage addsaleinbill(SalesInBillVO salesinbillVO) |
|                              | 前置条件 | 添加进货单                                    |
|                              | 后置条件 | 返回添加成功与否                                 |
| salesinbill.updatesaleinbill | 语法   | public ResultMessage updatesaleinbill(SalesInBillVO salesinbillVO) |
|                              | 前置条件 | 更新进货单                                    |
|                              | 后置条件 | 返回更新成功与否                                 |
| salesinbill.searchsaleinbill | 语法   | public ArrayList< SaleInBillVO> searchsalesinbill(FilterFlagers) |
|                              | 前置条件 | 搜索符合条件的进货单                               |
|                              | 后置条件 | 返回更新成功与否                                 |
|                              |      |                                          |
|                              |      |                                          |

需要的服务 需接口

| 服务名                               | 服务    |
| --------------------------------- | ----- |
| billdataservice.addsaleinbill     | 添加进货单 |
| billdataservice.updatesalesinbill | 更新进货单 |
| billdataservice.searchsalesinbill | 搜索进货单 |



表四 salesoutbill

提供的服务 供接口

| 服务名                            | 服务   |                                          |
| ------------------------------ | ---- | ---------------------------------------- |
| salesoutbill.addsaleoutbill    | 语法   | public ResultMessage addsaleoutbill(SaleOutBillVO saleoutbillVO) |
|                                | 前置条件 | 添加售货单                                    |
|                                | 后置条件 | 返回添加成功与否                                 |
| salesoutbill.updatesaleoutbill | 语法   | public ResultMessage updatesaleoutbill(SaleOutBillVO saleoutbillVO) |
|                                | 前置条件 | 更新售货单                                    |
|                                | 后置条件 | 返回更新成功与否                                 |
| salesoutbill.searchsaleoutbill | 语法   | public ArrayList< SaleOutBillVO>searchsaleoutbill |
|                                | 前置条件 | 搜索售货单                                    |
|                                | 后置条件 | 返回符合条件的售货单                               |
|                                |      |                                          |
|                                |      |                                          |

需要的服务 需接口

| 服务名                                | 服务    |
| ---------------------------------- | ----- |
| billdataservice.addsaleoutbill     | 添加售货单 |
| billdataservice.updatesalesoutbill | 更新售货单 |
| billdataservice.searchsalesoutbill | 搜素售货单 |

表五 financebill

提供的服务 供接口

| 服务名                           | 服务   |                                          |
| ----------------------------- | ---- | ---------------------------------------- |
| financebill.addfinancebill    | 语法   | public ResultMessage addfinancebill(FinanceBillVO financebillVO) |
|                               | 前置条件 | 添加财务类单据                                  |
|                               | 后置条件 | 返回更新成功与否                                 |
| financebill.updatefinancebill | 语法   | public ResultMessage updatefinancebill(FinanceBillVO financebillVO) |
|                               | 前置条件 | 更新财务类单据                                  |
|                               | 后置条件 | 返回更新成功与否                                 |
| financebill.searchfinancebill | 语法   | public ArrayList< FinanceBillVO>searchfinancebill(FilterFlagers) |
|                               | 前置条件 | 搜索财务类单据                                  |
|                               | 后置条件 |                                          |
|                               |      |                                          |
|                               |      |                                          |

需要的服务 需接口

| 服务名                               | 服务      |
| --------------------------------- | ------- |
| billdataservice.addfinancebill    | 添加财务类单据 |
| billdataservice.updatefinancebill | 更新财务类单据 |
| billdataservice.searchfinancebill | 搜索财务类单据 |

## StockBL

(1)模块描述

stockbl模块承担的需求参见需求规格说明文档功能需求以及相关非功能需求

stockbl模块的职责及接口参见软件系统结构描述文档

(2) 整体结构

根据体系结构的设计，我们将系统分成展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，比如展示层和逻辑层之间，我们添加stockblservice接口。业务逻辑层和数据层之间添加stockdataservice接口。为了隔离业务逻辑职责和逻辑控制职责，我们增加了StockController，这样StockController会将对库存信息的逻辑处理委托给Stock和Inventory对象，stockPO是作为进出库记录的持久化对象被添加到设计模型中，inventoryPO是作为商品库存记录的持久化对象被添加到设计模型中CommodityInfo是根据依赖到导致原则，为了消除循环依赖而产生的接口。ChangeInfoVO是为了保存因订单变化而要进行的库存信息的更改

stock模块的设计如图所示

| 模块              | 职责                          |
| --------------- | --------------------------- |
| stockController | 管理stockbl各个类的任务，负责和其他bl模块交互 |
| stock           | 完成对商品进出库信息的增查               |
| inventory       | 完成对商品库存相关信息的增改查             |
|                 |                             |

(3) 模块内部类的接口规范

表一stockController

提供的接口 供接口

| 服务名                                     | 服务   |                                          |
| --------------------------------------- | ---- | ---------------------------------------- |
| StockController.viewStock               | 语法   | public ArrayList< StockVO> viewStock(Date startTime, Date endTime); |
|                                         | 前置条件 | 想要查看进出库数据                                |
|                                         | 后置条件 | 返回进出库信息，若无则返回空                           |
| StockController.checkInventory          | 语法   | public ArrayList< InventoryVO> checkInventory() |
|                                         | 前置条件 | 要进行库存盘点                                  |
|                                         | 后置条件 | 返回商品库存信息列表若无则返回空                         |
| StockController.updateStockAndInventory | 语法   | public ResultMessage updateStock(ChangeInfoVO changeInvo) |
|                                         | 前置条件 | 更新库存信息                                   |
|                                         | 后置条件 | 返回更新是否成功                                 |
|                                         |      |                                          |

需要的接口 需接口

| 服务名                          | 服务       |
| ---------------------------- | -------- |
| Stock.addStock               | 增加进出库信息  |
| Stock.viewStock              | 查看出入库信息  |
| Inventory.updateInventory    | 更新商品库存信息 |
| CommodityInfo.updateComodity | 更新商品信息   |
|                              |          |
|                              |          |



表二stock的接口规范

提供的接口 供接口

| 服务名             | 服务   |                                          |
| --------------- | ---- | ---------------------------------------- |
| Stock.addStock  | 语法   | public ResultMessage addStock(ChangeInfoVO vo) |
|                 | 前置条件 | 想要添加进出库记录                                |
|                 | 后置条件 | 返回是否成功添加                                 |
| Stock.viewStock | 语法   | public ArrayList< StockVO> viewStock(Date start,Date end) |
|                 | 前置条件 | 想要查看库存                                   |
|                 | 后置条件 |                                          |
|                 |      |                                          |

需要的接口 需接口

| 服务名                          | 服务      |
| ---------------------------- | ------- |
| stockdataservice.addStock    | 添加出入库信息 |
| stockdataservice.searchStock | 搜索库存信息  |
|                              |         |
|                              |         |
|                              |         |

表三 inventory

提供的服务 供接口

| 服务名                       | 服务   |                                          |
| ------------------------- | ---- | ---------------------------------------- |
| inventory.updateInventory | 语法   | public ResultMessage updateInventory(ChangeInfoVO vo) |
|                           | 前置条件 |                                          |
|                           | 后置条件 |                                          |
| inventory.checkInventory  | 语法   | public ArrayList< InventoryVO> checkInventory() |
|                           | 前置条件 |                                          |
|                           | 后置条件 |                                          |

需要的服务 需接口

| 服务名                              | 服务       |
| -------------------------------- | -------- |
| stockdataservice.updateInventory | 更新库存信息   |
| stockdataservice.searchInventory | 搜索商品库存信息 |
|                                  |          |
|                                  |          |
|                                  |          |



(4) 业务逻辑层内部动态模型

## CommodityBL

(1)模块描述

commoditybl模块承担的需求参见需求规格说明文档功能需求以及相关非功能需求

stockbl模块的职责及接口参见软件系统结构描述文档

(2) 整体结构

根据体系结构的设计，我们将系统分成展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，比如展示层和逻辑层之间，我们添加commodityblservice接口。业务逻辑层和数据层之间添加commoditydatablservice接口。为了隔离业务逻辑职责和逻辑控制职责，我们增加了commodityController，这样commodityController会将对商品信息的逻辑处理委托给commodity和classification对象，commodityPO是作为商品信息的持久化对象被添加到设计模型中，classificationPO是作为商品分类的信息的持久化对象被添加到设计模型中的。ClassificationVO、commodityVO和FilterFlagsVO是作为携带商品信息的有价值对象被添加到设计模型中去的。

commodity模块的设计如图所示

| 模块                            | 职责                              |
| ----------------------------- | ------------------------------- |
| CommodityController           | 管理commoditybl各个类的任务，负责和其他bl模块交互 |
| Commodity                     | 完成对商品信息的增删改查等任务                 |
| Classification                | 完成对商品分类信息的增删改查等任务               |
| BuyPriceAscendingComparator   | 进价升序排序器                         |
| BuyPriceDescendingComparator  | 进价降序排序器                         |
| StockAscendingComparator      | 库存数量升序排序器                       |
| StockDescendingComparator     | 库存数量降序排序器                       |
| SellPriceAscendingComparator  | 售价升序排序器                         |
| SellPriceDescendingComparator | 售价降序排序器                         |
| ToolKit                       | 工具类                             |

(3) 模块内部类的接口规范

表1 CommodityComtroller

**提供的服务 （供接口）**

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| CommodityController.searchCommodity      | 语法   | public ArrayList< CommodityVO > searchCommodity(FilterFlagsVO flags) |
|                                          | 前置条件 | 用户选择合法的筛选条件                              |
|                                          | 后置条件 | 返回符合筛选条件的商品列表，如果没有符合条件的酒店，则返回空列表         |
| CommodityController.getCommodity         | 语法   | public CommodityVO getCommodity(String id) |
|                                          | 前置条件 | 用户输入正确的商品编号                              |
|                                          | 后置条件 | 返回用户指定的商品信息                              |
| CommodityController.getClassification    | 语法   | public ClassificationVO getClassification(String id) |
|                                          | 前置条件 | 用户输入正确的商品分类编号                            |
|                                          | 后置条件 | 返回用户指定的商品分类信息                            |
| CommodityController.addCommodity         | 语法   | public ResultMessage addCommodity(CommodityVO commodity_vo) |
|                                          | 前置条件 | 库存管理人员添加商品信息                             |
|                                          | 后置条件 | 返回添加成功与否                                 |
| CommodityController.addClassification    | 语法   | public ResultMessage addClassification(ClassificationVO classification_vo) |
|                                          | 前置条件 | 库存管理人员添加商品分类信息                           |
|                                          | 后置条件 | 返回添加成功与否                                 |
| CommodityController.updateCommodity      | 语法   | public ResultMessage updateCommodity(CommodityVO commodity_vo ) |
|                                          | 前置条件 | 更新商品信息                                   |
|                                          | 后置条件 | 返回更新成功与否                                 |
| CommodityController.updateClassification | 语法   | public ResultMessage updateClassification(ClassificationVO classification_vo) |
|                                          | 前置条件 | 用户要更新商品分类                                |
|                                          | 后置条件 | 返回更新成功与否                                 |
| CommodityController.deleteCommodity      | 语法   | public ResultMessage deleteCommodity(String commodity_id) |
|                                          | 前置条件 | 库存管理人员输入商品编号合法                           |
|                                          | 后置条件 | 返回删除成功与否                                 |
| CommodityController.deleteClassification | 语法   | public ResultMessage deleteClassification(String id) |
|                                          | 前置条件 | 库存管理人员输入商品分类编号合法                         |
|                                          | 后置条件 | 返回删除成功与否                                 |
| CommodityController.BuyPriceAscendingSort | 语法   | public Iterator< CommodityVO > buyPriceAscendingSort(ArrayList< CommodityVO> commodityVOs) |
|                                          | 前置条件 | 搜索得到结果                                   |
|                                          | 后置条件 | 无                                        |
| CommodityController.BuyPriceDescendingSort | 语法   | public Iterator < CommodityVO > buyPriceDesendingSort(ArrayList< CommodityVO > commodityVOs) |
|                                          | 前置条件 | 搜索得到结果                                   |
|                                          | 后置条件 | 无                                        |
| CommodityController.StockAscendingSort   | 语法   | public Iterator< CommodityVO> stockAscendingSort(ArrayList< CommodityVO commodityVOs) |
|                                          | 前置条件 | 搜索得到结果                                   |
|                                          | 后置条件 | 无                                        |
| CommodityController.StockDescendingSort  | 语法   | public Iterator< CommodityVO> stockDescending(ArrayList< CommodityVO> commodityVOs) |
|                                          | 前置条件 | 搜索得到结果                                   |
|                                          | 后置条件 | 无                                        |
| CommodityController.SellAscendingSort    | 语法   | public Iterator< CommodityVO> sellAsendingSort(ArrayList< CommodityVO> commodityVOs) |
|                                          | 前置条件 | 搜索得到结果                                   |
|                                          | 后置条件 | 无                                        |
| CommodityController.SellDescendingSort   | 语法   | public Iterator< CommodityVO> sellDescendingSort(ArrayList< CommodityVO> commodityVOs) |
|                                          | 前置条件 | 搜索得到结果                                   |
|                                          | 后置条件 | 无                                        |
| CommodityController.getAllClassifications | 语法   | public ArrayList< ClassificationVO> getAllClassifications |
|                                          | 前置条件 | 搜索得到结果                                   |
|                                          | 后置条件 | 返回所有的商品分类信息                              |
| CommodityController.searchClassification | 语法   | public ArrayList< ClassificationVO> searchClassification(FilterFlags flags) |
|                                          | 前置条件 | 搜索得到结果                                   |
|                                          | 后置条件 | 返回符合条件的商品分类                              |

**需要的服务（需接口）**

| 服务名                                  | 服务           |
| ------------------------------------ | ------------ |
| Commodity.SearchCommodity            | 搜索符合条件的商品列表  |
| Commodity.getCommodity               | 通过ID得到商品信息   |
| Commodity.addCommodity               | 增加商品         |
| Commodity.updateCommodity            | 更新商品信息       |
| Commodity.deleteCommodity            | 删除商品         |
| Commodity.BuyPriceAscendingSort      | 根据商品进价升序排列商品 |
| Commodity.BuyPriceDescendingSort     | 根据商品进价降序排列商品 |
| Commodity.SellPriceAscendingSort     | 根据商品售价升序排列商品 |
| Commodity.SellPriceDescendingSort    | 根据商品售价降序排列商品 |
| Commodity.StockAscendingSort         | 根据商品库存升序排列商品 |
| Commodity.StockDescendingSort        | 根据商品库存降序排列商品 |
| Classification.addClassification     | 添加商品分类       |
| Classification.updateClassification  | 更新商品分类       |
| Classification.deleteClassification  | 删除商品分类       |
| Classification.getClassification     | 得到商品分类信息     |
| Classification.getAllClassifications | 得到所有的商品分类    |
| Classifiction.SearchClassificaions   | 搜索商品分类       |
|                                      |              |
|                                      |              |

表2classification的接口规范

**提供的服务（供接口）**

| 服务名                                 | 服务   |                                          |
| ----------------------------------- | ---- | ---------------------------------------- |
| Classification.addClassification    | 语法   | public ResultMessage addClassification(ClassificationVO classification_vo) |
|                                     | 前置条件 | 添加商品分类                                   |
|                                     | 后置条件 | 返回添加成功与否                                 |
| Classification.updateClassification | 语法   | public ResultMessage updateClassification(ClassificationVO classification_vo) |
|                                     | 前置条件 | 输入正确的商品分类信息                              |
|                                     | 后置条件 | 返回更新成功与否                                 |
| Classification.deleteClassification | 语法   | public ResultMessage deleteClassification(String id) |
|                                     | 前置条件 | 输入正确的商品分类信息                              |
|                                     | 后置条件 | 返回删除成功与否                                 |
| Classification.getClassification    | 语法   | public ClassificationVO getClassification(ClassificationVO classification_vo) |
|                                     | 前置条件 | 输入正确的商品分类编号信息                            |
|                                     | 后置条件 | 返回得到的商品信息                                |
| Classification.searchClassification | 语法   | public ArrayList< ClassificationVO> searchClassification(FilterFlags flagers) |
|                                     | 前置条件 | 输入正确的搜索标志                                |
|                                     | 后置条件 | 返回符合条件的商品分类信息                            |
| Classification.getAllClassification | 语法   | public ArrayList< ClassificationVO> getAllClassifications |
|                                     | 前置条件 | 无                                        |
|                                     | 后置条件 | 返回所有的商品分类信息                              |
|                                     |      |                                          |

**需要的服务（需接口）**

| 服务名                                      | 服务         |
| ---------------------------------------- | ---------- |
| CommodityDataService.getClassification   | 得到商品分类信息   |
| CommodityDataService.addClassification   | 添加商品分类信息   |
| CommodityDataService.updateClassification | 更新商品分类信息   |
| CommodityDataService.deleteClassification | 删除商品分类信息   |
| CommodityDataService.exactlySearchClassification | 精确搜索商品分类   |
| CommodityDataService.prefixSearchClassification | 前缀匹配搜索商品分类 |
| CommodityDataService.fullSearchClassification | 完全匹配搜索商品分类 |
| CommodityDataService.getAllClassifications | 得到所有的商品分类  |
|                                          |            |

表3 commodity的接口规范

| 服务名                               | 服务   | 服务                                       |
| --------------------------------- | ---- | ---------------------------------------- |
| Commodity.addCommodity            | 语法   | public ResultMessage addCommodity(CommodityVO commodity_vo) |
|                                   | 前置条件 | 输入了正确的商品信息                               |
|                                   | 后置条件 | 返回添加成功与否                                 |
| Commodity.deleteCommodity         | 语法   | public ResultMessage deleteCommodity(String id) |
|                                   | 前置条件 | 输入正确的商品编号                                |
|                                   | 后置条件 | 返回删除成功与否                                 |
| Commodity.updateCommodity         | 语法   | public ResultMessage updateCommodity(CommodityVO commodity_vo) |
|                                   | 前置条件 | 输入了正确的商品信息                               |
|                                   | 后置条件 | 返回更新成功与否                                 |
| Commodity.getCommodity            | 语法   | public CommodityVO getCommodity(String id) |
|                                   | 前置条件 | 输入正确的商品编号                                |
|                                   | 后置条件 | 返回商品信息                                   |
| Commodity.searchCommodity         | 语法   | public ArrayList< CommodityVO> searchCommodity(FilterFlag flags) |
|                                   | 前置条件 | 输入正确的搜索标志                                |
|                                   | 后置条件 | 返回满足条件的商品信息                              |
| Commodity.BuyPriceAscendingSort   | 语法   | public ArrayList< CommodityVO> BuyPriceAscendingSort(ArrayList< CommodityVO> vos) |
|                                   | 前置条件 | 搜索商品得到结果                                 |
|                                   | 后置条件 | 无                                        |
| Commodity.BuyPriceDescendingSort  | 语法   | public ArrayList< CommodityVO> BuyPriceDescendingSort(ArrayList< CommodityVO> vos) |
|                                   | 前置条件 | 搜索商品得到结果                                 |
|                                   | 后置条件 | 无                                        |
| Commodity.SellPriceAscendingSort  | 语法   | public ArrayList< CommodityVO> sellPriceAsendingSort(ArrayList< CommodityVO> vos) |
|                                   | 前置条件 | 搜索商品得到结果                                 |
|                                   | 后置条件 | 无                                        |
| Commodity.SellPriceDescendingSort | 语法   | public ArrayList< CommodityVO> sellPriceDesendingSort(ArrayList< CommodityVO> vos) |
|                                   | 前置条件 | 搜索商品得到结果                                 |
|                                   | 后置条件 | 无                                        |
| Commodity.StockAscendingSort      | 语法   | public ArrayList< CommodityVO> StockAscendingSort(ArrayList< CommodityVO> vos) |
|                                   | 前置条件 | 搜索商品得到结果                                 |
|                                   | 后置条件 | 无                                        |
| Commodity.StockDescendingSort     | 语法   | public ArrayList< CommodityVO> StockDescendingSort(ArrayList< CommodityVO> vos) |
|                                   | 前置条件 | 搜索商品得到结果                                 |
|                                   | 后置条件 | 无                                        |



**需要的服务（需接口）**

| 服务名                                      | 服务         |
| ---------------------------------------- | ---------- |
| CommodityDataService.exactlySearchCommodity | 精确搜索商品     |
| CommodityDataService.prefixSearchCommodity | 前缀匹配搜索商品   |
| CommodityDataService.fullSearchCommodity | 完全匹配搜索商品   |
| CommodityDataService.fuzzySearchCommodity | 模糊搜索匹配商品   |
| CommodityDataService.rangeSearchCommodity | 范围搜索商品     |
| CommodityDataService.mulitySearchCommodity | 多条件搜索商品    |
| CommodityDataService.getCommodity        | 通过商品id得到商品 |
| CommodityDataService.addCommodity        | 添加商品       |
| CommodityDataService.updateCommodity     | 更新商品信息     |
| CommodityDataService.delteCommodity      | 删除商品       |

表4 BuyPriceAscendingComparator的接口规范

**提供的服务（供接口）**

| 服务名                                 | 服务   |                                          |
| ----------------------------------- | ---- | ---------------------------------------- |
| BuyPriceAscendingComparator.compare | 语法   | public int compare(CommodityVO o1,CommodityVO o2); |
|                                     | 前置条件 | 通过搜索得到商品列表                               |
|                                     | 后置条件 | 无                                        |

**需要的服务（需接口）**

| 服务名  | 服务   |
| ---- | ---- |
| 无    | 无    |

表5 BuyPriceDescendingComparator的接口规范

**提供的服务（供接口）**

| 服务名                                  | 服务   |                                          |
| ------------------------------------ | ---- | ---------------------------------------- |
| BuyPriceDescendingComparator.compare | 语法   | public int compare(CommodityVO o1,CommodityVO o2); |
|                                      | 前置条件 | 通过搜索得到商品列表                               |
|                                      | 后置条件 | 无                                        |

**需要的服务（需接口）**

| 服务名  | 服务   |
| ---- | ---- |
| 无    | 无    |

表6 SellPriceAscendingComparator的接口规范

**提供的服务（供接口）**

| 服务名                                  | 服务   |                                          |
| ------------------------------------ | ---- | ---------------------------------------- |
| SellPriceAscendingComparator.compare | 语法   | public int compare(CommodityVO o1,CommodityVO o2); |
|                                      | 前置条件 | 通过搜索得到商品列表                               |
|                                      | 后置条件 | 无                                        |

**需要的服务（需接口)**

| 服务名  | 服务   |
| ---- | ---- |
| 无    | 无    |

表7 SellPriceDescendingComparator的接口规范

**提供的服务（供接口）**

| 服务名                                 | 服务   |                                          |
| ----------------------------------- | ---- | ---------------------------------------- |
| BuyPriceAscendingComparator.compare | 语法   | public int compare(CommodityVO o1,CommodityVO o2); |
|                                     | 前置条件 | 通过搜索得到商品列表                               |
|                                     | 后置条件 | 无                                        |



**需要的服务（需接口）**

| 服务名  | 服务   |
| ---- | ---- |
| 无    | 无    |

表8 StockAscendingComparator的接口规范

**提供的服务（供接口）**

| 服务名                              | 服务   |                                          |
| -------------------------------- | ---- | ---------------------------------------- |
| StockAscendingComparator.compare | 语法   | public int compare(CommodityVO o1,CommodityVO o2); |
|                                  | 前置条件 | 通过搜索得到商品列表                               |
|                                  | 后置条件 | 无                                        |



**需要的服务（需接口）**

| 服务名  | 服务   |
| ---- | ---- |
| 无    | 无    |

表9 StockDescendingComparator的接口规范

**提供的服务（供接口）**

| 服务名                               | 服务   |                                          |
| --------------------------------- | ---- | ---------------------------------------- |
| StockDescendingComparator.compare | 语法   | public int compare(CommodityVO o1,CommodityVO o2); |
|                                   | 前置条件 | 通过搜索得到商品列表                               |
|                                   | 后置条件 | 无                                        |



**需要的服务（需接口）**

| 服务名  | 服务   |
| ---- | ---- |
| 无    | 无    |



表10 ToolKit的接口规范

**提供的服务（供接口）**

| 服务名                | 服务   |                                          |
| ------------------ | ---- | ---------------------------------------- |
| ToolKit.generateID | 语法   | public static String generateID(String id, int number) |
|                    | 前置条件 | 无                                        |
|                    | 后置条件 | 无                                        |



**需要的服务（需接口）**

| 服务名  | 服务   |
| ---- | ---- |
| 无    | 无    |

(4) 业务逻辑层内部动态模型

#### 4.2.5 AccountBL模块

##### （1）模块描述

accountbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求。

accountbl模块的职责及接口参见软件体系结构设计文档

 ##### （2）整体结构

AccountBL模块主要负责账户管理功能需求的逻辑实现，其中Account为主模块，负责主要逻辑的生成以及对辅助类和功能类的调度，但为了降低耦合，Account不与DataService模块交互，而是AccountInfoFactory与DataService交互，来生成具体的VO并且向数据层传输数据，此外，还拥有AccountSorter类来负责AccountBL类的数据的排序

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/Account%E6%A8%A1%E5%9D%97.png)


AccountBL模块的类的功能如下表所示

| 模块                   | 职责                         |
| -------------------- | -------------------------- |
| AccountBLServiceImpl | 账户管理接口的具体实现                |
| Account              | AccountBL主要逻辑类，实现增删改查等主要功能 |
| AccountComparator    | 功能类，用来排序Account            |
| AccountInfoFactory   | 信息辅助类，完成PO与VO转换并且获得数据      |

##### （3）模块内部类的接口规范

Account的接口规范

| 提供的服务（供接口）                          |      |                                          |
| ----------------------------------- | ---- | ---------------------------------------- |
| AccountBLServiceImpl.addAccount     | 语法   | public ResultMessage addAccount（AccountVO account) |
|                                     | 前置条件 | account.name不能与之前的重复                     |
|                                     | 后置条件 | 无                                        |
| AccountBLServiceImpl.deleteAccount  | 语法   | public ResultMessage deleteAccount（string name) |
|                                     | 前置条件 | name必须已经存在的账户列表中                         |
|                                     | 后置条件 | 无                                        |
| AccountBLServiceImpl.modifyAccount  | 语法   | public ResultMessage modifyAccount（string oldname,string newname) |
|                                     | 前置条件 | oldname已经存在于账号列表中而newname不存在于账户列表中       |
|                                     | 后置条件 | 无                                        |
| AccountBLServiceImpl.checkAccount   | 语法   | public AccountVO checkAccount(String name) |
|                                     | 前置条件 | name已经存在于账户列表中                           |
|                                     | 后置条件 | 返回已经写入账户信息（具体参见Account类说明表）的Account      |
| AccountBLServiceImpl.income         | 语法   | public void income(String name, int income) |
|                                     | 前置条件 | 无                                        |
|                                     | 后置条件 | 无                                        |
| AccountBLServiceImpl.pay            | 语法   | public void pay(String name,int pay)     |
|                                     | 前置条件 | 无                                        |
|                                     | 后置条件 | 无                                        |
| AccountBLServiceImpl.compareByName  | 语法   | public ArrayList<AccountVO> compareByName(ArrayList<AccountVO> account) |
|                                     | 前置条件 | 无                                        |
|                                     | 后置条件 | 返回按姓名字典序排序的账户列表                          |
| AccountBLServiceImpl.compareByMoney | 语法   | public ArrayList<AccountVO> compareByMoney(ArrayList<AccountVO> account) |
|                                     | 前置条件 | 无                                        |
|                                     | 后置条件 | 返回按金额从小到大的排序的账户列表                        |

需要的服务(需接口)

| 服务名                                   | 服务                |
| ------------------------------------- | ----------------- |
| Account.pay                           | 账户付款，调整金额         |
| Account.income                        | 账户收款，调整金额         |
| Account.addAccount                    | 增加账户至数据库          |
| Account.deleteAccount                 | 删除数据库中的账户         |
| Account.modifyAccount                 | 修改数据库中的账户         |
| Account.checkAccount                  | 搜索数据库中的账户         |
| AccountComparator.NameAlphabetOrder   | 返回按姓名字典序排序的账户列表   |
| AccountComparator.MoneyFromBigToSmall | 返回按金额从小到大的排序的账户列表 |

提供的服务(供接口)

Account的接口规范

| 提供的服务（供接口）            |      |                                          |
| --------------------- | ---- | ---------------------------------------- |
| Account.addAccount    | 语法   | public ResultMessage addAccount（AccountVO account) |
|                       | 前置条件 | account.name不能与之前的重复                     |
|                       | 后置条件 | 无                                        |
| Account.deleteAccount | 语法   | public ResultMessage deleteAccount（string name) |
|                       | 前置条件 | name必须已经存在的账户列表中                         |
|                       | 后置条件 | 无                                        |
| Account.modifyAccount | 语法   | public ResultMessage modifyAccount（string oldname,string newname) |
|                       | 前置条件 | oldname已经存在于账号列表中而newname不存在于账户列表中       |
|                       | 后置条件 | 无                                        |
| Account.checkAccount  | 语法   | public AccountVO checkAccount(String name) |
|                       | 前置条件 | name已经存在于账户列表中                           |
|                       | 后置条件 | 返回已经写入账户信息（具体参见Account类说明表）的Account      |
| Account.income        | 语法   | public void income(String name, int income) |
|                       | 前置条件 | 无                                        |
|                       | 后置条件 | 无                                        |
| Account.pay           | 语法   | public void pay(String name,int pay)     |
|                       | 前置条件 | 无                                        |
|                       | 后置条件 | 无                                        |

需要的服务(需接口)

| 服务名                              | 服务        |
| -------------------------------- | --------- |
| AccountInfoFactory.pay           | 账户付款，调整金额 |
| AccountInfoFactory.income        | 账户收款，调整金额 |
| AccountInfoFactory.addAccount    | 增加账户至数据库  |
| AccountInfoFactory.deleteAccount | 删除数据库中的账户 |
| AccountInfoFactory.modifyAccount | 修改数据库中的账户 |
| AccountInfoFactory.checkAccount  | 搜索数据库中的账户 |

提供的服务(供接口)

| 服务名                                   |      | 服务                                       |
| ------------------------------------- | ---- | ---------------------------------------- |
| AccountComparator.NameAlphabetOrder   | 语法   | public ArrayList<AccountVO>  NameAlphabetOrder(ArrayList<AccountVO> list) |
|                                       | 前置条件 | 无                                        |
|                                       | 后置条件 | 返回排列好的列表，若参数列表为空，则返回空                    |
| AccountComparator.MoneyFromBigToSmall | 语法   | public ArrayList<AccountVO>  MoneyFromBigToSmall(ArrayList<AccountVO> account) |
|                                       | 前置条件 | 无                                        |
|                                       | 后置条件 | 返回排列好的列表，若参数列表为空，则返回空                    |
| AccountComparator.MoneyFromSmallToBig | 语法   | public ArrayList<AccountVO>  MoneyFromSmallToBig(ArrayList<AccountVO> account) |
|                                       | 前置条件 | 无                                        |
|                                       | 后置条件 | 返回排列好的列表，若参数列表为空，则返回空                    |

需要的服务(需接口)

| 服务名  | 服务   |
| ---- | ---- |
| 无    | 无    |

提供的服务(供接口)

| 提供的服务（供接口）                       |      |                                          |
| -------------------------------- | ---- | ---------------------------------------- |
| AccountInfoFactory.addAccount    | 语法   | public ResultMessage addAccount（string name,int money) |
|                                  | 前置条件 | name不能与之前的重复                             |
|                                  | 后置条件 | 无                                        |
| AccountInfoFactory.deleteAccount | 语法   | public ResultMessage deleteAccount（string name) |
|                                  | 前置条件 | name必须已经存在的账户列表中                         |
|                                  | 后置条件 | 无                                        |
| AccountInfoFactory.modifyAccount | 语法   | public ResultMessage modifyAccount（string oldname,string newname) |
|                                  | 前置条件 | oldname已经存在于账号列表中而newname不存在于账户列表中       |
|                                  | 后置条件 | 无                                        |
| AccountInfoFactory.checkAccount  | 语法   | public Account checkAccount(String name) |
|                                  | 前置条件 | name已经存在于账户列表中                           |
|                                  | 后置条件 | 返回已经写入账户信息（具体参见Account类说明表）的Account      |
| AccountInfoFactory.income        | 语法   | public void income(String name, int income) |
|                                  | 前置条件 | 无                                        |
|                                  | 后置条件 | 无                                        |
| AccountInfoFactory.pay           | 语法   | public void pay(String name,int pay)     |
|                                  | 前置条件 | 无                                        |
|                                  | 后置条件 | 无                                        |

需要的服务(需接口)

| 服务名                              | 服务        |
| -------------------------------- | --------- |
| AccountDataService.income        | 调整账户金额，收款 |
| AccountDataService.pay           | 调整账户金额，付款 |
| AccountDataService.addAccount    | 增加账户至数据库  |
| AccountDataService.deleteAccount | 删除数据库中的账户 |
| AccountDataService.modifyAccount | 修改数据库中的账户 |
| AccountDataService.checkAccount  | 搜索数据库中的账户 |

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/%E5%88%A0%E9%99%A4%E8%B4%A6%E6%88%B7%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/%E6%B7%BB%E5%8A%A0%E8%B4%A6%E6%88%B7%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/%E8%B4%A6%E6%88%B7%E6%8E%92%E5%BA%8F%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)

#### 4.2.6 PromotionBL模块

##### （1）模块概述

Promotionbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求

Promotionbl模块的职责及接口参见软件系统结构描述文档

##### （2）整体结构

根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，我们会添加接口。比如展示层和业务逻辑层之间我们添加promotionblservice接口。业务逻辑层和数据层之间添加promotiondataservice接口和。为了隔离业务逻辑职责和逻辑控制职责，我们增加了promotion对象，这样promotionblserviceimpl会将促销策略模块的操作委托给promotion对象。PromotionPO是作为持久化对象被添加到设计模型中去的。
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/Promotion模块类图.png)
PromotionBL模块各个类的职责如表所示

| 模块                     | 职责                        |
| ---------------------- | ------------------------- |
| PromotionBLServiceImpl | 促销策略模块接口的具体实现             |
| Promotion              | 促销策略模块的主要功能类，负责实现所有的功能    |
| PromotionBLInfo        | 负责PromotionBL模块与其他BL模块的交互 |

##### （3）模块内部类的接口规范

PromotionBLServiceImpl的接口规范

| 提供的服务（供接口）                               |                  |                                          |
| ---------------------------------------- | ---------------- | ---------------------------------------- |
| PromotionBLServiceImpl.add               | 语法               | public ResultMessage add(Promotion VO promotionVO); |
| 前置条件                                     | 无                |                                          |
| 后置条件                                     | 促销策略数据中增加一条促销策略  |                                          |
| PromotionBLServiceImpl.delete            | 语法               | public ResultMessage delete(String id);  |
| 前置条件                                     | 无                |                                          |
| 后置条件                                     | 删除一条促销策略         |                                          |
| PromotionBLServiceImpl.update            | 语法               | public ResultMessage update(String id,PromotionVO promotionVO); |
| 前置条件                                     | 无                |                                          |
| 后置条件                                     | 更新一条促销策略         |                                          |
| PromotionBLServiceImpl.search            | 语法               | public ArrayList<PromotionPO> search(Time date); |
| 前置条件                                     | 无                |                                          |
| 后置条件                                     | 返回所有有效的促销策略      |                                          |
| PromotionBLServiceImpl.showPromotionList | 语法               | public PromotionListVO showPromotionList(ArrayList<PromotionPO> promotionList); |
|                                          | 前置条件             | 无                                        |
|                                          | 后置条件             | 返回促销策略列表VO                               |
| PromotionBLServiceImpl.showPromotionDetail | 语法               | public PromotionVO showPromotionDetail(String id); |
|                                          | 前置条件             | 无                                        |
|                                          | 后置条件             | 返回促销策略VO                                 |
| 需要的服务（需接口）                               |                  |                                          |
| 服务名                                      | 服务               |                                          |
| Promotion.add                            | 给促销策略数据中增加一个促销策略 |                                          |
| Promotion.delete                         | 从促销策略数据中删除一个促销策略 |                                          |
| Promotion.update                         | 更新一个促销策略         |                                          |
| Promotion.search                         | 搜索所有有效的促销策略      |                                          |
| Promotion.showPromotionList              | 返回一个促销策略列表VO     |                                          |
| Promotion.showPromotionDetail            | 返回一个促销策略VO       |                                          |

Promotion的接口规范

| 提供的服务（供接口）                    |                  |                                          |
| ----------------------------- | ---------------- | ---------------------------------------- |
| Promotion.add                 | 语法               | public ResultMessage add(Promotion VO promotionVO); |
| 前置条件                          | 无                |                                          |
| 后置条件                          | 促销策略数据中增加一条促销策略  |                                          |
| Promotion.delete              | 语法               | public ResultMessage delete(String id);  |
| 前置条件                          | 无                |                                          |
| 后置条件                          | 删除一条促销策略         |                                          |
| Promotion.update              | 语法               | public ResultMessage update(String id,PromotionVO promotionVO); |
| 前置条件                          | 无                |                                          |
| 后置条件                          | 更新一条促销策略         |                                          |
| Promotion.search              | 语法               | public ArrayList<PromotionPO> search(Time date); |
| 前置条件                          | 无                |                                          |
| 后置条件                          | 返回所有有效的促销策略      |                                          |
| Promotion.showPromotionList   | 语法               | public PromotionListVO showPromotionList(ArrayList<PromotionPO> promotionList); |
|                               | 前置条件             | 无                                        |
|                               | 后置条件             | 返回促销策略列表VO                               |
| Promotion.showPromotionDetail | 语法               | public PromotionVO showPromotionDetail(String id); |
|                               | 前置条件             | 无                                        |
|                               | 后置条件             | 返回促销策略VO                                 |
| 需要的服务（需接口）                    |                  |                                          |
| 服务名                           | 服务               |                                          |
| PromotionDataService.add      | 给促销策略数据中增加一个促销策略 |                                          |
| PromotionDataService.delete   | 从促销策略数据中删除一个促销策略 |                                          |
| PromotionDataService.update   | 更新一个促销策略         |                                          |
| PromotionDataService.search   | 搜索所有有效的促销策略      |                                          |

PromotionBLInfo的接口规范

| 提供的服务（供接口）             |             |                                          |
| ---------------------- | ----------- | ---------------------------------------- |
| PromotionBLInfo.search | 语法          | public ArrayList<PromotionPO> search(Time date); |
| 前置条件                   | 无           |                                          |
| 后置条件                   | 返回符合条件的促销策略 |                                          |
| 需要的服务（需接口）             |             |                                          |
| 服务名                    | 服务          |                                          |
| Promotion.search       | 返回符合条件的促销策略 |                                          |

（4）业务逻辑层内部动态模型
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/Promotion顺序图.png)

#### 4.2.7 TableBL模块

##### （1）模块描述

tablebl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求。

tablebl模块的职责及接口参见软件体系结构设计文档

 ##### （2）整体结构

TableBL模块主要负责制定报表功能需求的逻辑实现，其中Table为主模块，负责主要逻辑的生成以及对辅助类和功能类的调度，但为了降低耦合，Table不与DataService模块交互，而是TableInfoFactory与BillDataService交互，来生成ArrayList<Bill>以及具体的VO，此外，还拥有TableSorter类来负责TableBL类的数据的排序<br>
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/Table%E6%A8%A1%E5%9D%97.png)

TableBL模块各个类的职责如表所示

| 模块                      | 职责                           |
| ----------------------- | ---------------------------- |
| TableBLServiceImpl      | 查看报表接口的具体实现                  |
| Table                   | TableBL模块的主要功能类，负责实现大部分的功能   |
| TableInfoFactory        | 信息的接口，负责与DataService交互的信息功能类 |
| BusinessTableComparator | 负责与经营情况报表有关的单据的排序功能类         |
| SaleTableComparator     | 负责与销售明细报表有关的单据的排序功能类         |
| ProcessTableComparator  | 负责与经营历程报表有关的单据的排序功能类         |
| ExportHelper            | 导出的实现的辅助类                    |

##### （3）模块内部类的接口

提供的服务(供接口)

| 服务名                                    | 服务   | 服务                                       |
| -------------------------------------- | ---- | ---------------------------------------- |
| TableBLServiceImpl.checkSaleTable      | 语法   | public SaleTableVO checkSaleTable(SaleTableFilterFlags flags) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 返回对应的SaleTableVO                         |
| TableBLServiceImpl.checkProcessTable   | 语法   | public ProcessTableVO checkProcessTable(ProcessTableFilterFlags flags) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 返回对应的ProcessTableVO                      |
| TableBLServiceImpl.checkBusinessTable  | 语法   | public BusinessTableVO checkBusinessTable(BusinessTableFilterFlags flags) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 返回对应的BusinessTableVO                     |
| TableBLServiceImpl.exportSaleTable     | 语法   | public void exportSaleTable(SaleTableVO saletable) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 无                                        |
| TableBLServiceImpl.exportProcessTable  | 语法   | public void exportProcessTable(ProcessTableVO  processtable) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 无                                        |
| TableBLServiceImpl.exportBusinessTable | 语法   | public void exportBusinessTable(BusinessTableVO businesstable) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 无                                        |
| TableBLServiceImpl.compareBTByTime     | 语法   | public BusinessTableVO compareBTByTime(BusinessTableVO businesstable) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 返回时间从早到晚排序的报表                            |
| TableBLServiceImpl.compareSTByMoney    | 语法   | public SaleTableVO compareSTByMoney(SaleTableVO saletable) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 按金额从小到大排序                                |
| TableBLServiceImpl.comparePTByMoney    | 语法   | public ProcessTableVO comparePTByMoney(ProcessTableVO processtable) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 按金额从少到大排序                                |
| TableBLServiceImpl.compareSTByTime     | 语法   | public SaleTable compareSTByTime(SaleTableVO saletable) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 按时间从早到晚排序                                |
| TableBLServiceImpl.comparePTByTime     | 语法   | public ProcessTableVO comparePTByTime(ProcessTableVO processtable) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 按时间从早到晚排序                                |

需要的服务(需接口)

| 服务名                                   | 服务               |
| ------------------------------------- | ---------------- |
| Table.exportBusinesTable              | 导出Business报表     |
| Table.exportSaleTable                 | 导出sale报表         |
| Table.exportProcessTable              | 导出Process报表      |
| Table.checkBusinessBill               | 查看Busine报表       |
| TableInfo.ProcessBill                 | 查看Proce报表        |
| TableInfo.checkSaleBill               | 查看Sale报表         |
| BusinessTablecomparator.compareByTime | 把Business报表按时间排序 |
| SaleTablecomparator.compareByTime     | 把Sale报表按时间排序     |
| ProcessTablecomparator.compareByTime  | 把Process报表按时间排序  |
| SaleTablecomparator.compareByMoney    | 把Sale报表按金额排序     |
| ProcessTablecomparator.compareByMoney | 把Process报表按金额排序  |



提供的服务(供接口)

| 服务名                       | 服务   | 服务                                       |
| ------------------------- | ---- | ---------------------------------------- |
| Table.checkSaleTable      | 语法   | public SaleTableVO checkSaleTable(SaleTableFilterFlags flags) |
|                           | 前置条件 | 无                                        |
|                           | 后置条件 | 返回对应的SaleTableVO                         |
| Table.checkProcessTable   | 语法   | public ProcessTableVO checkProcessTable(ProcessTableFilterFlags flags) |
|                           | 前置条件 | 无                                        |
|                           | 后置条件 | 返回对应的ProcessTableVO                      |
| Table.checkBusinessTable  | 语法   | public BusinessTableVO checkBusinessTable(BusinessTableFilterFlags flags) |
|                           | 前置条件 | 无                                        |
|                           | 后置条件 | 返回对应的BusinessTableVO                     |
| Table.exportSaleTable     | 语法   | public void exportSaleTable(SaleTableVO saletable) |
|                           | 前置条件 | 无                                        |
|                           | 后置条件 | 无                                        |
| Table.exportProcessTable  | 语法   | public void exportProcessTable(ProcessTableVO  processtable) |
|                           | 前置条件 | 无                                        |
|                           | 后置条件 | 无                                        |
| Table.exportBusinessTable | 语法   | public void exportBusinessTable(BusinessTableVO businesstable) |
|                           | 前置条件 | 无                                        |
|                           | 后置条件 | 无                                        |

需要的服务(需接口)

| 服务名                              | 服务   |
| -------------------------------- | ---- |
| ExportHelper.exportBusinesTable  |      |
| ExportHelper.exportSaleTable     |      |
| ExportHelper.exportProcessTable  |      |
| TableInfoFactory.getBusinessBill |      |
| TableInfoFactory.getProcessBill  |      |
| TableInfoFactory.getSaleBill     |      |

提供的服务(供接口)

| 服务名                               | 服务   | 服务                                       |
| --------------------------------- | ---- | ---------------------------------------- |
| TableInfoFactory.getSaleTable     | 语法   | public SaleTableVO checkSaleTable(SaleTableFilterFlags flags) |
|                                   | 前置条件 | 无                                        |
|                                   | 后置条件 | 返回对应的SaleTableVO                         |
| TableInfoFactory.getProcessTable  | 语法   | public ProcessTableVO checkProcessTable(ProcessTableFilterFlags flags) |
|                                   | 前置条件 | 无                                        |
|                                   | 后置条件 | 返回对应的ProcessTableVO                      |
| TableInfoFactory.getBusinessTable | 语法   | public BusinessTableVO checkBusinessTable(BusinessTableFilterFlags flags) |
|                                   | 前置条件 | 无                                        |
|                                   | 后置条件 | 返回对应的BusinessTableVO                     |

需要的服务(需接口)

| 服务   | 服务名  |
| ---- | ---- |
|      |      |
|      |      |
|      |      |
|      |      |
|      |      |
|      |      |

提供的服务(供接口)

| 服务名                              |      | 服务                                       |
| -------------------------------- | ---- | ---------------------------------------- |
| ExportHelper.exportBusinessTable | 语法   | public ResultMessage exportBusinessTable(BusinessTableVO table) |
|                                  | 前置条件 | 无                                        |
|                                  | 后置条件 | 返回导出结果                                   |
| ExportHelper.exportSaleTable     | 语法   | public ResultMessage exportSaleTable(SaleTable table) |
|                                  | 前置条件 | 无                                        |
|                                  | 后置条件 | 返回导出结果                                   |
| ExportHelper.exportProcessTable  | 语法   | public ResultMessage exportProcessTable(ProcessTable table) |
|                                  | 前置条件 | 无                                        |
|                                  | 后置条件 | 返回导出结果                                   |

需要的服务(需接口)

| 服务名  | 服务   |
| ---- | ---- |
| 无    | 无    |



提供的服务(供接口)

| 服务名                                   |      | 服务                                       |
| ------------------------------------- | ---- | ---------------------------------------- |
| BusinessTableComparator.compareByTime | 语法   | public BusinessTableVO compareByTime(BusinessTableVO businesstable) |
|                                       | 前置条件 | 无                                        |
|                                       | 后置条件 | 返回按时间先后排序的VO                             |

需要的服务(需接口)

| 服务名  | 服务   |
| ---- | ---- |
| 无    |      |

提供的服务(供接口)

| 服务名                                |      | 服务                                       |
| ---------------------------------- | ---- | ---------------------------------------- |
| SaleTableComparator.compareByTime  | 语法   | public SaleTableVO compareByTime(SaleTableVO saletable) |
|                                    | 前置条件 | 无                                        |
|                                    | 后置条件 | 返回按时间先后排序的VO                             |
| SaleTableComparator.compareByMoney | 语法   | public SaleTableVO compareByMoney(SaleTableVO saletable) |
|                                    |      | 无                                        |
|                                    |      | 返回按金额大小排序的VO                             |

需要的服务(需接口)

| 服务名  | 服务   |
| ---- | ---- |
| 无    |      |

提供的服务(供接口)

| 服务名                                   |      | 服务                                       |
| ------------------------------------- | ---- | ---------------------------------------- |
| ProcessTableComparator.compareByTime  | 语法   | public ProcessTableVO compareByTime(ProcessTableVO processtable) |
|                                       | 前置条件 | 无                                        |
|                                       | 后置条件 | 返回按时间先后排序的VO                             |
| ProcessTableComparator.compareByMoney | 语法   | public ProcessTableVO compareByMoney(ProcessTableVO processtable) |
|                                       |      | 无                                        |
|                                       |      | 返回按金额大小排序的VO                             |

需要的服务(需接口)

| 服务名  | 服务   |
| ---- | ---- |
| 无    |      |

##### （4）业务逻辑层内部动态模型

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/%E6%8A%A5%E8%A1%A8%E4%B8%AD%E5%8D%95%E6%8D%AE%E6%8E%92%E5%BA%8F%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/%E6%9F%A5%E7%9C%8B%E6%8A%A5%E8%A1%A8%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)


#### 4.2.8 CustomerBL模块

##### （1）模块描述

customerbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求。

customerbl模块的职责及接口参见软件体系结构设计文档

##### （2）整体结构

根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，我们会添加接口。比如展示层和业务逻辑层之间我们添加businesslogicservice.customerblservice.CustomerBLService接口。业务逻辑层和数据层之间添加dataservice.CustomerDataService、dataservice.CommodityDataService接口。为了隔离业务逻辑职责和逻辑控制职责，我们增加了CustomerBLServiceImpl，这样CustomerBLServiceImpl会将客户管理和制定单据的业务逻辑委托给Customer对象。CustomerPO是作为客户属性的持久化对象被添加到设计模型中去的，CommodityPO是作为商品属性的持久化对象被添加到设计模型中去的。CustomerVO、CommodityVO是作为值对象被添加到设计模型中去的。

| 模块                    | 职责                                 |
| --------------------- | ---------------------------------- |
| CustomerBLServiceImpl | 管理 customerbl 各个类的任务，负责与其他 bl 模块交互 |
| Customer              | 负责对客户的增删改查的操作                      |

##### （3）模块内部类的接口规范

表4.2.8（3）-1 CustomerBLServiceImpl类的接口规范

提供的服务（供接口）

| 服务名                                   | 服务   | 服务                                       |
| ------------------------------------- | ---- | ---------------------------------------- |
| CustomerBLServiceImpl.addCustomer     | 语法   | public boolean addCustomer(CustomerVO customer) |
|                                       | 前置条件 | 输入的信息符合规范                                |
|                                       | 后置条件 | 系统新建一个客户，并提示新建成功                         |
| CustomerBLServiceImpl.delCustomer     | 语法   | public boolean delCustomer(String ID);   |
|                                       | 前置条件 | 需要删除的用户存在于系统中                            |
|                                       | 后置条件 | 删除用户，返回true                              |
| CustomerBLServiceImpl.modifyCustomer  | 语法   | public boolean ModifyCustomer(CustomerVO modCustomer); |
|                                       | 前置条件 | 输入的信息符合规范                                |
|                                       | 后置条件 | 系统修改该客户的属性，并返回true                       |
| CustomerBLServiceImpl.getCustomerInfo | 语法   | public CustomerVO getCustomerInfo(String ID); |
|                                       | 前置条件 | 输入的客户编号符合规范                              |
|                                       | 后置条件 | 如果系统中有该客户，返回该客户的属性。否则返回null              |
| CustomerBLServiceImpl.searchCustomer  | 语法   | public ArrayList< CustomerVO > searchCustomer(String keytype, String keyword); |
|                                       | 前置条件 | 输入的关键词合法                                 |
|                                       | 后置条件 | 如果系统里有符合条件的客户，返回true，否则返回false           |
|                                       |      |                                          |
|                                       |      |                                          |

需要的服务（需接口）

| 服务名                      | 服务     |
| ------------------------ | ------ |
| Customer.addCustomer     | 增加用户   |
| Customer.delCustomer     | 删除用户   |
| Customer.modifyCustomer  | 修改用户   |
| Customer.getCustomerInfo | 获取用户属性 |
| Customer.searchCustomer  | 查找用户   |

表5.2.8（3）-2 Customer类的接口规范

| 服务名                      | 服务   | 服务                                       |
| ------------------------ | ---- | ---------------------------------------- |
| Customer.addCustomer     | 语法   | public boolean addCustomer(CustomerVO customer) |
|                          | 前置条件 | 输入的信息符合规范                                |
|                          | 后置条件 | 系统新建一个客户，并提示新建成功                         |
| Customer.delCustomer     | 语法   | public boolean delCustomer(String ID);   |
|                          | 前置条件 | 需要删除的用户存在于系统中                            |
|                          | 后置条件 | 删除用户，返回true                              |
| Customer.modifyCustomer  | 语法   | public boolean ModifyCustomer(CustomerVO modCustomer); |
|                          | 前置条件 | 输入的信息符合规范                                |
|                          | 后置条件 | 系统修改该客户的属性，并返回true                       |
| Customer.getCustomerInfo | 语法   | public CustomerVO getCustomerInfo(String ID); |
|                          | 前置条件 | 输入的客户编号符合规范                              |
|                          | 后置条件 | 如果系统中有该客户，返回该客户的属性。否则返回null              |
| Customer.searchCustomer  | 语法   | public ArrayList< CustomerVO > searchCustomer(String keytype, String keyword); |
|                          | 前置条件 | 输入的关键词合法                                 |
|                          | 后置条件 | 如果系统里有符合条件的客户，返回true，否则返回false           |
|                          |      |                                          |
|                          |      |                                          |

需要的服务（需接口）

| 服务名                             | 服务     |
| ------------------------------- | ------ |
| CommodityBLService.getCommodity | 获取商品属性 |
|                                 |        |

##### （4）业务逻辑层内部动态模型

图1 增加客户顺序图

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%BF%9B%E8%B4%A7%E9%94%80%E5%94%AE%E4%BA%BA%E5%91%98/%E5%A2%9E%E5%8A%A0%E5%AE%A2%E6%88%B7%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)

修改客户属性顺序图

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%BF%9B%E8%B4%A7%E9%94%80%E5%94%AE%E4%BA%BA%E5%91%98/%E4%BF%AE%E6%94%B9%E5%AE%A2%E6%88%B7%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)

#### 4.2.9 LogBL模块

##### （1）模块概述

logbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求

logbl模块的职责及接口参加软件系统结构描述文档

##### （2）整体结构

根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，我们会添加接口。比如展示层和业务逻辑层之间我们添加logblservice接口。业务逻辑层和数据层之间添加logdataservice接口和。为了隔离业务逻辑职责和逻辑控制职责，我们增加了log对象，这样logblserviceimpl会将日志模块的操作委托给log对象。LogPO是作为持久化对象被添加到设计模型中去的。
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/Log模块类图.png)
LogBL模块各个类的职责如表所示

| 模块               | 职责                   |
| ---------------- | -------------------- |
| LogBLServiceImpl | 日志模块接口的具体实现          |
| Log              | 日志模块的主要功能类，负责实现所有的功能 |
| LogBLInfo        | 负责LogBL模块与其他BL模块的交互  |

##### （3）模块内部类的接口规范

LogBLServiceImpl的接口规范

| 提供的服务（供接口）                     |              |                                          |
| ------------------------------ | ------------ | ---------------------------------------- |
| LogBLServiceImpl.search        | 语法           | public ArrayList<LogPO> search(Time date); |
| 前置条件                           | 无            |                                          |
| 后置条件                           | 返回存储LogPO的数组 |                                          |
| LogBLServiceImpl.showLogList   | 语法           | public LogListVO showLogList(ArrayList<LogPO> logList); |
| 前置条件                           | 无            |                                          |
| 后置条件                           | 返回日志列表VO     |                                          |
| LogBLServiceImpl.showLogDetail | 语法           | public LogVO showLogDetail(String Id);   |
| 前置条件                           | 无            |                                          |
| 后置条件                           | 返回日志VO       |                                          |
| 需要的服务（需接口）                     |              |                                          |
| 服务名                            | 服务           |                                          |
| Log.search                     | 搜索符合条件的日志    |                                          |
| Log.showLogList                | 显示日志列表       |                                          |
| Log.showLogDetail              | 显示日志详情       |                                          |

Log的接口规范

| 提供的服务（供接口）            |                 |                                          |
| --------------------- | --------------- | ---------------------------------------- |
| Log.add               | 语法              | public ResultMessage add(LogPO logPO);   |
| 前置条件                  | 无               |                                          |
| 后置条件                  | Log Data里增添一条记录 |                                          |
| Log.search            | 语法              | public ArrayList<LogPO> search(Time date); |
| 前置条件                  | 无               |                                          |
| 后置条件                  | 返回存储LogPO的数组    |                                          |
| Log.showLogList       | 语法              | public LogListVO showLogList(ArrayList<LogPO> logList); |
| 前置条件                  | 无               |                                          |
| 后置条件                  | 返回日志列表VO        |                                          |
| Log.showLogDetail     | 语法              | public LogVO showLogDetail(String id);   |
| 前置条件                  | 无               |                                          |
| 后置条件                  | 返回日志VO          |                                          |
| 需要的服务（需接口）            |                 |                                          |
| 服务名                   | 服务              |                                          |
| LogDataService.add    | 在日志数据中加入一个日志PO  |                                          |
| LogDataService.search | 搜索符合条件的日志PO     |                                          |

LogBLInfo的接口规范

| 提供的服务（供接口）         |                 |                                        |
| ------------------ | --------------- | -------------------------------------- |
| LogBLInfo.add      | 语法              | public ResultMessage add(LogPO logPO); |
| 前置条件               | 无               |                                        |
| 后置条件               | Log Data里增添一条记录 |                                        |
| 需要的服务（需接口）         |                 |                                        |
| 服务名                | 服务              |                                        |
| LogDataService.add | 在日志数据中加入一个日志PO  |                                        |
（4）业务逻辑层内部动态模型业务逻辑
![](http://101.37.19.32:10080/FX/MSPSS/blob/master/doc/img/Log顺序图.png)

#### 4.2.10 GeneralAccountBL模块

##### （1）模块描述

generalaccountbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求。

generalaccountbl模块的职责及接口参见软件体系结构设计文档

 ##### （2）整体结构

TableBL模块主要负责制定报表功能需求的逻辑实现，其中Table为主模块，负责主要逻辑的生成以及对辅助类和功能类的调度，但为了降低耦合，Table不与DataService模块交互，而是TableInfoFactory与BillDataService交互，来生成ArrayList<Bill>以及具体的VO，此外，还拥有TableSorter类来负责TableBL类的数据的排序
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/GeneralAccount%E6%A8%A1%E5%9D%97.png)



GeneralAccount模块的各个类的职责如表所示

| 模块                          | 职责                                  |
| --------------------------- | ----------------------------------- |
| GeneralAccountBLServiceImpl | 负责实现与期初建账有关的添加，查询，排序操作              |
| GeneralAccount              | 期初建账模块的主要功能类，负责实现功能及辅助类功能类之间的调度     |
| GeneralAccountInfoFactory   | GeneralAccountVO及PO的工厂模式，负责信息的转化和生成 |
| GeneralAccountComparator    | 排序功能类，负责实现各种排序方法                    |

##### （3）模块内部类的接口规范

GeneralAccountBLServiceImpl的接口规范

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| GeneralAccountBLServiceImpl.newGeneralAccount | 语法   | public ResultMessage newGeneralAccount(GeneralAccountVO generalaccount) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回期初建账的结果ResultMessa                     |
| GeneralAccountBLServiceImpl.checkGeneralAccount | 语法   | public ArrayList<GeneralAccountVO checkGenerlalAccount(Time begin,Time end) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回期初建账的信息，如果不存在，则返回空VO                   |
| GeneralAccountBLServiceImpl.ETLSort      | 语法   | public ArrayList<GeneralAccountVO> ETLSort(ArrayList<GeneralAccountVO> list) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回时间从早到晚排序的list                          |
| GeneralAccountBLServiceImpl.LTESort      | 语法   | public ArrayList<GeneralAccountVO> LTESort(ArrayList<GeneralAccountVO> list) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回时间从晚到早排序的list                          |

需要的接口(需接口)

| 服务名                                | 服务        |
| ---------------------------------- | --------- |
| GeneralAccount.newGeneralAccount   | 添加期初建账的信息 |
| GeneralAccount.checkGeneralAccount | 检查期初建账的信息 |
| GeneralAccount.Early_To_Late       | 从早到晚排序    |
| GeneralAccount.Late_To_Early       | 从晚到早排序    |

GeneralAccount的接口规范

提供的接口(供接口)

| 服务名                                | 服务   | 服务                                       |
| ---------------------------------- | ---- | ---------------------------------------- |
| GeneralAccount.newGeneralAccount   | 语法   | public ResultMessage newGeneralAccount(GeneralAccountVO generalaccount) |
|                                    | 前置条件 | 无                                        |
|                                    | 后置条件 | 返回期初建账的结果ResultMessa                     |
| GeneralAccount.checkGeneralAccount | 语法   | public ArrayList<GeneralAccountVO checkGenerlalAccount(Time begin,Time end) |
|                                    | 前置条件 | 无                                        |
|                                    | 后置条件 | 返回期初建账的信息，如果不存在，则返回空VO                   |
| GeneralAccount.ETLSort             | 语法   | public ArrayList<GeneralAccountVO> ETLSort(ArrayList<GeneralAccountVO> list) |
|                                    | 前置条件 | 无                                        |
|                                    | 后置条件 | 返回时间从早到晚排序的list                          |
| GeneralAccount.LTESort             | 语法   | public ArrayList<GeneralAccountVO> LTESort(ArrayList<GeneralAccountVO> list) |
|                                    | 前置条件 | 无                                        |
|                                    | 后置条件 | 返回时间从晚到早排序的list                          |

需要的服务(需接口)

| 服务名                                      | 服务        |
| ---------------------------------------- | --------- |
| GeneralAccountInfoFactory.newGeneralAccount | 添加期初建账的信息 |
| GeneralAccountInfoFactory.checkGeneralAccount | 检查期初建账的信息 |
| GeneralAccountSorter.Early_To_Late       | 从早到晚排序    |
| GeneralAccountSorter.Late_To_Early       | 从晚到早排序    |

提供的服务(供接口)

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| GeneralAccountInfoFactory.newGeneralAccount | 语法   | public ResultMessage newGeneralAccount(GeneralAccountVO generalaccount) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回期初建账的结果ResultMessa                     |
| GeneralAccountInfoFacto.checkGeneralAccount | 语法   | public ArrayList<GeneralAccountVO checkGenerlalAccount(Time begin,Time end) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回期初建账的信息，如果不存在，则返回空VO                   |

需要的服务(需接口)

| 服务名                                      | 服务        |
| ---------------------------------------- | --------- |
| GeneralAccountDataService.newGeneralAccount | 添加期初建账的信息 |
| GeneralAccountDataService.checkGeneralAccount | 检查期初建账的信息 |
| AccountDataService.addAccount            | 从早到晚排序    |
| CommodityDataService.addCommodity        | 从晚到早排序    |
| CustomerDataService.addCustomer          |           |

提供的接口(供接口)

| 提供的接口(供接口)                             |      |                                          |
| -------------------------------------- | ---- | ---------------------------------------- |
| 服务名                                    |      | 服务                                       |
| GeneralAccountComparator.Early_To_Late | 语法   | public ArrayList<GeneralAccountVO> Early_To_Late(ArrayList<GeneralAccount> list) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 返回时间从早到晚的总账                              |
| GeneralAccountComparator.Late_To_Early | 语法   | public ArrayList<GeneralAccountVO> Late_To_Early(ArrayList<GeneralAccount> list) |
|                                        | 前置条件 | 无                                        |
|                                        | 后置条件 | 返回时间从晚到早的总账                              |

需要的服务(需接口)

| 服务名  | 服务   |
| ---- | ---- |
| 无    |      |


![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/%E6%9C%9F%E5%88%9D%E5%BB%BA%E8%B4%A6%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/%E6%9F%A5%E7%9C%8B%E6%9C%9F%E5%88%9D%E8%B4%A6%E6%88%B7%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)

##### （4）业务逻辑层内部动态模型













### 4.3 数据层的分解

#### 4.3.1 User模块

提供的服务（供接口）

| 服务名                            | 服务   | 服务                                       |
| ------------------------------ | ---- | ---------------------------------------- |
| UserDataServiceImpl.login      | 语法   | public Log_In_Out_Status login(String ID, String password) |
|                                | 前置条件 | 用户处于未登录状态                                |
|                                | 后置条件 | 用户登陆                                     |
| UserDataServiceImpl.logout     | 语法   | public Log_In_Out_Status logout(String ID) |
|                                | 前置条件 | 用户已登录                                    |
|                                | 后置条件 | 用户登出                                     |
| UserDataServiceImpl.addUser    | 语法   | public ResultMessage addUser(UserPO);    |
|                                | 前置条件 | 输入的信息符合规范                                |
|                                | 后置条件 | 增加用户                                     |
| UserDataServiceImpl.delUser    | 语法   | public ResultMessage delUser(String ID); |
|                                | 前置条件 | 输入的ID已存在                                 |
|                                | 后置条件 | 删除该用户                                    |
| UserDataServiceImpl.modifyUser | 语法   | public ResultMessage modifyUser(UserPO); |
|                                | 前置条件 | 输入的信息符合规范                                |
| 输入的信息符合规范                      | 后置条件 | 修改用户属性                                   |

需要的服务（需接口）

| 服务名  | 服务   |
| ---- | ---- |
|      |      |
|      |      |



#### 4.3.2 Stock模块

#### 4.3.3 Commodity模块

#### 4.3.4 Bill模块

#### 4.3.5 Account模块

模块内部的接口规范

| 提供的服务（供接口）                           |      |                                          |
| ------------------------------------ | ---- | ---------------------------------------- |
| AccountDataServiceImpl.addAccount    | 语法   | public ResultMessage addAccount（AccountVO account) |
|                                      | 前置条件 | account.name不能与之前的重复                     |
|                                      | 后置条件 | 无                                        |
| AccountDataServiceImpl.deleteAccount | 语法   | public ResultMessage deleteAccount（string name) |
|                                      | 前置条件 | name必须已经存在的账户列表中                         |
|                                      | 后置条件 | 无                                        |
| AccountDataServiceImpl.modifyAccount | 语法   | public ResultMessage modifyAccount（string oldname,string newname) |
|                                      | 前置条件 | oldname已经存在于账号列表中而newname不存在于账户列表中       |
|                                      | 后置条件 | 无                                        |
| AccountDataServiceImpl.checkAccount  | 语法   | public AccountVO checkAccount(String name) |
|                                      | 前置条件 | name已经存在于账户列表中                           |
|                                      | 后置条件 | 返回已经写入账户信息（具体参见Account类说明表）的Account      |
| AccountDataServiceImpl.income        | 语法   | public void income(String name, int income) |
|                                      | 前置条件 | 无                                        |
|                                      | 后置条件 | 无                                        |
| AccountDataServiceImpl.pay           | 语法   | public void pay(String name,int pay)     |
|                                      | 前置条件 | 无                                        |
|                                      | 后置条件 | 无                                        |

#### 4.3.6 Customer模块

提供的服务（供接口）

| 服务名                                     | 服务   | 服务                                       |
| --------------------------------------- | ---- | ---------------------------------------- |
| CustomerDataServiceImpl.addCustomer     | 语法   | public boolean addCustomer(CustomerPO customer) |
|                                         | 前置条件 | 输入的信息符合规范                                |
|                                         | 后置条件 | 系统新建一个客户，并提示新建成功                         |
| CustomerDataServiceImpl.delCustomer     | 语法   | public boolean delCustomer(String ID);   |
|                                         | 前置条件 | 需要删除的用户存在于系统中                            |
|                                         | 后置条件 | 删除用户，返回true                              |
| CustomerDataServiceImpl.modifyCustomer  | 语法   | public boolean ModifyCustomer(CustomerPO modCustomer); |
|                                         | 前置条件 | 输入的信息符合规范                                |
|                                         | 后置条件 | 系统修改该客户的属性，并返回true                       |
| CustomerDataServiceImpl.getCustomerInfo | 语法   | public CustomerPO getCustomerInfo(String ID); |
|                                         | 前置条件 | 输入的客户编号符合规范                              |
|                                         | 后置条件 | 如果系统中有该客户，返回该客户的属性。否则返回null              |
| CustomerDataServiceImpl.searchCustomer  | 语法   | public ArrayList< CustomerPO > searchCustomer(String keytype, String keyword); |
|                                         | 前置条件 | 输入的关键词合法                                 |
|                                         | 后置条件 | 如果系统里有符合条件的客户，返回true，否则返回false           |
|                                         |      |                                          |
|                                         |      |                                          |

需要的服务（需接口）

| 服务名  | 服务   |
| ---- | ---- |
|      |      |
|      |      |



#### 4.3.7 Log模块

#### 4.3.8 GeneralAccount模块

模块内部的接口规范

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| GeneralAccountDataServiceImpl.newGeneralAccount | 语法   | public ResultMessage newGeneralAccount(GeneralAccountVO generalaccount) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回期初建账的结果ResultMessa                     |
| GeneralAccountDataServiceImpl.checkGeneralAccount | 语法   | public ArrayList<GeneralAccountVO checkGenerlalAccount(Time begin,Time end) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回期初建账的信息，如果不存在，则返回空VO                   |

#### 4.3.9 Promotion模块



### 5 依赖视角

进销存管理系统MSPSS客户端开发包图如图5-1所示，服务器端开发包图如图5-2所示。

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%BF%9B%E8%B4%A7%E9%94%80%E5%94%AE%E7%B3%BB%E7%BB%9FMSPSS%E5%AE%A2%E6%88%B7%E7%AB%AF%E5%BC%80%E5%8F%91%E5%8C%85%E5%9B%BE.png)

图5-1进销存管理系统MSPSS客户端开发包图

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%BF%9B%E9%94%80%E5%AD%98%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9FMSPSS%E6%9C%8D%E5%8A%A1%E5%99%A8%E7%AB%AF%E9%80%BB%E8%BE%91%E5%8C%85%E5%9B%BE.png)

图5-2进销存管理系统MSPSS服务器端开发包图

### 6 内聚和耦合的度量

