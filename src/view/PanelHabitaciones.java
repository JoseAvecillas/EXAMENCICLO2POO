package view;

import javax.swing.*;
import java.awt.*;

public class PanelHabitaciones extends JPanel {
    public JTextField txtNumero;
    public JComboBox<String> cmbTipo;
    public JButton btnGuardar;

    public PanelHabitaciones() {
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Número:"));
        txtNumero = new JTextField();
        add(txtNumero);

        add(new JLabel("Tipo:"));
        cmbTipo = new JComboBox<>(new String[]{"INDIVIDUAL", "DOBLE", "SUITE"});
        add(cmbTipo);

        btnGuardar = new JButton("Guardar Habitación");
        add(btnGuardar);
    }
}