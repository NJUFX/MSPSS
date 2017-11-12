package vo;

import java.util.ArrayList;

public class AlarmBillVO {
    /**
     * 库存报警的商品
     */
    CommodityVO commodityVO;

    /**
     * 库存报警的商品的当前库存
     */
    int number;
   public AlarmBillVO(CommodityVO commodityVO,int number){
        this.commodityVO = commodityVO;
        this.number = number;
    }

    @Override
    public String toString() {
        return "库存报警商品名为 "+commodityVO.name+" 类型为 "+commodityVO.type+" 当前库存量为 "+number;
    }
}
