package exception.classificationexception;

/**
 * Created by thinkpad on 2018/1/7.
 */

/**
 * 商品分类过多报出的异常
 */
public class ClassificationOverFlowException extends Exception {
    String problem = "商品分类过多，不符合公司需求，请更换分类";
    @Override
    public String toString(){
        return problem;
    }
}
