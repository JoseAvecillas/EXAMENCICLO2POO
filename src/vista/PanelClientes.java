package vista;

import javax.swing.*;
import java.awt.*;

public class PanelClientes extends JPanel {
    public JTextField txtNombre, txtApellido, txtCedula;
    public JButton btnGuardar;

    public PanelClientes() {
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        add(txtApellido);

        add(new JLabel("Cédula:"));
        txtCedula = new JTextField();
        add(txtCedula);

        btnGuardar = new JButton("Guardar Cliente");
        add(btnGuardar);
    }
}