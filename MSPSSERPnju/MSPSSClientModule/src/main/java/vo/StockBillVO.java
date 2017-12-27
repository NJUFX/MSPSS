package vo;

import blimpl.stockblimpl.Stock;
import util.BillStatus;
import util.StockBillType;
import util.Time;

import java.util.ArrayList;

/**
 * Description: Created by Hanxinhu at 20:04 2017/11/21/021
 */
public class StockBillVO {
    /**
     * 库存单据ID
     */
    public String id;
    /**
     * 库存单据的具体类型
     */
    public StockBillType type;
    /**
     * 库存类订单当前的状态
     */
    public BillStatus status;
    /**
     * 单据中国包含的商品信息
     */
    public ArrayList<StockBillItemVO> itemVOS;

    /**
     * 单据的产生时间
     */
    public Time init_time;

    /**
     * 单据的提交时间
     */

    public Time commit_time;

    /**
     * 单据的审批时间
     */
    public Time approval_time;

    /**
     * 库存管理人员添加的备注说明
     */
    public String commentByStockManager;

    /**
     * 经理审批时的备注说明
     */
    public String commentByManager;
    /**
     * 产生该单据的库存管理人员
     */
    public UserVO stockManager;

    /**
     * 审批该单据的总经理
     */
    public UserVO manager;

    /**
     * 在产生界面端new vo时所需要的信息
     * 其余都在逻辑层赋值
     *
     * @param type
     * @param itemVOS
     * @param commentByStockManager
     * @param stockManager
     */
    public StockBillVO(StockBillType type, ArrayList<StockBillItemVO> itemVOS, String commentByStockManager, UserVO stockManager) {
        this.type = type;
        this.itemVOS = itemVOS;
        this.commentByStockManager = commentByStockManager;
        this.stockManager = stockManager;
    }

    public StockBillVO(String id, StockBillType type, BillStatus status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }

    public StockBillVO(String id, StockBillType type, BillStatus status, ArrayList<StockBillItemVO> itemVOS, Time init_time, Time commit_time, String commentByStockManager, UserVO stockManager) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.itemVOS = itemVOS;
        this.init_time = init_time;
        this.commit_time = commit_time;
        this.commentByStockManager = commentByStockManager;
        this.stockManager = stockManager;
    }

    public StockBillVO(String id, StockBillType type, BillStatus status, ArrayList<StockBillItemVO> itemVOS,
                       Time init_time, String commentByStockManager, UserVO stockManager) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.init_time = init_time;
        this.itemVOS = itemVOS;
        this.commentByStockManager = commentByStockManager;
        this.stockManager = stockManager;
    }


    public StockBillVO(String id, StockBillType type, BillStatus status, ArrayList<StockBillItemVO> itemVOS,
                       Time init_time, Time commit_time, Time approval_time, String commentByStockManager, String commentByManager,
                       UserVO stockManager, UserVO manager) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.itemVOS = itemVOS;
        this.init_time = init_time;
        this.commit_time = commit_time;
        this.approval_time = approval_time;
        this.stockManager = stockManager;
        this.manager = manager;
        this.commentByManager = commentByManager;
        this.commentByStockManager = commentByStockManager;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setManager(UserVO manager) {
        this.manager = manager;
    }

    public UserVO getManager() {
        return manager;
    }

    public void setStockManager(UserVO stockManager) {
        this.stockManager = stockManager;
    }

    public UserVO getStockManager() {
        return stockManager;
    }

    public void setType(StockBillType type) {
        this.type = type;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setItemVOS(ArrayList<StockBillItemVO> itemVOS) {
        this.itemVOS = itemVOS;
    }

    public void setApproval_time(Time approval_time) {
        this.approval_time = approval_time;
    }

    public void setCommentByManager(String commentByManager) {
        this.commentByManager = commentByManager;
    }

    public void setCommentByStockManager(String commentByStockManager) {
        this.commentByStockManager = commentByStockManager;
    }

    public void setCommit_time(Time commit_time) {
        this.commit_time = commit_time;
    }

    public void setInit_time(Time init_time) {
        this.init_time = init_time;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public ArrayList<StockBillItemVO> getItemVOS() {
        return itemVOS;
    }

    public StockBillType getType() {
        return type;
    }

    public String getCommentByManager() {
        return commentByManager;
    }

    public String getCommentByStockManager() {
        return commentByStockManager;
    }

    public Time getApproval_time() {
        return approval_time;
    }

    public Time getCommit_time() {
        return commit_time;
    }

    public Time getInit_time() {
        return init_time;
    }
}
