import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServeurJeux {
    public static void main(String[] args) {
        int nbMagique;
        int numJoueur=0;
        try {
            ServerSocket ss=new ServerSocket(83);
            nbMagique=new Random().nextInt(100);

            while (true){
                Socket s=ss.accept();
                numJoueur++;
                ThreadJeux tj=new ThreadJeux(s,nbMagique,numJoueur);
                tj.start();
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
