package blimpl.generalaccountblimpl;

import blservice.generalaccountblservice.GeneralAccountBLService;

/**
 * Created by thinkpad on 2017/12/25.
 */
public class GeneralAccountBLFactory {
    private static  GeneralAccount generalAccount = new GeneralAccount();
    private static GeneralAccountBLService generalAccountBLService;

    public synchronized static GeneralAccountBLService getGeneralAccountBLService(){
        if(generalAccountBLService==null){
            generalAccountBLService = new GeneralAccountBLServiceImpl(generalAccount);
        }
        return generalAccountBLService;

    }
}
