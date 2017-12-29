package network;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by thinkpad on 2017/12/28.
 */
public class UtilNetworkImpl extends UnicastRemoteObject implements UtilNetworkService {

    public UtilNetworkImpl() throws RemoteException {

    }

    public void addCurrentConnectionNum() throws RemoteException {
       // ServerHelper.addCurrentConnectionNum();
    }

    public void minusCurrentConnectionNum() throws RemoteException {
       // ServerHelper.minusCurrentConnectionNum();
    }

}
