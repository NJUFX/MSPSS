![Image text](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E6%96%87%E6%A1%A3%E5%B0%81%E9%9D%A2/%E4%BD%93%E7%B3%BB%E7%BB%93%E6%9E%84%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3.png)
<br>
# 进销存系统

# <center>进销存管理系统</center>



# <center>MSPSS(Management System of Purchase-Sell-Stock)</center>





# <center> 体系结构设计文档</center>





# <center>v1.0 </center>

<br><br><br>

## <center>南京大学FX工作组</center><br><center>伏家兴，韩新虎，刘雅歆，徐光耀</center><br><center>2017-09-30</center>



##目录<br>
<a href="#geng">更新历史</a><br>

<a href="#1">1.引言</a><br>

<a href="#1.1">1.1编制目的</a><br>

<a href="#1.2">1.2词汇表</a><br>

<a href="#1.3">1.3参考资料</a><br>

<a href="#2">2.产品概述</a><br>

<a href="#3">3.逻辑视角</a><br>

<a href="#4">4.组合视角</a><br>

<a href="#4.1">4.1开发包图</a><br>

<a href="#4.2">4.2运行时进程</a><br>

<a href="#4.3">4.3物理部署</a><br>

<a href="#5">5.接口视角</a><br>

<a href="#5.1">5.1模块的职责</a><br>

<a href="#5.2">5.2用户界面层的分解</a><br>

<a href="#5.2.1">5.2.1 用户界面层模块的职责</a><br>

<a href="#5.2.2">5.2.2 用户界面模块的接口规范</a><br>

<a href="#5.2.3">5.2.3 用户界面模块的设计原理</a><br>

<a href="#5.3">5.3业务逻辑层的分解</a><br>

<a href="#5.4">5.4数据层的分解</a><br>

<a href="#5.5">5.5模块的关键类图</a><br>

<a href="#6">6.信息视角</a><br>



## <a name="geng"></a> 更新历史

| **修改人员** | **日期**     | **变更原因** | **版本号**  |
| -------- | ---------- | -------- | -------- |
| FX全组人员   | 2017-10-10 | 最初草稿     | V1.0  草稿 |
| 伏家兴      | 2017-10-13 | 添加目录     | V1.1草稿   |
|          |            |          |          |
|          |            |          |          |



## <a name="1"></a>1 引言

### <a name="1.1"></a>  1.1 编制目的

  本报告详细完成库存管理系统MSPSS的概要设计，达到指导详细设计和开发的目的，同时实现和测试人员及用户人员的沟通。

###  <a name="1.2"></a>1.2词汇表

  

| 词汇名称  | 词汇含义                                     | 备注   |
| ----- | ---------------------------------------- | ---- |
| MSPSS | Management System of Purchase-Sell-Stock |      |
| _ui   | 表示某展示层                                   |      |
| _bi   | 表示某逻辑层                                   |      |
| data  | 表示某数据层                                   |      |

### <a name="1.2"></a>1.2词汇表

1. IEEE std 1471-2000
2. 《库存管理系统MSPSS需求规格说明书 v1.0》
3. 丁二玉，刘钦.计算与软件工程（卷二）[M]机械工业出版社，2012：134—182
4. Frank Buschmann, Regine Meunier, Hans Rohnert, Peter Sommerlad,Micheael Stal.Pattern-Oriented Software Architecture Volume 1: A system of Patterns [M]机械工业出版社,2003 

## <a name="2"></a>2产品概述

 进销存管理系统是一个在线的销售企业管理系统，旨在提供各种功能来简化库存管理人员，销售人员，财务管理人员，总经理操作流程的应用程序。提高了企业员工处理普通业务的工作效率，方便了各个部门之间的联系，从而全面提高了工作效率和用户的满意程度。

## <a name="3"></a> 3 逻辑视角

进销存管理系统 MSPSS中 选择了分层体系结构风格将系统分为3层（展示层，业务逻辑层，数据层）能够很好地示意整个高层抽象。展示层包括GUI页面的实现，业务逻辑层包含业务逻辑处理的实现，数据层负责数据的持久化和访问。分层体系结构的逻辑视角和逻辑设计方案如图3-1  和图3-2  所示。

![逻辑视角](http://101.37.19.32:10080/FX/MSPSS/raw/8cd024f022c261554f2939cdf3a817a88b83198b/doc/img/%E5%88%86%E5%B1%82%E4%BD%93%E7%B3%BB%E7%BB%93%E6%9E%84%E7%9A%84%E9%80%BB%E8%BE%91%E8%A7%86%E8%A7%92.png)

<center> 图3-1 分层体系结构的逻辑视角</center>

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%BF%9B%E8%B4%A7%E9%94%80%E5%94%AE%E7%B3%BB%E7%BB%9F%E8%BD%AF%E4%BB%B6%E4%BD%93%E7%B3%BB%E7%BB%93%E6%9E%84%E9%80%BB%E8%BE%91%E8%AE%BE%E8%AE%A1%E6%96%B9%E6%A1%88.png)

​	<center> 图3-2 分层体系结构的逻辑设计方案</center>

## <a name="4"></a>4 组合视角

### <a name="4.1"></a> 4.1 开发包图

进销存管理系统MSPSS的最终开发包设计表如表4.1-1

<center> 表4.1-1 进销存管理系统MSPSS的最终开发包设计</center>

| 开发包图（物理）              | 依赖的其他开发包                                 |
| --------------------- | ---------------------------------------- |
| mainui                | stockmanagerui，cheifmanagerui， financeui， adminui， searchservice，vo |
| stockmanagerui        | stockmanagerblservice，stockmanagerbl，stockmanagerblservice，vo |
| cheifmanagerui        | cheifmanagerservice，cheifmanagerbl，cheifmanagerblservice，vo |
| financeui             | financeblservice，financebl，financeblservice，vo |
| adminui               | searchservice，systemdata，vo              |
| stocksellerblservice  | stocksellerbl,java.RMI，po                |
| stockmanagerblservice | stockjmanagerbl,java.RMI，po              |
| financeblservice      | financebl,java.RMI，po                    |
| mainblservice         | mainbl,java.RMI，po                       |
| adminblservice        | adminbl,java.RMI，po                      |
| cheifmanagerblservice | cheifmanagerbl,java.RMI，po               |
| stocksellerbl         | systemdataservice，customerdataservice，billdataservice，commoditydataservice，systemdata，customerdata，billdata，commoditydata |
| stockmanagerbl        | commoditydataservice，billdataservice，stockdataservice，systemdataservice， commoditydata，billdata，stockdata，systemdata |
| financebl             | systemservice，billservice，accountservice，commodityservice,systemservice，billservice，accountservice，commodityservice |
| mainbl                | searchservice，systemdata                 |
| adminbl               | searchservice，systemdata                 |
| cheifmanagerbl        | customerdataservice，systemdataservice，billdataservice，accountdataservice，customerdata，systemdata，billdata，accountdata |
| customerdataservice   | java.RMI，po                              |
| stockdataservice      | java.RMI，po                              |
| systemdataservice     | java.RMI，po                              |
| billdataservice       | java.RMI，po                              |
| commoditydataservice  | java.RMI,   po                           |
| customerdata          | derby                                    |
| stockdata             | derby                                    |
| systemdata            | derby                                    |
| billdata              | derby                                    |
| accountdata           | derby                                    |
| commoditydata         | derby                                    |
| vo                    |                                          |
| po                    |                                          |
| 界面类库包                 | java.awt，javx.swing，java.2D，java.3D      |
| JDBC                  | JDBC                                     |
| RMI                   | java.rmi                                 |
| derby                 | derby.jar                                |



进销存管理系统MSPSS客户端开发包如图4.1-1 所示，服务器端开发包图如图4.1-2所示

<center>图4.1-1 进销存管理系统MSPSS客户端开发包图</center>

![Image text](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%BF%9B%E8%B4%A7%E9%94%80%E5%94%AE%E7%B3%BB%E7%BB%9FMSPSS%E5%AE%A2%E6%88%B7%E7%AB%AF%E5%BC%80%E5%8F%91%E5%8C%85%E5%9B%BE.png)



<center> 表4.1-2 进销存管理系统MSPSS服务器端逻辑包图</center>

![客户端图](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%BF%9B%E9%94%80%E5%AD%98%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9FMSPSS%E6%9C%8D%E5%8A%A1%E5%99%A8%E7%AB%AF%E9%80%BB%E8%BE%91%E5%8C%85%E5%9B%BE.png)

### <a name="4.2"></a>4.2 运行时进程

​	在进销存管理系统MSPSS中，会有多个客户端进程和一个服务器段进程，其进程图如图 4.2所示。结合部署图，客户端进程是在客户端机器上运行，服务器端机器是在服务器端运行。

![进程图](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%BF%9B%E7%A8%8B%E5%9B%BE.png)

<center> 图4.2 进程图 </center>

### <a name="4.3"></a> 4.3 物理部署

进销存系统MSPSS中的客户端构建是放在客户端机器上，服务端构建是放在服务端机器上。在客户端节点上，还要部署RMIStub构件。由于Java RMI 构件属于JDK8.0的一部分，所以在系统JDK环境已经设置好的情况下，不需要独立部署。

![部署图](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E9%83%A8%E7%BD%B2%E5%9B%BE.png)

## <a name="5"></a>5 接口视角

### <a name="5.1"></a>5.1模块的职责

客户端模块和服务器端模块视图分别如图5.1-1和图5.1-2所示。客户端各层和服务器端各层的职责分别如表5.1-1和表5.1-2所示

![客户端模块视图](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E5%AE%A2%E6%88%B7%E7%AB%AF%E6%A8%A1%E5%9D%97%E8%A7%86%E5%9B%BE.png)

图5.1-1 客户端模块视图

![服务器端模块视图](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E6%9C%8D%E5%8A%A1%E5%99%A8%E7%AB%AF%E6%A8%A1%E5%9D%97%E8%A7%86%E5%9B%BE.png)

图5.1-2 服务器端模块视图



表5.1-1 客户端各层的职责

| 层       | 职责                      |
| :------ | :---------------------- |
| 启动模块    | 负责初始化网络通信机制，启动用户界面      |
| 用户界面层   | 基于窗口的进销存管理系统客户端用户界面     |
| 业务逻辑层   | 对于用户界面的输入进行响应并进行业务处理逻辑  |
| 客户端网络模块 | 利用 Java RMI 机制查找 RMI 服务 |



表5.1-2 服务器端各层的职责

| 层       | 职责                                |
| ------- | --------------------------------- |
| 启动模块    | 负责初始化网络通信机制，启动用户界面                |
| 数据层     | 负责数据的持久化以及数据访问接口                  |
| 客户端网络模块 | 利用 Java RMI 机制开启 RMI 服务，注册 RMI 服务 |



每一层都只是使用下方直接接触的层。层与层之间仅仅是通过接口的调用来完成的。层与层之间的接口如表5.1-3所示。

| 接口                                       | 服务调用方    | 服务提供方    |
| ---------------------------------------- | -------- | -------- |
| StockManagerBLService<br>StockSellerBLService<br>FinancerBLService<br>ChiefManagerBLService<br>MainBLService<br>AdminBLService | 客户端展示层   | 客户端业务逻辑层 |
| CustomerDataService<br>StockDataService<br>SystemDataService<br>BillDataService<br>CommodityDataService | 客户端业务逻辑层 | 服务器端数据层  |



### <a name="5.2"></a>5.2用户界面层的分解

根据需求，系统存在40个界面： 登录界面、系统管理员主界面、库存管理人员主界面、进货销售人员主界面、财务管理人员主界面、总经理主界面、客户管理界面、增加客户界面、修改客户属性界面、删除客户界面、制定进货单界面、制定进货退货单界面、制定销售单界面、制定销售退货单界面、商品管理界面、增加商品界面、删除商品界面、修改商品界面、商品分类管理界面、增加商品分类界面、修改商品分类界面、删除商品分类界面、制定库存赠送单界面、制定库存报损单界面、库存查看界面、库存盘点界面、账户管理界面、查看导出报表界面、查看经营情况表界面[财]、查看销售历程表界面[财]、查看销售明细表界面[财]、期初建账界面、查询单据界面、查看经营情况表界面[总]、查看销售历程表界面[总]、查看销售明细表界面[总]、审批单据界面、制定促销策略界面、查看日志界面、用户管理界面。

PS: [总]指该界面针对总经理，[财]指该界面针对财务管理人员。

![用户界面跳转](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E7%94%A8%E6%88%B7%E7%95%8C%E9%9D%A2%E8%B7%B3%E8%BD%AC.png)

图5.2-1 用户界面跳转

服务器端和客户端的用户界面设计接口是一致的，只是具体的页面不一样。用户界面如图5.2-2所示。

#### 5.2.1 用户界面层模块的职责<a name="5.2.1"></a> 

表5.2.1-1所示为用户界面层模块的职责。

| 模块     | 职责                    |
| ------ | --------------------- |
| MainUI | 界面Frame，负责界面的显示和界面的跳转 |

#### 5.2.2 用户界面层模块的接口规范<a name="5.2.2"></a> 

用户界面层模块的接口规范如表5.2.2-1所示

| MainUI | 语法   |                     |
| ------ | ---- | ------------------- |
|        | 前置条件 | 无                   |
|        | 后置条件 | 显示Frame以及LoginPanel |

用户界面层需要的服务接口如表5.2.2-2所示

| 服务名  | 服务   |
| ---- | ---- |
|      |      |
|      |      |

#### 5.2.3 用户界面模块设计原理<a name="5.2.3"></a> 

用户界面利用JavaFX来实现。



### <a name="5.3"></a> 5.3业务逻辑层的分解<br>

业务逻辑层包括多个针对界面的业务逻辑处理对象

#### 5.3.1 业务逻辑层模块的职责<br>

业务逻辑层模块的职责如表5.3.1-1所示

##### 表 5.3.1-1 业务逻辑层模块的职责<br>

| fiancebl | 负责实现财务人员界面所需要的服务   |
| -------- | ------------------ |
| mainbl   | 负责实现登陆界面所需要的服务     |
| adminbl  | 负责实现系统管理人员界面所需要的服务 |



#### 5.3.2-2 stocksellerbl模块的接口规范

名词解释：

DAE: Default Account Executive, 默认业务员

<center>**表1 stockmanagerbl模块的接口规范**

**提供的服务（供接口）**</center>

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| StockManangerBLService.addCommodity      | 语法   | public ResultMessage addCommodity(String ID,String name, String type) |
|                                          | 前置条件 | 用户输入正确的商品信息                              |
|                                          | 后置条件 | 返回添加成功与否，如果用户输入了非法信息，则抛出异常信息             |
| StockManangerBLService.ModifyCommodity   | 语法   | public ReusultMessage modifyCommodity(String ID,String name,String type) |
|                                          | 前置条件 | 用户输入正确的商品信息                              |
|                                          | 后置条件 | 返回修改成功与否，如果用户输入了非法信息，则抛出异常信息             |
| StockManagerBLService.DeleteCommodity    | 语法   | public ResultMessage deleteCommodity(CommodityVO comdity_vo) |
|                                          | 前置条件 | 用户选择了合适的商品                               |
|                                          | 后置条件 | 返回删除成功与否，如果非法则抛出异常信息                     |
| StockManagerBLService.SearchCommodity    | 语法   | public ArrayList< CommodityVO >  searchCommodity(Filter flags) |
|                                          | 前置条件 | 客户选择合适的筛选条件                              |
|                                          | 后置条件 | 返回符合条件的商品信息列表，如果没有符合条件的商品，返回空列表          |
| StockManagerBLService.getCommodity       | 语法   | public CommodityVO getCommodity(String ID) |
|                                          | 前置条件 | 用户输入了正确的信息                               |
|                                          | 后置条件 | 返回用户指定的商品信息                              |
| StockManagerBLService.AddClassification  | 语法   | public ResultMessage addClassification(String parentID, String name) |
|                                          | 前置条件 | 用户输入正确的信息                                |
|                                          | 后置条件 | 返回添加成功与否，如果用户输入的信息非法，则抛出异常信息             |
| StockManagerBLService.DeleteClassification | 语法   | public ResultMessage deleteClassification(String ID) |
|                                          | 前置条件 | 用户输入了正确的信息                               |
|                                          | 后置条件 | 返回删除成功与否，如果用户输入的信息非法，则抛出异常信息             |
| StockManagerBLService.ModifyClassification | 语法   | public ResultMessage modifyClassification(String ID,String newParentID,String newName) |
|                                          | 前置条件 | 用户输入了正确的信息                               |
|                                          | 后置条件 | 返回修改成功与否，如果输入的信息非法，则抛出异常信息               |
| StockManagerBLService.GetClassifications | 语法   | public Tree< ClassificationVO > getClassifications() |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回已有的商品分类树，如果暂未有商品分类，则返回空树               |
| StockManagerBLService.ViewStock          | 语法   | public ArrayList< StockVO > viewStock(String startName, String endName) |
|                                          | 前置条件 | 用户输入了正确的时间点                              |
|                                          | 后置条件 | 返回时间段内的库存信息，若无库存信息则返回空列表，若输入信息异常则抛出非法信息  |
| StockManagerBLservice.InventoryCheck     | 语法   | public ArrayList< InventoryVO> inventoryCheck() |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回当天的库存快照，若无则返回空列表                       |
| StockManagerBLService.LossAndOverflowReport | 语法   | public ResultMessage makeLossAndOverflowReport(ArrayList < CommodityVO> commodityVO, ArrayList< Integer> numbers) |
|                                          | 前置条件 | 用户输入了正确的信息                               |
|                                          | 后置条件 | 返回是否产生库存报损报溢单，若输入信息 非法，则抛出异常信息           |
| StockManagerBLService.PresentationReport | 语法   | public ResultMessage makePresentationReport(ArrayList< CommodityVO> commodity,ArrayList< Integer> numbers) |
|                                          | 前置条件 | 用户输入了正确的信息                               |
|                                          | 后置条件 | 返回是否产生库存赠送单，若输入信息非法，则抛出非法信息              |
| StockManagerBLService.AlarmReport        | 语法   | public ResultMessage dealAlarmReport(AlarmReportVO report) |
|                                          | 前置条件 | 选择正确的库存报警单                               |
|                                          | 后置条件 | 返回是否正确处理库存报警单，若非法则抛出非法信息                 |

<center>**需要的服务（需接口）**</center>

| 服务名                                      | 服务               |
| ---------------------------------------- | ---------------- |
| CommodityService.AddCommodity            | 新增商品存入数据库        |
| CommodityService.DeleteCommodity         | 删除数据库中的已有商品      |
| CommodityService.ModifyCommodity         | 修改商品的信息          |
| CommodityService.SearchCommodity         | 搜索商品             |
| StockDataService.getStockInfo            | 得到某商品的库存信息       |
| StockDataService.getAllStockInfo         | 得到所有商品的库存信息      |
| BillDataService.MakeLossAndOverflowReport | 将新增的库存报损报溢单存入数据库 |
| BillDataService.MakePresentationReport   | 将新增的库存赠送单存入数据库   |
| BillDataService.DealAlarmReport          | 处理已存的库存报警单       |
| CommodityService.AddClassification       | 新增商品分类           |
| CommodityService.ModifyClassification    | 修改商品分类           |
| CommodityService.DeleteClassification    | 删除商品分类           |



表2 stocksellerbl模块的接口规范

****提供的服务（供接口）****

| 服务名                                 | 服务   | 服务                                       |
| ----------------------------------- | ---- | ---------------------------------------- |
| StockSellerBLService.searchCustomer | 语法   | public ArrayList< CustomerVO > searchCustomer(String keytype, String keyword); |
|                                     | 前置条件 | 输入的关键词合法                                 |
|                                     | 后置条件 | 如果系统里有符合条件的客户，返回true，否则返回false           |
| StockSellerBLService.getCustomer    | 语法   | public CustomerVO getCustomer(String ID); |
|                                     | 前置条件 | 输入的客户编号符合规范                              |
|                                     | 后置条件 | 如果系统中有该客户，返回该客户的属性。否则返回null              |
| StockSellerBLService.addCustomer    | 语法   | public boolean addCustomer(String ID, String category, int level, String name, String tele, String address, String postcode, String email, double InValue, double in, double out, String DAE); |
|                                     | 前置条件 | 输入的信息符合规范                                |
|                                     | 后置条件 | 系统新建一个客户，并提示新建成功                         |
| StockSellerBLService.delCustomer    | 语法   | public boolean delCustomer(String ID);   |
|                                     | 前置条件 | 需要删除的用户存在于系统中                            |
|                                     | 后置条件 | 删除用户，返回true                              |
| StockSellerBLService.ModifyCustomer | 语法   | public boolean ModifyCustomer(String ID, String category, int level, String name, String tele, String address, String postcode, String email, double InValue); |
|                                     | 前置条件 | 输入的信息符合规范                                |
|                                     | 后置条件 | 系统修改该客户的属性，并返回true                       |
|                                     |      |                                          |

| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| StockSellerBLService.createPurchaseList  | 语法   | public boolean createPurchaseList (CustomerVO supplier, String store, String worker, ArrayList< CommodityVO > prolist, double sum, String remark); |
|                                          | 前置条件 | 输入的信息符合规范                                |
|                                          | 后置条件 | 生成进货单，返回true，提示生成成功                      |
| StockSellerBLService.createPurchaseReturnList | 语法   | public boolean createPurchaseReturnList (CustomerVO supplier, String store, String worker, ArrayList< CommodityVO > prolist, double sum, String remark); |
|                                          | 前置条件 | 输入的信息符合规范                                |
|                                          | 后置条件 | 生成进货退货单，返回true，提示生成成功                    |
| StockSellerBLService.createSalesList     | 语法   | public boolean createSalesList(CustomerVO saler, String DAE, String worker, String store, ArrayList< CommodityVO > prolist, double befSum, double discount, double vocher, double aftSum, String remark); |
|                                          | 前置条件 | 输入的信息符合规范                                |
|                                          | 后置条件 | 生成销售单，返回true，提示生成成功                      |
| StockSellerBLService.createSalesReturnList | 语法   | public boolean createSalesReturnList (CustomerVO saler, String DAE, String worker, String store, ArrayList< CommodityVO > prolist, double befSum, double discount, double vocher, double aftSum, String remark); |
|                                          | 前置条件 | 输入的信息符合规范                                |
|                                          | 后置条件 | 生成销售退货单，返回true，提示生成成功                    |

**需要的服务（供接口）**

| 服务名                                      | 服务      |
| ---------------------------------------- | ------- |
| CustomerDataService.addCustomer          | 增加客户    |
| CustomerDataService.delCustomer          | 删除客户    |
| CustomerDataService.modifyCustomer       | 修改客户属性  |
| CustomerDataService.getCustomerInfo      | 得到客户属性  |
| CommodityDataService.getCommodityInfo    | 得到商品属性  |
| BillDataService.createPurchaseList       | 创建进货单   |
| BillDataService.createPurchaseReturnList | 创建进货退货单 |
| BillDataService.createSalesList          | 创建销售单   |
| BillDataService.createSalesReturnList    | 创建销售退货单 |

表3 ChiefManagerbl模块的接口规范

| 提供的服务（供接口）                               |                         |                                          |
| ---------------------------------------- | ----------------------- | ---------------------------------------- |
| ChiefManagerBLService.checkLimit         | 语法                      | public boolean checkLimit(int id,String serviceType); |
| 前置条件                                     | 用户已经成功登陆                |                                          |
| 后置条件                                     | 返回一个布尔值表示用户是否有使用申请功能的权限 |                                          |
| ChiefManagerBLService.exportList         | 语法                      | public void exportList(ListVO listVO);   |
| 前置条件                                     | 有符合条件的表单                |                                          |
| 后置条件                                     | 导出excel格式的表单            |                                          |
| ChiefManagerBLService.emptyCondition     | 语法                      | public void emptyCondition();            |
| 前置条件                                     | 用户有搜索销售明细表的权限           |                                          |
| 后置条件                                     | 清空用户输入的搜索条件             |                                          |
| ChiefManagerBLService.exit               | 语法                      | public void exit();                      |
| 前置条件                                     | 用户位于具体功能界面              |                                          |
| 后置条件                                     | 系统返回总经理登陆后的起始界面         |                                          |
| ChiefManagerBLService.makeSalesList      | 语法                      | public SalesListVO makeSalesList(String time,String commodityName, String customerName, String salesmanName,String warehouseName ); |
| 前置条件                                     | 用户有查看销售明细表的权限           |                                          |
| 后置条件                                     | 返回用户要求的销售明细表            |                                          |
| ChiefManagerBLService.makeManageList     | 语法                      | public ManageListVO makeManageList(String time); |
| 前置条件                                     | 用户有查看经营情况表的权限           |                                          |
| 后置条件                                     | 返回用户要求的经营情况表            |                                          |
| ChiefManagerBLService.showLogList        | 语法                      | public LogListVO showLogList();          |
| 前置条件                                     | 用户有查询日志的权限              |                                          |
| 后置条件                                     | 返回系统日志列表                |                                          |
| ChiefManagerBLService.showLogDetail      | 语法                      | public LogVO showLogDetail(int id);      |
| 前置条件                                     | 用户有查询日志的权限              |                                          |
| 后置条件                                     | 返回该条日志的详细信息             |                                          |
| ChiefManagerBLService.showBillList       | 语法                      | public BillListVO showBillList(String isExamined)； |
| 前置条件                                     | 用户有审批单据的权限              |                                          |
| 后置条件                                     | 返回待审批单据列表               |                                          |
| ChiefManagerBLService.changeBillState    | 语法                      | public void changeBillState(ArrayList<BillVO> billVOArray),boolean pass); |
| 前置条件                                     | 待审批单据列表不为空              |                                          |
| 后置条件                                     | 改变单据的审批状态为批准或不批准        |                                          |
| ChiefManagerBLService.updateBillData     | 语法                      | public void updateBillData(ArrayList<BillVO billVOArray>); |
| 前置条件                                     | 有单据被审批                  |                                          |
| 后置条件                                     | 将审批后的单据信息更新到数据库中        |                                          |
| ChiefManagerBLService.sendMessage        |                         |                                          |
| ChiefManagerBLService.showBillDetail     | 语法                      | public BillVO showBillDetail(int id);    |
| 前置条件                                     | 待审批单据列表不为空              |                                          |
| 后置条件                                     | 返回一张单据的详细内容             |                                          |
| ChiefManagerBLService.choosePromotionType | 语法                      | public PromotionVO choosePromotionType(String type); |
| 前置条件                                     | 用户有权限制定促销策略             |                                          |
| 后置条件                                     | 返回类型对应的VO               |                                          |
| ChiefManagerBLService.setPromotionTime   | 语法                      | public PromotionVO setPromotionTime(PromotionVO promotionVO); |
| 前置条件                                     | 用户有权限制定促销策略             |                                          |
| 后置条件                                     | 返回修改了起始时间的PromotionVo   |                                          |
| ChiefManagerBLService.checkPromotionInfo | 语法                      | public PromotionVO checkPromotionInfo(PromotionVO promotionVO) |
| 前置条件                                     | 用户有权限制定促销策略             |                                          |
| 后置条件                                     | 检查用户传入促销策略信息的正确性        |                                          |
| ChiefManagerBLService.ShowPromotionList  | 语法                      | public PromotionListVO ShowPromotionList(); |
| 前置条件                                     | 用户有权限制定促销策略             |                                          |
| 后置条件                                     | 显示当前存在的促销策略列表           |                                          |
| ChiefManagerBLService.updatePromotionInfo | 语法                      | public void updatePromotionInfo(PromotionVO promotionVO); |
| 前置条件                                     | 用户制定促销策略成功              |                                          |
| 后置条件                                     | 更新数据库中的促销策略信息           |                                          |
| 需要的服务（需接口）                               |                         |                                          |
| 服务名                                      | 服务                      |                                          |
| SystemData.userData.findUser             | 根据id查找对应的userPO         |                                          |
| BillDataService.findSaleBill             | 根据搜索条件查找对应的saleBillPP   |                                          |
| BillDataService.findBill                 | 查找符合条件的所有类型的单据PO        |                                          |
| SystemDataService.LogDataService.findLog | 根据ID查找对应的LogPO          |                                          |
| BillDataService.updateBill               | 改变BillPO中的数据            |                                          |
| SystemDataService.promotionDataService.find | 查找参数类型对应的所有PromotionPO  |                                          |

##### 表4 fiancebl模块的接口规范

| 提供的服务（接口）                    |      |                                          |
| ---------------------------- | ---- | ---------------------------------------- |
| AccountManger.addAccount     | 语法   | public  AccountStatus addAccount(Account account) |
|                              | 前置条件 | account已经被初始化且不存在同名账户                    |
|                              | 后置条件 | 返回账户管理操作的状态Enum类：AccountStatus           |
| AccountManager.deleteAccount | 语法   | public  AccountStatus deleteAccount(Account account) |
|                              | 前置条件 | account存在于账户列表，且必须已经初始化                  |
|                              | 后置条件 | 返回账户管理操作的状态Enum类：AccountStatus           |
| AccountManager.checkAccount  | 语法   | public  Account checkAccount(AccountPos position) |
|                              | 前置条件 | position必须被初始化                           |
|                              | 后置条件 | 返回账户目标账户或者抛出异常                           |
| AccountManager.modifyAccount | 语法   | public  AccountStatus modifyAccount(Account account) |
|                              | 前置条件 | account必须存在于账户列表，并且修改已经写入account         |
|                              | 后置条件 | 返回账户管理操作的状态Enum类：AccountStatus           |
| BillManager.checkIncomeBill  | 语法   | public IncomeBill checkIncomeBill(BillPos position) |
|                              | 前置条件 | position必须被初始化                           |
|                              | 后置条件 | 返回目标IncomeBill的对象或者抛出异常                  |
| BillManager.addIncomeBill    | 语法   | public BillStatus addIncomeBill(IncomeBill bill) |
|                              | 前置条件 | bill必须已经被初始化                             |
|                              | 后置条件 | 返回提交状态Enum类：BillStatus，提交表单              |
| ReceiptManager.addReceipt    | 语法   | public BillStatus addReceipt(Receipt receipt) |
|                              | 前置条件 | receipt必须被初始化                            |
|                              | 后置条件 | 返回提交状态Enum类：BillStatus，提交表单              |
| AccountInitializer.init      | 语法   | Public InitStatus Initialize(InitAccount initaccount) |
|                              | 前置条件 | initaccount必须格式正确并且被初始化                  |
|                              | 后置条件 | 返回初始化状态Enum类：InitStatus，保存账户             |
| AccountInitializer.check     | 语法   | Public InitAccount Initialize(InitAccountPos positon) |
|                              | 前置条件 | position必须已经被初始化                         |
|                              | 后置条件 | 返回期初建账的账户信息                              |
| BPTManager.check             | 语法   | Public BussinessProcessTable check(BPTPos position) |
|                              | 前置条件 | position必须已经被初始化                         |
|                              | 后置条件 | 返回对应经营历程表                                |
| BPTManger.export             | 语法   | Public boolean export(BussinuessProcessTable table) |
|                              | 前置条件 | table必须在表单列表中                            |
|                              | 后置条件 | 导出表单并且返回boolean表示是否导出成功                  |
| BPTManager.hotfrog           | 语法   | public BillStatus hotfrog(Bill bill)     |
|                              | 前置条件 | bill必须已经被初始化                             |
|                              | 后置条件 | 返回单据状态的Enum类：BillStatus                  |

| 需要的服务（需接口）                               |                         |
| ---------------------------------------- | ----------------------- |
| 服务名                                      | 服务                      |
| BillDataService.add(BillPO)              | 在数据库中插入BillPO对象         |
| BillDataService.serch(BillIndex index)   | 在数据库中搜索以index为索引的BillPO |
| BillDataService.change(BillIndex,Bill)   | 修改数据库中以index为索引的BillPO  |
| BillDataService.delete(BillIndex)        | 删除数据库中以index为索引的BillPO  |
| SystemDataService.addInitInfo(InitAccountPO) | 在数据库中插入InitAccountPO    |
| SystemDataService.checkInitInfo()        | 在数据库中搜索相关初始化信息          |
| SystemDataService.addLog()               | 在数据库中插入日志               |

### <a name="5.4"></a>5.4数据层的分解

#### 5.4.1 数据层模块的职责

| 模块                    | 职责                                      |
| --------------------- | --------------------------------------- |
| SystemDataService     | 系统持久化数据库的接口，提供集体载入，集体保存，增，删，改，查服务       |
| SystemDataTxtFileImpl | 基于txt文件的持久化数据库的接口，提供集体载入，集体保存，增，删，改，查服务 |
|                       |                                         |



#### 5.4.2 数据层模块的接口规范<br>

表1 SystemDataService模块的接口规范

| 提供的服务（供接口）                        |      |                                          |
| --------------------------------- | ---- | ---------------------------------------- |
| SystemDataService.findUser        | 语法   | public UserPO findUser(long id) throws RemoteException |
|                                   | 前置条件 | id存在于用户数据中                               |
|                                   | 后置条件 | 返回该id对应的UserPo，或者抛出异常：RemoteException    |
| SystemDataService.deleteUser      | 语法   | public POStatus deleteUser(long id) throws RemoteException |
|                                   | 前置条件 | 无                                        |
|                                   | 后置条件 | 返回数据状态Enum类：POStatus，或者抛出异常：RemoteException，删除数据 |
| SystemDataService.addUser         | 语法   | public POStatus addUser(UserPO newuser) throws RemoteException |
|                                   | 前置条件 | newuser必须被初始化                            |
|                                   | 后置条件 | 返回数据状态Enum类：POStatus，或者抛出异常：RemoteException，保存新用户 |
| SystemDataService.updateUser      | 语法   | public POStatus updateUser(UserPO user) throws RemoteException |
|                                   | 前置条件 | user必须以及被初始化                             |
|                                   | 后置条件 | 返回数据状态Enum类：POStatus，或者抛出异常：RemoteException，更新系统数据 |
| SystemDataSerive.addInitInfo()    | 语法   | public POStatus addInitInfo(InitAccountPO initaccount) throws RemoteException |
|                                   | 前置条件 | 无                                        |
|                                   | 后置条件 | 返回数据状态Enum类：POStatus，或者抛出异常：RemoteException，保存初始化账户 |
| SystemDataService.addLog()        | 语法   | public POStatus addLog(LogPO log) throws RemoteException |
|                                   | 前置条件 | 无                                        |
|                                   | 后置条件 | 返回数据状态Enum类：POStatus，或者抛出异常：RemoteException，保存日志 |
| SystemDataService.checkInitInfo() | 语法   | public InitAccountPO checkInitInfo(long index) throws RemoteException throws NullIndexException |
|                                   | 前置条件 | id必须存在于初始化信息列表中                          |
|                                   | 后置条件 | 返回对应InitAccountPO或者抛出异常:RemoteException ，或者NullIndexException(无效索引，空索引异常) |



### <a name="5.5"></a>5.5模块的关键类图

图5.5-1 stocksellerbl关键类图
![stcokmanagerl关键类图](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/stockmanagerlb%E5%85%B3%E9%94%AE%E7%B1%BB%E5%9B%BE.png)
![stocksellerbl关键类图](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/stocksellerbl%E5%85%B3%E9%94%AE%E7%B1%BB%E5%9B%BE.png)
图5.5-2 financebl关键类图<br>
![financebl](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/FinanceBl%E7%9A%84%E5%85%B3%E9%94%AE%E7%B1%BB%E5%9B%BE.png)
![ChiefManagerbl关键类图](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/ChiefManagerBL关键类图.png)



## <a name="6"></a> 6 信息视角

### <a name="6.1"></a> 6.1 数据的持久化对象

系统的 PO 类就是对应的相关的实体类，在此只做简单的的介绍。

<<<<<<< HEAD
| 类名               | 属性                                       |
| ---------------- | ---------------------------------------- |
| CustomerPO       | 客户编号、分类、级别、姓名、电话、地址、邮编、电子邮箱、应收额度、应收、应付、默认业务员 |
| PurchasePO       | 单据编号、供应商、仓库、操作员、入库商品列表、总额合计、备注           |
| SalesPO          | 单据编号、客户、默认业务员、操作员、仓库、出货商品清单、折让前总额、折让、代金券、折让后总额、备注 |
| CommodityPO      | 商品编号、名称、型号、库存数量、进价、零售价、最近进价、最近零售价        |
| ClassificationPO | 商品分类编号、名称、父分类                            |
| InventoryPO      | 各种商品的名称、型号，库存数量，库存均价，批次，批号，出厂日期          |
| StockPO          | 出/入库数量/金额，销售/进货的数量/金额                    |
|                  |                                          |
|                  |                                          |
=======
| 类名          | 属性                                       |
| ----------- | ---------------------------------------- |
| CustomerPO  | 客户编号、分类、级别、姓名、电话、地址、邮编、电子邮箱、应收额度、应收、应付、默认业务员 |
| PurchasePO  | 单据编号、供应商、仓库、操作员、入库商品列表、总额合计、备注           |
| SalesPO     | 单据编号、客户、默认业务员、操作员、仓库、出货商品清单、折让前总额、折让、代金券、折让后总额、备注 |
| CommodityPO | 商品编号、名称、型号、单价、备注                         |
| LogPO       | 操作人员、操作时间、操作类型、金额、库存、商品                  |
| UserPO      | 用户ID、密码、姓名、职位、权限                         |
|             |                                          |
|             |                                          |
|             |                                          |
>>>>>>> 189ba189c52bc475758c4e89512023d2f7fe6023

### <a name="6.2"></a> 6.2  持久化格式



### <a name="6.3"></a> 6.3 数据库表

数据库中包含CustomerPO表、PurchasePO表、SalesPO表、CommodityPO表、LogPO表、UserPO表

<br>**名词解释**

DAE: Default Account Executive默认业务员

in 应收

out 应付

InValue 应收额度



<br>**数据库表结构（属性-数据类型）**

**CustomerPO**

| ID     | category | level | name   | telephone | address | postcode | email  | Invalue | in     | out    | DAE    |
| ------ | -------- | ----- | ------ | --------- | ------- | -------- | ------ | ------- | ------ | ------ | ------ |
| String | String   | int   | String | String    | String  | String   | String | double  | double | double | String |

**PurchasePO**

| ID     | supplier | store  | worker | prolist                  | sum    | remark |
| ------ | -------- | ------ | ------ | ------------------------ | ------ | ------ |
| String | String   | String | String | ArrayList< CommodityPO > | double | String |

**SalesPO**

| ID     | customer | DAE    | worker | store  | prolist                  | befSum | discount | vocher | aftSum | remark |
| ------ | -------- | ------ | ------ | ------ | ------------------------ | ------ | -------- | ------ | ------ | ------ |
| String | String   | String | String | String | ArrayList< CommodityPO > | double | double   | double | double | String |

**CommodityPO**

| ID     | name   | type   | price  | remark |      |
| ------ | ------ | ------ | ------ | ------ | ---- |
| String | String | String | double | String |      |

**LogPO**

| Operator | Time   | Kind   | money     | stock     | commodity |
| -------- | ------ | ------ | --------- | --------- | --------- |
| String   | String | String | long long | long long | string    |

##### **UserPO**

| ID   | Password | name   | Job    | Power |
| ---- | -------- | ------ | ------ | ----- |
| long | string   | string | string | int   |



