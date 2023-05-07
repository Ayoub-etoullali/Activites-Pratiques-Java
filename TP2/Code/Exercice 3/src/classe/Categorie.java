package classe;

import java.util.Arrays;

public class Categorie implements InterfaceOrdinateur {

    private String nom;
    private String description;
    private Ordinateur[] ord;

    //_________________________________Constructors___________________________________
    public Categorie() {}
    public Categorie(String nom, String description, Ordinateur[] ord) {
        this.nom = nom;
        this.description = description;
        this.ord = ord;
    }

    //_________________________________Getters & Setters________________________________
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Ordinateur[] getOrd() {
        return ord;
    }

    public void setOrd(Ordinateur[] ord) {
        this.ord = ord;
    }

    //__________________________________toString()_________________________________
    @Override
    public String toString() {
        return "Categorie{" + "\n" +
                "nom='" + nom + '\'' + "\n" +
                ", description='" + description + '\'' + "\n" +
                ", ord=" + Arrays.toString(ord) + "\n" +
                '}';
    }

    //______________________________Méthodes_____________________________________

    public void ajouterOrdinateur(Ordinateur ordinateur) {
        for (int i = 0; i < this.ord.length; i++) {
            if (!ord[i].getNom().equals(ordinateur.getNom())) {
                if (ord[i]==null) {
                    ord[i] = ordinateur;
                    break;
                }
            }
        }
    }

    public void supprimerOrdinateur(Ordinateur ordinateur) {
        boolean k=false;
        for (int i = 0; i < this.ord.length; i++) {
                if (ord[i].getNom().equals(ordinateur.getNom())) {
                    ord[i] = null;
                k=true;
            }else if (ord[i] == ordinateur) {
                ord[i] = null;
            }
        }
        if(k==false){
            System.out.println("cette ordinateur est n'existe pas !!");
        }
    }

    public Ordinateur[] rechercherParPrix(double prix) {
        Ordinateur[] ords = new Ordinateur[this.ord.length];
        int j = 0;
        for (int i = 0; i < this.ord.length; i++) {
            if ((double)ord[i].getPrix() == (double) prix) {
                ords[j] = ord[i];
                j++;
            }
        }
        return ords;
    }

}

