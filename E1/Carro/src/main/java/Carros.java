public class Carros {
    private String modelo;
    private String cor;
    private int ano;

    // Construtor
    public Carros(String modelo, String cor, int ano) {
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
    }

    // Método para exibir os dados do carro
    public String mostrarDados() {
        return "Modelo: " + modelo + "\nCor: " + cor + "\nAno: " + ano;
    }

    // Método para calcular a idade do carro
    public int calcularIdade(int anoAtual) {
        return anoAtual - this.ano;
    }

    // Método para atualizar a cor do carro
    public void atualizarCor(String novaCor) {
        this.cor = novaCor;
    }
}
