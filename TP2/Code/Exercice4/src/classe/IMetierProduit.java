package classe;

import java.util.List;

public interface IMetierProduit {

        /*---------------------------Méthodes----------------------------*/
    public Produit addProduit(Produit p);
    public List<Produit> getAllProduit();
    public List<Produit> findByNomProduit(String motCle);
    public Produit findByIdProduit(long id);
    public void deleteProduit(long id);
}
