package Application;

import Classe.Employe;
import Classe.Ingenieur;
import Classe.Manager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);

        System.out.println("\nVeuillez saissir le salaire : ");
        double k=input.nextDouble();

        // _________________________ingénieur_______________________________
        System.out.println("\nRemplir les informations d'un ingénieur : ");
        Ingenieur inj= new Ingenieur();
        inj.setSalaire(k);

        System.out.print("Nom: "); inj.setNom(input.nextLine());
        System.out.print("Prenom: "); inj.setPrenom(input.nextLine());
        System.out.print("Email: "); inj.setEmail(input.nextLine());
        System.out.print("Telephone: "); inj.setTelephone(input.nextLine());
        inj.setSalaire(inj.calculerSalaire());
        System.out.print("Specialite: "); ((Ingenieur)inj).setSpecialite(input.nextLine());  System.out.println("\n");
        inj.afficher();

        // _________________________manager_______________________________
        System.out.println("\nRemplir les informations d'un manager : ");
        Manager manag= new Manager();
        manag.setSalaire(k);

        System.out.print("Nom: "); manag.setNom(input.nextLine());
        System.out.print("Prenom: "); manag.setPrenom(input.nextLine());
        System.out.print("Email: "); manag.setEmail(input.nextLine());
        System.out.print("Telephone: "); manag.setTelephone(input.nextLine());
        manag.setSalaire(manag.calculerSalaire());
        System.out.print("Service: "); ((Manager)manag).setService(input.nextLine());  System.out.println("\n");
        manag.afficher();
        }
}