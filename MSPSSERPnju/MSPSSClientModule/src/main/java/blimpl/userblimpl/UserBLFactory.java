package blimpl.userblimpl;

import blservice.mainblservice.MainBLService;
import blservice.userblservice.UserBLService;
import blservice.userblservice.UserInfo;

/**
 * Description:
 * Created by Hanxinhu at 16:15 2017/12/21/021
 */
public class UserBLFactory {
    private static final User user = new User();

    private static UserBLServiceImpl impl;

    public static UserBLService getUserBLService() {
        if (impl == null) {
            impl = new UserBLServiceImpl(user);
        }
        return impl;
    }

    public static UserInfo getUserInfo() {
        if (impl == null) {
            impl = new UserBLServiceImpl(user);
        }
        return impl;
    }

    public static MainBLService getMainBLService() {
        if (impl == null) {
            impl = new UserBLServiceImpl(user);
        }
        return impl;
    }
}
