//package blimpl.generalaccountblimpl;
//
//import util.ResultMessage;
//import util.Time;
//import vo.AccountVO;
//import vo.GeneralAccountVO;
//
//import java.util.ArrayList;
//
///**
// * Created by thinkpad on 2017/11/11.
// */
//public class MockGeneralAccount extends GeneralAccount{
//
//
//    public ArrayList<GeneralAccountVO> checkGeneralAccount(Time begin, Time end) {
//        ArrayList<GeneralAccountVO> list = new ArrayList<GeneralAccountVO>();
//        GeneralAccountVO g = new GeneralAccountVO();
//        AccountVO a = new AccountVO("苏果超市",1000,new Time(2017,11,11,11,11,11));
//        g.addAccount(a);
//        list.add(g);
//
//
//        if(begin.isBefore(end)) {
//            return list;
//        }
//        else{
//            return null;
//        }
//
//    }
//
//
//    public ResultMessage newGeneralAccount(GeneralAccountVO generalaccount) {
//        if(generalaccount.getaccountlist().get(0).getName().equals(("苏果超市")))
//
//              return ResultMessage.SUCCESS;
//        else
//
//              return ResultMessage.EXIST;
//    }
//
//
//    public ArrayList<GeneralAccountVO> ETLsort(ArrayList<GeneralAccountVO> accountlist) {
//        return accountlist;
//    }
//}
