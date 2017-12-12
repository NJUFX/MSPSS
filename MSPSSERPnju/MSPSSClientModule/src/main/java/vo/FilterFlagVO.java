package vo;

public class FilterFlagVO {
    /**
     * 进价最小值
     */
   public double importCostMin;
    /**
     * 进价最大值
     */
   public double importCostMax;
    /**
     * 售价最小值
     */
    public double exportCostMin;
    /**
     * 售价最大值
     */
   public double exportCostMax;
    /**
     * 所属的分类
     */
   public String classificationName;
    /**
     * 商品名
     */
    public String name;
    /**
     * 商品ID
     */
   public String id;

    public double getImportCostMin() {
        return importCostMin;
    }

    public double getImportCostMax() {
        return importCostMax;
    }

    public double getExportCostMin() {
        return exportCostMin;
    }

    public double getExportCostMax() {
        return exportCostMax;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setImportCostMin(double importCostMin) {
        this.importCostMin = importCostMin;
    }

    public void setImportCostMax(double importCostMax) {
        this.importCostMax = importCostMax;
    }

    public void setExportCostMin(double exportCostMin) {
        this.exportCostMin = exportCostMin;
    }

    public void setExportCostMax(double exportCostMax) {
        this.exportCostMax = exportCostMax;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
