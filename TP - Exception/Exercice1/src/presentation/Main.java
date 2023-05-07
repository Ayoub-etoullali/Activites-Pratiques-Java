package presentation;

import exceptions.NombreNegatifException;
import metier.EntierNaturel;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n**********cas 1************");
        EntierNaturel en1=new EntierNaturel();
        try {
            en1.setVal(2);
            System.out.println(en1.getVal());
            en1.decrementer();
            System.out.println(en1.getVal());
        }catch (NombreNegatifException e){
            System.out.println(e.getMessage());
            System.out.println(e.getVal());
        }

        System.out.println("\n**********cas 2************");
        EntierNaturel en2=new EntierNaturel();
        try {
            en2.setVal(-4);
            System.out.println(en2.getVal());
            en2.decrementer();
            System.out.println(en2.getVal());
        }catch (NombreNegatifException e){
            System.out.println(e.getMessage());
            System.out.println(e.getVal());
        }


        System.out.println("\n**********cas 3************");
        EntierNaturel en3=new EntierNaturel();
        try {
            en3.setVal(0);
            System.out.println(en3.getVal());
            en3.decrementer();
            System.out.println(en3.getVal());
        }catch (NombreNegatifException e){
            System.out.println(e.getMessage());
            System.out.println(e.getVal());
        }

    }
}
