package logica;

import persistencia.EstadisticasDAO;

public class GestorEstadisticas {
    private EstadisticasDAO estadisticasDAO;

    public GestorEstadisticas() {
        this.estadisticasDAO = new EstadisticasDAO();
    }

    // Generar estadísticas
    public void generarEstadisticas() {
        estadisticasDAO.generarEstadisticas();
    }

    // Exportar estadísticas a PDF
    public void exportarEstadisticas() {
        estadisticasDAO.exportarEstadisticas();
    }
}