package auxiliary;

import javafx.beans.property.SimpleStringProperty;
import vo.SalesInBillVO;
import vo.SalesOutBillVO;
import vo.StockBillVO;

public class BillCheckTable {
    private final SimpleStringProperty Name = new SimpleStringProperty("");
    private final SimpleStringProperty Id = new SimpleStringProperty("");
    private final SimpleStringProperty Status = new SimpleStringProperty("");
    private StockBillVO stockBillVO;
    private SalesOutBillVO salesOutBillVO;
    private SalesInBillVO salesInBillVO;

    public BillCheckTable() {
        this("", "", "");
    }

    public BillCheckTable(String id, String name, String status) {
        setId(id);
        setName(name);
        setStatus(status);
    }

    public void setSalesInBillVO(SalesInBillVO salesInBillVO) {
        this.salesInBillVO = salesInBillVO;
    }

    public void setSalesOutBillVO(SalesOutBillVO salesOutBillVO) {
        this.salesOutBillVO = salesOutBillVO;
    }

    public SalesInBillVO getSalesInBillVO() {
        return salesInBillVO;
    }

    public SalesOutBillVO getSalesOutBillVO() {
        return salesOutBillVO;
    }

    public void setStockBillVO(StockBillVO stockBillVO) {
        this.stockBillVO = stockBillVO;
    }

    public StockBillVO getStockBillVO() {
        return stockBillVO;
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String fName) {
        Name.set(fName);
    }

    public String getId() {
        return Id.get();
    }

    public void setId(String fName) {
        Id.set(fName);
    }

    public String getStatus() {
        return Status.get();
    }

    public void setStatus(String fName) {
        Status.set(fName);
    }

}
