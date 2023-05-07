package ma.enset.tpjdbc.dao;

import ma.enset.tpjdbc.dao.entities.Commande;
import ma.enset.tpjdbc.dao.entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao {

    @Override
    public List<Client> findAll()  {
        Connection connection=SingletonConnexionDB.getConnection();
        List<Client> clients=new ArrayList<>();
        try{
        PreparedStatement stm=connection.prepareStatement("select CLT.ID, CLT.NOM, CLT.PRENOM, CLT.AGE, CLT.ID_COMMANDE, COM.ID, COM.NOM as 'NOM_COMMANDE' from CLIENTS CLT,COMMANDES COM where CLT.ID_COMMANDE=COM.ID ");
        ResultSet rs=stm.executeQuery();

        while (rs.next()){
            Client client=new Client();
            client.setId(rs.getInt("ID"));
            client.setNom(rs.getString("NOM"));
            client.setPrenom(rs.getString("PRENOM"));
            client.setAge(rs.getInt("AGE"));
            Commande commande=new Commande();
            commande.setId(rs.getInt("ID_COMMANDE"));
            commande.setNom(rs.getString("NOM_COMMANDE"));
            client.setCommande(commande);
            clients.add(client);
        }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return clients;
    }
    @Override
    public Client findOne(int id)  {
        Connection connection=SingletonConnexionDB.getConnection();
        Client client=new Client();
        try{
            PreparedStatement stm=connection.prepareStatement("select CLT.ID, CLT.NOM, CLT.PRENOM, CLT.AGE, CLT.ID_COMMANDE, COM.ID, COM.NOM as 'NOM_COMMANDE' from CLIENTS CLT,COMMANDES COM where ID=? and CLT.ID_COMMANDE=COM.ID ");
            stm.setInt(1,id);
            ResultSet rs=stm.executeQuery();

            if(rs.next()){
                client.setId(rs.getInt("ID"));
                client.setNom(rs.getString("NOM"));
                client.setPrenom(rs.getString("PRENOM"));
                client.setAge(rs.getInt("AGE"));
                Commande c=new Commande();
                c.setId(rs.getInt("ID_COMMANDE"));
                c.setNom(rs.getString("NOM_COMMANDE"));
                client.setCommande(c);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return client;
    }
    @Override
    public Client save(Client o)  {
        Connection connection=SingletonConnexionDB.getConnection();
        try{
        PreparedStatement pstm=connection.prepareStatement("insert into CLIENTS(NOM,PRENOM,AGE,ID_COMMANDE)" +
                "   values(?,?,?,?)"); //Mapping O-R
        pstm.setString(1,o.getNom());
        pstm.setString(2,o.getPrenom());
        pstm.setInt(3,o.getAge());
        pstm.setInt(4,o.getCommande().getId());
        pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public boolean delete(Client o) {
        try {
            Connection connection=SingletonConnexionDB.getConnection();
            PreparedStatement pstm=connection.prepareStatement("delete from CLIENTS where ID=?");
            pstm.setInt(1,o.getId());
            pstm.executeUpdate();
        }catch (SQLException e){
            return false;
        }

        return true;
    }

    @Override
    public Client update(Client o)  {
        Connection connection=SingletonConnexionDB.getConnection();
        try{
        PreparedStatement pstm=connection.prepareStatement("update CLIENTS set NOM=?,PRENOM=?," +
                "AGE=? where ID=?");
        pstm.setString(1,o.getNom());
        pstm.setString(2,o.getPrenom());
        pstm.setInt(3,o.getAge());
        pstm.setInt(4,o.getId());
        pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public List<Client> findClientsByNom(String nom)  {

        Connection connection=SingletonConnexionDB.getConnection();
        List<Client> clients=new ArrayList<>();
       try{
        PreparedStatement pstm=connection.prepareStatement("select * from CLIENTS where NOM like ?");
        pstm.setString(1,"%"+nom+"%");
        ResultSet rs=pstm.executeQuery();

        while (rs.next()){
            Client client=new Client();
            client.setId(rs.getInt("ID"));
            client.setNom(rs.getString("NOM"));
            client.setPrenom(rs.getString("PRENOM"));
            client.setAge(rs.getInt("AGE"));
            clients.add(client);
        }
       }catch (SQLException e){
           e.printStackTrace();
       }
        return clients;
    }
}
