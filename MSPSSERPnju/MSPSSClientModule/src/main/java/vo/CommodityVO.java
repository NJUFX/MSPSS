package vo;

public class CommodityVO {

    /**
     * 商品名称
     */
    public String name;

    /**
     * 商品分类（位于哪个分类下）
     */
    public String classificationName;

    /**
     * 型号
     */
    public String type;

    /**
     * 商品编号
     */
   public String ID;

    /**
     * 进价
     */
   public double importCost;

    /**
     * 零售价
     */
   public double exportCost;

    /**
     * 最近一次进价
     */
   public double latestImportCost;

    /**
     * 最近一次售价
     */
   public double latestExportCost;
    /**
     * 库存数量
     */
   public int numberInStock;
    /**
     * 库存警戒值
     */
   public int alertNumber;

    public CommodityVO(String name, String ID,String type, double importCost, double exportCost,int numberInStock){
        this.name = name;
        this.ID = ID;
        this.numberInStock = numberInStock;
        this.type = type;
        this.importCost = importCost;
        this.exportCost = exportCost;
    }
    public CommodityVO(String name, String type, String classificationName, double importCost, double exportCost){
        this.name = name;
        this.classificationName = classificationName;
        this.type = type;
        this.importCost = importCost;
        this.exportCost = exportCost;
    }

    public CommodityVO(String name, String classificationVO, String type, String ID, double importCost, double exportCost, double latestImportCost, double latestExportCost, int numberInStock, int alertNumber) {
        this.name = name;
        this.classificationName = classificationVO;
        this.type = type;
        this.ID = ID;
        this.importCost = importCost;
        this.exportCost = exportCost;
        this.latestImportCost = latestImportCost;
        this.latestExportCost = latestExportCost;
        this.numberInStock = numberInStock;
        this.alertNumber = alertNumber;
    }

    @Override
    public String toString() {
        return "商品名为"+name+" 商品类型为 "+classificationName+"商品型号为 " +type+" 商品编号为 "+ID+" 进价为 "+ importCost +" 售价为 "+ exportCost;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumberInStock(int numberInStock) {
        this.numberInStock = numberInStock;
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

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public void setAlertNumber(int alertNumber) {
        this.alertNumber = alertNumber;
    }

    public int getAlertNumber() {
        return alertNumber;
    }

    public void setImportCost(double importCost) {
        this.importCost = importCost;
    }



    public double getImportCost() {
        return importCost;
    }

    public void setLatestExportCost(double latestExportCost) {
        this.latestExportCost = latestExportCost;
    }

    public double getLatestExportCost() {
        return latestExportCost;
    }

    public void setLatestImportCost(double latestImportCost) {
        this.latestImportCost = latestImportCost;
    }

    public double getLatestImportCost() {
        return latestImportCost;
    }

}
