package main;

import model.*;
import view.*;
import controller.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginVista login = new LoginVista();

            // Mostrar la ventana de login
            login.setVisible(true);

            // Acción del botón "Iniciar Sesión"
            login.btnLogin.addActionListener(e -> {
                String usuario = login.txtUsuario.getText().trim();
                String clave = new String(login.txtClave.getPassword()).trim();

                // 1. Verificar primero en archivo (usuarios registrados)
                if (UsuarioDao.verificarLogin(usuario, clave)) {
                    JOptionPane.showMessageDialog(login, "Login exitoso");
                    login.dispose();
                    abrirMenuPrincipal();
                    return;
                }

                // 2. Verificar usuarios quemados
                Usuario[] usuarios = new Usuario[] {
                    new Administrador("admin", "1234"),
                    new Recepcionista("recep", "1234")
                };

                Usuario encontrado = null;
                for (Usuario u : usuarios) {
                    if (u.getUsuario().equals(usuario) && u.autenticar(clave)) {
                        encontrado = u;
                        break;
                    }
                }

                if (encontrado != null) {
                    JOptionPane.showMessageDialog(login, "Login exitoso");
                    login.dispose();
                    abrirMenuPrincipal();
                } else {
                    JOptionPane.showMessageDialog(login, "Usuario o clave incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            // Acción del botón "Registrarse"
            login.btnRegistrar.addActionListener(e -> {
                new RegistroVista();
            });
        });
    }

    // Método para abrir el menú principal con controladores enlazados
    private static void abrirMenuPrincipal() {
        MenuPrincipalVista menu = new MenuPrincipalVista();
        menu.setVisible(true);

        ClienteController clienteCtrl = new ClienteController();
        HabitacionController habitacionCtrl = new HabitacionController();
        ReservaController reservaCtrl = new ReservaController();

        // CLIENTE
        menu.panelClientes.btnGuardar.addActionListener(a -> {
            try {
                String nom = menu.panelClientes.txtNombre.getText();
                String ape = menu.panelClientes.txtApellido.getText();
                String ced = menu.panelClientes.txtCedula.getText();

                if (nom.isBlank() || ape.isBlank() || ced.isBlank()) {
                    JOptionPane.showMessageDialog(menu, "Todos los campos son obligatorios");
                    return;
                }
                Cliente c = new Cliente(nom, ape, ced);
                clienteCtrl.guardarCliente(c);
                JOptionPane.showMessageDialog(menu, "Cliente guardado");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(menu, "Error al guardar cliente: " + ex.getMessage());
            }
        });

        // HABITACION
        menu.panelHabitaciones.btnGuardar.addActionListener(a -> {
            try {
                int num = Integer.parseInt(menu.panelHabitaciones.txtNumero.getText());
                TipoHabitacion tipo = TipoHabitacion.valueOf((String) menu.panelHabitaciones.cmbTipo.getSelectedItem());
                Habitacion h = new Habitacion(num, tipo);
                habitacionCtrl.guardarHabitacion(h);
                JOptionPane.showMessageDialog(menu, "Habitación guardada");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(menu, "Error al guardar habitación: " + ex.getMessage());
            }
        });

        // RESERVA
        menu.panelReservas.btnReservar.addActionListener(a -> {
            try {
                String ced = menu.panelReservas.txtCedula.getText();
                int num = Integer.parseInt(menu.panelReservas.txtNumero.getText());
                var entrada = java.time.LocalDate.parse(menu.panelReservas.txtEntrada.getText());
                var salida = java.time.LocalDate.parse(menu.panelReservas.txtSalida.getText());

                List<Cliente> clientes = clienteCtrl.cargarClientes();
                List<Habitacion> habitaciones = habitacionCtrl.cargarHabitaciones();
                List<Reserva> reservas = reservaCtrl.cargarReservas(clientes, habitaciones);

                Cliente cli = clientes.stream().filter(c -> c.getCedula().equals(ced)).findFirst().orElse(null);
                Habitacion hab = habitaciones.stream().filter(h -> h.getNumero() == num).findFirst().orElse(null);

                if (cli == null || hab == null) {
                    JOptionPane.showMessageDialog(menu, "Cliente o habitación no encontrados");
                    return;
                }

                Reserva nueva = new Reserva(cli, hab, entrada, salida);
                if (reservaCtrl.reservaSuperpuesta(nueva, reservas)) {
                    JOptionPane.showMessageDialog(menu, "Reserva superpuesta detectada");
                } else {
                    reservaCtrl.guardarReserva(nueva);
                    JOptionPane.showMessageDialog(menu, "Reserva registrada con éxito");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(menu, "Error al reservar: " + ex.getMessage());
            }
        });
    }
}