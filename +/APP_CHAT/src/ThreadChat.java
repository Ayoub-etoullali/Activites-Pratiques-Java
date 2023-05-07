import java.io.*;
import java.net.Socket;
import java.util.Map;

public class ThreadChat extends Thread{
    private int nbClient;
    private Socket s;
    private Map<Integer,Socket> clients;
    public ThreadChat(int nbClient, Socket s,Map<Integer,Socket> clients) {
        this.nbClient = nbClient;
        this.s = s;
        this.clients=clients;
    }

    @Override
    public void run() {
        try {
            InputStream is=s.getInputStream();
            OutputStream os=s.getOutputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            PrintWriter pr=new PrintWriter(os,true);
            pr.println("Bienvenue "+nbClient);
            String msg=null;
            while ((msg=br.readLine())!=null){
                String tab[]=msg.split(":",2);
                int dest=Integer.parseInt(tab[0]);
                Socket s1=clients.get(dest);
                OutputStream os1=s1.getOutputStream();
                PrintWriter pr1=new PrintWriter(os1,true);
                pr1.println(nbClient+"-"+tab[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
