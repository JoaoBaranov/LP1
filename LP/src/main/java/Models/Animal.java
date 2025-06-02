package Models;

public class Animal {

    private String nome;
    private String especie;
    private int idade;
    private String porte;


    public Animal(String nome, int idade, String especie, String porte) {
        this.nome = nome;
        this.idade = idade;
        this.especie = especie;
        this.porte = porte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }
}
