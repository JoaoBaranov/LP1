package atividadedois.Classes;

public class Calcado {

    private String marca;
    private String modelo;
    private int tamanho;
    private int id;



    public Calcado() {
        this.marca = marca;
        this.tamanho = tamanho;
        this.modelo = modelo;
        this.id = id;

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

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {return modelo;}

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}

