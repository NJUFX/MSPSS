package po;

import util.Kind_Of_Users;

import java.io.Serializable;

/**
 * Created by thinkpad on 2017/10/21.
 */
public class UserPO implements Serializable {
    /**
     * 编号
     * 用户的ID
     * 编号开头
     * ss 库存管理人员
     * sm 销售人员
     * fm 财务人员
     * cm 总经理
     */
    private String ID;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户种类
     * 1 对应库存管理人员
     * 2 对应 普通销售人员
     * 3 对应 销售经理
     * 4 对应 普通财务人员
     * 5 对应 财务经理即最高权限
     * 6 对应 总经理
     */
    private int category;
    /**
     * 密码保存时理应是已经加密过的密码 参见Encrypt.Encryptor
     */
    private String password;
    /**
     * 为了防止删除已经使用过的用户后出现系统错误
     */
    private boolean isValid = true;
    /**
     * 该用户的邮件地址
     */
    private String mail;




    public UserPO() {
    }

    public UserPO(String ID, String name, int category, String password, String mail) {
        this.ID = ID;
        this.name = name;
        this.category = category;
        this.password = password;
        this.mail = mail;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pa) {
        this.password = pa;
    }



    public String getName() {
        return name;
    }

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean b) {
        this.isValid = b;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * 用户种类
     * 1 对应库存管理人员
     * 2 对应 普通销售人员
     * 3 对应 销售经理
     * 4 对应 普通财务人员
     * 5 对应 财务经理即最高权限
     * 6 对应 总经理
     */
    public Kind_Of_Users getKind() {
        Kind_Of_Users kind;
        switch (category) {
            case 1:
                kind = Kind_Of_Users.StockManager;
                break;
            case 2:
                kind = Kind_Of_Users.StockSeller;
                break;
            case 3:
                kind = Kind_Of_Users.StockSellerManager;
                break;
            case 4:
                kind = Kind_Of_Users.Financer;
                break;
            case 5:
                kind = Kind_Of_Users.FinancerManager;
                break;
            case 6:
                kind = Kind_Of_Users.ChiefManager;
                break;
            default:
                kind = Kind_Of_Users.ChiefManager;
        }
        return kind;
    }


}

