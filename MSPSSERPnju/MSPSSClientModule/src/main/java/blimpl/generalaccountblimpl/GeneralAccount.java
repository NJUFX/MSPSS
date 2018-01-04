package blimpl.generalaccountblimpl;

import network.GeneralAccountClientNetworkImpl;
import network.GeneralAccountClientNetworkService;
import po.*;
import util.Kind_Of_Customers;
import util.ResultMessage;
import util.Time;
import vo.AccountVO;
import vo.CommodityVO;
import vo.CustomerVO;
import vo.GeneralAccountVO;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class GeneralAccount {
    private GeneralAccountClientNetworkService generalAccountClientNetworkService;

    protected GeneralAccount(){
        generalAccountClientNetworkService = new GeneralAccountClientNetworkImpl();
    }
    /**
     * 添加期初账户
     * @param
     * @return ResultMessage
     */
    public ResultMessage addGeneralAcocunt(GeneralAccountVO generalAccountVO){
        return generalAccountClientNetworkService.addGeneralAcocunt(vo_to_po(generalAccountVO));
    }


    /**
     * 精确查找商品
     * @param id
     * @return
     */
    public GeneralAccountVO exactlySearchGeneralAccount(String field,String id){
        return po_to_vo((generalAccountClientNetworkService.exactlySearchGeneralAccount(field, id)));
    }

    public ArrayList<GeneralAccountVO> fullSearchGeneralAccount(String field, Object value){
        ArrayList<GeneralAccountVO> generalAccountVOS = new ArrayList<GeneralAccountVO>();
        ArrayList<GeneralAccountPO> generalAccountPOS = generalAccountClientNetworkService.fullSearchGeneralAccount(field, value);
        for(int i=0;i<=generalAccountPOS.size()-1;i++){
            generalAccountVOS.add(po_to_vo(generalAccountPOS.get(i)));
        }

        return generalAccountVOS;
    }
    /**
     *
     * @param filed
     * @param value
     * @return
     */
    public ArrayList<GeneralAccountVO> fuzzySearchGeneralAccount(String filed,String value){
        ArrayList<GeneralAccountVO> generalAccountVOS = new ArrayList<>();
        ArrayList<GeneralAccountPO> generalAccountPOS = generalAccountClientNetworkService.fuzzySearchGeneralAccount(filed, value);
        for(int i=0;i<=generalAccountPOS.size()-1;i++){
            generalAccountVOS.add(po_to_vo(generalAccountPOS.get(i)));
        }

        return generalAccountVOS;
    }


    /**
     *
     * @param field
     * @param min
     * @param max
     * @return
     */
    public ArrayList<GeneralAccountVO> rangeSearchGeneralAccount(String field, Object min, Object max){
        ArrayList<GeneralAccountVO> generalAccountVOS = new ArrayList<GeneralAccountVO>();
        ArrayList<GeneralAccountPO> generalAccountPOS = generalAccountClientNetworkService.rangeSearchGeneralAccount(field, min,max);
        for(int i=0;i<=generalAccountPOS.size()-1;i++){
            generalAccountVOS.add(po_to_vo(generalAccountPOS.get(i)));
        }

        return generalAccountVOS;
    }

    /**
     * 在已有数据库中搜索客户
     * @param name
     * @return
     */
    public CustomerVO searchCustomer(String name){
       CustomerPO customerPO =  generalAccountClientNetworkService.searchCustomer(name);
       CustomerVO customerVO = new CustomerVO(String.format("%05d",customerPO.getID()),Kind_Of_Customers.values()[customerPO.getCategory()],customerPO.getLevel(), customerPO.getName(), customerPO.getPhonenumber(), customerPO.getAddress(), customerPO.getPostcode(), customerPO.getEmail(), customerPO.getInvalue(),customerPO.getIncomemoney(), customerPO.getPaymoney(), "期初建账");
       return customerVO;
    }

    /**
     * 在已有数据库中搜索商品
     * @param name
     * @return
     */
    public CommodityVO searchCommodity(String name){
        CommodityPO commodityPO = generalAccountClientNetworkService.searchCommodity(name);
        CommodityVO commodityVO = new CommodityVO(commodityPO.getName(), commodityPO.getClassificationID(), commodityPO.getType(), commodityPO.getID(), commodityPO.getImportCost(), commodityPO.getExportCost(), commodityPO.getLatestImportCost(), commodityPO.getLatestExportCost(), commodityPO.getNumberInStock(), commodityPO.getAlertNumber());
        return commodityVO;
    }


    private GeneralAccountPO vo_to_po(GeneralAccountVO generalAccountVO){
        GeneralAccountPO generalAccountPO = new GeneralAccountPO();
        for(int i=0;i<=generalAccountVO.getAccountlist().size()-1;i++){
            AccountVO accountVO= generalAccountVO.getAccountlist().get(i);
            //generalAccountPO.getAccountlist().add(new GeneralAccount_AccountList_PO(accountVO.getName(),accountVO.getMoney()));
        }

        for(int i=0;i<=generalAccountVO.getCustomerlist().size()-1;i++){
            CustomerVO customerVO= generalAccountVO.getCustomerlist().get(i);
            int numOfint = customerVO.getCategory().ordinal();
            //generalAccountPO.getCustomerlist().add(new GeneralAccount_CustomerList_PO(customerVO.getExist(),customerVO.getID(), numOfint,customerVO.getLevel(),customerVO.getName(),customerVO.getPhonenumber(),customerVO.getAddress(),customerVO.getPostcode(),customerVO.getEmail(),customerVO.getInvalue(),customerVO.getIncomemoney(),customerVO.getPaymoney()));
        }

        for(int i=0;i<=generalAccountVO.getCommoditylist().size()-1;i++){
            CommodityVO commodityVO = generalAccountVO.getCommoditylist().get(i);
            //generalAccountPO.getCommoditylist().add(new GeneralAccount_CommodityList_PO(commodityVO.getName(),commodityVO.getClassificationName(),commodityVO.getType(),commodityVO.getID(),commodityVO.getImportCost(),commodityVO.getExportCost(),commodityVO.getNumberInStock()));
        }

        generalAccountPO.setName(generalAccountVO.getName());
        generalAccountPO.setTime(generalAccountVO.getTime().toString());

        return generalAccountPO;

    }

    private GeneralAccountVO po_to_vo(GeneralAccountPO generalAccountPO){
        GeneralAccountVO generalAccountVO = new GeneralAccountVO();
        for(int i=0;i<=generalAccountPO.getAccountlist().size()-1;i++){
            GeneralAccount_AccountList_PO generalAccount_accountList_po= generalAccountPO.getAccountlist().get(i);
            generalAccountVO.getAccountlist().add(new AccountVO(generalAccount_accountList_po.getName(),generalAccount_accountList_po.getMoney(),new Time(generalAccountPO.getTime())));
        }

        for(int i=0;i<=generalAccountPO.getCustomerlist().size()-1;i++){
            GeneralAccount_CustomerList_PO generalAccount_customerList_po= generalAccountPO.getCustomerlist().get(i);
            generalAccountVO.getCustomerlist().add(new CustomerVO(String.format("%05d",generalAccount_customerList_po.getID()), Kind_Of_Customers.values()[generalAccount_customerList_po.getCategory()],generalAccount_customerList_po.getLevel(),generalAccount_customerList_po.getName(),generalAccount_customerList_po.getPhonenumber(),generalAccount_customerList_po.getAddress(),generalAccount_customerList_po.getPostcode(),generalAccount_customerList_po.getEmail(),generalAccount_customerList_po.getInvalue(),generalAccount_customerList_po.getIncomemoney(),generalAccount_customerList_po.getPaymoney(),"期初建账创建"));
        }

        for(int i=0;i<=generalAccountPO.getCommoditylist().size()-1;i++){
            GeneralAccount_CommodityList_PO generalAccount_commodityList_po  = generalAccountPO.getCommoditylist().get(i);
            generalAccountVO.getCommoditylist().add(new CommodityVO(generalAccount_commodityList_po.getName(),generalAccount_commodityList_po.getClassificationID(),generalAccount_commodityList_po.getType(),generalAccount_commodityList_po.getID(),generalAccount_commodityList_po.getImportCost(),generalAccount_commodityList_po.getExportCost(),generalAccount_commodityList_po.getNumberInStock()));
        }

        generalAccountVO.setName(generalAccountPO.getName());
        generalAccountVO.setTime(new Time(generalAccountPO.getTime()));

        return generalAccountVO;

    }

}
