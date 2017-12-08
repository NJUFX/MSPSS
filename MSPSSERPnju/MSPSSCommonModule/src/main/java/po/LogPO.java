package po;

import java.io.Serializable;

/**
 * updated by hanxinhu at 2017-12-08
 */
public class LogPO implements Serializable {
    /**
     * 日志信息的编号
     */
    private String id;
    /**
     * 日志信息的产生者
     */
    private String operator;
    /**
     * 日志信息产生的时间
     */
    private String time;
    /**
     * 日志记录的具体操作
     */
    private String operate;


    public LogPO(String id, String operator, String time,String operate ) {
        this.id = id;
        this.operator = operator;
        this.time = time;
        this.operate = operate;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
