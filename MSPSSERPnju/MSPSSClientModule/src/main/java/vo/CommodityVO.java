package VO;

public class CommodityVO {
    public CommodityVO(String name,String type,String ID,double importcost,double exportcost){
        this.name = name;
        this.type = type;
        this.ID = ID;
        this.importcost = importcost;
        this.exportcost = exportcost;
    }
    String name;
    String type;
    String ID;
    double importcost;
    double exportcost;

    @Override
    public String toString() {
        return "商品名为"+name+" 商品类型为 "+type+" 商品编号为 "+ID+" 进价为 "+importcost+" 售价为 "+exportcost;
    }
}
