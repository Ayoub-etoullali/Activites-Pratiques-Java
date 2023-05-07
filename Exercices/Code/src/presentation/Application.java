package presentation;

import metier.Question;
import metier.Questionnaire;
import metier.Reponse;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n-*-*-*-*-*-*-*-*-*-saisir le nom de questionnaire-*-*-*-*-*-*-*-*-*-*-*-\n");
        String qs=scanner.nextLine();
        scanner.nextLine();

        System.out.print("Enter le nombre des quesions : " );
        int q=scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter le nombre des réponses : ");
        int r=scanner.nextInt();
        scanner.nextLine();

        Question[] tableau = new Question[q];

        //--------------------Remplir---------------------
        int k=0;
        for (int i = 0; i < tableau.length; i++) {
            k=i+1;
            tableau[i] = new Question();
            tableau[i].setReponses(new Reponse[r]);
            System.out.println("\n----------------saisir un titre de question---------------");
            tableau[i].setTitre(scanner.nextLine());
            scanner.nextLine();

            System.out.println("saisir la question " + k);
            tableau[i].setDescription(scanner.nextLine());
            scanner.nextLine();

            for (int j = 0; j < tableau[i].getReponses().length; j++) {
                k=j+1;
                tableau[i].reponses[j] = new Reponse(); //tableau[i].setReponses(new Reponse[]{new Reponse()})
                System.out.println("\nsaisir la réponse " + k);
                tableau[i].reponses[j].setTitre(scanner.nextLine());
                scanner.nextLine();
                System.out.println("il est true ? ");
                tableau[i].reponses[j].setCorrect(scanner.nextBoolean());
                scanner.nextLine();
            }

            System.out.print("saisir un score : ");
            tableau[i].setScore(scanner.nextInt());
            scanner.nextLine();
        }


        //-------------------Reponse--------------------

        float Rst = 0;
        int reponse = 1;
        for (int i = 0; i < tableau.length; i++) {
            k=i+1;
            System.out.println("\n#titre de question: [" + tableau[i].getTitre() + "]\tscore: " + tableau[i].getScore());
            System.out.println("Q" + k + ": " + tableau[i].getDescription());
            for (int j = 0; j < tableau[i].getReponses().length; j++) {
                System.out.println("\t - " + tableau[i].reponses[j].getTitre());
            }
            System.out.print("Réponse : ");
            reponse = scanner.nextInt();
            scanner.nextLine();
            //tableau[i].reponses[reponse-1].correct=true;
            if (tableau[i].reponses[reponse - 1].isCorrect()) {
                Rst += tableau[i].getScore();
            }
        }

        //-----------------affichage----------------------

        System.out.println("\n-*-*-*-*-*-*-*-*-*-QCM de " + qs +"-*-*-*-*-*-*-*-*-*\n");
        for (int i = 0; i < tableau.length; i++) {
            k=i+1;
            System.out.println("Q" + k + "\t" + tableau[i].getDescription() );
            for (int j = 0; j < tableau[i].getReponses().length; j++) {
                if (tableau[i].reponses[j].isCorrect()) {
                    System.out.println(tableau[i].reponses[j].getTitre() + ": est la reponse correcte !!\n\n");
                }
            }
        }
            System.out.println("\n***** Résultat final *****\n" + Rst);
    }
}