import java.util.Locale;
import java.util.Scanner;

public class Exercice4 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("\nEntrez une ligne de texte (max. 100 caractères) :");
        String ch=scanner.nextLine().toUpperCase();

        int[] tab=new int[ch.length()];
        int k=0;
        char[] str=ch.toCharArray(), t_str=new char[ch.length()]; //AYOUB

/*
        System.out.println(str);
        System.out.println(str[0]);
        System.out.println(str[0] == str[1]);
*/

        // Caculs
        for (int i=0;i<str.length;i++){
            tab[i]=1;
        }
        for(int i=0;i<str.length;i++){
            k=1;
            for(int j=i+1;j<str.length;j++){
                if(str[i] == str[j]){ // str -> char // nb_occu -> string //
                    k++;
                    tab[i]=k;
                    t_str[j]='0';
                }
            }
        }

        // Affichage
        for(int i=0;i<str.length;i++){
            if (t_str[i]!='0' && str[i]!=' '){
                System.out.println( str[i] + " fois la lettre " + tab[i] );
            }
        }
    }
}
