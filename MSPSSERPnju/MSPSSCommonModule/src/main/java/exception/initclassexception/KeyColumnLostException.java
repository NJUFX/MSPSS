package exception.initclassexception;

/**
 * Created by thinkpad on 2018/1/7.
 */

/**
 *  类中关键数据的名称信息丢失
 */
public class KeyColumnLostException extends InitClassException{

    String columnName;

    public KeyColumnLostException(String message){
        this.columnName = message;
    }

}
