package interfaz;

import logica.GestorEstadisticas;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelEstadisticas extends JPanel {
    private GestorEstadisticas gestorEstadisticas;
    private JButton btnGenerarEstadisticas, btnExportarEstadisticas;

    public PanelEstadisticas() {
        gestorEstadisticas = new GestorEstadisticas();

        btnGenerarEstadisticas = new JButton("Generar Estadísticas");
        btnExportarEstadisticas = new JButton("Exportar Estadísticas");

        btnGenerarEstadisticas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestorEstadisticas.generarEstadisticas();
                JOptionPane.showMessageDialog(null, "Estadísticas generadas con éxito");
            }
        });

        btnExportarEstadisticas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestorEstadisticas.exportarEstadisticas();
                JOptionPane.showMessageDialog(null, "Estadísticas exportadas con éxito");
            }
        });

        add(btnGenerarEstadisticas);
        add(btnExportarEstadisticas);
    }
}