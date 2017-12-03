package util;

import java.io.Serializable;

/**
 * Description:
 * Created by Hanxinhu at 17:02 2017/11/30/030
 */
public interface CriteriaClause extends Serializable{
    /**
     * 得到字段名
     *
     * @return 字段名
     */
    public String getField();

    /**
     * 得到字段值
     *
     * @return 字段值
     */
    public Object getValue();

    /**
     * 得到另一字段名
     *
     * @return 另一字段名
     */
    public Object getAnotherValue();

    /**
     * 得到查询方法
     *
     * @return 查询方法
     */
    public QueryMethod getQueryMethod();


    /**
     * 得到关键字名
     *
     * @return 关键字名
     */
    public String getKeyWord();
}
