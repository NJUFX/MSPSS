## 更新历史

| 修改人员 | 日期         | 变更原因    | 版本号  |
| ---- | ---------- | ------- | ---- |
| FX全组 | 2017-10-28 | 最初草稿    | V1.0 |
| 徐光耀  | 2017-10-30 | 添加逻辑层分解 | v1.0 |
|      |            |         |      |
|      |            |         |      |
|      |            |         |      |
|      |            |         |      |
|      |            |         |      |
|      |            |         |      |
|      |            |         |      |

## 1. 引言

### **1.1编制目的**

本报告详细完成对MSPSS进销存管理系统概要设计，达到指导详细设计和开放的目的，同时实现和测试人员及用户的沟通

 

### 1.2词汇表

| 词汇名称  | 词汇含义                    | 备注   |
| ----- | ----------------------- | ---- |
| CSS   | Course selection system |      |
| _ui   | 表示某展示层                  |      |
| _bl   | 表示某逻辑层                  |      |
| _data | 表示某数据层                  |      |



### 1.3参考资料

1. IEEE Std 1016-1998 《IEEE Recommended Practice for Software Design Descriptions》

2.AURORA小组，《NJWU选课系统CSS需求规格说明书V1.2》

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

#### 4.2.2 stockseller模块

#### 4.2.3 financebl模块

######（1）模块概述

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
图4.2.3(4)-1中表面了添加账户的操作中，各个类之间的协作关系
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1%E6%96%87%E6%A1%A3%E5%9B%BE%E7%89%87%E6%A0%B9%E7%9B%AE%E5%BD%95/%E6%B7%BB%E5%8A%A0%E8%B4%A6%E6%88%B7%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)


#### 4.2.4 chiefmanger模块

