package view;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import model.Usuario;
import model.UsuarioDao;

public class RegistroVista extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtClave;
    private JButton btnGuardar;

    public RegistroVista() {
        setTitle("Registro de Usuario");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Nuevo Usuario:"));
        txtUsuario = new JTextField();
        add(txtUsuario);

        add(new JLabel("Nueva Clave:"));
        txtClave = new JPasswordField();
        add(txtClave);

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> registrarUsuario());
        add(btnGuardar);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void registrarUsuario() {
        String usuario = txtUsuario.getText().trim();
        String clave = new String(txtClave.getPassword()).trim();

        if (usuario.isEmpty() || clave.isEmpty()) {
            JOptionPane.showMessageDialog(this, "⚠️ Todos los campos son obligatorios.");
            return;
        }

        if (UsuarioDao.usuarioExiste(usuario)) {
            JOptionPane.showMessageDialog(this, "⚠️ El usuario ya existe. Intenta con otro nombre.");
            return;
        }

        UsuarioDao.guardarUsuario(usuario, clave);
        JOptionPane.showMessageDialog(this, "✅ Usuario registrado correctamente.");
        dispose(); // Cierra la ventana después del registro
    }
}