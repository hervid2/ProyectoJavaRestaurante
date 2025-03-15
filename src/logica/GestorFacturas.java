package logica;

import persistencia.FacturaDAO;

public class GestorFacturas {
    private FacturaDAO facturaDAO;

    public GestorFacturas() {
        this.facturaDAO = new FacturaDAO();
    }

    // Generar una factura
    public void generarFactura(int idPedido) {
        facturaDAO.generarFactura(idPedido);
    }
}