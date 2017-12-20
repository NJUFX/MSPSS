package vo;

public class AlarmBillVO {
    /**
     * 库存报警的商品
     */
    String commodityID;

    /**
     * 库存报警的商品的当前库存
     */
    int number;
   public AlarmBillVO(String commodityID, int number){
        this.commodityID = commodityID;
        this.number = number;
    }

    @Override
    public String toString() {
        return "库存报警商品编号为 "+ commodityID+" 当前库存量为 "+number;
    }
}
