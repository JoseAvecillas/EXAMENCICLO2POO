package vista;

import javax.swing.*;

public class MenuPrincipalVista extends JFrame {
    public JTabbedPane pestañas;

    public MenuPrincipalVista() {
        setTitle("Sistema de Reservas de Hotel");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pestañas = new JTabbedPane();
        pestañas.addTab("Clientes", new PanelClientes());
        pestañas.addTab("Habitaciones", new PanelHabitaciones());
        pestañas.addTab("Reservas", new PanelReservas());

        add(pestañas);
        setLocationRelativeTo(null);
    }
}