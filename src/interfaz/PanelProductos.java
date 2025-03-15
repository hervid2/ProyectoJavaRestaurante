package interfaz;

import logica.GestorProductos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelProductos extends JPanel {
    private GestorProductos gestorProductos;
    private JTextField txtNombre, txtIngredientes, txtValorNeto, txtImpuestos;
    private JButton btnAgregar, btnEliminar;

    public PanelProductos() {
        gestorProductos = new GestorProductos();

        txtNombre = new JTextField(20);
        txtIngredientes = new JTextField(20);
        txtValorNeto = new JTextField(20);
        txtImpuestos = new JTextField(20);

        btnAgregar = new JButton("Agregar Producto");
        btnEliminar = new JButton("Eliminar Producto");

        btnAgregar.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String ingredientes = txtIngredientes.getText();
                double valorNeto = Double.parseDouble(txtValorNeto.getText());
                double impuestos = Double.parseDouble(txtImpuestos.getText());

                gestorProductos.agregarProducto(nombre, ingredientes, valorNeto, impuestos);
                JOptionPane.showMessageDialog(null, "Producto agregado con éxito");
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                gestorProductos.eliminarProducto(nombre);
                JOptionPane.showMessageDialog(null, "Producto eliminado con éxito");
            }
        });

        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Ingredientes:"));
        add(txtIngredientes);
        add(new JLabel("Valor Neto:"));
        add(txtValorNeto);
        add(new JLabel("Impuestos:"));
        add(txtImpuestos);
        add(btnAgregar);
        add(btnEliminar);
    }
}
