package classe;

public class LigneCommande   {

    private long quantite;
    private Commande commande;
    private Ordinateur ordCommande;

    //_________________________________Constructors___________________________________
    public LigneCommande() {}
    public LigneCommande(long quantite, Commande commande, Ordinateur ordCommande) {
        this.quantite = quantite;
        this.commande = commande;
        this.ordCommande = ordCommande;
    }

    //_________________________________Getters & Setters________________________________
    public long getQuantite() {
        return quantite;
    }

    public void setQuantite(long quantite) {
        this.quantite = quantite;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Ordinateur getOrdCommande() {
        return ordCommande;
    }

    public void setOrdCommande(Ordinateur ordCommande) {
        this.ordCommande = ordCommande;
    }

    //__________________________________toString()_________________________________
    @Override
    public String toString() {
        return "LigneCommande{" +
                "quantite=" + quantite +
                ", commande=" + commande +
                ", ordCommande=" + ordCommande +
                '}';
    }
}
