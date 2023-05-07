package metier;

import java.io.Serializable;

public class Produit implements Serializable {

    private long id;
    private String nom;
    private String marque;
    private long prix;
    private String description;
    private long nbrStock;

    public Produit(){}
    public Produit(long id, String nom, String marque, long prix, String description, long nbrStock) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nbrStock = nbrStock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public long getPrix() {
        return prix;
    }

    public void setPrix(long prix) {
        this.prix = prix;
    }

    public String  getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getNbrStock() {
        return nbrStock;
    }

    public void setNbrStock(long nbrStock) {
        this.nbrStock = nbrStock;
    }
}
