package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by Hanxinhu at 20:39 2017/11/27/027
 */
public class StockBillPO implements Serializable{
    /**
     * 本来是没想到的
     * 但是为了统一格式 还是加上统一类型的ID吧
     * 库存赠送单 KCZSD-20171111-00001
     * 库存报损单 KCBSD-
     * 库存报溢单 KCBYD-
     */
    private String ID;
    /**
     * 库存单据的具体类型
     */
    private int type;
    /**
     * 库存类订单当前的状态
     */
    private int status;
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

    public StockBillPO() {
    }

    public StockBillPO(String ID, int type, int status, List<StockBillItemPO> itemPOS, String init_time, String commit_time, String approval_time, String commentByStockManager, String commentByManager, String initID, String approvalID) {
        this.ID = ID;
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

    public StockBillPO(int type, int status, ArrayList<StockBillItemPO> itemPOS, String init_time,
                       String commit_time, String approval_time, String commentByStockManager, String commentByManager,
                       String initID, String approvalID ){

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

    public int getType() {
        return type;
    }

    public int getStatus() {
        return status;
    }

    public List<StockBillItemPO> getItemPOS() {
        return itemPOS;
    }

    public String getInit_time() {
        return init_time;
    }

    public String getCommit_time() {
        return commit_time;
    }

    public String getApproval_time() {
        return approval_time;
    }

    public String getCommentByStockManager() {
        return commentByStockManager;
    }

    public String getCommentByManager() {
        return commentByManager;
    }

    public String getInitID() {
        return initID;
    }

    public String getApprovalID() {
        return approvalID;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setItemPOS(List<StockBillItemPO> itemPOS) {
        this.itemPOS = itemPOS;
    }

    public void setInit_time(String init_time) {
        this.init_time = init_time;
    }

    public void setCommit_time(String commit_time) {
        this.commit_time = commit_time;
    }

    public void setApproval_time(String approval_time) {
        this.approval_time = approval_time;
    }

    public void setCommentByStockManager(String commentByStockManager) {
        this.commentByStockManager = commentByStockManager;
    }

    public void setCommentByManager(String commentByManager) {
        this.commentByManager = commentByManager;
    }

    public void setInitID(String initID) {
        this.initID = initID;
    }

    public void setApprovalID(String approvalID) {
        this.approvalID = approvalID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
