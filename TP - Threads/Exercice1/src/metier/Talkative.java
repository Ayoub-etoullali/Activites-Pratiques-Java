package metier;

public class Talkative implements Runnable{

    int nbr;
    String name;

    public Talkative(int nbr,String name) {
        this.nbr = nbr;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i=1;i<=10;i++){
            System.out.println(name+" "+nbr);
        }
    }
}
