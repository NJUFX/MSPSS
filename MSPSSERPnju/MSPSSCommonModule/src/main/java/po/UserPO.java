package po;

/**
 * Created by thinkpad on 2017/10/21.
 */
public class UserPO {
    String id;
    String name;
    boolean checkListLimit;
    boolean examineBillLimit;
    boolean readLogLimit;
    boolean makePromotionLimit;

    public UserPO(String i, String s, boolean c, boolean e, boolean r, boolean m) {
        id = i;
        name = s;
        checkListLimit = c;
        examineBillLimit = e;
        readLogLimit = r;
        makePromotionLimit = m;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getCheckListLimit() {
        return checkListLimit;
    }

    public boolean getExamineLimit() {
        return examineBillLimit;
    }

    public boolean getReadLogLimit() {
        return readLogLimit;
    }

    public boolean getMakePromotionLimit() {
        return makePromotionLimit;
    }
}

