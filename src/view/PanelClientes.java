package view;

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

        btnGuardar.addActionListener(e -> {
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String cedula = txtCedula.getText().trim();

        if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "⚠️ Todos los campos son obligatorios.");
            return;
        }

        model.Cliente nuevo = new model.Cliente(nombre, apellido, cedula);
        controller.ClienteController controller = new controller.ClienteController();

        try {
            boolean guardado = controller.guardarCliente(nuevo);

            if (guardado) {
                JOptionPane.showMessageDialog(this, "✅ Cliente registrado con éxito.");
                // Limpiar campos
                txtNombre.setText("");
                txtApellido.setText("");
                txtCedula.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "⚠️ La cédula ya está registrada.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "❌ Error al guardar el cliente.");
        }
    });
    }
}