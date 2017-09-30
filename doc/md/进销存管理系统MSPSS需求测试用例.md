# 进销存管理系统MSPSS需求测试用例

# <center>进销存管理系统</center>



# <center>MSPSS(Management System of Purchase-Sell-Stock)</center>





# <center> 需求测试用例</center>





# <center>v1.0 正式版</center>

<br><br><br>

## <center>南京大学FX工作组</center><br><center>伏家兴，韩新虎，刘雅歆，徐光耀</center><br><center>2017-09-30</center>

## 用例1 商品分类

### 1.1测试用例套件

| ID     | 输入--选择要进行的操作 | 输入--下一步操作 | 输入--分类位置 | 输入--分类信息 | 预期输出             |
| ------ | ------------ | --------- | -------- | -------- | ---------------- |
| TUS1-1 | 增加分类         |           | 单独的节点    | 正确信息     | 提示添加成功，并更新数据库    |
| TUS1-2 | 增加分类         |           | 存在商品的节点  |          | 提示已存在商品，无法添加分类   |
| TUS1-3 | 增加分类         |           | 单独的节点    | 残缺信息     | 提示信息不全，重新输入或取消操作 |
| TUS1-4 | 删除分类         |           | 单独的节点    |          | 提示删除成功           |
| TUS1-5 | 删除分类         |           | 存在商品的节点  |          | 提示删除失败           |
| TUS1-6 | 修改分类         | 选择修改节点位置  | 单独的节点    |          | 提示修改成功           |
| TUS1-7 | 修改分类         | 选择修改节点    | 存在商品的节点  |          | 提示修改失败           |
| TUS1-8 | 修改分类         | 选择修改节点名称  |          | 正确信息     | 提示修改成功           |




###1.2测试套件覆盖情况

| 编号                               | 1    | 2    | 3    | 4    | 5    | 6    | 7    | 8    |
| -------------------------------- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | ---- |
| Classification.Start             | 1    | 2    | 3    | 4    | 5    | 6    | 7    | 8    |
| Classification.Input             | 1    |      | 3    |      |      |      |      |      |
| Classification.Select            | 1    | 2    | 3    | 4    | 5    | 6    | 7    | 8    |
| Classification.Select.Add        | 1    | 2    | 3    |      |      |      |      |      |
| Classification.Select.Delete     |      |      |      | 4    | 5    |      |      |      |
| Classification.Select.Modify     |      |      |      |      |      | 6    | 7    | 8    |
| Classification.Select.End        | 1    | 2    | 3    | 4    | 5    | 6    |      |      |
| Classification.Add.Select        | 1    | 2    | 3    |      |      |      |      |      |
| Classification.Add.Description   | 1    |      | 3    |      |      |      |      |      |
| Classification.Add.Submit        | 1    |      | 3    |      |      |      |      |      |
| Classification.Add.Invalid       |      | 2    | 3    |      |      |      |      |      |
| Classification.Delete.Select     |      |      |      | 4    | 5    |      |      |      |
| Classification.Delete.Submit     |      |      |      | 4    |      |      |      |      |
| Classification.Delete.Invalid    |      |      |      |      | 5    |      |      |      |
| Classification.Modify.Select     |      |      |      |      |      | 6    | 7    |      |
| Classification.Modify.Name       |      |      |      |      |      |      | 7    | 8    |
| Classification.Modify.Name.Input |      |      |      |      |      |      | 7    | 8    |
| Classification.Modify.Location   |      |      |      |      |      | 6    |      |      |
| Classification.Modify.Submit     |      |      |      |      |      | 6    |      |      |
| Classification.Modify.Invalid    |      |      |      |      |      |      |      | 8    |



## 用例2 商品管理

### 2.1测试用例套件

| ID      | 输入<br> 选择要进行的操作 | 输入<br> 商品关键字 | 输入<br> 商品信息 | 输入<br> 选中商品 | 预期输出          |
| ------- | --------------- | ------------ | ----------- | ----------- | ------------- |
| TUS2-1  | 增加商品            |              | 正确信息        |             | 提示增加成功        |
| TUS2-2  | 增加商品            |              | 残缺信息        |             | 提示重新输入或取消增加商品 |
| TUS2-3  | 增加商品            |              |             |             | 提示输入商品信息      |
| TUS2-4  | 删除商品            | 正确关键字        |             |             | 系统显示满足关键字的列表  |
| TUS2-5  | 删除商品            | 错误关键字或空      |             |             | 系统提示无相关商品     |
| TUS2-6  | 删除商品            | 正确关键字        |             | 已有记录的商品     | 提示无法删除        |
| TUS2-7  | 删除商品            | 正确关键字        |             | 无记录的商品      | 提示删除成功        |
| TUS2-8  | 修改商品            | 正确关键字        | 正确信息        |             | 提示修改成功        |
| TUS2-9  | 修改商品            | 正确关键字        | 残缺信息        |             | 提示重新输入或者取消修改  |
| TUS2-10 | 查看商品            | 正确关键字        |             |             | 系统显示满足关键字的列表  |
| TUS2-11 | 查看商品            | 正确关键字        |             | 任一显示的商品     | 系统显示该商品的信息    |

###

### 2.2 测试套件覆盖情况

| 编号                           | 1    | 2    | 3    | 4    | 5    | 6    | 7    | 8    | 9    | 10   | 11   |
| ---------------------------- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| Management.Start             | 1    | 2    | 3    | 4    | 5    | 6    | 7    | 8    | 9    | 10   | 11   |
| Management.End               |      |      |      |      |      |      |      |      |      | 10   | 11   |
| Management.Select            | 1    | 2    | 3    | 4    | 5    | 6    | 7    | 8    | 9    | 10   | 11   |
| Management.Select.Add        | 1    | 2    | 3    |      |      |      |      |      |      |      |      |
| Management.Select.Delete     |      |      |      | 4    | 5    | 6    | 7    |      |      |      |      |
| Management.Select.Modify     |      |      |      |      |      |      |      | 8    | 9    |      |      |
| Management.Input             | 1    | 2    |      |      |      |      | 7    | 8    | 9    | 10   | 11   |
| Management.Input.Keyword     |      |      |      | 4    | 5    |      | 7    |      |      | 10   | 11   |
| Management.Input.Information | 1    | 2    |      |      |      |      |      | 8    | 9    |      |      |
| Management.Input.Invalid     |      | 2    |      |      | 5    |      |      |      |      |      |      |
| Management.Select.Obeserve   |      |      |      |      |      |      |      |      |      |      |      |
| Management.Add.Input         | 1    |      | 3    |      |      |      |      |      |      |      |      |
| Management.Add.Submit        | 1    |      |      |      |      |      |      |      |      |      |      |
| Management.Add.Invalid       |      | 2    |      |      |      |      |      |      |      |      |      |
| Management.Add.Blank         |      | 2    |      |      |      |      |      |      |      |      |      |
| Management.Delete            |      |      |      | 4    | 5    | 6    | 7    |      |      |      |      |
| Management.Delete.Input      |      |      |      | 4    | 5    | 6    | 7    |      |      |      |      |
| Management.Delete.List       |      |      |      |      | 5    | 6    | 7    |      |      |      |      |
| Management.Delete.Determine  |      |      |      |      |      | 6    | 7    |      |      |      |      |
| Management.Delete.End        |      |      |      |      |      |      | 7    |      |      |      |      |
| Management.Modify            |      |      |      |      |      |      |      | 8    | 9    |      |      |
| Management.Modify.Input      |      |      |      |      |      |      |      | 8    | 9    |      |      |
| Management.Modify.List       |      |      |      |      |      |      |      | 8    | 9    |      |      |
| Management.Modify.Determine  |      |      |      |      |      |      |      | 8    | 9    |      |      |
| Management.Modify.Submit     |      |      |      |      |      |      |      | 8    | 9    |      |      |
| Management.Modify.Invalid    |      |      |      |      |      |      |      |      | 9    |      |      |
| Management.Observe           |      |      |      |      |      |      |      |      |      | 10   | 11   |
| Management.Observe.Input     |      |      |      |      |      |      |      |      |      | 10   | 11   |
| Management.Observe.List      |      |      |      |      |      |      |      |      |      |      | 11   |
| Management.Observe.Select    |      |      |      |      |      |      |      |      |      |      | 11   |

## 用例3 库存查看

### 3.1测试用例套件

| ID     | 输入--起始时间  | 输入--结束时间  |      | 预期输出                              |
| ------ | --------- | --------- | ---- | --------------------------------- |
| TUS3-1 | 2017-9-1  | 2017-9-8  |      | 显示出2017-9-1至2017-9-8的所有出库入库情况     |
| TUS3-2 | 2017-9-29 | 2017-9-10 |      | 提示输入时间有误                          |
| TUS3-3 | 2018-9-30 | 2018-10-1 |      | 显示无入库出库情况                         |
| TUS3-4 |           |           | 退出   | 返回至上一界面                           |
| TUS3-5 | 2017-5-1  | 2017-5-30 | 退出   | 显示2017-5-1至2017-5-30内所有的出入库情况，并退出 |

### 3.2 测试用例套件覆盖情况

| 编号                    | 1    | 2    | 3    | 4    | 5    |
| --------------------- | ---- | ---- | ---- | ---- | ---- |
| Check.Time            | 1    | 2    | 3    |      | 5    |
| Check.Display         | 1    |      |      |      | 5    |
| Check.Display.Invalid |      | 2    | 3    |      |      |
| Check.End             |      |      |      | 4    | 5    |



## 用例4 库存盘点

### 4.1测试用例套件



| ID     | 输入--请求盘点 | 输入--确认盘点 | 输入--返回上一界面 | 预期输出                         |
| ------ | -------- | -------- | ---------- | ---------------------------- |
| TUS4-1 | 请求盘点     |          |            | 系统列出当天的所有出入库信息               |
| TUS4-2 | 请求盘点     | 确认盘点     |            | 系统列出当天的所有出入库信息，并更新数据库        |
| TUS4-3 |          |          | 返回上一界面     | 系统返回上一界面                     |
| TUS4-4 | 请求盘点     | 确认盘点     | 返回上一界面     | 系统列出当天的所有出入库信息并更新数据库然后返回上一界面 |



### 4.2 测试用例套件覆盖情况

| 编号               | 1    | 2    | 3    | 4    |
| ---------------- | ---- | ---- | ---- | ---- |
| Inventory        | 1    | 2    |      | 4    |
| Inventory.Finish |      | 2    |      | 4    |
| Inventory.Cancel |      |      | 3    | 4    |

## 用例5 处理库存单据

### 5.1测试用例套件

| ID     | 输入--选择库存赠送单 | 输入--选择库存报损报溢单 | 输入--库存报警单 | 输入--更新库存信息 | 输入--库存信息 | 预期输出               |
| ------ | ----------- | ------------- | --------- | ---------- | -------- | ------------------ |
| TUS5-1 | √           |               |           |            |          | 显示库存赠送单信息          |
| TUS5-2 | √           |               |           | √          |          | 显示库存赠送单，库存信息更新。    |
| TUS5-3 |             | √             |           |            |          | 显示库存报损单或库存报溢单的模板   |
| TUS5-4 |             | √             |           |            | 正确信息     | 显示库存报损单或库存报溢单成功发送  |
| TUS5-4 |             |               | √         |            |          | 显示库存报警单模板          |
| TUS5-5 |             |               | √         |            | 正确信息     | 显示库存报警单成功发送        |
| TUS5-6 |             | √             |           |            | 错误信息     | 系统提示输入非法请重新输入或取消操作 |
| TUS5-7 |             |               | √         |            | 错误信息     | 系统提示输入非法请重新输入或取消操作 |



### 5.2 测试用例套件对需求的覆盖情况

| 编号                        | 1    | 2    | 3    | 4    | 5    | 6    | 7    |
| ------------------------- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| Invoices.Input            |      | 2    |      | 4    |      | 6    | 7    |
| Invoices.Input.Invalid    |      |      |      |      |      | 6    | 7    |
| Invoices.Start            | 1    | 2    | 3    | 4    | 5    | 6    | 7    |
| Invoices.Select           | 1    | 2    | 3    | 4    | 5    | 6    | 7    |
| Invoices.Select.Present   | 1    | 2    |      |      |      |      |      |
| Invoices.Select.Repetory  |      |      | 3    | 4    |      | 6    |      |
| Invoices.Select.Alert     |      |      |      |      | 5    |      | 7    |
| Invoices.End              |      |      |      |      |      |      |      |
| Invoices.Present          | 1    | 2    |      |      |      |      |      |
| Invoices.Present.Update   |      | 2    |      |      |      |      |      |
| Invoices.Present.Done     |      | 2    |      |      |      |      |      |
| Invoices.Repertory        |      |      | 3    | 4    |      | 6    |      |
| Invoices.Repertory.Input  |      |      |      | 4    |      | 6    |      |
| Invoices.Repertory.Submit |      |      |      | 4    |      | 6    |      |
| Invoices.Alert            |      |      |      |      | 5    |      | 7    |
| Invoices.Alert.Input      |      |      |      |      |      |      | 7    |
| Invoices.Alert.Submit     |      |      |      |      |      |      | 7    |

## 用例 6 客户管理

###6.1 测试用例套件

| ID      | 输入--操作            | 输入--客户信息       | 预期输出                       |
| :------ | ----------------- | -------------- | -------------------------- |
| TUS6-1  | 选择查找客户            |                | 显示搜索框                      |
| TUS6-2  | 确认查找              | 输入的关键字或者编号存在   | 系统显示符合搜索信息的所有客户            |
| TUS6-3  | 确认查找              | 输入的关键字或者编号不存在  | 系统提示该用户不存在，提示重新输入          |
| TUS6-4  | 选择增加客户            |                | 显示填写增加客户信息的界面              |
| TUS6-5  | 确认增加              | 输入的客户信息与系统中无重复 | 系统新建客户，提示增加成功              |
| TUS6-6  | 确认增加              | 输入的客户信息与系统中重复  | 系统报错，提示核对信息重新输入            |
| TUS6-7  | 确认增加              | 输入的客户信息有缺失     | 系统报错，提示核对信息重新输入            |
| TUS6-8  | 选择删除已输入的信息        |                | 系统删除已输入的信息                 |
| TUS6-9  | 选择取消任务            | 已输入信息          | 系统询问是否需要关闭任务               |
| TUS6-10 | 选择取消任务            | 未输入信息          | 系统关闭任务，回到上一界面              |
| TUS6-11 | 确认取消任务            |                | 系统关闭任务，回到上一界面              |
| TUS6-12 | 选择删除客户            |                | 系统显示删除客户任务的界面              |
| TUS6-13 | 选中要删除的客户并点击删除     |                | 系统询问是否删除该客户的信息             |
| TUS6-14 | 确认删除客户            |                | 系统删除客户信息，并返回删除成功           |
| TUS6-15 | 选择修改客户属性          |                | 显示修改客户属性的界面                |
| TUS6-16 |                   | 输入的信息不符合数据规范   | 系统报错，提示重新输入                |
| TUS6-17 |                   | 输入的信息符合数据规范    | 系统等待下一步输入                  |
| TUS6-18 | 点击修改客户属性的命令       |                | 系统询问是否修改客户属性               |
| TUS6-19 | 确认修改              |                | 系统修改该客户的属性，更新数据库。显示修改后的信息。 |
| TUS6-20 | 完成当前操作后，输入结束任务的命令 |                | 系统结束当前任务，返回上一界面            |



### 6.2测试用例套件覆盖情况



| 编号                                    | TUS6-1 | TUS6-2 | TUS6-3 | TUS6-4 | TUS6-5 | TUS6-6 | TUS6-7 | TUS6-8 | TUS6-9 | TUS6-10 | TUS6-11 |
| ------------------------------------- | :----: | :----: | :----: | :----: | :----: | :----: | :----: | :----: | :----: | :-----: | :-----: |
| CustomerManager.Seek                  |   1    |   2    |   3    |        |        |        |        |   8    |        |         |         |
| CustomerManager.Seek.Input            |        |   2    |   3    |        |        |        |        |        |        |         |         |
| CustomerManager.Seek.End              |        |        |        |        |        |        |        |        |        |         |         |
| CustomerManager.Seek.Del              |        |        |        |        |        |        |        |   8    |        |         |         |
| CustomerManager.Seek.Valid            |        |   2    |        |        |        |        |        |        |        |         |         |
| CustomerManager.Seek.Invalid          |        |        |   3    |        |        |        |        |        |        |         |         |
| CustomerManager.Add                   |        |        |        |   4    |   5    |   6    |   7    |   8    |   9    |   10    |         |
| CustomerManager.Add.Input             |        |        |        |        |   5    |   6    |   7    |        |        |         |         |
| CustomerManager.Add.Del               |        |        |        |        |        |        |        |   8    |        |         |         |
| CustomerManager.Add.Seek              |        |        |        |        |        |        |        |        |        |         |         |
| CustomerManager.Add.Invalid.Repeat    |        |        |        |        |        |   6    |        |        |        |         |         |
| CustomerManager.Add.Invalid.Lack      |        |        |        |        |        |        |   7    |        |        |         |         |
| CustomerManager.Add.Valid             |        |        |        |        |   5    |        |        |        |        |         |         |
| CustomerManager.Add.End               |        |        |        |        |        |        |        |        |   9    |   10    |         |
| CustomerManager.Add.End.Null          |        |        |        |        |        |        |        |        |        |   10    |         |
| CustomerManager.Add.End.Uninish       |        |        |        |        |        |        |        |        |   9    |         |         |
| CustomerManager.Add.Update            |        |        |        |        |   5    |        |        |        |        |         |         |
| CustomerManager.Del                   |        |   2    |   3    |        |        |        |        |        |        |         |   11    |
| CustomerManager.Del.Input             |        |   2    |   3    |        |        |        |        |        |        |         |         |
| CustomerManager.Del.Seek              |        |   2    |   3    |        |        |        |        |        |        |         |         |
| CustomerManager.Del.Seek.Invalid      |        |        |   3    |        |        |        |        |        |        |         |         |
| CustomerManager.Del.Seek.Valid        |        |   2    |        |        |        |        |        |        |        |         |         |
| CustomerManager.Del.Start             |        |        |        |        |        |        |        |        |        |         |         |
| CustomerManager.Del.Check             |        |        |        |        |        |        |        |        |        |         |         |
| CustomerManager.Del.End               |        |        |        |        |        |        |        |        |        |         |   11    |
| CustomerManager.Del.End.Cancel        |        |        |        |        |        |        |        |        |        |         |   11    |
| CustomerManager.Del.End.Update        |        |        |        |        |        |        |        |        |        |         |         |
| CustomerManager.Modify                |        |   2    |   3    |        |        |        |        |        |   9    |   10    |   11    |
| CustomerManager.Modify.Start          |        |        |        |        |        |        |        |        |        |         |         |
| CustomerManager.Modify.Input          |        |        |        |        |        |        |        |        |        |         |         |
| CustomerManager.Modify. Input.Invalid |        |        |        |        |        |        |        |        |        |         |         |
| CustomerManager.Modify.Input.Valid    |        |        |        |        |        |        |        |        |        |         |         |
| CustomerManager.Modify.End            |        |        |        |        |        |        |        |        |   9    |   10    |   11    |
| CustomerManager.Modify.End.Cancel     |        |        |        |        |        |        |        |        |   9    |   10    |   11    |
| CustomerManager.Modify.End.Update     |        |        |        |        |        |        |        |        |        |         |         |



| 编号                                    | TUS6-12 | TUS6-13 | TUS6-14 | TUS6-15 | TUS6-16 | TUS6-17 | TUS6-18 | TUS6-19 | TUS6-20 |      |
| ------------------------------------- | :-----: | :-----: | :-----: | :-----: | :-----: | :-----: | :-----: | :-----: | :-----: | ---- |
| CustomerManager.Seek                  |         |         |         |         |         |         |         |         |   20    |      |
| CustomerManager.Seek.Input            |         |         |         |         |         |         |         |         |         |      |
| CustomerManager.Seek.End              |         |         |         |         |         |         |         |         |   20    |      |
| CustomerManager.Seek.Del              |         |         |         |         |         |         |         |         |         |      |
| CustomerManager.Seek.Valid            |         |         |         |         |         |         |         |         |         |      |
| CustomerManager.Seek.Invalid          |         |         |         |         |         |         |         |         |         |      |
| CustomerManager.Add                   |         |         |         |         |         |         |         |         |   20    |      |
| CustomerManager.Add.Input             |         |         |         |         |   16    |   17    |         |         |         |      |
| CustomerManager.Add.Del               |         |         |         |         |         |         |         |         |         |      |
| CustomerManager.Add.Seek              |         |         |         |         |         |         |         |         |         |      |
| CustomerManager.Add.Input.Illegal     |         |         |         |         |         |   17    |         |         |         |      |
| CustomerManager.Add.Invalid.Repeat    |         |         |         |         |         |         |         |         |         |      |
| CustomerManager.Add.Invalid.Lack      |         |         |         |         |         |         |         |         |         |      |
| CustomerManager.Add.Valid             |         |         |         |         |   16    |         |         |         |         |      |
| CustomerManager.Add.End               |         |         |         |         |         |         |         |         |   20    |      |
| CustomerManager.Add.End.Null          |         |         |         |         |         |         |         |         |         |      |
| CustomerManager.Add.End.Uninish       |         |         |         |         |         |         |         |         |         |      |
| CustomerManager.Add.Update            |         |         |         |         |         |         |         |         |         |      |
| CustomerManager.Del                   |   12    |   13    |   14    |         |         |         |         |         |   20    |      |
| CustomerManager.Del.Input             |         |         |         |         |         |         |         |         |         |      |
| CustomerManager.Del.Seek              |         |         |         |         |         |         |         |         |         |      |
| CustomerManager.Del.Seek.Invalid      |         |         |         |         |         |         |         |         |         |      |
| CustomerManager.Del.Seek.Valid        |         |         |         |         |         |         |         |         |         |      |
| CustomerManager.Del.Start             |         |   13    |         |         |         |         |         |         |         |      |
| CustomerManager.Del.Check             |         |         |   14    |         |         |         |         |         |         |      |
| CustomerManager.Del.End               |         |   13    |         |         |         |         |         |         |   20    |      |
| CustomerManager.Del.End.Cancel        |         |         |         |         |         |         |         |         |         |      |
| CustomerManager.Del.End.Update        |         |         |   14    |         |         |         |         |         |         |      |
| CustomerManager.Modify                |         |         |         |   15    |   16    |   17    |   18    |   19    |   20    |      |
| CustomerManager.Modify.Start          |         |         |         |   15    |         |         |         |         |         |      |
| CustomerManager.Modify.Input          |         |         |         |         |   16    |   17    |         |         |         |      |
| CustomerManager.Modify. Input.Invalid |         |         |         |         |         |   17    |         |         |         |      |
| CustomerManager.Modify.Input.Valid    |         |         |         |         |   16    |         |         |         |         |      |
| CustomerManager.Modify.End            |         |         |         |         |         |         |   18    |   19    |   20    |      |
| CustomerManager.Modify.End.Cancel     |         |         |         |         |         |         |         |         |         |      |
| CustomerManager.Modify.End.Update     |         |         |         |         |         |         |   18    |   19    |         |      |



## 用例7 制定进货单和进货退货单

###7.1 测试用例套件

| ID     | 输入--操作     | 输入--单据信息  | 预期输出               |
| ------ | ---------- | --------- | ------------------ |
| TUS7-1 | 选择要制定的单据类型 |           | 显示该种单据的界面          |
| TUS7-2 |            | 单据信息符合规范  | 系统等待下一步输入          |
| TUS7-3 |            | 单据信息不符合规范 | 系统报错，提示重新输入        |
| TUS7-4 | 确认制定       | 单据信息符合规范  | 系统制定单据，提示制定成功      |
| TUS7-5 | 确认制定       | 单据信息有遗漏   | 系统报错、提示核对信息重新输入    |
| TUS7-6 | 取消制定单据     | 单据信息未填写   | 系统关闭制定单据的任务，返回上一状态 |
| TUS7-7 | 取消制定单据     | 已输入部分单据信息 | 系统询问是否关闭制定单据任务     |
| TUS7-8 | 确认取消       |           | 系统关闭制定单据的任务，返回上一状态 |
|        |            |           |                    |
|        |            |           |                    |

### 7.2测试用例套件覆盖情况

| 编号                         | TUS7-1 | TUS7-2 | TUS7-3 | TUS7-4 | TUS7-5 | TUS7-6 | TUS7-7 | TUS7-8 |      |
| -------------------------- | :----: | :----: | :----: | :----: | :----: | :----: | :----: | :----: | ---- |
| MakeReceipt.Select         |   1    |        |        |        |        |        |        |        |      |
| MakeReceipt.Input          |        |   2    |   3    |        |        |        |        |        |      |
| MakeReceipt.Input.Invalid  |        |   2    |        |        |        |        |        |        |      |
| MakeReceipt.Input.Valid    |        |        |   3    |        |        |        |        |        |      |
| MakeReceipt.Create         |        |        |        |   4    |   5    |        |        |        |      |
| MakeReceipt.Create.Invalid |        |        |        |        |   5    |        |        |        |      |
| MakeReceipt.Create.Valid   |        |        |        |   4    |        |        |        |        |      |
| MakeReceipt.End            |        |        |        |   4    |        |   6    |   7    |   8    |      |
| MakeReceipt.End.Close      |        |        |        |        |        |   6    |   7    |        |      |
| MakeReceipt.End.Update     |        |        |        |   4    |        |        |        |        |      |



## 用例8 制定销售单和销售退货单

###8.1 测试用例套件

| ID     | 输入--操作     | 输入--单据信息  | 预期输出               |
| ------ | ---------- | --------- | ------------------ |
| TUS8-1 | 选择要制定的单据类型 |           | 显示该种单据的界面          |
| TUS8-2 |            | 单据信息符合规范  | 系统等待下一步输入          |
| TUS8-3 |            | 单据信息不符合规范 | 系统报错，提示重新输入        |
| TUS8-4 | 确认制定       | 单据信息符合规范  | 系统制定单据，提示制定成功      |
| TUS8-5 | 确认制定       | 单据信息有遗漏   | 系统报错、提示核对信息重新输入    |
| TUS8-6 | 取消制定单据     | 单据信息未填写   | 系统关闭制定单据的任务，返回上一状态 |
| TUS8-7 | 取消制定单据     | 已输入部分单据信息 | 系统询问是否关闭制定单据任务     |
| TUS8-8 | 确认取消       |           | 系统关闭制定单据的任务，返回上一状态 |
|        |            |           |                    |
|        |            |           |                    |

###8.2 测试用例套件覆盖情况

| 编号                         | TUS8-1 | TUS8-2 | TUS8-3 | TUS8-4 | TUS8-5 | TUS8-6 | TUS8-7 | TUS8-8 |      |
| -------------------------- | :----: | :----: | :----: | :----: | :----: | :----: | :----: | :----: | ---- |
| MakeReceipt.Select         |   1    |        |        |        |        |        |        |        |      |
| MakeReceipt.Input          |        |   2    |   3    |        |        |        |        |        |      |
| MakeReceipt.Input.Invalid  |        |   2    |        |        |        |        |        |        |      |
| MakeReceipt.Input.Valid    |        |        |   3    |        |        |        |        |        |      |
| MakeReceipt.Create         |        |        |        |   4    |   5    |        |        |        |      |
| MakeReceipt.Create.Invalid |        |        |        |        |   5    |        |        |        |      |
| MakeReceipt.Create.Valid   |        |        |        |   4    |        |        |        |        |      |
| MakeReceipt.End            |        |        |        |   4    |        |   6    |   7    |   8    |      |
| MakeReceipt.End.Close      |        |        |        |        |        |   6    |   7    |        |      |
| MakeReceipt.End.Update     |        |        |        |   4    |        |        |        |        |      |

##用例9 账户管理

###9.1测试用例套件

| ID     | 输入—任务选择       | 输入信息—模糊查找   | 输入信息—账户信息         | 预期输出                                     |
| ------ | ------------- | ----------- | ----------------- | ---------------------------------------- |
| TUS9-1 | 修改账户          | ”17年公司总帐“   | 名称：“17年上半年总账”     | 显示修改成功，同时账户列表中对应信息已经被修改                  |
| TUS9-2 | 修改账户          | “16年公司总账”   | 名称：“17年上半年总账”     | 显示账户重复，提示重新输入名称，返回修改界面                   |
| TUS9-3 | 无             | “锟斤拷烫烫烫”    | 无                 | 系统提示“系统没有与锟斤拷烫烫烫匹配的账户，请重新输入“             |
| TUS9-4 | 无             | ”17“        | 无                 | 系统输出下列账户信息：”17上半年总账“  ，”17期初账户“，”17第一季度账户“，”17第二季度账户“ |
| TUS9-5 | 增加账户          | 无           | 名称：”17年第二季度账户“并保存 | 系统提示增加账户成功                               |
| TUS9-6 | 删除账户          | ”17年第二季度账户“ | 确认删除              | 系统移除”17年第二季度账户“并修改数据库                    |
| TUS9-7 | 删除账户          | ”17年第一季度账户“ | 取消删除              | 系统提示“删除操作已取消”                            |
| TUS9-8 | 退出账户管理界面并确认退出 | 无           | 无                 | 系统返回上一界面                                 |
| TUS9-9 | 退出账户管理界面并取消退出 | 无           | 无                 | 系统界面不进行退出操作                              |

### 9.2测试用例套件覆盖情况



| 编号                                       | 覆盖情况 | ——   | ——   | ——   | ——   | ——   | ——   | ——   | ——   |
| ---------------------------------------- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
|                                          | 1    | 2    | 3    | 4    | 5    | 6    | 7    | 8    | 9    |
| AccountManage.Exit                       |      |      |      |      |      |      |      | 8    | 9    |
| AccountManage.Check                      | 1    | 2    | 3    | 4    |      | 6    | 7    |      |      |
| AccountManage.Check.Add                  |      |      |      |      | 5    |      |      |      |      |
| AccountManage.Check.Valid                | 1    | 2    |      | 4    | 5    | 6    | 7    |      |      |
| AccountManage.Check.Invalid              |      |      | 3    |      |      |      |      |      |      |
| AccountManage.Check.Valid.Modify         | 1    | 2    |      |      |      |      |      |      |      |
| AccountManage.Check.Valid.Delete         |      |      |      |      |      | 6    | 7    |      |      |
| AccountManage.Modify                     | 1    | 2    |      |      |      |      |      |      |      |
| AccountManage.Modify.Unchangable         | 1    |      |      |      |      |      |      |      |      |
| AccountManage.Modify.Changable           |      | 2    |      |      |      |      |      |      |      |
| AccountManage.Modify.Changable.Repetition |      | 2    |      |      |      |      |      |      |      |
| AccountManage.Modify.End                 | 1    | 2    |      |      |      |      |      | 8    |      |
| AccountManage.Add                        |      |      |      |      | 5    |      |      |      |      |
| AccountManage.Add.Repetition             |      |      |      |      | 5    |      |      |      |      |
| AccountManage.Add.End                    |      |      |      |      | 5    |      |      |      |      |
| AccountManage.Delete                     |      |      |      |      |      | 6    | 7    |      |      |
| AccountManage.Delete.Comfirm             |      |      |      |      |      | 6    | 7    |      |      |
| AccountManage.Delete.Comfirm.Yes         |      |      |      |      |      | 6    |      |      |      |
| AccountManage.Delete.Comfirm.No          |      |      |      |      |      |      | 7    |      |      |
| AccountManage.End                        | 1    |      |      | 4    | 5    | 6    |      | 8    |      |
| AccountManage.End.Save                   | 1    |      |      |      | 5    | 6    |      |      |      |
| AccountManage.End.Discard                |      |      |      |      |      |      |      | 8    |      |
| AccountManage.End.Concel                 |      |      |      |      |      |      |      |      | 9    |

##用例10制定收款单及现金费用单

###10.1 测试用例套件

| ID      | 输入—报表选择 | 输入—报表信息                                  | 输入—审批 | 预期输出                                     |
| ------- | ------- | ---------------------------------------- | ----- | ---------------------------------------- |
| TUS10-1 | 付款单     | ”单据编号：XJFYD-yyyyMMdd-11111<br>操作员：比尔盖茨<br>银行账户：8888888888888888<br>条目清单：比尔盖茨买鲸鱼转账100000人民币，备注：这是IT界的土豪<br>总额：100000（人民币）“<br>    并提交 | 成功    | 系统提示”提交成功“并提交总经理审批，在审批成功后显示”审批成功，请进行实际操作“ |
| TUS10-2 | 付款单     | ”单据编号：XJFYD-yyyyMMdd-11112<br>操作员：马化腾<br>银行账户：8888888888888888<br>条目清单：马化腾冲Q币转给腾讯100人民币，备注：这项不是与公司业务有关的操作<br>总额：100（人民币）“<br>    并提交 | 失败    | 系统提示提交成功并提交总经理审批，在审批之后提示”审批失败，请修改单据“     |
| TUS10-3 | 付款单     | ”单据编号：1234<br>操作员：王小二<br>银行账户：8888888888888888<br>条目清单：购买南大开发的软件花费100万人民币，备注：无br>总额：1000000（人民币）“<br>    并提交 | 无     | 系统提示”单据编号错误“并不予提交                        |
| TUS10-4 | 现金费用单   | ”单据编号：XJFYD-yyyyMMdd-11111<br>操作员：乔布斯<br>银行账户：8888888888888888<br>条目清单：招采购公司食品苹果一袋20元，备注：无<br>总额：50（人民币）“<br>    并提交 | 成功    | 系统提示”提交成功“并提交总经理审批，在审批成功后显示”审批成功，请进行实际操作“ |
| TUS10-5 | 现金费用单   | ”单据编号：XJFYD-yyyyMMdd-11111<br>操作员：雷军<br>银行账户：8888888888888888<br>条目清单：招采购公司食品大米一袋50元，备注：无<br>总额：50（人民币）“<br>    并提交 | 失败    | 系统提示提交成功并提交总经理审批，在审批之后提示”审批失败，请修改单据“     |
| TUS10-6 | 现金费用单   | ”单据编号：1234<br>操作员：王小二<br>银行账户：8888888888888888<br>条目清单：购买南大开发的软件花费100万人民币，备注：无br>总额：1000000（人民币）“<br>    并提交 | 无     | 系统提示”单据编号错误“并不予提交                        |
| TUS10-7 | 付款单     | 取消提交                                     | 无     | 系统返回选择单据界面                               |
| TUS10-8 | 无，退出系统  | 无                                        | 无     | 系统退出，并返回上一界面                             |

## 10.2测试用例套件覆盖情况

| 编号                             | 覆盖情况 | ——   | ——   | ——   | ——   | ——   | ——   | ——   |
| ------------------------------ | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
|                                | 1    | 2    | 3    | 4    | 5    | 6    | 7    | 8    |
| MakeBill.Exit                  |      |      |      |      |      |      |      | 8    |
| MakeBill.Choose                | 1    | 2    | 3    | 4    | 5    | 6    | 7    |      |
| MakeBill.Choose.PayBill        | 1    | 2    | 3    |      |      |      | 7    |      |
| MakeBill.Choose.CashBill       |      |      |      | 4    | 5    | 6    |      |      |
| MakeBill.PayBill               | 1    | 2    | 3    |      |      |      |      |      |
| MakeBill.PayBill.Input         | 1    | 2    | 3    |      |      |      |      |      |
| MakeBill.PayBill.Discard       |      |      | 3    |      |      |      |      |      |
| MakeBill.PayBill.Wrong         |      |      | 3    |      |      |      |      |      |
| MakeBill.PayBill.Input.Commit  | 1    | 2    |      |      |      |      |      |      |
| MakeBill.CashBill              |      |      |      | 4    | 5    | 6    |      |      |
| MakeBill.CashBill.Input        |      |      |      | 4    | 5    | 6    |      |      |
| MakeBill.CashBill.Discard      |      |      |      |      |      | 6    |      |      |
| MakeBill.CashBill.Wrong        |      |      |      |      | 5    | 6    |      |      |
| MakeBill.CashBill.Input.Commit |      |      |      | 4    | 5    |      |      |      |
| MakeBill.Commit                | 1    | 2    |      | 4    |      |      |      |      |
| MakeBill.Commit.Incomplete     |      | 2    |      |      |      |      |      |      |
| MakeBill.Commit.Complete       | 1    |      |      | 4    |      |      |      |      |
| MakeBill.Commit.Complete.Check | 1    |      |      | 4    | 5    |      |      |      |
| MakeBill.Commit.Concel         |      | 2    |      |      |      |      |      |      |
| MakeBill.Check.Finish          | 1    |      |      | 4    |      |      |      |      |
| MakeBill.Check.Finish.Change   | 1    |      |      | 4    |      |      |      |      |
| MakeBill.Discard               |      |      |      |      |      |      | 7    |      |
| MakeBill.Diacard.Sure          |      |      |      |      |      |      | 7    |      |
| MakeBill.Discard.Concel        | 1    |      |      |      |      |      |      |      |

## 用例11 制定付款单

### 11.1 测试用例套件



| ID      | 输入信息                                     | 输入—审批 | 预期信息                                     |
| ------- | ---------------------------------------- | ----- | ---------------------------------------- |
| TUS11-1 | "单据编号:SKD-yyyyMMdd-11111<br>，客户:供应商：华为，销售商：苹果<br>操作员：库克<br>，转账列表：银行账户：888888888，转账金额：100，备注：无<br>总额汇总：100元。"并提交 | 成功    | 系统提示”提交成功“并提交总经理审批，在审批成功后显示”审批成功，请进行实际操作“ |
| TUS11-2 | "单据编号:SKD-yyyyMMdd-11111<br>，客户:供应商：阿里巴巴，销售商：亚马逊<br>操作员：马云<br>，转账列表：银行账户：888888888，转账金额：100，备注：无<br>总额汇总：100元。"并提交 | 失败    | 系统提示提交成功并提交总经理审批，在审批之后提示”审批失败，请修改单据“     |
| TUS11-3 | "单据编号:1234br>，客户:供应商：阿里巴巴，销售商：亚马逊<br>操作员：马云<br>，转账列表：银行账户：888888888，转账金额：100，备注：无<br>总额汇总：100元。"并提交 | 无     | 系统提示”单据编号错误“并不予提交                        |
| TUS11-4 | 无并退出填写                                   | 无     | 系统返回上一界面                                 |

###11.2测试套件覆盖情况

| 编号                                | 覆盖情况 | ——   | ——   | ——   |
| --------------------------------- | ---- | ---- | ---- | ---- |
|                                   | 1    | 2    | 3    | 4    |
| MakeReceipt.Exit                  |      |      |      | 4    |
| MakeReceip.Input                  | 1    | 2    | 3    |      |
| MakeReceipt.Discard               |      | 2    |      |      |
| MakeReceipt.Wrong                 |      | 2    |      |      |
| MakeReceipt.Input.Commit          | 1    |      | 3    |      |
| MakeReceipt.Commit                | 1    |      | 3    |      |
| MakeReceipt.Commit.Incomplete     |      |      | 3    |      |
| MakeReceipt.Commit.Complete       | 1    |      |      |      |
| MakeReceipt.Commit.Complete.Check | 1    |      |      |      |
| MakeReceipt.Commit.Concel         |      |      | 3    |      |
| MakeReceipt.Check.Finish          | 1    |      |      |      |
| MakeReceipt.Check.Finish.Change   | 1    |      |      |      |
| MakeReceipt.Discard               |      | 2    |      |      |
| MakeReceipt.Diacard.Sure          |      | 2    |      |      |
| MakeReceipt.Discard.Concel        |      |      |      | 4    |

##用例12 查看导出报表

### 12.1 测试用例套件



| ID      | 输入信息—报表类型 | 输入信息—查找及导出                               | 预期输出                                     |
| ------- | --------- | ---------------------------------------- | ---------------------------------------- |
| TUS12-1 | 销售明细表     | “时间区间：2017-1-1~2017-6-1<br>商品名：旺仔牛奶<br>客户：王二<br>业务员：比尔盖茨<br>仓库：1“且导出 | 系统显示：”时间：2017-3-1<br>商品名：旺仔牛奶<br>型号：201<br>数量：10000<br>单价：4.5元<br>总额：45000"并导出报表 |
| TUS12-2 | 销售明细表     | “时间区间：2018-11-1~2018-12-1”               | 系统显示“时间区间格式错误：时间区间应在当前时间之前”              |
| TUS12-3 | 经营历程表     | “时间区间：2017-1-1~2017-6-1<br>单据类型：进货类单据<br>客户：王二<br>业务员：比尔盖茨<br>仓库：1“不红冲且导出单取消 | 系统返回当前区间的进货类单据并导出                        |
| TUS12-4 | 经营历程表     | “时间区间：2017-1-1~2017-6-1<br>单据类型：进货类单据<br>客户：王二<br>业务员：比尔盖茨<br>仓库：1“红冲且不导出 | 系统返回当前区间的进货类单据<br>系统随后显示单据（红冲）填写画面,填写画面为当前单据的部分复制 |
| TUS12-5 | 经营情况表     | “时间区间：2017-1-1~2017-6-1"                 | 系统 返回1. 收入类：销售收入、商品类收入（商品报溢收入 成本调价收入 进货退货差价 代金券与实际收款差额收入）。收入类显示折让后总收入，并显示折让了多少。2. 支出类：销售成本、商品类支出（商品报损 商品赠出）。支出类显示总支出。3. 利润：折让后总收入-总支出 |
| TUS12-6 | 经营情况表     | “时间区间：2017-6-1~2017-1-1"                 | 系统显示：”时间区间格式错误：后一个时间不应小于强时间“             |
| TUS12-7 | 无且退出系统    | 无                                        | 系统返回上一界面                                 |

### 12.2 测试用例套件覆盖情况

| 编号                                       | 覆盖情况 | ——   | ——   | ——   | ——   | ——   | ——   |
| ---------------------------------------- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
|                                          | 1    | 2    | 3    | 4    | 5    | 6    | 7    |
| ViewReport.Exit                          |      |      |      |      |      |      | 7    |
| ViewReport.Choose                        | 1    | 2    | 3    | 4    | 5    | 6    |      |
| ViewReport.Choose.SaleList               | 1    | 2    |      |      |      |      |      |
| ViewReport.Choose.BusinessProcessTable   |      |      | 3    | 4    |      |      |      |
| ViewReport.Choose.StatementOfOperation   |      |      |      |      | 5    | 6    |      |
| ViewReport.SaleList                      | 1    | 2    |      |      |      |      |      |
| ViewReport.SaleList.Filter               | 1    | 2    |      |      |      |      |      |
| ViewReport.SaleList.Filter.Invalid       |      | 2    |      |      |      |      |      |
| ViewReport.SaleLIst.Filter.Valid         | 1    |      |      |      |      |      |      |
| ViewReport.SaleList.Export               | 1    |      |      |      |      |      |      |
| ViewReport.BusinessProcessTable          |      |      | 3    | 4    |      |      |      |
| ViewReport.BusinessProcessTable.Filter   |      |      | 3    | 4    |      |      |      |
| ViewReport.BusinessProcessTable.Filter.Invalid |      |      |      | 4    |      |      |      |
| ViewReport.BusinessProcessTable.Filter.Valid |      |      | 3    |      |      |      |      |
| ViewReport.BusinessProcessTable.HotForging |      |      |      | 4    |      |      |      |
| ViewReport.BusinessProcessTable.Export   |      |      | 3    |      |      |      |      |
| ViewReport.StatementOfOperation          |      |      |      |      | 5    | 6    |      |
| ViewReport.StatementOfOperation.Filter   |      |      |      |      | 5    | 6    |      |
| ViewReport.StatementOfOperation.Filter.Invalid |      |      |      |      |      |      |      |
| ViewReport.StatementOfOperation.Filter.Valid |      |      |      |      | 5    | 6    |      |
| ViewReport.StatementOfOperation.Export   |      |      |      |      | 5    |      |      |
| ViewReport.HotForging                    |      |      |      | 4    |      |      |      |
| ViewReport.HotForging.New                |      |      |      | 4    |      |      |      |
| ViewReport.HotForging.Copy               |      |      |      | 4    |      |      |      |
| ViewReport.HotForging.Commit             |      |      |      | 4    |      |      |      |
| ViewReport.HotForging.Discard            |      |      |      | 4    |      |      |      |
| ViewReport.Export                        | 1    |      | 3    |      | 5    |      |      |
| ViewReport.Export.Concle                 |      |      | 3    |      |      |      |      |

##13 期初建账

###13.1 测试用例套件

| ID      | 输入信息                                     | 预期输出                       |
| ------- | ---------------------------------------- | -------------------------- |
| TUS13-1 | "商品信息:商品分类:酒水饮料，某一商品的名称：旺仔牛奶，类别乳制品，型号201，进价/售价:3/4.5，最近进价和最近售价:3/5<br>客户信息:客户分类:VIP1，客户的名称:马云，联系方式888888888888，应收：0应付：10000<br>银行账户信息：名称：公司总账余额：100000000” | 系统返回“建账成功”并保存账户            |
| TUS13-2 | "商品信息:商品分类:酒水饮料，某一商品的名称：旺仔牛奶，类别乳制品，型号201，进价/售价:3/4.5，最近进价和最近售价:3/5<br>客户信息:客户分类:VIP1，客户的名称:马云，联系方式888888888888，应收：0应付：10000<br>银行账户信息：名称：公司总账余额：100000000” | 系统提示：“建账失败：存在同名账户”并返回建账界面  |
| TUS13-3 | "商品信息:商品分类:酒水饮料，某一商品的名称：旺仔牛奶，类别乳制品，型号201，进价/售价:3/4.5，最近进价和最近售价:3/5" | 系统提示：“建账失败：信息填写不完整“并返回建账界面 |
| TUS13-4 | 无且退出                                     | 系统返回上一画面                   |

###13.2 测试用例套件覆盖情况

| 编号                               | 覆盖情况 | ——   | ——   | ——   |
| -------------------------------- | ---- | ---- | ---- | ---- |
|                                  | 1    | 2    | 3    | 4    |
| InitialAccount.Exit              |      |      |      | 4    |
| InitialAccount.Initialize        | 1    | 2    | 3    |      |
| InitialAccount.Initialize.Wrong  |      | 2    | 3    |      |
| InitialAccount.Initialize.quit   |      | 2    |      |      |
| InitialAccount.Initialize.Save   | 1    |      |      |      |
| InitialAccount.Initialize.Concle |      | 2    |      |      |

##用例14 查看导出报表测试用例

### 14.1 测试用例套件

| ID       |           |              |      |              | 预期输出                     |
| -------- | --------- | ------------ | ---- | ------------ | ------------------------ |
| 操作选择     | 用户行为（输入）  | 是否确认操作       | 后台数据 |              |                          |
| TUS14-1  | 登录        | 未填写          | 否    | —            | 系统停留在登录界面等待用户输入          |
| TUS14-2  | 登录        | 未填写          | 是    | —            | 系统提示登录失败，用户名和密码不匹配       |
| TUS14-3  | 登录        | 不匹配的用户名和密码   | 是    | —            | 系统提示登录失败，用户名和密码不匹配       |
| TUS14-4  | 登录        | 正确的用户名和密码    | 是    | —            | 系统提示登录成功                 |
| TUS14-5  | 放弃登录      | 点击放弃登录按钮     | 是    | —            | 系统关闭所有界面，结束运行            |
| TUS14-6  | 重新登录      | 点击重新登录按钮     | 是    | —            | 系统清空当前用户名和密码             |
| TUS14-7  | 申请查询报表    | 点击查询报表按钮     | 是    | 用户权限合法       | 系统提示权限合法，并输出报表类型         |
| TUS14-8  | 申请查询报表    | 点击查询报表按钮     | 是    | 用户权限不合法      | 系统提示权限不合法，要求用户退出查询       |
| TUS14-9  | 选择报表类型    | 点击一个报表类型按钮   | 是    | —            | 系统显示该报表所需的筛选条件           |
| TUS14-10 | 退出查看报表    | 点击退出按钮       | 是    |              | 系统提示用户已退出查看报表功能，返回登录后主界面 |
| TUS14-11 | 填写筛选条件并查询 | 未填写          | 是    | —            | 系统提示输入不合法，要求重新输入条件或退出查询  |
| TUS14-12 | 填写筛选条件并查询 | 不完整的筛选条件     | 是    | —            | 系统提示输入不完整，要求重新输入条件       |
| TUS14-13 | 填写筛选条件并查询 | 完整的筛选条件      | 是    | 当前条件下有对应的报表  | 系统显示对应的报表                |
| TUS14-14 | 填写筛选条件并查询 | 完整的筛选条件      | 是    | 当前条件下没有对应的报表 | 系统提示当前条件下没有对应的报表         |
| TUS14-15 | 清空筛选条件并查询 | 点击清空条件按钮     | 是    | —            | 系统显示空白的筛选条件列表            |
| TUS14-16 | 重新选择报表类型  | 点击重新选择报表类型按钮 | 是    | —            | 系统返回选择报表类型界面             |
| TUS14-17 | 重新选择筛选条件  | 点击重新选择筛选条件按钮 | 是    | —            | 系统返回填写筛选条件界面             |
| TUS14-18 | 导出当前报表    | 点击导出报表按钮     | 是    | —            | 系统导出报表并提示用户报表已导出         |
| TUS14-19 | 再次查看报表    | 点击继续查看报表按钮   | 是    | —            | 系统返回选择报表类型界面             |

###14.2 测试用例套件覆盖情况

| 编号                      | TUS14 |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| ----------------------- | ----- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| 1                       | 2     | 3    | 4    | 5    | 6    | 7    | 8    | 9    | 10   | 11   | 12   | 13   | 14   | 15   | 16   | 17   | 18   | 19   |      |
| Read.Login.Wait         | 1     |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Read.Login.Input        |       | 2    | 3    | 4    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Read.Login.Check        |       | 2    | 3    | 4    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Read.Login.Valid        |       |      |      | 4    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Read.Login.Invalid      |       | 2    | 3    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Read.Login.Exit         |       |      |      |      | 5    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Read.Login.Retry        |       |      |      |      |      | 6    |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Read.Limits.Application |       |      |      |      |      |      | 7    | 8    |      |      |      |      |      |      |      |      |      |      |      |
| Read.Limits.Check       |       |      |      |      |      |      | 7    | 8    |      |      |      |      |      |      |      |      |      |      |      |
| Read.Limits.Valid       |       |      |      |      |      |      | 7    |      |      |      |      |      |      |      |      |      |      |      |      |
| Read.Limits.Invalid     |       |      |      |      |      |      |      | 8    |      |      |      |      |      |      |      |      |      |      |      |
| Read.Select.Show        |       |      |      |      |      |      | 7    |      |      |      |      |      |      |      |      | 16   |      |      | 19   |
| Read.Select.Input       |       |      |      |      |      |      |      |      | 9    |      |      |      |      |      |      |      |      |      |      |
| Read.Select.Cancel      |       |      |      |      |      |      |      |      |      | 10   |      |      |      |      |      |      |      |      |      |
| Read.Select.Search      |       |      |      |      |      |      |      |      | 9    |      |      |      |      |      |      |      |      |      |      |
| Read.Condition.Show     |       |      |      |      |      |      |      |      | 9    |      |      |      |      |      | 15   |      | 17   |      |      |
| Read.Condition.Input    |       |      |      |      |      |      |      |      |      |      | 11   | 12   | 13   | 14   |      |      |      |      |      |
| Read.Condition.Clear    |       |      |      |      |      |      |      |      |      |      |      |      |      |      | 15   |      |      |      |      |
| Read.Condition.Invalid  |       |      |      |      |      |      |      |      |      |      | 11   | 12   |      |      |      |      |      |      |      |
| Read.Condition.Rechoose |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 16   |      |      |      |
| Read.Condition.Search   |       |      |      |      |      |      |      |      |      |      | 11   | 12   | 13   | 14   | 15   |      |      |      |      |
| Read.Show.List          |       |      |      |      |      |      |      |      |      |      |      |      | 13   |      |      |      |      |      |      |
| Read.Show.Null          |       |      |      |      |      |      |      |      |      |      |      |      |      | 14   |      |      |      |      |      |
| Read.Show.Change        |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 17   |      |      |
| Read.Show.Export        |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 18   |      |
| Read.Show.Exit          |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 10   |
| Read.Export.Outout      |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 18   |      |
| Read.Export.Reminder    |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 18   |      |
| Read.Export.Continue    |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 19   |

##用例15 审批单据

###15.1 测试用例套件

| ID       |          |                |      |                 | 预期输出                                     |
| -------- | -------- | -------------- | ---- | --------------- | ---------------------------------------- |
| 操作选择     | 用户行为（输入） | 是否确认操作         | 后台数据 |                 |                                          |
| TUS15-1  | 登录       | 未填写            | 否    | —               | 系统停留在登录界面等待用户输入                          |
| TUS15-2  | 登录       | 未填写            | 是    | —               | 系统提示登录失败，用户名和密码不匹配                       |
| TUS15-3  | 登录       | 不匹配的用户名和密码     | 是    | —               | 系统提示登录失败，用户名和密码不匹配                       |
| TUS15-4  | 登录       | 正确的用户名和密码      | 是    | —               | 系统提示登录成功                                 |
| TUS15-5  | 放弃登录     | 点击放弃登录按钮       | 是    | —               | 系统关闭所有界面，结束运行                            |
| TUS15-6  | 重新登录     | 点击重新登录按钮       | 是    | —               | 系统清空当前用户名和密码                             |
| TUS15-7  | 申请审批单据   | 点击审批单据按钮       | 是    | 用户权限合法，有未审批的单据  | 系统提示权限合法，并输出提交单据列表                       |
| TUS15-8  | 申请审批单据   | 点击审批单据按钮       | 是    | 用户权限合法，没有未审批的单据 | 系统提示权限合法，提示当前没有未审批的单据                    |
| TUS15-9  | 申请审批单据   | 点击审批单据按钮       | 是    | 用户权限不合法         | 系统提示权限不合法，要求用户退出审批单据                     |
| TUS15-10 | 选择单据     | 选择一张单据         | 否    | —               | 系统显示该单据已被选中                              |
| TUS15-11 | 选择单据     | 选择多张单据         | 否    | —               | 系统显示多张单据已被选中                             |
| TUS15-12 | 选择单据     | 选择一张单据         | 是    | —               | 系统显示用户选择是否批准该单据                          |
| TUS15-13 | 选择单据     | 选择多张单据         | 是    | —               | 系统显示用户选择是否批准多张单据                         |
| TUS15-14 | 读取详细内容   | 选择一张单据         | 是    | —               | 系统显示该单据的详细内容                             |
| TUS15-15 | 取消已选单据   | 点击取消已选单据按钮     | 是    | —               | 系统显示已清空已选单据列表                            |
| TUS15-16 | 退出审批单据   | 点击退出审批单据按钮     | 是    | —               | 系统退出审批单据功能，返回主界面                         |
| TUS15-17 | 审批单据     | 用户选择一张单据并点击批准  | 是    | —               | 系统更新后台数据、显示当前提交单据列表、修改该单据状态为已批准，单据提交者收到消息提示 |
| TUS15-18 | 审批单据     | 用户选择多张单据并点击批准  | 是    | —               | 系统更新后台数据、显示当前提交单据列表、修改多张单据状态为已批准，单据提交者收到消息提示 |
| TUS15-19 | 审批单据     | 用户选择多张单据并点击不批准 | 是    | —               | 系统更新后台数据、显示当前提交单据列表、修改多张单据状态为不批准，单据提交者收到消息提示 |
| TUS15-20 | 审批单据     | 用户选择一张单据并点击不批准 | 是    | —               | 系统更新后台数据、显示当前提交单据列表、修改该单据状态为不批准，单据提交者收到消息提示 |
| TUS15-21 | 继续审批单据   | 用户点击继续审批单据按钮   | 是    | —               | 系统输出提交单据列表                               |
| TUS15-22 | 退出审批单据   | 用户点击退出审批按钮     | 是    | —               | 系统退出审批单据功能，返回主界面                         |

###15.2 测试用例套件覆盖情况

| 编号                         | TUS14 |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| -------------------------- | ----- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| 1                          | 2     | 3    | 4    | 5    | 6    | 7    | 8    | 9    | 10   | 11   | 12   | 13   | 14   | 15   | 16   | 17   | 18   | 19   | 20   | 21   | 22   |      |
| Receipt.Login.Wait         | 1     |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Receipt.Login.Input        |       | 2    | 3    | 4    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Receipt.Login.Check        |       | 2    | 3    | 4    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Receipt.Login.Valid        |       |      |      | 4    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Receipt.Login.Invalid      |       | 2    | 3    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Receipt.Login.Exit         |       |      |      |      | 5    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Receipt.Login.Retry        |       |      |      |      |      | 6    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Receipt.Limits.Application |       |      |      |      |      |      | 7    | 8    | 9    |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Receipt.Limits.Check       |       |      |      |      |      |      | 7    | 8    | 9    |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Receipt.Limits.Valid       |       |      |      |      |      |      | 7    | 8    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Receipt.Limits.Invalid     |       |      |      |      |      |      |      |      | 9    |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Receipt.Show.List          |       |      |      |      |      |      | 7    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Receipt.Show.Null          |       |      |      |      |      |      |      | 8    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Receipt.Show.Read          |       |      |      |      |      |      |      |      |      |      |      |      |      | 14   |      |      |      |      |      |      |      |      |
| Receipt.Show.Exit          |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Receipt.Check.Select       |       |      |      |      |      |      |      |      |      | 10   | 11   | 12   | 13   |      |      |      | 17   | 18   | 19   | 20   |      |      |
| REceipt.Check.Reminder     |       |      |      |      |      |      |      |      |      |      |      | 12   | 13   |      |      |      |      |      |      |      |      |      |
| Receipt.Check.Commit       |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 16   | 17   | 18   | 19   | 20   |      |      |
| Receipt.Check.Clear        |       |      |      |      |      |      |      |      |      |      |      |      |      |      | 15   |      |      |      |      |      |      |      |
| Receipt.Check.Cancel       |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 16   |      |      |      |      |      |      |
| Receipt.Process.Pass       |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 17   | 18   |      |      |      |      |
| Receipt.Process.Fail       |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 19   | 20   |      |      |
| Receipt.Process.Update     |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 17   | 18   | 19   | 20   |      |      |
| Receipt.Process.Inform     |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 17   | 18   | 19   | 20   |      |      |
| Receipt.Process.Refresh    |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 17   | 18   | 19   | 20   |      |      |
| Receipt.Continue           |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 21   |      |
| Receipt.Exit               |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 22   |

##用例16 查询日志
###16.1 测试用例套件
| ID       |          |            |      |         | 预期输出                 |
| -------- | -------- | ---------- | ---- | ------- | -------------------- |
| 操作选择     | 用户行为（输入） | 是否确认操作     | 后台数据 |         |                      |
| TUS16-1  | 登录       | 未填写        | 否    | —       | 系统停留在登录界面等待用户输入      |
| TUS16-2  | 登录       | 未填写        | 是    | —       | 系统提示登录失败，用户名和密码不匹配   |
| TUS16-3  | 登录       | 不匹配的用户名和密码 | 是    | —       | 系统提示登录失败，用户名和密码不匹配   |
| TUS16-4  | 登录       | 正确的用户名和密码  | 是    | —       | 系统提示登录成功             |
| TUS16-5  | 放弃登录     | 点击放弃登录按钮   | 是    | —       | 系统关闭所有界面，结束运行        |
| TUS16-6  | 重新登录     | 点击重新登录按钮   | 是    | —       | 系统清空当前用户名和密码         |
| TUS16-7  | 申请查询日志   | 点击查询日志按钮   | 是    | 用户权限合法  | 系统提示权限合法，并输出日志列表     |
| TUS16-8  | 申请查询日志   | 点击查询日志按钮   | 是    | 用户权限不合法 | 系统提示权限不合法，要求用户退出查询日志 |
| TUS16-9  | 读取日志内容   | 打开一条日志内容   | 是    | —       | 系统显示该条日志的详细内容        |
| TUS16-10 | 返回日志列表   | 点击返回列表按钮   | 是    | —       | 系统显示日志列表             |
| TUS16-11 | 退出查询日志   | 点击退出查询日志按钮 | 是    | —       | 系统退出查询日志功能，返回主界面     |

###16.2 测试用例套件覆盖情况
| 编号                     | TUS14 |      |      |      |      |      |      |      |      |      |      |
| ---------------------- | ----- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| 1                      | 2     | 3    | 4    | 5    | 6    | 7    | 8    | 9    | 10   | 11   |      |
| Log.Login.Wait         | 1     |      |      |      |      |      |      |      |      |      |      |
| Log.Login.Input        |       | 2    | 3    | 4    |      |      |      |      |      |      |      |
| Log.Login.Check        |       | 2    | 3    | 4    |      |      |      |      |      |      |      |
| Log.Login.Valid        |       |      |      | 4    |      |      |      |      |      |      |      |
| Log.Login.Invalid      |       | 2    | 3    |      |      |      |      |      |      |      |      |
| Log.Login.Exit         |       |      |      |      | 5    |      |      |      |      |      |      |
| Log.Login.Retry        |       |      |      |      |      | 6    |      |      |      |      |      |
| Log.Limits.Application |       |      |      |      |      |      | 7    | 8    |      |      |      |
| Log.Limits.Check       |       |      |      |      |      |      | 7    | 8    |      |      |      |
| Log.Limits.Valid       |       |      |      |      |      |      | 7    |      |      |      |      |
| Log.Limits.Invalid     |       |      |      |      |      |      |      | 8    |      |      |      |
| Log.Show.List          |       |      |      |      |      |      | 7    |      |      | 10   |      |
| Log.Show.Choose        |       |      |      |      |      |      |      |      | 9    |      |      |
| Log.Show.Details       |       |      |      |      |      |      |      |      | 9    |      |      |
| Log.Show.Back          |       |      |      |      |      |      |      |      |      | 10   |      |
| Log.Exit               |       |      |      |      |      |      |      |      |      |      | 11   |

##用例17 制定促销策略
###17.1 测试用例套件
| ID       |            |                 |      |              | 预期输出                        |
| -------- | ---------- | --------------- | ---- | ------------ | --------------------------- |
| 操作选择     | 用户行为（输入）   | 是否确认操作          | 后台数据 |              |                             |
| TUS17-1  | 登录         | 未填写             | 否    | —            | 系统停留在登录界面等待用户输入             |
| TUS17-2  | 登录         | 未填写             | 是    | —            | 系统提示登录失败，用户名和密码不匹配          |
| TUS17-3  | 登录         | 不匹配的用户名和密码      | 是    | —            | 系统提示登录失败，用户名和密码不匹配          |
| TUS17-4  | 登录         | 正确的用户名和密码       | 是    | —            | 系统提示登录成功                    |
| TUS17-5  | 放弃登录       | 点击放弃登录按钮        | 是    | —            | 系统关闭所有界面，结束运行               |
| TUS17-6  | 重新登录       | 点击重新登录按钮        | 是    | —            | 系统清空当前用户名和密码                |
| TUS17-7  | 申请制定促销策略   | 点击制定促销策略按钮      | 是    | 用户权限合法       | 系统提示权限合法，并显示起始时间选项          |
| TUS17-8  | 申请制定促销策略   | 点击制定促销策略按钮      | 是    | 用户权限不合法      | 系统提示权限不合法，要求用户退出制定促销策略功能    |
| TUS17-9  | 填写起始时间     | 完整的促销开始时间和结束时间  | 是    | —            | 系统显示可选择促销策略列表               |
| TUS17-10 | 填写起始时间     | 不完整的促销开始时间和结束时间 | 是    | —            | 系统显示时间不完整，要求重新输入时间          |
| TUS17-11 | 选择促销策略类型   | 点击一个促销策略类型按钮    | 是    | —            | 系统显示该促销策略所需的筛选条件            |
| TUS17-12 | 放弃制定促销策略   | 点击放弃制定促销策略按钮    | 是    | —            | 系统退出制定促销策略功能返回主界面           |
| TUS17-13 | 填写当前策略所需信息 | 未填写             | 是    | —            | 系统提示输入不合法，要求重新输入条件或退出制定策略   |
| TUS17-14 | 填写当前策略所需信息 | 不完整的信息          | 是    | —            | 系统提示输入不完整，要求重新输入条件          |
| TUS17-15 | 填写当前策略所需信息 | 完整的信息           | 是    | 当前条件下没有重复的策略 | 系统显示新策略制定成功，显示当前策略列表，更新后台数据 |
| TUS17-16 | 填写当前策略所需信息 | 完整的筛选信息         | 是    | 当前条件下有对应的策略  | 系统提示当前策略重复                  |
| TUS17-17 | 清空已输入信息    | 点击清空信息按钮        | 是    | —            | 系统显示空白的所需信息列表               |
| TUS17-18 | 重新选择促销策略类型 | 点击重新选择促销策略类型按钮  | 是    | —            | 系统返回选择促销策略类型界面              |
| TUS17-19 | 继续制定策略     | 点击继续制定策略按钮      | 是    | —            | 系统返回输入起始时间界面                |
| TUS17-20 | 退出制定策略     | 点击退出按钮          | 是    |              | 系统返回登录后主界面                  |

###测试用例套件覆盖情况
| 编号                            | TUS14 |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| ----------------------------- | ----- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| 1                             | 2     | 3    | 4    | 5    | 6    | 7    | 8    | 9    | 10   | 11   | 12   | 13   | 14   | 15   | 16   | 17   | 18   | 19   | 20   |      |
| Promotion.Login.Wait          | 1     |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Promotion.Login.Input         |       | 2    | 3    | 4    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Promotion.Login.Check         |       | 2    | 3    | 4    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Promotion.Login.Valid         |       |      |      | 4    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Promotion.Login.Invalid       |       | 2    | 3    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Promotion.Login.Exit          |       |      |      |      | 5    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Promotion.Login.Retry         |       |      |      |      |      | 6    |      |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Promotion.Limits.Application  |       |      |      |      |      |      | 7    | 8    |      |      |      |      |      |      |      |      |      |      |      |      |
| Promotion.Limits.Check        |       |      |      |      |      |      | 7    | 8    |      |      |      |      |      |      |      |      |      |      |      |      |
| Promotion.Limits.Valid        |       |      |      |      |      |      | 7    |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Promotion.Limits.Invalid      |       |      |      |      |      |      |      | 8    |      |      |      |      |      |      |      |      |      |      |      |      |
| Promotion.Time.Reminder       |       |      |      |      |      |      | 7    |      |      |      |      |      |      |      |      |      |      |      |      |      |
| Promotion.Time.Input          |       |      |      |      |      |      |      |      | 9    | 10   |      |      |      |      |      |      |      |      |      |      |
| Promotion.Select.Show         |       |      |      |      |      |      |      |      | 9    |      |      |      |      |      |      |      |      | 18   |      |      |
| Promotion.Select.Input        |       |      |      |      |      |      |      |      |      |      | 11   |      |      |      |      |      |      |      |      |      |
| Promotion.Select.Cancel       |       |      |      |      |      |      |      |      |      |      |      | 12   |      |      |      |      |      |      |      |      |
| Promotion.Select.Search       |       |      |      |      |      |      |      |      |      |      | 11   |      |      |      |      |      |      |      |      |      |
| Promotion.Condition.Show      |       |      |      |      |      |      |      |      |      |      | 11   |      |      |      |      |      | 17   |      |      |      |
| Promotion.Condition.Input     |       |      |      |      |      |      |      |      |      |      |      |      | 13   | 14   | 15   | 16   |      |      |      |      |
| Promotion.Condition.Clear     |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 17   |      |      |      |
| Promotion.Condition.Invalid   |       |      |      |      |      |      |      |      |      |      |      |      | 13   | 14   |      |      |      |      |      |      |
| Promotion.Condition.Rechoose  |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 18   |      |      |
| Promotion.Condition.formulate |       |      |      |      |      |      |      |      |      |      |      |      |      |      | 15   |      |      |      |      |      |
| Promotion.Condition.Pass      |       |      |      |      |      |      |      |      |      |      |      |      |      |      | 15   |      |      |      |      |      |
| Promotion.Condition.Repeat    |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 16   |      |      |      |      |
| Promotion.Process.Update      |       |      |      |      |      |      |      |      |      |      |      |      |      |      | 15   |      |      |      |      |      |
| Promotion.Process.Message     |       |      |      |      |      |      |      |      |      |      |      |      |      |      | 15   |      |      |      |      |      |
| Promotion.Process.Show        |       |      |      |      |      |      |      |      |      |      |      |      |      |      | 15   |      |      |      |      |      |
| Promotion.Continue            |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 19   |      |
| Promotion.Exit                |       |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      |      | 20   |
