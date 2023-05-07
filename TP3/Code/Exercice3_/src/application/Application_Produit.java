package application;

import metier.MetierProduitImpl;
import metier.Produit;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Application_Produit {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner input = new Scanner(System.in);

        MetierProduitImpl prd=new MetierProduitImpl();

        System.out.print("\nSaisir le nom de fichier pour sauvegarder les produits: ");
        prd.setNomFil(input.nextLine());
        input.nextLine();

        System.out.println(
                "\n-------------------------------Menu-----------------------------\n"+
                        "1. Afficher la liste des produits.\n" +
                        "2. Recherche un produit par son id.\n" +
                        "3. Ajouter un nouveau produit dans la liste.\n" +
                        "4. Supprimer un produit par id.\n" +
                        "5. Sauvegarder les produits : cette option permet de sauvegarder\n" +
                        "    la liste des produits dans fichier nommé produits.dat.\n" +
                        "6. Quitter ce programme." +
                        "\n----------------------------------------------------------------\n"
        );

        while (true){
            System.out.print("\n\nVeuillez saisir votre choix: ");
            int k=input.nextInt();
            input.nextLine();

            switch (k){
                case 1: {
                    System.out.println("La liste des Produits:\n");
                    List<Produit> l=prd.getAll();
                    prd.Affiche(l);
                    break;
                }
                case 2: {
                    System.out.println("choissez un id du produit: \n");
                    long id=input.nextLong();

                    Produit c=prd.findById(id);
                    prd.afficheSeul(c);
                    input.nextLine();
                    break;
                }
                case 3: {
                    System.out.println("Saisir un id du produit: ");
                    long id=input.nextLong();
                    input.nextLine();
                    System.out.println("Saisir un nom du produit: ");
                    String nom=input.nextLine();
                    input.nextLine();
                    System.out.println("Saisir une marque du produit: ");
                    String marque=input.nextLine();
                    input.nextLine();
                    System.out.println("Saisir un prix du produit: ");
                    long prix=input.nextLong();
                    input.nextLine();
                    System.out.println("Saisir une description du produit: ");
                    String description=input.nextLine();
                    input.nextLine();
                    System.out.println("Saisir un nombre en stock du produit: ");
                    long nbrStock=input.nextLong();

                    Produit c=new Produit(id,nom,marque,prix,description,nbrStock);
                    prd.add(c);
                    input.nextLine();
                    break;
                }
                case 4: {
                    System.out.println("Saisir un id du produit: ");
                    long id=input.nextLong();

                    prd.delete(id);
                    input.nextLine();
                    break;
                }
                case 5: {
                    prd.saveAll();
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


