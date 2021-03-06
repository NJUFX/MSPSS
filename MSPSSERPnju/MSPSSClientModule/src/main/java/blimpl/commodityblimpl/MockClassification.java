package blimpl.commodityblimpl;

import util.ResultMessage;
import vo.ClassificationVO;
import vo.FilterFlagVO;

import java.util.ArrayList;

/**
 * Description:
 * Created by Hanxinhu at 21:46 2017/11/21/021
 */
public class MockClassification  extends Classification{
    @Override
    public ResultMessage addClassification(ClassificationVO classificationVO) {
        System.out.println("add classificationName");
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage deleteClassification(String id) {
        System.out.println("");
        return super.deleteClassification(id);
    }

    @Override
    public ResultMessage updateClassification(ClassificationVO classificationVO) {
        return super.updateClassification(classificationVO);
    }

    @Override
    public ClassificationVO getClassification(String id) {
        return super.getClassification(id);
    }




}
