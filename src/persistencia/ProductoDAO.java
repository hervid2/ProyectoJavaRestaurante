package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    public void agregarProducto(String nombre, String ingredientes, double valorNeto, double valorVenta, double impuestos) {
        String sql = "INSERT INTO productos (nombre, ingredientes, valor_neto, valor_venta, impuestos) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, ingredientes);
            pstmt.setDouble(3, valorNeto);
            pstmt.setDouble(4, valorVenta);
            pstmt.setDouble(5, impuestos);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> obtenerProductos() {
        List<String> productos = new ArrayList<>();
        String sql = "SELECT nombre FROM productos";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                productos.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    public void eliminarProducto(String nombre) {
        String sql = "DELETE FROM productos WHERE nombre = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}