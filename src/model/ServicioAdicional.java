// ServicioAdicional.java
package model;

public class ServicioAdicional implements Pago {
    private String nombre;
    private double precio;

    public ServicioAdicional(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public double calcularTotal() {
        return precio;
    }

    @Override
    public String toString() {
        return nombre + "," + precio;
    }
}