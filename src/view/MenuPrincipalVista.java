package view;

import javax.swing.*;

public class MenuPrincipalVista extends JFrame {
    public JTabbedPane pestañas;
    public PanelClientes panelClientes;
    public PanelHabitaciones panelHabitaciones;
    public PanelReservas panelReservas;

    public MenuPrincipalVista() {
        setTitle("Sistema de Reservas de Hotel");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pestañas = new JTabbedPane();

        // Instancias de los paneles y se guardan en atributos
        panelClientes = new PanelClientes();
        panelHabitaciones = new PanelHabitaciones();
        panelReservas = new PanelReservas();

        pestañas.addTab("Clientes", panelClientes);
        pestañas.addTab("Habitaciones", panelHabitaciones);
        pestañas.addTab("Reservas", panelReservas);

        add(pestañas);
        setLocationRelativeTo(null);
    }
}