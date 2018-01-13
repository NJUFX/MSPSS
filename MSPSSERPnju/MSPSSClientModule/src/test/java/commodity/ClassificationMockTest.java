package commodity;

import blimpl.commodityblimpl.Classification;
import blimpl.commodityblimpl.MockClassification;
import org.junit.Test;
import util.ResultMessage;
import vo.ClassificationVO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Description:
 * Created by Hanxinhu at 9:39 2017/11/22/022
 */
public class ClassificationMockTest {
    private Classification classification = new MockClassification();
    private ClassificationVO classificationVO = new ClassificationVO("", "");

    @Test
    public void a_add() {
        ResultMessage message = classification.addClassification(classificationVO);
        assertEquals(ResultMessage.SUCCESS, message);
    }

    @Test
    public void b_update() {
        ResultMessage message = classification.updateClassification(classificationVO);
        assertEquals(ResultMessage.SUCCESS, message);
    }

    @Test
    public void c_search() {
        ClassificationVO classificationVO = classification.getClassification("da");
        assertNotNull(classificationVO);
    }


}
