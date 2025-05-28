public class InstrumentoMusical {
    private String nome;
    private String tipo;
    private String marca;
    private int anoFabricacao;

    public InstrumentoMusical(String nome, String tipo, String marca, int anoFabricacao) {
        this.nome = nome;
        this.tipo = tipo;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
    }

    public String getDescricao() {
        return "Nome: " + nome + "\nTipo: " + tipo + "\nMarca: " + marca + "\nAno de Fabricação: " + anoFabricacao;
    }

    public void atualizarTipo(String novoTipo) {
        this.tipo = novoTipo;
    }

    public void atualizarAno(int novoAno) {
        this.anoFabricacao = novoAno;
    }
}
