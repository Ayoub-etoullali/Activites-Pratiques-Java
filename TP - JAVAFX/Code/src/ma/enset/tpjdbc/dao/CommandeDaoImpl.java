package ma.enset.tpjdbc.dao;

import ma.enset.tpjdbc.dao.entities.Commande;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommandeDaoImpl implements CommandeDao {

    @Override
    public List<Commande> findAll() {
        Connection connection=SingletonConnexionDB.getConnection();
        List<Commande> commandes=new ArrayList<>();
        try{
            PreparedStatement stm=connection.prepareStatement("select * from COMMANDES");
            ResultSet rs=stm.executeQuery();

            while (rs.next()){
                Commande c=new Commande();
                c.setId(rs.getInt("ID"));
                c.setNom(rs.getString("NOM"));
                commandes.add(c);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return commandes;
    }

    @Override
    public Commande findOne(int id) {
        Connection connection=SingletonConnexionDB.getConnection();
        Commande c=new Commande();
        try{
            PreparedStatement stm=connection.prepareStatement("select * from COMMANDES where ID=?");
            stm.setInt(1,id);
            ResultSet rs=stm.executeQuery();

            if(rs.next()){
                c.setId(rs.getInt("ID"));
                c.setNom(rs.getString("NOM"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public Commande save(Commande o) {
        Connection connection=SingletonConnexionDB.getConnection();
        try{
            PreparedStatement pstm=connection.prepareStatement("insert into COMMANDES(NOM) values(?)"); //Mapping
            pstm.setString(1,o.getNom());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public boolean delete(Commande o) {
        try {
            Connection connection=SingletonConnexionDB.getConnection();
            PreparedStatement pstm=connection.prepareStatement("delete from COMMANDES where ID=?");
            pstm.setInt(1,o.getId());
            pstm.executeUpdate();
        }catch (SQLException e){
            return false;
        }

        return true;
    }

    @Override
    public Commande update(Commande o) {
        Connection connection=SingletonConnexionDB.getConnection();
        try{
            PreparedStatement pstm=connection.prepareStatement("update COMMANDES set NOM=? where ID=?");
            pstm.setString(1,o.getNom());
            pstm.setInt(2,o.getId());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return o;
    }
}
