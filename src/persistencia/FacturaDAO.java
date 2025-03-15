package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FacturaDAO {
    // Generar una factura
    public void generarFactura(int idPedido) {
        String sql = "INSERT INTO facturas (id_pedido, total) SELECT id, (cantidad * valor_venta) FROM pedidos JOIN productos ON pedidos.producto = productos.nombre WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idPedido);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}