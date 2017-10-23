package blstubdriver.admainblservicestubdrive;

import blservice.adminblservice.AdminBLService;

public class adminblservicedrive {
    public static void main(String[] args) {
        AdminBLService admin = new adminblservicestub();
        System.out.println(admin.addAccount().toString());
        System.out.println(admin.deleteAccount().toString());
        System.out.println(admin.modifyAccount().toString());
    }
}
