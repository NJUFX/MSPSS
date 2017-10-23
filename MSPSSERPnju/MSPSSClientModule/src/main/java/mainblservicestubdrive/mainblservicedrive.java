package blstubdriver.mainblservicestubdrive;

import blservice.mainblservice.MainBLService;

public class mainblservicedrive {
    public static void main(String[] args) {
        MainBLService main = new mainblservicestub();
        System.out.println(main.loggin());
        System.out.println(main.rigister());
    }
}
