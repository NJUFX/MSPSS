package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project_Name ERPnju
 * @Author: HanXinHu
 * @Description:
 * @Date Created in 19:05 2017/11/6/006
 */
public class ClassificationPO implements Serializable {
    /**
     * 商品分类名称
     */
    private String  name;
    /**
     * 商品分类ID
     */
   private String ID;
    /**
     * 父分类的ID
      */
     private String parentID;

    /**
     * 子分类的ID
     */
    List<Classification_Children_PO> childrenID;
    /**
     * 位于该分类下的节点
     */
    List<Classification_Commodity_PO> commodityIDs;

    /**
     * 判断是否为叶节点
     */
    Boolean LeafNode;

    public ClassificationPO() {
    }

    public ClassificationPO(String name, String ID, String parentID, List<Classification_Children_PO> childrenID, List<Classification_Commodity_PO> commodityIDs, Boolean leafNode) {
        this.name = name;
        this.ID = ID;
        this.parentID = parentID;
        this.childrenID = childrenID;
        this.commodityIDs = commodityIDs;
        LeafNode = leafNode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public List<Classification_Children_PO> getChildrenID() {
        return childrenID;
    }

    public void setChildrenID(List<Classification_Children_PO> childrenID) {
        this.childrenID = childrenID;
    }

    public List<Classification_Commodity_PO> getCommodityIDs() {
        return commodityIDs;
    }

    public void setCommodityIDs(List<Classification_Commodity_PO> commodityIDs) {
        this.commodityIDs = commodityIDs;
    }

    public Boolean getLeafNode() {
        return LeafNode;
    }

    public void setLeafNode(Boolean leafNode) {
        LeafNode = leafNode;
    }
}
