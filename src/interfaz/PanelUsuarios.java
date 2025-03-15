package interfaz;

import logica.GestorUsuarios;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelUsuarios extends JPanel {
    private GestorUsuarios gestorUsuarios;
    private JTextField txtNombre, txtUsuario, txtContraseña, txtRol;
    private JButton btnAgregar;

    public PanelUsuarios() {
        gestorUsuarios = new GestorUsuarios();

        txtNombre = new JTextField(20);
        txtUsuario = new JTextField(20);
        txtContraseña = new JTextField(20);
        txtRol = new JTextField(20);

        btnAgregar = new JButton("Agregar Usuario");

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String usuario = txtUsuario.getText();
                String contraseña = txtContraseña.getText();
                String rol = txtRol.getText();

                gestorUsuarios.agregarUsuario(nombre, usuario, contraseña, rol);
                JOptionPane.showMessageDialog(null, "Usuario agregado con éxito");
            }
        });

        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Usuario:"));
        add(txtUsuario);
        add(new JLabel("Contraseña:"));
        add(txtContraseña);
        add(new JLabel("Rol:"));
        add(txtRol);
        add(btnAgregar);
    }
}