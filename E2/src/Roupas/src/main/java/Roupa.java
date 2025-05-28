public class Roupa {
    private String tipo;
    private String tamanho;
    private String cor;
    private String marca;

    public Roupa(String tipo, String tamanho, String cor, String marca) {
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.cor = cor;
        this.marca = marca;
    }

    public String getDescricao() {
        return "Tipo: " + tipo + "\nTamanho: " + tamanho + "\nCor: " + cor + "\nMarca: " + marca;
    }

    public void atualizarCor(String novaCor) {
        this.cor = novaCor;
    }

    public void atualizarTamanho(String novoTamanho) {
        this.tamanho = novoTamanho;
    }
}
