package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    // Validar credenciales de usuario
    public boolean validarUsuario(String usuario, String contraseña) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario);
            pstmt.setString(2, contraseña);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Retorna true si las credenciales son válidas
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Agregar un nuevo usuario
    public void agregarUsuario(String nombre, String usuario, String contraseña, String rol) {
        String sql = "INSERT INTO usuarios (nombre, usuario, contraseña, rol) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, usuario);
            pstmt.setString(3, contraseña);
            pstmt.setString(4, rol);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Bloquear usuario después de intentos fallidos
    public void bloquearUsuario(String usuario) {
        String sql = "UPDATE usuarios SET bloqueado = 1 WHERE usuario = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}