package datastubdriver.generalaccountdatastubservice;


import dataservice.GeneralAccountDataService;
import org.junit.Test;
import po.GeneralAccountPO;
import util.ResultMessage;
import util.Time;


import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/13.
 */
public class GeneralAccountDataService_Driver {
    GeneralAccountPO generalaccount = new GeneralAccountPO();

    GeneralAccountDataService service = new GeneralAccountDataService_Stub();

    @Test
    public void drive() {
        ResultMessage result;
        //1
        result = service.newGeneralAccount(generalaccount);
        if (result == ResultMessage.SUCCESS) System.out.println("Sucess to new account");
        else System.out.println("Fail");
        //2
        ArrayList<GeneralAccountPO> list = new ArrayList<GeneralAccountPO>();
        list = service.checkGeneralAccount(new Time(2017, 11, 11, 11, 11, 11), new Time(2017, 12, 11, 11, 11, 11));
        if (list == null) System.out.println("check sucessfully");
        else System.out.println("fail");
    }
}
