package vo;

import util.*;

public class UserVO {
    private String ID;
    private String name;
    private Kind_Of_Users category;
    private String password;
    private String power;
    private boolean isValid;
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
}
