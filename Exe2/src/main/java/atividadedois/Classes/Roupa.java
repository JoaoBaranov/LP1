package atividadedois.Classes;

public class Roupa {

    private String tipo;
    private String cor;
    private int tamanho;



    public Roupa(String tipo, int tamanho, String cor) {
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.cor = cor;

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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }


}

