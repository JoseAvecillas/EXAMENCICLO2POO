// ClienteController.java
package controller;

import model.Cliente;
import java.io.*;
import java.util.*;

public class ClienteController {
    private static final String RUTA = "clientes.txt";

    public boolean guardarCliente(Cliente c) throws IOException {
        List<Cliente> lista = cargarClientes();

        for (Cliente cliente : lista) {
            if (cliente.getCedula().equals(c.getCedula())) {
                return false; // Cédula ya registrada, no guardar
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA, true))) {
            bw.write(c.toString());
            bw.newLine();
        }
        return true; // Guardado correctamente
    }

    public List<Cliente> cargarClientes() throws IOException {
        List<Cliente> lista = new ArrayList<>();
        File archivo = new File(RUTA);

        if (!archivo.exists()) return lista; // Retorna lista vacía si no existe

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    lista.add(new Cliente(partes[0], partes[1], partes[2]));
                }
            }
        }
        return lista;
    }
}


