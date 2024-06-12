import java.time.LocalTime;
import java.util.ArrayList;

public class Parqueadero {
    private static final int NUM_PUESTOS = 40;
    private Puesto[] puestos;
    private double tarifa;
    private LocalTime reloj;
    private double ingresos;

    public Parqueadero(double tarifaInicial) {
        this.puestos = new Puesto[NUM_PUESTOS];
        for (int i = 0; i < NUM_PUESTOS; i++) {
            puestos[i] = new Puesto(i + 1);
        }
        this.tarifa = tarifaInicial;
        this.reloj = LocalTime.of(6, 0);
        this.ingresos = 0;
    }

    public void ingresarCarro(Carro carro) {
        for (Puesto puesto : puestos) {
            if (!puesto.estaOcupado()) {
                puesto.setCarro(carro);
                return;
            }
        }
        System.out.println("No hay puestos disponibles.");
    }

    public void darSalidaCarro(String placa) {
        for (Puesto puesto : puestos) {
            if (puesto.estaOcupado() && puesto.getCarro().getPlaca().equals(placa)) {
                LocalTime horaEntrada = puesto.getCarro().getHoraEntrada();
                long horasParqueado = java.time.Duration.between(horaEntrada, reloj).toHours() + 1;
                ingresos += horasParqueado * tarifa;
                puesto.desocupar();
                return;
            }
        }
        System.out.println("Carro no encontrado.");
    }

    public double darIngresos() {
        return ingresos;
    }

    public int puestosDisponibles() {
        int disponibles = 0;
        for (Puesto puesto : puestos) {
            if (!puesto.estaOcupado()) {
                disponibles += 1;
            }
        }
        return disponibles;
    }

    public void avanzarReloj(int horas) {
        reloj = reloj.plusHours(horas);
    }

    public void cambiarTarifa(double nuevaTarifa) {
        tarifa = nuevaTarifa;
    }

    public double darTiempoPromedio() {
        int carros = 0;
        long totalHoras = 0;
        for (Puesto puesto : puestos) {
            if (puesto.estaOcupado()) {
                carros++;
                totalHoras += java.time.Duration.between(puesto.getCarro().getHoraEntrada(), reloj).toHours();
            }
        }
        return carros > 0 ? (double) totalHoras / carros : 0.0;
    }

    public Carro carroConMasHoras() {
        Carro carroMayor = null;
        long maxHoras = -1;
        for (Puesto puesto : puestos) {
            if (puesto.estaOcupado()) {
                long horas = java.time.Duration.between(puesto.getCarro().getHoraEntrada(), reloj).toHours();
                if (horas > maxHoras) {
                    maxHoras = horas;
                    carroMayor = puesto.getCarro();
                }
            }
        }
        return carroMayor;
    }

    public boolean hayCarroMasDeOchoHoras() {
        for (Puesto puesto : puestos) {
            if (puesto.estaOcupado()) {
                long horas = java.time.Duration.between(puesto.getCarro().getHoraEntrada(), reloj).toHours();
                if (horas > 8) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Carro> darCarrosMasDeTresHorasParqueados() {
        ArrayList<Carro> carros = new ArrayList<>();
        for (Puesto puesto : puestos) {
            if (puesto.estaOcupado()) {
                long horas = java.time.Duration.between(puesto.getCarro().getHoraEntrada(), reloj).toHours();
                if (horas > 3) {
                    carros.add(puesto.getCarro());
                }
            }
        }
        return carros;
    }

    public boolean hayCarrosPlacaIgual() {
        ArrayList<String> placas = new ArrayList<>();
        for (Puesto puesto : puestos) {
            if (puesto.estaOcupado()) {
                String placa = puesto.getCarro().getPlaca();
                if (placas.contains(placa)) {
                    return true;
                }
                placas.add(placa);
            }
        }
        return false;
    }

    public int contarCarrosQueComienzanConPlacaPB() {
        int count = 0;
        for (Puesto puesto : puestos) {
            if (puesto.estaOcupado() && puesto.getCarro().getPlaca().startsWith("PB")) {
                count++;
            }
        }
        return count;
    }

    public boolean hayCarroCon24Horas() {
        for (Puesto puesto : puestos) {
            if (puesto.estaOcupado()) {
                long horas = java.time.Duration.between(puesto.getCarro().getHoraEntrada(), reloj).toHours();
                if (horas >= 24) {
                    return true;
                }
            }
        }
        return false;
    }

    public String metodo1() {
        int countPB = contarCarrosQueComienzanConPlacaPB();
        boolean carro24Horas = hayCarroCon24Horas();
        return "Cantidad de carros con placa PB: " + countPB + " – Hay carro parqueado por 24 o más horas: " + (carro24Horas ? "Sí" : "No");
    }

    public int desocuparParqueadero() {
        int carrosSacados = 0;
        for (Puesto puesto : puestos) {
            if (puesto.estaOcupado()) {
                puesto.desocupar();
                carrosSacados++;
            }
        }
        return carrosSacados;
    }

    public String metodo2() {
        int carrosSacados = desocuparParqueadero();
        return "Cantidad de carros sacados: " + carrosSacados;
    }
}
