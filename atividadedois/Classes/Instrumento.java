package atividadedois.Classes;

public class Instrumento {

    private String nome;
    private String tipo;
    private String marca;



    public Instrumento(String nome, String marca, String tipo) {
        this.nome = nome;
        this.marca = marca;
        this.tipo = tipo;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {return tipo;}

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
