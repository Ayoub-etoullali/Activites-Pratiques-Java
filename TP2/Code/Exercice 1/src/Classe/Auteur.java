package Classe;

public class Auteur extends Personne {
    private int numAuteur;

    public Auteur(String nom, String prenom, String email, String tel, int age, int numAuteur) {
        super(nom, prenom, email, tel, age);
        this.numAuteur = numAuteur;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Numéro Auteur: "+numAuteur);
    }
}
