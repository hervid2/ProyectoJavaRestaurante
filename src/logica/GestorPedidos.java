package logica;

import persistencia.PedidoDAO;
import java.util.List;

public class GestorPedidos {
    private PedidoDAO pedidoDAO;

    public GestorPedidos() {
        this.pedidoDAO = new PedidoDAO();
    }

    // Agregar un nuevo pedido
    public void agregarPedido(String producto, int cantidad) {
        pedidoDAO.agregarPedido(producto, cantidad);
    }

    // Editar un pedido existente (necesita el ID del pedido)
    public void editarPedido(int idPedido, String producto, int cantidad) {
        pedidoDAO.editarPedido(idPedido, producto, cantidad);
    }

    // Cancelar un pedido (necesita el ID del pedido)
    public void cancelarPedido(int idPedido) {
        pedidoDAO.cancelarPedido(idPedido);
    }

    // Obtener lista de pedidos activos
    public List<String> obtenerPedidosActivos() {
        return pedidoDAO.obtenerPedidosActivos();
    }
}
