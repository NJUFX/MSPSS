package po;

import java.io.Serializable;

/**
 * Created by thinkpad on 2017/11/30.
 */
public class GeneralAccount_AccountList_PO implements Serializable  {

    private String keycolumn;
    private String name;
    private int money;
    private GeneralAccountPO generalaccount;

    public String getKeycolumn() {
        return keycolumn;
    }

    public void setKeycolumn(String keycolumn) {
        this.keycolumn = keycolumn;
    }

    public GeneralAccountPO getGeneralaccount() {
        return generalaccount;
    }

    public void setGeneralaccount(GeneralAccountPO generalaccount) {
        this.generalaccount = generalaccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


}
