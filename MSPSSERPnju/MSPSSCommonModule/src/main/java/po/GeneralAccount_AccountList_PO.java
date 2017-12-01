package po;

import java.io.Serializable;

/**
 * Created by thinkpad on 2017/11/30.
 */
public class GeneralAccount_AccountList_PO  {

    private String name;
    private int money;
    private GeneralAccountPO generalaccount;



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
