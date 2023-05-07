package Classe;

public class Personne {
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private int age;


    public Personne(String nom, String prenom, String email, String tel, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.age = age;
    }

    public Personne(){
        this("","","","",0);
        System.out.println("*** class Personne ***");
    }

    public void afficher(){
        System.out.println("Nom: "+nom+
                            "\nPrenom: "+prenom+
                            "\nemail: "+email+
                            "\nTelephone: "+tel+
                            "\nAge: "+age);
    }
}
