package interfaz;

import logica.GestorPedidos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPedidos extends JPanel {
    private GestorPedidos gestorPedidos;
    private JTextField txtProducto, txtCantidad, txtIdPedido;
    private JButton btnAgregar, btnEditar, btnCancelar;

    public PanelPedidos() {
        gestorPedidos = new GestorPedidos();

        txtProducto = new JTextField(20);
        txtCantidad = new JTextField(20);
        txtIdPedido = new JTextField(20); // Campo para el ID del pedido

        btnAgregar = new JButton("Agregar Pedido");
        btnEditar = new JButton("Editar Pedido");
        btnCancelar = new JButton("Cancelar Pedido");

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String producto = txtProducto.getText();
                int cantidad = Integer.parseInt(txtCantidad.getText());
                gestorPedidos.agregarPedido(producto, cantidad);
                JOptionPane.showMessageDialog(null, "Pedido agregado con éxito");
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idPedido = Integer.parseInt(txtIdPedido.getText()); // Obtener el ID del pedido
                String producto = txtProducto.getText();
                int cantidad = Integer.parseInt(txtCantidad.getText());
                gestorPedidos.editarPedido(idPedido, producto, cantidad);
                JOptionPane.showMessageDialog(null, "Pedido editado con éxito");
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idPedido = Integer.parseInt(txtIdPedido.getText()); // Obtener el ID del pedido
                gestorPedidos.cancelarPedido(idPedido);
                JOptionPane.showMessageDialog(null, "Pedido cancelado con éxito");
            }
        });

        add(new JLabel("ID del Pedido:"));
        add(txtIdPedido);
        add(new JLabel("Producto:"));
        add(txtProducto);
        add(new JLabel("Cantidad:"));
        add(txtCantidad);
        add(btnAgregar);
        add(btnEditar);
        add(btnCancelar);
    }
}