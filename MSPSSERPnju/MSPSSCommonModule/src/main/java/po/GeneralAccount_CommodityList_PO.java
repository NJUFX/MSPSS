package po;

import java.io.Serializable;

/**
 * Created by thinkpad on 2017/11/30.
 */
public class GeneralAccount_CommodityList_PO implements Serializable {
    /**
     * 数据库关键字，数据库会自动赋值！！切勿自己赋值
     */
    private String keycolumn;
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
     *多对一映射中对应的链表
     */
    private GeneralAccountPO generalaccount;

    public String getKeycolumn() {
        return keycolumn;
    }

    public void setKeycolumn(String keycolumn) {
        this.keycolumn = keycolumn;
    }

    public GeneralAccountPO getGeneralaccount() {
        return generalaccount;
    }

    public void setGeneralaccount(GeneralAccountPO generalaccount) {
        this.generalaccount = generalaccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassificationID() {
        return classificationID;
    }

    public void setClassificationID(String classificationID) {
        this.classificationID = classificationID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getImportCost() {
        return importCost;
    }

    public void setImportCost(double importCost) {
        this.importCost = importCost;
    }

    public double getExportCost() {
        return exportCost;
    }

    public void setExportCost(double exportCost) {
        this.exportCost = exportCost;
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(int numberInStock) {
        this.numberInStock = numberInStock;
    }
}
