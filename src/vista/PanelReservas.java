package vista;

import javax.swing.*;
import java.awt.*;

public class PanelReservas extends JPanel {
    public JTextField txtCedula;
    public JTextField txtNumero;
    public JTextField txtEntrada, txtSalida;
    public JButton btnReservar;

    public PanelReservas() {
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Cédula Cliente:"));
        txtCedula = new JTextField();
        add(txtCedula);

        add(new JLabel("Número Habitación:"));
        txtNumero = new JTextField();
        add(txtNumero);

        add(new JLabel("Fecha Entrada (YYYY-MM-DD):"));
        txtEntrada = new JTextField();
        add(txtEntrada);

        add(new JLabel("Fecha Salida (YYYY-MM-DD):"));
        txtSalida = new JTextField();
        add(txtSalida);

        btnReservar = new JButton("Reservar");
        add(btnReservar);
    }
}