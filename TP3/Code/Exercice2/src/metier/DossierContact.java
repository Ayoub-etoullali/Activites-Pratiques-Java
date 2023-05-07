package metier;

import java.io.*;
import java.lang.*;
import java.util.*;

public class DossierContact {

    File contact=new File("C:\\Users\\pc\\Desktop\\ENSET\\S3\\POO\\POO Java\\TPs\\TP3\\Code\\Exercice2\\Contacts");
    File[] nom=contact.listFiles();
    ArrayList<String> numTele=new ArrayList<>();

    public DossierContact() throws IOException {

    }

    public File getContact() {
        return contact;
    }

    public void setContact(File contact) {
        this.contact = contact;
    }
    public File[] getNom() {
        return nom;
    }

    public void setNom(File[] nom) {
        this.nom = nom;
    }

    public ArrayList<String> getNumTele() {
        return numTele;
    }

    public void setNumTele(ArrayList<String> numTele) {
        this.numTele = numTele;
    }

    public String ajouterContact(String nomcontact,String numContact) throws IOException {
        int i=0;
        String str=contact.getPath()+"\\"+nomcontact+".txt";

        File f2=new File(str);
        FileWriter fw=new FileWriter(f2,true);
        fw.write(numContact);
        fw.close();

        return nomcontact;
    }

    public String suppContact(String contact) {
        Boolean B = false;
        for (File f:nom) {
            if (f.getName().substring(0,f.getName().length()-4).equals(contact)){
                System.out.println("@");
                f.delete();
                B = true;
            }
        }
        if (B==false) System.out.println(" cette contact n'esxiste pas !! ");
        return contact;
    }

    public Boolean rechContactNom(String nomContact) {
        String nc=contact.getPath()+"\\"+nomContact+".txt";
        Boolean B = false;
        for (File c : nom) {
            if (nc.equals(c.getPath())) {
                B = true;
            }
        }
        return B;
    }

    public String changeNumTele(String nomct, String numtele) throws IOException {
        int i = 0;
        String nc=contact.getPath()+"\\"+nomct+".txt";
        for (File n : nom) {
            if (n.toString().equals(nc)) {

                n.delete();
                File f2=new File(nc);
                FileWriter fw=new FileWriter(f2,true);
                fw.write(numtele);
                fw.close();

                i++;
            }
        }
        for (int j=0;j<numTele.size();j++) System.out.println(numTele.get(j));
        return numtele;
    }
}

