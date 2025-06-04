package atividadedois.Classes;

public class Cerveja {

    private String origem;
    private double teor;
    private String marca;



    public Cerveja(String origem, double teor, String marca) {
        this.origem = origem;
        this.teor = teor;
        this.marca  = marca;

    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public double getTeor() {
        return teor;
    }

    public void setTeor(double teor) {
        this.teor = teor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}

