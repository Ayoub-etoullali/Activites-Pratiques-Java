package classe;

public class Ordinateur {

    private String nom;
    private String marque;
    private double prix;
    private String description;
    private Long nbrStock;

    //__________________________getPrix selon quatite________________________________
    public double getPrix_quatite(){
        return prix;
    }

    //_________________________________Constructors___________________________________
    public Ordinateur() {}
    public Ordinateur(String nom, String marque, double prix, String description, Long nbrStock, Categorie categorie) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nbrStock = nbrStock;
    }

    //_________________________________Getters & Setters________________________________
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNbrStock() {
        return nbrStock;
    }

    public void setNbrStock(Long nbrStock) {
        this.nbrStock = nbrStock;
    }

    //__________________________________toString()_________________________________
    @Override
    public String toString() {
        return "Ordinateur{" +
                "nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", nbrStock=" + nbrStock +
                '}';
    }

}
