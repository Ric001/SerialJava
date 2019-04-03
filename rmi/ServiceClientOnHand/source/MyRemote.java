import java.rmi.RemoteException;
import java.rmi.Remote;

public interface MyRemote extends Remote {
    public String sayHello() throws RemoteException;
}