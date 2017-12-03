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
     * 该分类的子分类
     */
    public ArrayList<ClassificationVO> children;

    /**
     * 该分类下的商品
     */
    public ArrayList<CommodityVO> commodityVOS;

    public ClassificationVO(){

    }
    public ClassificationVO(String name){
        this.name = name;
    }
    public ClassificationVO(String name,ClassificationVO parent){
        this.name = name;
        this.parent = parent;
    }
    public ClassificationVO(String name, ClassificationVO parent,ArrayList<ClassificationVO> children){
        this(name,parent);
        this.children = children;
    }
    public ClassificationVO(String name, ArrayList<CommodityVO> commodityVOS){
        this(name);
        this.commodityVOS = commodityVOS;
    }

    public String getID() {
        return ID;
    }
}
