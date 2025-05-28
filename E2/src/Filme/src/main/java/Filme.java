public class Filme {
    private String titulo;
    private String diretor;
    private int anoLancamento;
    private String genero;

    public Filme(String titulo, String diretor, int anoLancamento, String genero) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
    }

    public String getDescricao() {
        return "Título: " + titulo + "\nDiretor: " + diretor + "\nAno: " + anoLancamento + "\nGênero: " + genero;
    }

    public void atualizarAno(int novoAno) {
        this.anoLancamento = novoAno;
    }

    public void atualizarGenero(String novoGenero) {
        this.genero = novoGenero;
    }
}
