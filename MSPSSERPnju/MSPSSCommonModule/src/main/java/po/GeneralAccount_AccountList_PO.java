package po;

import java.io.Serializable;

/**
 * Created by thinkpad on 2017/11/30.
 */
public class GeneralAccount_AccountList_PO implements Serializable  {

    private String keycolumn;
    private String name;
    private double money;
    private GeneralAccountPO generalaccount;

    public GeneralAccount_AccountList_PO() {
    }



    public GeneralAccount_AccountList_PO(String name, double money, GeneralAccountPO generalaccount) {
        this.name = name;
        this.money = money;
        this.generalaccount = generalaccount;
    }

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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
