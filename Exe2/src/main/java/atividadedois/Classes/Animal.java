package atividadedois.Classes;

public class Animal{

    private String nome;
    private String especie;
    private int idade;
    private int id;



    public Animal() {
        this.nome = nome;
        this.idade = idade;
        this.especie = especie;
        this.id = id;

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

    public void setIdade(int idade) {this.idade = idade;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }


}
