package Classe;

public class Livre {

    private int ISBN;
    private Auteur auteur;

    public Livre(int ISBN, Auteur auteur) {
        this.ISBN = ISBN;
        this.auteur = auteur;
    }

    public void afficher(){
        System.out.println("ISBN: "+ISBN);
        auteur.afficher();

    }
}
