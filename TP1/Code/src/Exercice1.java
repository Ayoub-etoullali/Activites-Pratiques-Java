import java.util.Arrays;
import java.util.Scanner;

public class Exercice1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nombre d'étudiants :");
        int nb = scanner.nextInt();

        double notes[] = new double[nb];
        for (int i = 0; i < nb; i++) {
            System.out.println("Entrer la note " + (i + 1) + " :");
            notes[i] = scanner.nextDouble();
        }

        // afficher
        System.out.println("afficher");
        for (double n : notes) {
            System.out.println(n);
        }

        // trier : use normal
        System.out.println("\n ** use normal **");
        double min = notes[0], X;
        for (int i = 0; i < notes.length-1; i++) {
            for (int j = i + 1; j < notes.length; j++) {
                if (notes[i] > notes[j]) {
                    X = notes[i];
                    notes[i] = notes[j];
                    notes[j] = X;
                }
            }
        }

        // afficher apres trier
        System.out.println("afficher apres trier");
        for (double nt : notes) {
            System.out.println(nt);
        }

        // trier : use sort
        System.out.println("\n ** use sort **");
        Arrays.sort(notes);

        // afficher apres sort
        System.out.println("afficher apres trier");
        for (double nbt : notes) {
            System.out.println(nbt);
        }

        // moyenne
        double S = notes[0];
        for (int j = 1; j < notes.length; j++) {
            S += notes[j];
        }
        System.out.println("moyenne = " + (S / (notes.length)));

        // min
        System.out.println("min = " + notes[0]);

        // max
        System.out.println("max = " + notes[notes.length - 1]);

        // nbr étudiant
        System.out.println("\nnbr étudiant");
        System.out.println("Entrez une note d'un étudiant :");
        double nbr = scanner.nextDouble();
        int Nbr = 1;
        for (int i = notes.length - 1; i > 0; i--) {
            if (nbr == notes[i]) {
                System.out.println(Nbr);
            }
            Nbr++;
        }
/*
            // classement étudiant
            System.out.println("classement étudiant");
            System.out.println("Entrez une note d'un étudiant :");
            double Nr = scanner.nextDouble();
            int Nbr = 0;
            for (int k = notes.length - 1; k > 0; k--) {
                if (Nr == notes[k]) {
                    System.out.println("l'étudiant est classé en " + (++Nbr));
                }
            }
 */
        }
    }

