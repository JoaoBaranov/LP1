package atividadedois.Classes;

public class Filme {

    private String nome;
    private String genero;
    private int ano;
    private int id;



    public Filme() {
        this.nome = nome;
        this.ano = ano;
        this.genero = genero;
        this.id = id;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenero() {return genero;}

    public void setGenero(String genero) {
        this.genero = genero;
    }

}

