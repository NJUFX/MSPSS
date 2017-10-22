package vo;

import util.Kind_Of_Customers;

public class CustomerVO {
    /**
     * 判断客户是否存在
     */
    public boolean isExist;
    /**
     * 客户编号
     */
    public String ID;
    /**
     * 等级
     */
    public int level;
    /**
     * 姓名
     */
    public String name;
    /**
     * 电话号码
     */
    public String phonenumber;
    /**
     * 地址
     */
    public String address;
    /**
     * 邮编
     */
    public String postcode;
    /**
     * 电子邮箱
     */
    public String email;
    /**
     * 应收额度
     */
    public double Invalue;
    /**
     * 应收
     */
    public double incomemoney;
    /**
     * 应付
     */
    public double paymoney;
    /**
     * 默认业务员
     */
    public String DAE;
    /**
     * 银行账户
     */
    public BankAccountVO bankaccount;
    /**
     * 客户分类
     */
    public Kind_Of_Customers kind;


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public double getInvalue() {
        return Invalue;
    }

    public void setInvalue(double invalue) {
        Invalue = invalue;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDAE() {
        return DAE;
    }

    public void setDAE(String DAE) {
        this.DAE = DAE;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankAccountVO getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(BankAccountVO bankaccount) {
        this.bankaccount = bankaccount;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Kind_Of_Customers getKind() {
        return kind;
    }

    public void setKind(Kind_Of_Customers kind) {
        this.kind = kind;
    }

    public boolean getExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }

    /**
     * 客户属性构造方法
     *
     * @param ID
     * @param kind
     * @param level
     * @param name
     * @param phonenumber
     * @param address
     * @param postcode
     * @param email
     * @param InValue     应收额度
     * @param incomemoney 应收
     * @param paymoney    应付
     * @param DAE         默认业务员
     */
    public CustomerVO(String ID, Kind_Of_Customers kind, int level, String name, String phonenumber, String address, String postcode, String email, double InValue, double incomemoney, double paymoney, String DAE) {
        this.ID = ID;
        this.kind = kind;
        this.level = level;
        this.name = name;
        this.phonenumber = phonenumber;
        this.address = address;
        this.postcode = postcode;
        this.email = email;
        this.Invalue = InValue;
        this.incomemoney = incomemoney;
        this.paymoney = paymoney;
        this.DAE = DAE;
        this.isExist = true;
    }
}