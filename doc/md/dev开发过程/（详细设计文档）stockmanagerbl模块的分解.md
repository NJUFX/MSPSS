### 4.1.1 stockmanager

### 4.2.1 stockmangager模块

##### (1)模块描述 

stockmanagerbl模块承担的需求参见需求规格说明文档功能需求及其他相关非功能需求。

stockmanagerbl模块的职责及接口参见软件体系结构设计文档

##### (2) 整体结构

根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，我们会添加接口。比如展示层和业务逻辑层之间我们添加businesslogicservice.stockmanagrerblservice.StockManagerBLService接口。业务逻辑层和数据层之间添加dataservice.CustomerDataService、dataservice.BillDataService、dataservice.CommodityDataService接口。为了隔离业务逻辑职责和逻辑控制职责，我们增加了StockSellerBLServiceImpl，这样StockSellerBLServiceImpl会将客户管理和制定单据的业务逻辑委托给Customer对象和Bill对象。CustomerPO是作为客户属性的持久化对象被添加到设计模型中去的。PurchaseBillPO是作为进货单和进货退货单持久化对象被添加到设计模型中去的。、SalesBillPO是作为销售单和销售退货单的持久化对象被添加到设计模型中去的。、CommodityPO是作为商品属性的持久化对象被添加到设计模型中去的。CustomerVO、PurchaseBillVO、SalesBillVO、CommodityVO是作为值对象被添加到设计模型中去的。



stocksellerbl模块的设计图

#####（3）模块内部类的接口规范