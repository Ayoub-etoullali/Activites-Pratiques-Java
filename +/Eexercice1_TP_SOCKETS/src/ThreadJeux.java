import java.io.*;
import java.net.Socket;

public class ThreadJeux extends Thread{
    private Socket s;
    private int nbMagique;
    private static boolean termine;
    private int numJoueur;
    private static String nomJoueurGagnant;
    private String nomJoueur;
    public ThreadJeux(Socket s,int nbMagique,int numJoueur) {
        this.s = s;
        this.nbMagique=nbMagique;
        this.numJoueur=numJoueur;
    }

    @Override
    public void run() {
        try {
            InputStream is=s.getInputStream();
            OutputStream os=s.getOutputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            PrintWriter wr=new PrintWriter(os,true);
            wr.println("Veuillez entrez votre nom");
            nomJoueur= br.readLine();
            wr.println("Deviner un nombre !!");
            String msg=null;
            while ((msg= br.readLine())!=null){
                int nb=Integer.parseInt(msg);
                if(!termine){
                    if(nb>nbMagique){
                        wr.println("Entrez un nombre inférieur !!");
                    }else if(nb<nbMagique){
                        wr.println("Entrez un nombre supérieur !!");
                    }else {
                        wr.println("Bravo vous avez trouvé le nombre magique !!");
                        termine=true;
                        nomJoueurGagnant =nomJoueur;
                    }
                }else{
                    wr.println("Le jeu est terminé, le nombre magique est :"+nbMagique+" trouvé par le joueur  "+ nomJoueurGagnant);
                }

            }
        }catch(Exception e){

        }


    }
}
