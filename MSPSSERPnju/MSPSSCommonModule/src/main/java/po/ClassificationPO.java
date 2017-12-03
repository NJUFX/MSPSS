package po;

import java.util.ArrayList;

/**
 * @Project_Name ERPnju
 * @Author: HanXinHu
 * @Description:
 * @Date Created in 19:05 2017/11/6/006
 */
public class ClassificationPO {
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
    ArrayList<String> childrenID;
    /**
     * 位于该分类下的节点
     */
    ArrayList<String> commodityIDs;

    /**
     * 判断是否为叶节点
     */
    Boolean isLeafNode;

    public ClassificationPO() {
    }

    public ClassificationPO(String name, String ID, String parentID, ArrayList<String> childrenID, ArrayList<String> commodityIDs, Boolean isLeafNode) {
        this.name = name;
        this.ID = ID;
        this.parentID = parentID;
        this.childrenID = childrenID;
        this.commodityIDs = commodityIDs;
        this.isLeafNode = isLeafNode;
    }


    //getter and setter 方法

    public Boolean getLeafNode() {
        return isLeafNode;
    }

    public void setLeafNode(Boolean leafNode) {
        isLeafNode = leafNode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public ArrayList<String> getChildrenID() {
        return childrenID;
    }

    public void setChildrenID(ArrayList<String> childrenID) {
        this.childrenID = childrenID;
    }

    public void setCommodityIDs(ArrayList<String> commodityIDs) {
        this.commodityIDs = commodityIDs;
    }

    public ArrayList<String> getCommodityIDs() {
        return commodityIDs;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public String getParentID() {
        return parentID;
    }
}
