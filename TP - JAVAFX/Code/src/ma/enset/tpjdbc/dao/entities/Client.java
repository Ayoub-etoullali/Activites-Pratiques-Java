package ma.enset.tpjdbc.dao.entities;

import java.io.Serializable;

//classe persistante ou entité
public class Client implements Serializable {
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private Commande commande;

    public Client() {
    }

    public Client(String nom, String description, int quantite, Commande categorie) {
        this.nom = nom;
        this.prenom = description;
        this.age = quantite;
        this.commande =categorie;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                '}';
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Commande getCommande() {
        return commande;
    }
}
