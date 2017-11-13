package datastubdriver.generalaccountdatastubservice;

import blservice.generalaccountblservice.GeneralAccountBLService;
import blstubdriver.generalaccountstubdriver.GeneralAccount_Stub;
import org.junit.Test;
import util.ResultMessage;
import util.Time;
import vo.GeneralAccountVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/13.
 */
public class GeneralAccountDataService_Driver {
    GeneralAccountVO generalaccount = new GeneralAccountVO();

    GeneralAccountBLService service = new GeneralAccount_Stub();

    @Test
    public void drive() {
        ResultMessage result;
        //1
        result = service.newGeneralAccount(generalaccount);
        if (result == ResultMessage.SUCCESS) System.out.println("Sucess to new account");
        else System.out.println("Fail");
        //2
        ArrayList<GeneralAccountVO> list = new ArrayList<GeneralAccountVO>();
        list = service.checkGeneralAccount(new Time(2017, 11, 11, 11, 11, 11), new Time(2017, 12, 11, 11, 11, 11));
        if (list == null) System.out.println("check sucessfully");
        else System.out.println("fail");
    }
}
