package application;

import metier.DossierContact;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        DossierContact dossierContact=new DossierContact();

            System.out.println(
                    "\n---------------------Menu-----------------------\n"+
                    "(1) Rechercher un numéro de téléphone.\n" +
                    "(2) Ajouter un nouveau contact.\n" +
                    "(3) Supprimer un contact.\n" +
                    "(4) Changer le numéro de téléphone d’un contact.\n" +
                    "(5) Quitter ce programme."+
                    "\n------------------------------------------------"
            );

        while (true){
            System.out.println("\n\nVeuillez saisir votre choix: ");
            int k=input.nextInt();
            input.nextLine();

            if (!dossierContact.getContact().exists()) System.out.println("path no found !!");
            else System.out.println("\npath is found at:\t "+dossierContact.getContact().getPath()+"\n");

            switch (k){
                case 1: {
                    System.out.println("Saisir un contact de téléphone: ");
                    String s=input.nextLine();
                    if (dossierContact.rechContactNom(s)) System.out.println("\t| cette nom est existe  (*_*)");
                    else System.out.println("cette contact n'existe pas  (-_-)");
                    input.nextLine();
                    break;
                }
                case 2: {
                    System.out.println("Saisir un nouveau contact: ");
                    String s=input.nextLine();
                    input.nextLine();
                    System.out.println("Saisir le numéro du téléphone: ");
                    String st=input.nextLine();

                    dossierContact.ajouterContact(s,st);

                    System.out.println("liste des contacts : ");
                    for (File n:dossierContact.getNom()) {
                        System.out.println(n);
                    }

                    input.nextLine();
                    break;
                }
                case 3: {
                    System.out.println("Saisir le contact que vous voulez supprimer: ");
                    String s=input.nextLine();

                    dossierContact.suppContact(s);
                    input.nextLine();
                    for (File n:dossierContact.getNom()) {
                        System.out.println(n);
                    }
                    break;
                }
                case 4: {
                    System.out.println("Saisir nom de contact que vous voulez changer: ");
                    String nom=input.nextLine();
                    input.nextLine();

                    System.out.println("Saisir le numéro de téléphone: ");
                    String numtele=input.nextLine();

                    dossierContact.changeNumTele(nom,numtele);
                    input.nextLine();
                    break;
                }
                case 5: {
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

