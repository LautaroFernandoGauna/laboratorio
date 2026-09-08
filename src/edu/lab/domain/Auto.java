package edu.lab.domain;

public class Auto extends Vehiculo{
    private int cantidadPuertas;
    
    
    public double calcularPrecio(int dias){
        double total= precioPorDia * dias;
        total*= (dias>7)?0.90 : 1;
        return total;
    }

    @Override
    public String obtenerInformacion() {
       return "marca: " + marca +
       "Modelo: " + modelo +
       "Puertas: " + cantidadPuertas;
    }

    public Auto(){

    }

    public Auto(String marca, String modelo, double precioPorDia, int cantidadPuertas) {
        super(marca, modelo, precioPorDia);
        this.cantidadPuertas = cantidadPuertas;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }






    


}
