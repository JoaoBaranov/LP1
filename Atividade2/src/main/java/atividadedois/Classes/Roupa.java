package atividadedois.Classes;

public class Roupa {

    private String tipo;
    private String cor;
    private int tamanho;
    private int id;



    public Roupa() {
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.cor = cor;
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTamanho() {return tamanho;}

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }


}

