package dao;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionBase {

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/mercado", "root", "");
        } catch (Exception erro) {
            throw new RuntimeException("Erro 1 " + erro);
        }

    }
}
