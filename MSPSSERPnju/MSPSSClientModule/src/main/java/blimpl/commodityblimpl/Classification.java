package blimpl.commodityblimpl;


import network.CommodityClientNetworkService;
import po.ClassificationPO;
import po.CommodityPO;
import util.ResultMessage;
import vo.ClassificationVO;
import vo.CommodityVO;
import vo.FilterFlagVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 23:14 2017/11/15/015
 */
public class Classification {
    /**
     * 增加一个新的分类
     * @param classificationVO
     * @return
     */
    CommodityClientNetworkService netService;

    public ResultMessage addClassification(ClassificationVO classificationVO){
        ArrayList<String> children = new ArrayList<>();
        for (ClassificationVO vo: classificationVO.children) {
            children.add(vo.ID);
        }
        ArrayList<String> commodityIDs = new ArrayList<>();
        for (CommodityVO vo : classificationVO.commodityVOS){
            commodityIDs.add(vo.ID);
        }
        ClassificationPO po = new ClassificationPO(classificationVO.name,classificationVO.ID,classificationVO.parent.ID,children,commodityIDs);
        return netService.addClassification(po);
    }

    /**
     * 删除一个分类
     * @param id
     * @return
     */
    public ResultMessage deleteClassification(String id){
        ClassificationPO po = netService.getClassification(id);
        //验证该分类下是否有子节点
        if (po.getChildrenID()==null||po.getChildrenID().size()==0)
            return ResultMessage.FAILED;
        //验证该分类下是否有商品
        if (po.getCommodityIDs()==null||po.getCommodityIDs().size()==0)
            return ResultMessage.FAILED;
        return netService.deleteClassification(id);
    }

    /**
     * 更新一个分类
     * @param classificationVO
     * @return
     */
    public ResultMessage updateClassification(ClassificationVO classificationVO){
        ArrayList<String> children = new ArrayList<>();
        for (ClassificationVO vo: classificationVO.children) {
            children.add(vo.ID);
        }
        ArrayList<String> commodityIDs = new ArrayList<>();
        for (CommodityVO vo : classificationVO.commodityVOS){
            commodityIDs.add(vo.ID);
        }
        ClassificationPO po = new ClassificationPO(classificationVO.name,classificationVO.ID,classificationVO.parent.ID,children,commodityIDs);
        return netService.modifyClassification(po);
    }

    /**
     * 通过id查询一个分类
     * @param id
     * @return
     */
    public ClassificationVO getClassification(String id){
        ClassificationPO po = netService.getClassification(id);

        return PO_To_VO(po);
    }

    public ArrayList<ClassificationVO> searchClassification(FilterFlagVO flag){
        return null;
    }

    /**
     * 查询一个分类的子分类
     * @return
     */
    public ArrayList<ClassificationVO> searchChildren(ClassificationVO vo){

        return vo.children;
    }

    /**
     *
     * @return
     */
    public ArrayList<ClassificationVO> getAllClassification(){
        return null;
    }

    private ClassificationVO PO_To_VO(ClassificationPO po){

        ClassificationVO classificationVO = new ClassificationVO(po.getName());
        if (po.getChildrenID()!=null&&po.getChildrenID().size()>0);
        for (String i : po.getChildrenID()){
            classificationVO.children.add(PO_To_VO(netService.getClassification(i)));
        }
        if (po.getCommodityIDs()!=null&&po.getCommodityIDs().size()>0)
            for (String id : po.getCommodityIDs()){
                CommodityPO commodityPO = netService.exactlySearchCommodity(id);
                CommodityVO vo = new CommodityVO(commodityPO.getName(),commodityPO.getID(),commodityPO.getType(),commodityPO.getImportCost(),commodityPO.getExportCost(),
                        commodityPO.getNumberInStock());
                classificationVO.commodityVOS.add(vo);
            }
        return classificationVO;
    }
}
