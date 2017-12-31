package blimpl.userblimpl;

import network.UserClientNetworkImpl;
import network.UserClientNetworkService;
import po.UserPO;
import util.Kind_Of_Users;
import util.ResultMessage;
import vo.UserVO;

import java.util.ArrayList;

public class User {

    private UserClientNetworkService networkService = new UserClientNetworkImpl();


    /**
     * @param user
     * @return
     */
    public ResultMessage addUser(UserVO user) {
        if (user.getID()==null){

        }
        return ResultMessage.SUCCESS;
    }

    /**
     * 根据用户类型查找用户
     * sale finance    同时返回经理
     *
     * @param kind
     * @return
     */

    public ArrayList<UserVO> searchUserByKind(Kind_Of_Users kind) {
        int category = kind.getNumber();

        ArrayList<UserPO> pos = networkService.fullSearchUser("category", category);
        //如果查询类型是销售人员 则将销售经理也返回
        //如果查询类型是财务人员 则将财务经理也返回
        if (category == 2 || category == 4)
            pos.addAll(networkService.fullSearchUser("category", category + 1));
        ArrayList<UserVO> vos = pos_to_vos(pos);
        return vos;
    }
    /**
     * 删除用户
     *
     * @param userID 用户id
     * @return 删除用户的运行结果
     */
    public ResultMessage deleteUser(String userID) {

        return networkService.deleteUser(userID);
    }

    /**
     * @param userVO
     * @return
     */
    public ResultMessage updateUser(UserVO userVO) {
        UserPO po = vo_to_po(userVO);
        return networkService.updateUser(po);
    }

    /**
     * 根据用户的ID来查找
     *
     * @param ID
     * @return
     */

    public UserVO searchUserByID(String ID) {
        UserPO po = networkService.searchUserByID(ID);
        return po_to_vo(po);
    }

    private UserVO po_to_vo(UserPO po) {
        UserVO vo = new UserVO(po.getID(), po.getName(), po.getKind(), po.getPassword());
        return vo;
    }

    private UserPO vo_to_po(UserVO vo) {
        UserPO po = new UserPO(vo.getID(), vo.getName(), vo.getCategoryForPO(), vo.getPassword());
        return po;
    }

    private ArrayList<UserVO> pos_to_vos(ArrayList<UserPO> pos) {
        ArrayList<UserVO> vos = new ArrayList<>();
        for (UserPO po : pos) {
            vos.add(po_to_vo(po));
        }
        return vos;
    }
}
