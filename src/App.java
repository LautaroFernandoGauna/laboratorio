import java.time.LocalDate;

import edu.lab.domain.Auto;
import edu.lab.domain.Cliente;
import edu.lab.domain.DetalleReserva;
import edu.lab.domain.EstadoReserva;
import edu.lab.domain.Moto;
import edu.lab.domain.Reserva;

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
            





    }
}
