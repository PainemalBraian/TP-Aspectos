package aop.ejercicio3.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/concursos?allowPublicKeyRetrieval=true&useSSL=false", "yo", "contrasena");
    }

}
