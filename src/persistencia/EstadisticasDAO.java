package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstadisticasDAO {
    // Generar estadísticas
    public void generarEstadisticas() {
        String sql = "SELECT producto, COUNT(*) as ventas FROM pedidos GROUP BY producto ORDER BY ventas DESC";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Producto: " + rs.getString("producto") + ", Ventas: " + rs.getInt("ventas"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Exportar estadísticas a PDF
    public void exportarEstadisticas() {
        // Implementación de exportación a PDF (usando librerías como iText)
    }
}