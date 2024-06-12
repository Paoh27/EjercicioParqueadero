import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero(10); // Se crea un parqueadero con tarifa $10 por hora

        int opcion;
        do {
            System.out.println("\n-- Menú --");
            System.out.println("1. Ingresar un carro al parqueadero");
            System.out.println("2. Dar salida a un carro del parqueadero");
            System.out.println("3. Informar los ingresos del parqueadero");
            System.out.println("4. Consultar la cantidad de puestos disponibles");
            System.out.println("5. Avanzar el reloj del parqueadero");
            System.out.println("6. Cambiar la tarifa del parqueadero");
            System.out.println("7. Salir");
            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la placa del carro: ");
                    String placa = scanner.next();
                    System.out.print("Ingrese la hora de entrada del carro (entre 6 y 21): ");
                    int horaEntrada = scanner.nextInt();
                    parqueadero.ingresarCarro(new Carro(placa, horaEntrada));
                    break;
                case 2:
                    System.out.print("Ingrese la placa del carro a sacar: ");
                    String placaSalida = scanner.next();
                    parqueadero.darSalidaCarro(placaSalida);
                    break;
                case 3:
                    double ingresos = parqueadero.informarIngresos();
                    System.out.println("Ingresos del parqueadero: $" + ingresos);
                    break;
                case 4:
                    int puestosDisponibles = parqueadero.consultarPuestosDisponibles();
                    System.out.println("Puestos disponibles: " + puestosDisponibles);
                    break;
                case 5:
                    // Implementar avanzar el reloj del parqueadero si es necesario
                    System.out.println("Avanzar el reloj del parqueadero...");
                    break;
                case 6:
                    System.out.print("Ingrese la nueva tarifa del parqueadero: ");
                    double nuevaTarifa = scanner.nextDouble();
                    parqueadero.cambiarTarifa(nuevaTarifa);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida, por favor ingrese una opción válida.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}
