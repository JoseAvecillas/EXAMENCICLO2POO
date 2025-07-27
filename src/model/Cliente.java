// Cliente.java
package model;

public class Cliente {
    private String nombre;
    private String apellido;
    private String cedula;

    public Cliente(String nombre, String apellido, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getCedula() { return cedula; }

    @Override
    public String toString() {
        return nombre + "," + apellido + "," + cedula;
    }
}



