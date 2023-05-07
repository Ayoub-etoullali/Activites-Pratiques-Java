package ma.enset.tpjdbc.services;

import ma.enset.tpjdbc.dao.entities.Commande;
import ma.enset.tpjdbc.dao.entities.Client;

import java.util.List;

public interface GestionService {

    //=> les Clients
    List<Client> getAllClients();
    void addCLient(Client p);
    void deleteClient(Client p);
    List<Client> getClientsParNom(String nom);

    //=> les Commandes
    List<Commande> getAllCommandes();
    Commande getCommandeById(int id);
    void addCommande(Commande c);
    void removeCommande(Commande c);
}
