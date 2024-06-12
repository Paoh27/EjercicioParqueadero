import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero(10.0);

        // Ingresar carros
        Carro carro1 = new Carro("ABC123", LocalTime.of(8, 0));
        Carro carro2 = new Carro("PB1234", LocalTime.of(9, 0));
        Carro carro3 = new Carro("DEF567", LocalTime.of(10, 0));
        
        parqueadero.ingresarCarro(carro1);
        parqueadero.ingresarCarro(carro2);
        parqueadero.ingresarCarro(carro3);

        // Avanzar el reloj
        parqueadero.avanzarReloj(4);

        // Dar salida a un carro
        parqueadero.darSalidaCarro("ABC123");

        // Consultar ingresos
        System.out.println("Ingresos: " + parqueadero.darIngresos());

        // Consultar puestos disponibles
        System.out.println("Puestos disponibles: " + parqueadero.puestosDisponibles());

        // Consultar tiempo promedio
        System.out.println("Tiempo promedio: " + parqueadero.darTiempoPromedio());

        // Consultar carro con más horas
        Carro carroMasHoras = parqueadero.carroConMasHoras();
        if (carroMasHoras != null) {
            System.out.println("Carro con más horas: " + carroMasHoras.getPlaca());
        } else {
            System.out.println("No hay carros en el parqueadero.");
        }

        // Consultar si hay carros más de 8 horas
        System.out.println("Hay carro más de 8 horas: " + parqueadero.hayCarroMasDeOchoHoras());

        // Consultar carros más de 3 horas
        System.out.println("Carros más de 3 horas: " + parqueadero.darCarrosMasDeTresHorasParqueados().size());

        // Consultar si hay carros con placa igual
        System.out.println("Hay carros con placa igual: " + parqueadero.hayCarrosPlacaIgual());

        // Consultar carros con placa PB
        System.out.println(parqueadero.metodo1());

        // Desocupar parqueadero
        System.out.println(parqueadero.metodo2());
    }
}
