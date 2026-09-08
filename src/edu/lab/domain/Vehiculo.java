package edu.lab.domain;

public abstract class Vehiculo implements Alquilable {
    protected String marca;
    protected String modelo;
    protected double precioPorDia;


    public abstract String obtenerInformacion();

    @Override
    public double calcularPrecio(int dias) {
        return dias * precioPorDia;
    }

    public Vehiculo(){

    }

    public Vehiculo(String marca, String modelo, double precioPorDia) {
        this.marca = marca;
        this.modelo = modelo;
        this.precioPorDia = precioPorDia;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public double getPrecioPorDia() {
        return precioPorDia;
    }
    public void setPrecioPorDia(double precioPorDia) {
        this.precioPorDia = precioPorDia;
    }


}
