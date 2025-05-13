import java.time.LocalDateTime;

public class Vaga {

    private Veiculo veiculo;
    private LocalDateTime horarioEntrada;
    private int numeroVaga;

    public Vaga(int numeroVaga) {
        this.numeroVaga = numeroVaga;
        this.veiculo = null;
        this.horarioEntrada = null;
    }

    public boolean ocuparVaga(Veiculo veiculo) {
        if (this.veiculo != null) {
            return false; // já está ocupada
        }
        this.veiculo = veiculo;
        this.horarioEntrada = LocalDateTime.now();
        return true;
    }

    public Veiculo liberarVaga() {
        Veiculo veiculoRemovido = this.veiculo;
        this.veiculo = null;
        this.horarioEntrada = null;
        return veiculoRemovido;
    }

    public int getNumeroVaga() {
        return numeroVaga;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDateTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public boolean estaLivre() {
        return veiculo == null;
    }
}