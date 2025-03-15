package interfaz;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Sistema de Gestión de Restaurante");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Productos", new PanelProductos());
        tabbedPane.addTab("Pedidos", new PanelPedidos());
        tabbedPane.addTab("Facturas", new PanelFacturas());
        tabbedPane.addTab("Estadísticas", new PanelEstadisticas());
        tabbedPane.addTab("Usuarios", new PanelUsuarios());

        add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}