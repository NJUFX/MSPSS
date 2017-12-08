package po;

import util.BillStatus;
import util.StockBillType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by Hanxinhu at 20:39 2017/11/27/027
 */
public class StockBillPO implements Serializable{
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
    private List<StockBillItemPO> itemPOS;

    /**
     * 单据的产生时间
     */
    private String init_time;

    /**
     * 单据的提交时间
     */

    private String commit_time;

    /**
     * 单据的审批时间
     */
    private String approval_time;

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

<<<<<<< HEAD
    public StockBillPO(StockBillType type, BillStatus status, List<StockBillItemPO> itemPOS, Time init_time, Time commit_time, Time approval_time, String commentByStockManager, String commentByManager, String initID, String approvalID) {
=======
    public StockBillPO(StockBillType type, BillStatus status, ArrayList<StockBillItemPO> itemPOS, String init_time,
                       String commit_time, String approval_time, String commentByStockManager, String commentByManager,
                       String initID, String approvalID ){
>>>>>>> f4629d107257d0548b122ca949fef85a75dc1d68
        this.type = type;
        this.status = status;
        this.itemPOS = itemPOS;
        this.init_time = init_time;
        this.commit_time = commit_time;
        this.approval_time = approval_time;
        this.commentByStockManager = commentByStockManager;
        this.commentByManager = commentByManager;
        this.initID = initID;
        this.approvalID = approvalID;
    }

<<<<<<< HEAD
=======
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

    public String getInit_time() {
        return init_time;
    }

    public void setInit_time(String init_time) {
        this.init_time = init_time;
    }

>>>>>>> f4629d107257d0548b122ca949fef85a75dc1d68
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

<<<<<<< HEAD
    public List<StockBillItemPO> getItemPOS() {
        return itemPOS;
    }

    public void setItemPOS(List<StockBillItemPO> itemPOS) {
        this.itemPOS = itemPOS;
    }

    public Time getInit_time() {
        return init_time;
    }

    public void setInit_time(Time init_time) {
        this.init_time = init_time;
    }

    public Time getCommit_time() {
=======
    public String getCommit_time() {
>>>>>>> f4629d107257d0548b122ca949fef85a75dc1d68
        return commit_time;
    }

    public void setCommit_time(String commit_time) {
        this.commit_time = commit_time;
    }

    public Time getApproval_time() {
        return approval_time;
    }

    public void setApproval_time(Time approval_time) {
        this.approval_time = approval_time;
    }

    public String getCommentByStockManager() {
        return commentByStockManager;
    }

<<<<<<< HEAD
    public void setCommentByStockManager(String commentByStockManager) {
        this.commentByStockManager = commentByStockManager;
    }

    public String getCommentByManager() {
        return commentByManager;
=======
    public void setApproval_time(String approval_time) {
        this.approval_time = approval_time;
    }

    public String getApproval_time() {
        return approval_time;
>>>>>>> f4629d107257d0548b122ca949fef85a75dc1d68
    }

    public void setCommentByManager(String commentByManager) {
        this.commentByManager = commentByManager;
    }

    public String getInitID() {
        return initID;
    }

    public void setInitID(String initID) {
        this.initID = initID;
    }

    public String getApprovalID() {
        return approvalID;
    }

    public void setApprovalID(String approvalID) {
        this.approvalID = approvalID;
    }
}
