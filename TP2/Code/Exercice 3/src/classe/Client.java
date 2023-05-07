package classe;

import java.util.Arrays;

public class Client implements InterfaceCommande{

    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String ville;
    private String telephone;
    private Commande[] commandesEffect;


    //______________________________Méthodes_____________________________________
    public void ajouterCommande(Commande nvCommande) {
        for (int i = 0; i < commandesEffect.length; i++) {
            if (commandesEffect[i] == nvCommande) {
                System.out.println("cette commande est existe déjà !!");
                break;
            }else if (commandesEffect[i]==null){
                commandesEffect[i] = nvCommande;
                break;
            }
        }
    }

    public void supprimerCommande(Commande Cmd){
        boolean k=false;
        for (int i = 0; i < commandesEffect.length; i++) {
            if (commandesEffect[i] == Cmd) {
                commandesEffect[i] = null;
                k=true;
            }else if (commandesEffect[i] == Cmd) {
                commandesEffect[i] = null;
            }
        }
        if(k==false){
            System.out.println("cette commande est n'existe pas !!");
        }
    }

    //_________________________________Constructors___________________________________
    public Client() {}
    public Client(String nom, String prenom, String adresse, String email, String ville, String telephone, Commande[] commandesEffect) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.ville = ville;
        this.telephone = telephone;
        this.commandesEffect = commandesEffect;
    }

    //_________________________________Getters & Setters________________________________
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Commande[] getCommandesEffect() {
        return commandesEffect;
    }

    public void setCommandesEffect(Commande[] commandesEffect) {
        this.commandesEffect = commandesEffect;
    }

    //__________________________________toString()_________________________________
    @Override
    public String toString() {
        return  "nom = " + nom +
                "\tprenom = " + prenom  +
                "\tadresse = " + adresse +
                "\temail = " + email  +
                "\tville = " + ville +
                "\ttelephone=" + telephone +
                "\tcommandesEffect = " + Arrays.toString(commandesEffect);
    }
}
