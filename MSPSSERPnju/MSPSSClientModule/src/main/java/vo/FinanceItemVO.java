package vo;

/**
 * Description:
 * Created by Hanxinhu at 19:02 2017/11/28/028
 */
public class FinanceItemVO {
    /**
     * 银行账户
     */
    public AccountVO accountVO;
    /**
     * 备注
     */
    public String ps;
    /**
     * 金额
     */
    public double money;

    public FinanceItemVO(AccountVO accountVO, String ps, double money) {
        this.accountVO = accountVO;
        this.ps = ps;
        this.money = money;
    }

    public AccountVO getAccountVO () {
    	  return accountVO;
    }

    public void setAccountVO(AccountVO accountVO) {
        this.accountVO = accountVO;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
