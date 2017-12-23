package blservice.accountblservice;

import vo.AccountVO;

/**
 * Created by hanxinhu on 2017/11/11.
 */
public interface AccountBLInfo {
    /**
     * 账户收款
     *
     * @param name,money
     * @return void
     */
    public void income(String name, double money);
    /**
     * 账户付款
     *
     * @param name,money
     * @return void
     */
    public void pay(String name, double money);

    public AccountVO getAccountVO(String name);
}
