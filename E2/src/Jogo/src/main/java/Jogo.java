public class Jogo {
    private String nome;
    private String genero;
    private String plataforma;
    private int ano;

    public Jogo(String nome, String genero, String plataforma, int ano) {
        this.nome = nome;
        this.genero = genero;
        this.plataforma = plataforma;
        this.ano = ano;
    }

    public String getDescricao() {
        return "Nome: " + nome + "\nGênero: " + genero + "\nPlataforma: " + plataforma + "\nAno: " + ano;
    }

    public void atualizarPlataforma(String novaPlataforma) {
        this.plataforma = novaPlataforma;
    }

    public void atualizarAno(int novoAno) {
        this.ano = novoAno;
    }
}

