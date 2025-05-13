import java.time.LocalDateTime;

public class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String tipo; // Pode ser "pequeno", "grande" ou "moto"
    private LocalDateTime horaEntrada; // Hora de entrada no estacionamento

    public Veiculo(String placa, String marca, String modelo, String tipo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.horaEntrada = LocalDateTime.now(); // A hora atual como entrada
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

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }
}