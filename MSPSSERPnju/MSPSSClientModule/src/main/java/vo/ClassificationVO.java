package VO;

public class ClassificationVO {
    /**
     * 分类的ID
     */
    String ID;
    /**
     * 分类节点的父ID
     */
    String parentID;
    /**
     *  分类的名称
     */
    String name;

    public ClassificationVO(String ID,String parentID,String name){
        this.ID = ID;
        this.parentID = parentID;
        this.name = name;
    }
    public ClassificationVO(String ID,String name){
        this(ID,null,name);
    }
    @Override
    public String toString() {
        if (parentID == null){
            return "编号为 "+ID+"分类名称为 "+name;
        }
        return "编号为 "+ID+"分类名称为 "+name + "父类编号为 "+parentID;

    }
}
