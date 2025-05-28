public class Cerveja {
    private String nome;
    private String tipo;
    private double teorAlcoolico;
    private String paisOrigem;
    private boolean aberta = false;

    public Cerveja(String nome, String tipo, double teorAlcoolico, String paisOrigem) {
        this.nome = nome;
        this.tipo = tipo;
        this.teorAlcoolico = teorAlcoolico;
        this.paisOrigem = paisOrigem;
    }

    public String getDescricao() {
        return "🍺 Nome: " + nome +
                "\nTipo: " + tipo +
                "\nTeor Alcoólico: " + teorAlcoolico + "%" +
                "\nPaís de Origem: " + paisOrigem +
                "\nStatus: " + (aberta ? "Aberta (já foi bebida)" : "Fechada");
    }

    public void atualizarTeorAlcoolico(double novoTeor) {
        this.teorAlcoolico = novoTeor;
    }

    public void atualizarPais(String novoPais) {
        this.paisOrigem = novoPais;
    }

    public String beber() {
        if (aberta) {
            return "Você já bebeu essa cerveja!";
        } else {
            aberta = true;
            return "HUMMM... Você bebeu a cerveja! 🍻";
        }
    }
}
