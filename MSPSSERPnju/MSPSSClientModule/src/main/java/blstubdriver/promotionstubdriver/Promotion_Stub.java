package blstubdriver.promotionstubdriver;

import blservice.promotionblservice.PromotionBLService;
import util.ResultMessage;
import util.Time;
import vo.*;

import java.util.ArrayList;

class Promotion_Stub implements PromotionBLService{
    private static final CommodityVO commodity1 = new CommodityVO("LED灯","12138","IEEE-0001",10,10,100);
    private static final CommodityVO commodity2 = new CommodityVO("LED灯","12138","IEEE-0002",10,11,110);
    private static final CommodityVO commodity3 = new CommodityVO("LED灯","12138","IEEE-0003",10,12,120);
    private static final CommodityVO commodity4 = new CommodityVO("LED灯","12138","IEEE-0004",10,13,130);
    private static final CommodityVO commodity5 = new CommodityVO("LED灯","12138","IEEE-0005",10,14,140);
    private static final CommodityVO commodity6 = new CommodityVO("LED灯","12138","IEEE-0006",10,15,150);
    private static final CommodityVO commodity7 = new CommodityVO("LED灯","12138","IEEE-0007",10,16,160);
    private static final CommodityVO commodity8 = new CommodityVO("LED灯","12138","IEEE-0008",10,17,170);
    private static final CommodityVO commodity9 = new CommodityVO("LED灯","12138","IEEE-0009",10,18,180);

    public Promotion_Stub() {
        super();
    }

    /**
     * 增加针对客户的促销策略
     *
     * @param promotionVO
     * @return
     */
    @Override
    public ResultMessage addCustomerPromotion(CustomerPromotionVO promotionVO) {
        return ResultMessage.SUCCESS;
    }

    /**
     * 更改针对客户的促销策略
     *
     * @param promotionVO
     * @return
     */
    @Override
    public ResultMessage updateCustomerPromotion(CustomerPromotionVO promotionVO) {
        return ResultMessage.SUCCESS;
    }

    /**
     * 删除客户的促销策略
     *
     * @param promotionVO
     * @return
     */
    @Override
    public ResultMessage deleteCustomerPromotion(CustomerPromotionVO promotionVO) {
        return ResultMessage.SUCCESS;
    }

    /**
     * 得到所有的客户促销策略
     *
     * @return
     */
    @Override
    public ArrayList<CustomerPromotionVO> getAllCustomerPromotion() {
        ArrayList<PresentationCommodityItemVO> list = new ArrayList<>();
        list.add(new PresentationCommodityItemVO(commodity1.ID,1));
        list.add(new PresentationCommodityItemVO(commodity2.ID,10));
        list.add(new PresentationCommodityItemVO(commodity3.ID,100));
        list.add(new PresentationCommodityItemVO(commodity4.ID,1000));
        list.add(new PresentationCommodityItemVO(commodity5.ID,10000));


        CustomerPromotionVO customerPromotionVO1 = new CustomerPromotionVO("1212",1,0,1000,new ArrayList<>(), Time.getInstance(),new Time(Time.MAX_TIME));
        CustomerPromotionVO customerPromotionVO2 = new CustomerPromotionVO("1211",1,2000,1000,new ArrayList<>(), Time.getInstance(),new Time(Time.MAX_TIME));
        CustomerPromotionVO customerPromotionVO3 = new CustomerPromotionVO("1211",1,2000,1000,list, Time.getInstance(),new Time(Time.MAX_TIME));
        ArrayList<CustomerPromotionVO> vos = new ArrayList<>();
        vos.add(customerPromotionVO1);
        vos.add(customerPromotionVO2);
        vos.add(customerPromotionVO3);
        return vos;
    }

    /**
     * 添加特价包促销策略
     *
     * @param groupPromotionVO
     * @return
     */
    @Override
    public ResultMessage addGroupPromotion(GroupPromotionVO groupPromotionVO) {
        return ResultMessage.SUCCESS;
    }

    /**
     * 更新特价包促销策略
     *
     * @param groupPromotionVO
     * @return
     */
    @Override
    public ResultMessage updateGroupPromotion(GroupPromotionVO groupPromotionVO) {
        return ResultMessage.SUCCESS;
    }

    /**
     * 删除特价包促销策略
     *
     * @param groupPromotionVO
     * @return
     */
    @Override
    public ResultMessage deleteGroupPromotion(GroupPromotionVO groupPromotionVO) {
        return ResultMessage.SUCCESS;
    }

    /**
     * 得到所有的特价包促销策略
     *
     * @return
     */
    @Override
    public ArrayList<GroupPromotionVO> getAllGroupPromotion() {
        ArrayList<String> s = new ArrayList<>();
        s.add("12123");
        s.add("11212");
        s.add("11111");
        GroupPromotionVO groupPromotionVO1 = new GroupPromotionVO("12138",0.8,s,new Time(),new Time());
        GroupPromotionVO groupPromotionVO2 = new GroupPromotionVO("22138",0.9,s,new Time(),new Time());
        GroupPromotionVO groupPromotionVO3 = new GroupPromotionVO("32138",0.75,s,new Time(),new Time());
        GroupPromotionVO groupPromotionVO4 = new GroupPromotionVO("42138",0.83,s,new Time(),new Time());
        GroupPromotionVO groupPromotionVO5 = new GroupPromotionVO("52138",0.81,s,new Time(),new Time());
        ArrayList<GroupPromotionVO> vos = new ArrayList<>();
        vos.add(groupPromotionVO1);
        vos.add(groupPromotionVO2);
        vos.add(groupPromotionVO3);
        vos.add(groupPromotionVO4);
        vos.add(groupPromotionVO5);
        return vos;
    }

    /**
     * 添加满减特价包促销策略
     *
     * @param grossPromotionVO
     * @return
     */
    @Override
    public ResultMessage addGrossPromotion(GrossPromotionVO grossPromotionVO) {
        return ResultMessage.SUCCESS;

    }

    /**
     * 更新满减促销策略
     *
     * @param grossPromotionVO
     * @return
     */
    @Override
    public ResultMessage updateGrossPromotion(GrossPromotionVO grossPromotionVO) {
        return ResultMessage.SUCCESS;

    }

    /**
     * 删除满减策略
     *
     * @param grossPromotionVO
     * @return
     */
    @Override
    public ResultMessage deleteGrossPromotion(GrossPromotionVO grossPromotionVO) {
        return ResultMessage.SUCCESS;

    }

    /**
     * 得到所有的满减策略
     *
     * @return
     */
    @Override
    public ArrayList<GrossPromotionVO> getAllGrossPromotion() {
        ArrayList<GrossPromotionVO> grossPromotionVOS = new ArrayList<>();
        ArrayList<PresentationCommodityItemVO> list = new ArrayList<>();
        list.add(new PresentationCommodityItemVO(commodity1.ID,1));
        list.add(new PresentationCommodityItemVO(commodity2.ID,10));
        list.add(new PresentationCommodityItemVO(commodity3.ID,100));
        list.add(new PresentationCommodityItemVO(commodity4.ID,1000));
        list.add(new PresentationCommodityItemVO(commodity5.ID,10000));
        grossPromotionVOS.add(new GrossPromotionVO("1",10000,210,list,new Time(),new Time()));
        grossPromotionVOS.add(new GrossPromotionVO("2",10000,2100,new
                ArrayList<>(),new Time(),new Time()));
        grossPromotionVOS.add(new GrossPromotionVO("3",1000000,200,list,new Time(),new Time()));
        grossPromotionVOS.add(new GrossPromotionVO("4",100001,100,new ArrayList<>(),new Time(),new Time()));
        grossPromotionVOS.add(new GrossPromotionVO("5",100002,2000,list,new Time(),new Time()));
        grossPromotionVOS.add(new GrossPromotionVO("6",100003,2100,list,new Time(),new Time()));
        return grossPromotionVOS;
    }
}