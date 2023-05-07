import java.util.Scanner;

public class Exercice3 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        System.out.println(
                "\n" +
                        "|-------------------------------------------Menu-------------------------------------------------|\n" +
                        "| 1. saisir : lire une chaîne de caractères à partir du clavier et la stocker dans une variable. |\n" +
                        "| 2. afficher : afficher la chaîne saisie.                                                       |\n" +
                        "| 3. inverser : inverser la chaîne saisie.                                                       |\n" +
                        "| 4. Nombre de mots : compter le nombre de mots de la chaîne.                                    |\n" +
                        "| 5. exit                                                                                        |\n" +
                        "|------------------------------------------------------------------------------------------------|"
        );



        do {
            System.out.println("Choisissez votre sélection désirée :");
            int nbr=scanner.nextInt();
            scanner.nextLine();
            switch (nbr){
                case 1 : {
                    System.out.println("Entrez une chaine");
                    sb.replace(0,sb.length(),scanner.nextLine());
                    break;
                }
                case 2 : {
                    System.out.println("affiche : " + sb);
                    break;
                }
                case 3 :
                    sb.reverse();
                    break;
                case 4 :
                    System.out.println(sb.toString().split(" ").length);
                    break;

                case 5: {
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("cette choix n'existe pas");
                }
            }
            System.out.println("Frappez une touche pour revenir au menu.");
            scanner.nextLine();
        }while (true);

    }
}
