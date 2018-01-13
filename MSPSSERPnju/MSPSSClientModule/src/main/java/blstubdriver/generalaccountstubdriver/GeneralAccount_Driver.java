package blstubdriver.generalaccountstubdriver;

import blservice.generalaccountblservice.GeneralAccountBLService;
import org.junit.Test;
import util.ResultMessage;
import util.Time;
import vo.GeneralAccountVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class GeneralAccount_Driver {
    GeneralAccountVO generalaccount = new GeneralAccountVO();

    GeneralAccountBLService service = new GeneralAccount_Stub();

    @Test
    public void drive() {
        ResultMessage result;
        //1
        result = service.addGeneralAcocunt(generalaccount);
        if (result == ResultMessage.SUCCESS) System.out.println("Sucess to new account");
        else System.out.println("Fail");
        //2
        ArrayList<GeneralAccountVO> list = new ArrayList<GeneralAccountVO>();
        list = service.fullSearchGeneralAccountByTime(new Time(2017, 11, 11, 11, 11, 1));
        if (list == null) System.out.println("check sucessfully");
        else System.out.println("fail");
        //3
        list = service.fuzzySearchGeneralAccountByName("");
        if (list == null) System.out.println("check sucessfully");
        else System.out.println("fail");

    }
}
