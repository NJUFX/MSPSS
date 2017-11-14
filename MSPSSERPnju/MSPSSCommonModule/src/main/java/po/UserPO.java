package po;

import util.Kind_Of_Power;
import util.Kind_Of_Users;

/**
 * Created by thinkpad on 2017/10/21.
 */
public class UserPO {
    private String ID;
    private String name;
    private Kind_Of_Users category;
    private String password;
    private String power;
    private boolean isValid = true;

    public UserPO(String i, String s, Kind_Of_Users category, String password, String power) {
        this.ID = i;
        this.name = s;
        this.category = category;
        this.password = password;
        this.power = power;
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

