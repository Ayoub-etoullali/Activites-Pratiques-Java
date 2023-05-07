package application;

import java.awt.desktop.SystemEventListener;
import java.io.File;
import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        /*
       C:\Users\pc\Desktop\ENSET\S3\POO\POO Java\TPs\TP3\Code\xampp
         */

            input.nextLine();

            System.out.println("\nSaisie le chemin du répertoire :");
            Systeme.out.in()
            File rep=new File(input.nextLine());
            input.nextLine();
            repertoire(rep);

    }
    public static void repertoire(File rep){


        if(!rep.exists())
        else System.out.print(rep.getPat

                h());

        if(rep.isFile()){
            System.out.print(" <FILE>");

        }
        else if(rep.isDirectory()){
            System.out.print(" <DIR>");
        }

        if(rep.canRead()) System.out.print(" r");
        else if(rep.isDirectory()) System.out.print("-");
        if(rep.canWrite()) System.out.print("w");
        else if(rep.isDirectory()) System.out.print("-");
        if(rep.canExecute()) System.out.print("x");
        else if(rep.isDirectory()) System.out.print("-");

        if(rep.isFile()) System.out.print("\n");
        else {
            System.out.print("\n   -----> ");
            File[] child=rep.listFiles();
            for (File f:child) {
                repertoire(f);
            }
            }
        }

    }

//System.out.println("path not found !!");
