package application;

import metier.Client;
import metier.MetierClientImpl;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner input = new Scanner(System.in);

        MetierClientImpl clt=new MetierClientImpl();

        System.out.println(
                "\n-------------------------------Menu-----------------------------\n"+
                        "1. Afficher la liste des clients.\n" +
                        "2. Afficher un client par son id.\n" +
                        "3. Ajouter un nouveau client dans la liste.\n" +
                        "4. Supprimer un client par id.\n" +
                        "5. Sauvegarder les clients : cette option permet de sauvegarder\n" +
                        "    la liste des clients dans fichier nommé clients.dat.\n" +
                        "6. Quitter ce programme." +
                        "\n----------------------------------------------------------------\n"
        );

        while (true){
            System.out.print("\n\nVeuillez saisir votre choix: ");
            int k=input.nextInt();
            input.nextLine();

            switch (k){
                case 1: {
                    System.out.println("La liste des clients:\n");
                    List<Client> l=clt.getAllClients();
                    clt.Affiche(l);
                    break;
                }
                case 2: {
                    System.out.println("choissez un id du client: \n");
                    String id=input.nextLine();

                    Client c=clt.findClientById(id);
                    clt.afficheClt(c);
                    input.nextLine();
                    break;
                }
                case 3: {
                    System.out.println("Saisir un id du client: ");
                    String id=input.nextLine();
                    System.out.println("Saisir un nom du client: ");
                    String nom=input.nextLine();
                    System.out.println("Saisir un prénom du client: ");
                    String prénom=input.nextLine();
                    System.out.println("Saisir une adresse du client: ");
                    String adresse=input.nextLine();
                    System.out.println("Saisir un tel du client: ");
                    String tel=input.nextLine();
                    System.out.println("Saisir un email du client: ");
                    String email=input.nextLine();

                    Client c=new Client(id,nom,prénom,adresse,tel,email);
                    clt.addClient(c);
                    break;
                }
                case 4: {
                    System.out.println("Saisir un id du client: ");
                    String id=input.nextLine();

                    clt.deleteClient(id);
                    input.nextLine();
                    break;
                }
                case 5: {
                    clt.saveAllClients();
                    break;
                }
                case 6: {
                    System.exit(-1);
                    break;
                }
                default:{
                    System.out.println("veuillez ressaisir votre choix !!");
                }
            }
        }
    }
}


