package util;

/**
 * Description:数据库查询类型
 * Created by Hanxinhu at 16:57 2017/11/30/030
 */
public enum QueryMethod {
    Fuzz, Range, Full, Prefix;
    public boolean valueShouldBeString(){
        return this.equals(Fuzz) || this.equals(Prefix);
    }
}
