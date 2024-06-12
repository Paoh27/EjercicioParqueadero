import java.time.LocalTime;

public class Carro {
    private String placa;
    private LocalTime horaEntrada;

    public Carro(String placa, LocalTime horaEntrada) {
        this.placa = placa;
        this.horaEntrada = horaEntrada;
    }

    public String getPlaca() {
        return placa;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }
}
