package vo;

import util.*;

public class UserVO {
    /**
     * 用户的ID
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
     * 用户的权限
     */
    private String power;
    /**
     * 是否被使用过
     */
    private boolean isValid;
    /**
     * 是否登入
     */
    private boolean isLogin;

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

    public String getPower() {
        return power;
    }

    public void setPower(String po) {
        this.power = po;
    }

    /**
     * @param Id
     * @param Name
     * @param Category
     * @param Password
     * @param Power
     */
    public UserVO(String Id, String Name, Kind_Of_Users Category, String Password, String Power) {
        this.ID = Id;
        this.name = Name;
        this.category = Category;
        this.password = Password;
        this.power = Power;
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
}
