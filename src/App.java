import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import edu.lab.domain.Auto;
import edu.lab.domain.Cliente;
import edu.lab.domain.DetalleReserva;
import edu.lab.domain.EstadoReserva;
import edu.lab.domain.Moto;
import edu.lab.domain.Reserva;
import edu.lab.repositorio.Repositorio;

public class App {
    public static void main(String[] args) throws Exception {
        
        Cliente clien1= new Cliente("Raul", "12345678");
        Cliente clien2= new Cliente("Ana", "30111222");
        
        Auto auto1= new Auto("Ford", "Focus", 3000, 4);
        Auto auto2= new Auto("Toyota", "Corolla", 3500, 4);

        Moto moto1 = new Moto("Zanella", "RZ3", 400, 300 );

        DetalleReserva detalleFord= new DetalleReserva(auto1, 
            LocalDate.of(2026, 8, 20), 
            LocalDate.of(2026, 8, 27));

        DetalleReserva detalleMoto= new DetalleReserva(moto1,
            LocalDate.of(2026, 8, 22) ,
            LocalDate.of(2026, 8, 27));

        DetalleReserva detalleToyota= new DetalleReserva(auto2, 
            LocalDate.of(2026, 9, 1),
            LocalDate.of(2026, 9, 4) );

        Reserva reserva1001= new Reserva(1001, 
            LocalDate.of(2026, 8, 22),
            EstadoReserva.CONFIRMADA, clien1, detalleFord );
            
        reserva1001.agregarDetalle(detalleMoto);

        Reserva reservaAna= new Reserva(1002, 
            LocalDate.of(2026, 8, 18), 
            EstadoReserva.PENDIENTE, clien2, detalleToyota);

            Repositorio <Reserva> repositorio= new Repositorio<>();
            repositorio.agregar(reserva1001);
            repositorio.agregar(reservaAna);
            repositorio.verTodo();

            mostrarReserva(repositorio);
            guardarReserva(repositorio);

            //Calcular en un double la suma de los importes de todas las reservas almacenadas.
            double totalFactu= repositorio.stream()
            .mapToDouble(Reserva :: calcularTotal)
            .sum();
            System.out.println("El total generado es de: " + totalFactu);



    }

    private static void mostrarReserva(Repositorio<Reserva> repositorio){
        for (Reserva reserva: repositorio.verTodo()){
            System.out.println("Reserva : " + reserva.getNumero());
            System.out.println("Fecha: " + reserva.getFecha());
            System.out.println("Estado: " + reserva.getEstado());
            System.out.println("Cliente: "+ reserva.getCliente().getNombre() + " \n" 
            + " DNI: " + reserva.getCliente().getDNI());

            for (DetalleReserva detalleReserva: reserva.getDetalles()){
                System.out.println("Vehiculo: " + detalleReserva.getVehiculo().obtenerInformacion());
                System.out.println("Fecha desde: " + detalleReserva.getFechaDesde() + "Hasta : " + detalleReserva.getFechaHasta());
                
            }


        }
        System.out.println("Reservas: " + repositorio.size());

    }


    private static void guardarReserva(Repositorio<Reserva> repositorio){
        for(Reserva reserva: repositorio.verTodo()){
            try (
                FileWriter archivo= new FileWriter("reservas.txt", true);
                PrintWriter escritor= new PrintWriter(archivo)
            ){
                escritor.println("Reserva: " + reserva.getNumero() );
                escritor.println("Fecha " + reserva.getFecha());
                escritor.println("Estado" + reserva.getEstado());
                escritor.println("Cliente: " + reserva.getCliente().getNombre() + 
                " \n" +"DNI: " + 
            reserva.getCliente().getDNI());

            for(DetalleReserva detalles : reserva.getDetalles()){
                escritor.println(detalles.getVehiculo().obtenerInformacion());
                escritor.println("Desde : " + detalles.getFechaDesde() + " \n" + 
            " Hasta : " + detalles.getFechaHasta());
            }
            }catch(IOException e ){
                System.out.println("No se puede guardar la reserva"+ e.getMessage());
            }
        }
        System.out.println("cantidad de reservas: " + repositorio.size());
    }




}



