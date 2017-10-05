# 进销存系统

# <center>进销存管理系统</center>



# <center>MSPSS(Management System of Purchase-Sell-Stock)</center>





# <center> 需求度量数据文档</center>





# <center>v1.0 正式版</center>

<br><br><br>

## <center>南京大学FX工作组</center><br><center>伏家兴，韩新虎，刘雅歆，徐光耀</center><br><center>2017-09-30</center>







## 更新历史

| **修改人员** | **日期**     | **变更原因** | **版本号**  |
| -------- | ---------- | -------- | -------- |
| FX全组人员   | 2017-09-30 | 最初草稿     | V1.0  草稿 |
|          |            |          |          |
|          |            |          |          |
|          |            |          |          |







## 1 度量标准

### 1.1 功能点计算的加权因子fi

**本系统为中等系统**

| 功能点测度 | 加权因子   |      |      |      |
| ----- | ------ | ---- | ---- | ---- |
| 简单系统  | 中等系统   | 复杂系统 |      |      |
| C1    | 输入数量   | 3    | 4    | 6    |
| C2    | 输出数量   | 4    | 5    | 7    |
| C3    | 查询数量   | 3    | 4    | 6    |
| C4    | 逻辑文件数量 | 7    | 10   | 15   |
| C5    | 对外接口数量 | 5    | 7    | 10   |

### 1.2 复杂度调整因子

| 系统复杂度调整因子Fi | 描述                       | MSPSS估计值 |
| ----------- | ------------------------ | -------- |
| 1           | 系统需要备份和恢复吗？              | 0        |
| 2           | 需要专门的网络数据通信吗？            | 0        |
| 3           | 存在分布式处理功能吗？              | 5        |
| 4           | 性能关键吗？                   | 2        |
| 5           | 系统将运行在一个现有的、使用困难的操作环境吗？  | 1        |
| 6           | 系统需要在线数据项吗？              | 3        |
| 7           | 在线数据项目需要对多个屏幕或操作建立输入事务吗？ | 4        |
| 8           | 逻辑文件在线更新吗？               | 5        |
| 9           | 输入、输出、文件或查询是复杂的吗？        | 2        |
| 10          | 内部处理是复杂的吗？               | 3        |
| 11          | 所设计的代码要求可复用吗？            | 4        |
| 12          | 设计要求包括交付与安装吗？            | 3        |
| 13          | 系统需要设计为多个安装以适应不同组织吗？     | 0        |
| 14          | 系统设计要求易于修改和易于使用吗？        | 4        |



## 2 需求度量

### 2.1 商品分类

| 编号                               | 需求描述与度量                                  |
| -------------------------------- | ---------------------------------------- |
| Classification.Start             | 当库存管理人员请求对商品管理时，系统进入商品管理界面（输出）           |
| Classification.Input             | 系统应该允许库存管理人员进行键盘输入或鼠标选择                  |
| Classification.Select            | 系统应该允许库存管理人员选择要进行的操作（查询）                 |
| Classification.Select.Add        | 系统应该允许库存管理人员选择增加分类，参见Classification.Add  |
| Classification.Select.Delete     | 系统应当允许库存管理人员选择删除分类，参见Classification.Delete |
| Classification.Select.Modify     | 系统应当允许库存管理人员选择修改分类， 参见Classification.Modify |
| Classification.Select.End        | 在库存管理人员选择要进行的操作后跳转到相应的界面（输出）             |
| Classification.Add.Select        | 系统应该允许库存管理人员选择要添加的节点（输出，逻辑文件）            |
| Classification.Add.Description   | 系统应该允许库存管理人员输入新添加的分类信息（输入）               |
| Classification.Add.Submit        | 在库存管理人员确认提交后，系统保存基本信息（输出）                |
| Classification.Add.Invalid       | 库存管理人员输入非法的信息后，系统提示重新输入或取消（输出）           |
| Classification.Delete.Select     | 系统应当允许库存管理人员选择要删除的节点（查询，逻辑文件）            |
| Classification.Delete.Submit     | 库存管理人员确认删除后，系统应该更新分类信息（逻辑文件）             |
| Classification.Delete.Invalid    | 删除无效后，提示删除错误，取消删除操作                      |
| Classification.Modify.Select     | 选择要修改的节点（查询）                             |
| Classification.Modify.Name       | 选择要修改名称（查询)                              |
| Classification.Modify.Name.Input | 系统应该允许库存管理人员输入新的名称(输入)                   |
| Classification.Modify.Location   | 系统应该允许库存管理人员选择新的位置（查询）                   |
| Classification.Modify.Submit     | 库存管理人员确认提交后，系统保存新的信息（逻辑文件）               |
| Classification.Modify.Invalid    | 修改无效后，系统提示重新操作或者取消（输出）                   |
| Classification.End               | 系统应当允许库存管理人员结束当前页面跳转回去（输出）               |

| 输入      | 4                                        |
| ------- | ---------------------------------------- |
| 输出      | 6                                        |
| 查询      | 5                                        |
| 内部逻辑文件  | 4                                        |
| 对外接口文件  | 0                                        |
| 功能点测度总数 | 4 * 4 + 6 * 5 + 5 * 4 + 4 *10 + 7 * 0 = 86 |
| FP      | 86.86                                    |



### 2.2 商品管理

| 编号                           | 需求描述                                     |
| ---------------------------- | ---------------------------------------- |
| Management.Start             | 当库存管理人员请求对商品管理时，系统进入商品管理界面（查询）           |
| Management.End               | 当库存管理人员结束商品管理时，系统返回库存管理人员初始界面            |
| Management.Select            | 系统应当允许库存管理人员选择要进行的操作（查询）                 |
| Management.Select.Add        | 系统应当允许库存管理人员选择添加商品，参见Management.Add      |
| Management.Select.Delete     | 系统应当允许库存管理人员选择删除商品，参见Management.Delete   |
| Management.Select.Modify     | 系统应当允许库存管理人员选择修改商品，参见Management.Modify   |
| Management.Input             | 系统应当允许库存管理人员用键盘输入                        |
| Management.Input.Keyword     | 系统应当允许库存管理人员输入商品关键字（输入）                  |
| Management.Input.Information | 系统应当允许库存管理人员输入商品信息（输入）                   |
| Management.Input.Invalid     | 系统应当在输入不合法时提醒重新输入（输出）                    |
| Management.Select.Obeserve   | 系统应当允许库存管理人员选择查看商品，参见Management.Obeserve |
| Management.Add.Input         | 系统应当允许库存管理人员输入商品信息，参见Management.Input.Information |
| Management.Add.Submit        | 在库存管理人员输入商品信息提交后，应当更新商品信息（逻辑文件）          |
| Management.Add.Invalid       | 输入的商品信息非法时系统提示错误要求重新输入或取消，参见Managemnt.Input.Invalid（输出） |
| Management.Add.Blank         | 当库存管理人员输入的信息中存在没有输入的项时，系统提示库存管理人员输入或取消（输出） |
| Management.Delete            | 系统应当提示输入要删除的商品的关键字信息（输出）                 |
| Management.Delete.Input      | 系统应当允许库存管理人员输入关键字，参见Management.Input.keyword（输入） |
| Management.Delete.List       | 系统应当显示满足关键字的商品列表（输出）                     |
| Management.Delete.Determine  | 系统应该允许系统管理人员选择要删除的商品（查询）                 |
| Management.Delete.End        | 系统应该提示删除成功并更新商品数据（逻辑文件，输出）               |
| Management.Modify            | 系统应当提示库存管理人员输入商品关键字（输出）                  |
| Management.Modify.Input      | 系统应当允许库存管理人员输入商品关键字，参见Management.Input.Keyword（输入） |
| Management.Modify.List       | 系统应当显示满足关键字的商品列表（输出）                     |
| Management.Modify.Determine  | 系统应当显示选中的商品的具体信息（输出）                     |
| Management.Modify.Submit     | 在库存管理人员修改并保存后，系统应该更新商品信息（逻辑文件）           |
| Management.Modify.Invalid    | 当修改后的商品信息非法时系统提示错误要求重新输入或取消，参见Management.Input.Invalid（输出） |
| Management.Observe           | 系统应该允许库存管理人员查看商品信息（输出）                   |
| Management.Observe.Input     | 库存管理人员输入关键字信息，参见Management.Input.Keyword（输入） |
| Management.Observe.List      | 系统显示满足关键字的商品列表 （输出）                      |
| Management.Observe.Select    | 当库存管理人员选中某商品进行查看时系统显示该商品的所有信息 （输出）       |



| 输入      | 4                                        |
| ------- | ---------------------------------------- |
| 输出      | 13                                       |
| 查询      | 3                                        |
| 内部逻辑文件  | 3                                        |
| 对外接口文件  | 0                                        |
| 功能点测度总数 | 4 * 4 + 13 * 5 + 3 * 4 + 3 *10 + 7 * 0 =123 |
| FP      | 124.23                                   |



### 2.3 库存查看

| 编号                    | 需求描述                   |
| --------------------- | ---------------------- |
| Check.Time            | 系统应当允许库存管理人员选择时间段 （输入） |
| Check.Display         | 系统显示这一时间段内的所有入库出库（输出）  |
| Check.Display.Invalid | 系统提示输入时间无效或该时间段内无出入库信息 |
| Check.End             | 系统允许用户在此进程的任意时间退出      |



| 输入      | 1                                        |
| ------- | ---------------------------------------- |
| 输出      | 2                                        |
| 查询      | 0                                        |
| 内部逻辑文件  | 0                                        |
| 对外接口文件  | 0                                        |
| 功能点测度总数 | 1 * 4 + 2 * 5 + 0 * 4 + 0 * 10 + 0 * 7 =14 |
| FP      | 14.14                                    |



### 2.4 库存盘点

| 编号               | 需求描述                      |
| ---------------- | ------------------------- |
| Inventory        | 系统自动显示当天所有的出库入库信息 (输出，查询) |
| Inventory.Cancel | 系统允许库存管理人员在任一时间任一进度退出     |
| Inventory.Finish | 库存管理人员确认信息后，系统更新数据库（逻辑文件） |



| 输入      | 0                                        |
| ------- | ---------------------------------------- |
| 输出      | 1                                        |
| 查询      | 1                                        |
| 内部逻辑文件  | 1                                        |
| 对外接口文件  | 0                                        |
| 功能点测度总数 | 0 * 4 + 1 * 5 + 1 * 4 + 1 *10 + 0 * 7 =19 |
| FP      | 19.19                                    |



### 2.5 处理库存单据

| 编号                        | 需求描述                                     |
| ------------------------- | ---------------------------------------- |
| Invoices.Input            | 库存管理人员请求输入库存信息                           |
| Invoices.Input.Invalid    | 系统提示输入信息无效，提示重新输入或取消操作                   |
| Invoices.Start            | 库存管理人员请求处理库存单据时，系统进入相应的界面（查询）            |
| Invoices.Select           | 系统应当允许库存管理人员选择要处理的表单（查询）                 |
| Invoices.Select.Present   | 系统应当允许库存管理人员选择库存赠送单，参见Invoices.Present   |
| Invoices.Select.Repetory  | 系统应当允许库存管理人员选择库存报损单或库存报溢单，参见Invoices.Repetory |
| Invoices.Select.Alert     | 系统应当允许库存管理人员选择库存报警单，参见Invoices.Alert     |
| Invoices.End              | 当库存管理人员结束处理库存单据时，系统返回库存管理人员初始界面（查询）      |
| Invoices.Present          | 允许库存管理人员查看收到的库存赠送单（输出）                   |
| Invoices.Present.Update   | 库存管理人员更新库存信息（逻辑文件）                       |
| Invoices.Present.Done     | 单据已被库存管理人员处理（逻辑文件）                       |
| Invoices.Repertory        | 允许库存管理人员生成库存报损报溢单（逻辑文件）                  |
| Invoices.Repertory.Input  | 允许库存管理人员输入相关库存信息，参见Invoices.Input（输入）    |
| Invoices.Repertory.Submit | 库存管理人员保存并提交，系统更新信息（输出）                   |
| Invoices.Alert            | 允许库存管理人员生成报警单（查询）                        |
| Invoices.Alert.Input      | 允许库存管理人员输入相关库存信息，参见Invoices.Input（输入）    |
| Invoices.Alert.Submit     | 允许库存管理人员提交，并更新数据库（逻辑文件，输出）               |



| 输入      | 2                                        |
| ------- | ---------------------------------------- |
| 输出      | 3                                        |
| 查询      | 3                                        |
| 内部逻辑文件  | 4                                        |
| 对外接口文件  | 0                                        |
| 功能点测度总数 | 2 * 4 + 3 * 5 + 3 * 4 + 4 *10 + 7 * 0 = 75 |
| FP      | 75.75                                    |



### 2.6 客户管理

| 编号                                    | 需求描述                                     |
| ------------------------------------- | ---------------------------------------- |
| CustomerManager.Seek                  | 系统允许进货销售人员人员选择查找客户                       |
| CustomerManager.Seek.Input            | 系统应该允许进货销售人员在查找客户的任务中进行键盘输入（输入）          |
| CustomerManager.Seek.End              | 在进货销售人员输入结束查找命令时（查询），系统要结束一个查找任务（输出）     |
| CustomerManager.Seek.Del              | 在进货销售人员输入删除已输入信息的命令时（查询），系统执行删除已输入信息的命令（输出） |
| CustomerManager.Seek.Valid            | 在进货销售人员输入系统中存在的客户编号或关键词时（逻辑文件），系统显示所有符合条件的客户信息（输出） |
| CustomerManager.Seek.Invalid          | 在进货销售人员输入系统中不存在的客户编号或者关键词时（输入），系统提示核对信息并重新输入（输出） |
| CustomerManager.Add                   | 系统允许进货销售人员人员选择增加客户的命令                    |
| CustomerManager.Add.Input             | 系统应该允许进货销售人员在增加客户的任务中进行键盘输入（输入）          |
| CustomerManager.Add.Del               | 在进货销售人员输入删除已输入信息的命令时（查询），系统执行删除已输入信息的命令（输出） |
| CustomerManager.Add.Seek              | 在进货销售人员输入增加客户的命令后（查询），系统查找是否与已有客户重复。     |
| CustomerManager.Add.Invalid.Repeat    | 在进货销售人员输入的客户属性和系统中已有的客户重复时（逻辑文件），系统不做增加客户处理，并提示核对信息重新输入（输出） |
| CustomerManager.Add.Invalid.Lack      | 在进货销售人员输入的客户属性不完整时（输入），系统不做增加操作并提示核对信息重新输入（输出） |
| CustomerManager.Add.Input.Illegal     | 进货销售人员输入的信息不符合数据规范（输入），系统提示核对信息重新输入（输出）  |
| CustomerManager.Add.Valid             | 在进货销售人员输入的客户属性完整且没有与系统中已有的客户重复时（输入），系统中新建一个客户，并提示新建成功（输出） |
| CustomerManager.Add.End               | 在进货销售人员输入结束增加客户命令时（查询），系统要结束一个增加客户任务（输出） |
| CustomerManager.Add.End.Null          | 在进货销售人员未输入任何信息就输入结束命令时（查询），系统关闭增加客户任务不做任何处理（输出） |
| CustomerManager.Add.End.Uninish       | 在进货销售人员已输入客户属性后但未输入增加客户命令而是选择结束命令时（查询），系统提示操作尚未成功，询问操作人是否结束操作（输出） |
| CustomerManager.Add.Update            | 在增加客户的操作成功后，系统更新数据库（逻辑文件）                |
| CustomerManager.Del                   | 系统允许进货销售人员人员选择删除客户的命令                    |
| CustomerManager.Del.Input             | 系统允许进货销售人员在删除客户任务中进行键盘输入（输入）             |
| CustomerManager.Del.Seek              | 在进货销售人员输入关键词或者编号后，系统内查找所有符合条件的客户。        |
| CustomerManager.Del.Seek.Invalid      | 当系统内不存在符合条件的客户时，系统提示核对信息重新输入（输出）。        |
| CustomerManager.Del.Seek.Valid        | 系统中存在符合搜索条件的客户时，显示所有符合条件的客户（输出）          |
| CustomerManager.Del.Start             | 在进货销售人员找到要删除的客户时，选择该客户发起删除客户的请求（查询）      |
| CustomerManager.Del.Check             | 在进货销售人员输入删除命令时（查询），系统询问是否进行删除（输出）        |
| CustomerManager.Del.End               | 系统结束一个删除客户的任务。                           |
| CustomerManager.Del.End.Cancel        | 进货销售人员取消删除命令（查询），系统返回显示界面（输出）            |
| CustomerManager.Del.End.Update        | 进货销售人员确认删除客户（查询），系统删除该客户（输出）并更新数据库（逻辑文件） |
| CustomerManager.Modify                | 系统允许进货销售人员人员选择修改客户属性的命令                  |
| CustomerManager.Modify.Start          | 进货销售人员发起修改客户属性的请求（查询）                    |
| CustomerManager.Modify.Input          | 系统应该允许进货销售人员在修改客户属性的任务中进行键盘输入（输入）        |
| CustomerManager.Modify. Input.Invalid | 进货销售人员输入的信息不符合数据规范时（输入），系统提示核对信息重新输入（输出） |
| CustomerManager.Modify.Input.Valid    | 进货销售人员输入的信息符合数据规范（输入）                    |
| CustomerManager.Modify.End            | 系统允许进货销售人员结束修改客户属性的请求。                   |
| CustomerManager.Modify.End.Cancel     | 进货销售人员取消修改操作（查询），系统返回显示界面。（输出）           |
| CustomerManager.Modify.End.Update     | 进货销售人员提交修改操作（查询），系统内对客户属性进行修改，并更新数据库（逻辑文件）。 |



| 输入      | 10                                       |
| ------- | ---------------------------------------- |
| 输出      | 19                                       |
| 查询      | 14                                       |
| 内部逻辑文件  | 5                                        |
| 对外接口文件  | 0                                        |
| 功能点测度总数 | 10 * 4 + 19* * 5 + 14 * 4 + 10 * 5 + 0 * 7 = 241 |
| FP      | 243.41                                   |



### 2.7 制定进货单和进货退货单

| 编号                         | 需求描述                                     |
| -------------------------- | ---------------------------------------- |
| MakeReceipt.Select         | 进货销售人员选择要制定的单据的类型（查询）                    |
| MakeReceipt.Input          | 系统应该允许进货销售人员在制定单据的任务中进行键盘输入              |
| MakeReceipt.Input.Invalid  | 进货销售人员输入的单据内容不符合数据规范（输入）                 |
| MakeReceipt.Input.Valid    | 进货销售人员输入的单据内容符合数据规范（输入）。                 |
| MakeReceipt.Create         | 系统生成相应的单据                                |
| MakeReceipt.Create.Invalid | 进货销售人员输入的单据内容有缺失或者错误（输入），系统不作生成处理，并提示核对信息重新输入（输出） |
| MakeReceipt.Create.Valid   | 系统成功生成相应单据（输出）                           |
| MakeReceipt.End            | 系统允许进货销售人员结束制定单据的请求。                     |
| MakeReceipt.End.Close      | 当进货销售人员选择结束制定单据的操作时（查询），系统返回选择制定单据类型的界面（输出）。 |
| MakeReceipt.End.Update     | 当创建单据成功后，进货销售人员选择结束制定单据的操作时（查询），系统更新数据库（逻辑文件）。 |



| 输入      | 3                                        |
| ------- | ---------------------------------------- |
| 输出      | 3                                        |
| 查询      | 3                                        |
| 内部逻辑文件  | 1                                        |
| 对外接口文件  | 0                                        |
| 功能点测度总数 | 3 * 4 + 3 * 5 + 3 * 4 + 1 * 10 + 7 * 0 = 49 |
| FP      | 49.49                                    |



### 2.8 制定销售单和销售退货单

| 编号                         | 需求描述                                     |
| -------------------------- | ---------------------------------------- |
| MakeReceipt.Select         | 进货销售人员选择要制定的单据的类型（查询）                    |
| MakeReceipt.Input          | 系统应该允许进货销售人员在制定单据的任务中进行键盘输入              |
| MakeReceipt.Input.Invalid  | 进货销售人员输入的单据内容不符合数据规范（输入）                 |
| MakeReceipt.Input.Valid    | 进货销售人员输入的单据内容符合数据规范（输入）。                 |
| MakeReceipt.Create         | 系统生成相应的单据                                |
| MakeReceipt.Create.Invalid | 进货销售人员输入的单据内容有缺失或者错误（输入），系统不作生成处理，并提示核对信息重新输入（输出） |
| MakeReceipt.Create.Valid   | 系统成功生成相应单据（输出）                           |
| MakeReceipt.End            | 系统允许进货销售人员结束制定单据的请求。                     |
| MakeReceipt.End.Close      | 当进货销售人员选择结束制定单据的操作时（查询），系统返回选择制定单据类型的界面（输出）。 |
| MakeReceipt.End.Update     | 当创建单据成功后，进货销售人员选择结束制定单据的操作时（查询），系统更新数据库（逻辑文件）。 |



| 输入      | 3                                        |
| ------- | ---------------------------------------- |
| 输出      | 3                                        |
| 查询      | 3                                        |
| 内部逻辑文件  | 1                                        |
| 对外接口文件  | 0                                        |
| 功能点测度总数 | 3 * 4 + 3 * 5 + 3 * 4 + 1 * 10 + 7 * 0 = 49 |
| FP      | 49.49                                    |



### 2.9 账户管理及操作

| AccountManage.Exit                       | 在管理账户时，允许财务人员退出账户管理，系统要舍弃财务人员之前未保存的操作并且回到之前的界面 |
| ---------------------------------------- | ---------------------------------------- |
| AccountManage.Check                      | 在账号查询操作开始时，系统要求财务人员输入目标账户的信息**（输入，查询）**  |
| AccountManage.Check.Add                  | 在财务人员选择增加账户操作时，系统要执行增帐任务，参见AccountManage.Add |
| AccountManage.Check.Valid                | 在财务人员输入有效信息时，系统显示有关的账户的名称和余额**（输出）**     |
| AccountManage.Check.Invalid              | 在收银员输入内容无匹配账户时，系统提示无相关账户**（输出，查询）**      |
| AccountManage.Check.Valid.Modify         | 财务人员修改选中账户的信息，具体参见AccountManage.Modify**（输入）** |
| AccountManage.Check.Valid.Delete         | 财务人员要求执行删除操作，参见AccountMagage.Delete      |
| AccountManage.Modify                     | 系统进入修改信息的任务**（输入）**                      |
| AccountManage.Modify.Unchangable         | 如果操作人员试图修改账户余额时，系统禁止财务人员修改余额**（逻辑文件）**   |
| AccountManage.Modify.Changable           | 系统允许操作人员修改账户名称**（逻辑文件）**                 |
| AccountManage.Modify.Changable.Repetition | 收银员输入一个与之前账户同名的账号名时，系统提示名称重复**（查询，输出）**  |
| AccountManage.Modify.End                 | 退出修改操作，具体参见AccountManage.End             |
| AccountManage.Add                        | 系统允许财务人员增加账户，并且要求财务人员输入账户初始的信息**（输入）**   |
| AccountManage.Add.Repetition             | 在财务人员输入一个以存在的账户名时，系统提示账户名重复**（查询，输出）**   |
| AccountManage.Add.End                    | 财务人员请求结束增帐操作，参见AccountManage.End         |
| AccountManage.Delete                     | 系统允许财务人员删除一个选中的账户                        |
| AccountManage.Delete.Comfirm             | 在财务人员选择一个账户，并要求删除时，系统会提示财务人员是否确认删除**（逻辑文件，输出）** |
| AccountManage.Delete.Comfirm.Yes         | 收银员选择确认删除，系统从账户列表中删除目标账户,保存修改**（逻辑文件）**  |
| AccountManage.Delete.Comfirm.No          | 系统在财务人员否认删除之后，取消账户删除操作，返回查看界面，参见AccountManage.Check |
| AccountManage.End                        | 系统应该允许财务人员退出操作                           |
| AccountManage.End.Save                   | 系统保存财务人员的修改，退出系统**（逻辑文件）**               |
| AccountManage.End.Discard                | 系统撤销财务人员的修改，退出系统                         |
| AccountManage.End.Concel                 | 系统取消结束命令                                 |



| 输入      | 4                    |
| ------- | -------------------- |
| 输出      | 5                    |
| 查询      | 4                    |
| 内部逻辑文件  | 5                    |
| 对外接口文件  | 0                    |
| 功能点测度总数 | 4x4+5x5+4x4+5x10=107 |
| FP      | 108.7                |



### 2.10 制定付款单及现金费用单

| MakeBill.Exit                  | 在制定付款单或者现金费用单时，允许财务人员退出填写界面，系统要舍弃财务人员之前未保存的操作并且回到之前的界面 |
| ------------------------------ | ---------------------------------------- |
| MakeBill.Choose                | 在制定报表的页面，财务人员可以选择需要制定的报表类型**(逻辑文件)**     |
| MakeBill.Choose.PayBill        | 财务人员在选择指定付款单时，系统执行付款单制作操作，参见PayBill.PayBill |
| MakeBill.Choose.CashBill       | 财务人员在选择指定现金费用单时，系统执行现金费用单制作操作，参见PayBill.CashBill |
| MakeBill.PayBill               | 系统允许财务人员制定付款单                            |
| MakeBill.PayBill.Input         | 在财务人员制定报表时，财务人员要输入 单据编号（XJFYD-yyyyMMdd-xxxxx）,操作员（当前登录用户），银行账户，条目清单，总额。条目清单中包括：条目名，金额，备注。**（输入）** |
| MakeBill.PayBill.Discard       | 财务人员选择放弃填写报表，参见MakeBill.Discard          |
| MakeBill.PayBill.Wrong         | 财务人员输入信息格式错误**（输出）**                     |
| MakeBill.PayBill.Input.Commit  | 财务人员选择提交已经填写好的报表，系统会检查报表的填写状况，具体参见MakeBill.Commit**（逻辑文件）** |
| MakeBill.CashBill              | 系统允许财务人员制定现金费用单                          |
| MakeBill.CashBill.Input        | 在财务人员制定报表时，财务人员要输入 单据编号（XJFYD-yyyyMMdd-xxxxx）,操作员（当前登录用户），银行账户，条目清单，总额。条目清单中包括：条目名，金额，备注。**（输入）** |
| MakeBill.CashBill.Discard      | 财务人员选择放弃报表填写，参见MakeBill.Discard          |
| MakeBill.CashBill.Wrong        | 财务人员输入信息格式错误**（输出）**                     |
| MakeBill.CashBill.Input.Commit | 财务人员选择提交表单，系统会检查报表的填写状况，具体参见MakeBill.Commit**（逻辑文件）** |
| MakeBill.Commit                | 系统允许财务人员提交表单                             |
| MakeBill.Commit.Incomplete     | 在财务人员员填写信息不完全并且提交时，系统提示信息未输入完全，并返回信息填写界面**（输出）** |
| MakeBill.Commit.Complete       | 在收银员填写信息完全并且提交时，系统提交单据给总经理，并且修改系统数据，保存账单并入账**（逻辑文件，输出）** |
| MakeBill.Commit.Complete.Check | 交付总经理审查，具体参见MakeBill.Check               |
| MakeBill.Commit.Concel         | 系统允许财务人员放弃提交操作                           |
| MakeBill.Check.Finish          | 在总经理审批之后，系统发送审批成功的信息给财务人员，提示财务人员单据审批成功**（输出）** |
| MakeBill.Check.Finish.Change   | 系统在单据审批成功之后，系统修改客户的应收数据**（逻辑文件）**        |
| MakeBill.Discard               | 系统允许财务人员放弃填写表单                           |
| MakeBill.Diacard.Sure          | 系统不保存填写的表单，退出填表操作                        |
| MakeBill.Discard.Concel        | 取消放弃填写,返回填写操作                            |



| 输入      | 2               |
| ------- | --------------- |
| 输出      | 5               |
| 查询      | 0               |
| 内部逻辑文件  | 5               |
| 对外接口文件  | 0               |
| 功能点测度总数 | 2x4+5x5+5x10=83 |
| FP      | 83.83           |



### 2.11 制定收款单

| MakeReceipt.Exit                  | 在制定收款单时，允许财务人员退出填写界面，系统要舍弃财务人员之前未保存的操作并且回到之前的界面 |
| --------------------------------- | ---------------------------------------- |
| MakeReceip.Input                  | 单据编号（SKD-yyyyMMdd-xxxxx），客户（同时包含供应商和销售商），操作员（当前登录用户），转账列表，总额汇总。转账列表中的一项包含：银行账户，转账金额，备注。 |
| MakeReceipt.Discard               | 财务人员选择放弃填写报表，参见MakeReceipt.Discard       |
| MakeReceipt.Wrong                 | 财务人员输入信息格式错误**（输出）**                     |
| MakeReceipt.Input.Commit          | 财务人员选择提交已经填写好的报表，系统会检查报表的填写状况，具体参见MakeReceipt.Commit |
| MakeReceipt.Commit                | 系统允许财务人员提交表单                             |
| MakeReceipt.Commit.Incomplete     | 在财务人员员填写信息不完全并且提交时，系统提示信息未输入完全，并返回信息填写界面**（输出）** |
| MakeReceipt.Commit.Complete       | 在收银员填写信息完全并且提交时，系统提交单据给总经理，并且修改系统数据，保存账单并入账**（输出，逻辑文件）** |
| MakeReceipt.Commit.Complete.Check | 交付总经理审查，具体参见MakeReceipt.Check            |
| MakeReceipt.Commit.Concel         | 系统允许财务人员放弃提交操作                           |
| MakeReceipt.Check.Finish          | 在总经理审批之后，系统发送审批成功的信息给财务人员，提示财务人员单据审批成功**（输出）** |
| MakeReceipt.Check.Finish.Change   | 系统在单据审批成功之后，系统修改客户的应收数据**（逻辑文件）**        |
| MakeReceipt.Discard               | 系统允许财务人员放弃填写表单                           |
| MakeReceipt.Diacard.Sure          | 系统不保存填写的表单，退出填表操作                        |
| MakeReceipt.Discard.Concel        | 取消放弃填写,返回填写操作                            |



| 输入      | 1               |
| ------- | --------------- |
| 输出      | 4               |
| 查询      | 0               |
| 内部逻辑文件  | 2               |
| 对外接口文件  | 0               |
| 功能点测度总数 | 1x4+4x5+2x10=44 |
| FP      | 44.44           |



### 2.12 查看导出及调整报表

| ViewReport.Exit                          | 系统应该允许财务人员退出查看导出报表界面                     |
| ---------------------------------------- | ---------------------------------------- |
| ViewReport.Choose                        | 系统应该允许财务人员选择查看或导出报表的类型，其中包括： 销售明细表， 经营历程表， 经营情况表**（输入）** |
| ViewReport.Choose.SaleList               | 财务人员执行提填写销售明细表操作，参见ViewReport.SaleList   |
| ViewReport.Choose.BusinessProcessTable   | 财务人员执行填写经营历程表操作，参见ViewReport.BusinessProcessTable |
| ViewReport.Choose.StatementOfOperation   | 财务人员执行填写经营情况表，参见ViewReport.StatementOfOperation |
| ViewReport.SaleList                      | 财务人员在查看报表之前，应该输入目标的条件**（输入，查询，输出）**      |
| ViewReport.SaleList.Filter               | 财务人员在查看单据时，应该输入相关信息，  时间区间，商品名，客户，业务员，仓库**（输入，查询，输出）** |
| ViewReport.SaleList.Filter.Invalid       | 如果没有信息，则显示无相关信息**（输出）**                  |
| ViewReport.SaleLIst.Filter.Valid         | 销售明细列表中包括： 时间（精确到天），商品名，型号，数量，单价，总额**（输出）** |
| ViewReport.SaleList.Export               | 财务人员可以导出报表，参见ViewReport.Export           |
| ViewReport.BusinessProcessTable          | 系统执行查看经营历程表操作                            |
| ViewReport.BusinessProcessTable.Filter   | 财务人员输入筛选条件：时间区间，单据类型，客户，业务员，仓库**（输入，查询，输出）** |
| ViewReport.BusinessProcessTable.Filter.Invalid | 如果没有信息，则显示无相关信息**（输出）**                  |
| ViewReport.BusinessProcessTable.Filter.Valid | 时间里的所有单据，单据分为：1. 销售类单据（销售出货单，销售退货单） 2. 进货类单据（进货单，进货退货单） 3. 财务类单据（付款单，收款单，现金费用单）4. 库存类单据（报溢单，报损单，赠送单）,只能进行查看操作**（输出）** |
| ViewReport.BusinessProcessTable.HotForging | 财务人员进行红冲操作，参见ViewReport.HotForging       |
| ViewReport.BusinessProcessTable.Export   | 系统执行导出报表操作，参见ViewReport.Export           |
| ViewReport.StatementOfOperation          | 财务人员查看经营情况表                              |
| ViewReport.StatementOfOperation.Filter   | 财务人员输入目标的时间区间**（输入，输出，查询）**              |
| ViewReport.StatementOfOperation.Filter.Invalid | 如果没有信息，则显示无相关信息**（输出）**                  |
| ViewReport.StatementOfOperation.Filter.Valid | 显示信息：	1. 收入类：销售收入、商品类收入（商品报溢收入 成本调价收入 进货退货差价 代金券与实际收款差额收入）。收入类显示折让后总收入，并显示折让了多少。2. 支出类：销售成本、商品类支出（商品报损 商品赠出）。支出类显示总支出。3. 利润：折让后总收入-总支出**（输出）** |
| ViewReport.StatementOfOperation.Export   | 系统执行导出操作，参见ViewReport.Export             |
| ViewReport.HotForging                    | 系统允许财务人员执行红冲操作                           |
| ViewReport.HotForging.New                | 财务人员新建单据                                 |
| ViewReport.HotForging.Copy               | 财务人员执行红冲操作，复制目标单据，财务人员修改单据**（输入）**       |
| ViewReport.HotForging.Commit             | 财务人员提交单据，系统发送单据给总经理，并修改系统数据**（逻辑文件，输出）** |
| ViewReport.HotForging.Discard            | 系统允许财务人员放弃红冲操作                           |
| ViewReport.Export                        | 在导出表单之前，财务人员应该先选择要导出的具体报表**（输入，外部接口）**   |
| ViewReport.Export.Concle                 | 在报表导出的初始阶段，系统允许财务人员取消导出报表                |



| 输入      | 7                     |
| ------- | --------------------- |
| 输出      | 11                    |
| 查询      | 4                     |
| 内部逻辑文件  | 1                     |
| 对外接口文件  | 1                     |
| 功能点测度总数 | 7x4+11x5+4x4+10+7=116 |
| FP      | 117.16                |



### 2.13 期初建账

| InitialAccount.Exit              | 系统应该允许财务人员退出期初建账界面                       |
| -------------------------------- | ---------------------------------------- |
| InitialAccount.Initialize        | 财务人员填写初始化信息, 添加商品信息（商品分类，某一商品的名称，类别，型号，进价/售价(默认为上年平均)，最近进价和最近售价留空），客户信息（客户分类，某一个客户的名称，联系方式等，应收应付(之前遗留)），银行账户信息（名称，余额）**(输入)** |
| InitialAccount.Initialize.Wrong  | 财务人员在填写信息时出现格式错误时，系统应返回格式错误，并标记错误出处**（输出，逻辑文件，查询）** |
| InitialAccount.Initialize.quit   | 财务人员在填写报表时，可以选择放弃报表，系统会返回上一界面，不保存已修改信息   |
| InitialAccount.Initialize.Save   | 财务人员在保存期初建账时，系统会提示是否建账，选择保存，则修改系统数据，并保存账户至账户列表**（输出，逻辑文件）** |
| InitialAccount.Initialize.Concle | 财务人员在保存期初建账时，系统会提示是否建账，选择放弃，则放弃填写的账户数据，并返回至账户初始化界面**（输出）** |



| 输入      | 1                   |
| ------- | ------------------- |
| 输出      | 3                   |
| 查询      | 1                   |
| 内部逻辑文件  | 2                   |
| 对外接口文件  | 0                   |
| 功能点测度总数 | 1x4+3x5+1x4+2x10=43 |
| FP      | 43.43               |



### 2.14 查看导出销售明细表

| SalesList.Login.Wait         | 系统提示用户输入登录名和密码（输出）                       |
| ---------------------------- | ---------------------------------------- |
| SalesList.Login.Input        | 系统获取用户输入的登录名和密码（输入）                      |
| SalesList.Login.Check        | 系统判定用户名和密码是否匹配                           |
| SalesList.Login.Valid        | 系统提示用户登录成功并修改登录状态（输出、逻辑文件）               |
| SalesList.Login.Invalid      | 系统提示用户登录失败，用户名和密码不匹配（输出）                 |
| SalesList.Login.Exit         | 用户放弃登录，选择退出系统                            |
| SalesList.Login.Retry        | 用户要求重新登录，参见SalesList.Login.Wait（查询）      |
| SalesList.Limits.Application | 用户向系统申请查询销售明细表（查询）                       |
| SalesList.Limits.Check       | 系统查询用户权限信息以确认是否允许查询（逻辑文件）                |
| SalesList.Limits.Valid       | 系统提示用户权限合法，并提示用户选择筛选条件，参见SalesList.Condition.Show（输出） |
| SalesList.Limits.Invalid     | 系统提示用户权限不足无法查看报表，要求用户退出查看经营情况表功能，参见SalesList.Exit（输出） |
| SalesList.Condition.Show     | 系统显示筛选条件：**时间区间，商品名，客户，业务员，仓库（**输出、逻辑文件**）** |
| SalesList.Condition.Input    | 用户输入筛选条件（输入）                             |
| SalesList.Condition.Clear    | 用户要求系统清空所有已选的筛选条件（查询）                    |
| SalesList.Condition.Invalid  | 系统提示用户输入的条件不完整或不合法，要求用户重新输入（参见SalesList.Condition.Input）或退出查询报表功能（参见SalesList.Exit）（输出） |
| SalesList.Condition.Rechoose | 用户重新输入条件                                 |
| SalesList.Condition.Search   | 用户要求系统查询符合条件的报表（查询）                      |
| SalesList.Show.List          | 系统显示符合筛选条件的报表（输出、逻辑文件）                   |
| SalesList.Show.Null          | 系统提示用户当前条件下没有符合要求的报表（输出）                 |
| SalesList.Show.Export        | 用户要求系统导出当前报表，参见SalesList.Export（查询）      |
| SalesList.Show.Exit          | 用户要求退出查看报表功能，参见SalesList.Exit（查询）        |
| SalesList.Export.Outout      | 系统导出用户要求的报表并存放在本地                        |
| SalesList.Export.Reminder    | 系统提示用户当前报表已导出（输出）                        |
| SalesList.Export.Continue    | 用户要求继续查看报表，系统返回上层界面，参见SalesList.Condition.Show（查询） |
| SalesList.Exit               | 系统退出导出报表功能                               |

| 输入      | 2                         |
| ------- | ------------------------- |
| 输出      | 10                        |
| 查询      | 5                         |
| 内部逻辑文件  | 4                         |
| 对外接口文件  | 0                         |
| 功能点测度总数 | 2*4+10*5+5*4+4*10+0*7=118 |
| FP      | 165*（0.65+0.01*36）=119.18 |

### 2.15查看导出经营情况表

| ManageList.Login.Wait         | 系统提示用户输入登录名和密码（输出）                       |
| ----------------------------- | ---------------------------------------- |
| ManageList.Login.Input        | 系统获取用户输入的登录名和密码（输入）                      |
| ManageList.Login.Check        | 系统判定用户名和密码是否匹配                           |
| ManageList.Login.Valid        | 系统提示用户登录成功并修改登录状态（输出、逻辑文件）               |
| ManageList.Login.Invalid      | 系统提示用户登录失败，用户名和密码不匹配（输出）                 |
| ManageList.Login.Exit         | 用户放弃登录，选择退出系统                            |
| ManageList.Login.Retry        | 用户要求重新登录，参见SalesList.Login.Wait（查询）      |
| ManageList.Limits.Application | 用户向系统申请查询销售明细表（查询）                       |
| ManageList.Limits.Check       | 系统查询用户权限信息以确认是否允许查询（逻辑文件）                |
| ManageList.Limits.Valid       | 系统提示用户权限合法，并提示用户选择筛选条件，参见ManageList.Condition.Show（输出） |
| ManageList.Limits.Invalid     | 系统提示用户权限不足无法查看报表，要求用户退出查看经营情况表功能，参见ManageList.Exit（输出） |
| ManageList.Condition.Show     | 系统显示筛选条件：时间区间，商品名，客户，业务员，仓库（输出、逻辑文件）     |
| ManageList.Condition.Input    | 用户输入筛选条件（输入）                             |
| ManageList.Condition.Clear    | 用户要求系统清空所有已选的筛选条件（查询）                    |
| ManageList.Condition.Invalid  | 系统提示用户输入的条件不完整或不合法，要求用户重新输入（参见ManageList.Condition.Input）或退出查询报表功能（参见ManageList.Exit）（输出） |
| SalesList.Condition.Rechoose  | 用户重新输入条件                                 |
| ManageList.Condition.Search   | 用户要求系统查询符合条件的报表（查询）                      |
| ManageList.Show.List          | 系统显示符合筛选条件的报表（输出、逻辑文件）                   |
| ManageList.Show.Null          | 系统提示用户当前条件下没有符合要求的报表（输出）                 |
| ManageList.Show.Export        | 用户要求系统导出当前报表，参见ManageList.Export（查询）     |
| ManageList.Show.Exit          | 用户要求退出查看报表功能，参见ManageList.Exit（查询）       |
| ManageList.Export.Outout      | 系统导出用户要求的报表并存放在本地                        |
| ManageList.Export.Reminder    | 系统提示用户当前报表已导出（输出、逻辑文件）                   |
| ManageList.Export.Continue    | 用户要求继续查看报表，系统返回上层界面，参见ManageList.Condition.Show（查询） |
| ManageList.Exit               | 系统退出导出报表功能                               |

| 输入      | 2                         |
| ------- | ------------------------- |
| 输出      | 10                        |
| 查询      | 5                         |
| 内部逻辑文件  | 5                         |
| 对外接口文件  | 0                         |
| 功能点测度总数 | 2*4+10*5+5*4+5*10+0*7=128 |
| FP      | 165*（0.65+0.01*36）=129.28 |

### 2.16审批单据

| Receipt.Login.Wait         | 系统提示用户输入登录名和密码（输出）                       |
| -------------------------- | ---------------------------------------- |
| Receipt.Login.Input        | 系统获取用户输入的登录名和密码（输入）                      |
| Receipt.Login.Check        | 系统判定用户名和密码是否匹配                           |
| Receipt.Login.Valid        | 系统提示用户登录成功并修改登录状态（输出、逻辑文件）               |
| Receipt.Login.Invalid      | 系统提示用户登录失败，用户名和密码不匹配（输出）                 |
| Receipt.Login.Exit         | 用户放弃登录，选择退出系统                            |
| Receipt.Login.Retry        | 用户要求重新登录，参见Receipt.Login.Wait（查询）        |
| Receipt.Limits.Application | 用户向系统申请审批单据（查询）                          |
| Receipt.Limits.Check       | 系统查询用户权限信息以确认是否允许审批（逻辑文件）                |
| Receipt.Limits.Valid       | 系统提示用户权限合法，并显示当前单据列表，参见Receipt.Show（输出）  |
| Receipt.Limits.Invalid     | 系统提示用户权限不足无法审批单据，要求用户退出审批单据功能，参见Receipt.Exit（输出） |
| Receipt.Show.List          | 系统显示当前提交单据列表（输出、逻辑文件）                    |
| Receipt.Show.Null          | 系统提示当前没有提交单据（输出）                         |
| Receipt.Show.Read          | 用户点击一张单据，系统显示其详细信息（查询、逻辑文件）              |
| Receipt.Show.Exit          | 用户要求退出审批单据功能，参见Receipt.Exit（查询）          |
| Receipt.Check.Select       | 用户选中要审批的单张或多张单据并确认（输入）                   |
| REceipt.Check.Reminder     | 系统提示用户选择批准或不批准（输出）                       |
| Receipt.Check.Commit       | 用户选择批准单据或不批准单据                           |
| Receipt.Check.Clear        | 用户要求系统清空已选单据重新选择（查询）                     |
| Receipt.Check.Cancel       | 用户放弃审批单据，参见Receipt.Exit                  |
| Receipt.Process.Pass       | 系统修改用户审批通过的单据的审核状态为批准（逻辑文件）              |
| Receipt.Process.Fail       | 系统修改用户审批不通过的单据状态为不批准（逻辑文件）               |
| Receipt.Process.Update     | 系统根据审批通过的单据的数据更新后台数据（逻辑文件）               |
| Receipt.Process.Inform     | 系统向被审批单据的提交者发送消息来提示其提交单据的状态（逻辑文件）        |
| Receipt.Process.Refresh    | 系统在当前提交单据列表中删除被审批的单据，显示当前提交单据列表（输出、逻辑文件） |
| Receipt.Continue           | 系统返回上层界面允许用户继续审批单据，参见Receipt.Show.List（输出） |
| Receipt.Exit               | 系统退出审批单据功能                               |

| 输入      | 2                         |
| ------- | ------------------------- |
| 输出      | 10                        |
| 查询      | 5                         |
| 内部逻辑文件  | 9                         |
| 对外接口文件  | 0                         |
| 功能点测度总数 | 2*4+10*5+5*4+9*10+0*7=168 |
| FP      | 168*（0.65+0.01*36）=169.68 |

### 2.17 查询日志

| Log.Login              | 系统应当读取用户输入的用户名和密码来判定是否允许登录               |
| ---------------------- | ---------------------------------------- |
| Log.Login.Wait         | 系统提示用户输入登录名和密码（输出）                       |
| Log.Login.Input        | 系统获取用户输入的登录名和密码（输入）                      |
| Log.Login.Check        | 系统判定用户名和密码是否匹配                           |
| Log.Login.Valid        | 系统提示用户登录成功并修改登录状态（输出、逻辑文件）               |
| Log.Login.Invalid      | 系统提示用户登录失败，用户名和密码不匹配（输出）                 |
| Log.Login.Exit         | 用户放弃登录，选择退出系统                            |
| Log.Login.Retry        | 用户要求重新登录，参见Log.Login.Wait（查询）            |
| Log.Limits.Application | 用户向系统申请查询日志（查询）                          |
| Log.Limits.Check       | 系统查询用户权限信息以确认是否允许查询（逻辑文件）                |
| Log.Limits.Valid       | 系统提示用户权限合法，并显示日志列表，参见Log.Show（输出、逻辑文件）   |
| Log.Limits.Invalid     | 系统提示用户权限不足无法查询日志，要求用户退出查询日志功能，参见Log.Exit（输出） |
| Log.Show.List          | 系统显示当前日志列表（输出、逻辑文件）                      |
| Log.Show.Choose        | 用户选择一条日志要求查看其详细内容（查询）                    |
| Log.Show.Details       | 系统显示用户选择日志的详细内容（输出、逻辑文件）                 |
| Log.Show.Back          | 用户要求返回日志列表（查询）                           |
| Log.Exit               | 系统退出查询日志功能                               |

| 输入      | 1                        |
| ------- | ------------------------ |
| 输出      | 6                        |
| 查询      | 4                        |
| 内部逻辑文件  | 5                        |
| 对外接口文件  | 0                        |
| 功能点测度总数 | 1*4+6*5+4*4+5*10+0*7=100 |
| FP      | 100*（0.65+0.01*36）=101   |

### 2.18 制定促销策略

| Promotion.Login.Wait          | 系统提示用户输入登录名和密码（输出）                       |
| ----------------------------- | ---------------------------------------- |
| Promotion.Login.Input         | 系统获取用户输入的登录名和密码（输入）                      |
| Promotion.Login.Check         | 系统判定用户名和密码是否匹配                           |
| Promotion.Login.Valid         | 系统提示用户登录成功并修改登录状态（输出、逻辑文件）               |
| Promotion.Login.Invalid       | 系统提示用户登录失败，用户名和密码不匹配（输出）                 |
| Promotion.Login.Exit          | 用户放弃登录，选择退出系统                            |
| Promotion.Login.Retry         | 用户要求重新登录，参见Promotion.Login.Wait（查询）      |
| Promotion.Limits.Application  | 用户向系统申请制定促销策略（查询）                        |
| Promotion.Limits.Check        | 系统查询用户权限信息以确认是否允许制定（逻辑文件）                |
| Promotion.Limits.Valid        | 系统提示用户权限合法，并显示起始时间选项，（输出）参见Promotion.Time（输出） |
| Promotion.Limits.Invalid      | 系统提示用户权限不足无法制定策略，要求用户退出制定促销策略列表，参见Promotion.Exit（输出） |
| Promotion.Time.Reminder       | 系统提示用户输入促销的开始和结束时间（输出）                   |
| Promotion.Time.Input          | 系统获取用户输入促销开始的开始和结束时间（输入）                 |
| Promotion.Select.Show         | 系统显示当前可选择促销策略类型（输出、逻辑文件）                 |
| Promotion.Select.Input        | 用户选择一个策略类型点击制定（查询）                       |
| Promotion.Select.Cancel       | 用户放弃制定策略功能，参见Read.Exit                   |
| Promotion.Select.Search       | 系统查询用户选择的促销策略类型需要填写的信息（逻辑文件）             |
| Promotion.Condition.Show      | 系统显示当前促销策略下的需要填写的信息（输出、逻辑文件）             |
| Promotion.Condition.Input     | 用户输入需要填写的信息（输入）                          |
| Promotion.Condition.Clear     | 用户要求系统清空所有已填写的信息（查询）                     |
| Promotion.Condition.Invalid   | 系统提示用户输入的信息不完整或不合法，要求用户重新输入（参见Promotion.Condition.Input）或退出制定策略功能（参见Promotion.Exit）（输出） |
| Promotion.Condition.Rechoose  | 用户要求重新选择促销策略类型，系统返回上一操作界面供用户重新选择，参见Promotion.Select.Show（查询） |
| Promotion.Condition.formulate | 用户要求系统根据当前输入的信息制定促销策略（查询）                |
| Promotion.Condition.Pass      | 系统提示用户新策略制定成功（输出）                        |
| Promotion.Condition.Repeat    | 系统判定促销策略与已有策略重复，要求用户重新输入条件，参见Promotion.Condition.Show（输出、逻辑文件） |
| Promotion.Process.Update      | 系统根据用户输入的策略信息更新后台数据（逻辑文件）                |
| Promotion.Process.Message     | 系统根据策略生成并发送单据（逻辑文件）                      |
| Promotion.Process.Show        | 系统显示用户制定过策略后的当前策略列表（输出、逻辑文件）             |
| Promotion.Continue            | 系统返回选择起始时间界面，参见Promotion.Time.Reminder   |
| Promotion.Exit                | 用户要求退出制定促销策略功能                           |

| 输入      | 3                         |
| ------- | ------------------------- |
| 输出      | 13                        |
| 查询      | 6                         |
| 内部逻辑文件  | 9                         |
| 对外接口文件  | 0                         |
| 功能点测度总数 | 3*4+13*5+6*4+9*10+0*7=191 |
| FP      | 191*（0.65+0.01*36）=192.91 |

**3.场景度量**

**3.1 查看导出销售明细表**

| 查看导出报表 |            |      |      |      |        |        |         |       |
| ------ | ---------- | ---- | ---- | ---- | ------ | ------ | ------- | ----- |
| 编号     | 场景描述       | 输入   | 输出   | 查询   | 内部逻辑文件 | 对外接口文件 | 功能点测度总数 | FP    |
| 1      | 用户登录系统     | 1    | 3    | 1    | 1      | 0      | 33      | 33.33 |
| 2      | 系统审核查看报表权限 | 0    | 2    | 1    | 1      | 0      | 24      | 24.24 |
| 3      | 用户选择筛选条件   | 1    | 2    | 2    | 1      | 0      | 32      | 32.32 |
| 4      | 系统显示报表     | 0    | 2    | 2    | 1      | 0      | 28      | 28.28 |
| 5      | 用户导出报表     | 0    | 1    | 1    | 1      | 0      | 19      | 19.19 |

**3.2 查看导出经营情况表**

| 查看导出报表 |            |      |      |      |        |        |         |       |
| ------ | ---------- | ---- | ---- | ---- | ------ | ------ | ------- | ----- |
| 编号     | 场景描述       | 输入   | 输出   | 查询   | 内部逻辑文件 | 对外接口文件 | 功能点测度总数 | FP    |
| 1      | 用户登录系统     | 1    | 3    | 1    | 1      | 0      | 33      | 33.33 |
| 2      | 系统审核查看报表权限 | 0    | 2    | 1    | 1      | 0      | 24      | 24.24 |
| 3      | 用户选择筛选条件   | 1    | 2    | 2    | 1      | 0      | 32      | 32.32 |
| 4      | 系统显示报表     | 0    | 2    | 2    | 1      | 0      | 28      | 28.28 |
| 5      | 用户导出报表     | 0    | 1    | 1    | 1      | 0      | 19      | 19.19 |

**3.3 审批单据**

| 审批单据 |            |      |      |      |        |        |         |       |
| ---- | ---------- | ---- | ---- | ---- | ------ | ------ | ------- | ----- |
| 编号   | 场景描述       | 输入   | 输出   | 查询   | 内部逻辑文件 | 对外接口文件 | 功能点测度总数 | FP    |
| 1    | 用户登录系统     | 1    | 3    | 1    | 1      | 0      | 33      | 33.33 |
| 2    | 系统审核审批单据权限 | 0    | 2    | 1    | 1      | 0      | 24      | 24.24 |
| 3    | 系统输出单据列表   | 0    | 2    | 2    | 2      | 0      | 38      | 38.38 |
| 4    | 用户审批单据     | 1    | 1    | 1    | 0      | 0      | 13      | 13.13 |
| 5    | 系统进行后台操作   | 0    | 1    | 0    | 5      | 0      | 55      | 55.55 |
| 6    | 用户返回审批单据   | 0    | 1    | 0    | 0      | 0      | 5       | 5.05  |

**3.4 查询日志**

| 查询日志 |            |      |      |      |        |        |         |       |
| ---- | ---------- | ---- | ---- | ---- | ------ | ------ | ------- | ----- |
| 编号   | 场景描述       | 输入   | 输出   | 查询   | 内部逻辑文件 | 对外接口文件 | 功能点测度总数 | FP    |
| 1    | 用户登录系统     | 1    | 3    | 1    | 1      | 0      | 33      | 33.33 |
| 2    | 系统审核查询日志权限 | 0    | 2    | 1    | 1      | 0      | 24      | 24.24 |
| 3    | 用户查询日志     | 0    | 2    | 2    | 2      | 0      | 38      | 38.38 |

**3.5 制定促销策略**

| 制定促销策略 |            |      |      |      |        |        |         |       |
| ------ | ---------- | ---- | ---- | ---- | ------ | ------ | ------- | ----- |
| 编号     | 场景描述       | 输入   | 输出   | 查询   | 内部逻辑文件 | 对外接口文件 | 功能点测度总数 | FP    |
| 1      | 用户登录系统     | 1    | 3    | 1    | 1      | 0      | 33      | 33.33 |
| 2      | 系统审核查看报表权限 | 0    | 2    | 1    | 1      | 0      | 24      | 24.24 |
| 3      | 用户选择起始时间   | 1    | 1    | 0    | 0      | 0      | 9       | 9.09  |
| 4      | 用户选择促销策略类型 | 0    | 1    | 1    | 2      | 0      | 29      | 29.29 |
| 5      | 用户填写策略信息   | 1    | 4    | 3    | 2      | 0      | 56      | 56.56 |
| 6      | 系统进行后台操作   | 0    | 1    | 0    | 3      | 0      | 10      | 10.10 |

## 3 其他参数
用例数量：15<br>
场景数量：25<br>
功能需求数量：15<br>
非功能需求数量：10<br>
功能点数量：如上<br>


