package po;

import java.io.Serializable;

/**
 * @Project_Name ERPnju
 * @Author: HanXinHu
 * @Description:
 * @Date Created in 18:41 2017/11/6/006
 */

public class CommodityPO implements Serializable{
    /**
     * 商品名称
     */
    private String name;

    /**
     * 位于的商品分类ID
     */
    private String classificationID;

    /**
     * 型号
     */
    private String type;

    /**
     * 商品编号
     */
    private String ID;

    /**
     * 进价
     */
    private double importCost;

    /**
     * 零售价
     */
    private double exportCost;

    /**
     * 库存数量(要与stock同步,这可能会出bug!!!!!!）
     */
    private int numberInStock;

    /**
     * 判断该商品是否已经使用过
     */
    private boolean isUsed;
    public CommodityPO(){

    }
    public CommodityPO(String name,String classificationID,String type,String ID,double importCost,double exportCost,int numberInStock){
        this.name = name;
        this.classificationID = classificationID;
        this.type = type;
        this.ID = ID;
        this.importCost = importCost;
        this.exportCost = exportCost;
        this.numberInStock = numberInStock;
        this.isUsed = false;
    }
    public CommodityPO(String name,String classificationID,String type,String ID,double importCost,double exportCost,int numberInStock,boolean isUsed){
        this(name,classificationID,type,ID,importCost,exportCost,numberInStock);
        this.isUsed = false;
    }
    public String getName() {
        return name;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
    public boolean isUsed(){
        return isUsed;
    }

    public String getClassificationID() {
        return classificationID;
    }

    public double getExportCost() {
        return exportCost;
    }
    public double getImportCost(){
        return importCost;
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    public String getID() {
        return ID;
    }

    public String getType() {
        return type;
    }

    public void setClassificationID(String classificationID) {
        this.classificationID = classificationID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setImportCost(double importCost) {
        this.importCost = importCost;
    }

    public void setExportCost(double exportCost) {
        this.exportCost = exportCost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberInStock(int numberInStock) {
        this.numberInStock = numberInStock;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CommodityPO)
        {
            obj = (CommodityPO) obj;
            return this.ID.equals(((CommodityPO) obj).ID);
        }
            return false;
    }
}
