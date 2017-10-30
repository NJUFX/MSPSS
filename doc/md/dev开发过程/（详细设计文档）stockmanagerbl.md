4.1.1 stockmanager

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