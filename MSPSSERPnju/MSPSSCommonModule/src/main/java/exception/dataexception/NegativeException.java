package exception.dataexception;

/**
 * Created by thinkpad on 2018/1/7.
 */
public class NegativeException extends Exception {

    @Override
    public String toString(){
        return "正负值错误，应该为正";
    }

}
