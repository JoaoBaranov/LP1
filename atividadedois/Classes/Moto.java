package atividadedois.Classes;

public class Moto {

    private String nome;
    private String marca;
    private int cilindrada;



    public Moto(String nome, int cilindrada, String marca) {
        this.nome = nome;
        this.marca = marca;
        this.cilindrada = cilindrada;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCilindrada() {return cilindrada;}

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


}

