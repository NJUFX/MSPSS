![Image text](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E6%96%87%E6%A1%A3%E5%B0%81%E9%9D%A2/%E4%BD%93%E7%B3%BB%E7%BB%93%E6%9E%84%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3.png)
<br>
# 进销存系统

# <center>进销存管理系统</center>



# <center>MSPSS(Management System of Purchase-Sell-Stock)</center>





# <center> 体系结构设计文档</center>





# <center>v1.3 </center>

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

<a href="#5.3.1">5.3.1业务逻辑层模块的职责</a><br>

<a href="#5.3.2">5.3.2业务逻辑层模块的接口规范</a><br>

<a href="#5.4">5.4数据层的分解</a><br>

<a href="#5.4.1">5.4.1数据层模块的职责</a><br>

<a href="#5.4.2">5.4.2数据层模块的接口规范</a><br>

<a href="#5.5">5.5模块的关键类图</a><br>

<a href="#6">6.信息视角</a><br>

<a href="#6,1">6.1数据的持久化对象</a><br>

<a href="#6.2">6.2数据库表</a><br>



## <a name="geng"></a> 更新历史

| **修改人员** | **日期**     | **变更原因**                        | **版本号**  |
| -------- | ---------- | ------------------------------- | -------- |
| FX全组人员   | 2017-10-10 | 最初草稿                            | V1.0  草稿 |
| 伏家兴      | 2017-10-13 | 添加目录                            | V1.1     |
| 伏家兴      | 2017-10-16 | 添加stocksellerbl接口规范             | V1.2.1   |
| 韩新虎      | 2017-10-17 | 添加stockmanagerbl接口规范            | V1.2.2   |
| 徐光耀      | 2017-10-19 | 添加financebl接口规范和systemdata的接口规范 | V1.2.3   |
| 刘雅歆      | 2017-10-19 | 添加chiefmanagerbl接口规范            | V1.2.4   |
| 伏家兴      | 2017-10-19 | 整合文档格式                          | V1.3     |
| 刘雅歆      | 2017-10-20 | 修改了chiefmanagerbl接口规范           | V1.3.1   |
| 伏家兴      | 2017-10-21 | 添加了customerdata的接口规范            | V1.3.2   |
| FX全组人员   | 2017-11-10 | 重构                              | v1.4     |
| 伏家兴      | 2017-11-11 | 添加customerbl和userbl的接口规范和关键类图   | v1.,4.1  |
|          |            |                                 |          |
|          |            |                                 |          |
|          |            |                                 |          |
|          |            |                                 |          |



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
2. 《进销存管理系统MSPSS需求规格说明书 v1.0》
3. 丁二玉，刘钦.计算与软件工程（卷二）[M]机械工业出版社，2012：134—182
4. Frank Buschmann, Regine Meunier, Hans Rohnert, Peter Sommerlad,Micheael Stal.Pattern-Oriented Software Architecture Volume 1: A system of Patterns [M]机械工业出版社,2003 

## <a name="2"></a>2产品概述

 进销存管理系统是一个在线的销售企业管理系统，旨在提供各种功能来简化库存管理人员，销售人员，财务管理人员，总经理操作流程的应用程序。提高了企业员工处理普通业务的工作效率，方便了各个部门之间的联系，从而全面提高了工作效率和用户的满意程度。

## <a name="3"></a> 3 逻辑视角

进销存管理系统 MSPSS中 选择了分层体系结构风格将系统分为3层（展示层，业务逻辑层，数据层）能够很好地示意整个高层抽象。展示层包括GUI页面的实现，业务逻辑层包含业务逻辑处理的实现，数据层负责数据的持久化和访问。分层体系结构的逻辑视角和逻辑设计方案如图3-1  和图3-2  所示。

![逻辑视角](http://101.37.19.32:10080/FX/MSPSS/raw/8cd024f022c261554f2939cdf3a817a88b83198b/doc/img/%E5%88%86%E5%B1%82%E4%BD%93%E7%B3%BB%E7%BB%93%E6%9E%84%E7%9A%84%E9%80%BB%E8%BE%91%E8%A7%86%E8%A7%92.png)

<center> 图3-1 分层体系结构的逻辑视角</center>

![]()

​	<center> 图3-2 分层体系结构的逻辑设计方案</center>

## <a name="4"></a>4 组合视角

### <a name="4.1"></a> 4.1 开发包图

进销存管理系统MSPSS的最终开发包设计表如表4.1-1

<center> 表4.1-1 进销存管理系统MSPSS的最终开发包设计</center>

| 开发包图                      | 依赖的其他开发包       |
| ------------------------- | -------------- |
| main                      |                |
| userui                    |                |
| userblservice             |                |
| userbl                    |                |
| userdataservice           |                |
| userdata                  |                |
| logui                     |                |
| logblservice              |                |
| logbl                     |                |
| logdataservice            |                |
| logdata                   |                |
| stockui                   |                |
| stockblservice            |                |
| stockbl                   |                |
| stockdataservice          |                |
| stockdata                 |                |
| promotionui               |                |
| promotionblservice        |                |
| promotionbl               |                |
| promotiondataservice      |                |
| promotionservice          |                |
| tableui                   |                |
| tableblservice            |                |
| tablebl                   |                |
| billui                    |                |
| billblservice             |                |
| billbl                    |                |
| billdataservice           |                |
| billdata                  |                |
| commodityui               |                |
| commodityblservice        |                |
| commoditybl               |                |
| commoditydataservice      |                |
| commoditydata             |                |
| accountui                 |                |
| accountblservice          |                |
| accountbl                 |                |
| accountdataservice        |                |
| accountdata               |                |
| generalaccountui          |                |
| generalaccountblservice   |                |
| generalaccountbl          |                |
| generalaccountdataservice |                |
| generalaccountdata        |                |
| customerui                |                |
| customerblservice         |                |
| customerbl                |                |
| customerdataservice       |                |
| customerdata              |                |
| vo                        |                |
| po                        |                |
| utilitybl                 |                |
| 界面类库包                     | javafx         |
| Java RMI                  |                |
| databaseutility           | JDBC,hibernate |
|                           |                |
|                           |                |
|                           |                |
|                           |                |

进销存管理系统MSPSS客户端开发包如图4.1-1 所示，服务器端开发包图如图4.1-2所示

<center>图4.1-1 进销存管理系统MSPSS客户端开发包图</center>

![客户端开发包图]()



<center> 表4.1-2 进销存管理系统MSPSS服务器端逻辑包图</center>

![客户端图]()

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
| CommodityBLService<br>StockBLService<br>BillBLService<br>CustomerBLService<br>AccountBLService<br>UserBLService<br>LogBLService<br>GeneralAccountBLService<br>PromotionBLService<br>TableBLService<br> | 客户端展示层   | 客户端业务逻辑层 |
| CommodityDataService<br>StockDataService<br>BillDataService<br>CustomerDataService<br>AccountDataService<br>UserDataService<br>LogDataService<br>GeneralAccountDataService<br>PromotionDataService<br> | 客户端业务逻辑层 | 服务器端数据层  |

### <a name="5.2"></a>5.2用户界面层的分解

根据需求，系统存在40个界面： 登录界面、系统管理员主界面、库存管理人员主界面、进货销售人员主界面、财务管理人员主界面、总经理主界面、客户管理界面、增加客户界面、修改客户属性界面、删除客户界面、制定进货单界面、制定进货退货单界面、制定销售单界面、制定销售退货单界面、商品管理界面、增加商品界面、删除商品界面、修改商品界面、商品分类管理界面、增加商品分类界面、修改商品分类界面、删除商品分类界面、制定库存赠送单界面、制定库存报损单界面、库存查看界面、库存盘点界面、账户管理界面、查看导出报表界面、查看经营情况表界面[财]、查看销售历程表界面[财]、查看销售明细表界面[财]、期初建账界面、查询单据界面、查看经营情况表界面[总]、查看销售历程表界面[总]、查看销售明细表界面[总]、审批单据界面、制定促销策略界面、查看日志界面、用户管理界面。

PS: [总]指该界面针对总经理，[财]指该界面针对财务管理人员。

![用户界面跳转](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E7%94%A8%E6%88%B7%E7%95%8C%E9%9D%A2%E8%B7%B3%E8%BD%AC.png)

图5.2-1 用户界面跳转

服务器端和客户端的用户界面设计接口是一致的，只是具体的页面不一样。用户界面如图5.2-2所示。



![yonghu](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E7%94%A8%E6%88%B7%E7%95%8C%E9%9D%A2%E7%B1%BB.png)

图5.2-2 用户界面类

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

| 服务名                                 | 服务               |
| ----------------------------------- | ---------------- |
| BusinessLogicService.LoginBLService | 登录界面的业务逻辑口       |
| BusinessLogicService.*BLService     | 每个界面都有一个相应的业务逻辑口 |

#### 5.2.3 用户界面模块设计原理<a name="5.2.3"></a> 

用户界面利用JavaFX来实现。

### <a name="5.3"></a> 5.3业务逻辑层的分解<br>

业务逻辑层包括多个针对界面的业务逻辑处理对象，业务逻辑层的设计如图5.3-1所示



图5.3-1 业务逻辑层的设计

#### 5.3.1 业务逻辑层模块的职责<a name="5.3.1"></a><br>

业务逻辑层模块的职责如表5.3.1-1所示

表 5.3.1-1 业务逻辑层模块的职责

| 模块         | 职责           |
| ---------- | ------------ |
| userbl     | 负责实现用户所需要的业务 |
| customerbl | 负责实现客户所需要的业务 |
|            |              |
|            |              |
|            |              |
|            |              |
|            |              |
|            |              |
|            |              |

#### 5.3.2 业务逻辑模块的接口规范<a name="5.3.2"></a><br>

表5.3.2-1 userbl模块的接口规范

提供的服务（供接口）

| 服务名                      | 服务   | 服务                                       |
| ------------------------ | ---- | ---------------------------------------- |
| UserBLService.login      | 语法   | public Log_In_Out_Status login(String ID, String password) |
|                          | 前置条件 | 用户处于未登录状态                                |
|                          | 后置条件 | 用户登陆                                     |
| UserBLService.logout     | 语法   | public Log_In_Out_Status logout(String ID) |
|                          | 前置条件 | 用户已登录                                    |
|                          | 后置条件 | 用户登出                                     |
| UserBLService.addUser    | 语法   | public ResultMessage addUser(UserVO);    |
|                          | 前置条件 | 输入的信息符合规范                                |
|                          | 后置条件 | 增加用户                                     |
| UserBLService.delUser    | 语法   | public ResultMessage delUser(String ID); |
|                          | 前置条件 | 输入的ID已存在                                 |
|                          | 后置条件 | 删除该用户                                    |
| UserBLService.modifyUser | 语法   | public ResultMessage modifyUser(UserVO); |
|                          | 前置条件 | 输入的信息符合规范                                |
| 输入的信息符合规范                | 后置条件 | 修改用户属性                                   |

需要的服务（需接口）

| 服务名  | 服务   |
| ---- | ---- |
|      |      |
|      |      |



### commoditybl的接口规范

**提供的服务供接口**

| 服务名                                     | 服务   | 服务                                       |
| --------------------------------------- | ---- | ---------------------------------------- |
| CommodityBLService.addCommodity         | 语法   | public ResultMessage addCommodity(CommodityVO  cmvo) |
|                                         | 前置条件 | 库存管理人员输入有效的新的商品                          |
|                                         | 后置条件 | 返回添加成功与否                                 |
| CommodityBLService.updateCommodity      | 语法   | public ReusultMessage updateCommodity(Commodity newCmvo) |
|                                         | 前置条件 | 库存管理人员要求更新商品信息                           |
|                                         | 后置条件 | 系统修改制定的商品信息，并返回结果                        |
| CommodityBLService.deleteCommodity      | 语法   | public ResultMessage deleteCommodity(String ID) |
|                                         | 前置条件 | 用户选择了合适的商品                               |
|                                         | 后置条件 | 返回删除成功与否，如果非法则抛出异常信息                     |
| CommodityBLService.searchCommodity      | 语法   | public Iterator< CommodityVO >  searchCommodity(Filter flags) |
|                                         | 前置条件 | 客户选择合适的筛选条件                              |
|                                         | 后置条件 | 返回符合条件的商品信息列表，如果没有符合条件的商品，返回空列表          |
| CommodityBLService.getCommodity         | 语法   | public CommodityVO getCommodity(String ID) |
|                                         | 前置条件 | 用户输入了正确的信息                               |
|                                         | 后置条件 | 返回用户指定的商品信息                              |
| CommodityBLInfo.getCommodity            | 语法   | public CommodityVO getCommodity(String ID) |
|                                         | 前置条件 | 用户输入了正确的信息                               |
|                                         | 后置添加 | 返回商品信息                                   |
| CommodityBLService.AddClassification    | 语法   | public ResultMessage addClassification(ClassifictaionVO clvo) |
|                                         | 前置条件 | 用户输入正确的信息                                |
|                                         | 后置条件 | 返回添加成功与否，如果用户输入的信息非法，则抛出异常信息             |
| CommodityBLService.DeleteClassification | 语法   | public ResultMessage deleteClassification(String ID) |
|                                         | 前置条件 | 用户输入了正确的商品分类信息                           |
|                                         | 后置条件 | 返回删除成功与否，如果用户输入的信息非法，则抛出异常信息             |
| CommodityBLService.updateClassification | 语法   | public ResultMessage updateClassification(ClassifictionVO clvo) |
|                                         | 前置条件 | 用户输入了正确的信息                               |
|                                         | 后置条件 | 返回修改成功与否，如果输入的信息非法，则抛出异常信息               |
| CommodityBLService.GetClassifications   | 语法   | public Iterator< ClassificationVO > getClassifications() |
|                                         | 前置条件 | 无                                        |
|                                         | 后置条件 | 返回已有的商品分类树，如果暂未有商品分类，则返回空树               |
| CommodityBLService.getClassifictaion    | 语法   | public ClassificationVO getClassifiction(String ID) |
|                                         | 前置条件 | 用户输入正确的商品分类编号                            |
|                                         | 后置条件 | 返回已有的商品分类，否则抛出异常                         |

<center>**需要的服务（需接口）**</center>

| 服务名                                      | 服务              |
| ---------------------------------------- | --------------- |
| CommodityDataService.AddCommodity        | 新增商品            |
| CommodityDataService.DeleteCommodity     | 删除商品            |
| CommodityDataService.updateCommodity     | 更新商品信息          |
| CommodityDataService.getCommodity        | 通过商品ID得到商品      |
| CommodityDataService.exactlySearchCommodity | 精确搜索商品          |
| CommodityDataService.prefixSearchCommodity | 前缀搜索商品          |
| CommodityDataService.fullSearchCommodity | 完全匹配商品          |
| CommodityDataService.fuzzySearchCommodity | 模糊搜索商品          |
| CommodityDataService.rangeSearchCommodity | 范围搜索商品          |
| CommodityDataService.AddClassification   | 新增商品分类          |
| CommodityDataService.updateClassification | 修改商品分类          |
| CommodityDataService.DeleteClassification | 删除商品分类          |
| CommodityDataService.getClassification   | 通过商品分类ID来获得商品分类 |

### stockbl的接口规范

**提供的服务供接口**

| 服务名                                 | 服务   | 服务                                       |
| ----------------------------------- | ---- | ---------------------------------------- |
| StockBLService.ViewStock            | 语法   | public ArrayList< StockVO > viewStock(String startTime, String endTime) |
|                                     | 前置条件 | 用户输入了正确的时间点                              |
|                                     | 后置条件 | 返回时间段内的库存信息，若无库存信息则返回空列表，若输入信息异常则抛出非法信息  |
| StockBLservice.InventoryCheck       | 语法   | public ArrayList< InventoryVO> inventoryCheck() |
|                                     | 前置条件 | 无                                        |
|                                     | 后置条件 | 返回当天的库存快照，若无则返回空列表                       |
| StockBLInfo.updateStockAndInventory | 语法   | public ResultMessage updateStockAndInventory(BillVO bvo) |
|                                     | 前置条件 | 单据得到审批                                   |
|                                     | 后置条件 | 更新库存信息                                   |

<center>**需要的服务（需接口）**</center>

| 服务名                             | 服务         |
| ------------------------------- | ---------- |
| CommodityBLInfo.updateCommodity | 更新商品的库存数量  |
| StockDataService.addInventory   | 更新商品的库存信息  |
| StockDataService.addStock       | 更新商品的进出库记录 |
|                                 |            |



### billbl的接口规范

**提供的服务（供接口）**

| 服务名                                     | 服务   | 服务                                       |
| --------------------------------------- | ---- | ---------------------------------------- |
| BillBLService.makeLessOrMoreBill        | 语法   | public ResultMessage makeLessOrMoreBill(LessOrMoreBillVO lombvo ) |
|                                         | 前置条件 | 用户输入了正确的信息                               |
|                                         | 后置条件 | 返回是否产生库存报损报溢单，若输入信息 非法，则抛出异常信息           |
| BillBLService.makePresentationBill      | 语法   | public ResultMessage makePresentationBill(PresentBillVO  pbvo) |
|                                         | 前置条件 | 用户输入了正确的信息                               |
|                                         | 后置条件 | 返回是否产生库存赠送单，若输入信息非法，则抛出非法信息              |
| BillBLService.getAlarmBills             | 语法   | public ArrayList< AlarmBillVO > getAlarmBills() |
|                                         | 前置条件 | 库存管理人员要查看库存报警单                           |
|                                         | 后置条件 | 返回库存报警单列表，若非法则抛出非法信息                     |
| BillBLInfo.makeAlarmBills               | 语法   | public ResultMessage makeAlarmBills(AlarmBillVO abvo) |
|                                         | 前置条件 | 库存发生变化到达警戒线                              |
|                                         | 后置条件 | 返回是否创建成功                                 |
| BillBLService.makePurchaseBill          | 语法   | public ResultMessage makePurchase(PurchaseVO purchase); |
|                                         | 前置条件 | 输入的信息符合规范                                |
|                                         | 后置条件 | 生成进货单，返回true，提示生成成功                      |
| BillBLService.makePurchaseReturnBill    | 语法   | public ResultMessage makePurchaseReturnBill (PurchaseVO puret); |
|                                         | 前置条件 | 输入的信息符合规范                                |
|                                         | 后置条件 | 生成进货退货单，返回true，提示生成成功                    |
| BillBLService.makeSalesBill             | 语法   | public ResultMessage makeSales(SalesVO salesvo); |
|                                         | 前置条件 | 输入的信息符合规范                                |
|                                         | 后置条件 | 生成销售单，返回true，提示生成成功                      |
| BillBLService.makeSalesReturnBill       | 语法   | public ResultMessage makesSalesReturnBill(SalesPO saleret); |
|                                         | 前置条件 | 输入的信息符合规范                                |
|                                         | 后置条件 | 生成销售退货单，返回true，提示生成成功                    |
| BillBLService.makePaymentAndReceiptBill | 语法   | public ResultMessage makePaymentAndReceiptBill(PaymentAndReceiptBill  parvo) |
|                                         | 前置条件 | 财务人员想要制定付款单或付款单                          |
|                                         | 后置条件 | 返回是否制定成功，更新数据库                           |
| BillBLService.makeCashBill              | 语法   | public ResultMessage makeCashBill(CashBillVO cbvo) |
|                                         | 前置条件 | 财务人员想要制定现金费用单                            |
|                                         | 后置条件 | 返回是否制定成功                                 |
| BillBLService.getBills                  | 语法   | public ArrayList<BillVO> getBills()      |
|                                         | 前置条件 | 总经理想要查看所有的单据                             |
|                                         | 后置条件 | 返回已有的单据列表                                |

需接口

| 服务名                                      | 服务               |
| ---------------------------------------- | ---------------- |
| BillDataService.addLessOrMoreBill        | 添加库存报损报溢单        |
| BillDataService.updateLessOrMoreBill     | 更新库存报损报溢单        |
| BillDataService.getAllLessOrMoreBills    | 得到所有的库存报损报溢单     |
| BillDataService.getLessOrMoreBill        | 得到特定的库存报损报溢单     |
| BillDataService.getUndealtLessOrMoreBill | 得到所有的未处理的库存报损报溢单 |
| BillDataService.addPresentationBill      | 添加库存赠送单          |
| BillDataService.updatePresentationBill   | 更新库存赠送单          |
| BillDataService.getPresentationBill      | 得到特定的库存赠送单       |
| BillDataService.getAllPresentationBills  | 得到所有的库存赠送单       |
| BillDataService.getUndealtPresentationBill | 得到所有的未处理的库存报损报溢单 |
| BillDataService.addAlarmBill             | 添加库存报警单          |
| BillDataService.updateAlarmBill          | 更新库存报警单          |
| BillDataService.getAlarmBills            | 得到所有的库存报警单       |
| BillDataService.addPurchaseBill          | 添加进货单            |
| BillDataService.updatePurchaseBill       | 更新进货单            |
| BillDataService.getPurchaseBill          | 得到进货单            |
| BillDataService.addPurchaseReturnBill    | 添加进货退货单          |
| BillDataService.updatePurchaseReturnBill | 更新进货退货单          |
| BillDataService.getPurchaseReturnBill    | 得到退货单            |
| BillDataService.addSalesBill             | 添加销售单            |
| BillDataService.updateSalesBill          | 更新销售单            |
| BillDataService.getSalesBill             | 得到销售单            |
| BillDataService.addSalesReturnBill       | 添加销售退货单          |
| BillDataService.updateSalesReturnBill    | 更新销售退货单          |
| BillDataService.getSalesReturnBill       | 得到销售退货单          |
| BillDataService.addPaymentAndReceiptBill | 添加收款付款单          |
| BillDataService.updatePaymentAndReceiptBill | 更新收款付款单          |
| BillDataService.getPaymentAndReceiptBill | 得到收款付款单          |
| BillDataService.addCashBill              | 添加现金费用单          |
| BillDataService.updateCashBill           | 更新库存报警单          |
| BillDataService.getCashBill              | 得到现金费用单          |
| CommodityBLInfo.getCommodity             | 得到商品             |



### logbl的接口规范

| 服务名                        | 服务   | 服务                                       |
| -------------------------- | ---- | ---------------------------------------- |
| LogBLInfo.add              | 语法   | public ResultMessage add(LogPO logPO);   |
|                            | 前置条件 | 无                                        |
|                            | 后置条件 | Log Data里增添一条记录                          |
| LogBLService.search        | 语法   | public ArrayList<LogPO> search(Time date); |
|                            | 前置条件 | 无                                        |
|                            | 后置条件 | 返回存储LogPO的数组                             |
| LogBLService.showLogList   | 语法   | public LogListVO showLogList(ArrayList<LogPO> logList); |
|                            | 前置条件 | 无                                        |
|                            | 后置条件 | 返回日志列表VO                                 |
| LogBLService.showLogDetail | 语法   | public LogVO showLogDetail(LogPO logPO); |
|                            | 前置条件 | 无                                        |
|                            | 后置条件 | 返回日志VO                                   |

| 服务名                   | 服务             |
| --------------------- | -------------- |
| LogDataService.add    | 在日志数据中加入一个日志PO |
| LogDataService.search | 搜索符合条件的日志PO    |

### promotionbl的接口规范

| 服务名                       | 服务   | 服务                                       |
| ------------------------- | ---- | ---------------------------------------- |
| PromotionBLService.add    | 语法   | public ResultMessage add(Promotion PO promotionPO); |
|                           | 前置条件 | 无                                        |
|                           | 后置条件 | 促销策略数据中增加一条促销策略                          |
| PromotionBLService.delete | 语法   | public ResultMessage delete(String id);  |
|                           | 前置条件 | 无                                        |
|                           | 后置条件 | 删除一条促销策略                                 |
| PromotionBLService.update | 语法   | public ResultMessage update(String id,PromotionPO promotionPO); |
|                           | 前置条件 | 无                                        |
|                           | 后置条件 | 更新一条促销策略                                 |
| PromotionBLService.search | 语法   | public ArrayList<PromotionPO> search(Time date); |
|                           | 前置条件 | 无                                        |
|                           | 后置条件 | 返回所有有效的促销策略                              |
| PromotionBLInfo.search    | 语法   | public ArrayList<PromotionPO> search(Time date); |
|                           | 前置条件 | 无                                        |
|                           | 后置条件 | 返回所有有效的促销策略                              |

| 服务名                         | 服务               |
| --------------------------- | ---------------- |
| PromotionDataService.add    | 给促销策略数据中增加一个促销策略 |
| PromotionDataService.delete | 从促销策略数据中删除一个促销策略 |
| PromotionDataService.update | 更新一个促销策略         |
| PromotionDataService.search | 搜索所有有效的促销策略      |

### accountbl的接口规范

| 服务名                            | 服务   | 服务                                       |
| ------------------------------ | ---- | ---------------------------------------- |
| AccountBLService.addAccount    | 语法   | public ResultMessage addAccount(AccountVO account) |
|                                | 前置条件 | 无                                        |
|                                | 后置条件 | 返回增加账户的结果ResultMessage                   |
| AccountBLService.deleteAccount | 语法   | public ResultMessage deleteAccount(String name) |
|                                | 前置条件 | 无                                        |
|                                | 后置条件 | 返回删除账户的结果ResultMessage                   |
| AccountBLService.modifyAccount | 语法   | public ResultMesage modifyAccount(String old_account_name,String new_account_name) |
|                                | 前置条件 | 无                                        |
|                                | 后置条件 | 返回修改账户的结果ResultMessage                   |
| AccountBLService.checkAccount  | 语法   | public ArrayList<AccountVO> checkAccount(AccountFilterFlags flags) |
|                                | 前置条件 | 无                                        |
|                                | 后置条件 | 返回符合条件的AccountVO的ArrayList，不存在则返回空列表     |

| 服务名  | 服务   |
| ---- | ---- |
| 无    | 无    |

### generalaccountbl 的接口规范



| 服务名                                      | 服务   | 服务                                       |
| ---------------------------------------- | ---- | ---------------------------------------- |
| GeneralAccountBLService.newGeneralAccount | 语法   | public ResultMessage newGeneralAccount(GeneralAccountVO generalaccount) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回期初建账的结果ResultMessa                     |
| GeneralAccountBLService.check            | 语法   | public GeneralAccountVO check(Time begin,Time end) |
|                                          | 前置条件 | 无                                        |
|                                          | 后置条件 | 返回期初建账的信息，如果不存在，则返回空VO                   |

| 服务名  | 服务   |
| ---- | ---- |
|      |      |
|      |      |
|      |      |

### tablebl的接口规范

| 服务名                                | 服务   | 服务                                       |
| ---------------------------------- | ---- | ---------------------------------------- |
| TableBLService.checkSaleTable      | 语法   | public SaleTableVO checkSaleTable(SaleTableFilterFlags flags) |
|                                    | 前置条件 | 无                                        |
|                                    | 后置条件 | 返回对应的SaleTableVO                         |
| TableBLService.checkProcessTable   | 语法   | public ProcessTableVO checkProcessTable(ProcessTableFilterFlags flags) |
|                                    | 前置条件 | 无                                        |
|                                    | 后置条件 | 返回对应的ProcessTableVO                      |
| TableBLService.checkBusinessTable  | 语法   | public BusinessTableVO checkBusinessTable(BusinessTableFilterFlags flags) |
|                                    | 前置条件 | 无                                        |
|                                    | 后置条件 | 返回对应的BusinessTableVO                     |
| TableBLService.exportSaleTable     | 语法   | public void exportSaleTable(SaleTableVO saletable) |
|                                    | 前置条件 | 无                                        |
|                                    | 后置条件 | 无                                        |
| TableBLService.exportProcessTable  | 语法   | public void exportProcessTable(ProcessTableVO  processtable) |
|                                    | 前置条件 | 无                                        |
|                                    | 后置条件 | 无                                        |
| TableBLService.exportBusinessTable | 语法   | public void exportBusinessTable(BusinessTableVO businesstable) |
|                                    | 前置条件 | 无                                        |
|                                    | 后置条件 |                                          |

| 服务名  | 服务   |
| ---- | ---- |
|      |      |
|      |      |
|      |      |
|      |      |

表5.3.2- customerbl模块的接口规范

提供的服务（供接口）

| 服务名                               | 服务   | 服务                                       |
| --------------------------------- | ---- | ---------------------------------------- |
| CustomerBLService.addCustomer     | 语法   | public boolean addCustomer(CustomerVO customer) |
|                                   | 前置条件 | 输入的信息符合规范                                |
|                                   | 后置条件 | 系统新建一个客户，并提示新建成功                         |
| CustomerBLService.delCustomer     | 语法   | public boolean delCustomer(String ID);   |
|                                   | 前置条件 | 需要删除的用户存在于系统中                            |
|                                   | 后置条件 | 删除用户，返回true                              |
| CustomerBLService.modifyCustomer  | 语法   | public boolean ModifyCustomer(CustomerVO modCustomer); |
|                                   | 前置条件 | 输入的信息符合规范                                |
|                                   | 后置条件 | 系统修改该客户的属性，并返回true                       |
| CustomerBLService.getCustomerInfo | 语法   | public CustomerVO getCustomerInfo(String ID); |
|                                   | 前置条件 | 输入的客户编号符合规范                              |
|                                   | 后置条件 | 如果系统中有该客户，返回该客户的属性。否则返回null              |
| CustomerBLService.searchCustomer  | 语法   | public ArrayList< CustomerVO > searchCustomer(String keytype, String keyword); |
|                                   | 前置条件 | 输入的关键词合法                                 |
|                                   | 后置条件 | 如果系统里有符合条件的客户，返回true，否则返回false           |
|                                   |      |                                          |
|                                   |      |                                          |

需要的服务（需接口）

| 服务名  | 服务   |
| ---- | ---- |
|      |      |
|      |      |

### 5.4 数据层的分解

#### 5.4.1 数据层模块的职责

数据层主要给业务逻辑层提供数据访问服务，包括对数据库的增、删、改、 查。由于持久化数据的保存存在
多种形式:txt 文件、序列化文件、数据库，所以抽象了数据服务

#### 5.4.2 数据层模块的接口规范<a name="5.4.2"></a><br>

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

表2 CustomerDataServic模块的接口规范

| 服务名                                 | 服务   | 服务                                       |
| ----------------------------------- | ---- | ---------------------------------------- |
| CustomerDataService.addCustomer     | 语法   | public boolean addCustomer(CustomerPO customer); |
|                                     | 前置条件 | 无                                        |
|                                     | 后置条件 | 系统增加新的客户信息，更新数据                          |
| CustomerDataService.delCustomer     | 语法   | public boolean delCustomer(String ID);   |
|                                     | 前置条件 | 无                                        |
|                                     | 后置条件 | 系统删除该ID对应的客户，更新数据                        |
| CustomerDataService.getCustomerInfo | 语法   | public CustomerPO getCustomerInfo(String ID); |
|                                     | 前置条件 | 无                                        |
|                                     | 后置条件 | 返回该ID对应的客户PO                             |
| CustomerDataService.modifyCustomer  | 语法   | public boolean ModifyCustomer(CustomerPO customer); |
|                                     | 前置条件 | 无                                        |
|                                     | 后置条件 | 修改客户信息，更新数据                              |
|                                     |      |                                          |

表3 BillDataService模块的接口规范

| 提供的服务（供接口）             |                         |                                          |
| ---------------------- | ----------------------- | ---------------------------------------- |
| BillDataService.search | 语法                      | public ArrayList<BillPO> search(ConditionPO Condition); |
| 前置条件                   | 无                       |                                          |
| 后置条件                   | 返回符合条件的所有单据PO           |                                          |
| BillDataService.update | 语法                      | public void update(ArrayList<BillPO>);   |
| 前置条件                   | 数据库中中存在参数传入的BillPO      |                                          |
| 后置条件                   | BillPO的信息改为参数中BillPO的信息 |                                          |
| BillDataService.delete | 语法                      | public void delete(ArrayList<BillPO>);   |
| 前置条件                   | 数据库中存在参数传入的BillPO       |                                          |
| 后置条件                   | 数据库中移除相应的BillPO         |                                          |
| BillDataService.add    | 语法                      | public void add(ArrayList<BillPO>);      |
| 前置条件                   | 数据库中没有参数传入的PO           |                                          |
| 后置条件                   | 将参数传入的PO加入到数据库          |                                          |
|                        |                         |                                          |

表4 LogDataService模块的接口规范

| 提供的服务（供接口）            |      |                                          |
| --------------------- | ---- | ---------------------------------------- |
| 服务名                   | 服务   | 服务                                       |
| LogDataService.add    | 语法   | public  ResultMessage add(LogPO logPO)   |
|                       | 前置条件 | 无                                        |
|                       | 后置条件 | 日志数据里增加一条日志记录                            |
| LogDataService.search | 语法   | public ArrayList<LogPO> search (Time date); |
|                       | 前置条件 | 无                                        |
|                       | 后置条件 | 返回符合要求的日志PO数组                            |

表5 PromotionDataService模块的接口规范

| 提供的服务（供接口）                  |      |                                          |
| --------------------------- | ---- | ---------------------------------------- |
| 服务名                         | 服务   | 服务                                       |
| PromotionDataService.add    | 语法   | public ResultMessage add(PromotionPO promotionPO); |
|                             | 前置条件 | 无                                        |
|                             | 后置条件 | 促销策略数据中增加一条促销记录                          |
| PromotionDataService.delete | 语法   | public ResultMessage delete(String id);  |
|                             | 前置条件 | 无                                        |
|                             | 后置条件 | 删除促销策略ID对应的策略                            |
| PromotionDataService.update | 语法   | public ResultMessage update(PromotionPO promotionPO,String id); |
|                             | 前置条件 | 无                                        |
|                             | 后置条件 | 更新促销策略ID对应的策略                            |
| PromotionDataService.search | 语法   | public ArrayList<PromotionPO> search(Time date); |
|                             | 前置条件 | 无                                        |
|                             | 后置条件 | 返回日期范围内的所有促销策略                           |

### <a name="5.5"></a>5.5模块的关键类图

userbl关键类图

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/UserBL%E5%85%B3%E9%94%AE%E7%B1%BB%E5%9B%BE.png)

customerbl关键类图

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/CustomerBL%E5%85%B3%E9%94%AE%E7%B1%BB%E5%9B%BE.png)

## <a name="6"></a> 6 信息视角

### <a name="6.1"></a> 6.1 数据的持久化对象

系统的 PO 类就是对应的相关的实体类，在此只做简单的的介绍。

| 类名               | 属性                                       |
| ---------------- | ---------------------------------------- |
| CustomerPO       | 客户编号、分类、级别、姓名、电话、地址、邮编、电子邮箱、应收额度、应收、应付、默认业务员 |
| PurchasePO       | 单据编号、供应商、仓库、操作员、入库商品列表、总额合计、备注           |
| SalesPO          | 单据编号、客户、默认业务员、操作员、仓库、出货商品清单、折让前总额、折让、代金券、折让后总额、备注 |
| CommodityPO      | 商品编号、名称、型号、单价、备注                         |
| LogPO            | 操作人员、操作时间、操作类型、金额、库存、商品                  |
| UserPO           | 用户ID、密码、姓名、职位、权限                         |
| ClassificationPO | 商品分类编号、名称、父分类                            |
| InventoryPO      | 各种商品的名称、型号，库存数量，库存均价，批次，批号，出厂日期          |
| StockPO          | 出/入库数量/金额，销售/进货的数量/金额                    |
| PromotionPO      | 促销策略id，促销策略类型，促销策略信息列表（根据类型不同而变化，在构造函数中选择初始化），促销策略有效时间 |
### 6.2 数据库表<a name="6.3"></a>

数据库中包含CustomerPO表、PurchasePO表、SalesPO表、CommodityPO表、LogPO表、UserPO表、PromotionPO表

<br>**名词解释**

DAE: Default Account Executive默认业务员

InValue 应收额度

<br>**数据库表结构（属性-数据类型）**

**CustomerPO**

| ID     | kind             | level | name   | phonenumber | address | postcode | email  | Invalue | incomemoney | paymoney | bankaccount   | DAE    |
| ------ | ---------------- | ----- | ------ | ----------- | ------- | -------- | ------ | ------- | ----------- | -------- | ------------- | ------ |
| String | Kind_Of_Customer | int   | String | String      | String  | String   | String | double  | double      | double   | BankAccountPO | String |

**PurchasePO**

| ID     | supplier   | store  | worker | prolist                  | sum    | remark |
| ------ | ---------- | ------ | ------ | ------------------------ | ------ | ------ |
| String | CustomerPO | String | String | ArrayList< CommodityPO > | double | String |

**SalesPO**

| ID     | saler      | DAE    | worker | store  | prolist                  | befSum | discount | vocher | aftSum | remark |
| ------ | ---------- | ------ | ------ | ------ | ------------------------ | ------ | -------- | ------ | ------ | ------ |
| String | CustomerPO | String | String | String | ArrayList< CommodityPO > | double | double   | double | double | String |

**CommodityPO**

| ID     | name   | type   | impostcost | number | expostcost | latesrimpostcost | latestexpostcost |
| ------ | ------ | ------ | ---------- | ------ | ---------- | ---------------- | ---------------- |
| String | String | String | double     | int    | double     | double           | double           |

**LogPO**

| Operator | Time   | Kind   | money     | stock     | commodity |
| -------- | ------ | ------ | --------- | --------- | --------- |
| String   | String | String | long long | long long | string    |

**UserPO**

| ID   | Password | name   | Job    | Power |
| ---- | -------- | ------ | ------ | ----- |
| long | string   | string | string | int   |

**PromotionPO**

| ID     | Type   | InfoList | Time |      |
| ------ | ------ | -------- | ---- | ---- |
| String | String | String[] | Time |      |



