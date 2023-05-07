package ma.enset.tpjdbc.dao;

import java.sql.*;

public class SingletonConnexionDB {
    private static Connection connection;
    static {
        //charger le pilote JDBC pour MYSQL
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //établir la connexion avec la bd
             connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/DB_CLIENTS","root","");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
