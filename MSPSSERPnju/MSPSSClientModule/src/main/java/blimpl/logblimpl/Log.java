package blimpl.logblimpl;

import network.LogClientNetworkService;
import po.LogPO;
import util.*;
import vo.LogFilterVO;
import vo.LogListVO;
import vo.LogVO;

import java.util.ArrayList;

/**
 * Created by Harper on 17/11/21
 */
public class Log {
    LogClientNetworkService networkService;
    public ResultMessage add(LogVO logVO) {
        LogPO po = vo_to_po(logVO);
        return networkService.addLog(po);
    }

    public ArrayList<LogVO> operatorSearchLog(String operator) {
        ArrayList<LogPO> pos =  networkService.fullSearch("operator",operator);
        ArrayList<LogVO> vos = new ArrayList<>();
        for (int i = 0 ; i < pos.size() ; i++){
            LogVO vo = po_to_vo(pos.get(i));
            vos.add(vo);
        }
       return vos;
    }


    public ArrayList<LogVO> operateSearchLog(String operate) {
        ArrayList<LogPO> pos =  networkService.fullSearch("operate",operate);
        ArrayList<LogVO> vos = new ArrayList<>();
        for (int i = 0 ; i < pos.size() ; i++){
            LogVO vo = po_to_vo(pos.get(i));
            vos.add(vo);
        }
        return vos;
    }

    public ArrayList<LogVO> timeSearchLog(Time start, Time end) {
        ArrayList<LogPO> pos =  networkService.rangeSearch("time",start.toString(),end.toString());
        ArrayList<LogVO> vos = new ArrayList<>();
        for (int i = 0 ; i < pos.size() ; i++){
            LogVO vo = po_to_vo(pos.get(i));
            vos.add(vo);
        }
        return vos;
    }

    public ArrayList<LogVO> multiSearchLog(LogFilterVO filterVO){
        ArrayList<CriteriaClause> list = new ArrayList<>();
        if (filterVO.operator!=null){
            list.add(CriteriaClauseImpl.createSingleValueQuery("operator",filterVO.operator, QueryMethod.Full));
        }
        if (filterVO.operate!=null){
            list.add(CriteriaClauseImpl.createSingleValueQuery("operate",filterVO.operate,QueryMethod.Fuzz));
        }
        if (filterVO.endTime!=null&&filterVO.startTime!=null){
            list.add(CriteriaClauseImpl.createRangeValueQuery("time",filterVO.startTime.toString(),filterVO.endTime.toString(),QueryMethod.Range));
        }
        ArrayList<LogPO> pos = networkService.multiSearchLog(list);
        ArrayList<LogVO> vos = new ArrayList<>();
        for (int i = 0 ; i < pos.size() ; i++){
             vos.add(po_to_vo(pos.get(i)));
        }
        return vos;
    }
    private LogVO po_to_vo(LogPO logPO){
        LogVO vo = new LogVO(logPO.getId(),logPO.getOperator(),new Time(logPO.getTime()),logPO.getOperate());
        return vo;
    }
    private LogPO vo_to_po(LogVO logVO){
        LogPO po  = new LogPO(logVO.id,logVO.operator,logVO.time.toString(),logVO.operate);
        return po;
    }


}
