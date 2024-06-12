public class Puesto {
    private int numero;
    private Carro carro;

    public Puesto(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public Carro getCarro() {
        return carro;
    }

    public void parquearCarro(Carro carro) {
        this.carro = carro;
    }

    public void sacarCarro() {
        this.carro = null;
    }

    public boolean estaOcupado() {
        return carro != null;
    }
}
