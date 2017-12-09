package blimpl.accountblimpl;

import vo.AccountVO;

import java.util.Comparator;

/**
 * Description:根据账户名从Z到A排列
 * Created by Hanxinhu at 8:56 2017/12/9/009
 */
public class AccountNameDescendingComparator implements Comparator<AccountVO> {
    @Override
    public int compare(AccountVO o1, AccountVO o2) {
        return o2.getName().compareTo(o1.getName());
    }


}
