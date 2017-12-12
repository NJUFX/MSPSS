package vo;

import blimpl.commodityblimpl.Classification;

import java.util.ArrayList;

public class ClassificationVO {
    /**
     * 分类名称
     */
    public String name;
    /**
     * 分类编号
     */
    public  String ID;
    /**
     * 该分类的父分类
     */
    public ClassificationVO parent;
    /**
     * 是否是叶节点
     */
    boolean isLeaf;

    public ClassificationVO(){

    }
    public ClassificationVO(String name){
        this.name = name;
    }
    public ClassificationVO(String name,ClassificationVO parent){
        this.name = name;
        this.parent = parent;
    }

    public ClassificationVO(String name, String ID, ClassificationVO parent) {
        this.name = name;
        this.ID = ID;
        this.parent = parent;
    }

    public ClassificationVO(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    public ClassificationVO(String name, String ID, ClassificationVO parent, boolean isLeaf) {
        this.name = name;
        this.ID = ID;
        this.parent = parent;
        this.isLeaf = isLeaf;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setParent(ClassificationVO parent) {
        this.parent = parent;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public ClassificationVO getParent() {
        return parent;
    }
}
