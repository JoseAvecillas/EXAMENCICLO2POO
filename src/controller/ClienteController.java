// ClienteController.java
package controller;

import model.Cliente;
import java.io.*;
import java.util.*;

public class ClienteController {
    private static final String RUTA = "clientes.txt";

    public void guardarCliente(Cliente c) throws IOException {
        FileWriter fw = new FileWriter(RUTA, true);
        fw.write(c.toString() + "\n");
        fw.close();
    }

    public List<Cliente> cargarClientes() throws IOException {
        List<Cliente> lista = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(RUTA));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            if (partes.length == 3)
                lista.add(new Cliente(partes[0], partes[1], partes[2]));
        }
        br.close();
        return lista;
    }
}


