package network;



import network.accountnetwork.AccountServerNetworkImpl;
import network.accountnetworkservice.AccountServerNetworkService;
import network.billnetwork.BillServerNetworkImpl;
import network.billnetworkservice.BillServerNetworkService;
import network.commoditynetwork.CommodityServerNetworkImpl;
import network.commoditynetworkservice.CommodityServerNetworkService;
import network.customernetwork.CustomerServerNetworkImpl;
import network.customernetworkservice.CustomerServerNetworkService;
import network.geberalaccountnetwork.GeneralAccountServerNetworkImpl;
import network.generalaccountnetworkservice.GeneralAccountServerNeworkService;
import network.lognetwork.LogServerNetworkImpl;
import network.lognetworkservice.LogServerNetworkService;
import network.promotionnetwork.PromotionServerNetworkImpl;
import network.promotionnetworkservice.PromotionServerNetworkService;
import network.stocknetwork.StockServerNetworkImpl;
import network.stocknetworkservice.StockServerNetworkService;
import network.usernetwork.UserServerNetworkImpl;
import network.usernetworkservice.UserServerNetworkService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Remote;
/**
 * Created by thinkpad on 2017/12/28.
 */
public class ServerHelper{
        private static ServerHelper serverHelper;
        private static Registry registry;
        private static int currentConnectionNum = 0;

        private ServerHelper(int port) {
            buildNetwork(port);
        }

        public static ServerHelper getServerHelper(int port) {
            if (serverHelper != null) {
                return serverHelper;
            } else {
                return new ServerHelper(port);
            }
        }

        public static int getCurrentConnectionNum() {
            return currentConnectionNum;
        }



        public static ServerHelper buildNetwork(int port) {

            try {
                //启动RMI注册服务，指定端口为1099　（1099为默认端口）
                //也可以通过命令 ＄java_home/bin/rmiregistry 1099启动
                //这里用这种方式避免了再打开一个DOS窗口
                //而且用命令rmiregistry启动注册服务还必须事先用RMIC生成一个stub类为它所用

                registry = LocateRegistry.createRegistry(port);
               // registry = LocateRegistry.createRegistry(1099);
                //创建远程对象的一个或多个实例
                //可以用不同名字注册不同的实例
                System.out.println("RMI server is ready!");

                //把clientServerService注册到RMI注册服务器上
                UserServerNetworkService userServerNetworkService = new UserServerNetworkImpl();
                BillServerNetworkService billServerNetworkService = new BillServerNetworkImpl();
                AccountServerNetworkService accountServerNetworkService = new AccountServerNetworkImpl();
                CommodityServerNetworkService commodityServerNetworkService = new CommodityServerNetworkImpl();
                CustomerServerNetworkService customerServerNetworkService = new CustomerServerNetworkImpl();
                GeneralAccountServerNeworkService generalAccountServerNeworkService = new GeneralAccountServerNetworkImpl();
                LogServerNetworkService logServerNetworkService = new LogServerNetworkImpl();
                StockServerNetworkService stockServerNetworkService = new StockServerNetworkImpl();
                PromotionServerNetworkService promotionServerNetworkService = new PromotionServerNetworkImpl();

                UtilNetworkService utilNetworkService = new UtilNetworkImpl();

               /*Naming.rebind("AccountServerNetworkService", accountServerNetworkService);
                Naming.rebind("BillServerNetworkService", billServerNetworkService);
                Naming.rebind("CommodityServerNetworkService", commodityServerNetworkService);
                Naming.rebind("CustomerServerNetworkService", customerServerNetworkService);
                Naming.rebind("GeneralAccountServerNetworkService", generalAccountServerNeworkService);
                Naming.rebind("LogServerNetworkService", logServerNetworkService);
                Naming.rebind("StockServerNetworkService", stockServerNetworkService);
                Naming.rebind("UserServerNetworkService", userServerNetworkService);
                Naming.rebind("PromotionServerNetworkService",promotionServerNetworkService);
*/
             String host = "rmi://172.19.110.49:8888/";
                Naming.rebind(host+"AccountServerNetworkService", accountServerNetworkService);
                Naming.rebind(host+"BillServerNetworkService", billServerNetworkService);
                Naming.rebind(host+"CommodityServerNetworkService", commodityServerNetworkService);
                Naming.rebind(host+"CustomerServerNetworkService", customerServerNetworkService);
                Naming.rebind(host+"GeneralAccountServerNetworkService", generalAccountServerNeworkService);
                Naming.rebind(host+"LogServerNetworkService", logServerNetworkService);
                Naming.rebind(host+"StockServerNetworkService", stockServerNetworkService);
                Naming.rebind(host+"UserServerNetworkService", userServerNetworkService);
                Naming.rebind(host+"PromotionServerNetworkService",promotionServerNetworkService);
                System.out.println("connect succeed");

                return serverHelper;
            } catch (RemoteException e) {
                e.printStackTrace();
                System.out.println("Connect Failed");
                return null;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                System.out.println("Connect Failed");
                return null;
            }
        }

        public static void disableNetwork() {

//        if(currentConnectionNum > 0){
//            ServiceGUI.getServiceGUI().postText("You have " + currentConnectionNum + " client(s) online, still want to close connection?");
//        }else {
            try {
                UnicastRemoteObject.unexportObject(registry, true);
            } catch (NoSuchObjectException e) {
                e.printStackTrace();
            }
//        }
        }

}
