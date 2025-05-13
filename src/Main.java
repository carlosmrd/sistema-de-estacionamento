import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Estacionamento de 20 vagas
        Estacionamento estacionamento = new Estacionamento("Estacionamento da Faculdade", 20);

        Scanner scanner = new Scanner(System.in);

        String placa;

        System.out.println("Bem-vindo ao " + estacionamento.getNome());

        while (true) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Estacionar um veículo");
            System.out.println("2. Liberar um veículo");
            System.out.println("3. Consultar vagas livres");
            System.out.println("4. Consultar vagas ocupadas");
            System.out.println("5. Consultar o total de veículos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite a placa do veículo: ");
                    placa = scanner.nextLine();
                    System.out.print("Digite a marca do veículo: ");
                    String marca = scanner.nextLine();
                    System.out.print("Digite o modelo do veículo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Digite o tipo (pequeno, grande, moto): ");
                    String tipo = scanner.nextLine();

                    Veiculo veiculo = new Veiculo(placa, marca, modelo, tipo);
                    estacionamento.estacionar(veiculo);
                    break;

                case 2:
                    System.out.print("Digite a placa do veículo a ser removido: ");
                    placa = scanner.nextLine();
                    estacionamento.liberarVaga(placa);
                    break;

                case 3:
                    estacionamento.listarVagasLivres();
                    break;

                case 4:
                    estacionamento.listarVagasOcupadas();
                    break;

                case 5:
                    int total = estacionamento.totalDeVeiculos();
                    System.out.println("Total de veículos no estacionamento: " + total);
                    break;

                case 6:
                    System.out.println("Encerrando.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}