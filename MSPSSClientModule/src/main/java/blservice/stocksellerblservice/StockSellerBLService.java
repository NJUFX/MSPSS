package blservice.stocksellerblservice;

import util.Kind_Of_Customers;
import vo.*;
import java.lang.reflect.Array;
import java.util.*;

public interface StockSellerBLService {
    /**
     * 通过关键词类型和关键词来查找客户
     *
     * @param keytype
     * @param keyword
     * @return
     */
    public ArrayList<CustomerVO> searchCustomer(String keytype, String keyword);

    /**
     * 通过客户编号获取客户属性
     *
     * @param ID
     * @return
     */
    public CustomerVO getCustomer(String ID);

    /**
     * 增加客户
     *
     * @param ID       客户编号
     * @param kind 分类
     * @param level
     * @param name
     * @param tele
     * @param address
     * @param postcode 邮编
     * @param email
     * @param InValue  应收额度
     * @param in       应收
     * @param out      应付
     * @param DAE      默认业务员
     * @return
     */
    public boolean addCustomer(String ID, Kind_Of_Customers kind, int level, String name, String tele, String address, String postcode, String email, double InValue, double in, double out, String DAE);

    /**
     * 增加客户
     * @param customer
     * @return
     */
    public boolean addCustomer(CustomerVO customer);
    /**
     * 删除客户
     *
     * @param ID
     * @return
     */
    public boolean delCustomer(String ID);

    /**
     * 修改客户属性
     *
     * @param kind
     * @param level
     * @param name
     * @param tele
     * @param address
     * @param postcode
     * @param email
     * @param InValue
     * @return
     */
    public boolean ModifyCustomer(String ID, Kind_Of_Customers kind, int level, String name, String tele, String address, String postcode, String email, double InValue);

    /**
     * 制定进货单
     *
     * @param supplier
     * @param store
     * @param worker
     * @param prolist
     * @param sum
     * @param remark
     * @return
     */
    public boolean createPurchaseList(CustomerVO supplier, String store, String worker, ArrayList<CommodityVO> prolist, double sum, String remark);

    /**
     * 制定进货退货单
     *
     * @param supplier
     * @param store
     * @param worker
     * @param prolist
     * @param sum
     * @param remark
     * @return
     */
    public boolean createPurchaseReturnList(CustomerVO supplier, String store, String worker, ArrayList<CommodityVO> prolist, double sum, String remark);

    /**
     * 制定销售单
     *
     * @param saler
     * @param DAE      默认业务员
     * @param worker   操作员
     * @param store
     * @param prolist
     * @param befSum   折让前总额
     * @param discount 折扣
     * @param vocher   代金券
     * @param aftSum   折让后总额
     * @param remark   备注
     * @return
     */
    public boolean createSalesList(CustomerVO saler, String DAE, String worker, String store, ArrayList<CommodityVO> prolist, double befSum, double discount, double vocher, double aftSum, String remark);

    /**
     * 制定销售退货单
     *
     * @param saler
     * @param DAE
     * @param worker
     * @param store
     * @param prolist
     * @param befSum
     * @param discount
     * @param vocher
     * @param aftSum
     * @param remark
     * @return
     */
    public boolean createSalesReturnList(CustomerVO saler, String DAE, String worker, String store, ArrayList<CommodityVO> prolist, double befSum, double discount, double vocher, double aftSum, String remark);

    //public ArrayList<CommodityVO> createCommodityList();
}
