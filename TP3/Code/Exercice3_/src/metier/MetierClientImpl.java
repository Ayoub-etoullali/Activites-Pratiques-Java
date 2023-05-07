package metier;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetierClientImpl implements IMetier<Client> {

    List<Client> listClient;
    private String nomFil;

    public MetierClientImpl() {
    }

    public MetierClientImpl(List<Client> listClient, String nomFil) {
        this.listClient = listClient;
        this.nomFil = nomFil;
    }

    public List<Client> getListClient() {
        return listClient;
    }

    public void setListClient(List<Client> listClient) {
        this.listClient = listClient;
    }

    public String getNomFil() {
        return nomFil;
    }

    public void setNomFil(String nomFil) {
        this.nomFil = nomFil;
    }


    //----------------Interface Metier Client-----------------
    @Override
    public Client add(Client c) throws IOException {
        File f = new File("C:\\Users\\pc\\Desktop\\ENSET\\S3\\POO\\POO Java\\TPs\\TP3\\Code\\Exercice3_\\Clients\\" + c.getPrénom() + ".txt");
        FileWriter fw = new FileWriter(f);

        String s= Long.valueOf(c.getId()).toString();
        fw.append(s);
        fw.append(" ");

        fw.append(c.getNom());
        for (int i = 0; i <= 20 - c.getNom().length(); i++) fw.append(" ");

        fw.append(c.getPrénom());
        for (int i = 0; i <= 20 - c.getPrénom().length(); i++) fw.append(" ");

        fw.append(c.getAdresse());
        for (int i = 0; i <= 20 - c.getAdresse().length(); i++) fw.append(" ");

        fw.append(c.getTel());
        for (int i = 0; i <= 20 - c.getTel().length(); i++) fw.append(" ");

        fw.append(c.getEmail());
        for (int i = 0; i <= 20 - c.getEmail().length(); i++) fw.append(" ");

        fw.close();

        return c;
    }

    public List<Client> getAll() throws IOException {
        File Directory = new File("C:\\Users\\pc\\Desktop\\ENSET\\S3\\POO\\POO Java\\TPs\\TP3\\Code\\Exercice3_\\Clients");
        File[] fileClient = Directory.listFiles();
        Client[] client = new Client[10];
        int i = 0;
        for (i=0;i<client.length;i++) client[i] = new Client();

        i = 0;
        for (File f : fileClient) {
            FileReader fr = new FileReader(f);
            int c;
            String str = "";
            while ((c = fr.read()) != -1) {
                str += (char) c;
            }
            fr.close();
            client[i].setId(Long.valueOf(str.substring(0, 2)));
            client[i].setNom(str.substring(3, 23));
            client[i].setPrénom(str.substring(24, 44));
            client[i].setAdresse(str.substring(45, 65));
            client[i].setTel(str.substring(66, 86));
            client[i].setEmail(str.substring(87, 107));
            i++;
        }
        listClient = Arrays.asList(client);
        return listClient;
    }

    @Override
    public Client findById(long id) {
        Client clt = null;
        int i = 0;
        for (Client c : listClient) {
            if (id==c.getId()) clt = listClient.get(i);
            i++;
        }
        if (clt == null) return null;
        return clt;
    }

    @Override
    public void delete(long id) throws IOException {
        File Directory = new File("C:\\Users\\pc\\Desktop\\ENSET\\S3\\POO\\POO Java\\TPs\\TP3\\Code\\Exercice3_\\Clients");
        File[] fileClient = Directory.listFiles();
        listClient = getAll();
        Boolean B = false;
        int i = 0;
        for (File f : fileClient) {
            if (id==listClient.get(i).getId()) {
                B = true;
                f.delete();
            }
            i++;
        }
        if (!B) System.out.println("Client not found !!");
    }

    @Override
    public void saveAll() throws IOException, ClassNotFoundException {
        listClient = getAll();
        for (Client c : listClient) {
            File f1 = new File("C:\\Users\\pc\\Desktop\\ENSET\\S3\\POO\\POO Java\\TPs\\TP3\\Code\\Exercice3_\\" + nomFil + ".dat");
            FileOutputStream fw = new FileOutputStream(f1);
            ObjectOutputStream oos = new ObjectOutputStream(fw);

            oos.writeObject(c);
            oos.close();

            FileInputStream fis = new FileInputStream(f1);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Client p = (Client) ois.readObject();
            System.out.println(p.getPrénom() + " " + p.getNom());
            ois.close();
        }


    }

    @Override
    public void Affiche(List<Client> listClient) {
        for (Client c : listClient) {
            afficheSeul(c);
        }
    }

    @Override
    public void afficheSeul(Client c) {
        if (c != null) {
            System.out.println("---------Client: " + c.getId() + "--------------\n" +
                    "nom: " + c.getNom() + "\n" +
                    "prénom: " + c.getPrénom() + "\n" +
                    "adresse: " + c.getAdresse() + "\n" +
                    "tel: " + c.getTel() + "\n" +
                    "email: " + c.getEmail() + "\n" +
                    "-----------------------------------\n\n"
            );
        } else System.out.println("Client not found !!");
    }
}