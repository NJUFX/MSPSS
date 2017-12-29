package util;

import java.io.Serializable;

/**
 * Description:数据库查询类型
 * Created by Hanxinhu at 16:57 2017/11/30/030
 */
public enum QueryMethod implements Serializable {
    Fuzz, Range, Full, Prefix;
    public boolean valueShouldBeString(){
        return this.equals(Fuzz) || this.equals(Prefix);
    }
}
