# MSPSS进销存管理系统代码开发过程总结



### 1、采用Maven配置管理

#### 1.1 原因

> ##### &emsp;并行开发，避免重复配置依赖与插件
>
> ##### &emsp;避免版本冲突
>
> ##### &emsp;保证程序不会重复添加依赖
>
> ##### &emsp;小组成员对于多IDE编程的强烈！！需要(eclipse与Intellij IDEA)

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E4%BB%A3%E7%A0%81%E5%BC%80%E5%8F%91%E8%BF%87%E7%A8%8B%E6%80%BB%E7%BB%93/1.png)

### 2、采用分层模式

#### 1.1 原因

> ##### &emsp;迷途知返为时未晚，找到适合自己的分工方式（在横向与纵向之间的切换）
>
> ##### &emsp;发挥大家的特长，避免重复学习的成本
>
> ##### &emsp;命名方式统一，接口规范较为一致
>
> ##### &emsp;同一个人的出BUG的地方大致相同，不会产生特别奇怪的玄学BUG
>
> ##### &emsp;Stub与mock完美的发挥的作用
>
> ![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E4%BB%A3%E7%A0%81%E5%BC%80%E5%8F%91%E8%BF%87%E7%A8%8B%E6%80%BB%E7%BB%93/2.png)
>
> #### 1.2 缺点

> ##### &emsp;修改文档的工作量真的好大！！！
>
> ##### &emsp;离开stub与mock无法展开测试，尤其是UI层，因此编写测试和桩的工作量比较大
>
> ##### &emsp;学习的东西比较单一，精于一块地方



### 3、 考虑多线程并发

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E4%BB%A3%E7%A0%81%E5%BC%80%E5%8F%91%E8%BF%87%E7%A8%8B%E6%80%BB%E7%BB%93/3.png)

### 4、 丰富的设计模式（虽然不一定很标准，但是精髓有体现）

#### 4.1 工厂模式以及静态工厂模式

##### 4.1.1 实例代码

```
public class PromotionBLFactory {
    private static final CustomerPromotion customerPromotion = new CustomerPromotion();
    private static final GroupPromotion groupPromotion = new GroupPromotion();
    private static final GrossPromotion grossPromotion = new GrossPromotion();
    private static PromotionBLServiceImpl impl;

  
    /**
     * 返回一个PromotionBLServiceImpl的一个静态对象
     * @return PromotionBLService
     */
   public synchronized static PromotionBLService getPromotionBLService(){
        if (impl==null){
            impl = new PromotionBLServiceImpl(customerPromotion,grossPromotion,groupPromotion);
        }
        return impl;
    }

    /**
     * 返回一个PromotionBLService的一个桩
     * @return PromotionBLService
     */
    public synchronized static PromotionBLService getPromotionBLServiceStub(){

        return new Promotion_Stub();
    }

}

```
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E4%BB%A3%E7%A0%81%E5%BC%80%E5%8F%91%E8%BF%87%E7%A8%8B%E6%80%BB%E7%BB%93/4.png)

##### 4.1.2 设计模式的优点

> ##### &emsp;可扩展性比较好
>
> ##### &emsp;在工厂中完成对象的初始化并返回，对上层隐藏了实现，并且减少了上层读代码的成本
>
> ##### &emsp;降低了上层代码和底层的耦合
>
> ##### &emsp;满足OPC原则，即“开放-封闭原则”，对扩展开放，对修改封闭
>
> ##### &emsp;虽然需要多实现代码，不过实际编程上也实现了初始化的代码复用，所以其实是减少了代码量

#### 4.2 单例模式

##### 4.2.1 代码如上

##### 4.2.2 设计模式的优点

> ##### &emsp;减少频繁调用及创建数据库的内存开销
>
> ##### &emsp;防止重复连接数据库

#### 4.3 建造者模式

##### 4.3.1 使用该设计模式的原因

> ##### &emsp;建造者模式将一个复杂对象的构建与表示分离，使得同样的构建过程可以创建不同的表示。
>
> ##### &emsp;主要体现在期初建造
>
> ![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E4%BB%A3%E7%A0%81%E5%BC%80%E5%8F%91%E8%BF%87%E7%A8%8B%E6%80%BB%E7%BB%93/5.png)
> ![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E4%BB%A3%E7%A0%81%E5%BC%80%E5%8F%91%E8%BF%87%E7%A8%8B%E6%80%BB%E7%BB%93/12.png)
>
> ##### 4.3.2 代码示例

```
public interface GeneralAccountDataService {

    /**
     * 新建期初建账
     *
     * @param generalaccount
     * @return 新建成功与否
     */
    public ResultMessage newGeneralAccount(GeneralAccountPO generalaccount);
    /**
     * 查询建账信息
     *
     * @param field,min,max
     * @return 建账信息列表
     */
    public ArrayList<GeneralAccountPO> checkGeneralAccount(String field,Object min,Object max);

    /**
     * 精确查询
     * @param field,value
     */
    public GeneralAccountPO exactlySearchGeneralAccount(String field,Object value);

```

> ##### &emsp;传入一个PO,由于期初建账信息中账户、客户、商品和普通账户、客户、商品存在二义性，因此不&emsp;能简单的  传递普通的数据到数据库，必须要加上一层建造，一次采取建造者模式，负责建造以及转化

#### 4.4 代理模式

##### 4.4.1 原因

> ##### &emsp;分散职责，降低代码复杂度

### 5、 采取ORM框架处理对象关系映射

#### 5.1 优点

> ##### &emsp;隐藏了数据访问细节，“封闭”的通用数据库交互
>
> ##### &emsp;和OOP的编程风格相匹配
>
> ##### &emsp;避免复杂的数据库查询语句

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E4%BB%A3%E7%A0%81%E5%BC%80%E5%8F%91%E8%BF%87%E7%A8%8B%E6%80%BB%E7%BB%93/6.png)

#### 5.2 示例代码

```
public interface DataHelper<T> {

    /**
     * 持久化指定的PO
     *
     * @param o 指定的PO
     * @return 保存成功——ResultMessage.SUCCESS<br>
     * 存在ID相同的PO——ResultMessage.EXIST<br>
     * 底层持久化过程失败——ResultMessage.FAILED
     */
    public ResultMessage save(Object o);

    /**
     * 更新已被持久化的PO
     *
     * @param o 指定的PO
     * @return 更新成功——ResultMessage.SUCCESS<br>
     * 不存在ID相同的PO——ResultMessage.NOT_EXIST<br>
     * 底层持久化过程失败——ResultMessage.FAILED
     */
    public ResultMessage update(Object o);

    /**
     * 删除已被持久化的PO
     *
     * @param key 被删除的PO的ID域名
     * @param ID  被删除的PO的ID域值
     * @return 删除成功——ResultMessage.SUCCESS<br>
     * 不存在指定ID的PO——ResultMessage.NOT_EXIST<br>
     * 底层持久化过程失败——ResultMessage.FAILED
     */
    public ResultMessage delete(String key, Object ID);

    /**
     * 按指定字段精确查询PO<br>
     * 建议使用ID进行查询
     *
     * @param field 指定字段名
     * @param value 指定字段值
     * @return 找不到指定的PO——null<br>
     * 找到指定的PO——指定的PO
     */
    public T exactlyQuery(String field, Object value);

    /**
     * 按指定字段完全匹配查询PO<br>
     *
     * @param field 指定字段名
     * @param value 指定字段值
     * @return 找不到指定的PO——空ArrayList<br>
     * 找到指定的POs——指定的PO列表
     */
    public ArrayList<T> fullMatchQuery(String field, Object value);

    /**
     * 按指定字段前缀匹配查询PO<br>
     *
     * @param field 指定字段名
     * @param value 指定字段值
     * @return 找不到指定的PO——空ArrayList<br>
     * 找到指定的POs——指定的PO列表
     */
    public ArrayList<T> prefixMatchQuery(String field, String value);

    /**
     * 按指定字段后缀匹配查询PO<br>
     *
     * @param field 指定字段名
     * @param value 指定字段值
     * @return 找不到指定的PO——空ArrayList<br>
     * 找到指定的POs——指定的PO列表
     */
    public ArrayList<T> suffixMatchQuery(String field, String value);

    /**
     * 按指定字段模糊匹配查询PO<br>
     *
     * @param field 指定字段名
     * @param value 指定字段值
     * @return 找不到指定的PO——空ArrayList<br>
     * 找到指定的POs——指定的PO列表
     */
    public ArrayList<T> fuzzyMatchQuery(String field, String value);

    /**
     * 按指定字段范围查询符合范围条件的PO<br>
     * 注意：最大值和最小值包括在范围内
     *
     * @param field 指定字段名
     * @param min   指定字段最小值
     * @param max   指定字段最大值
     * @return 找不到指定的PO——空ArrayList<br>
     * 找到指定的POs——指定的PO列表
     */
    public ArrayList<T> rangeQuery(String field, Object min, Object max);

    /**
     * 多条件多字段查询符合条件的PO<br>
     *
     * @param criteriaClauses 单字段查询分句组
     * @return 找不到指定的PO——空ArrayList<br>
     * 找到指定的POs——指定的PO列表
     *
     * @see CriteriaClause
     */
    public ArrayList<T> multiCriteriaQuery(ArrayList<CriteriaClause> criteriaClauses);


    /**
     * 清空数据库对应的表格
     * @param table
     */
    public void clear(String table);



}

```

### 6、 防御式编程

#### 6.1 实例代码

##### 6.1.1 代码广泛覆盖try,catch

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E4%BB%A3%E7%A0%81%E5%BC%80%E5%8F%91%E8%BF%87%E7%A8%8B%E6%80%BB%E7%BB%93/7.png)

##### 6.1.2 采用枚举类ResultMessage作为返回值代替String，自定义Time类代替字符串提高安全性

```
public enum ResultMessage implements Serializable{
    SUCCESS, // 成功
    FAILED, // 失败
    WRONG, // 错误
    EXIST, // 已存在
    NOT_EXIST, // 不存在
    TOO_LONG, // 输入过长
    TOO_SHORT, // 输入过短
    INVALID, // 含有非法字符
    NULL, // 输入为空
    TRUE,//判断为真
    FALSE;//判断为假


    public String toString() {
        switch (this) {
            case SUCCESS:
                return "成功";
            case FAILED:
                return "失败";
            case WRONG:
                return "错误";
            case EXIST:
                return "已存在";
            case NOT_EXIST:
                return "不存在";
            case TOO_LONG:
                return "输入过长";
            case TOO_SHORT:
                return "输入过短";
            case INVALID:
                return "含有非法字符";
            case NULL:
                return "输入为空";

            case TRUE:
                return "真";
            case FALSE:
                return "假";
            default:
                return null;
        }
    }

}

```

##### 6.1.3 大量！！的便捷化接口，方便上层调用

如：

大量自定义toString()方法

设置自定义Max_Value以及Min_Value避免用户数据溢出

getInstance()、PO_To_VO方法等

后缀搜索，前缀搜索，模糊搜索，范围查找，精确匹配，多条件查找

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E4%BB%A3%E7%A0%81%E5%BC%80%E5%8F%91%E8%BF%87%E7%A8%8B%E6%80%BB%E7%BB%93/8.png)
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E4%BB%A3%E7%A0%81%E5%BC%80%E5%8F%91%E8%BF%87%E7%A8%8B%E6%80%BB%E7%BB%93/9.png)

##### 6.1.4 加密算法MD5

```
 /**
     * 加密算法
     *
     * @param str
     * @return 加密后的字符串
     */
    public static String encrypt(String str) {
        boolean isTest = false;
        if(isTest){
            return str;
        }else{
            //MD5 32位加密
            String result = "";
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(str.getBytes());
                byte b[] = md.digest();
                int i;
                StringBuilder buf = new StringBuilder("");
                for (int offset = 0; offset < b.length; offset++) {
                    i = b[offset];
                    if (i < 0)
                        i += 256;
                    if (i < 16)
                        buf.append("0");
                    buf.append(Integer.toHexString(i));
                }
                result = buf.toString();
//                System.out.println("MD5(" + str + ",32) = " + result);
                return result;
            }catch (Exception e){
                e.printStackTrace();
                return str;
            }
        }
    }
```



### 7、自定义Exception来处理异常

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E4%BB%A3%E7%A0%81%E5%BC%80%E5%8F%91%E8%BF%87%E7%A8%8B%E6%80%BB%E7%BB%93/10.png)

### 8、注释详细，风格统一，没有无用注释

> ##### &emsp;无处不在的注释让我感受到队友的关♂怀
>
> ##### &emsp;注释风格统一，一目了然

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E4%BB%A3%E7%A0%81%E5%BC%80%E5%8F%91%E8%BF%87%E7%A8%8B%E6%80%BB%E7%BB%93/11.png)

### 9、 代码命名

#### 9.1 java代码

> ##### &emsp;统一采用驼峰式命名方式

#### 9.2 数据库命名方式

> ##### &emsp; 参考了 张子阳的《数据库对象命名参考》小写字母加下划线

#### 9.3 接口、类等命名

> ##### &emsp;因为采用分层的方式，接口都是固定的人完成，所以命名方式基本统一



### 10、 模板类可以减少大量的重复代码

#### 10.1 实例代码

```
public class HibernateHelper<T> implements DataHelper<T> {

    private SessionFactory sessionFactory;
    private Session session;
    private Class<T> type;

    //使用默认构造类，则sessionfactory不会被初始化！！！！！报错NUllPointer!

    public HibernateHelper() {

    }

    public HibernateHelper(Class<T> type) {
        this.type = type;
        Configuration configuration = new Configuration();
        sessionFactory = configuration.configure().buildSessionFactory();
    }
.......
```



### 11、严格遵守优秀的编程风格

#### 11.1 OCP风格开放-封闭原则

##### 11.1.1 举例

> ##### &emsp;kind类型全部采用枚举类，便于拓展
>
> ##### &emsp;ResultMessage作为返回类型取代boolean与String,便于拓展
>
> ##### &emsp;同时底层对上层信息隐藏，封闭修改
>
> ##### &emsp;工厂模式，对多种初始化的实现方式开放
>
> ![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E4%BB%A3%E7%A0%81%E5%BC%80%E5%8F%91%E8%BF%87%E7%A8%8B%E6%80%BB%E7%BB%93/13.png)

#### 11.2 行为与职责“在一起”

> ##### &emsp;比如是否需要创建过多工具类和辅助类

#### 

### 12、采用controller与逻辑控制相结合的控制器风格

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E4%BB%A3%E7%A0%81%E5%BC%80%E5%8F%91%E8%BF%87%E7%A8%8B%E6%80%BB%E7%BB%93/14.png)

### 13、接口设计合理，并且通过接口调用



### 14、 大作业产生的心得与经验：

#### 14.1 “V”字型代码调用与“7”字代码调用相结合

> ##### V字形调用的好处： 1）减少代码调用历程，便于Debug；2）减少类与类之间连续耦合； 3）直接调用，测试结果可靠
>
> ##### 缺点：1）不对修改开放 2）代码没有层进性
>
> ##### “7"字形调用的好处：1）可修改性提高 2）代码重用 3）代码具有层次性
>
> ##### 缺点：1）加长了调用路程，不利于Debug



### 14.2 方法数量采用倒三角形式，

![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E4%BB%A3%E7%A0%81%E5%BC%80%E5%8F%91%E8%BF%87%E7%A8%8B%E6%80%BB%E7%BB%93/15.png)
![](http://101.37.19.32:10080/FX/MSPSS/raw/master/doc/img/%E4%BB%A3%E7%A0%81%E5%BC%80%E5%8F%91%E8%BF%87%E7%A8%8B%E6%80%BB%E7%BB%93/16.png)