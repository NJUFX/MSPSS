package blservice.tableblservice;

import filterflags.SaleTableFilterFlags;
import filterflags.BusinessTableFilterFlags;
import filterflags.ProcessTableFilterFlags;
import util.Time;
import vo.*;

/**
 * Created by thinkpad on 2017/11/11.
 */

public interface TableBLService {
    /**
     * 查询销售明细表
     *
     * @param flags
     * @return 销售明细表VO
     */
    public SaleTableVO checkSaleTable(SaleTableFilterFlagsVO flags);
    /**
     * 查询经营情况表
     *
     * @param begin,end
     * @return 经营情况表VO
     */
    public BusinessTableVO checkBusinessTable(Time begin,Time end);
    /**
     * 查询经营历程表,!!!注意客户名，业务名如果有重复的情况，只能查找到一个业务员的所有单据，不能查到多个重名的业务员
     *
     * @param flags
     * @return 经营历程表VO
     */
    public ProcessTableVO checkProcessTable(ProcessTableFilterFlagsVO flags);
    /**
     * 导出经营情况表
     *
     * @param businesstable
     * @return void
     */
    public void exportBusinessTable(BusinessTableVO businesstable);
    /**
     * 导出销售明细表
     *
     * @param saletable
     * @return void
     */
    public void exportSaleTable(SaleTableVO saletable);
    /**
     * 导出经营历程表
     *
     * @param processtable
     * @return void
     */
    public void exportProcessTable(ProcessTableVO processtable);
    /**
     * 按时间先后排序
     *
     * @param saletable
     * @return 排序好的VO
     */
    public SaleTableVO compareSTByTime(SaleTableVO saletable);
    /**
     * 按姓名字典序先后排序
     *
     * @param saletable
     * @return 排序好的VO
     */
    public SaleTableVO compareSTByName(SaleTableVO saletable);
    /**
     * 按时间先后排序
     *
     * @param businesstable
     * @return 排序好的VO
     */
    public BusinessTableVO compareBTByTime(BusinessTableVO businesstable);
    /**
     * 按时间先后排序
     *
     * @param processtable
     * @return 排序好的VO
     */
    public ProcessTableVO comparePTByTime(ProcessTableVO processtable);
    /**
     * 按姓名字典序先后排序
     *
     * @param processtable
     * @return 排序好的VO
     */
    public ProcessTableVO comparePTByName(ProcessTableVO processtable);


}
