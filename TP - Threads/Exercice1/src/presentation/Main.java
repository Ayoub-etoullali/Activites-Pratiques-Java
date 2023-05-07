package presentation;

import metier.Talkative;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        // *-----------1-----------*
        Talkative[] T = {
                new Talkative(1, "T1"),
                new Talkative(2, "T2"),
                new Talkative(3, "T3"),
                new Talkative(4, "T4"),
                new Talkative(5, "T5"),
                new Talkative(6, "T6"),
                new Talkative(7, "T7"),
                new Talkative(8, "T8"),
                new Talkative(9, "T9"),
                new Talkative(10, "T10")
        };

         /*
        Talkative t1=new Talkative(1);
        Talkative t2=new Talkative(2);
        Talkative t3=new Talkative(3);
        Talkative t4=new Talkative(4);
        Talkative t5=new Talkative(5);
        Talkative t6=new Talkative(6);
        Talkative t7=new Talkative(7);
        Talkative t8=new Talkative(8);
        Talkative t9=new Talkative(9);
        Talkative t10=new Talkative(10);
        */

        new Thread(T[3]).setPriority(Thread.MAX_PRIORITY);
        for (Talkative t:T) {
            new Thread(t).start();
        }

        // *-----------2-----------*
        /*
        List<Talkative> list=new ArrayList<>();
        for(int i=1;i<=10;i++){
            list.add(new Talkative(i,"T"+i));
        }
        for(int i=1;i<=list.size();i++){
            new Thread(list.get(i)).start();
        }
        */


        // *-----------3-----------*
        /*
        for (int i = 1; i <= 10; i++) {
            Talkative t = new Talkative(i, "T" + i);
            new Thread(t).start();
        }
         */
    }
}
