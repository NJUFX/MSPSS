package util;

/**
 * Description:
 * Created by Hanxinhu at 20:27 2017/11/27/027
 */
public enum BillStatus {
    /**
     * 草稿状态
     */
    init,
    /**
     * 提交状态
     */
    commit,
    /**
     * 审批后完成
     */
    approval,
    /**
     * 拒绝通过
     */
    rejected;
}
