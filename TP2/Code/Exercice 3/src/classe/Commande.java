package classe;

import java.util.Date;

public class Commande {

    private String reference;
    private Client client;
    private Date dateCommande;
    private boolean etatCommande;

    //_________________________________Constructors___________________________________
    public Commande() {}
    public Commande(String reference, Client client, Date dateCommande, boolean etatCommande) {
        this.reference = reference;
        this.client = client;
        this.dateCommande = dateCommande;
        this.etatCommande = etatCommande;
    }

    //_________________________________Getters & Setters________________________________
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public boolean isEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(boolean etatCommande) {
        this.etatCommande = etatCommande;
    }

    //__________________________________toString()_________________________________
    @Override
    public String toString() {
        return "------------------------------------------------------------------------------------------------------------------------------------------------------------------\n" +
                "***Commande*** \n\n" +
                "reference = " + reference +
                "\n*client*\n" + client +
                "\ndateCommande = " + dateCommande +
                "\netatCommande = " + etatCommande +
                "\n------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
    }
}
