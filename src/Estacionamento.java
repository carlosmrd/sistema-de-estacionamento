// Arquivo: Estacionamento.java
public class Estacionamento {
    private Vaga[] vagas;
    private String nome;

    // Construtor
    public Estacionamento(String nome, int numeroDeVagas) {
        this.nome = nome;
        this.vagas = new Vaga[numeroDeVagas];

        // Inicializa as vagas no estacionamento
        for (int i = 0; i < numeroDeVagas; i++) {
            vagas[i] = new Vaga(i + 1); // Vaga numerada de 1 até 'numeroDeVagas'
        }
    }

    // Estacionar um veículo em uma vaga
    public boolean estacionar(Veiculo veiculo) {
        for (Vaga vaga : vagas) {
            if (vaga.estaLivre()) {
                vaga.ocuparVaga(veiculo);
                System.out.println("Veículo estacionado na vaga " + vaga.getNumeroVaga());
                return true;
            }
        }
        System.out.println("Não há vagas disponíveis.");
        return false; // Caso não haja vagas livres
    }

    // Liberar uma vaga com base na placa do veículo
    public boolean liberarVaga(String placa) {
        for (Vaga vaga : vagas) {
            if (!vaga.estaLivre() && vaga.getVeiculo().getPlaca().equals(placa)) {
                Veiculo veiculoRemovido = vaga.liberarVaga();
                System.out.println("Veículo com placa " + placa + " saiu do estacionamento.");
                return true;
            }
        }
        System.out.println("Veículo não encontrado.");
        return false;
    }

    // Consultar vagas livres
    public void listarVagasLivres() {
        System.out.println("Vagas livres:");
        for (Vaga vaga : vagas) {
            if (vaga.estaLivre()) {
                System.out.println("Vaga " + vaga.getNumeroVaga());
            }
        }
    }

    // Consultar vagas ocupadas
    public void listarVagasOcupadas() {
        System.out.println("Vagas ocupadas:");
        for (Vaga vaga : vagas) {
            if (!vaga.estaLivre()) {
                System.out.println("Vaga " + vaga.getNumeroVaga() + " - Veículo: " + vaga.getVeiculo().getPlaca());
            }
        }
    }

    // Consultar total de carros no estacionamento
    public int totalDeVeiculos() {
        int count = 0;
        for (Vaga vaga : vagas) {
            if (!vaga.estaLivre()) {
                count++;
            }
        }
        return count;
    }
}
