import java.util.ArrayList;
import java.util.HashMap;

public class Parqueadero {
    private ArrayList<Puesto> puestos;
    private double tarifaHora;
    private HashMap<String, Carro> carros;

    public Parqueadero(double tarifaHora) {
        this.tarifaHora = tarifaHora;
        this.puestos = new ArrayList<>();
        this.carros = new HashMap<>();
        for (int i = 1; i <= 40; i++) {
            puestos.add(new Puesto(i));
        }
    }

    public void ingresarCarro(Carro carro) {
        for (Puesto puesto : puestos) {
            if (puesto.getCarro() == null) {
                puesto.setCarro(carro);
                carros.put(carro.getPlaca(), carro);
                break;
            }
        }
    }

    public void darSalidaCarro(String placa) {
        for (Puesto puesto : puestos) {
            Carro carro = puesto.getCarro();
            if (carro != null && carro.getPlaca().equals(placa)) {
                puesto.setCarro(null);
                carros.remove(placa);
                break;
            }
        }
    }

    public double darIngresos() {
        // Implementar lógica para calcular ingresos
        return 0.0;
    }

    public int consultarPuestosDisponibles() {
        int disponibles = 0;
        for (Puesto puesto : puestos) {
            if (puesto.getCarro() == null) {
                disponibles++;
            }
        }
        return disponibles;
    }

    public void avanzarRelojParqueadero() {
        // Implementar lógica para avanzar el reloj del parqueadero
    }

    public void cambiarTarifa(double nuevaTarifa) {
        this.tarifaHora = nuevaTarifa;
    }

    public double darTiempoPromedio() {
        // Implementar lógica para calcular tiempo promedio
        return 0.0;
    }

    public Carro darCarroMasHoras() {
        // Implementar lógica para encontrar carro con más horas
        return null;
    }

    public boolean hayCarroMasDeOchoHoras() {
        // Implementar lógica para verificar si hay carro más de 8 horas
        return false;
    }

    public ArrayList<Carro> darCarrosMasDeTresHorasParqueados() {
        ArrayList<Carro> carrosMasDeTresHoras = new ArrayList<>();
        // Implementar lógica para encontrar carros más de tres horas
        return carrosMasDeTresHoras;
    }

    public boolean hayCarrosPlacaIgual() {
        // Implementar lógica para verificar si hay carros con misma placa
        return false;
    }

    public int contarCarrosQueComienzanConPlacaPB() {
        int contador = 0;
        // Implementar lógica para contar carros con placa que empiece con PB
        return contador;
    }

    public boolean hayCarroCon24Horas() {
        // Implementar lógica para verificar si hay carro con 24 horas o más
        return false;
    }

    public String metodo1() {
        // Implementar lógica para retornar mensaje solicitado en 3.3
        return "";
    }

    public int desocuparParqueadero() {
        int cantidadSacada = 0;
        // Implementar lógica para sacar todos los carros
        return cantidadSacada;
    }

    public String metodo2() {
        // Implementar lógica para retornar mensaje solicitado en 3.5
        return "";
    }
}
