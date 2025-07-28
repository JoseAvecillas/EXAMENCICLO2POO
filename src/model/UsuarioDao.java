package model;

import java.io.*;
import java.util.*;

public class UsuarioDao {
    private static final String ARCHIVO = "usuarios.txt";

    public static void guardarUsuario(String usuario, String clave) {
        if (usuarioExiste(usuario)) {
            System.out.println("⚠️ Usuario ya existente: " + usuario);
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            bw.write(usuario + ";" + clave);
            bw.newLine();
            System.out.println("✅ Usuario registrado con éxito: " + usuario);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean usuarioExiste(String usuario) {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length >= 1 && datos[0].equalsIgnoreCase(usuario)) {
                    return true; // Existe el usuario (ignorando mayúsculas/minúsculas)
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean verificarLogin(String usuario, String clave) {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 2 && datos[0].equals(usuario) && datos[1].equals(clave)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}