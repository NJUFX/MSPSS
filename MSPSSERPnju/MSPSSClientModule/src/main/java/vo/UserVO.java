package vo;

import util.Kind_Of_Users;

public class UserVO {
    /**
     * 用户的ID
     编号开头
     ss 库存管理人员
     sm 销售人员
     fm 财务人员
     cm 总经理
     */

    private String ID;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户的种类
     */
    private Kind_Of_Users category;
    /**
     * 用户的密码
     */
    private String password;
    /**
     * 是否被使用过
     */
    private boolean isValid;
    /**
     * 是否登入
     */
    private boolean isLogin;
    /**
     * 用户的邮件地址
     */
    private String mail;

    public boolean getIsLogin() {
        return isValid;
    }

    public void setIsLogin(boolean b) {
        this.isValid = b;
    }

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean b) {
        this.isValid = b;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Kind_Of_Users getCategory() {
        return category;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pa) {
        this.password = pa;
    }


    /**
     *
     * @param ID
     * @param name
     * @param category
     * @param password
     */
    public UserVO(String ID,String name,Kind_Of_Users category,String password){
        this.ID = ID;
        this.name = name;
        this.category = category;
        this.password = password;
    }

    public int getCategoryForPO() {
        switch (category) {
            case Financer:
                return 4;
            case StockSeller:
                return 2;
            case FinancerManager:
                return 5;
            case StockManager:
                return 1;
            case StockSellerManager:
                return 3;
            case ChiefManager:
                return 6;
            default:
                return 0;
        }

    }

    public UserVO(String ID, String name, Kind_Of_Users category, String password, String mail) {
        this.ID = ID;
        this.name = name;
        this.category = category;
        this.password = password;
        this.mail = mail;
    }
}
