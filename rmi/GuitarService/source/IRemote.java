import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;
public interface IRemote extends Remote {

    public LinkedList<Guitar> listProducts() throws RemoteException;
}