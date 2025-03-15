package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/restaurante?useSSL=true&requireSSL=true";
    private static final String USER = "root"; // Cambia por tu usuario de MySQL
    private static final String PASSWORD = "password"; // Cambia por tu contraseña de MySQL

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}