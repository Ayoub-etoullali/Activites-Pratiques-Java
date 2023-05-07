package metier;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetierClientImpl implements IMetierClient {

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
    public Client addClient(Client c) throws IOException {
        File f=new File("C:\\Users\\pc\\Desktop\\ENSET\\S3\\POO\\POO Java\\TPs\\TP3\\Code\\Exercice3\\Clients\\"+c.getPrénom()+".txt");
        FileWriter fw=new FileWriter(f);

        fw.append(c.getId());
        for (int i=0;i<=1-c.getId().length();i++) fw.append(" ");

        fw.append(c.getNom());
        for (int i=0;i<=19-c.getNom().length();i++) fw.append(" ");

        fw.append(c.getPrénom());
        for (int i=0;i<=19-c.getPrénom().length();i++) fw.append(" ");

        fw.append(c.getAdresse());
        for (int i=0;i<=19-c.getAdresse().length();i++) fw.append(" ");

        fw.append(c.getTel());
        for (int i=0;i<=19-c.getTel().length();i++) fw.append(" ");

        fw.append(c.getEmail());
        for (int i=0;i<=19-c.getEmail().length();i++) fw.append(" ");

        fw.close();

        return c;
    }

    public List<Client> getAllClients() throws IOException {
        MetierClientImpl clients=new MetierClientImpl();
        listClient=clients.introduce();
        return listClient;
    }

    @Override
    public Client findClientById(String id) {
        Client clt=null;
        int i=0;
        for(Client c:listClient){
            if(id.equals(listClient.get(i).getId())) clt=listClient.get(i);
            i++;
        }
        if(clt==null) return null;
        return clt;
    }

    @Override
    public void deleteClient(String id) throws IOException {
        File Directory = new File("C:\\Users\\pc\\Desktop\\ENSET\\S3\\POO\\POO Java\\TPs\\TP3\\Code\\Exercice3\\Clients");
        File[] fileClient = Directory.listFiles();
        //listClient=getAllClients();
        Boolean B=false;
        int i=0;
        for(File f:fileClient){
            if(id.equals(listClient.get(i).getId())) {
                B=true;
                f.delete();
            }
            i++;
        }
        if(!B) System.out.println("Client not found !!");
    }

    @Override
    public void saveAllClients() throws IOException, ClassNotFoundException {
        listClient=getAllClients();
        for (Client c: listClient){
            File f1 = new File("C:\\Users\\pc\\Desktop\\ENSET\\S3\\POO\\POO Java\\TPs\\TP3\\Code\\Exercice3\\clients.dat");
            FileOutputStream fw = new FileOutputStream(f1);
            ObjectOutputStream oos = new ObjectOutputStream(fw);

            oos.writeObject(c);
            oos.close();

            FileInputStream fis=new FileInputStream(f1);
            ObjectInputStream ois=new ObjectInputStream(fis);

            Client p=(Client) ois.readObject();
            System.out.println(p.getPrénom()+" "+p.getNom());
            ois.close();
        }


    }

        public List<Client> introduce() throws IOException {
            File Directory = new File("C:\\Users\\pc\\Desktop\\ENSET\\S3\\POO\\POO Java\\TPs\\TP3\\Code\\Exercice3\\Clients");
            File[] fileClient = Directory.listFiles();
            Client[] client = new Client[10];
            int i = 0;
            for (Client c : client) {
                client[i]=new Client();
                i++;
            }
            i=0;
            for (File f : fileClient) {
                FileReader fr = new FileReader(f);
                int c;
                String str = "";
                while ((c = fr.read()) != -1) {
                    str += (char) c;
                }
                fr.close();
                client[i].setId(str.substring(0, 1));
                client[i].setNom(str.substring(2, 20));
                client[i].setPrénom(str.substring(22, 40));
                client[i].setAdresse(str.substring(42, 60));
                client[i].setTel(str.substring(62, 80));
                client[i].setEmail(str.substring(82, 99));
                i++;
            }
            listClient = Arrays.asList(client);
            return listClient;
        }
        public void Affiche(List<Client> listClient){
            for (Client c : listClient) {
                afficheClt(c);
            }
        }
    public void afficheClt(Client c){
        if (c!=null){
            System.out.println("---------Client: " + c.getId() + "--------------\n" +
                    "nom: " + c.getNom() + "\n" +
                    "prénom: " + c.getPrénom() + "\n" +
                    "adresse: " + c.getAdresse() + "\n" +
                    "tel: " + c.getTel() + "\n" +
                    "email: " + c.getEmail() + "\n" +
                    "-----------------------------------\n\n"
            );
        }
        else System.out.println("Client not found !!");
    }
    }
