package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    // Agregar un nuevo pedido
    public void agregarPedido(String producto, int cantidad) {
        String sql = "INSERT INTO pedidos (producto, cantidad, estado) VALUES (?, ?, 'Pendiente')";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producto);
            pstmt.setInt(2, cantidad);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Editar un pedido existente
    public void editarPedido(int idPedido, String producto, int cantidad) {
        String sql = "UPDATE pedidos SET producto = ?, cantidad = ? WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producto);
            pstmt.setInt(2, cantidad);
            pstmt.setInt(3, idPedido);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cancelar un pedido
    public void cancelarPedido(int idPedido) {
        String sql = "UPDATE pedidos SET estado = 'Cancelado' WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idPedido);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener lista de pedidos activos
    public List<String> obtenerPedidosActivos() {
        List<String> pedidosActivos = new ArrayList<>();
        String sql = "SELECT id, producto, cantidad FROM pedidos WHERE estado = 'Pendiente'";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String pedido = "ID: " + rs.getInt("id") + 
                               ", Producto: " + rs.getString("producto") + 
                               ", Cantidad: " + rs.getInt("cantidad");
                pedidosActivos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidosActivos;
    }
}