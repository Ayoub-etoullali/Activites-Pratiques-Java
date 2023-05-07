package metier;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit> {

    List<Produit> listProduit;
    private String nomFil;

    public MetierProduitImpl() {
    }

    public MetierProduitImpl(List<Produit> listProduit, String nomFil) {
        this.listProduit = listProduit;
        this.nomFil = nomFil;
    }

    public List<Produit> getListProduit() {
        return listProduit;
    }

    public void setListProduit(List<Produit> listProduit) {
        this.listProduit = listProduit;
    }

    public String getNomFil() {
        return nomFil;
    }

    public void setNomFil(String nomFil) {
        this.nomFil = nomFil;
    }



    //----------------Interface Metier Produit-----------------
    @Override
    public Produit add(Produit p) throws IOException {
        File f=new File("C:\\Users\\pc\\Desktop\\ENSET\\S3\\POO\\POO Java\\TPs\\TP3\\Code\\Exercice3_\\Produits\\"+p.getNom()+".txt");
        FileWriter fw=new FileWriter(f);

        String s= Long.valueOf(p.getId()).toString();
        fw.append(s);
        fw.append(" ");

        fw.append(p.getNom());
        for (int i=0;i<=20-p.getNom().length();i++) fw.append(" ");

        fw.append(p.getMarque());
        for (int i=0;i<=20-p.getMarque().length();i++) fw.append(" ");

        /*
        char c=p.getPrix();
        fw.append(c);
        for (int i=0;i<=10;i++) fw.append(" ");
         */

        fw.append(Long.valueOf(p.getPrix()).toString());
        fw.append(" ");

        fw.append(p.getDescription());
        for (int i=0;i<=20-p.getDescription().length();i++) fw.append(" ");

        fw.append(Long.valueOf(p.getNbrStock()).toString());
        fw.append(" ");
        fw.close();

        return p;
    }

    @Override
    public List<Produit> getAll() throws IOException {
        File Directory = new File("C:\\Users\\pc\\Desktop\\ENSET\\S3\\POO\\POO Java\\TPs\\TP3\\Code\\Exercice3_\\Produits");
        File[] fileProduit = Directory.listFiles();
        Produit[] produit = new Produit[10];
        int i = 0;
        for (i=0;i<produit.length;i++) produit[i]=new Produit();
        i=0;
        for (File f : fileProduit) {
            FileReader fr = new FileReader(f);
            int c;
            String str = "";
            while ((c = fr.read()) != -1) {
                str += (char) c;
            }
            fr.close();
            produit[i].setId(Long.valueOf(str.substring(0, 2)));
            produit[i].setNom(str.substring(3 , 23));
            produit[i].setMarque(str.substring(24, 44));
            produit[i].setPrix(Long.valueOf(str.substring(45, 47)));
            //produit[i].setPrix(Long.valueOf(str.substring(45, 65)));
            produit[i].setDescription(str.substring(48, 68));
            produit[i].setNbrStock(Long.valueOf(str.substring(69, 71)));
            i++;
        }
        listProduit = Arrays.asList(produit);
        return listProduit;
    }

    @Override
    public Produit findById(long id) {
        Produit clt=null;
        int i=0;
        for(Produit c:listProduit){
            if(id==c.getId()) clt=c;
            i++;
        }
        if(clt==null) return null;
        return clt;
    }

    @Override
    public void delete(long id) throws IOException {
        File Directory = new File("C:\\Users\\pc\\Desktop\\ENSET\\S3\\POO\\POO Java\\TPs\\TP3\\Code\\Exercice3_\\Produits");
        File[] fileProduit = Directory.listFiles();
        listProduit=getAll();
        Boolean B=false;
        int i=0;
        for(File f:fileProduit){
            if(id==listProduit.get(i).getId()) {
                B=true;
                f.delete();
            }
            i++;
        }
        if(!B) System.out.println("Produit not found !!");
    }

    @Override
    public void saveAll() throws IOException, ClassNotFoundException {
        listProduit=getAll();
        for (Produit c: listProduit){
            File f1 = new File("C:\\Users\\pc\\Desktop\\ENSET\\S3\\POO\\POO Java\\TPs\\TP3\\Code\\Exercice3_\\"+nomFil+".dat");
            FileOutputStream fw = new FileOutputStream(f1);
            ObjectOutputStream oos = new ObjectOutputStream(fw);

            oos.writeObject(c);
            oos.close();

            FileInputStream fis=new FileInputStream(f1);
            ObjectInputStream ois=new ObjectInputStream(fis);

            Produit p=(Produit) ois.readObject();
            System.out.println(p.getNom()+" "+p.getMarque());
            ois.close();
        }
    }

    @Override
    public void Affiche(List<Produit> listProduit){
        for (Produit p : listProduit) {
            afficheSeul(p);
        }
    }

    @Override
    public void afficheSeul(Produit c){
        if (c!=null){
            System.out.println("---------Produit: " + c.getId() + "--------------\n" +
                    "nom: " + c.getNom() + "\n" +
                    "getMarque: " + c.getMarque() + "\n" +
                    "getPrix: " + c.getPrix() + "\n" +
                    "Description: " + c.getDescription() + "\n" +
                    "NbrStock: " + c.getNbrStock() + "\n" +
                    "-----------------------------------\n\n"
            );
        }
        else System.out.println("Produit not found !!");
    }
}
