package dataservice;


import filterflags.BillFilter;
import po.BillPO;
import util.ResultMessage;

import java.util.Iterator;

public interface BillDataService {
    /**
     * 增加单据
      * @param billPO
     * @return
     */
 public ResultMessage addBill(BillPO billPO);

    /**
     * 删除单据
     * @param id
     * @return
     */
 public ResultMessage deleteBill(String id);

    /**
     * 更新单据
     * @param billPO
     * @return
     */
 public ResultMessage updateBill(BillPO billPO);

    /**
     * 搜索单据
     * @param filter
     * @return
     */
 public Iterator<BillPO> searchBill(BillFilter filter);


}


