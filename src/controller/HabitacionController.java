// HabitacionController.java
package controller;

import model.*;
import java.io.*;
import java.util.*;

public class HabitacionController {
    private static final String RUTA = "habitaciones.txt";

    public void guardarHabitacion(Habitacion h) throws IOException {
        FileWriter fw = new FileWriter(RUTA, true);
        fw.write(h.toString() + "\n");
        fw.close();
    }

    public List<Habitacion> cargarHabitaciones() throws IOException {
        List<Habitacion> lista = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(RUTA));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            int num = Integer.parseInt(partes[0]);
            TipoHabitacion tipo = TipoHabitacion.valueOf(partes[1]);
            boolean disponible = Boolean.parseBoolean(partes[2]);
            Habitacion h = new Habitacion(num, tipo);
            h.setDisponible(disponible);
            lista.add(h);
        }
        br.close();
        return lista;
    }
}
