// ReservaController.java
package controller;

import model.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ReservaController {
    private static final String RUTA = "reservas.txt";

    public void guardarReserva(Reserva r) throws IOException {
        File archivo = new File(RUTA);
        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        FileWriter fw = new FileWriter(archivo, true);
        fw.write(r.toString() + "\n");
        fw.close();
    }


    public List<Reserva> cargarReservas(List<Cliente> clientes, List<Habitacion> habitaciones) throws IOException {
        List<Reserva> lista = new ArrayList<>();
        File archivo = new File(RUTA);
        if (!archivo.exists()) {
            return lista; // Retorna lista vacía si el archivo aún no existe
        }

        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            Cliente cliente = clientes.stream().filter(c -> c.getCedula().equals(partes[0])).findFirst().orElse(null);
            Habitacion habitacion = habitaciones.stream().filter(h -> h.getNumero() == Integer.parseInt(partes[1])).findFirst().orElse(null);
            LocalDate entrada = LocalDate.parse(partes[2]);
            LocalDate salida = LocalDate.parse(partes[3]);
            if (cliente != null && habitacion != null) {
                lista.add(new Reserva(cliente, habitacion, entrada, salida));
            }
        }
        br.close();
        return lista;
    }

    public boolean reservaSuperpuesta(Reserva nueva, List<Reserva> existentes) {
        for (Reserva r : existentes) {
            if (r.getHabitacion().getNumero() == nueva.getHabitacion().getNumero()) {
                if (!(nueva.getFechaSalida().isBefore(r.getFechaEntrada()) || nueva.getFechaEntrada().isAfter(r.getFechaSalida()))) {
                    return true;
                }
            }
        }
        return false;
    }
}
