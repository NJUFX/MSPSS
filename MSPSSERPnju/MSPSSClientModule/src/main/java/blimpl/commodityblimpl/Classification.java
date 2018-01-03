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
        classificationVO.setID(classificationVO.getName());
        ClassificationPO po = vo_to_po(classificationVO);
         return netService.addClassification(po);
    }

    /**
     * 删除一个分类
     * @param id
     * @return
     */
    public ResultMessage deleteClassification(String id){

      return netService.deleteClassification(id);
    }

    /**
     * 更新一个分类
     * @param classificationVO
     * @return
     */
    public ResultMessage updateClassification(ClassificationVO classificationVO){
        ClassificationPO po = vo_to_po(classificationVO);
        return netService.updateClassification(po);
    }

    /**
     * 通过id查询一个分类
     * @param id
     * @return
     */
    public ClassificationVO getClassification(String id){
        ClassificationPO po = netService.getClassification(id);
        return po_to_vo(po);
    }


    /**
     * 查询一个分类的子分类
     * @return
     */
    public ArrayList<ClassificationVO> searchChildren(ClassificationVO parentVO) {
        ArrayList<ClassificationVO> vos = new ArrayList<>();
        ArrayList<ClassificationPO> pos = netService.fullSearchClassificationPO("parentID",parentVO.getID());
        for (int i = 0 ; i < pos.size() ;i++){
            ClassificationVO vo = po_to_vo(pos.get(i),parentVO);
            vos.add(vo);
        }
        return vos;

    }
    /**
     *
     * @return
     */
    public ArrayList<ClassificationVO> getRootClassifications(){
        ArrayList<ClassificationVO> vos = new ArrayList<>();
       ArrayList<ClassificationPO> pos = netService.fullSearchClassificationPO("parentID","null");
       for (int i = 0 ; i < pos.size() ;i++){
           ClassificationVO vo = po_to_vo(pos.get(i));
           vos.add(vo);
       }
       return vos;
    }

    private ClassificationVO po_to_vo(ClassificationPO po){
            ClassificationVO vo = new ClassificationVO(po.getName(),po.getID());
            vo.setLeaf(po.getLeafNode());
      return vo;
    }
    private ClassificationVO po_to_vo(ClassificationPO po,ClassificationVO parent){
        ClassificationVO vo = new ClassificationVO(po.getName(),po.getID(),parent,po.getLeafNode());
        return vo;
    }
    private ClassificationPO vo_to_po(ClassificationVO vo){
        ClassificationPO po;
        if (vo.parent!=null)
        po = new ClassificationPO(vo.getName(),vo.getID(),vo.getParent().getID(),vo.isLeaf());
        else
        po = new ClassificationPO(vo.getName(),vo.getID(),"null",vo.isLeaf())   ;
        return po;
    }

}
