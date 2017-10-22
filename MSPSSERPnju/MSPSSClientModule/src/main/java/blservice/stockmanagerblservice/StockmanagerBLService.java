package blservice.stockmanagerblservice;


import VO.*;

import util.ResultMessage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public interface StockmanagerBLService {
    /**
     * @param ID   商品编号
     * @param name 商品名称
     * @param type 商品类型
     * @return 是否成功添加，如果否，返回异常信息
     */

    public ResultMessage addCommodity(String ID, String name, String type);

    /**
     * @param ID       要修改的商品编号
     * @param new_name
     * @param new_type
     * @return 是否成功修改，如果否，返回异常信息
     */
    public ResultMessage modifyCommodity(String ID, String new_name, String new_type);

    /**
     * @param commodity_vo 选中的商品
     * @return 是否成功删除，如果否返回异常信息
     */
    public ResultMessage deleteCommodity(CommodityVO commodity_vo);

    /***
     *
     * @param flagvo 筛选标志
     * @return 搜索到的商品列表
     */
    public Iterator<CommodityVO> searchCommodity(FilterFlagVO flagvo);

    /**
     *
     * @param ID 商品的ID
     * @return
     */
    public CommodityVO getCommodity(String ID);

    /**
     *
     * @param parentID 父分类节点
     * @param name 分类名称
     * @return
     */
    public ResultMessage addClassification(String parentID, String name);

    /**
     *
     * @param ID 分类节点ID
     * @return
     */
    public ResultMessage deleteClassification(String ID);

    /**
     *
     * @param ID 要修改的 分类ID
     * @param newParentID 新的位置处的父类ID
     * @param newName 新的分类名称
     * @return
     */
    public ResultMessage modifyClassification(String ID, String newParentID, String newName);

    /**
     *
     * @return 得到分类集合的树集
     */
    public Iterator<ClassificationVO> getClassifications();

    /**
     *
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    public Iterator<StockVO> viewStock(String startTime, String endTime);

    /**
     *
     * @return 返回今日的库存数量
     */
    public Iterator<InventoryVO> inventoryCheck();

    /**
     *
     * @param commodityVO 商品
     * @param numbers 商品实际库存
     * @return
     */
    public ResultMessage makeLossAndOverflowReport(ArrayList < CommodityVO> commodityVO, ArrayList< Integer> numbers);

    /**
     *
     * @param commodity 商品
     * @param numbers   实际库存
     * @return
     */
    public ResultMessage makePresentationReport(ArrayList< CommodityVO> commodity,ArrayList< Integer> numbers);

    /**
     *
     * @param report 报警单
     * @return
     */
    public ResultMessage dealAlarmReport(AlarmReportVO report);
}