public class Veiculo {

    private String placa;
    private String marca;
    private String modelo;
    //tipo pode ser "pequeno", "grande", ou "moto".
    private String tipo;

    public Veiculo(String placa, String marca, String modelo, String tipo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo.toLowerCase();
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipo() {
        return tipo;
    }
}