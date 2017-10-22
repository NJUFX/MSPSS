package vo;

import java.util.Date;

public class InventoryVO {
    /**
     * 商品的名称、型号，库存数量，库存均价，批次，批号，出厂日期
    */
    String name;
    String type;
    int number;
    double price;
    String pici;
    String pihao;
    Date exportDate;
    public InventoryVO(String name,String type,int number,double price,String pici,String pihao,Date exportDate){
        this.name = name;
        this.type = type;
        this.number = number;
        this.price = price;
        this.pici = pici;
        this.pihao = pihao;
        this.exportDate = exportDate;
    }
    @Override
    public String toString() {
        return "商品的名称: "+name+" 型号:"+type+" 库存数量: "+number+"库存均价:"+price
        +"批次: "+pici+"批号: " +"出厂日期: "+exportDate;
    }
};