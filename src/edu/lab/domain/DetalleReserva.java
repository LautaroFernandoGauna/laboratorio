package edu.lab.domain;

import java.time.LocalDate;

public class DetalleReserva {
    protected Vehiculo vehiculo;
    protected LocalDate fechaDesde;
    protected LocalDate fechaHasta;
    protected double precioPactado;

    
    public DetalleReserva(Vehiculo vehiculo, LocalDate fechaDesde, LocalDate fechaHasta, double precioPactado) {
        this.vehiculo = vehiculo;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.precioPactado = precioPactado;
    }
    
    public DetalleReserva(Vehiculo vehiculo, LocalDate fechaDesde, LocalDate fechaHasta) {
        this.vehiculo = vehiculo;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public LocalDate getFechaDesde() {
        return fechaDesde;
    }
    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }
    public LocalDate getFechaHasta() {
        return fechaHasta;
    }
    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
    public double getPrecioPactado() {
        return precioPactado;
    }
    public void setPrecioPactado(double precioPactado) {
        this.precioPactado = precioPactado;
    }

}
