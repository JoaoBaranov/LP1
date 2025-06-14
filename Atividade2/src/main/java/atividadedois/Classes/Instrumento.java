package atividadedois.Classes;

public class Instrumento {

    private String nome;
    private String tipo;
    private String marca;
    private int id;



    public Instrumento() {
        this.nome = nome;
        this.marca = marca;
        this.tipo = tipo;
        this.id = id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {return tipo;}

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
