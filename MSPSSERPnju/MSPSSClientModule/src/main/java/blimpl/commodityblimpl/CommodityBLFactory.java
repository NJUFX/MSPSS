package blimpl.commodityblimpl;

import blservice.commodityblservice.CommodityBLService;
import blservice.commodityblservice.CommodityInfoService;

/**
 * Description:
 * Created by Hanxinhu at 23:20 2017/11/15/015
 */
public class CommodityBLFactory {
    private static Commodity commodity = new Commodity();
    private static Classification classification = new Classification();
    private static CommodityBLImpl impl;

    public static synchronized CommodityBLService getCommodityBLService() {
        if (impl == null) {
            impl = new CommodityBLImpl(commodity, classification);
        }
        return impl;
    }

    public static synchronized CommodityInfoService getCommodityBLInfo() {
        if (impl==null){
            impl = new CommodityBLImpl(commodity,classification);
        }
        return impl;
    }


}
