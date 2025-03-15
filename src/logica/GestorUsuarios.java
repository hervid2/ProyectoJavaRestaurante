package logica;

import persistencia.UsuarioDAO;

public class GestorUsuarios {
    private UsuarioDAO usuarioDAO;

    public GestorUsuarios() {
        this.usuarioDAO = new UsuarioDAO();
    }

    // Validar credenciales de usuario
    public boolean validarUsuario(String usuario, String contraseña) {
        return usuarioDAO.validarUsuario(usuario, contraseña);
    }

    // Agregar un nuevo usuario
    public void agregarUsuario(String nombre, String usuario, String contraseña, String rol) {
        usuarioDAO.agregarUsuario(nombre, usuario, contraseña, rol);
    }

    // Bloquear usuario después de intentos fallidos
    public void bloquearUsuario(String usuario) {
        usuarioDAO.bloquearUsuario(usuario);
    }
}