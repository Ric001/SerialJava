import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.LinkedList; 

public class ServiceClient {
    public static void main(String[] args) {
        try {
            IRemote service = (IRemote) Naming.lookup("rmi://localhost/remote_inventory");
            LinkedList<Guitar> incomingGuitars  = service.listProducts();
            if (incomingGuitars.isEmpty())
                throw new Exception();

            displayGuitars(incomingGuitars);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayGuitars(LinkedList<Guitar> guitars) {
        for (Guitar guitar : guitars) {
            System.out.println(guitar.toString().concat("\n\n"));
        }
    } 
}