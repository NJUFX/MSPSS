5.3.2业务逻辑层模块的接口规范

**Chiefmanagerbl模块的接口规范**

| 提供的服务（供接口）                               |                         |                                          |
| ---------------------------------------- | ----------------------- | ---------------------------------------- |
| chiefmanagerblservice.checkLimit         | 语法                      | public boolean checkLimit(int id,String serviceType); |
| 前置条件                                     | 用户已经成功登陆                |                                          |
| 后置条件                                     | 返回一个布尔值表示用户是否有使用申请功能的权限 |                                          |
| chiefmanagerblservice.exportList         | 语法                      | public void exportList(ListVo listVo);   |
| 前置条件                                     | 有符合条件的表单                |                                          |
| 后置条件                                     | 导出excel格式的表单            |                                          |
| chiefmanagerblservice.emptyCondition     | 语法                      | public void emptyCondition();            |
| 前置条件                                     | 用户有搜索销售明细表的权限           |                                          |
| 后置条件                                     | 清空用户输入的搜索条件             |                                          |
| chiefmanagerblservice.exit               | 语法                      | public void exit();                      |
| 前置条件                                     | 用户位于具体功能界面              |                                          |
| 后置条件                                     | 系统返回总经理登陆后的起始界面         |                                          |
| chiefmanagerblservice.makeSalesList      | 语法                      | public salesListVo makeSalesList(String time,String commodityName, String customName, String salesmanName,String warehouseName ); |
| 前置条件                                     | 用户有查看销售明细表的权限           |                                          |
| 后置条件                                     | 返回用户要求的销售明细表            |                                          |
| chiefmanagerblservice.makeManageList     | 语法                      | public manageListVo makeManageList(String time); |
| 前置条件                                     | 用户有查看经营情况表的权限           |                                          |
| 后置条件                                     | 返回用户要求的经营情况表            |                                          |
| chiefmanagerblservice.showLogList        | 语法                      | public LogListVo showLogList();          |
| 前置条件                                     | 用户有查询日志的权限              |                                          |
| 后置条件                                     | 返回系统日志列表                |                                          |
| chiefmanagerblservice.showLogDetail      | 语法                      | public LogVo showLogDetail(int id);      |
| 前置条件                                     | 用户有查询日志的权限              |                                          |
| 后置条件                                     | 返回该条日志的详细信息             |                                          |
| chiefmanagerblservice.showBillList       | 语法                      | public BillListVo showBillList(String unexamined)； |
| 前置条件                                     | 用户有审批单据的权限              |                                          |
| 后置条件                                     | 返回待审批单据列表               |                                          |
| chiefmanagerblservice.changeBillState    | 语法                      | public void changeBillState(ArrayList<BillVo>),boolean pass); |
| 前置条件                                     | 待审批单据列表不为空              |                                          |
| 后置条件                                     | 改变单据的审批状态为批准或不批准        |                                          |
| chiefmanagerblservice.updateBillData     | 语法                      | public void updateBillData(ArrayList<BillVo>); |
| 前置条件                                     | 有单据被审批                  |                                          |
| 后置条件                                     | 将审批后的单据信息更新到数据库中        |                                          |
| chiefmanagerblservice.sendMessage        |                         |                                          |
| chiefmanagerblservice.showBillDetail     | 语法                      | public BillVo showBillDetail(int id);    |
| 前置条件                                     | 待审批单据列表不为空              |                                          |
| 后置条件                                     | 返回一张单据的详细内容             |                                          |
| chiefmanagerblservice.choosePromotionType | 语法                      | public PromotionVo choosePromotionType(String type); |
| 前置条件                                     | 用户有权限制定促销策略             |                                          |
| 后置条件                                     | 返回类型对应的VO               |                                          |
| chiefmanagerblservice.setPromotionTime   | 语法                      | public PromotionVo setPromotionTime(PromotionVo promotionVo); |
| 前置条件                                     | 用户有权限制定促销策略             |                                          |
| 后置条件                                     | 返回修改了起始时间的PromotionVo   |                                          |
| chiefmanagerblservice.checkPromotionInfo | 语法                      | public PromotionVo checkPromotionInfo(PromotionVo promotionvo) |
| 前置条件                                     | 用户有权限制定促销策略             |                                          |
| 后置条件                                     | 检查用户传入促销策略信息的正确性        |                                          |
| chiefmanagerblservice.ShowPromotionList  | 语法                      | public PromotionListVo ShowPromotionList(); |
| 前置条件                                     | 用户有权限制定促销策略             |                                          |
| 后置条件                                     | 显示当前存在的促销策略列表           |                                          |
| chiefmanagerblservice.updatePromotionInfo | 语法                      | public void updatePromotionInfo(PromotionVo promotionVo); |
| 前置条件                                     | 用户制定促销策略成功              |                                          |
| 后置条件                                     | 更新数据库中的促销策略信息           |                                          |
| 需要的服务（需接口）                               |                         |                                          |
| 服务名                                      | 服务                      |                                          |
| systemData.userData.findUserPo           | 根据id查找对应的userPo         |                                          |
| billDataService.findSaleBill             | 根据搜索条件查找对应的saleBillPo   |                                          |
| billDataService.findBillPo               | 查找符合条件的所有类型的单据PO        |                                          |
| SystemDataService.LogDataService.findLogPo | 根据ID查找对应的LogPo          |                                          |
| billDataService.updateBillPo             | 改变BillPo中的数据            |                                          |
| SystemDataService.promotionDataService.find | 查找参数类型对应的所有PromotionPo  |                                          |

 数据层模块的接口规范

| 提供的服务（供接口）                               |                                    |                                          |
| ---------------------------------------- | ---------------------------------- | ---------------------------------------- |
| systemDataService.userDataService.findUserPo | 语法                                 | public userPo finduserPo(int id);        |
| 前置条件                                     | 无                                  |                                          |
| 后置条件                                     | 返回该用户ID对应的userPo                   |                                          |
| billDataService.findSaleBillPo           | 语法                                 | public ArrayList<SaleBillPo> findSaleBill(String time,String commodityName, String customName, String salesmanName,String warehouseName); |
| 前置条件                                     | 无                                  |                                          |
| 后置条件                                     | 返回按条件查找的saleBillPo                 |                                          |
| billDataService.findBillPo               | 语法                                 | public ArrayList<BillPo> findBillPo(String Condition); |
| 前置条件                                     | 无                                  |                                          |
| 后置条件                                     | 返回符合条件的所有单据                        |                                          |
| SystemDataService.LogDataService.findLogPo | 语法                                 | public ArrayList<LogPo> findLogPo(int logID); |
| 前置条件                                     | 无                                  |                                          |
| 后置条件                                     | 返回该日志id对应的LogPo,如果ID为特定值则返回所有LogPo |                                          |
| billDataService.updateBillPo             | 语法                                 | public void updateBillPo(ArrayList<BillPo>); |
| 前置条件                                     | 持久化文件中存在参数传入的BillPo                |                                          |
| 后置条件                                     | BillPo的信息改为参数中BillPo的信息            |                                          |
| SystemDataService.promotionDataService.find | 语法                                 | public ArrayList<PromotionPo> find(String type); |
| 前置条件                                     | 无                                  |                                          |
| 后置条件                                     | 返回参数类型对应的所有PromotionPo             |                                          |
| SystemDataService.promotionDataService.insert | 语法                                 | public void updatePromotionPo(ArrayList<BillPo>); |
| 前置条件                                     | 无                                  |                                          |
| 后置条件                                     | 更新数据库里的促销策略信息                      |                                          |