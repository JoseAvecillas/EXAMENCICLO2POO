package view;

import javax.swing.*;
import java.awt.*;

public class LoginVista extends JFrame {
    public JTextField txtUsuario;
    public JPasswordField txtClave;
    public JButton btnLogin;
    public JButton btnRegistrar; // <--- botón nuevo

    public LoginVista() {
        setTitle("Login de Usuario");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2)); // de 3 a 4 filas

        add(new JLabel("Usuario:"));
        txtUsuario = new JTextField();
        add(txtUsuario);

        add(new JLabel("Clave:"));
        txtClave = new JPasswordField();
        add(txtClave);

        btnLogin = new JButton("Iniciar Sesión");
        add(btnLogin);

        btnRegistrar = new JButton("Registrarse"); // <--- nuevo botón
        add(btnRegistrar);

        setLocationRelativeTo(null);
    }
}