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
    
    public AccountVO getAccountVO () {
    	  return accountVO;
    }
}
