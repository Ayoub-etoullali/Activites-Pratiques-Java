package ma.enset.tpjdbc.services;

import ma.enset.tpjdbc.dao.CommandeDao;
import ma.enset.tpjdbc.dao.ClientDao;
import ma.enset.tpjdbc.dao.entities.Commande;
import ma.enset.tpjdbc.dao.entities.Client;

import java.util.List;

public class GestionServiceImpl implements GestionService {
    private ClientDao clientDao;
    private CommandeDao commandeDao;

    public GestionServiceImpl(ClientDao Pdao, CommandeDao Cdao){
        this.clientDao =Pdao;
        this.commandeDao =Cdao;
    }

    @Override
    public List<Client> getAllClients() {
        return clientDao.findAll();
    }

    @Override
    public void addCLient(Client p) {
       clientDao.save(p);
    }

    @Override
    public void deleteClient(Client p) {
       clientDao.delete(p);
    }

    @Override
    public List<Client> getClientsParNom(String nom) {
        return clientDao.findClientsByNom(nom);
    }

    @Override
    public List<Commande> getAllCommandes() {
        return commandeDao.findAll();
    }

    @Override
    public Commande getCommandeById(int id) {
        return commandeDao.findOne(id);
    }

    @Override
    public void addCommande(Commande c) {
        commandeDao.save(c);
    }

    @Override
    public void removeCommande(Commande c) {
        commandeDao.delete(c);
    }
}
