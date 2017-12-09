package blimpl.accountblimpl;

import vo.AccountVO;

import java.util.Comparator;

/**
 * Description:根据余额降序排列
 * Created by Hanxinhu at 9:01 2017/12/9/009
 */
public class AccountMoneyDescendingComparator implements Comparator<AccountVO> {
    @Override
    public int compare(AccountVO o1, AccountVO o2) {
        if (o1.getMoney()>o2.getMoney())
            return -1;
        if (o1.getMoney()<o2.getMoney())
            return 1;
        return 0;
    }
}
