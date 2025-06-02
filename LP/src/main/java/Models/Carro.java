package Models;

public class Carro {

    private String nome;
    private String modelo;
    private int ano;
    private String marca;
    private int km;


    public Carro(String nome, String modelo, int ano, String marca, int km) {
        this.nome = nome;
        this.modelo = modelo;
        this.ano = ano;
        this.marca  = marca;
        this.km = km;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
}

