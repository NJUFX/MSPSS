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
| 徐光耀  | 2017-1106  | 添加财务人员展示层分解        | v1.2.3 |
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

#### 4.1.2 stockseller模块

##### （1）整体结构

展示层的控制器为树状委托式结构，StockSellerViewController负责对进货销售人员界面的整体跳转，StockSellerNavBarController负责实现导航栏界面，CustomerManagerViewController、BillCreateViewController分别实现进货销售人员导航栏的客户管理和制定单据的跳转

StockSeller界面各类的职责如表4.2.1(1)-1所示

表4.2.1(1)-1 StockSeller界面各类的职责

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

表4.2.1(2)-1 StockSellerViewController的接口规范

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

表4.2.1(2)-2 StockSellerNavBarController的接口规范

提供的服务（供接口）

无

需要的服务（需接口）

| 服务名                               | 服务       |
| --------------------------------- | -------- |
| CustomerManageViewController.show | 显示客户管理界面 |
| BillCreateViewController.show     | 显示制定单据界面 |
|                                   |          |

表4.2.1(2)-3 CustomerManageViewController的接口规范

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

表4.2.1(2)-4 BillCreateViewController的接口规范

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

表4.2.1(2)-5 CustomerAddViewController的接口规范

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

表4.2.1(2)-6 CustomerDelViewController的接口规范

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

表4.2.1(2)-7 CustomerModifyViewController的接口规范

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

表4.2.1(2)-8 CustomerSearchViewController的接口规范

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

表4.2.1(2)-9 CustomerShowViewController的接口规范

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

表4.2.1(2)-10 PurchaseCreateViewController的接口规范

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

表4.2.1(2)-11 PurchaseRetCreateViewController的接口规范

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

表4.2.1(2)-12 SalesCreateViewController的接口规范

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

表4.2.1(2)-13 SalesRetCreateViewController的接口规范

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







### 4.2 业务逻辑层的分解



#### 4.2.1 UserBL模块

##### （1）模块描述

userbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求。

userbl模块的职责及接口参见软件体系结构设计文档

##### （2）整体结构

根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，我们会添加接口。比如展示层和业务逻辑层之间我们添加businesslogicservice.userblservice.UserBLService接口。业务逻辑层和数据层之间添加dataservice.UserDataService。为了隔离业务逻辑职责和逻辑控制职责，我们增加了UserBLServiceImpl，这样UserBLServiceImpl会将用户管理和登陆登出的业务逻辑委托给User对象。UserPO是作为用户的持久化对象被添加到设计模型中去的。UserVO是作为值对象被添加到设计模型中去的。

##### （3）模块内部类的接口规范

提供的服务（供接口）

| 服务名               | 服务   | 服务                                       |
| ----------------- | ---- | ---------------------------------------- |
| UserBL.login      | 语法   | public Log_In_Out_Status login(String ID, String password) |
|                   | 前置条件 | 用户处于未登录状态                                |
|                   | 后置条件 | 用户登陆                                     |
| UserBL.logout     | 语法   | public Log_In_Out_Status logout(String ID) |
|                   | 前置条件 | 用户已登录                                    |
|                   | 后置条件 | 用户登出                                     |
| UserBL.addUser    | 语法   | public ResultMessage addUser(UserVO);    |
|                   | 前置条件 | 输入的信息符合规范                                |
|                   | 后置条件 | 增加用户                                     |
| UserBL.delUser    | 语法   | public ResultMessage delUser(String ID); |
|                   | 前置条件 | 输入的ID已存在                                 |
|                   | 后置条件 | 删除该用户                                    |
| UserBL.modifyUser | 语法   | public ResultMessage modifyUser(UserVO); |
|                   | 前置条件 | 输入的信息符合规范                                |
| 输入的信息符合规范         | 后置条件 | 修改用户属性                                   |

需要的服务（需接口）

| 服务名  | 服务   |
| ---- | ---- |
|      |      |
|      |      |

##### （4）业务逻辑层内部动态模型

#### 4.2.2 StockBL模块



#### 4.2.3 CommodityBL模块



#### 4.2.4 BillBL模块

PayBillController的接口规范





#### 4.2.5 AccountBL模块

##### （1）模块描述

accountbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求。

accountbl模块的职责及接口参见软件体系结构设计文档

 **（2）整体结构**

AccountBL模块主要负责账户管理功能需求的逻辑实现，其中Account为主模块，负责主要逻辑的生成以及对辅助类和功能类的调度，但为了降低耦合，Account不与DataService模块交互，而是AccountInfoFactory与DataService交互，来生成具体的VO并且向数据层传输数据，此外，还拥有AccountSorter类来负责AccountBL类的数据的排序

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/Account%E6%A8%A1%E5%9D%97.png)


AccountBL模块的类的功能如下表所示

| 模块                   | 职责                         |
| -------------------- | -------------------------- |
| AccountBLServiceImpl | 账户管理接口的具体实现                |
| Account              | AccountBL主要逻辑类，实现增删改查等主要功能 |
| AccountComparator    | 功能类，用来排序Account            |
| AccountInfoFactory   | 信息辅助类，完成PO与VO转换并且获得数据      |

**（3）模块内部类的接口规范**

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

(1)模块概述

Promotionbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求

Promotionbl模块的职责及接口参加软件系统结构描述文档

(2)整体结构

根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，我们会添加接口。比如展示层和业务逻辑层之间我们添加promotionblservice接口。业务逻辑层和数据层之间添加promotiondataservice接口和。为了隔离业务逻辑职责和逻辑控制职责，我们增加了promotion对象，这样promotionblserviceimpl会将促销策略模块的操作委托给promotion对象。PromotionPO是作为持久化对象被添加到设计模型中去的。

PromotionBL模块各个类的职责如表所示

| 模块                     | 职责                        |
| ---------------------- | ------------------------- |
| PromotionBLServiceImpl | 促销策略模块接口的具体实现             |
| Promotion              | 促销策略模块的主要功能类，负责实现所有的功能    |
| PromotionBLInfo        | 负责PromotionBL模块与其他BL模块的交互 |

（3）模块内部类的接口规范

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
| PromotionBLServiceImpl.showPromotionList | 语法               | public PromotionListVO showPromotionList(ArrayList<PromotionPO>); |
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
| Promotion.showPromotionList   | 语法               | public PromotionListVO showPromotionList(ArrayList<PromotionPO>); |
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

| 提供的服务（供接口）          |                  |                                          |
| ------------------- | ---------------- | ---------------------------------------- |
| PromotionBLInfo.add | 语法               | public ResultMessage add(Promotion PO promotionPO); |
| 前置条件                | 无                |                                          |
| 后置条件                | 促销策略数据中增加一条促销策略  |                                          |
| 需要的服务（需接口）          |                  |                                          |
| 服务名                 | 服务               |                                          |
| Promotion.add       | 给促销策略数据中增加一个促销策略 |                                          |

#### 4.2.7 TableBL模块

##### （1）模块描述

tablebl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求。

tablebl模块的职责及接口参见软件体系结构设计文档

 **（2）整体结构**

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

**（3）模块内部类的接口规范**

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


![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/%E6%8A%A5%E8%A1%A8%E4%B8%AD%E5%8D%95%E6%8D%AE%E6%8E%92%E5%BA%8F%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/%E6%9F%A5%E7%9C%8B%E6%8A%A5%E8%A1%A8%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)
![](
#### 4.2.8 CustomerBL模块

##### （1）模块描述

customerbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求。

customerbl模块的职责及接口参见软件体系结构设计文档

##### （2）整体结构

根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，我们会添加接口。比如展示层和业务逻辑层之间我们添加businesslogicservice.customerblservice.CustomerBLService接口。业务逻辑层和数据层之间添加dataservice.CustomerDataService、dataservice.CommodityDataService接口。为了隔离业务逻辑职责和逻辑控制职责，我们增加了CustomerBLServiceImpl，这样CustomerBLServiceImpl会将客户管理和制定单据的业务逻辑委托给Customer对象。CustomerPO是作为客户属性的持久化对象被添加到设计模型中去的，CommodityPO是作为商品属性的持久化对象被添加到设计模型中去的。CustomerVO、CommodityVO是作为值对象被添加到设计模型中去的。

##### （3）模块内部类的接口规范

提供的服务（供接口）

| 服务名                       | 服务   | 服务                                       |
| ------------------------- | ---- | ---------------------------------------- |
| CustomerBL.addCustomer    | 语法   | public boolean addCustomer(CustomerVO customer) |
|                           | 前置条件 | 输入的信息符合规范                                |
|                           | 后置条件 | 系统新建一个客户，并提示新建成功                         |
| CustomerBL.delCustomer    | 语法   | public boolean delCustomer(String ID);   |
|                           | 前置条件 | 需要删除的用户存在于系统中                            |
|                           | 后置条件 | 删除用户，返回true                              |
| CustomerBL.modifyCustomer | 语法   | public boolean ModifyCustomer(CustomerVO modCustomer); |
|                           | 前置条件 | 输入的信息符合规范                                |
|                           | 后置条件 | 系统修改该客户的属性，并返回true                       |
| CustomerBLgetCustomerInfo | 语法   | public CustomerVO getCustomerInfo(String ID); |
|                           | 前置条件 | 输入的客户编号符合规范                              |
|                           | 后置条件 | 如果系统中有该客户，返回该客户的属性。否则返回null              |
| CustomerBL.searchCustomer | 语法   | public ArrayList< CustomerVO > searchCustomer(String keytype, String keyword); |
|                           | 前置条件 | 输入的关键词合法                                 |
|                           | 后置条件 | 如果系统里有符合条件的客户，返回true，否则返回false           |
|                           |      |                                          |
|                           |      |                                          |

需要的服务（需接口）

| 服务名  | 服务   |
| ---- | ---- |
|      |      |
|      |      |



#### 4.2.9 LogBL模块

(1)模块概述

logbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求

logbl模块的职责及接口参加软件系统结构描述文档

(2)整体结构

根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，我们会添加接口。比如展示层和业务逻辑层之间我们添加logblservice接口。业务逻辑层和数据层之间添加logdataservice接口和。为了隔离业务逻辑职责和逻辑控制职责，我们增加了log对象，这样logblserviceimpl会将日志模块的操作委托给log对象。LogPO是作为持久化对象被添加到设计模型中去的。

LogBL模块各个类的职责如表所示

| 模块               | 职责                   |
| ---------------- | -------------------- |
| LogBLServiceImpl | 日志模块接口的具体实现          |
| Log              | 日志模块的主要功能类，负责实现所有的功能 |
| LogBLInfo        | 负责LogBL模块与其他BL模块的交互  |

（3）模块内部类的接口规范

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

#### 4.2.10 GeneralAccountBL模块

##### （1）模块描述

generalaccountbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求。

generalaccountbl模块的职责及接口参见软件体系结构设计文档

 **（2）整体结构**

TableBL模块主要负责制定报表功能需求的逻辑实现，其中Table为主模块，负责主要逻辑的生成以及对辅助类和功能类的调度，但为了降低耦合，Table不与DataService模块交互，而是TableInfoFactory与BillDataService交互，来生成ArrayList<Bill>以及具体的VO，此外，还拥有TableSorter类来负责TableBL类的数据的排序
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%BE%90%E5%85%89%E8%80%80%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE/GeneralAccount%E6%A8%A1%E5%9D%97.png)



GeneralAccount模块的各个类的职责如表所示

| 模块                          | 职责                                  |
| --------------------------- | ----------------------------------- |
| GeneralAccountBLServiceImpl | 负责实现与期初建账有关的添加，查询，排序操作              |
| GeneralAccount              | 期初建账模块的主要功能类，负责实现功能及辅助类功能类之间的调度     |
| GeneralAccountInfoFactory   | GeneralAccountVO及PO的工厂模式，负责信息的转化和生成 |
| GeneralAccountComparator    | 排序功能类，负责实现各种排序方法                    |

**（3）模块内部类的接口规范**

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















#### 4.2.1 stockmanager模块



##### （1）模块描述 

stockmanagerbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求。

stockmanagerbl模块的职责及接口参见软件体系结构设计文档

##### （2） 整体结构

 ClassificationPO是作为商品分类属性的持久化对象被添加到设计模型中去的。PresentBillPO是作为库存赠送单的持久化对象被添加到设计模型中去的。OverOrLowBillPO是作为库存报损报溢单属性的持久化对象被添加到设计模型中去的。AlertBillPO是作为库存报警单属性的持久化对象被添加到设计模型中去的。StackPO是作为库存报警单属性的持久化对象被添加到设计模型中去的。

CommodityVO、StackVO、SalesBillVO、StackPO是作为值对象被添加到设计模型中去的。



stockmanagerbl模块的设计图

| 模块                        | 职责                               |
| ------------------------- | -------------------------------- |
| StockManagerBLServiceImpl | 负责管理stockmanager各个类的任务负责与bl模块的交互 |
| Commodity                 | 负责对商品信息的增删改查任务                   |
| Classification            | 负责对商品分类信息的增删改查任务                 |

#####（3）模块内部类的接口规范

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

GeneralAccoutController的接口规范

| 提供的服务                          |      |                                          |
| ------------------------------ | ---- | ---------------------------------------- |
| GeneralAccountController.new   | 语法   | public ResultMessage new(GeneralAccoutVO accout) |
|                                | 前置条件 | accout已经被初始化                             |
|                                | 后置条件 | 无                                        |
| GeneralAccountController.check | 语法   | public GeneralAccoutVO check(string id)  |
|                                | 前置条件 | id存在于账户列表中                               |
|                                | 后置条件 | 无                                        |

| 需要的服务                                |            |
| ------------------------------------ | ---------- |
| SystemDataService.newGeneralAccount  | 创建一个账户在数据层 |
| SystemDataService.checkGeneralAccout | 查询账户       |



#####（4）业务逻辑层内部动态模型

图4.2.3(4)-1中表现了添加账户的操作中，各个类之间的协作关系
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE%E7%89%87%E6%A0%B9%E7%9B%AE%E5%BD%95/%E6%B7%BB%E5%8A%A0%E8%B4%A6%E6%88%B7%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)


#### 4.2.4 chiefmanger模块

##### （1）模块概述

chiefmanagerbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求

chiefmanagerbl模块的职责及接口参加软件系统结构描述文档

##### （2）整体结构

根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，我们会添加接口。比如展示层和业务逻辑层之间我们添加businesslogicservice.chiefmanegerblservice.chiefmanagerBLService接口。业务逻辑层和数据层之间添加dataservice.systemDataService接口和dataservice.billDataservice接口。为了隔离业务逻辑职责和逻辑控制职责，我们增加了List和Promotion对象，这样chiefmanagerblServiceImpl会将查看报表和制定促销策略的业务逻辑分别委托给List对象和Promotion对象。BillPO、ConditionPO、LogPO、SalesBillPO、PromotionPO是作为持久化对象被添加到设计模型中去的。
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/chiefmanagerbl模块各个类的设计.png)

chiefmanagernbl模块的职责如下表所示

| 模块                         | 职责                                       |
| -------------------------- | ---------------------------------------- |
| ChiefManaagerBLServiceImpl | 实现查询日志和审批单据的简单服务，管理查看报表和制定促销策略的服务，负责与其他模块的交互 |
| List                       | 实现处理查看报表的服务                              |
| Promotion                  | 实现制定促销策略的服务                              |

##### （3）模块内部类的接口规范

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

| 提供的服务（供接口）             |                  |                                          |
| ---------------------- | ---------------- | ---------------------------------------- |
| List.makeSalesList     | 语法               | public SalesListVO makeSalesList(String time,String commodityName, String customerName, String salesmanName,String warehouseName ); |
| 前置条件                   | 用户有查看销售明细表的权限    |                                          |
| 后置条件                   | 返回用户要求的销售明细表     |                                          |
| List.makeManageList    | 语法               | public ManageListVO makeManageList(String time); |
| 前置条件                   | 用户有查看经营情况表的权限    |                                          |
| 后置条件                   | 返回用户要求的经营情况表     |                                          |
| 需要的服务（需接口）             |                  |                                          |
| BillDataService.find   | 查找符合条件的所有类型的单据PO |                                          |
| BillDataService.update | 改变BillPO中的数据     |                                          |

##### （4）业务逻辑层内部动态模型

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/查看经营情况表顺序图.png)

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/查看销售明细表顺序图.png)
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/制定促销策略顺序图.png)

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

####

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

### 

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

