package blimpl.accountblimpl;

import vo.AccountVO;

import java.util.Comparator;

/**
 * 根据名字从A到Z排列
 * Created by thinkpad on 2017/11/11.
 */
public class AccountNameAscendingComparator implements Comparator<AccountVO> {
    @Override
    public int compare(AccountVO o1, AccountVO o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
