import java.util.Locale;
import java.util.Scanner;

public class app4_1 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("\nEntrez une ligne de texte (max. 100 caractères) :");
        String ch=scanner.nextLine().toUpperCase();

        String nb_occurrences= "Azertyuiopqsdfghjklmwxcvbn";
        int[] tab=new int[26];
        int k=0;

        char[] str=ch.toCharArray(); //AYOUB
        char[] x=nb_occurrences.toUpperCase().toCharArray(); //AZERTYUIOPQSDFGHJKLMWXCVBN

        // Caculs
        for (int i=0;i<str.length;i++){
            tab[i]=0;
        }
        for(int i=0;i<str.length;i++){
            k=0;
            for(int j=1;j<str.length;j++){
                if(str[i] == str[j]){ // str -> char // nb_occu -> string //
                    str[j]=0;
                    tab[i]=k++;
                }
            }
        }

        // Affichage
        for(int i=0;i<str.length;i++){
            if (tab[i] != 0){
                System.out.println( str[i] + " fois la lettre " + tab[i] );
            }
        }
/*
        System.out.println(x);
        System.out.println(str);
        System.out.println(x[0]);
        System.out.println(str[0]);
        System.out.println(x[0] == str[0]);
*/
/*
        // Caculs
        for (int i=0;i<x.length;i++){
            tab[i]=0;
        }
        for(int i=0;i<str.length;i++){
            for(int j=0;j< x.length;j++){
                k=0;
                if(x[j] == str[i]){  //str -> char && nb_occu -> string
                    k++;
                    tab[j]=k;
                }
            }
        }

        // Affichage
        int p=0;
        for(int i=0;i<x.length;i++){
            if (tab[i] != 0){
                System.out.println( str[p] + " fois la lettre " + tab[i] );
                p++;
            }
        }
*/
    }
}
