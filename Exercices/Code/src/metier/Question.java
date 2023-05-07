package metier;

public class Question {

    //Attributs
    private String titre;
    private String description;
    public Reponse[] reponses; // ou ajouter []reponses=new Reponse[4]
    private float score;


    //Méthodes
    public Question() {
    }
    public Question(String titre, String description, Reponse[] reponses, float scores) {
        this.titre = titre;
        this.description = description;
        this.reponses = reponses;
        this.score = scores;
    }

    public String getTitre() { return titre; }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Reponse[] getReponses() {
        return reponses;
    }

    public void setReponses(Reponse[] reponses) {
        this.reponses = reponses;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String toString() {
        String quest=  titre +
                " (" + score + ')'+
                "\n" + description + '\n' ;
        for (Reponse rep:reponses) {
            quest+=rep.toString();
        }
        return quest;
    }

}

