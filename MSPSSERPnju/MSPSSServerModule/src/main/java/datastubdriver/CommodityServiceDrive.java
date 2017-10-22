package java.dataservicestubdrive;

import util.CommodityPO;
import util.ResultMessage;

import java.dataservice.CommodityDataService;

public class CommodityServiceDrive  {
    public static void main(String[] args) {
        CommodityDataService c = new CommodityServiceStub();
        System.out.println(c.AddClassification());
        System.out.println(c.addCommodity(null));
        System.out.println(c.deleteCommodity(null));
        System.out.println(c.DeleteClaassification());
        System.out.println(c.modifyCommodity(null));
        System.out.println(c.ModifyClassification());
        System.out.println(c.searchCommodity());
    }

}
