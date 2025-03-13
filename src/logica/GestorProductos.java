package logica;

import persistencia.ProductoDAO;
import java.util.List;

public class GestorProductos {
    private ProductoDAO productoDAO; // Objeto para interactuar con la base de datos

    public GestorProductos() {
        this.productoDAO = new ProductoDAO(); // Inicializa el DAO de productos
    }

    // Método para agregar un producto
    public void agregarProducto(String nombre, String ingredientes, double valorNeto, double impuestos) {
        double valorVenta = valorNeto + (valorNeto * impuestos); // Calcula el valor de venta
        productoDAO.agregarProducto(nombre, ingredientes, valorNeto, valorVenta, impuestos); // Guarda en la base de datos
    }

    // Método para obtener todos los productos
    public List<String> obtenerProductos() {
        return productoDAO.obtenerProductos(); // Consulta la base de datos
    }

    // Método para eliminar un producto
    public void eliminarProducto(String nombre) {
        productoDAO.eliminarProducto(nombre); // Elimina de la base de datos
    }
}