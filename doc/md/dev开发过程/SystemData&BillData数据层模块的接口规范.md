数据层模块的接口规范

| 提供的服务（供接口）                               |                                    |                                          |
| ---------------------------------------- | ---------------------------------- | ---------------------------------------- |
| SystemDataService.userDataService.findUser | 语法                                 | public userPo finduser(int id);          |
| 前置条件                                     | 无                                  |                                          |
| 后置条件                                     | 返回该用户ID对应的userPO                   |                                          |
| BillDataService.findSaleBill             | 语法                                 | public ArrayList<SaleBillPO> findSaleBill(String time,String commodityName, String customName, String salesmanName,String warehouseName); |
| 前置条件                                     | 无                                  |                                          |
| 后置条件                                     | 返回按条件查找的saleBillPO                 |                                          |
| BillDataService.findBill                 | 语法                                 | public ArrayList<BillPO> findBill(String Condition); |
| 前置条件                                     | 无                                  |                                          |
| 后置条件                                     | 返回符合条件的所有单据PO                      |                                          |
| SystemDataService.LogDataService.findLog | 语法                                 | public ArrayList<LogPO> findLog(int logID); |
| 前置条件                                     | 无                                  |                                          |
| 后置条件                                     | 返回该日志id对应的LogPo,如果ID为特定值则返回所有LogPO |                                          |
| BillDataService.updateBill               | 语法                                 | public void updateBill(ArrayList<BillPO>); |
| 前置条件                                     | 持久化文件中存在参数传入的BillPO                |                                          |
| 后置条件                                     | BillPO的信息改为参数中BillPO的信息            |                                          |
| SystemDataService.promotionDataService.find | 语法                                 | public ArrayList<PromotionPO> find(String type); |
| 前置条件                                     | 无                                  |                                          |
| 后置条件                                     | 返回参数类型对应的所有PromotionPO             |                                          |
| SystemDataService.promotionDataService.updatePromotionPO | 语法                                 | public void updatePromotionPO(ArrayList<PromotionPO>); |
| 前置条件                                     | 无                                  |                                          |
| 后置条件                                     | 更新数据库里的促销策略信息                      |                                          |