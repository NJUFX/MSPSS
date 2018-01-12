package vo;

import util.Kind_Of_Customers;

public class CustomerVO {
    /**
     * 判断客户是否存在
     */
    private boolean isExist;
    /**
     * 客户编号
     */
    private String ID;
    /**
     * 客户分类
     */
    private Kind_Of_Customers category;
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
    public String address;
    /**
     * 邮编
     */
    public String postcode;
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

    public Kind_Of_Customers getCategory() {
        return category;
    }

    public void setCategory(Kind_Of_Customers category) {
        this.category = category;
    }

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
     * @param category
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
    public CustomerVO(String ID, Kind_Of_Customers category, int level, String name, String phonenumber, String address, String postcode, String email, double InValue, double incomemoney, double paymoney, String DAE) {
        this.ID = ID;
        this.category = category;
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

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "客户名称为 " + getID() + " 客户名称为 " + getName() + " 联系方式为：" + getPhonenumber() + " 邮箱为 " + getEmail() + " 地址为 " + getAddress();
    }
}