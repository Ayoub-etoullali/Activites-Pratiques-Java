package classe;

import classe.IMetierProduit;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class MetierProduitImpl implements IMetierProduit {

    /*---------------------------attributs----------------------------*/
    List<Produit> produits=new ArrayList<>();

    /*---------------------------Constructor----------------------------*/
    public MetierProduitImpl(List<Produit> produit) {
        this.produits = produit;
    }

    /*---------------------------Méthodes----------------------------*/
    public List<Produit> getProduit() {
        return produits;
    }
    public void setProduit(List<Produit> produit) {
        this.produits = produit;
    }


    @Override
    public Produit addProduit(Produit p) {

        if(!produits.contains(p)) {
                produits.add(p);
            }
        return p;
    }

    @Override
    public List<Produit> getAllProduit() {
        return produits;
    }

    @Override
    public List<Produit> findByNomProduit(String motCle) {
        List<Produit> produits1=new ArrayList<>();
        Boolean[] B={false};
        produits.forEach((m)-> {
            if (m.getNom().equals(motCle)){
                produits1.add(m);
                B[0] =true;
            }
        });
        if (!B[0]) {
            System.out.println("cette nom n'existe pas");
            exit(1);
        }
        return produits1;
    }

    @Override
    public Produit findByIdProduit(long id) {
        Produit[] m1 = {new Produit()};
        Boolean[] B={false};
        produits.forEach((m)-> {
            if (m.getId()==id){
                m1[0] = m;
                B[0] =true;
            }
        });
        if (!B[0]) {
            System.out.println("cette id n'existe pas");
            exit(1);
        }
        return m1[0];
    }

    @Override
    public void deleteProduit(long id) {
        Boolean[] B = {false};
        produits.forEach((m) -> {
            if (m.getId() == id) {
                B[0] = true;
            }
        });
        if (!B[0]) {
            System.out.println("cette id n'existe pas");
            exit(1);
        } else produits.remove((int) id);


    }
}
