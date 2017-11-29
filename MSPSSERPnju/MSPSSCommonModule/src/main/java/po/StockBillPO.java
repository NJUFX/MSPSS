package po;

import util.BillStatus;
import util.StockBillType;
import util.Time;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 20:39 2017/11/27/027
 */
public class StockBillPO {
    /**
     * 库存单据的具体类型
     */
    private StockBillType type;
    /**
     * 库存类订单当前的状态
     */
    private BillStatus status;
    /**
     * 单据中国包含的商品信息
     */
    private ArrayList<StockBillItemPO> itemPOS;

    /**
     * 单据的产生时间
     */
    private Time init_time;

    /**
     * 单据的提交时间
     */

    private Time commit_time;

    /**
     * 单据的审批时间
     */
    private Time approval_time;

    /**
     * 库存管理人员添加的备注说明
     */
    private String commentByStockManager;

    /**
     * 经理审批时的备注说明
     */
    private String commentByManager;
    /**
     * 生成该库存类单据的库存管理人员的ID编号
     */
    private String initID;

    /**
     * 审批该单据的总经理的编号
     */
    private String approvalID;

    public StockBillPO(StockBillType type,BillStatus status,ArrayList<StockBillItemPO> itemPOS,Time init_time,
                       Time commit_time,Time approval_time,String commentByStockManager,String commentByManager,
                      String initID,String approvalID ){
        this.type = type;
        this.status = status;
        this.itemPOS = itemPOS;
        this.init_time = init_time;
        this.commit_time = commit_time;
        this.approval_time = approval_time;
        this.commentByManager = commentByManager;
        this.commentByStockManager = commentByStockManager;
        this.initID = initID;
        this.approvalID = approvalID;
    }

    public void setApprovalID(String approvalID) {
        this.approvalID = approvalID;
    }

    public String getApprovalID() {
        return approvalID;
    }

    public String getInitID() {
        return initID;
    }

    public void setInitID(String initID) {
        this.initID = initID;
    }

    public Time getInit_time() {
        return init_time;
    }

    public void setInit_time(Time init_time) {
        this.init_time = init_time;
    }

    public StockBillType getType() {
        return type;
    }

    public void setType(StockBillType type) {
        this.type = type;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public Time getCommit_time() {
        return commit_time;
    }

    public void setCommit_time(Time commit_time) {
        this.commit_time = commit_time;
    }

    public void setCommentByStockManager(String commentByStockManager) {
        this.commentByStockManager = commentByStockManager;
    }

    public String getCommentByStockManager() {
        return commentByStockManager;
    }

    public void setApproval_time(Time approval_time) {
        this.approval_time = approval_time;
    }

    public Time getApproval_time() {
        return approval_time;
    }

    public void setCommentByManager(String commentByManager) {
        this.commentByManager = commentByManager;
    }

    public String getCommentByManager() {
        return commentByManager;
    }

    public void setItemPOS(ArrayList<StockBillItemPO> itemPOS) {
        this.itemPOS = itemPOS;
    }

    public ArrayList<StockBillItemPO> getItemPOS() {
        return itemPOS;
    }
}
