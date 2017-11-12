package blstubdriver.tablestubdriver;

import blservice.tableblservice.TableBLService;
import filterflags.BusinessTableFilterFlags;
import filterflags.ProcessTableFilterFlags;
import filterflags.SaleTableFilterFlags;
import org.junit.Test;
import util.Time;
import vo.BusinessTableVO;
import vo.ProcessTableVO;
import vo.SaleTableVO;

/**
 * Created by thinkpad on 2017/11/11.
 */
public class Table_Driver {
    BusinessTableVO businessTableVO = new BusinessTableVO();
    SaleTableVO slaetable = new SaleTableVO();
    ProcessTableVO processtable = new ProcessTableVO();
    BusinessTableFilterFlags bflags = new BusinessTableFilterFlags(new Time(2017,11,11,12,12,34),new Time(2017,11,11,13,12,34));
    SaleTableFilterFlags sflags = new SaleTableFilterFlags();
    ProcessTableFilterFlags pflags = new ProcessTableFilterFlags();
    TableBLService service = new Table_Stub();
    @Test
    public void drive(){
        BusinessTableVO b = new BusinessTableVO();
        SaleTableVO s = new SaleTableVO();
        ProcessTableVO p = new ProcessTableVO();

        //1
        b=service.checkBusinessTable(bflags);
        if(b==null) System.out.println("check business table successfully");
        else System.out.println("fail");

        //2
        s = service.checkSaleTable(sflags);
        if(s==null) System.out.println("check sale table successfully");
        else System.out.println("fail");

        //3
        p = service.checkProcessTable(pflags);
        if(p==null) System.out.println("check process table successfully");
        else System.out.println("fail");

        //4
        b = service.compareBTByTime(b);
        if(b==null) System.out.println("compare business table successfully");
        else System.out.println("fail");

        //5
        s = service.compareSTByName(s);
        if(s==null) System.out.println("compare sale table successfully");
        else System.out.println("fail");

        //6
        s= service.compareSTByTime(s);
        if(s==null) System.out.println("compare sale table successfully");
        else System.out.println("fail");

        //7
        p = service.comparePTByName(p);
        if(p==null) System.out.println("compare process table successfully");
        else System.out.println("fail");

        //8
        p = service.comparePTByTime(p);
        if(p==null) System.out.println("compare process table successfully");
        else System.out.println("fail");
    }
}
