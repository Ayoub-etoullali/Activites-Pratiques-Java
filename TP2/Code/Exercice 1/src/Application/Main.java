package Application;

import Classe.*;

public class Main {
    public static void main(String[] args) {

        Adherent ad1=new Adherent("ETOULLALI","radouan","radouan@gmail.com","+212 6 23 45 78",30,1);
        Auteur aut1=new Auteur("ETOULLALI","ayoub","ayoub@gmail.com","+212 6 58 71 20 11",20,15);

        System.out.println("________Adhérant________");
        ad1.afficher();
        System.out.println("\n_________Auteur_________");
        aut1.afficher();
    }
}
