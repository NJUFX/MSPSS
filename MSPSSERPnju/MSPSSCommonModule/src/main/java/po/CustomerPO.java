package po;

import util.Kind_Of_Customers;

public class CustomerPO {
    /**
     * 判断客户是否存在
     */
    private boolean Exist;
    /**
     * 客户编号
     */
    private String ID;
    /**
     * 分类
     */
    private int category;
    /**
     * 等级
     */
    private int level;
    /**
     * 姓名
     */
    private String name;
    /**
     * 电话号码
     */
    private String phonenumber;
    /**
     * 地址
     */
    private String address;
    /**
     * 邮编
     */
    private String postcode;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 应收额度
     */
    private double Invalue;
    /**
     * 应收
     */
    private double incomemoney;
    /**
     * 应付
     */
    private double paymoney;
    /**
     * 默认业务员
     */
    private String DAE;
    /**
     * 银行账户
     */
    private String accountID;
    //暂定用String表示客户类型
  //  /**
 //    * 客户分类
  //   */
  //  private Kind_Of_Customers kind;


    public CustomerPO() {
    }

    public CustomerPO(boolean exist, String ID, int category, int level, String name, String phonenumber, String address, String postcode, String email, double invalue, double incomemoney, double paymoney, String DAE, String accountID) {
        Exist = exist;
        this.ID = ID;
        this.category = category;
        this.level = level;
        this.name = name;
        this.phonenumber = phonenumber;
        this.address = address;
        this.postcode = postcode;
        this.email = email;
        Invalue = invalue;
        this.incomemoney = incomemoney;
        this.paymoney = paymoney;
        this.DAE = DAE;
        this.accountID = accountID;
    }

    public boolean isExist() {
        return Exist;
    }

    public void setExist(boolean exist) {
        Exist = exist;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getInvalue() {
        return Invalue;
    }

    public void setInvalue(double invalue) {
        Invalue = invalue;
    }

    public double getIncomemoney() {
        return incomemoney;
    }

    public void setIncomemoney(double incomemoney) {
        this.incomemoney = incomemoney;
    }

    public double getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(double paymoney) {
        this.paymoney = paymoney;
    }

    public String getDAE() {
        return DAE;
    }

    public void setDAE(String DAE) {
        this.DAE = DAE;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }
}

