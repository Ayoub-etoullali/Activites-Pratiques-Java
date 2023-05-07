import java.util.Scanner;

public class Exercice2 {
    public static void main(String[] args){
        System.out.println("Entrez un verbe du 1ere groupe :");
        Scanner scanner=new Scanner((System.in));
        String verbe= scanner.nextLine();
        if(verbe.endsWith("er")) {  //verbe.length()-2="e" & verbe.length()-1="r"
            String radical = verbe.substring(0, verbe.length() - 2);
            System.out.println("Je " + radical + "e");
            System.out.println("Tu " + radical + "es");
            System.out.println("Il " + radical + "e");
            System.out.println("Nous " + radical + "ons");
            System.out.println("Vous " + radical + "ez");
            System.out.println("Ils " + radical + "ent");
        }else {
            System.out.println("Entrez un verbe du 1ere groupe !");
        }
    }
}
