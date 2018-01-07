package exception.dataexception;

import exception.dataexception.DataException;

/**
 * Created by thinkpad on 2018/1/7.
 */
public class IntOverFlowException extends Exception {
    /*
       溢出后的输出结果
     */
    private int overFlow;
    public IntOverFlowException(int overFlow){
        this.overFlow = overFlow;
    }

    public int getOverFlow(){
        return overFlow;
    }

    @Override
    public String toString(){
        return "溢出后的int数据结果为:  "+overFlow;
    }
}
