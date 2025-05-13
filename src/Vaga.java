import java.time.Duration;
import java.time.LocalDateTime;

public class Vaga {
    private Veiculo veiculo;
    private int numeroVaga;

    public Vaga(int numeroVaga) {
        this.numeroVaga = numeroVaga;
        this.veiculo = null; // Inicialmente a vaga está livre
    }

    public int getNumeroVaga() {
        return numeroVaga;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public boolean estaLivre() {
        return veiculo == null;
    }

    public void ocuparVaga(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void liberarVaga() {
        Veiculo veiculoRemovido = veiculo;
        double valorAPagar = calcularValorAPagar(veiculoRemovido);
        System.out.println("Valor a ser pago pelo veículo " + veiculoRemovido.getPlaca() + ": R$" + valorAPagar);
        this.veiculo = null;
    }

    private double calcularValorAPagar(Veiculo veiculo) {
        Duration duration = Duration.between(veiculo.getHoraEntrada(), LocalDateTime.now());
        long horas = Math.max(1, duration.toHours());

        double tarifaPorHora = 0.0;

        switch (veiculo.getTipo()) {
            case "pequeno":
                tarifaPorHora = 16.0; // Carro pequeno
                break;
            case "grande":
                tarifaPorHora = 25.0; // Carro grande
                break;
            case "moto":
                tarifaPorHora = 8.0;  // Moto
                break;
            default:
                System.out.println("Tipo de veículo inválido.");
                break;
        }

        return tarifaPorHora * horas;
    }
}