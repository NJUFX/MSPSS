package  util;

import java.io.Serializable;

public enum ResultMessage implements Serializable{
    SUCCESS, // 成功
    FAILED, // 失败
    WRONG, // 错误
    EXIST, // 已存在
    NOT_EXIST, // 不存在
    TOO_LONG, // 输入过长
    TOO_SHORT, // 输入过短
    INVALID, // 含有非法字符
    NULL, // 输入为空
    TRUE,//判断为真
    FALSE;//判断为假


    public String toString() {
        switch (this) {
            case SUCCESS:
                return "成功";
            case FAILED:
                return "失败";
            case WRONG:
                return "错误";
            case EXIST:
                return "已存在";
            case NOT_EXIST:
                return "不存在";
            case TOO_LONG:
                return "输入过长";
            case TOO_SHORT:
                return "输入过短";
            case INVALID:
                return "含有非法字符";
            case NULL:
                return "输入为空";

            case TRUE:
                return "真";
            case FALSE:
                return "假";
            default:
                return null;
        }
    }

}
