import java.rmi.Naming;

public class MyRemoteClient {
    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    public void go() {
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://localhost/Remote_Hello");
            String response = service.sayHello();
            System.out.println(response);
        } catch (Exception ex) { ex.printStackTrace(); } 
    }
 }