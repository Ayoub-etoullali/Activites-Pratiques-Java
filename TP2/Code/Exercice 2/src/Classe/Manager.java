package Classe;

public class Manager extends Employe {

    private String service;

    public Manager(){}
    public Manager(String nom, String prenom, String email, String telephone, double salaire, String service) {
        super(nom, prenom, email, telephone, salaire);
        this.service = service;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public double calculerSalaire(){
        return getSalaire()*1.2;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("{" +
                "service='" + service + '\'' +
                '}');
    }
}

