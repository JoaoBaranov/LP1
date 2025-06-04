package atividadedois.Classes;

public class Carro {

    private String nome;
    private int ano;
    private String marca;



    public Carro(String nome, int ano, String marca) {
        this.nome = nome;
        this.ano = ano;
        this.marca  = marca;

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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}

