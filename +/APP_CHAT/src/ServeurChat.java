import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServeurChat {
    public static void main(String[] args) {
        int nbClient=0;
        Map<Integer,Socket> clients=new HashMap<>();
        try {
            ServerSocket ss=new ServerSocket(83);
            while (true){
                Socket s=ss.accept();
                nbClient++;
                clients.put(nbClient,s);
                ThreadChat tc=new ThreadChat(nbClient,s,clients);
               tc.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
