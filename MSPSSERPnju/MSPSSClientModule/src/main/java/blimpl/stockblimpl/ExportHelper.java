package blimpl.stockblimpl;

import blimpl.tableblimpl.ExportExcel;
import vo.StockInventoryVO;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by thinkpad on 2018/1/3.
 */
public class ExportHelper {

    /**
     * 导出库存列表
     */
    public void ExportStockList(List<StockInventoryVO> stockInventoryVOS) {
        Map<String, String> titleMap = new LinkedHashMap<String, String>();

        titleMap.put("name", "商品名");
        titleMap.put("number", "库存数量");
        titleMap.put("price", "库存均价");


        String sheetName = "                 库存快照";

        ExportExcel.excelExport(stockInventoryVOS, titleMap, sheetName);
    }

}
