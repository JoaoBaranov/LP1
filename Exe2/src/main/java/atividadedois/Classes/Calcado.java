package atividadedois.Classes;

public class Calcado {

    private String marca;
    private String modelo;
    private int tamanho;



    public Calcado(String marca, int tamanho, String modelo) {
        this.marca = marca;
        this.tamanho = tamanho;
        this.modelo = modelo;

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int idade) {
        this.tamanho = tamanho;
    }

    public String getModelo() {return modelo;}

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}

