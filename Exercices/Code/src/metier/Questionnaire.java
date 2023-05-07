package metier;

import java.util.Arrays;

public class Questionnaire {

    //Attributs
    public String titre;
    public Question[] tableau;
    //public String[] tab_correction=new String[4];

    //Méthodes
    public Questionnaire(String titre, Question[] tableau) {
        this.titre = titre;
        this.tableau = tableau;
    }
    @Override
    public String toString() {
        return "Questionnaire{" +
                "titre='" + titre + '\'' +
                ", tableau=" + Arrays.toString(tableau) +
                '}';
    }
}