package po;

import util.Kind_Of_Power;
import util.Kind_Of_Users;

/**
 * Created by thinkpad on 2017/10/21.
 */
public class UserPO {
    private String ID;
    private String name;
    private int category;
    private String password;
    private String power;
    private boolean isValid = true;

    public UserPO(String ID, String name, int category, String password, String power) {
        this.ID = ID;
        this.name = name;
        this.category = category;
        this.password = password;
        this.power = power;
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

    public String getPower() {
        return power;
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

    public String getId() {
        return ID;
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

    public void setPower(String power) {
        this.power = power;
    }

    public boolean getCheckListLimit() {
        if (power.charAt(0) == '0') {
            return false;
        }
        return true;
    }

    public boolean getExamineLimit() {
        if (power.charAt(1) == '0') {
            return false;
        }
        return true;
    }

    public boolean getReadLogLimit() {
        if (power.charAt(2) == '0') {
            return false;
        }
        return true;
    }

    public boolean getMakePromotionLimit() {
        if (power.charAt(3) == '0') {
            return false;
        }
        return true;
    }
}

