package dataservicestubdrive;

import dataservice.BillDataService;
import datastubdriver.*;

public class BillDataServiceDrive {
    public static void main(String[] args) {
            BillDataService bill = new BillDataServiceStub();
            System.out.println(bill.DealAlarmReport());
            System.out.println(bill.MakeLossAndOverflowReport());
            System.out.println(bill.MakePresentationReport());

    }
}
