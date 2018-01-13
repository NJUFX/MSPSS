package vo;

import util.BillStatus;
import util.SalesInBillType;
import util.Time;

import java.util.ArrayList;

/**
 * Description: 进货类单据
 * Created by Hanxinhu at 8:40 2017/11/22/022
 */
public class SalesInBillVO {
    /**
     * 进货类单据的单据编号
     * 进货单格式为（格式为：JHD-yyyyMMdd-xxxxx，后五位每天从1开始编号，所以一天最多可以生成99999条单子）
     * 进货退货单格式为（格式为：JHDTH-yyyyMMdd-xxxxx）
     */
    public String ID;
    /**
     * 默认业务员
     */
    public String DAE;
    /**
     * 供应商
     */
    public String provider;
    /**
     * 仓库
     */
    public String storage;

    /**
     * 进货类单据的类型（进货单还是进货退货单）
     */
    public SalesInBillType type;
    /**
     * 操作员（即产生订单的人）
     */
    public UserVO operator;
    /**
     * 备注
     */
    public String ps;

    /**
     * 总额共计
     */
    public double sumMoney;

    /**
     * 入库商品列表
     */
    public ArrayList<SalesItemVO> itemVOS;
    /**
     * 单据状态
     */
    public BillStatus status;

    /**
     * 单据的创建时间
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
     * 经理的审批评论
     */
    public String commentByManager;

    /**
     * 审批的总经理
     */

    public UserVO manager;

    public SalesInBillVO(String ID, String DAE, String provider, String storage, String ps, double sumMoney, String commentByManager) {
        this.ID = ID;
        this.DAE = DAE;
        this.provider = provider;
        this.storage = storage;
        this.ps = ps;
        this.sumMoney = sumMoney;
        this.commentByManager = commentByManager;
    }


    public SalesInBillVO(String id, SalesInBillType type, BillStatus status) {
        this.ID = id;
        this.type = type;
        this.status = status;
    }

    public SalesInBillVO(String ID, Time init_time, String provider, String storage, UserVO operator,
                         ArrayList<SalesItemVO> itemVOS, String ps) {
        this.ID = ID;
        this.provider = provider;
        this.storage = storage;
        this.operator = operator;
        this.itemVOS = itemVOS;
        this.ps = ps;
        this.init_time = init_time;

    }

    public SalesInBillVO(String ID, String DAE, String provider, String storage, SalesInBillType type, UserVO operator, String ps, double sumMoney, ArrayList<SalesItemVO> itemVOS, BillStatus status, Time init_time, Time commit_time) {
        this.ID = ID;
        this.DAE = DAE;
        this.provider = provider;
        this.storage = storage;
        this.type = type;
        this.operator = operator;
        this.ps = ps;
        this.sumMoney = sumMoney;
        this.itemVOS = itemVOS;
        this.status = status;
        this.init_time = init_time;
        this.commit_time = commit_time;
    }

    public SalesInBillVO(String ID, String DAE, String provider, String storage, SalesInBillType type, UserVO operator, String ps, double sumMoney, ArrayList<SalesItemVO> itemVOS, BillStatus status, Time init_time, Time commit_time, Time approval_time, String commentByManager, UserVO manager) {
        this.ID = ID;
        this.DAE = DAE;
        this.provider = provider;
        this.storage = storage;
        this.type = type;
        this.operator = operator;
        this.ps = ps;
        this.sumMoney = sumMoney;
        this.itemVOS = itemVOS;
        this.status = status;
        this.init_time = init_time;
        this.commit_time = commit_time;
        this.approval_time = approval_time;
        this.commentByManager = commentByManager;
        this.manager = manager;
    }

    public UserVO getManager() {
        return manager;
    }

    public void setManager(UserVO manager) {
        this.manager = manager;
    }

    public void setCommentByManager(String commentByManager) {
        this.commentByManager = commentByManager;
    }

    public String getCommentByManager() {
        return commentByManager;
    }

    public void setApproval_time(Time approval_time) {
        this.approval_time = approval_time;
    }

    public Time getApproval_time() {
        return approval_time;
    }

    public void setType(SalesInBillType type) {
        this.type = type;
    }

    public SalesInBillType getType() {
        return type;
    }

    public void setCommit_time(Time commit_time) {
        this.commit_time = commit_time;
    }

    public Time getCommit_time() {
        return commit_time;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setInit_time(Time init_time) {
        this.init_time = init_time;
    }

    public Time getInit_time() {
        return init_time;
    }

    public void setItemVOS(ArrayList<SalesItemVO> itemVOS) {
        this.itemVOS = itemVOS;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ArrayList<SalesItemVO> getItemVOS() {
        return itemVOS;
    }

    public void setDAE(String DAE) {
        this.DAE = DAE;
    }

    public double getSumMoney() {
        return sumMoney;
    }

    public void setOperator(UserVO operator) {
        this.operator = operator;
    }

    public String getDAE() {
        return DAE;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProvider() {
        return provider;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getPs() {
        return ps;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getStorage() {
        return storage;
    }

    public void setSumMoney(double sumMoney) {
        this.sumMoney = sumMoney;
    }

    public UserVO getOperator() {
        return operator;
    }


}
