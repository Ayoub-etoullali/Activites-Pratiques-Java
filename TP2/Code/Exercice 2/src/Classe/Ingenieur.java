package Classe;

public class Ingenieur extends Employe{

    private String specialite;

    public Ingenieur(){}
    public Ingenieur(String nom, String prenom, String email, String telephone, double salaire, String specialite) {
        super(nom, prenom, email, telephone, salaire);
        this.specialite = specialite;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public double calculerSalaire(){
        return getSalaire()*1.15;
    }

    public void afficher() {
        super.afficher();
        System.out.println("{" +
                "specialite='" + specialite + '\'' +
                '}');
    }
}
