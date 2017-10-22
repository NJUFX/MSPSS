数据层PO列表

注意：如果有重复的PO，即别人写过了你也要用，那就在属性中增加你需要的属性即可

| **PO****名称**（请以驼峰命名法书写，e.g. SalesBillPO） | **PO****中存储的内容**（e.g.SalesBillPO中存储的是数据层中的销售单据） | PO需要的属性（e.g. SalesBillPO中需要单据编号，请加上数据类型，如String id） | 所属的Data类型                |
| ---------------------------------------- | ---------------------------------------- | ---------------------------------------- | ------------------------ |
| UserPO                                   | 用户的系统信息                                  | int id;String name;boolean checkListLimit;boolean examineBillLimit;boolean readLogLimit;boolean makePromotionLimit; | SystemData.UserData      |
| SalesBillPO                              | 销售类单据，包括销售进货单和销售退货单                      | String commodityName;//商品String customerName;//客户String salesmanName;//销售员String warehouseName;//仓库String modelId;//型号int amount;//数量double unitPrice;//单价 | BillData                 |
| BillPO                                   | 所有单据的父类，用于制定经营情况表和经营历程表的时候返回所有单据         | String billId//单据编号                      | BillData                 |
| LogPO                                    | 系统日志的详细内容                                | int id;//编号String logText;//日志内容         | SystemData.LogData       |
| PromotionPO                              | 促销策略的父类，对应六个子类PO                         | String type;//促销策略类型String time;// 有效时间区间 | SystemData.PromotionData |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |
|                                          |                                          |                                          |                          |