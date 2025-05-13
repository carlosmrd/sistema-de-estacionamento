public class Estacionamento {
    private Vaga[] vagas;
    private String nome;

    public Estacionamento(String nome, int numeroDeVagas) {
        this.nome = nome;
        this.vagas = new Vaga[numeroDeVagas];

        for (int i = 0; i < numeroDeVagas; i++) {
            vagas[i] = new Vaga(i + 1); // Vaga numerada de 1 até 'numeroDeVagas'
        }
    }

    public String getNome() {
        return nome;
    }

    public void estacionar(Veiculo veiculo) {
        for (Vaga vaga : vagas) {
            if (vaga.estaLivre()) {
                vaga.ocuparVaga(veiculo);
                System.out.println("Veículo estacionado na vaga " + vaga.getNumeroVaga());
                return;
            }
        }
        System.out.println("Não há vagas disponíveis.");
    }

    public void liberarVaga(String placa) {
        for (Vaga vaga : vagas) {
            if (!vaga.estaLivre() && vaga.getVeiculo().getPlaca().equals(placa)) {
                vaga.liberarVaga();
                System.out.println("Veículo com placa " + placa + " saiu do estacionamento.");
            }
        }
        System.out.println("Veículo não encontrado.");
    }

    public void listarVagasLivres() {
        System.out.println("Vagas livres:");
        for (Vaga vaga : vagas) {
            if (vaga.estaLivre()) {
                System.out.println("Vaga " + vaga.getNumeroVaga());
            }
        }
    }

    public void listarVagasOcupadas() {
        System.out.println("Vagas ocupadas:");
        for (Vaga vaga : vagas) {
            if (!vaga.estaLivre()) {
                Veiculo veiculo = vaga.getVeiculo(); // Obtém o veículo na vaga
                System.out.println("Vaga " + vaga.getNumeroVaga() + " - Placa: " + veiculo.getPlaca()
                        + ", Marca: " + veiculo.getMarca()
                        + ", Modelo: " + veiculo.getModelo());
            }
        }
    }

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
