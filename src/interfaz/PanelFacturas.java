package interfaz;

import logica.GestorFacturas;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelFacturas extends JPanel {
    private GestorFacturas gestorFacturas;
    private JTextField txtPedidoId;
    private JButton btnGenerarFactura;

    public PanelFacturas() {
        gestorFacturas = new GestorFacturas();

        txtPedidoId = new JTextField(20);
        btnGenerarFactura = new JButton("Generar Factura");

        btnGenerarFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pedidoId = Integer.parseInt(txtPedidoId.getText());
                gestorFacturas.generarFactura(pedidoId);
                JOptionPane.showMessageDialog(null, "Factura generada con éxito");
            }
        });

        add(new JLabel("ID del Pedido:"));
        add(txtPedidoId);
        add(btnGenerarFactura);
    }
}