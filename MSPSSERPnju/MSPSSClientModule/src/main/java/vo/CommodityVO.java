package vo;

public class CommodityVO {

    /**
     * 商品名称
     */
    public String name;

    /**
     * 商品分类（位于哪个分类下）
     */
    public ClassificationVO classificationVO;

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

    public CommodityVO(String name, String ID,String type, double importCost, double exportCost,int numberInStock){
        this.name = name;
        this.ID = ID;
        this.numberInStock = numberInStock;
        this.type = type;
        this.importCost = importCost;
        this.exportCost = exportCost;
    }
    public CommodityVO(String name,String type,ClassificationVO classificationVO,double importCost,double exportCost){
        this.name = name;
        this.classificationVO = classificationVO;
        this.type = type;
        this.importCost = importCost;
        this.exportCost = exportCost;
    }


    @Override
    public String toString() {
        return "商品名为"+name+" 商品类型为 "+classificationVO.name+"商品型号为 " +type+" 商品编号为 "+ID+" 进价为 "+ importCost +" 售价为 "+ exportCost;
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

    public ClassificationVO getClassificationVO() {
        return classificationVO;
    }

    public void setImportCost(double importCost) {
        this.importCost = importCost;
    }

    public void setClassificationVO(ClassificationVO classificationVO) {
        this.classificationVO = classificationVO;
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
