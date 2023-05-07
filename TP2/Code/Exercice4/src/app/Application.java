package app;

import classe.MetierProduitImpl;
import classe.Produit;

import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.exit;
import static java.lang.System.in;

public class Application {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);

        ArrayList<Produit> produits=new ArrayList<>();

        Produit p1=new Produit(Long.valueOf(1), "produit 1", "marque 1", 1500, "description 1", 15);
        Produit p2=new Produit(Long.valueOf(2), "produit 2", "marque 2", 500, "description 2", 100);
        Produit p3=new Produit(Long.valueOf(3), "produit 3", "marque 3", 2000, "description 3", 44);

        produits.add(p1);
        produits.add(p2);
        produits.add(p3);

        MetierProduitImpl P=new MetierProduitImpl(produits);

        while (true){

            System.out.println("" +
                    "\n\n--------------------------------------------\n" +
                    "1. Afficher la liste des produits.\n" +
                    "2. Rechercher des produits par mot clé.\n" +
                    "3. Ajouter un nouveau produit dans la liste.\n" +
                    "4. Récupérer et afficher un produit par ID.\n" +
                    "5. Supprimer un produit par id.\n" +
                    "6. Quitter ce programme\n" +
                    "--------------------------------------------\n"
            );

            System.out.println("\nchoissez un nbr selon votre besoin : ");
            int k=input.nextInt();
            input.nextLine();

            switch (k){
                case 1: {
                    produits.forEach((m) -> System.out.println(m));
                    break;
                }
                case 2: {
                    System.out.println("Entrer un nom: ");
                    String str=input.nextLine();
                    input.nextLine();
                    P.findByNomProduit(str).forEach((m) -> System.out.println(m));
                    break;
                }
                case 3: {
                    Produit p4=new Produit();

                    System.out.println("setId: ");
                    p4.setId(input.nextInt());                    input.nextLine();

                    System.out.println("setNom: ");
                    p4.setNom(input.nextLine());                    input.nextLine();

                    System.out.println("setMarque: ");
                    p4.setMarque(input.nextLine());                    input.nextLine();

                    System.out.println("setPrix: ");
                    p4.setPrix(input.nextInt());                    input.nextLine();

                    System.out.println("setDescription: ");
                    p4.setDescription(input.nextLine());                    input.nextLine();

                    System.out.println("setNbrStock: ");
                    p4.setNbrStock(input.nextInt());                    input.nextLine();

                    P.addProduit(p4);

                    produits.forEach((m) -> System.out.println(m));
                    break;
                }
                case 4: {
                    System.out.println("Entrer id: ");
                    int x=input.nextInt();
                    input.nextLine();
                    P.findByIdProduit(x).afficher();
                    break;
                }
                case 5: {
                    System.out.println("Entrer id: ");
                    int x=input.nextInt();
                    input.nextLine();
                    P.deleteProduit(Long.valueOf(x)-1);
                    produits.forEach((m) -> System.out.println(m));
                    break;
                }
                case 6: {
                    System.out.println("~~By..");
                    exit(1);
                    break;
                }
                default :{
                    System.out.println("this choice is incorrect");
                    break;
                }
            }
        }
    }
}