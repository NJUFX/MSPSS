package po;

import util.Time;

/**
 * @Project_Name ERPnju
 * @Author: HanXinHu
 * @Description:
 * @Date Created in 19:20 2017/11/6/006
 */
public class CommodityStockPO {
    /**
     * 商品编号
     */
    private String commodityID;
    /**
     * 该批次批号下的商品数量
     */
    private int number;
    /**
     * 库存均价
     */
    private double price;
    /**
     * 批次
     */
    private String pici;
    /**
     * 批号
     */
    private String pihao;
    /**
     * 出厂日期
     */
    private String exportDate;


    public CommodityStockPO(String commodityID, int number, double price, String pici, String pihao, String exportDate) {

        this.commodityID = commodityID;
        this.number = number;
        this.price = price;
        this.pici = pici;
        this.pihao = pihao;
        this.exportDate = exportDate;
    }

    public String getCommodityID() {
        return commodityID;
    }

    public void setCommodityID(String commodityID) {
        this.commodityID = commodityID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPici() {
        return pici;
    }

    public void setPici(String pici) {
        this.pici = pici;
    }

    public String getPihao() {
        return pihao;
    }

    public void setPihao(String pihao) {
        this.pihao = pihao;
    }

    public String getExportDate() {
        return exportDate;
    }

    public void setExportDate(String exportDate) {
        this.exportDate = exportDate;
    }
}
