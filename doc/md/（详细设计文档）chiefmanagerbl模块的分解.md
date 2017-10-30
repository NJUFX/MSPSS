4.2 业务逻辑层的分解

4.2.1 chiefmanagerbl模块

(1)模块概述

chiefmanagerbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求

chiefmanagerbl模块的职责及接口参加软件系统结构描述文档

(2)整体结构

根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，我们会添加接口。比如展示层和业务逻辑层之间我们添加businesslogicservice.chiefmanegerblservice.chiefmanagerBLService接口。业务逻辑层和数据层之间添加dataservice.systemDataService接口和dataservice.billDataservice接口。为了隔离业务逻辑职责和逻辑控制职责，我们增加了List和Promotion对象，这样chiefmanagerblServiceImpl会将查看报表和制定促销策略的业务逻辑分别委托给List对象和Promotion对象。BillPO、ConditionPO、LogPO、SalesBillPO、PromotionPO是作为持久化对象被添加到设计模型中去的。

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

 promotion的接口规范

 

| 提供的服务（供接口）                               |                        |                                          |
| ---------------------------------------- | ---------------------- | ---------------------------------------- |
| Promotion.choosePromotionType            | 语法                     | public PromotionVO choosePromotionType(String type); |
| 前置条件                                     | 用户有权限制定促销策略            |                                          |
| 后置条件                                     | 返回类型对应的VO              |                                          |
| Promotion.setPromotionTime               | 语法                     | public PromotionVO setPromotionTime(PromotionVO promotionVO); |
| 前置条件                                     | 用户有权限制定促销策略            |                                          |
| 后置条件                                     | 返回修改了起始时间的PromotionVo  |                                          |
| Promotion.checkPromotionInfo             | 语法                     | public boolean checkPromotionInfo(PromotionVO promotionVO) |
| 前置条件                                     | 用户有权限制定促销策略            |                                          |
| 后置条件                                     | 检查用户传入促销策略信息的正确性       |                                          |
| Promotion.ShowPromotionList              | 语法                     | public PromotionListVO ShowPromotionList(); |
| 前置条件                                     | 用户有权限制定促销策略            |                                          |
| 后置条件                                     | 显示当前存在的促销策略列表          |                                          |
| Promotion.updatePromotionInfo            | 语法                     | public void updatePromotionInfo(PromotionVO promotionVO); |
| 前置条件                                     | 用户制定促销策略成功             |                                          |
| 后置条件                                     | 更新数据库中的促销策略信息          |                                          |
| 需要的服务（需接口）                               |                        |                                          |
| SystemDataService.promotionDataService.find | 查找参数类型对应的所有PromotionPO |                                          |
| SystemDataService.promotionDataService.insert | 插入参数类型对应的所有PromotionPO |                                          |