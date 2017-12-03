package po;

public class LogPO {
    private String id;
    private String operator;
    private String time;
    private int kind;


    public LogPO(String id, String operator, String time, int kind) {
        this.id = id;
        this.operator = operator;
        this.time = time;
        this.kind = kind;
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

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }
}
