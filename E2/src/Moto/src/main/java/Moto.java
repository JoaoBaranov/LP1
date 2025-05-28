public class Moto {
    private String modelo;
    private String marca;
    private int cilindrada;
    private int ano;

    public Moto(String modelo, String marca, int cilindrada, int ano) {
        this.modelo = modelo;
        this.marca = marca;
        this.cilindrada = cilindrada;
        this.ano = ano;
    }

    public String getDescricao() {
        return "Modelo: " + modelo + "\nMarca: " + marca + "\nCilindrada: " + cilindrada + "cc\nAno: " + ano;
    }

    public void atualizarCilindrada(int novaCilindrada) {
        this.cilindrada = novaCilindrada;
    }

    public void atualizarAno(int novoAno) {
        this.ano = novoAno;
    }
}
