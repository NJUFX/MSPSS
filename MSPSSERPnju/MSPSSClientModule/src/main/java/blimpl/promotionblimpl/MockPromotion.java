
//package blimpl.promotionblimpl;
//
//import po.PromotionPO;
//import util.ResultMessage;
//import util.Time;
//import vo.PromotionListVO;
//import vo.PromotionVO;
//
//import java.util.ArrayList;
//
//public class MockPromotion extends Promotion{
//
//    /**
//     * 增加一条促销策略
//     *
//     * @param promotionVO
//     * @return ResultMessage
//     */
//    public ResultMessage add(PromotionVO promotionVO){
//        PromotionPO promotionPO = new PromotionPO(promotionVO.getId(),promotionVO.getType(),promotionVO.getInfoList(),promotionVO.getTime());
//        promotionlist.add(promotionPO);
//        return ResultMessage.SUCCESS;
//    }
//
//    /**
//     * 删除一条促销策略
//     *
//     * @param id
//     * @return ResultMessage
//     */
//    public ResultMessage delete(String id){
//        for(int i=0;i<promotionlist.size();i++){
//            if(promotionlist.get(i).getId().equals(id)){
//                promotionlist.remove(i);
//            }
//        }
//        return ResultMessage.SUCCESS;
//    }
//
//    /**
//     * 更新一条促销策略
//     *
//     * @param id
//     * @param promotionVO
//     * @return ResultMessage
//     */
//    public ResultMessage update(String id,PromotionVO promotionVO){
//        PromotionPO promotionPO = new PromotionPO(promotionVO.getId(),promotionVO.getType(),promotionVO.getInfoList(),promotionVO.getTime());
//      for(int i=0;i<promotionlist.size();i++){
//          if(promotionlist.get(i).getId().equals(id)){
//              promotionlist.remove(i);
//              promotionlist.add(i,promotionPO);
//          }
//      }
//        return ResultMessage.SUCCESS;
//    }
//
//    /**
//     * 搜索所有有效的促销策略
//     *
//     * @param date
//     * @return ArrayList<PromotionPO>
//     */
//    public ArrayList<PromotionPO> timeSearchLog(Time date){
//        ArrayList<PromotionPO>result = new ArrayList<PromotionPO>();
//        for(int i=0;i<promotionlist.size();i++){
//            if(promotionlist.get(i).getTime().getYear()==date.getYear()&&promotionlist.get(i).getTime().getMonth()==date.getMonth()&&promotionlist.get(i).getTime().getDay()==date.getDay()){
//                result.add(promotionlist.get(i));
//            }
//        }
//        return result;
//    }
//
//    /**
//     * 显示促销策略列表
//     *
//     * @param promotionList
//     * @return PromotionListVO
//     */
//    public PromotionListVO showPromotionList(ArrayList<PromotionPO> promotionList){
//        ArrayList<PromotionVO> transArray  = new ArrayList<PromotionVO>();
//        for(int i=0;i<promotionList.size();i++){
//            PromotionVO temp = new PromotionVO(promotionList.get(i).getId(),promotionList.get(i).getType(),promotionList.get(i).getInfoList(),promotionList.get(i).getTime());
//            transArray.add(temp);
//        }
//        PromotionListVO result = new PromotionListVO(transArray);
//        return result;
//    }
//
//    /**
//     * 显示促销策略详情
//     *
//     * @param id
//     * @return PromotionVO
//     */
//    public PromotionVO showPromotionDetail(String id){
//        for(int i=0;i<promotionlist.size();i++){
//            if(promotionlist.get(i).getId().equals(id)){
//                PromotionVO result = new PromotionVO(promotionlist.get(i).getId(),promotionlist.get(i).getType(),promotionlist.get(i).getInfoList(),promotionlist.get(i).getTime());
//            return result;
//            }
//        }
//        return null;
//    }
//}

package blimpl.promotionblimpl;

import po.PromotionPO;
import util.ResultMessage;
import util.Time;
import vo.PromotionListVO;
import vo.PromotionVO;

import java.util.ArrayList;

public class MockPromotion extends Promotion{

    /**
     * 增加一条促销策略
     *
     * @param promotionVO
     * @return ResultMessage
     */
    public ResultMessage add(PromotionVO promotionVO){
        PromotionPO promotionPO = new PromotionPO();
        promotionlist.add(promotionPO);
        return ResultMessage.SUCCESS;
    }

    /**
     * 删除一条促销策略
     *
     * @param id
     * @return ResultMessage
     */
    public ResultMessage delete(String id){
        for(int i=0;i<promotionlist.size();i++){
            if(promotionlist.get(i)!=null){
                promotionlist.remove(i);
            }
        }
        return ResultMessage.SUCCESS;
    }

    /**
     * 更新一条促销策略
     *
     * @param id
     * @param promotionVO
     * @return ResultMessage
     */
    public ResultMessage update(String id,PromotionVO promotionVO){
        PromotionPO promotionPO = new PromotionPO();
      for(int i=0;i<promotionlist.size();i++){
          if(promotionlist.get(i)!=null){
              promotionlist.remove(i);
              promotionlist.add(i,promotionPO);
          }
      }
        return ResultMessage.SUCCESS;
    }

    /**
     * 搜索所有有效的促销策略
     *
     * @param date
     * @return ArrayList<PromotionPO>
     */
    public ArrayList<PromotionPO> search(Time date){
        ArrayList<PromotionPO>result = new ArrayList<PromotionPO>();
        for(int i=0;i<promotionlist.size();i++){
             result.add(promotionlist.get(i));
            
        }
        return result;
    }

    /**
     * 显示促销策略列表
     *
     * @param promotionList
     * @return PromotionListVO
     */
    public PromotionListVO showPromotionList(ArrayList<PromotionPO> promotionList){
        ArrayList<PromotionVO> transArray  = new ArrayList<PromotionVO>();
        String[] info = {};
        for(int i=0;i<promotionList.size();i++){
            PromotionVO temp = new PromotionVO("000001","分级赠送赠品",info,new Time(2017,10,04,11,23,22));
            transArray.add(temp);
        }
        PromotionListVO result = new PromotionListVO(transArray);
        return result;
    }

    /**
     * 显示促销策略详情
     *
     * @param id
     * @return PromotionVO
     */
    public PromotionVO showPromotionDetail(String id){
    	String[] info = {};
        for(int i=0;i<promotionlist.size();i++){
            if(promotionlist.get(i)!=null){
                PromotionVO result = new PromotionVO("000001","分级赠送赠品",info,new Time(2017,10,04,11,23,22));
            return result;
            }
        }
        return null;
    }
}

