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

    public static void main(String[] args) {
        System.out.println(BillStatus.values()[0].ordinal());

    }

    /**
     * Returns the name of this enum constant, as contained in the
     * declaration.  This method may be overridden, though it typically
     * isn't necessary or desirable.  An enum type should override this
     * method when a more "programmer-friendly" string form exists.
     *
     * @return the name of this enum constant
     */
    @Override
    public String toString() {
        switch (this) {
            case rejected:
                return "rejected";
            case approval:
                return "approval";
            case commit:
                return "commit";
            case init:
                return "init";
        }
        return super.toString();
    }

}
