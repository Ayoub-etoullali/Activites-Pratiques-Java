package ma.enset.tpjdbc.dao;

import ma.enset.tpjdbc.dao.entities.Client;

import java.util.List;

public interface ClientDao extends Dao<Client>{
    List<Client> findClientsByNom(String nom);
}
