import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;
import java.util.LinkedList;
public class InventoryService extends UnicastRemoteObject implements IRemote {
    
    public InventoryService() throws RemoteException {}

    @Override 
    public LinkedList<Guitar> listProducts() {
        LinkedList<Guitar> guitars = new LinkedList<Guitar>();
        initInventory(guitars);
        return guitars;
    }

    private void initInventory(LinkedList<Guitar> guitars) {
        
        guitars.add(new Guitar(0, "Gibson", "Electric", 
            "Fender", "Fender", 20.87));
        
        guitars.add(new Guitar(0, "Stratocastor", "Acoustic", 
            "Fender", "Fender", 20.87));
    }

    public static void main(String[] args) {
        try {
            IRemote service = new InventoryService();
            Naming.rebind("remote_inventory", service);
        } catch(Exception ex) { 
            ex.printStackTrace();
        }     
    }
}