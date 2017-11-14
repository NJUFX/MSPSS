package datastubdriver.billdatastubdriver;

import dataservice.BillDataService;
import filterflags.BillFilter;
import po.BillPO;
import util.ResultMessage;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Project_Name ERPnju
 * Author: HanXinHu
 * Description:
 * Created on 22:31 2017/11/12/012
 */
public class BillDataService_Stub implements BillDataService {
    @Override
    public ResultMessage addBill(BillPO billPO) {
        if (billPO!=null){
            System.out.println("add bill succeed");
            return ResultMessage.SUCCESS;
        }
        System.out.println("add bill fail");
        return ResultMessage.FAILED;
    }

    @Override
    public ResultMessage deleteBill(String id) {
        if (id.equals("12138")){
            System.out.println("delete bill succeed");
            return ResultMessage.SUCCESS;
        }
        System.out.println("delete bill fail");
        return ResultMessage.FAILED;
    }

    @Override
    public ResultMessage updateBill(BillPO billPO) {
        if (billPO!=null){
            System.out.println("update bill succeed");
            return ResultMessage.SUCCESS;
        }
        System.out.println("update bill fail");
        return ResultMessage.FAILED;
    }

    @Override
    public Iterator<BillPO> searchBill(BillFilter filter) {
        if (filter!=null){
            System.out.println("search bill succeed");
            return new ArrayList<BillPO>().iterator();
        }
        System.out.println("search bill fail");
        return null;
    }
}
