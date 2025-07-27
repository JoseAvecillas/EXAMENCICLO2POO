// Reserva.java
package model;

import java.time.LocalDate;

public class Reserva implements Pago {
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;

    public Reserva(Cliente cliente, Habitacion habitacion, LocalDate entrada, LocalDate salida) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = entrada;
        this.fechaSalida = salida;
    }

    public Cliente getCliente() { return cliente; }
    public Habitacion getHabitacion() { return habitacion; }
    public LocalDate getFechaEntrada() { return fechaEntrada; }
    public LocalDate getFechaSalida() { return fechaSalida; }

    @Override
    public double calcularTotal() {
        long dias = fechaSalida.toEpochDay() - fechaEntrada.toEpochDay();
        double tarifa = switch (habitacion.getTipo()) {
            case INDIVIDUAL -> 30.0;
            case DOBLE -> 50.0;
            case SUITE -> 90.0;
        };
        return dias * tarifa;
    }

    @Override
    public String toString() {
        return cliente.getCedula() + "," + habitacion.getNumero() + "," + fechaEntrada + "," + fechaSalida;
    }
}

