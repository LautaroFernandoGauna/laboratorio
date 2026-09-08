package edu.lab.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private int numero;
    private LocalDate fecha;
    private EstadoReserva estado;
    private Cliente cliente;
    private List<DetalleReserva> detalles;
    

    

    public Reserva() {
    }
    
    public Reserva(int numero, LocalDate fecha, EstadoReserva estado, Cliente cliente, DetalleReserva detalles) {
        this.numero = numero;
        this.fecha = fecha;
        this.estado = estado;
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
        this.detalles.add(detalles);
    }

    public void agregarDetalle(DetalleReserva detalle){
        this.detalles.add(detalle);
    }
    public double calcularTotal() {
        return detalles.stream()
                .mapToDouble(detalle -> {
                    int dias = (int) ChronoUnit.DAYS.between(
                            detalle.getFechaDesde(),
                            detalle.getFechaHasta());
                    return detalle.getVehiculo().calcularPrecio(dias);})
                .sum();
    }    

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public EstadoReserva getEstado() {
        return estado;
    }
    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public List<DetalleReserva> getDetalles() {
        return detalles;
    }
    public void setDetalles(List<DetalleReserva> detalles) {
        this.detalles = detalles;
    }
    

}
