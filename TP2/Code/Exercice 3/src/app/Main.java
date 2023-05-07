package app;

import classe.*;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //=> déclarez et intentiez une liste de trois ordinateurs
        Ordinateur []ordinateur=new Ordinateur[4];
        ordinateur[0]=new Ordinateur("acer","Mklj5625",5000,"bonne marque",Long.valueOf(546215462),null);
        ordinateur[1]=new Ordinateur("dell","lkj745",8000,"tres bonne marque",Long.valueOf(987455),null);
        ordinateur[2]=new Ordinateur("hp","iuyt965",10000,"meilleur marque",Long.valueOf(58745),null);

        //=> déclarez et intentiez une catégorie
        Categorie categorie=new Categorie("","",ordinateur);

        //=> déclarez et intentiez un client
        Client client=new Client("ETOULLALI","ayoub","lot 6543 address 1","ayoub@gmail.com","ERRACHIDIA","+212 6 58 71 20 11",null);

        //=> déclarez et instanciez une commande du client
        Commande commande=new Commande("mlk9854",client, new Date(2022,10,27),true);

        //=> déclarez et instanciez une liste de trois lignes de commandes pour la commande et les ordinateurs créés
        LigneCommande []ligneCommandes=new LigneCommande[3];
        ligneCommandes[0]=new LigneCommande(Long.valueOf(15),commande,ordinateur[0]);
        ligneCommandes[1]=new LigneCommande(Long.valueOf(2),commande,ordinateur[1]);
        ligneCommandes[2]=new LigneCommande(Long.valueOf(7),commande,ordinateur[2]);

        //=> affichez toutes les informations de la commande
        System.out.println("\n"+commande.toString());

        //=> Opérations
        ordinateur[3]=new Ordinateur("iphone","ui54",15000,"trop meilleur marque",Long.valueOf(564),categorie);
        categorie.ajouterOrdinateur(ordinateur[3]);
        System.out.println("=> ajouterOrdinateur :\n"+categorie.toString()+"\n\n");

        System.out.println("=> rechercherParPrix :");
        Ordinateur[] ord=categorie.rechercherParPrix(10000);
        for (Ordinateur o:ord) {
            if (o!=null) System.out.print(o);
        }

        categorie.supprimerOrdinateur(ordinateur[3]);
        System.out.println("\n\n\n\n\n=> supprimerOrdinateur :\n"+categorie.toString());
    }
}