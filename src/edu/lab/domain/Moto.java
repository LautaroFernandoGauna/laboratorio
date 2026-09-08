package edu.lab.domain;

public class Moto extends Vehiculo{

    private int cilindrada;


    public double calcularCosto(int dias){
        double total= dias * precioPorDia;
        total*= (dias> 5)? 0.95 : 1;
        return total;
    }
    @Override
    public String obtenerInformacion() {
        
       
       return "Marca : " + marca + " " +
       "Modelo:" + modelo + " " + 
       "Cilindrada: " + cilindrada;
    }
    
    
  
    
    public Moto() {
    
    }

    public Moto(String marca, String modelo, double precioPorDia, int cilindrada) {
        super(marca, modelo, precioPorDia);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }




}
