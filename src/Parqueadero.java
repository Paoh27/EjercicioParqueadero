import java.util.ArrayList;

public class Parqueadero {
    private static final int NUMERO_PUESTOS = 40;
    private static final int APERTURA = 6;
    private static final int CIERRE = 21;

    private ArrayList<Puesto> puestos;
    private double tarifa;

    public Parqueadero(double tarifa) {
        this.tarifa = tarifa;
        puestos = new ArrayList<>();
        for (int i = 1; i <= NUMERO_PUESTOS; i++) {
            puestos.add(new Puesto(i));
        }
    }

    public void ingresarCarro(Carro carro) {
        for (Puesto puesto : puestos) {
            if (!puesto.estaOcupado()) {
                puesto.parquearCarro(carro);
                return;
            }
        }
        System.out.println("Parqueadero lleno, no se puede ingresar el carro.");
    }

    public void darSalidaCarro(String placa) {
        for (Puesto puesto : puestos) {
            Carro carro = puesto.getCarro();
            if (carro != null && carro.getPlaca().equals(placa)) {
                puesto.sacarCarro();
                System.out.println("Carro con placa " + placa + " ha salido del parqueadero.");
                return;
            }
        }
        System.out.println("No se encontró ningún carro con la placa " + placa + " en el parqueadero.");
    }

    public double informarIngresos() {
        double ingresos = 0;
        for (Puesto puesto : puestos) {
            Carro carro = puesto.getCarro();
            if (carro != null) {
                int horas = CIERRE - carro.getHoraEntrada();
                ingresos += horas * tarifa;
            }
        }
        return ingresos;
    }

    public int consultarPuestosDisponibles() {
        int disponibles = 0;
        for (Puesto puesto : puestos) {
            if (!puesto.estaOcupado()) {
                disponibles++;
            }
        }
        return disponibles;
    }

    public void avanzarReloj() {
        // Implementación para avanzar el reloj del parqueadero, si es necesario
    }

    public void cambiarTarifa(double nuevaTarifa) {
        this.tarifa = nuevaTarifa;
        System.out.println("Tarifa cambiada a: " + nuevaTarifa);
    }

    // Implementación de los métodos adicionales solicitados:
    // 2.1 - darTiempoPromedio()
    public double darTiempoPromedio() {
        // Implementación para calcular el tiempo promedio que los carros pasan en el parqueadero
        return 0; // Placeholder
    }

    // 2.2 - carroConMayorTiempo()
    public Carro carroConMayorTiempo() {
        // Implementación para encontrar el carro que ha estado durante más horas en el parqueadero
        return null; // Placeholder
    }

    // 2.3 - hayCarroMasDeOchoHoras()
    public boolean hayCarroMasDeOchoHoras() {
        // Implementación para verificar si hay algún carro que lleva más de 8 horas parqueado
        return false; // Placeholder
    }

    // 2.4 - darCarrosMasDeTresHorasParqueados()
    public ArrayList<Carro> darCarrosMasDeTresHorasParqueados() {
        // Implementación para retornar todos los carros que llevan más de tres horas parqueados
        return new ArrayList<>(); // Placeholder
    }

    // 2.5 - hayCarrosPlacaIgual()
    public boolean hayCarrosPlacaIgual() {
        // Implementación para verificar si hay dos carros parqueados con la misma placa
        return false; // Placeholder
    }

    // 3.1 - contarCarrosQueComienzanConPlacaPB()
    public int contarCarrosQueComienzanConPlacaPB() {
        // Implementación para contar los carros parqueados cuya placa comienza por "PB"
        return 0; // Placeholder
    }

    // 3.2 - hayCarroCon24Horas()
    public boolean hayCarroCon24Horas() {
        // Implementación para verificar si hay algún carro que lleva 24 o más horas parqueado
        return false; // Placeholder
    }

    // 3.3 - metodo1()
    public String metodo1() {
        int cantidadPB = contarCarrosQueComienzanConPlacaPB();
        boolean hayCarro24Horas = hayCarroCon24Horas();
        return "Cantidad de carros con placa PB: " + cantidadPB + " - Hay carro parqueado por 24 o más horas: " + (hayCarro24Horas ? "Sí." : "No.");
    }

    // 3.4 - desocuparParqueadero()
    public int desocuparParqueadero() {
        int carrosSacados = 0;
        for (Puesto puesto : puestos) {
            if (puesto.getCarro() != null) {
                puesto.sacarCarro();
                carrosSacados++;
            }
        }
        return carrosSacados;
    }

    // 3.5 - metodo2()
    public String metodo2() {
        int carrosSacados = desocuparParqueadero();
        return "Cantidad de carros sacados: " + carrosSacados + ".";
    }
}
