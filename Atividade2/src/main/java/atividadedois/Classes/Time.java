package atividadedois.Classes;

public class Time {
    private String nome;
    private String pais;
    private int titulos;



    public Time(String nome, int titulos, String pais) {
        this.nome = nome;
        this.pais = pais;
        this.titulos = titulos;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTitulos() {return titulos;}

    public void setTitulos(int titulos) {
        this.titulos = titulos;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


}

